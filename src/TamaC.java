// stucture/calc-mvc/CalcController.java - Controller
//    Handles user interaction with listeners.
//    Calls View and Model as needed.
// Fred Swartz -- December 2004

import java.awt.event.*;

public class TamaC
{
    //... The Controller needs to interact with both the Model and View.
    private TamaM m_model;
    private TamaV  m_view;
    
    //========================================================== constructor
    /** Constructor */
    TamaC(TamaM model, TamaV view)
    {
        m_model = model;
        m_view  = view;
        
        //... Add listeners to the view.
        view.addMultiplyListener(new MultiplyListener());
        //view.addClearListener(new ClearListener());
        view.addPetListener( new PetListener() );

      
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
    
    
    class PetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
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
        }    
    }
}