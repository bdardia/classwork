package arrays;

public class Person {

	public static final String[] FIRST_START = {"Chr","Am","L","D","Th","Br","B"};
	public static final String[] FIRST_MIDDLE = {"ala","ima","e","o","anna","ola","a"};
	public static final String[] FIRST_END = {"na","ck","n","tt","rian","lius","lion","les"};

	
	public static final String[] LAST_START = {"Bl","Gr","Ph","M","Thr","Sh","Br"};
	public static final String[] LAST_MIDDLE = {"an","in","ast","own","il"};
	public static final String[] LAST_END = {"strom","son","rack","les","vin","ston"};

	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	private String nickname;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		this.friends = new Person[3];
		this.hobby = Hobby.randomHobby();
		this.nickname = createNickname(this.firstName);
	}
	
	public String toString() {
		return "My name is "+firstName+" "+
				lastName+ ". You can call me " + this.nickname + ", and I am from "+home+".";
	}
	
	public void setInFirstPlace(Person f)
	{
		for (int i = friends.length - 1; i > 0; i -= 1)
		{
			friends[i] = friends[i - 1];
		}
		friends[0] = f;
	}
	
	public void mingle(Person[] peers)
	{
		for (Person p: peers)
		{
			if (p != this)
			{
				setInFirstPlace(p);
			}
		}
	}
	
	public void stateYourFriends()
	{
		String friendsList = "";
		for (int i = 0; i < friends.length; i += 1)
		{
			if (i != (friends.length - 1))
			{
				friendsList += friends[i].firstName + " " + friends[i].lastName + ", ";
			}
			else
			{
				friendsList += "and " + friends[i].firstName + " " + friends[i].lastName;
			}
		}
		System.out.println("My friends are " + friendsList + ".");
	}
	
	public static String createNickname(String name)
	{
		String[] vowels = {"a", "e", "i", "o", "u"};
		int numVowels = 0;
		String nickname = name;
		
		for (int i = 0; i < name.length(); i += 1)
		{
			for (int o = 0; o < vowels.length; o += 1)
			{
				if (name.substring(i, i + 1).toLowerCase().equals(vowels[o]))
				{
					numVowels += 1;
				}
			}
			
			if (numVowels == 2)
			{
				return (nickname.substring(0, i));
			}
		}
		return nickname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}