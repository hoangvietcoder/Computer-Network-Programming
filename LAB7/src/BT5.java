import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BT5 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textFieldPort;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT5 frame = new BT5();
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
	public BT5() {
		setTitle("getLocalPort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter URL:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 43, 120, 36);
		contentPane.add(lblNewLabel);
		
		textFieldURL = new JTextField();
		textFieldURL.setText("dantri.com.vn");
		textFieldURL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL.setBounds(151, 45, 280, 35);
		contentPane.add(textFieldURL);
		textFieldURL.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 254, 120, 36);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(150, 204, 507, 141);
		contentPane.add(textAreaResult);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String getURL = textFieldURL.getText();
				int getPort = Integer.parseInt(textFieldPort.getText());
				try {
					Socket s = new Socket(getURL, getPort);
					int localPort = s.getLocalPort();
					textAreaResult.setText("Connecting from local port: " + localPort);
				} catch (IOException e1) {
					textAreaResult.setText("Connect is refused");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(349, 122, 120, 48);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Port:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(487, 43, 50, 36);
		contentPane.add(lblNewLabel_2);
		
		textFieldPort = new JTextField();
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPort.setText("80");
		textFieldPort.setBounds(547, 45, 106, 35);
		contentPane.add(textFieldPort);
		textFieldPort.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(349, 380, 120, 48);
		contentPane.add(btnBack);
	}

}
