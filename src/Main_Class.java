
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;

//							THIS WILL BE THE CONTROLLER

public class Main_Class extends Applet implements ActionListener, ItemListener
{
	public static void main(String[] args) 
	{
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		/*String name = pet.returnName();
		
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
		
		
		
			
		repaint(); 	*/
	}
	
	public void itemStateChanged(ItemEvent e)
    {
    	/*String text ;
    	
            if(e.getItemSelectable() == choice1)
            {
            	text = ( (Choice) e.getItemSelectable() ).getSelectedItem() ;            	
            	textField.setText( text );
            }*/
    }   

}
