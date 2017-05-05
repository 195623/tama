

public class Creature
{
	String name ;
	int hydrationMeter ;
	int satiationMeter ;
	int happinessMeter ;
	
	int urine ;
	int feces ; 
	
	public Creature( String name )
	{
		this.name = name ;
		this.hydrationMeter = 100 ;
		this.satiationMeter = 100 ;
		this.happinessMeter = 100 ;
		
		this.urine = 0 ;
		this.feces   = 0  ;		
	}
	
	public String returnName()
	{
		return this.name ;
	}
	
	public boolean isAlive()
	{
		if( hydrationMeter <= 0 || satiationMeter <= 0 ) return false ;

		return true ;
	}

	public int countFeces()
	{
		return this.feces ;
	}
	
	public int countUrine()
	{
		return this.urine;
	}
	
	public int countSatiation()
	{
		return this.satiationMeter;
	}
	
	public int countHydration()
	{
		return this.hydrationMeter;
	}
	
	public int countHappiness()
	{
		return this.happinessMeter;
	}
	
	public String giveStatus()
	{
		String output = "";
		
		int okayCounter = 0 ;
		
		if( hydrationMeter <= 0 ) return this.name + " died of thirst." ;
		else if( hydrationMeter <=20 ) output = this.name+ " is very thirsty.";
		else if( hydrationMeter <=50 ) output = this.name+ " is thirsty.";
		else if( hydrationMeter <=80 ) output = this.name+ " is slightly thirsty.";
		else okayCounter++ ;
		
		if( satiationMeter <= 0 ) return this.name + " died of hunger." ;
		else if( satiationMeter <=10 ) output = this.name+ " is very hungry.";
		else if( satiationMeter <=60 ) output = this.name+ " is hungry.";
		else if( satiationMeter <=85 ) output = this.name+ " is slightly hungry.";
		else okayCounter++ ;
		
		     if( urine >= 100 ) return this.name + "'s bladder exploded." ;
		else if( urine >= 90  ) output = this.name+ " needs to pee REALLY bad!";
		else if( urine >= 40  ) output = this.name+ " needs to pee.";
		else if( urine >= 20  ) output = this.name+ " needs to pee a little bit.";
		else okayCounter++ ;
		     
		     if( feces >= 100 ) return this.name + "'s butt exploded." ;
		else if( feces >= 85  ) output = this.name+ " needs to poo REALLY bad!";
		else if( feces >= 45  ) output = this.name+ " needs to poo.";
		else if( feces >= 25  ) output = this.name+ " needs to poo a little bit.";
		else okayCounter++ ;
		     
		if( okayCounter == 4 ) output = "All is okay with " + this.name + "." ;
		
		return output ;
	}
	
	public void dayPasses()
	{
		this.hydrationMeter -= 15 ;
		this.satiationMeter -= 5 ;
		
		updateHappiness();
	}
	
	public void updateHappiness()
	{
		int m = Math.min(hydrationMeter,satiationMeter) ;
		int e = Math.min(100-urine,100-feces) ;
		
		happinessMeter = Math.min(m,e) ;		
	}
	
	public void getFed( int foodQuantity )
	{
		this.satiationMeter = Math.min(100,this.satiationMeter+foodQuantity) ;
		
		if(this.satiationMeter>50) this.feces = Math.min(100,this.feces+foodQuantity/2) ;
		
		updateHappiness();
	}
	
	public void getWatered( int drinkQuantity )
	{
		this.hydrationMeter = Math.min(100,this.hydrationMeter+drinkQuantity) ;
		if(hydrationMeter>50) this.urine = Math.min(100,this.urine+drinkQuantity/2) ;
		
		updateHappiness();
	}
	
	public void purgeGuts()
	{
		this.urine = 0 ;
		this.feces = 0 ;
		
		updateHappiness();
	}

}
