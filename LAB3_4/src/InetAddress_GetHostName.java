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
public class InetAddress_GetHostName extends JFrame {

	private JTextField textFieldHostName;
	private JTextField textFieldResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InetAddress_GetHostName window = new InetAddress_GetHostName();
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
	public InetAddress_GetHostName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("GetHostName");
		this.setBounds(100, 100, 555, 347);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter HostName:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 36, 151, 35);
		this.getContentPane().add(lblNewLabel);
		
		textFieldHostName = new JTextField();
		textFieldHostName.setText("192.168.137.1");
		textFieldHostName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHostName.setBounds(171, 38, 255, 35);
		this.getContentPane().add(textFieldHostName);
		textFieldHostName.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostName = textFieldHostName.getText();
				try {
					InetAddress address = InetAddress.getByName(hostName);
					String temp = address.getHostName();
					textFieldResult.setText(temp);
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + hostName, "Message", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(239, 105, 113, 45);
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
		btnNewButton_1.setBounds(239, 237, 113, 45);
		getContentPane().add(btnNewButton_1);
	}

}
