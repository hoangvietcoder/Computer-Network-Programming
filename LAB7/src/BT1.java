import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BT1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLocalHost;
	private JLabel lblNewLabel_1;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT1 frame = new BT1();
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
	public BT1() {
		setTitle("LowPortScanner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Local Host:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 43, 120, 36);
		contentPane.add(lblNewLabel);
		
		textFieldLocalHost = new JTextField();
		textFieldLocalHost.setText("localhost");
		textFieldLocalHost.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldLocalHost.setBounds(150, 46, 431, 35);
		contentPane.add(textFieldLocalHost);
		textFieldLocalHost.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 254, 120, 36);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(150, 204, 431, 137);
		contentPane.add(textAreaResult);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String getLocalHost = textFieldLocalHost.getText();
				String result = "";
				for(int i = 1; i < 1024; i++) {
					try {
						Socket s = new Socket(getLocalHost, i);
						result += "There is a server on port " + i + " of local host" + "\n";
					} catch (UnknownHostException e1) {
						System.err.println(e1);
						break;
					} catch (IOException e1) {
						textAreaResult.setText("Connect is refused");
					}
				}
				textAreaResult.setText(result);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(304, 123, 120, 48);
		contentPane.add(btnNewButton);
		
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
		btnBack.setBounds(304, 372, 120, 48);
		contentPane.add(btnBack);
	}
}
