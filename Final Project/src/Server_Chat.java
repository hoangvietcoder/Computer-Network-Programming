import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Server_Chat extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textFieldPort;
	private JTabbedPane tabbedPane;
	private JButton btnNewButton;

	ServerSocket socket;
	BufferedReader bufferedReader;
	Thread thread;

	Server_Chat this_Server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_Chat frame = new Server_Chat();
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
	public Server_Chat() {
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 10, 10));

		JLabel lblServerPort = new JLabel("Server Port:");
		lblServerPort.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblServerPort.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblServerPort);

		textFieldPort = new JTextField();
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFieldPort.setText("2022");
		panel.add(textFieldPort);
		textFieldPort.setColumns(10);

		this_Server = this;

		btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getPort = 2021;

				try {
					getPort = Integer.parseInt(textFieldPort.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "The program uses the default port of 2021\nDetail: " + e1,
							"Error", JOptionPane.ERROR_MESSAGE);
				}

				try {
					socket = new ServerSocket(getPort);
					JOptionPane.showMessageDialog(null, "Server is running at port: " + getPort, "Message",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Detail: " + e1, "Error", JOptionPane.ERROR_MESSAGE);
				}

				thread = new Thread(this_Server);
				thread.start();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnNewButton);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		this.setSize(600, 415);
	}

	@Override
	public void run() {
		while (true) {
			try {
				// Chap nhan ket noi tu Client
				Socket socketAccept = socket.accept();
				if (socketAccept != null) {
					// Lay ten user vua nhan tin cho Server
					bufferedReader = new BufferedReader(new InputStreamReader(socketAccept.getInputStream()));
					String temp = bufferedReader.readLine();
					String name = temp.substring(0, temp.indexOf(":"));

					// Tao Panel_Chat và them no vao JTabblePane
					Panel_Chat panel_chat = new Panel_Chat(socketAccept, "Admin", name);
					tabbedPane.add(name, panel_chat);
					panel_chat.addMessage("Message: " + name + " is connected to the server" + "\n");
					panel_chat.addMessage("\n" + temp);
					panel_chat.updateUI();
					
					Thread thread = new Thread(panel_chat);
					thread.start();
				}
			} catch (Exception e) {
			}

		}
	}

}
