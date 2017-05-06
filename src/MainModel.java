
public class MainModel
{
	int day = 1 ;
	Creature pet = new Creature("Newmann") ;
	View view = new View();
	
	void nextDay()
	{
		day++ ;
	}
	
	int returnDay()
	{
		return day ;
	}
	
	Creature returnPet()
	{
		return pet ;
	}
}
