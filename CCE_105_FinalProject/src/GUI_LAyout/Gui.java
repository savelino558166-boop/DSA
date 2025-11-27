package GUI_LAyout;
import Solution.Solve;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Gui {
	static String DELIMETER = ",";

	public static void Page () {
	
	// Window
	JFrame frame = new JFrame();
	frame.setTitle("House Robber");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setSize(800, 500);
	frame.setVisible(true);
	
	frame.setLocationRelativeTo(null);
		
	// Initialization
	JLabel lblinput = new JLabel();
	JLabel lbloutput = new JLabel();
	JLabel lblWelcome = new JLabel();
	JTextField txtInput = new JTextField();
	JTextField txtOutput = new JTextField();
	JButton btnCalc = new JButton();
	
	
	// Customize
	
	
	lblWelcome.setText("House Robber System");
	lblWelcome.setFont(new Font("Kefa",Font.BOLD,50));
	
	lblinput.setText("input houses values| eg:(5, 2, 3,...)");
	lblinput.setFont(new Font("Kefa",Font.PLAIN,13));
	
	lbloutput.setText("output");
	lbloutput.setFont(new Font("Kefa",Font.PLAIN,13));
	
	txtOutput.setEditable(false);
	
	btnCalc.setText("Calculate");
	btnCalc.setFont(new Font("Kefa", Font.PLAIN,13));
	
	
	
	
	// Adding
	frame.add(lblWelcome).setBounds(150, 30, 550, 59);
	frame.add(txtInput).setBounds(150, 100, 500, 30);
	frame.add(lblinput).setBounds(275, 120, 210, 30);
	frame.add(txtOutput).setBounds(150, 230, 150, 30);
	frame.add(lbloutput).setBounds(200, 250, 200, 30);
	frame.add(btnCalc).setBounds(570, 350, 100, 30);
	
	btnCalc.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Solve system = new Solve();
			String inputValues = txtInput.getText();
			String[] gettingValue = inputValues.split(DELIMETER);
			int[] store = new int[gettingValue.length];
			
			try {
				
				for (int Values = 0; Values < gettingValue.length ; Values++) {
					store[Values] = Integer.parseInt(gettingValue[Values]);
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Input Unrecognized, Try Again");
			}
			txtOutput.setText(system.rob(store));
		}
	});
	
	
	
	}

	public static void main(String[] args) {

		Page();
		
		
	}
}
