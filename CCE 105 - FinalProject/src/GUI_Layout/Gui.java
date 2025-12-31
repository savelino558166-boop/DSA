package GUI_Layout;

import java.awt.*;
import javax.swing.*;
import Solution.Solve;

public class Gui {

    public static void Page() {
        JFrame frame = new JFrame();
        frame.setTitle("House Robber (Proposed)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 500);
        frame.setLayout(null);

        JLabel lblinput = new JLabel();
        JLabel lbloutput = new JLabel();
        JLabel lblWelcome = new JLabel();
        JLabel lblProcessingTime = new JLabel();
        JTextField txtInput = new JTextField();
        JTextField txtOutput = new JTextField();
        JTextField txtProcessingTime = new JTextField();
        JButton btnCalc = new JButton();

        lblWelcome.setText("House Robber System");
        lblWelcome.setFont(new Font("Kefa", Font.BOLD, 30));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);

        lblinput.setText("Input house values | eg: 5,2,3,...");
        lblinput.setFont(new Font("Kefa", Font.PLAIN, 13));

        lbloutput.setText("Maximum Amount:");
        lbloutput.setFont(new Font("Kefa", Font.PLAIN, 13));

        lblProcessingTime.setText("Processing Time (nanoseconds):");
        lblProcessingTime.setFont(new Font("Kefa", Font.PLAIN, 13));

        txtOutput.setEditable(false);
        txtProcessingTime.setEditable(false);

        btnCalc.setText("Calculate");
        btnCalc.setFont(new Font("Kefa", Font.PLAIN, 13));

        lblWelcome.setBounds(120, 30, 600, 50);
        txtInput.setBounds(150, 100, 500, 30);
        lblinput.setBounds(150, 130, 500, 30);
        lbloutput.setBounds(150, 200, 150, 30);
        txtOutput.setBounds(300, 200, 150, 30);

        // ⬇️ Processing time bottom-left
        lblProcessingTime.setBounds(20, 400, 250, 30);
        txtProcessingTime.setBounds(250, 400, 200, 30);

        btnCalc.setBounds(570, 350, 100, 30);

        frame.add(lblWelcome);
        frame.add(txtInput);
        frame.add(lblinput);
        frame.add(lbloutput);
        frame.add(txtOutput);
        frame.add(lblProcessingTime);
        frame.add(txtProcessingTime);
        frame.add(btnCalc);

        btnCalc.addActionListener(e -> {
            try {
                String input = txtInput.getText().trim();

                if (input.isEmpty()) {
                    txtOutput.setText("0");
                    txtProcessingTime.setText("0");
                    return;
                }

                String[] parts = input.split(",");
                int[] nums = new int[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    nums[i] = Integer.parseInt(parts[i].trim());
                }

                Solve solver = new Solve();

                long start = System.nanoTime();
                int result = solver.rob(nums);
                long end = System.nanoTime();

                txtOutput.setText(String.valueOf(result));
                txtProcessingTime.setText(String.valueOf(end - start));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input! Use: 5,2,3,9");
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Gui::Page);
    }
}