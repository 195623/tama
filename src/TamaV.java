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
    
    //... Components
    //private JTextField m_userInputTf = new JTextField(5);
    //private JTextField m_totalTf     = new JTextField(20);
    //private JButton    m_multiplyBtn = new JButton("Multiply");
    //private JButton    m_clearBtn    = new JButton("Clear");
    
    private TamaM m_model = new TamaM();
    
    // ------------------------------------------------------
    
    //private Creature ext_pet ;
    
    private JButton    feedButton    = new JButton("Feed");
    private JButton    waterButton    = new JButton("Water");
    private JButton    walkButton    = new JButton("Walk");
    private JButton    playButton    = new JButton("Play");
    
    private JButton    waitButton    = new JButton("Wait");
    
    private JTextField petNeeds = new JTextField("");
    private JTextField petStatus = new JTextField("");
    
    /** Constructor */
    TamaV(TamaM model)
    {	   	
        m_model = model;        // swapped L and R        
        
        //showEx(); -------------
        //showWindow();
        
    }
    
    public void updatePetNeeds()
    {
    	
    	petNeeds.setText(m_model.returnPet().returnNeeds()) ;
    	petStatus.setText(m_model.returnPet().returnStatus()) ;
    }
    
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
    
    
    
    //======================================================= constructor
    
    JPanel content = new JPanel();
    JPanel content2 = new JPanel();
    
    
    
    
    void showWindow()
    {
    	this.setLayout(new FlowLayout());
    	
        
        // ------------------------------------
        
    	this.add(feedButton);
    	this.add(waterButton);
    	this.add(walkButton);
    	this.add(playButton);
    	this.add(waitButton);
        
    	this.add(new JLabel(m_model.returnPet().returnNeeds())); // -----------------
    	this.pack();
    	this.setVisible(true);
    	
    	this.setTitle("Tamagotchi_MVC");
        // The window closing event should probably be passed to the 
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    	
    }
    
    JPanel returnWindow()
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
    	//jpan.add(new JLabel(m_model.returnPet().returnNeeds()));
    	
    	return jpan ;
    }
    
    
    
    
    CardLayout cardLayout = new CardLayout();
    
    JPanel gui = new JPanel(new BorderLayout(5,5));
    JPanel cards = new JPanel(cardLayout);
    
    JRadioButton actionScreen = new JRadioButton("Action Screen",false);
    JRadioButton menu = new JRadioButton("Main Menu", true);   
    
    public void showEx()
    {
    	

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add( menu );
        buttonGroup.add( actionScreen );

        JPanel buttons = new JPanel(new GridLayout(1, 1));
        buttons.add( menu );
        buttons.add( actionScreen );
        
        // --------------------------------
        
        JPanel jpan2 = returnWindow();

        gui.add(buttons, BorderLayout.SOUTH);       
        cards.add(jpan2, "menu");        
        
        cards.add(new JLabel("[action screen's content]"), "action screen");
        
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
    
    void addRadioListener(ActionListener ral)
    {
    	menu.addActionListener(ral);
        actionScreen.addActionListener(ral);
    }
    
    void addPetListener(ActionListener fal)
    {
        feedButton.addActionListener(fal);
        waterButton.addActionListener(fal);
        walkButton.addActionListener(fal);
        playButton.addActionListener(fal);
        waitButton.addActionListener(fal);
    }
    
    
    JRadioButton returnMenu()
    {
    	return menu ;
    }
    
    JRadioButton returnActionScreen()
    {
    	return actionScreen ;
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