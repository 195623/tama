// stucture/calc-mvc/CalcController.java - Controller
//    Handles user interaction with listeners.
//    Calls View and Model as needed.
// Fred Swartz -- December 2004

import java.awt.event.*;

import java.awt.*;
import javax.swing.*;

public class TamaC
{
    //... The Controller needs to interact with both the Model and View.
    private TamaM m_model ;//= new TamaM();
    private TamaV m_view  ;//= new TamaV(m_model);// = new TamaV(m_model);
    
    JRadioButton petActionsRadioButton    = new JRadioButton();
    JRadioButton mainMenuRadioButton = new JRadioButton();
    
    JPanel m_cards;
    CardLayout m_cardLayout ;
    
    
    //========================================================== constructor
    /** Constructor */
    TamaC(TamaM model, TamaV view)
    {
        m_model = model ; // swapped L and R
        m_view  = view;
        
        //m_view.showEx();
        
        //System.out.println(model.returnPet().returnNeeds());
        
        
        
        
        petActionsRadioButton = m_view.returnPetActionsRadioButton();
        mainMenuRadioButton = m_view.returnMainMenuRadioButton();
        
        
        
        m_cards = m_view.returnCards();
        m_cardLayout = m_view.returnCardLayout();
        
        //... Add listeners to the view.
        //m_view.addMultiplyListener(new MultiplyListener());
        
        m_view.addPetListener( new PetListener() );
        m_view.addRadioListener(new RadioListener());
        m_view.addMainMenuListener(new MainMenuListener());
        
        

      
    }
    
    // -----------------------------------------
    
    
    ////////////////////////////////////////// inner class MultiplyListener
    /** When a mulitplication is requested.
     *  1. Get the user input number from the View.
     *  2. Call the model to mulitply by this number.
     *  3. Get the result from the Model.
     *  4. Tell the View to display the result.
     * If there was an error, tell the View to display it.
     */
    
    
    
    class RadioListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {
    		if (petActionsRadioButton.isSelected())
            {
            	m_cardLayout.show(m_cards, "Pet Actions");
            	
            	System.out.println("1st choice");
            }
            else if (mainMenuRadioButton.isSelected())
            {
            	m_cardLayout.show(m_cards, "Main Menu");
            	System.out.println("2nd choice");
            }
        }
    	
    }
    
    class MainMenuListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {
    		if( e.getSource() == m_view.returnPreviousPetButton() )
            {
            	m_view.changePetIndex(-1);
            }
    		else if( e.getSource() == m_view.returnNextPetButton() )
            {
            	//System.out.println("Pet got fed.");
            	//currentPet.getFed(10);
    			m_view.changePetIndex(1);
            }
    		
    		m_view.updatePetNeeds();
        }
    	
    }
    
    
    class PetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	Creature currentPet = m_model.returnPets().get(m_view.returnSelectedPet());
        	       	
            if( e.getSource() == m_view.returnFeedButton() )
            {
            	System.out.println("Pet got fed.");
            	currentPet.getFed(10);
            }
            else if( e.getSource() == m_view.returnWaterButton() )
            {
            	System.out.println("Pet got watered.");
            	currentPet.getWatered(20);
            }
            else if( e.getSource() == m_view.returnWalkButton() )
            {
            	System.out.println("Pet got walked.");
            	currentPet.purgeGuts();
            }            
            else if( e.getSource() == m_view.returnPlayButton() )
            {
            	System.out.println("Pet got played with.");
            	currentPet.play(30);
            }
            else if( e.getSource() == m_view.returnWaitButton() )
            {
            	System.out.println("Waited a day.");
            	currentPet.dayPasses();            	
            	
            }
            else System.out.println("action performed");
            
            m_view.updatePetNeeds();
        }    
    }
    
 
}