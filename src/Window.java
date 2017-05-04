import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;
import java.applet.Applet;


public class Window extends Applet implements ActionListener, ItemListener
{	
	// Deklaracje obiektow - zmiennych reprezentujacych button i okno tekstowe
	Button  nextDay ;
	
	boolean defaultColor = true ;
			
	Color currentColor = Color.BLACK ;
	
	TextField oknoTekstowe; 
	Choice choice1 ;
	String text ;
	
	// ----
	
	int currentDay = 1 ;
	Creature pet = new Creature("Bonnie");
	String statusMessage ;
	
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
		
	}
	
	
	public void actionPerformed(ActionEvent evt)
	{		
		if (evt.getSource() == nextDay)
		{			
			currentDay++ ;
			pet.dayPasses();
		}
			
		repaint(); 	
	}
		
	public void init()
	{			
		nextDay = new Button("NEXT DAY");
		add(nextDay);
		nextDay.addActionListener(this);
		
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
            if(e.getItemSelectable() == choice1)
            {
            	text = ( (Choice) e.getItemSelectable() ).getSelectedItem() ;            	
            	oknoTekstowe.setText( text );
            }
    }    

}		// koniec klasy Appletu

