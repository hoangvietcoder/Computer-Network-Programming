import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Client_BaseConverter extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNumber;
	private static JTextField textFieldResult;

	static Socket socket;
	static DataInputStream dataInputStream;
	static DataOutputStream dataOutputStream;
	static int number;

	/**
	 * Launch the application.
	 * 
	 * @throws EOFException
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_BaseConverter frame = new Client_BaseConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		convert();

	}

	/**
	 * Create the frame.
	 */
	public Client_BaseConverter() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u01A1 s\u1ED1 10:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(61, 49, 97, 29);
		contentPane.add(lblNewLabel);

		textFieldNumber = new JTextField();
		textFieldNumber.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFieldNumber.setBounds(183, 47, 300, 40);
		contentPane.add(textFieldNumber);
		textFieldNumber.setColumns(10);

		JButton btnNewButton = new JButton("C\u01A1 s\u1ED1 2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldNumber.getText().isEmpty()) {
					try {
						number = Integer.parseInt(textFieldNumber.getText());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Please re-enter the number", "Warning",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					String getNumber = textFieldNumber.getText() + " 2";
					
					try {
						dataOutputStream.writeUTF(getNumber);
						dataOutputStream.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter the number", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				return;
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(61, 163, 107, 50);
		contentPane.add(btnNewButton);

		JButton btnCS = new JButton("C\u01A1 s\u1ED1 8");
		btnCS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldNumber.getText().isEmpty()) {
					try {
						number = Integer.parseInt(textFieldNumber.getText());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Please re-enter the number", "Warning",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					String getNumber = textFieldNumber.getText() + " 8";
					
					try {
						dataOutputStream.writeUTF(getNumber);
						dataOutputStream.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter the number", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				return;
			}
		});
		btnCS.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCS.setBounds(241, 163, 107, 50);
		contentPane.add(btnCS);

		JButton btnCS_1 = new JButton("C\u01A1 s\u1ED1 16");
		btnCS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldNumber.getText().isEmpty()) {
					try {
						number = Integer.parseInt(textFieldNumber.getText());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Please re-enter the number", "Warning",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					String getNumber = textFieldNumber.getText() + " 16";
	
					try {
						dataOutputStream.writeUTF(getNumber);
						dataOutputStream.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter the number", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				return;
			}
		});
		btnCS_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCS_1.setBounds(425, 163, 116, 50);
		contentPane.add(btnCS_1);

		JLabel lblKtQu = new JLabel("K\u1EBFt qu\u1EA3: ");
		lblKtQu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKtQu.setBounds(71, 293, 97, 29);
		contentPane.add(lblKtQu);

		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFieldResult.setColumns(10);
		textFieldResult.setBounds(183, 291, 295, 40);
		textFieldResult.setEditable(false);
		contentPane.add(textFieldResult);
	}

	public static void convert() {
		try {
			socket = new Socket("127.0.0.1", 2031);
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());

			String temp = "";

			while (!temp.equals("exit")) {
				temp = dataInputStream.readUTF();
				textFieldResult.setText("" + temp);
			}

		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}

	}

}
