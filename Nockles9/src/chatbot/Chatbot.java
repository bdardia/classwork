package chatbot;

public class Chatbot 
{
	private String username;
	private boolean chatting;
	private Topic ben;
	
	public Chatbot()
	{
		ben = new ChatbotBen();
		username = "Unknown User";
		chatting = true;
	}

	public void startChatting() 
	{
		ChatbotMain.print("I am a pizza chatbot. What's your name?");
		username = ChatbotMain.getInput();
		
		while(chatting)
		{
			ChatbotMain.print("What's your pizza question?");
			String response = ChatbotMain.getInput();
			
			if (ben.isTriggered(response))
			{
				chatting = false;
			}
		}
	}
}
