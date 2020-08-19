import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeAI implements ActionListener, Runnable {	
	boolean turnX = true;
	boolean turnO = false;
	boolean topLeftX = false;
	boolean topLeftO = false;
	boolean topMiddleX = false;
	boolean topMiddleO = false;
	boolean topRightX = false;
	boolean topRightO = false;
	boolean middleLeftX = false;
	boolean middleLeftO = false;
	boolean middleMiddleX = false;
	boolean middleMiddleO = false;
	boolean middleRightX = false;
	boolean middleRightO = false;
	boolean bottomLeftX = false;
	boolean bottomLeftO = false;
	boolean bottomMiddleX = false;
	boolean bottomMiddleO = false;
	boolean bottomRightX = false;
	boolean bottomRightO = false;
	static int turnNumber = 0;
	static int xScore = 0;
	static int oScore = 0;
	
	Graphics g;
	ImageIcon X = new ImageIcon(getClass().getResource("X.png"));
	ImageIcon O = new ImageIcon(getClass().getResource("O.png"));
	private JFrame board = new JFrame("Tic Tac Toe");
	private JButton topLeft= new JButton();
	private JButton topMiddle= new JButton();
	private JButton topRight= new JButton();
	private JButton middleLeft= new JButton();
	private JButton middleMiddle= new JButton();
	private JButton middleRight= new JButton();
	private JButton bottomLeft= new JButton();
	private JButton bottomMiddle= new JButton();
	private JButton bottomRight= new JButton();
	private JButton restartButton = new JButton("Restart?");
	private ButtonGroup modeButtons = new ButtonGroup();
	private JRadioButton beginner = new JRadioButton("Beginner");
	private JRadioButton advanced = new JRadioButton("Advanced");
	private JLabel xScoreLabel = new JLabel("X score = " + xScore);
	private JLabel oScoreLabel = new JLabel("O Score = " + oScore);
	private JPanel firstPanel = new JPanel();
	private JPanel secondPanel = new JPanel();
	private JPanel thirdPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	
	
	public static void main(String[] args) 
	{
	new TicTacToeAI(xScore, oScore);
	}
	
	
	
	public TicTacToeAI(int xScore, int oScore) 
	{
	board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    firstPanel.setLayout(new GridLayout(3, 3));
    topLeft.setPreferredSize(new Dimension(100, 100));
    topMiddle.setPreferredSize(new Dimension(100, 100));
    topRight.setPreferredSize(new Dimension(100, 100));
    middleLeft.setPreferredSize(new Dimension(100, 100));
    middleMiddle.setPreferredSize(new Dimension(100, 100));
    middleRight.setPreferredSize(new Dimension(100, 100));
    bottomLeft.setPreferredSize(new Dimension(100, 100));
    bottomMiddle.setPreferredSize(new Dimension(100, 100));
    bottomRight.setPreferredSize(new Dimension(100, 100));
    
    topLeft.setBackground(Color.white);
    topMiddle.setBackground(Color.white);
    topRight.setBackground(Color.white);
    middleLeft.setBackground(Color.white);
    middleMiddle.setBackground(Color.white);
    middleRight.setBackground(Color.white);
    bottomLeft.setBackground(Color.white);
    bottomMiddle.setBackground(Color.white);
    bottomRight.setBackground(Color.white);
    
    topLeft.addActionListener(this);
    topMiddle.addActionListener(this);
    topRight.addActionListener(this);
    middleLeft.addActionListener(this);
    middleMiddle.addActionListener(this);
    middleRight.addActionListener(this);
    bottomLeft.addActionListener(this);
    bottomMiddle.addActionListener(this);
    bottomRight.addActionListener(this);
    restartButton.addActionListener(this);
    beginner.addActionListener(this);
    advanced.addActionListener(this);
    
    modeButtons.add(beginner);
    modeButtons.add(advanced);
    firstPanel.add(topLeft);
    firstPanel.add(topMiddle);
    firstPanel.add(topRight);
    firstPanel.add(middleLeft);
    firstPanel.add(middleMiddle);
    firstPanel.add(middleRight);
    firstPanel.add(bottomLeft);
    firstPanel.add(bottomMiddle);
    firstPanel.add(bottomRight);
    secondPanel.add(xScoreLabel);
    secondPanel.add(restartButton);
    secondPanel.add(oScoreLabel);
    thirdPanel.add(beginner);
    thirdPanel.add(advanced);
    mainPanel.add(thirdPanel);
    mainPanel.add(firstPanel);
    mainPanel.add(secondPanel);
    board.add(mainPanel);
    board.setSize(310,310);
    board.setResizable(false);
    board.setLocationRelativeTo(null);
	board.setVisible(true);
	//lets go
	new Thread(this).start();
	
	}

	@Override
	public void run() 
	{
	while(true)
		{
		System.out.println("");
		if		((bottomLeftX&&bottomMiddleX&&bottomRightX)		||
				(middleLeftX&&middleMiddleX&&middleRightX)		||
				(topLeftX&&topMiddleX&&topRightX)				||
				(topLeftX&&middleLeftX&&bottomLeftX)			||
				(topMiddleX&&middleMiddleX&&bottomMiddleX)		||
				(topRightX&&middleRightX&&bottomRightX)			||
				(topLeftX&&middleMiddleX&&bottomRightX)			||
				(bottomLeftX&&middleMiddleX&&topRightX))
		{
			System.out.println("X wins");
			xScore++;
			xScoreLabel.setText(("X score = " + xScore));
			topLeft.removeActionListener(this);
			topMiddle.removeActionListener(this);
			topRight.removeActionListener(this);
			middleLeft.removeActionListener(this);
			middleMiddle.removeActionListener(this);
			middleRight.removeActionListener(this);
			bottomLeft.removeActionListener(this);
			bottomMiddle.removeActionListener(this);
			bottomRight.removeActionListener(this);
			return;
		}
		if		((bottomLeftO&&bottomMiddleO&&bottomRightO)		||
				(middleLeftO&&middleMiddleO&&middleRightO)		||
				(topLeftO&&topMiddleO&&topRightO)				||
				(topLeftO&&middleLeftO&&bottomLeftO)			||
				(topMiddleO&&middleMiddleO&&bottomMiddleO)		||
				(topRightO&&middleRightO&&bottomRightO)			||
				(topLeftO&&middleMiddleO&&bottomRightO)			||
				(bottomLeftO&&middleMiddleO&&topRightO))
		{
			System.out.println("O wins");
			oScore++;
			oScoreLabel.setText(("O score = " + oScore));
			topLeft.removeActionListener(this);
			topMiddle.removeActionListener(this);
			topRight.removeActionListener(this);
			middleLeft.removeActionListener(this);
			middleMiddle.removeActionListener(this);
			middleRight.removeActionListener(this);
			bottomLeft.removeActionListener(this);
			bottomMiddle.removeActionListener(this);
			bottomRight.removeActionListener(this);
			
			return;
		}
		if(turnO)
			if(beginner.isSelected())
					beginner_AI();
			else 
					advanced_AI();
		}
		
	}
	
	public void beginner_AI() 
		{
		int Move = 0;
		Move = (int) (Math.random()*9);
		
		switch(Move)
		{
		case 0:
			if(!(topLeftX || topLeftO))
				{
				topLeftO = true;
				topLeft.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
			
			else 
				break;
		case 1:
			if(!(topMiddleX || topMiddleO))
			{
				topMiddleO = true;
				topMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
		case 2:
			if(!(topRightX || topRightO))
			{
				topRightO = true;
				topRight.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
			
		case 3:
			if(!(middleLeftX || middleLeftO))
			{
				middleLeftO = true;
				middleLeft.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
			
		case 4:
			if(!(middleMiddleX || middleMiddleO))
			{
				middleMiddleO = true;
				middleMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
			
		case 5:
			if(!(middleRightX || middleRightO))
				{
				middleRightO = true;
				middleRight.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
			
			else 
				break;
			
		case 6:
			if(!(bottomLeftX || bottomLeftO))
				{
				bottomLeftO = true;
				bottomLeft.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
			
			else 
				break;
		case 7:
			if(!(bottomMiddleX || bottomMiddleO))
				{
				bottomMiddleO = true;
				bottomMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
		case 8:
			if(!(bottomRightX || bottomRightO))
				{
				bottomRightO = true;
				bottomRight.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
			
			else 
				break;
			}
		
		}
	public void advanced_AI()
		{
		//horizontal wins
		if(topLeftO && topMiddleO && !(topRightX))
			{topRightO = true; topRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleLeftO && middleMiddleO && !(middleRightX))
			{middleRightO = true; middleRight.setIcon(O); turnX = true; turnO = false; return;}
		else if (bottomLeftO && bottomMiddleO && !(bottomRightX))
			{bottomRightO = true; bottomRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(topLeftO && topRightO && !(topMiddleX))
			{topMiddleO = true; topMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleLeftO && middleRightO && !(middleMiddleX))
			{middleMiddleO = true; middleMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(bottomLeftO && bottomRightO && !(bottomMiddleX))
			{bottomMiddleO = true; bottomMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(topMiddleO && topRightO && !(topLeftX))
			{topLeftO = true; topLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleMiddleO && middleRightO && !(middleLeftX))
			{middleLeftO = true; middleLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(bottomMiddleO && bottomRightO && !(bottomLeftX))
			{bottomLeftO = true; bottomLeft.setIcon(O); turnX = true; turnO = false; return;}
		
		//vertical wins
		else if(topLeftO && middleLeftO && !(bottomLeftX))
			{bottomLeftO = true; bottomLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(topMiddleO && middleMiddleO && !(bottomMiddleX))
			{bottomMiddleO = true; bottomMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(topRightO && middleRightO && !(bottomRightX))
			{bottomRightO = true; bottomRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(topLeftO && bottomLeftO && !(middleLeftX))
			{middleLeftO = true; middleLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(topMiddleO && bottomMiddleO && !(middleMiddleX))
			{middleMiddleO = true; middleMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(topRightO && bottomRightO && !(middleRightX))
			{middleRightO = true; middleRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleLeftO && bottomLeftO && !(topLeftX))
			{topLeftO = true; topLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleMiddleO && bottomMiddleO && !(topMiddleX))
			{topMiddleO = true; topMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleRightO && bottomRightO && !(topRightX))
			{topRightO = true; topRight.setIcon(O); turnX = true; turnO = false; return;}
		
		//diagonal wins
		else if(topLeftO && middleMiddleO && !(bottomRightX))
			{bottomRightO = true; bottomRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(topLeftO && bottomRightO && !(middleMiddleX))
			{middleMiddleO = true; middleMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleMiddleO && bottomRightO && !(topLeftX))
			{topLeftO = true; topLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(bottomLeftO && middleMiddleO && !(topRightX))
			{topRightO = true; topRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(bottomLeftO && topRightO && !(middleMiddleX))
			{middleMiddleO = true; middleMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(topRightO && middleMiddleO && !(bottomLeftX))
			{bottomLeftO = true; bottomLeft.setIcon(O); turnX = true; turnO = false; return;}
		//nowhere to win so
		//block x wins
		if(topLeftX && topMiddleX && !(topRightO))
			{topRightO = true; topRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleLeftX && middleMiddleX && !(middleRightO))
			{middleRightO = true; middleRight.setIcon(O); turnX = true; turnO = false; return;}
		else if (bottomLeftX && bottomMiddleX && !(bottomRightO))
			{bottomRightO = true; bottomRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(topLeftX && topRightX && !(topMiddleO))
			{topMiddleO = true; topMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleLeftX && middleRightX && !(middleMiddleO))
			{middleMiddleO = true; middleMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(bottomLeftX && bottomRightX && !(bottomMiddleO))
			{bottomMiddleO = true; bottomMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(topMiddleX && topRightX && !(topLeftO))
			{topLeftO = true; topLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleMiddleX && middleRightX && !(middleLeftO))
			{middleLeftO = true; middleLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(bottomMiddleX && bottomRightX && !(bottomLeftO))
			{bottomLeftO = true; bottomLeft.setIcon(O); turnX = true; turnO = false; return;}
		
		//vertical wins
		else if(topLeftX && middleLeftX && !(bottomLeftO))
			{bottomLeftO = true; bottomLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(topMiddleX && middleMiddleX && !(bottomMiddleO))
			{bottomMiddleO = true; bottomMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(topRightX && middleRightX && !(bottomRightO))
			{bottomRightO = true; bottomRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(topLeftX && bottomLeftX && !(middleLeftO))
			{middleLeftO = true; middleLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(topMiddleX && bottomMiddleX && !(middleMiddleO))
			{middleMiddleO = true; middleMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(topRightX && bottomRightX && !(middleRightO))
			{middleRightO = true; middleRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleLeftX && bottomLeftX && !(topLeftO))
			{topLeftO = true; topLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleMiddleX && bottomMiddleX && !(topMiddleO))
			{topMiddleO = true; topMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleRightX && bottomRightX && !(topRightO))
			{topRightO = true; topRight.setIcon(O); turnX = true; turnO = false; return;}
		
		//diagonal wins
		else if(topLeftX && middleMiddleX && !(bottomRightO))
			{bottomRightO = true; bottomRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(topLeftX && bottomRightX && !(middleMiddleO))
			{middleMiddleO = true; middleMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(middleMiddleX && bottomRightX && !(topLeftO))
			{topLeftO = true; topLeft.setIcon(O); turnX = true; turnO = false; return;}
		else if(bottomLeftX && middleMiddleX && !(topRightO))
			{topRightO = true; topRight.setIcon(O); turnX = true; turnO = false; return;}
		else if(bottomLeftX && topRightX && !(middleMiddleO))
			{middleMiddleO = true; middleMiddle.setIcon(O); turnX = true; turnO = false; return;}
		else if(topRightX && middleMiddleX && !(bottomLeftO))
			{bottomLeftO = true; bottomLeft.setIcon(O); turnX = true; turnO = false; return;}
		//no wins to block so
		//pick a spot
		int advancedMove = 0;
		advancedMove = (int) (Math.random()*9);
		
		switch(advancedMove)
		{
		case 0:
			if(!(topLeftX || topLeftO))
				{
				topLeftO = true;
				topLeft.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
			
			else 
				break;
		case 1:
			if(!(topMiddleX || topMiddleO))
			{
				topMiddleO = true;
				topMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
		case 2:
			if(!(topRightX || topRightO))
			{
				topRightO = true;
				topRight.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
			
		case 3:
			if(!(middleLeftX || middleLeftO))
			{
				middleLeftO = true;
				middleLeft.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
			
		case 4:
			if(!(middleMiddleX || middleMiddleO))
			{
				middleMiddleO = true;
				middleMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
			
		case 5:
			if(!(middleRightX || middleRightO))
				{
				middleRightO = true;
				middleRight.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
			
			else 
				break;
			
		case 6:
			if(!(bottomLeftX || bottomLeftO))
				{
				bottomLeftO = true;
				bottomLeft.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
			
			else 
				break;
		case 7:
			if(!(bottomMiddleX || bottomMiddleO))
				{
				bottomMiddleO = true;
				bottomMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
		
			else 
				break;
		case 8:
			if(!(bottomRightX || bottomRightO))
				{
				bottomRightO = true;
				bottomRight.setIcon(O);
				turnX = true;
				turnO = false;
				break;
			}
			
			else 
				break;
			}
		}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
	if(!(beginner.isSelected() || advanced.isSelected()))
			return;
	if(ae.getSource() == topLeft)
		{
		if(!(topLeftX || topLeftO))
			{
			if(turnX)
				{
				topLeftX = true;
				topLeft.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				topLeftO = true;
				topLeft.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}
	
	if(ae.getSource() == topMiddle)
		{
		if(!(topMiddleX || topMiddleO))
			{
			if(turnX)
				{
				topMiddleX = true;
				topMiddle.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				topMiddleO = true;
				topMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}
	
	if(ae.getSource() == topRight)
		{
		if(!(topRightX || topRightO))
			{
			if(turnX)
				{
				topRightX = true;
				topRight.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				topRightO = true;
				topRight.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}
	
	if(ae.getSource() == middleLeft)
		{
		if(!(middleLeftX || middleLeftO))
			{
			if(turnX)
				{
				middleLeftX = true;
				middleLeft.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				middleLeftO = true;
				middleLeft.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}
	
	if(ae.getSource() == middleMiddle)
		{
		if(!(middleMiddleX || middleMiddleO))
			{
			if(turnX)
				{
				middleMiddleX = true;
				middleMiddle.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				middleMiddleO = true;
				middleMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}

	if(ae.getSource() == middleRight)
		{
		if(!(middleRightX || middleRightO))
			{
			if(turnX)
				{
				middleRightX = true;
				middleRight.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				middleRightO = true;
				middleRight.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}
	
	if(ae.getSource() == bottomLeft)
		{
		if(!(bottomLeftX || bottomLeftO))
			{
			if(turnX)
				{
				bottomLeftX = true;
				bottomLeft.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				bottomLeftO = true;
				bottomLeft.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}
	
	if(ae.getSource() == bottomMiddle)
		{
		if(!(bottomMiddleX || bottomMiddleO))
			{
			if(turnX)
				{
				bottomMiddleX = true;
				bottomMiddle.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				bottomMiddleO = true;
				bottomMiddle.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}
	
	if(ae.getSource() == bottomRight)
		{
		if(!(bottomRightX || bottomRightO))
			{
			if(turnX)
				{
				bottomRightX = true;
				bottomRight.setIcon(X);
				turnX = false;
				turnO = true;
				}
			else
				{
				bottomRightO = true;
				bottomRight.setIcon(O);
				turnX = true;
				turnO = false;
				}
			}
		}
	if(ae.getSource() == restartButton)
		{
		board.dispose();
		new TicTacToeAI(xScore, oScore);
	}
	}
}
	
