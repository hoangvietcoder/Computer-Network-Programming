import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InetAddress_BooleanEquals extends JFrame{

	private JTextField textFieldAddress1;
	private JTextField textFieldAddress2;
	private JTextField textFieldResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InetAddress_BooleanEquals window = new InetAddress_BooleanEquals();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InetAddress_BooleanEquals() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("BooleanEquals");
		this.setBounds(100, 100, 629, 419);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Address 1:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 32, 136, 27);
		this.getContentPane().add(lblNewLabel);
		
		textFieldAddress1 = new JTextField();
		textFieldAddress1.setText("facebook.com");
		textFieldAddress1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldAddress1.setBounds(166, 31, 334, 34);
		this.getContentPane().add(textFieldAddress1);
		textFieldAddress1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Address 2:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 94, 136, 21);
		this.getContentPane().add(lblNewLabel_1);
		
		textFieldAddress2 = new JTextField();
		textFieldAddress2.setText("instagram.com");
		textFieldAddress2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldAddress2.setBounds(166, 90, 334, 34);
		this.getContentPane().add(textFieldAddress2);
		textFieldAddress2.setColumns(10);
		
		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldResult.setBounds(166, 230, 334, 34);
		this.getContentPane().add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getAddress1 = textFieldAddress1.getText();
				String getAddress2 = textFieldAddress2.getText();
				
				try {
					InetAddress address1 = InetAddress.getByName(getAddress1);
					InetAddress address2 = InetAddress.getByName(getAddress2);
					
					if(address1.equals(address2)) {
						textFieldResult.setText(address1.getHostName() + " is the same as " + address2.getHostName());
					}
					else {
						textFieldResult.setText(address1.getHostName() + " is not the same as " + address2.getHostName());
					}
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "Host lookup failed.", "Message", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(273, 154, 120, 45);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Result:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 234, 57, 21);
		this.getContentPane().add(lblNewLabel_2);
		
		textFieldResult = new JTextField();
		textFieldResult.setBounds(166, 230, 334, 34);
		this.getContentPane().add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(273, 297, 120, 45);
		getContentPane().add(btnNewButton_1);
	}
}
