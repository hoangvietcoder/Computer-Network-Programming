import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InetAddress_AddressTypes extends JFrame {

	private JTextField textFieldHostName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InetAddress_AddressTypes window = new InetAddress_AddressTypes();
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
	public InetAddress_AddressTypes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("AddressTypes");
		this.setBounds(100, 100, 598, 453);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter HostName:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 38, 153, 31);
		this.getContentPane().add(lblNewLabel);
		
		textFieldHostName = new JTextField();
		textFieldHostName.setText("facebook.com");
		textFieldHostName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHostName.setBounds(173, 40, 348, 31);
		this.getContentPane().add(textFieldHostName);
		textFieldHostName.setColumns(10);
		
		
		JTextArea textAreaAddressTypes = new JTextArea();
		textAreaAddressTypes.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaAddressTypes.setBounds(173, 170, 348, 134);
		this.getContentPane().add(textAreaAddressTypes);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostName = textFieldHostName.getText();
				String result = "";
				try {
					InetAddress address = InetAddress.getByName(hostName);
					if(address.isAnyLocalAddress()) {
						result += address + "is a wildcard address. \n"; 
					}
					if(address.isLoopbackAddress()) {
						result += address + " is the loopback address. \n";
					}
					if(address.isLinkLocalAddress()) {
						result += address + " is an IPv6 link-local address. \n";
					}
					else if(address.isSiteLocalAddress()) {
						result += address + " is an IPv6 site-local address. \n";
					}
					else {
						result += address + " is a global address. \n";
					}
					
					if(address.isMulticastAddress()) {
						if(address.isMCGlobal()) {
							result += address + "is a global multicast address. \n";
						}
						else if(address.isMCNodeLocal()) {
							result += address + " is an interface-local multicast address. \n";
						}
						else if(address.isMCLinkLocal()) {
							result += address + " is a subnet-wide multicast address. \n";
						}
						else if(address.isMCSiteLocal()) {
							result += address + " is a site-wide multicast address. \n";
						}
						else if(address.isMCOrgLocal()) {
							result += address + " is an organization-wide multicast address. \n";
						}
						else {
							result += address + " is an unknown multicast address type. \n";
						}
					}
					else {
						result += address + " is a unicast address.";
				      }
					
					textAreaAddressTypes.setText(result);
					
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + hostName, "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(289, 99, 117, 45);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Address Types:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 219, 127, 31);
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
		btnNewButton_1.setBounds(289, 334, 117, 45);
		getContentPane().add(btnNewButton_1);
		
	}
}
