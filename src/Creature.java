

public class Creature
{
	String name ;
	int hydrationMeter ;
	int satiationMeter ;
	int happinessMeter ;
	int funMeter ;
	
	int urine ;
	int feces ;
	
	boolean lives = true ;
	
	public Creature( String name )
	{
		this.name = name ;
		this.hydrationMeter = 100 ;
		this.satiationMeter = 100 ;
		this.happinessMeter = 100 ;
		this.funMeter = 100 ;
		
		this.urine = 0 ;
		this.feces   = 0  ;		
	}
	
	public String returnName()
	{
		return this.name ;
	}
	
	public boolean isAlive()
	{	
		return lives ;
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
	
	public int countFun()
	{
		return funMeter ;
	}
	
	public String giveStatus()
	{
		int overdose = 150 ;
		
		String firstOutput = "", secondOutput = "";
		
		int firstMinimum, secondMinimum ;
		
		int okayCounter = 0 ;
		
		int distA=50, distB=50 ;
		
		boolean foodMuch  = false,
				foodFew   = false,
				drinkMuch = false,
				drinkFew  = false ;
		
		if( satiationMeter > 100 )
		{
			if( overdose - satiationMeter < hydrationMeter )
			{
				foodMuch = true ;
				distA = overdose - satiationMeter ;
			}
			else
			{
				drinkFew = true ;
				distA = hydrationMeter ;
			}
		}
		
		if( hydrationMeter > 100 )
		{
			if( overdose - hydrationMeter < satiationMeter )
			{
				drinkMuch = true ;
				distB = overdose - hydrationMeter ;
			}
			else
			{
				foodFew = true ;
				distB = satiationMeter ;
			}
		}
		
		String biggestNeed = "" ;
		
		if( distA < distB )
		{
			if(foodMuch) biggestNeed = "overeating" ;
			
			else if(drinkFew) biggestNeed = "underdrinking";
		}
		else
		{
			if(drinkMuch) biggestNeed = "overdrinking";
			
			else if(foodFew) biggestNeed = "undereating" ;
		}
		
		if( biggestNeed == "overdrinking" || biggestNeed == "underdrinking" ) // overeating death remains undetected; improve prerequisite overlaps
		{
			firstMinimum = hydrationMeter ;
			
			if( hydrationMeter <= 0 ) return this.name + " died of thirst." ;
			else if( hydrationMeter <=20 ) firstOutput = this.name+ " is very thirsty";
			else if( hydrationMeter <=50 ) firstOutput = this.name+ " is thirsty";
			else if( hydrationMeter <=80 ) firstOutput = this.name+ " is slightly thirsty";
			else if( hydrationMeter >=overdose )
			{
				lives = false ;
				return this.name+ " died from overhydration.";
			}
			else if( hydrationMeter >=overdose-40 ) firstOutput = this.name+ " drank too much.";
			else okayCounter++ ;
		}
		else
		{
			firstMinimum = satiationMeter ;
			
			if( satiationMeter <= 0 )
			{
				lives = false ;
				return this.name + " died of hunger." ;
			}
			else if( satiationMeter <=10 ) firstOutput = this.name+ " is very hungry";
			else if( satiationMeter <=60 ) firstOutput = this.name+ " is hungry";
			else if( satiationMeter <=85 ) firstOutput = this.name+ " is slightly hungry";
			else if( satiationMeter >=overdose )
			{
				lives = false ;
				return this.name+ " died from overfeeding.";
			}
			else if( satiationMeter >=overdose-40 ) firstOutput = this.name+ " ate too much.";
			else okayCounter++ ;
		}
		
		
		if(urine>feces)
		{
		     if( urine >= 100 )
		     {
		    	 lives = false ;
		    	 return this.name + "'s bladder exploded." ;
		     }
				else if( urine >= 90  ) secondOutput = "needs to pee REALLY bad!";
				else if( urine >= 40  ) secondOutput = "needs to pee.";
				else if( urine >= 20  ) secondOutput = "needs to pee a little bit.";
				else okayCounter++ ;
		}
		else
		{
			if( feces >= 100 )
			{
				lives = false ;
				return this.name + "'s butt exploded." ;
			}
			else if( feces >= 85  ) secondOutput = "needs to poo REALLY bad!";
			else if( feces >= 45  ) secondOutput = "needs to poo.";
			else if( feces >= 25  ) secondOutput = "needs to poo a little bit.";
			else okayCounter++ ;
		}
		
		String output = "" ;
		     
		if( okayCounter == 2 ) output = "All is okay with " + this.name + "." ;
		
		if( firstOutput == "" )
		{
			if( secondOutput == "" )
			{
				output = "All is okay with " + this.name + "." ;
			}
			else output = this.name+' '+secondOutput ;
		}
		else
		{
			if( secondOutput == "" )
			{
				output = firstOutput +'.';
			}
			else
			{
				output = firstOutput + " and " + secondOutput ;
			}
		}
		
		
		return output ;
	}
	
	public void dayPasses()
	{
		if( lives )
		{
			this.hydrationMeter -= 15 ;
			this.satiationMeter -= 5 ;
			this.funMeter -= 20 ;
		}
		updateHappiness();
	}
	
	public void updateHappiness()
	{
		if(!lives)
		{
			happinessMeter = 0 ;
			return ;
		}
		
		int m = Math.min(hydrationMeter,satiationMeter) ;
		int e = Math.min(100-urine,100-feces) ;
		
		happinessMeter = Math.min(m,e) ;
		
		happinessMeter = Math.min(happinessMeter,funMeter);
	}
	
	public void play( int funQuantity )
	{
		this.funMeter = Math.min(100,funMeter+funQuantity);
	}
	
	public void getFed( int foodQuantity )
	{
		this.satiationMeter = Math.min(150,this.satiationMeter+foodQuantity) ;
		
		if(this.satiationMeter>50) this.feces = Math.min(150,this.feces+foodQuantity/2) ;
		
		updateHappiness();
	}
	
	public void getWatered( int drinkQuantity )
	{
		this.hydrationMeter = Math.min(150,this.hydrationMeter+drinkQuantity) ;
		if(hydrationMeter>50) this.urine = Math.min(150,this.urine+drinkQuantity/2) ;
		
		updateHappiness();
	}
	
	public void purgeGuts()
	{
		this.urine = 0 ;
		this.feces = 0 ;
		
		updateHappiness();
	}

}
