import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.TitledBorder;

import java.io.InputStreamReader;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Panel_Chat extends JPanel implements Runnable {
	JPanel panel;
	JTextArea textAreaMessage;
	JTextArea textAreaSend;
	JButton btnSend;
	
	Socket socket;
	BufferedReader bufferedReader;
	DataOutputStream dataOutputStream;
	
	String sender;
	String receiver;
	/**
	 * Create the panel.
	 */
	public Panel_Chat(Socket s, String sender, String receiver) {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Type the message here to send", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times new Roman", Font.PLAIN, 16), Color.GRAY));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 5, 5));
		
		textAreaSend = new JTextArea();
		textAreaSend.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(textAreaSend);
		
		btnSend = new JButton("SEND");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Kiem tra nguoi dung da nhap tin nhan chua
				if(textAreaSend.getText().isEmpty()) return;
				try {
					dataOutputStream.writeBytes(sender + ": "+ textAreaSend.getText() + "\n");
					dataOutputStream.flush();
					textAreaMessage.append("\nMe" + ": "+ textAreaSend.getText());
					textAreaSend.setText("");
				} catch (Exception e2) {
				
				}
			}
		});
		panel.add(btnSend);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, BorderLayout.CENTER);
		
		textAreaMessage = new JTextArea();
		textAreaMessage.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaMessage.setEditable(false);
		scrollPane_1.setViewportView(textAreaMessage);

		socket = s;
		this.sender = sender;
		this.receiver = receiver;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader (socket.getInputStream()));
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {

		}
	}
	
	public void addMessage(String message) {
		textAreaMessage.append(message);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(socket != null) {
					String message = "";
					while ((message = bufferedReader.readLine()) != null) {
						textAreaMessage.append("\n" + message);
					}
				}
			} catch (Exception e) {
				
			}
		}
		
	}
}
