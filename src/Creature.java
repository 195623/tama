




// Model

public class Creature
{
	String name ;
	int hydrationMeter ;
	int satiationMeter ;
	int happinessMeter ;
	int funMeter ;
	
	int overdose = 150 ;
	
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
	
	public String giveNeeds()
	{
		String txt = "" ;
		txt += "HAPPINESS: " + happinessMeter + " :: " ;
		txt += "Satiation: " + satiationMeter + ", " ;
		txt += "Hydration: " + hydrationMeter + ", " ;
		txt += "Fun: " + funMeter + ", " ;
		txt += "feces: " + feces + ", " ;
		txt += "urine: " + urine + "." ;
		
		return txt ;
	}
	
	public String giveStatus()
	{
		String firstOutput = "", secondOutput = "";
		String output = "" ;
		
		// 1foodOver, 2foodUnder, 3drinkOver, 4drinkUnder
		
		int distMuchFood = overdose - satiationMeter ;
		int distMuchDrink = overdose - hydrationMeter ;
		int mini = overdose ;
		String biggestThreat = "" ;
		
		if( distMuchFood < mini )
		{
			mini = distMuchFood ;
			biggestThreat = "too much food" ;
		}
		
		if( satiationMeter < mini )
		{
			mini = satiationMeter ;
			biggestThreat = "too little food" ;
		}
		
		if( distMuchDrink < mini )
		{
			mini = distMuchDrink ;
			biggestThreat = "too much drink" ;
		}
		
		if( hydrationMeter < mini )
		{
			mini = hydrationMeter ;
			biggestThreat = "too little drink" ;
		}
		
		/*if( 100-urine < mini )
		{
			mini = 100-urine ;
			biggestThreat = "too much pee" ;
		}
		
		if( 100-feces < mini )
		{
			mini = 100-feces ;
			biggestThreat = "too much poo" ;
		}*/
		
		// --
		
		System.out.println("Biggest threat: "+biggestThreat);
		
		if( biggestThreat == "too much food" ) // too much food
		{
			if(satiationMeter>=overdose)
			{
				lives = false ;
				happinessMeter = 0 ;
				funMeter = 0 ;
				return name +" died of overeating." ;
			}
			else if(satiationMeter>=(100+overdose)/2) firstOutput = name+" is WAY too full" ;
			else if(satiationMeter>100) firstOutput = name+" ate a bit too much" ;
		}
		else		
		if( biggestThreat == "too little food" ) // too little food
		{
			if(satiationMeter<=0)
			{
				lives = false ;
				happinessMeter = 0 ;
				funMeter = 0 ;
				return name +" died of starvation." ;
			}
			else if(satiationMeter<=10) firstOutput = name+" is starving" ;
			else if(satiationMeter<=30) firstOutput = name+" is very hungry" ;
			else if(satiationMeter<=60) firstOutput = name+" is hungry" ;
			else if(satiationMeter<=90) firstOutput = name+" a little hungry" ;	
		}
		else
		if( biggestThreat == "too much drink"  ) // too much drink
		{
			if(hydrationMeter>=overdose)
			{
				lives = false ;
				happinessMeter = 0 ;
				funMeter = 0 ;
				return name +" died of overdrinking." ;
			}
			else if(hydrationMeter>=(100+overdose)/2) firstOutput = name+" drank WAY too much" ;
			else if(hydrationMeter>100) firstOutput = name+" drank a bit too much" ;
		}
		else
		if( biggestThreat == "too little drink"  ) // too little drink
		{
			if(hydrationMeter<=0)
			{
				lives = false ;
				happinessMeter = 0 ;
				funMeter = 0 ;
				return name +" died of dehydration." ;
			}
			else if(hydrationMeter<=10) firstOutput = name+" is awfully parched" ;
			else if(hydrationMeter<=30) firstOutput = name+" is very thirsty" ;
			else if(hydrationMeter<=60) firstOutput = name+" is thirsty" ;
			else if(hydrationMeter<=90) firstOutput = name+" is a little thirsty" ;			
		}

		
		if( feces>=100)
		{
			lives = false ;
			happinessMeter = 0 ;
			funMeter = 0 ;
			return name+"'s butt exploded." ;
		}
		else if ( feces >= 90 )
		{
			secondOutput = name+" needs to poo REALLY bad! " ;		
		}
		else if ( feces >= 60 )
		{
			secondOutput = name+" needs to poo a lot. " ;			
		}
		else if ( feces >= 30 )
		{
			secondOutput = name+" needs to poo. " ;
		}
		else if ( feces >= 10 )
		{
			secondOutput = name+" needs to poo a bit. " ;
		}
		
		// ----
		
		if( urine>=100)
		{
			lives = false ;
			happinessMeter = 0 ;
			funMeter = 0 ;
			return name+"'s bladder exploded." ;
		}
		else if ( urine >= 90 )
		{
			secondOutput += name+" needs to pee REALLY bad!" ;		
		}
		else if ( urine >= 60 )
		{
			secondOutput += name+" needs to pee a lot." ;			
		}
		else if ( urine >= 30 )
		{
			secondOutput += name+" needs to pee." ;
		}
		else if ( urine >= 10 )
		{
			secondOutput += name+" needs to pee a bit." ;
		}
		
		
		// add toilet needs
		
		if(firstOutput=="" && secondOutput=="") 
		{
			//System.out.println("-->"+firstOutput+secondOutput+"<--");
			if( funMeter >= 95 ) output = name+" is perfectly okay.";
			else if( funMeter>80) output = name+" is a little bored.";
			else if( funMeter>50) output = name+" is bored.";
			else if( funMeter>20) output = name+" is very bored.";
			else output = name+" is awfully bored.";			
		}
		else if(firstOutput!="" && secondOutput == "") output = firstOutput+'.';
		else if(firstOutput=="" && secondOutput != "") output = secondOutput ;
		else output = firstOutput + " and " + secondOutput ;
		
				
		
		return output ;
	}
	
	public void dayPasses()
	{
		if( lives )
		{
			this.hydrationMeter = Math.max(0,hydrationMeter-10) ;
			this.satiationMeter = Math.max(0,satiationMeter-6) ;
			this.funMeter =  Math.max(0,funMeter-10) ;
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
		updateHappiness();
	}
	
	public void getFed( int foodQuantity )
	{
		this.satiationMeter = Math.min(overdose,this.satiationMeter+foodQuantity) ;
		
		if(this.satiationMeter>50) this.feces = Math.min(overdose,this.feces+foodQuantity/2) ;
		
		updateHappiness();
	}
	
	public void getWatered( int drinkQuantity )
	{
		this.hydrationMeter = Math.min(overdose,this.hydrationMeter+drinkQuantity) ;
		if(hydrationMeter>50) this.urine = Math.min(overdose,this.urine+drinkQuantity/2) ;
		
		updateHappiness();
	}
	
	public void purgeGuts()
	{
		this.urine = 0 ;
		this.feces = 0 ;
		
		updateHappiness();
	}

}
