import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class NetworkInterface_GetByInetAddress extends JFrame {

	private JTextField textFieldIP;
	private JTextField textFieldResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetworkInterface_GetByInetAddress window = new NetworkInterface_GetByInetAddress();
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
	public NetworkInterface_GetByInetAddress() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("GetByInetAddress");
		this.setBounds(100, 100, 576, 359);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter IP:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 45, 92, 21);
		this.getContentPane().add(lblNewLabel);
		
		textFieldIP = new JTextField();
		textFieldIP.setText("127.0.0.1");
		textFieldIP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldIP.setBounds(139, 41, 287, 34);
		this.getContentPane().add(textFieldIP);
		textFieldIP.setColumns(10);
		
		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldResult.setBounds(139, 183, 287, 34);
		this.getContentPane().add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getIP = textFieldIP.getText();
				try {
					InetAddress ipAddress = InetAddress.getByName(getIP);
					NetworkInterface interfaceAddress = NetworkInterface.getByInetAddress(ipAddress);
					if(interfaceAddress == null) {
						textFieldResult.setText("That's weird. No local loopback address.");
					}
					else {
						textFieldResult.setText("" + interfaceAddress);
					}
					
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "That's weird. Could not lookup " + getIP, "Message",
							JOptionPane.ERROR_MESSAGE);
				} catch (SocketException e1) {
					JOptionPane.showMessageDialog(null, "Could not list network interfaces.", "Message",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(227, 109, 112, 45);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 189, 57, 21);
		this.getContentPane().add(lblNewLabel_1);
		
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
		btnNewButton_1.setBounds(227, 251, 112, 45);
		getContentPane().add(btnNewButton_1);
	}

}
