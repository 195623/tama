import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import java.applet.Applet;



// View AND Controller

public class View extends Applet implements ActionListener, ItemListener
{	
	// Deklaracje obiektow - zmiennych reprezentujacych button i okno tekstowe
	Button  nextDay,
			feed,
			water,
			takeOnWalk,
			play;
	
	boolean defaultColor = true ;
			
	Color currentColor = Color.BLACK ;
	
	TextField textField; 
	Choice choice1 ;
	
	// ----
	
	int currentDay = 1 ;
	Creature pet = new Creature("Bonnie");
	String statusMessage = "", lastActionMessage = "" ;
	
	public void setTextField(String txt)
	{
		textField.setText(txt);		
	}
	
	public TextField returnTextField()
	{
		return textField;
	}
	
	// ----
	
	public void paint (Graphics g)
	{		
		
		g.setColor(currentColor);		
		
		g.setColor(currentColor); 
		g.drawLine(50,50, 125, 190);
		g.drawLine(125, 190, 200, 50);
		g.drawLine(200, 50, 50, 50);
		
		// --
		
		g.drawString("Current day: "+currentDay, 200, 100);
		statusMessage = pet.giveStatus() ;
		g.drawString(statusMessage, 200, 130);
		
		g.drawString("Recent action: "+lastActionMessage, 200, 160);
		lastActionMessage = "" ;	
		
		g.drawString(pet.giveNeeds(), 200, 190);
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent evt)
	{
		String name = pet.returnName();
		
		if (evt.getSource() == nextDay)
		{			
			currentDay++ ;
			pet.dayPasses();
			
			
			lastActionMessage = name+" woke up the next day." ;
		}
		
		if(!pet.isAlive())
		{
			lastActionMessage = "Attempted action failed, because " + name + " is dead.";
			repaint();
			return ;
		}
		
		if (evt.getSource() == feed)
		{			
			pet.getFed(10) ;
			lastActionMessage = name+" ate some food." ;
		}
		
		if (evt.getSource() == water)
		{			
			pet.getWatered(15) ;
			lastActionMessage = name+" drank some water." ;
		}
		
		if (evt.getSource() == takeOnWalk)
		{			
			pet.purgeGuts() ;
			
			lastActionMessage = name+" did its business." ;
		}
		
		if (evt.getSource() == play)
		{			
			pet.play(25) ;
			
			lastActionMessage = name+" played a game." ;
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
		
		play = new Button("Play");
		add(play);
		play.addActionListener(this);
		
		// --------
		
		textField = new TextField(20);
        add(textField);
        choice1 = new Choice();
        choice1.add("A");
        choice1.add("B");

        add(choice1); 
        choice1.addItemListener(this);
        
        textField.setText( "---" );
		
		

	}	// koniec funkcji init
	
    public void itemStateChanged(ItemEvent e)
    {
    	String text ;
    	
            if(e.getItemSelectable() == choice1)
            {
            	text = ( (Choice) e.getItemSelectable() ).getSelectedItem() ;            	
            	textField.setText( text );
            }
    }    

}		// koniec klasy Appletu

