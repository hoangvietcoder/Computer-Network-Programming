import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TCPClient extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldSend;
	private JTextField textFieldPortNumber;
	Socket socket;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	String name;
	JTextArea textAreaResult;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCPClient frame = new TCPClient();
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
	public TCPClient() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(37, 28, 67, 27);
		contentPane.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldName.setText("Mai Ho\u00E0ng Vi\u1EC7t");
		textFieldName.setBounds(114, 22, 153, 40);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getPort = Integer.parseInt(textFieldPortNumber.getText().trim());
				name = textFieldName.getText();
				try {
					socket = new Socket("localhost", getPort);
					dataOutputStream = new DataOutputStream(socket.getOutputStream());
					dataOutputStream.writeUTF(name);
					dataOutputStream.flush();
					Thread thread = new Thread(TCPClient.this);
					thread.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(615, 16, 113, 50);
		contentPane.add(btnNewButton);
		
		textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(37, 95, 691, 270);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(37, 95, 691, 270);
		contentPane.add(scrollPane);
		
		textFieldSend = new JTextField();
		textFieldSend.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldSend.setColumns(10);
		textFieldSend.setBounds(37, 406, 550, 40);
		contentPane.add(textFieldSend);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = textFieldSend.getText().trim();
				try {
					dataOutputStream = new DataOutputStream(socket.getOutputStream());
					dataOutputStream.writeUTF(message);
					dataOutputStream.flush();
					
					textAreaResult.setText(textAreaResult.getText() + "\nMe: " + message);
					textFieldSend.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSend.setBounds(615, 398, 113, 50);
		contentPane.add(btnSend);
		
		JLabel lblNewLabel_1 = new JLabel("Port Number:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(302, 28, 126, 27);
		contentPane.add(lblNewLabel_1);
		
		textFieldPortNumber = new JTextField();
		textFieldPortNumber.setText("2020");
		textFieldPortNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPortNumber.setColumns(10);
		textFieldPortNumber.setBounds(438, 22, 100, 40);
		contentPane.add(textFieldPortNumber);;
	}

	@Override
	public void run() {
		String message = "";
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			while(!message.equals("exit")) {
				message = dataInputStream.readUTF();
				textAreaResult.setText(textAreaResult.getText() + "\nServer: " + message);

			}
		} catch (IOException e) {
			System.err.println();
		}
		finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.err.println();
			}
		}
	}

}
