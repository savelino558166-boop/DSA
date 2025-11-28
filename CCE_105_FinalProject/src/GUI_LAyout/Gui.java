package GUI_Layout;
import java.awt.*;
import Solution.Solve;
import javax.swing.*;

public class Gui {
    public static void Page() {

        JFrame frame = new JFrame();
        frame.setTitle("House Robber");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 500);
        
        frame.setLayout(null);
        
        JLabel lblinput = new JLabel();
        JLabel lbloutput = new JLabel();
        JLabel lblWelcome = new JLabel();
        JTextField txtInput = new JTextField();
        JTextField txtOutput = new JTextField();
        JButton btnCalc = new JButton();
        
        lblWelcome.setText("House Robber System");
        lblWelcome.setFont(new Font("Kefa", Font.BOLD, 35));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblinput.setText("Input house values | eg: 5,2,3,...");
        lblinput.setFont(new Font("Kefa", Font.PLAIN, 13));
        
        lbloutput.setText("Maximum Amount:");
        lbloutput.setFont(new Font("Kefa", Font.PLAIN, 13));
        
        txtOutput.setEditable(false);
        
        btnCalc.setText("Calculate");
        btnCalc.setFont(new Font("Kefa", Font.PLAIN, 13));
        
        lblWelcome.setBounds(150, 30, 500, 50);
        txtInput.setBounds(150, 100, 500, 30);
        lblinput.setBounds(150, 130, 500, 30);
        lbloutput.setBounds(150, 200, 150, 30);
        txtOutput.setBounds(300, 200, 150, 30);
        btnCalc.setBounds(570, 350, 100, 30);
        
        btnCalc.addActionListener(e -> {
            String input = txtInput.getText();

            if (!input.trim().isEmpty()) {
                try {
                    String[] values = input.split(",");
                    int[] houses = new int[values.length];

                    for (int i = 0; i < values.length; i++) {
                        houses[i] = Integer.parseInt(values[i].trim());
                    }

                    Solve solver = new Solve();
                    int result = solver.rob(houses);

                    txtOutput.setText(String.valueOf(result));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers separated by commas!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter house values!");
            }
        });
		
        frame.add(lblWelcome);
        frame.add(txtInput);
        frame.add(lblinput);
        frame.add(lbloutput);
        frame.add(txtOutput);
        frame.add(btnCalc);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Page();
        });
    }
}
