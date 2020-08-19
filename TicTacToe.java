import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener, Runnable {	
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
	private JLabel xScoreLabel = new JLabel("X score = " + xScore);
	private JLabel oScoreLabel = new JLabel("O Score = " + oScore);
	private JPanel firstPanel = new JPanel();
	private JPanel secondPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	
	
	public static void main(String[] args) 
	{
	new TicTacToe(xScore, oScore);
	}
	
	
	
	public TicTacToe(int xScore, int oScore) 
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
    mainPanel.add(firstPanel);
    mainPanel.add(secondPanel);
    board.add(mainPanel);
    board.setSize(300,300);
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
		//System.out.println("");
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
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
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
		new TicTacToe(xScore, oScore);
	}
	}
}
	
