import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ScrollPane;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TCPServer extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textFieldPortNumber;
	private JTextField textFieldSend;
	Socket socket;
	ServerSocket serverSocket;
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
					TCPServer frame = new TCPServer();
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
	public TCPServer() {
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Port Number:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(37, 28, 126, 27);
		contentPane.add(lblNewLabel);
		
		textFieldPortNumber = new JTextField();
		textFieldPortNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPortNumber.setText("2020");
		textFieldPortNumber.setBounds(168, 24, 100, 40);
		contentPane.add(textFieldPortNumber);
		textFieldPortNumber.setColumns(10);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getPort = Integer.parseInt(textFieldPortNumber.getText().trim());
				try {
					serverSocket = new ServerSocket(getPort);
					JOptionPane.showMessageDialog(null, "Server is created", "Message", JOptionPane.INFORMATION_MESSAGE);
					socket = serverSocket.accept();
					dataInputStream = new DataInputStream(socket.getInputStream());
					name = dataInputStream.readUTF();
					JOptionPane.showMessageDialog(null, "Client is connected", "Message", JOptionPane.INFORMATION_MESSAGE);
					Thread thread = new Thread(TCPServer.this);
					thread.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(473, 16, 113, 50);
		contentPane.add(btnNewButton);
		
		textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(37, 99, 549, 260);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(37, 99, 549, 260);
		contentPane.add(scrollPane);
		
		textFieldSend = new JTextField();
		textFieldSend.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldSend.setColumns(10);
		textFieldSend.setBounds(37, 406, 419, 40);
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
		btnSend.setBounds(473, 398, 113, 50);
		contentPane.add(btnSend);
	}

	@Override
	public void run() {
		String message = "";
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			while(!message.equals("exit")) {
				message = dataInputStream.readUTF();
				textAreaResult.setText(textAreaResult.getText() + "\n" + name + ": " + message);

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
