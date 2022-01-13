import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Enumeration_GetNetworkInterfaces extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enumeration_GetNetworkInterfaces window = new Enumeration_GetNetworkInterfaces();
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
	public Enumeration_GetNetworkInterfaces() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("GetNetWorkInterface");
		this.setBounds(100, 100, 760, 623);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JTextArea textAreaListInterface = new JTextArea();
		textAreaListInterface.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaListInterface.setBounds(141, 117, 535, 322);
		this.getContentPane().add(textAreaListInterface);
		
		JScrollPane scrollPane = new JScrollPane(textAreaListInterface, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(141, 117, 535, 322);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
				try {
					Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
					while(interfaces.hasMoreElements()) {
						NetworkInterface interfacesName = interfaces.nextElement();
						result += interfacesName + "\n";
					}
					textAreaListInterface.setText(result);
				} catch (SocketException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(340, 41, 121, 45);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("List Interface:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 280, 121, 21);
		this.getContentPane().add(lblNewLabel);
		
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
		btnNewButton_1.setBounds(340, 477, 133, 45);
		getContentPane().add(btnNewButton_1);
		
	}
}
