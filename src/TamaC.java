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
    
    JRadioButton m_menu ;
    JRadioButton m_actionScreen ;
    
    JPanel m_cards;
    CardLayout m_cardLayout ;
    
    
    //========================================================== constructor
    /** Constructor */
    TamaC(TamaM model, TamaV view)
    {
        m_model = model ; // swapped L and R
        m_view  = view;
        
        m_model.returnPet().dayPasses();
        m_model.returnPet().dayPasses();
        m_model.returnPet().dayPasses();
        
        m_view.showEx();
        
        //System.out.println(model.returnPet().returnNeeds());
        
        
        
        
        m_menu = m_view.returnMenu();
        m_actionScreen = m_view.returnActionScreen(); 
        
        
        m_cards = m_view.returnCards();
        m_cardLayout = m_view.returnCardLayout();
        
        //... Add listeners to the view.
        //m_view.addMultiplyListener(new MultiplyListener());
        
        m_view.addPetListener( new PetListener() );
        m_view.addRadioListener(new RadioListener());
        
        

      
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
    		if (m_menu.isSelected())
            {
            	m_cardLayout.show(m_cards, "menu");
            	
            	System.out.println("1st choice");
            }
            else
            {
            	m_cardLayout.show(m_cards, "action screen");
            	System.out.println("2nd choice");
            }
        }
    	
    }
    
    
    class PetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	//m_view.showEx();
        	
        	m_view.updatePetNeeds();
        	
        	
            if( e.getSource() == m_view.returnFeedButton() )
            {
            	System.out.println("Pet got fed.");
            }
            else if( e.getSource() == m_view.returnWaterButton() )
            {
            	System.out.println("Pet got watered.");
            }
            else if( e.getSource() == m_view.returnWalkButton() )
            {
            	System.out.println("Pet got walked.");
            }            
            else if( e.getSource() == m_view.returnPlayButton() )
            {
            	System.out.println("Pet got played with.");
            }
            else if( e.getSource() == m_view.returnWaitButton() )
            {
            	System.out.println("Waited a day.");
            	m_model.returnPet().dayPasses();            	
            	
            }
            else System.out.println("action performed");
        }    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    class MultiplyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String userInput = "";
            try
            {
                //userInput = m_view.getUserInput();
                //m_model.multiplyBy(userInput);
                //m_view.setTotal(m_model.getValue());
                
            }
            catch (NumberFormatException nfex)
            {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }//end inner class MultiplyListener
}