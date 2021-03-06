import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Server_BaseConverter extends JFrame {

	private JPanel contentPane;

	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream dataInputStream;
	static DataOutputStream dataOutputStream;

	static String result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_BaseConverter frame = new Server_BaseConverter();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
		convert();

	}

	/**
	 * Create the frame.
	 */
	public Server_BaseConverter() {
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("X\u1EEC L\u00DD CHUY\u1EC2N \u0110\u1ED4I C\u01A0 S\u1ED0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(67, 24, 321, 42);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Click \u0111\u1EC3 nh\u1EADn k\u1EBFt qu\u1EA3");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dataOutputStream.writeUTF(result);
					dataOutputStream.flush();
				} catch (IOException e1) {
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Please enter the number and base to convert on the Client.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(101, 143, 257, 55);
		contentPane.add(btnNewButton);
	}

	public static void convert() {
		String str = "";
		String[] base = { "2", "8", "16" };

		try {
			serverSocket = new ServerSocket(2031);
			socket = serverSocket.accept();
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());

			while (!str.equals(" ")) {
				str = dataInputStream.readUTF();
				String temp[] = str.split(" ");
				int number = Integer.parseInt(temp[0]);

				if (temp[1].equals(base[0])) {
					result = Integer.toBinaryString(number);
				}

				if (temp[1].equals(base[1])) {
					result = Integer.toOctalString(number);
				}

				if (temp[1].equals(base[2])) {
					result = Integer.toHexString(number);
				}
			}

		} catch (IOException e) {
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
			}
		}
	}

}
