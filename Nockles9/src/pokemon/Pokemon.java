package pokemon;

public class Pokemon 
{
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public Pokemon(String name, int level)
	{
		this.name = name;
		this.level = level;
		this.hp = 100;
		this.poisoned = false;
	}
	
	public void iChooseYou()
	{
		System.out.println(this.name);
		System.out.println(this.name);
	}
	
	public int getHP()
	{
		return this.hp;
	}
	
	public void setHP(int hp)
	{
		this.hp = hp;
	}
	
	public void setPoisoned(boolean poisoned)
	{
		this.poisoned = poisoned;
	}
	
	public void lapse()
	{
		if (this.poisoned)
		{
			this.hp -= 15;
		}
	}
	
	public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
		 attack.attack(target);
		 System.out.println("The attack hit");
		 }else{
		 System.out.println("The attack missed");
		 }
		 }
	
	public void levelUp(Effect e)
	{
		level += 1;
		e.happen();
	}
}
