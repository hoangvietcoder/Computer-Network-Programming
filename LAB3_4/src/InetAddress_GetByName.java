import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InetAddress_GetByName extends JFrame {

	private JTextField textFieldAddress;
	private JTextField textFieldResult;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InetAddress_GetByName window = new InetAddress_GetByName();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public InetAddress_GetByName() {
		this.setTitle("GetByName");
		this.setBounds(100, 100, 472, 338);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter HostName:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 33, 156, 21);
		this.getContentPane().add(lblNewLabel);

		textFieldAddress = new JTextField();
		textFieldAddress.setText("youtube.com");
		textFieldAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldAddress.setBounds(176, 30, 235, 29);
		this.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);

		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostName = textFieldAddress.getText();
				try {
					InetAddress address = InetAddress.getByName(hostName);
					textFieldResult.setText("" + address);
				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + hostName, "Message",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(234, 96, 112, 45);
		this.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 168, 63, 19);
		this.getContentPane().add(lblNewLabel_1);

		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldResult.setBounds(176, 164, 235, 29);
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
		btnNewButton_1.setBounds(234, 226, 112, 45);
		getContentPane().add(btnNewButton_1);
	}
}
