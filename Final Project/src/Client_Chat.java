import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class Client_Chat extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldIP;
	private JTextField textFieldPort;

	Socket socket;
	BufferedReader bufferedReader;
	DataOutputStream dataOutputStream;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Chat frame = new Client_Chat();
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
	public Client_Chat() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(), null, TitledBorder.LEADING,
				TitledBorder.TOP, new Font("Times new Roman", Font.BOLD, 18), null));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 6, 10, 10));

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("IP:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);

		textFieldIP = new JTextField();
		textFieldIP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFieldIP.setText("127.0.0.1");
		panel.add(textFieldIP);
		textFieldIP.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Port:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);

		textFieldPort = new JTextField();
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFieldPort.setText("2022");
		panel.add(textFieldPort);
		textFieldPort.setColumns(10);
		JFrame thisFrame = this;
		JButton btnConnect = new JButton("START");
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldName.getText().isEmpty() || textFieldIP.getText().isEmpty() || textFieldPort.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter full information", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}

				String getName = textFieldName.getText();
				String getIP = textFieldIP.getText();
				int getPort = Integer.parseInt(textFieldPort.getText());
				
				try {
					socket = new Socket(getIP, getPort);

					if (socket != null) {
						Panel_Chat panel_chat = new Panel_Chat(socket, getName, "Admin");
						thisFrame.getContentPane().add(panel_chat);
						panel_chat.addMessage("Message: " + "You can chat now" + "\n");
						panel_chat.updateUI();

						Thread t = new Thread(panel_chat);
						t.start();
					}
					JOptionPane.showMessageDialog(null, "Connect success", "Message", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Detail: " + e2, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnConnect);
	}

}
