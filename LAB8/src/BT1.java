import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BT1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldStartPort;
	private JTextField textFieldEndPort;

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
		setTitle("LocalPortScanner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start Port: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(23, 33, 98, 32);
		contentPane.add(lblNewLabel);
		
		textFieldStartPort = new JTextField();
		textFieldStartPort.setText("1");
		textFieldStartPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldStartPort.setBounds(131, 31, 140, 39);
		contentPane.add(textFieldStartPort);
		textFieldStartPort.setColumns(10);
		
		JLabel lblEndPort = new JLabel("End Port:");
		lblEndPort.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEndPort.setBounds(336, 33, 98, 32);
		contentPane.add(lblEndPort);
		
		textFieldEndPort = new JTextField();
		textFieldEndPort.setText("65535");
		textFieldEndPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldEndPort.setColumns(10);
		textFieldEndPort.setBounds(443, 31, 140, 39);
		contentPane.add(textFieldEndPort);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(131, 204, 452, 172);
		contentPane.add(textAreaResult);
		
		
		JButton btnNewButton = new JButton("Click here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int startPort = Integer.parseInt(textFieldStartPort.getText());
				int endPort = Integer.parseInt(textFieldEndPort.getText());

				String result = "";
				
				for(int port = startPort; port <= endPort; port++) {
					try {
						ServerSocket server = new ServerSocket(port);
					} catch (IOException e1) {
						result += "There is a server on port " + port + "\n";
					}
				}
				textAreaResult.setText(result);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(291, 108, 121, 50);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(131, 204, 452, 172);
		contentPane.add(scrollPane);
		
		JLabel lblResult = new JLabel("Result: ");
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblResult.setBounds(23, 275, 98, 32);
		contentPane.add(lblResult);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(292, 420, 121, 50);
		contentPane.add(btnNewButton_1);
	}
}
