package lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dice extends JFrame implements ActionListener{
	
	//NORTH
	JLabel heading;
	
	//WEST
	JPanel west = new JPanel();
	
	JLabel Cash_Available;
	int Cash_Available_Int = 1000;
	JTextField Cash_Remain;
	
	//EAST
	JPanel east = new JPanel();
	
	JButton Cash_Out;
	String[] SelectCash = {"Quick Bet", "$100", "$350", "$500"};
	JComboBox Cash_ComboBox = new JComboBox(SelectCash);
	
	//SOUTH
	JPanel result = new JPanel();
	
	JLabel notice1;
	JButton Roll_Dice;
	JLabel notice2;
	
	//CENTER
	JPanel game = new JPanel();
	JPanel dice = new JPanel(); //JPanel that will be included in JPanel <game>
	
	JButton dice1; //Will be included in JPanel <dice>
	JButton dice2; //Will be included in JPanel <dice>
	JButton dice3; //Will be included in JPanel <dice>
	
	JLabel bet; //Will be included in JPanel <game>
	JTextField Bet_Cash; //Will be included in JPanel <game>
	String Bet_String; //Will be included in JPanel <game>
	
	int Bet_Int; //Betting money, typed by User (parsed from String)
	int Bet_Int_Combo; //Betting money, chose by User through ComboBox
	
	public Dice()
	{
		super("Casino Simulator");
		
		setSize(450, 200); //set size of window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when user click 'x' button, the window is closed in the background
		setLocationRelativeTo(null); //set window to pop up on the center of the screen
		
		setLayout(new BorderLayout()); //use BorderLayout in this JFrame <Dice>
		
		//NORTH
		heading = new JLabel("Welcome To The High Roller Game");
		heading.setFont(new Font("Arial", Font.BOLD, 26));
		
		//WEST
		west.setLayout(new GridLayout(2,1,5,5)); //use GridLayout in <west> JPanel
		
		Cash_Available = new JLabel("Cash Available");
		Cash_Available.setFont(new Font("Arial", Font.BOLD, 18));
		
		Cash_Remain = new JTextField("$" + Cash_Available_Int);
		Cash_Remain.setFont(new Font("Arial", Font.PLAIN, 14));
		Cash_Remain.setEditable(false);		
		
		west.add(Cash_Available);
		west.add(Cash_Remain);
		
		//EAST
		east.setLayout(new GridLayout(2,1,5,5)); //use GridLayout in <east> JPanel
		
		Cash_Out = new JButton("Cash Out");
		Cash_Out.setFont(new Font("Arial", Font.BOLD ,14));
				
		east.add(Cash_Out);
		east.add(Cash_ComboBox);
		
		//SOUTH
		result.setLayout(new GridLayout(1,3,2,2)); //use GridLayout in <result> JPanel
		
		notice1 = new JLabel();
		notice1.setFont(new Font("Arial", Font.BOLD, 14));
		
		Roll_Dice = new JButton("Roll Dice");
		Roll_Dice.setFont(new Font("Arial", Font.BOLD, 14));
		
		notice2 = new JLabel();
		notice2.setFont(new Font("Arial", Font.BOLD, 14));
		
		result.add(notice1);
		result.add(Roll_Dice);
		result.add(notice2);
		
		//CENTER
		game.setLayout(new FlowLayout()); //use FlowLayout in <game> JPanel
		dice.setLayout(new FlowLayout()); //use FlowLayout in <dice> JPanel
		
		dice1 = new JButton("D1");
		dice1.setFont(new Font("Arial", Font.BOLD, 14));
		
		dice2 = new JButton("D2");
		dice2.setFont(new Font("Arial", Font.BOLD, 14));
		
		dice3 = new JButton("D3");
		dice3.setFont(new Font("Arial", Font.BOLD, 14));
		
		bet = new JLabel("Place Your Bet");
		bet.setFont(new Font("Arial", Font.BOLD, 14));
		
		Bet_Cash = new JTextField(12);
				
		dice.add(dice1);
		dice.add(dice2);
		dice.add(dice3);
		game.add(dice); //add JPanel <dice> to the JPanel <game>
		game.add(bet);
		game.add(Bet_Cash);
		
		add(heading, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		add(result, BorderLayout.SOUTH);
		add(game, BorderLayout.CENTER);
		
		Roll_Dice.addActionListener(this);
		Bet_Cash.addActionListener(this);
		Cash_ComboBox.addActionListener(this);
		Cash_Out.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) //set action
	{
		Object source1 = e.getSource(); //let actions know which button is clicked
		
		try {
		Bet_String = Bet_Cash.getText(); //get betting money from JTextField <Bet_Cash>
		Bet_Int = Integer.parseInt(Bet_String); //change String into Int to calculate
		
		}catch(Exception ex) //exception
		{

		}
		
		
		if(source1 == Roll_Dice) //set action for JButton <Roll_Dice>
		{
			if(Bet_Int>Cash_Available_Int)
			{
			notice1.setText("Insuffieicent Funds");
			}else {
		
				int dice_result_1 = (int)(Math.random() * 6) + 1;
				int dice_result_2 = (int)(Math.random() * 6) + 1;
				int dice_result_3 = (int)(Math.random() * 6) + 1;
				//set random number in each dice
				
				dice1.setText(""+dice_result_1);
				dice2.setText(""+dice_result_2);
				dice3.setText(""+dice_result_3);
				//print random number of each dice on JLabel <dice1, dice2, dice3>
				
				if(dice_result_1!=dice_result_2&&dice_result_2!=dice_result_3&&dice_result_3!=dice_result_1)
				{
					notice1.setText("LOSER");
					notice2.setText("Better luck next time.");
					Cash_Available_Int = Cash_Available_Int - Bet_Int;
					Cash_Remain.setText(""+Cash_Available_Int);
				}else if(dice_result_1==dice_result_2&&dice_result_2==dice_result_3&&dice_result_3==dice_result_1)
				{
					notice1.setText("WINNER");
					notice2.setText("Three of a Kind!");
					Cash_Available_Int = Cash_Available_Int + (Bet_Int * Bet_Int);
					Cash_Remain.setText(""+Cash_Available_Int);
				}else
				{
					notice1.setText("WINNER");
					notice2.setText("Two Pair!");
					Cash_Available_Int = Cash_Available_Int + Bet_Int;
					Cash_Remain.setText(""+Cash_Available_Int);
				}
				//set Winning situation, and Losing situation
				
				if(Cash_Available_Int == 0)
				{
					Cash_Out.setText("Exit");
					if(source1 == Cash_Out)
					{
						System.exit(0);
					}
				} 
				//change text of JButton <Cash_Out> into "Exit" if Available cash is $0
				//set JFrame close if User click JButton <Cash_Out> which is now changed into "Exit" Button
			}
		}else if(source1 == Cash_ComboBox)
		{
			int selected = Cash_ComboBox.getSelectedIndex(); //get information about which index of ComboBox is selected
			if(selected == 1) //if index 1 <$100> is selected
			{
				Bet_Cash.setText("100"); //change text of JTextField <Bet_Cash> into "100"
				Bet_Int = 100;
			}else if(selected == 2) //if index 2 <$350> is selected
			{
				Bet_Cash.setText("350"); //change text of JTextField <Bet_Cash> into "350"
				Bet_Int = 350;
			}else if(selected == 3) //if index 3 <$500> is selected
			{
				Bet_Cash.setText("500"); //change text of JTextField <Bet_Cash> into "500"
				Bet_Int = 500;
			}
		}else if(source1 == Cash_Out)
		{
			System.exit(0);
		} //set JFrame close if User click JButton <Cash_Out>
	}
}