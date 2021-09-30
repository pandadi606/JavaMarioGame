/*
* Project: ics3u
* Package: intro
* Class:OpeningPage   
* Programmer: Aditya Pandya
* Date Created: 11/06/2020
* Description:  Allows Character Selection
*/		
package FinalProject; 
		
		 
		
		//some import statements to get code written to help us 
		
		import java.awt.*; 
		
		import java.awt.event.*; 
		
		import javax.swing.*; 
		
		 
		
		 
		
		/*You need to add the line "extends JFrame class and implement ActionListener" 
		
		 * to your class definition. For now don't worry about what this means other  
		
		 * than it means additional code we can not see is included.  
		
		 * You can change GraphicWindow to the name of your class 
		
		 */ 
		
		public class OpeningPage extends JFrame implements  MouseListener 
		
		{ 
		JPanel myPanel;//creating A variable for the panel
		LayoutManager myLayout; // my layout represents the flow layout
		String audioFilePath ="Super Mario Bros. Theme Song.wav";//The song that will play if 
		Sound player = new Sound();//opens sound class
		int x;
		int y;
		
		    public OpeningPage()
		
		    { 

		    super("Super Mario");   //sets super as Super Mario
		
		     
		
		    //end the program if the close button is hit, otherwise program goes forever. 
		
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		     
		
		    this.setSize(500, 880); //set the size of the window 

		    //create a JPanel (pane) to organize contents in our JFrame/Window 
		
		    //myPanel is now in control of displaying content. 
		
		    myPanel = (JPanel) this.getContentPane(); 
		
		     
		
		    //set a LayoutManager for myPanel to organize content.  
		
		    //change FlowLayout to whatever type of layout you want or use null for no layout help. 
		
		    myLayout = new FlowLayout(); 
		
		    myPanel.setLayout(myLayout);   //assign this layout to your panel 

		    playMusic();
		
		    addMouseListener(this);
		    this.setVisible(true);  
		
		    } 
		    public void paint(Graphics g) {
		    	
		    	super.paint(g);
		    	
		    	Image background = Toolkit.getDefaultToolkit().getImage("start page.png");//Gives the background the mario Image
				g.drawImage(background,10, 10, this);
				Image mario = Toolkit.getDefaultToolkit().getImage("mario.png");//if the user clicks the mario he plays as mario
				g.drawImage(mario,150, 50, this);
				Image luigi = Toolkit.getDefaultToolkit().getImage("luigi.png");// if he selects luigi then he plays as luigi
				g.drawImage(luigi,300, 50, this);
				g.setColor(Color.WHITE);//new color
				g.setFont(new Font("Broadway", Font.BOLD, 25));
				g.drawString("Click on Character to Begin", 50, 850);
				
		    }
		     
		public void playMusic()
		{
				player.play(audioFilePath);
				player.loop();//plays the music set above
		}

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			x = e.getX();//gets the x and y values of the location clicked
			y = e.getY();
			if((x > 150 && x < 200) && (y > 50 && y < 150))
			{
				 Mario myGUI = new Mario();//if they click mario start mario and exits the program
				 this.dispose();
			}
			else if((x > 300 && x < 350) && (y > 50 && y < 150))
			{
				 Luigi myGUI = new Luigi();//if they click luigi start luigi and exits the program
				 this.dispose();
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		 
		
		} 