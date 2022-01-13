import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class NetworkInterface_GetByName extends JFrame {

	private JTextField textFieldInterfaceName;
	private JTextField textFieldResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetworkInterface_GetByName window = new NetworkInterface_GetByName();
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
	public NetworkInterface_GetByName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("GetByName");
		this.setBounds(100, 100, 636, 363);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Interface Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 45, 183, 21);
		this.getContentPane().add(lblNewLabel);
		
		textFieldInterfaceName = new JTextField();
		textFieldInterfaceName.setText("eth0");
		textFieldInterfaceName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldInterfaceName.setBounds(215, 41, 327, 34);
		this.getContentPane().add(textFieldInterfaceName);
		textFieldInterfaceName.setColumns(10);
		
		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldResult.setBounds(215, 180, 327, 34);
		this.getContentPane().add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getInterfaceName = textFieldInterfaceName.getText();
				try {
					NetworkInterface networkInterface = NetworkInterface.getByName(getInterfaceName);
					if(networkInterface == null) {
						textFieldResult.setText("No such interface: " + getInterfaceName);
					}
					else {
						textFieldResult.setText("" + networkInterface);
					}
				} catch (SocketException e1) {
					textFieldResult.setText("Could not list sockets." );
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(317, 105, 114, 45);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 184, 62, 21);
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
		btnNewButton_1.setBounds(317, 248, 114, 45);
		getContentPane().add(btnNewButton_1);
		
	}

}
