import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import java.applet.Applet;


public class Window extends Applet implements ActionListener, ItemListener
{	
	// Deklaracje obiektow - zmiennych reprezentujacych button i okno tekstowe
	Button  nextDay,
			feed,
			water,
			takeOnWalk;
	
	boolean defaultColor = true ;
			
	Color currentColor = Color.BLACK ;
	
	TextField oknoTekstowe; 
	Choice choice1 ;
	
	// ----
	
	int currentDay = 1 ;
	Creature pet = new Creature("Bonnie");
	String statusMessage = "", lastActionMessage = "" ;
	
	// ----
	
	public void paint (Graphics g)
	{		
		
		g.setColor(currentColor);		
		
		g.setColor(currentColor); 
		g.drawLine(50,50, 80, 190);
		g.drawLine(80, 190, 190, 50);
		g.drawLine(190, 50, 50, 50);
		
		// --
		
		g.drawString("Current day: "+currentDay, 200, 100);
		statusMessage = pet.giveStatus() ;
		g.drawString(statusMessage, 200, 130);
		
		g.drawString("Recent action: "+lastActionMessage, 200, 160);
		lastActionMessage = "" ;
		
		// --
		
		int satiation = pet.countSatiation() ;
		int hydration = pet.countHydration() ;
		int happiness = pet.countHappiness() ;
		int feces = pet.countFeces() ;
		int urine = pet.countUrine() ;
		String txt = "" ;
		txt += "Satiation: " + satiation + ", " ;
		txt += "Hydration: " + hydration + ", " ;
		txt += "Happiness: " + happiness + ", " ;
		txt += "    feces: " + feces + ", " ;
		txt += "    urine: " + urine + "." ;
		
		
		g.drawString(txt, 200, 190);
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent evt)
	{		
		if (evt.getSource() == nextDay)
		{			
			currentDay++ ;
			pet.dayPasses();
			
			String name = pet.returnName();
			lastActionMessage = name+" woke up the next day." ;
		}
		
		if (evt.getSource() == feed)
		{			
			pet.getFed(10) ;
			String name = pet.returnName();
			lastActionMessage = name+" ate some food." ;
		}
		
		if (evt.getSource() == water)
		{			
			pet.getWatered(15) ;
			String name = pet.returnName();
			lastActionMessage = name+" drank some water." ;
		}
		
		if (evt.getSource() == takeOnWalk)
		{			
			pet.purgeGuts() ;
			String name = pet.returnName();
			
			lastActionMessage = name+" did its business." ;
		}
		
		
		
			
		repaint(); 	
	}
		
	public void init()
	{			
		nextDay = new Button("NEXT DAY");
		add(nextDay);
		nextDay.addActionListener(this);
		
		feed = new Button("Feed");
		add(feed);
		feed.addActionListener(this);
		
		water = new Button("Water");
		add(water);
		water.addActionListener(this);
		
		takeOnWalk = new Button("Take on a walk");
		add(takeOnWalk);
		takeOnWalk.addActionListener(this);
		
		// --------
		
		oknoTekstowe = new TextField(20);
        add(oknoTekstowe);
        choice1 = new Choice();
        choice1.add("A");
        choice1.add("B");

        add(choice1); 
        choice1.addItemListener(this);
        
        oknoTekstowe.setText( "---" );
		
		

	}	// koniec funkcji init
	
    public void itemStateChanged(ItemEvent e)
    {
    	String text ;
    	
            if(e.getItemSelectable() == choice1)
            {
            	text = ( (Choice) e.getItemSelectable() ).getSelectedItem() ;            	
            	oknoTekstowe.setText( text );
            }
    }    

}		// koniec klasy Appletu

