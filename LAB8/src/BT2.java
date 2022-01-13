import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BT2 extends JFrame {

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
					BT2 frame = new BT2();
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
	public BT2() {
		setTitle("getInetAddress");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Port Number: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(42, 44, 119, 28);
		contentPane.add(lblNewLabel);
		
		textFieldPortNumber = new JTextField();
		textFieldPortNumber.setText("80");
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
					InetAddress ia = server.getInetAddress();
					
					textFieldResult.setText("" + ia);
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
		btnBack.setBounds(310, 309, 124, 50);
		contentPane.add(btnBack);

	}

}
