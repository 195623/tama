// structure/calc-mvc/CalcView.java - View component
//    Presentation only.  No user actions.
// Fred Swartz -- December 2004

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class TamaV extends JFrame
{
	JFrame mainJFrame = new JFrame();
	JFrame subJFrame = new JFrame() ;
	
    //... Constants
    private static final String INITIAL_VALUE = "1";
    
    private TamaM m_model = new TamaM();
    
    // ------------------------------------------------------
    
    //private Creature ext_pet ;
    
    private JButton		previousPetButton = new JButton ("previous") ;
    private JButton		nextPetButton     = new JButton ("next") ;
    
    private JButton		feedButton    = new JButton("Feed");
    private JButton		waterButton   = new JButton("Water");
    private JButton		walkButton    = new JButton("Walk");
    private JButton		playButton    = new JButton("Play");
    
    private JButton    waitButton    = new JButton("Wait");
    
    private JTextField petNeeds = new JTextField("");
    private JTextField petStatus = new JTextField("");
    
    private JTextField currentPetTextIndex = new JTextField("0");
    private JTextField currentPetName = new JTextField("");
    
    /** Constructor */
    TamaV(TamaM model)
    {	   	
        m_model = model;
        currentPetName.setText(m_model.returnPets().get(0).returnName()+"                ");
        
        showEx();
        //showWindow();
        
    }
    
  //======================================================= constructor
    
    public void updatePetNeeds()
    {
    	int currentPetIndex = Integer.parseInt(currentPetTextIndex.getText());
    	
    	
    	petNeeds.setText(m_model.returnPets().get(currentPetIndex).returnNeeds()) ;
    	petStatus.setText(m_model.returnPets().get(currentPetIndex).returnStatus()) ;
    }
    
    public int returnSelectedPet()
    {
    	int currentPetIndex = Integer.parseInt(currentPetTextIndex.getText());
    	
    	return currentPetIndex ;
    }
    
    public void changePetIndex(int i)
    {
    	int currentPetIndex = Integer.parseInt(currentPetTextIndex.getText());
    	currentPetIndex += i ;
    	
    	int n = m_model.returnPets().size() ;
    	
    	if(currentPetIndex<0) currentPetIndex  = n-1 ;
    	if(currentPetIndex>=n) currentPetIndex = 0 ;
    	
    	
    	currentPetTextIndex.setText(Integer.toString(currentPetIndex));
    	// update pet displayed name
    	currentPetName.setText(m_model.returnPets().get(currentPetIndex).returnName());
    	
    }
    
    // ------------------------------------------------
    
    public JButton returnNextPetButton()
    {
    	return nextPetButton ;
    }
    
    public JButton returnPreviousPetButton()
    {
    	return previousPetButton ;
    }
    
    // --------
    
    public JButton returnFeedButton()
    {
    	return feedButton ;
    }
    
    public JButton returnWaterButton()
    {
    	return waterButton ;
    }
    
    public JButton returnWalkButton()
    {
    	return walkButton ;
    }
    
    public JButton returnPlayButton()
    {
    	return playButton ;
    }
    
    
    public JButton returnWaitButton()
    {
    	return waitButton ;
    }
    
    
    // --------------------------------    
    
    
    void showWindow()
    {
    	this.setLayout(new FlowLayout());
    	
        
        // ------------------------------------
        
    	this.add(feedButton);
    	this.add(waterButton);
    	this.add(walkButton);
    	this.add(playButton);
    	this.add(waitButton);
        
    	this.add(new JLabel(m_model.returnPet().returnNeeds()));
    	this.pack();
    	this.setVisible(true);
    	
    	this.setTitle("Tamagotchi_MVC");

    	// The window closing event should be passed to the Controller
    	
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    	
    }
    
    JPanel returnPetActionsWindow()
    {
    	JPanel jpan = new JPanel(new GridLayout(5, 2));
    	
    	jpan.add(feedButton);
    	jpan.add(waterButton);
    	jpan.add(walkButton);
    	jpan.add(playButton);
    	jpan.add(waitButton);
        
    	updatePetNeeds();
    	jpan.add(new JLabel());
    	jpan.add(petNeeds);
    	jpan.add(petStatus);
    	
    	return jpan ;
    }
    
    
    
    
    
    
    
    JPanel returnMainMenuWindow()
    {
    	JPanel jpan = new JPanel(new FlowLayout()); //            change layout 
    	
    	// elements
    	jpan.add(previousPetButton);
    	jpan.add(new JLabel("Pet #"));
    	jpan.add(currentPetTextIndex);
    	jpan.add(new JLabel(": "));
    	jpan.add(currentPetName);
    	jpan.add(nextPetButton);

    	//jpan.add(new JButton());
    	
    	return jpan ;
    }
    
    
    
    
			    CardLayout cardLayout = new CardLayout();
			    
			    JPanel gui = new JPanel(new BorderLayout(5,5));
			    JPanel cards = new JPanel(cardLayout);
			    
			    
			    JRadioButton mainMenuRadioButton = new JRadioButton("Main Menu",true);
			    JRadioButton petActionsRadioButton = new JRadioButton("Pet Actions", false);
			    
			    
    
    public void showEx()
    {
    	

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add( mainMenuRadioButton );
        buttonGroup.add( petActionsRadioButton );
        

        JPanel buttons = new JPanel(new GridLayout(1, 1));
        buttons.add( mainMenuRadioButton );
        buttons.add( petActionsRadioButton );
        
        // -----------------------------------------------------------
        
        JPanel jpan = returnMainMenuWindow();
        
        cards.add(jpan, "Main Menu");
        
        // --------------------------------
        
        JPanel jpan2 = returnPetActionsWindow();
        cards.add(jpan2, "Pet Actions");

        gui.add(buttons, BorderLayout.SOUTH);       
        
        
        
        
        // ------------------------------------------------------------
        
        gui.add(cards);
        this.setContentPane(gui);
        this.pack();
        this.setVisible(true);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    

    
   
    void showError(String errMessage)
    {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    
    
    
        
    // ------------
    
    void addMainMenuListener(ActionListener mal)
    {
    	nextPetButton.addActionListener(mal);
    	previousPetButton.addActionListener(mal);
    }
    
    void addRadioListener(ActionListener ral)
    {
    	petActionsRadioButton.addActionListener(ral);
    	mainMenuRadioButton.addActionListener(ral);
    }
    
    void addPetListener(ActionListener fal)
    {
        feedButton.addActionListener(fal);
        waterButton.addActionListener(fal);
        walkButton.addActionListener(fal);
        playButton.addActionListener(fal);
        waitButton.addActionListener(fal);
    }
        
    public JRadioButton returnMainMenuRadioButton()
    {
    	return mainMenuRadioButton ;
    }
    
    public JRadioButton returnPetActionsRadioButton()
    {
    	return petActionsRadioButton ;
    }
    
    JPanel returnCards()
    {
    	return cards ;
    }
    
    CardLayout returnCardLayout()
    {
    	return cardLayout ;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*void addMultiplyListener(ActionListener mal)
    {
        m_multiplyBtn.addActionListener(mal);
    }*/
    
}