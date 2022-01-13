import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BT2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLocalHost;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT2 frame = new BT2();
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
	public BT2() {
		setTitle("HighPortScanner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 499);
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
		textFieldLocalHost.setBounds(150, 46, 384, 35);
		contentPane.add(textFieldLocalHost);
		textFieldLocalHost.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 255, 120, 36);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(150, 204, 384, 141);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(150, 204, 384, 141);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String getLocalHost = textFieldLocalHost.getText();
				String result = "";
				
				try {
					InetAddress inet = InetAddress.getByName(getLocalHost);
					for(int i = 1024; i < 65536; i++) {
						try {
							Socket s = new Socket(inet, i);
							result += "There is a server on port " + i + " of local host" + "\n";
						} catch(IOException e1) {
							textAreaResult.setText("Connect is refused");
						}
					}
				}catch(UnknownHostException e1){
					System.err.println(e1);
				}
				textAreaResult.setText(result);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(284, 122, 120, 48);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(284, 382, 120, 48);
		contentPane.add(btnBack);
	}

}
