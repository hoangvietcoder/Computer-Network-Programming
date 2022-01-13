import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BT1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL;
	private JTextField textFieldPort;
	private JTextField textFieldText;

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
		setTitle("Datagram");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input URL: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 114, 108, 35);
		contentPane.add(lblNewLabel);
		
		textFieldURL = new JTextField();
		textFieldURL.setText("www.ibiblio.org");
		textFieldURL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL.setBounds(120, 112, 255, 40);
		contentPane.add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPort.setBounds(439, 114, 49, 35);
		contentPane.add(lblPort);
		
		textFieldPort = new JTextField();
		textFieldPort.setText("2021");
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(498, 112, 96, 40);
		contentPane.add(textFieldPort);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(22, 271, 569, 164);
		contentPane.add(textAreaResult);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getURL = textFieldURL.getText();
				int getPort = Integer.parseInt(textFieldPort.getText());
				String msg = textFieldText.getText();
				
				byte[] data = msg.getBytes();
				try {
					InetAddress ia = InetAddress.getByName(getURL);
					DatagramPacket dp = new DatagramPacket(data, data.length, ia, getPort);
					String result = "This packet is addressed to \n";
					result += dp.getAddress() + " on port " + dp.getPort();
					result += "\nThere are " + dp.getLength() + " byte of data in the packet \n";
					result += dp.getData() + " - " + dp.getOffset() + " - " + dp.getLength();
					
					textAreaResult.setText(result);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(161, 182, 108, 50);
		contentPane.add(btnNewButton);
		
		
		JLabel lblInputText = new JLabel("Input Text: ");
		lblInputText.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblInputText.setBounds(10, 20, 108, 35);
		contentPane.add(lblInputText);
		
		textFieldText = new JTextField();
		textFieldText.setText("Enter data here");
		textFieldText.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldText.setColumns(10);
		textFieldText.setBounds(120, 15, 474, 40);
		contentPane.add(textFieldText);
		
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
		btnBack.setBounds(345, 182, 108, 50);
		contentPane.add(btnBack);
	}
}
