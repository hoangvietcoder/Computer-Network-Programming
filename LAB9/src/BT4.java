import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

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
public class BT4 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPort;
	private JTextField textFieldSize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT4 frame = new BT4();
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
	public BT4() {
		setTitle("UDP Discard Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Port:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 33, 71, 35);
		contentPane.add(lblNewLabel);
		
		textFieldPort = new JTextField();
		textFieldPort.setText("2021");
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPort.setBounds(79, 31, 100, 40);
		contentPane.add(textFieldPort);
		textFieldPort.setColumns(10);
		
		JLabel lblPort = new JLabel("Max Packet Size:");
		lblPort.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPort.setBounds(263, 33, 152, 35);
		contentPane.add(lblPort);
		
		textFieldSize = new JTextField();
		textFieldSize.setText("56507");
		textFieldSize.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldSize.setColumns(10);
		textFieldSize.setBounds(426, 31, 100, 40);
		contentPane.add(textFieldSize);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(23, 200, 503, 187);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(23, 200, 503, 187);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 *
			 */
			public void actionPerformed(ActionEvent e) {
				int getPort = Integer.parseInt(textFieldPort.getText());
				int maxSize = Integer.parseInt(textFieldSize.getText());
				String msg = "";
				
				byte[] buffer = new byte[maxSize];
				
				try {
					DatagramSocket server =  new DatagramSocket(getPort);
					DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
					Component fame = null;
					JOptionPane.showMessageDialog(fame, "Ready to reveive data", "Message", JOptionPane.INFORMATION_MESSAGE);
					
					while(!msg.equals("exit")) {
						server.receive(dp);
						msg = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
						textAreaResult.setText(textAreaResult.getText().trim() + "\n" + dp.getAddress() + " at port " + 
						dp.getPort() + " say: " + msg);
						JOptionPane.showMessageDialog(fame, "New data is received"); 

					}
				} catch (SocketException e1) {
					System.err.println();
				} catch (IOException e1) {
					System.err.println();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(218, 110, 108, 50);
		contentPane.add(btnNewButton);
	}

}
