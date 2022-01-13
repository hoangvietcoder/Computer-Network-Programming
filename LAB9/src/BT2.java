import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.SocketException;

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
	private JTextField textFieldStart;
	private JTextField textFieldEnd;

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
		setTitle("Look For Local UDP Ports");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start Port:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 33, 108, 35);
		contentPane.add(lblNewLabel);
		
		textFieldStart = new JTextField();
		textFieldStart.setText("1024");
		textFieldStart.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldStart.setBounds(128, 31, 100, 40);
		contentPane.add(textFieldStart);
		textFieldStart.setColumns(10);
		
		JLabel lblPort = new JLabel("End Port:");
		lblPort.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPort.setBounds(329, 33, 86, 35);
		contentPane.add(lblPort);
		
		textFieldEnd = new JTextField();
		textFieldEnd.setText("65535");
		textFieldEnd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldEnd.setColumns(10);
		textFieldEnd.setBounds(425, 31, 100, 40);
		contentPane.add(textFieldEnd);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(23, 200, 503, 187);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(23, 200, 503, 187);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int startPort = Integer.parseInt(textFieldStart.getText());
				int endPort = Integer.parseInt(textFieldEnd.getText());
				String result = "";
				int numbers = 1;
				for(int port = startPort; port < endPort; port++) {
					DatagramSocket server;
					try {
						server = new DatagramSocket(port);
						server.close();
					} catch (SocketException e1) {
						result += numbers + ". " + "There is a server on port: " + port + "\n";
						numbers ++;
					}
				}
				textAreaResult.setText(result);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(150, 113, 108, 50);
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
		btnBack.setBounds(288, 113, 108, 50);
		contentPane.add(btnBack);
	}

}
