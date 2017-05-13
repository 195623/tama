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
    private JTextField m_userInputTf = new JTextField(5);
    private JTextField m_totalTf     = new JTextField(20);
    private JButton    m_multiplyBtn = new JButton("Multiply");
    private JButton    m_clearBtn    = new JButton("Clear");
    
    private TamaM m_model;
    
    // ------------------------------------------------------
    
    private Creature ext_pet ;
    
    private JButton    feedButton    = new JButton("Feed");
    private JButton    waterButton    = new JButton("Water");
    private JButton    walkButton    = new JButton("Walk");
    private JButton    playButton    = new JButton("Play");
    
    //TextField textField = new TextField("default");
    
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
    
    
    
    //======================================================= constructor
    
    JPanel content = new JPanel();
    JPanel content2 = new JPanel();
    
    /** Constructor */
    TamaV(TamaM model)
    {	
    	ext_pet = model.returnPet();    	
        m_model = model;        

        
        //showWindow(); < --------------------<---------------------<-------- UNCOMMENT THIS and COMMENT NEXT
        showEx();
        
    }
    
    
    void showWindow()
    {
    	this.setLayout(new FlowLayout());
    	
        
        // ------------------------------------
        
    	this.add(feedButton);
    	this.add(waterButton);
    	this.add(walkButton);
    	this.add(playButton);
        
    	this.add(new JLabel(m_model.returnPet().returnNeeds()));
    	this.pack();
    	this.setVisible(true);
    	
    	this.setTitle("Tamagotchi_MVC");
        // The window closing event should probably be passed to the 
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    	
    }
    
    
    void showSubWindow()
    {
    	this.getContentPane().removeAll();
    	this.add(new JLabel("This is a subwindow."));
    	this.setTitle("Tamagotchi_MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void showEx()
    {
    	final JRadioButton game = new JRadioButton("Game", true);
        JRadioButton highScores = new JRadioButton("High Scores");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add( game );
        buttonGroup.add( highScores );

        JPanel buttons = new JPanel(new GridLayout(1, 1));
        buttons.add( game );
        buttons.add( highScores );

        JPanel gui = new JPanel(new BorderLayout(5,5));
        gui.add(buttons, BorderLayout.SOUTH);

        final CardLayout cardLayout = new CardLayout();
        final JPanel cards = new JPanel(cardLayout);
        gui.add(cards);
        cards.add(new JLabel("Level 1"), "game");
        
        JPanel jpan = new JPanel(new GridLayout(5, 1));
        jpan.add(new JLabel("High Scores"));
        jpan.add(new JLabel("1. JKB"));
        jpan.add(new JLabel("2. ASS"));
        jpan.add(new JLabel("3. POO"));
        cards.add(jpan, "scores");

        ActionListener al = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (game.isSelected())
                {
                	cardLayout.show(cards, "game");
                }
                else
                {
                	cardLayout.show(cards, "scores");
                }
            }
        };
        game.addActionListener(al);
        highScores.addActionListener(al);

        JOptionPane.showMessageDialog(null, gui);
    }
    
    

    
   
    void showError(String errMessage)
    {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    
    
    void addMultiplyListener(ActionListener mal)
    {
        m_multiplyBtn.addActionListener(mal);
    }
        
    // ------------
    
    void addPetListener(ActionListener fal)
    {
        feedButton.addActionListener(fal);
        waterButton.addActionListener(fal);
        walkButton.addActionListener(fal);
        playButton.addActionListener(fal);
    } 
    
}