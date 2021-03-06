import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Client_File extends JFrame {

	private JPanel contentPane;
	final File[] fileToSend = new File[1];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_File frame = new Client_File();
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
	public Client_File() {

		setTitle("Client send");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("G\u1EEDi File");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 29, 416, 46);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Ch\u1ECDn File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setDialogTitle("Chon File de gui");

				if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					fileToSend[0] = jFileChooser.getSelectedFile();
					lblNewLabel.setText("File ban chon đe gui đi là : " + fileToSend[0].getName());

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(56, 134, 124, 46);
		contentPane.add(btnNewButton);

		JButton btnGiFile = new JButton("G\u1EEDi File");
		btnGiFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileToSend[0] == null) {
					lblNewLabel.setText("Vui lÃ²ng chá»�n File");
				} else {
					try {
						FileInputStream fileInputStream = new FileInputStream(fileToSend[0].getAbsolutePath());
						@SuppressWarnings("resource")
						Socket socket = new Socket("localhost", 1234);

						DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

						String fileName = fileToSend[0].getName();

						byte[] fileNameBytes = fileName.getBytes();

						byte[] fileContentBytes = new byte[(int) fileToSend[0].length()];
						fileInputStream.read(fileContentBytes);

						dataOutputStream.writeInt(fileNameBytes.length);
						dataOutputStream.write(fileNameBytes);

						dataOutputStream.writeInt(fileContentBytes.length);
						dataOutputStream.write(fileContentBytes);
					} catch (IOException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}

				}
			}
		});

		btnGiFile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGiFile.setBounds(237, 134, 124, 46);
		contentPane.add(btnGiFile);

	}
}
