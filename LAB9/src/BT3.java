import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BT3 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHostName;
	private JTextField textFieldPort;
	private JTextField textFieldData;
	
	private InetAddress ia;
	private DatagramSocket theSocket;
	private String getHostName;
	private String getData;
	private int getPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT3 frame = new BT3();
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
	public BT3() {
		setTitle("UDP Discard Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Host Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 33, 108, 35);
		contentPane.add(lblNewLabel);
		
		textFieldHostName = new JTextField();
		textFieldHostName.setText("127.0.0.1");
		textFieldHostName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHostName.setBounds(154, 31, 248, 40);
		contentPane.add(textFieldHostName);
		textFieldHostName.setColumns(10);
		
		JLabel lblPort = new JLabel("PortNo:");
		lblPort.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPort.setBounds(476, 33, 86, 35);
		contentPane.add(lblPort);
		
		textFieldPort = new JTextField();
		textFieldPort.setText("2021");
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(572, 31, 100, 40);
		contentPane.add(textFieldPort);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(25, 200, 634, 237);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(25, 200, 634, 237);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getHostName = textFieldHostName.getText();
				getPort = Integer.parseInt(textFieldPort.getText());
				
				try {
					ia = InetAddress.getByName(getHostName);
					theSocket = new DatagramSocket();
					Component fame = null;
					JOptionPane.showMessageDialog(fame, "Ready to send data", "Message", JOptionPane.INFORMATION_MESSAGE);
				} catch (UnknownHostException e1) {
					System.err.println(e1);
				} catch (SocketException e1) {
					System.err.println(e1);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(294, 111, 108, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblInputData = new JLabel("Input Data:");
		lblInputData.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblInputData.setBounds(25, 473, 108, 35);
		contentPane.add(lblInputData);
		
		textFieldData = new JTextField();
		textFieldData.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldData.setColumns(10);
		textFieldData.setBounds(154, 471, 376, 40);
		contentPane.add(textFieldData);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getData = textFieldData.getText();
				try {
					byte[] data = getData.getBytes("UTF-8");
					DatagramPacket dp = new DatagramPacket(data, data.length, ia, getPort);
					theSocket.send(dp);
					textAreaResult.setText(textAreaResult.getText().trim() + "\n" +"Client: " + getData);
				} catch (UnsupportedEncodingException e1) {
					System.err.println();
				} catch (IOException e1) {
					System.err.println();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Please press the \"Click Here\" button before send the data", "Message", JOptionPane.WARNING_MESSAGE);
				}
				textFieldData.setText("");
			}
		});
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSend.setBounds(551, 466, 108, 50);
		contentPane.add(btnSend);
	}

}
