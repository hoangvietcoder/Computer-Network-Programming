import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BT3 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPortNumber;
	private JTextField textFieldResult;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT3 frame = new BT3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BT3() {
		setTitle("RandomPort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Port Number: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(42, 44, 119, 28);
		contentPane.add(lblNewLabel);
		
		textFieldPortNumber = new JTextField();
		textFieldPortNumber.setText("0");
		textFieldPortNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPortNumber.setBounds(182, 41, 365, 40);
		contentPane.add(textFieldPortNumber);
		textFieldPortNumber.setColumns(10);
		
		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldResult.setBounds(182, 224, 365, 40);
		contentPane.add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int portNumber = Integer.parseInt(textFieldPortNumber.getText());
				
				try {
					ServerSocket server = new ServerSocket(portNumber);
					textFieldResult.setText("" + server.getLocalPort());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Port already in use.", "IOException", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(305, 129, 124, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblResult.setBounds(42, 227, 71, 28);
		contentPane.add(lblResult);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setBounds(304, 312, 124, 50);
		contentPane.add(btnBack);
	}

}
