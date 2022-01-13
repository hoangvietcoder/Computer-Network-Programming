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
public class InetAddress_GetAllByName extends JFrame {

	private JTextField textFieldAddress;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InetAddress_GetAllByName window = new InetAddress_GetAllByName();
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
	public InetAddress_GetAllByName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("GetAllByName");
		this.setBounds(100, 100, 586, 419);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Enter HostName:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 26, 151, 32);
		this.getContentPane().add(lblNewLabel);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setText("microsoft.com");
		textFieldAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldAddress.setBounds(171, 29, 246, 32);
		this.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(171, 153, 246, 117);
		this.getContentPane().add(textAreaResult);
		
		btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostName = textFieldAddress.getText();
				String temp = "";
				try {
					InetAddress[] addresses = InetAddress.getAllByName(hostName);
					for(int  i = 0; i < addresses.length; i++) {
						temp += i + 1 + ". " + addresses[i] + "\n";
					}
					textAreaResult.setText(temp);
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + hostName, "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(237, 85, 114, 44);
		this.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("IP Addresses:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 198, 114, 32);
		this.getContentPane().add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(237, 300, 114, 44);
		getContentPane().add(btnNewButton_1);
		
	}
}
