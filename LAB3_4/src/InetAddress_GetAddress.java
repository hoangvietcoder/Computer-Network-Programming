import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InetAddress_GetAddress extends JFrame {

	private JTextField textFieldHostName;
	private JTextField textFieldResult;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InetAddress_GetAddress window = new InetAddress_GetAddress();
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
	public InetAddress_GetAddress() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("GetAddress");
		this.setBounds(100, 100, 573, 359);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter HostName:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 36, 151, 35);
		this.getContentPane().add(lblNewLabel);
		
		textFieldHostName = new JTextField();
		textFieldHostName.setText("google.com.vn");
		textFieldHostName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHostName.setBounds(171, 38, 255, 35);
		this.getContentPane().add(textFieldHostName);
		textFieldHostName.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostName = textFieldHostName.getText();
				String temp = "";
				try {
					InetAddress address = InetAddress.getByName(hostName);
					byte[] getAddress = address.getAddress(); 
					if(getAddress.length == 4) {
						temp = "The IP Version is 4"; 
					}
					else if(getAddress.length == 6){
						temp = "The IP Version is 6"; 
					}
					textFieldResult.setText(temp);
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + hostName, "Message", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(243, 103, 111, 45);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 173, 105, 35);
		this.getContentPane().add(lblNewLabel_1);
		
		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldResult.setBounds(171, 175, 255, 35);
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
		btnNewButton_1.setBounds(243, 238, 111, 45);
		getContentPane().add(btnNewButton_1);
	}

}
