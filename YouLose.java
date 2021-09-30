package FinalProject; 

import java.awt.*; 

import java.awt.event.*; 

import javax.swing.*; 


public class YouLose extends JFrame implements ActionListener 

{ 

JPanel myPanel; 

LayoutManager myLayout; 

 

    public YouLose()   //change GraphicWindow to the name of your class 

    { 

	    /*this is where code goes once a GraphicWindow is created in the Main 
	
	    program.  */ 
	
	     
	
	    //dont worry about this means yet, just know that you can change the title 
	
	    //of your frame below. 
	
	    super("Super Mario");   
	
	     
	
	    //end the program if the close button is hit, otherwise program goes forever. 
	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	
	     
	
	    this.setSize(1450, 917); //set the size of the window (frame) in pixels 
	
	     
	
	     
	
	    //create a JPanel (pane) to organize contents in our JFrame/Window 
	
	    //myPanel is now in control of displaying content. 
	
	    myPanel = (JPanel) this.getContentPane(); 
	
	     
	
	    //set a LayoutManager for myPanel to organize content.  
	
	    //change FlowLayout to whatever type of layout you want or use null for no layout help. 
	
	    myLayout = new FlowLayout(); 
	
	    myPanel.setLayout(myLayout);   //assign this layout to your panel 
	
	     
	
	     
	
	    //create the 3 buttons and assign their colors 
	
	    JButton playAgainButton = new JButton("Play Again!");//creating a play again button 
	    JButton quitButton = new JButton("Quit"); //creating a quit button
	     
	
	    //add the buttons in the order we want 
	
	    myPanel.add(playAgainButton);  //adding the buttons
	    myPanel.add(quitButton);//adding the buttons
	 
	     
	
	    playAgainButton.addActionListener(this); //allow the program to use the buttons
	    quitButton.addActionListener(this); //allow the program to use the buttons
	    
	    
	    this.pack();//condenses the program size
	    this.setVisible(true);  //allows the program to be visible
	
	    
	
	  } 

     

 

	public void actionPerformed(ActionEvent e) { 
		
		      
		
		  String action = e.getActionCommand();  //returns a string with the action's name 
		
		  
		
		  if (action.equals("Play Again!")) {
		
			  Mario myGUI = new Mario();//if play again is selected then open mario
		
		  }
		  if (action.equals("Quit")) {
		
				System.exit(0);// exit
		
		  }
		} 
		
		 
		
} 