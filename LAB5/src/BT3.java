import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BT3 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldProtocol;
	private JTextField textFieldResult;
	private JTextField textFieldHostName;
	private JTextField textFieldFile;
	private JTextField textFieldPort;
	private JButton btnNewButton_1;

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
		setTitle("public URL(String protocol, String host, int port, String file)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HostName:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 122, 103, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 412, 85, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				String getProtocol = textFieldProtocol.getText();
				String getHostName = textFieldHostName.getText();
				int getPort = Integer.parseInt(textFieldPort.getText());
				String getFile = textFieldFile.getText();
				
				try {
					URL url = new URL(getProtocol, getHostName, getPort, getFile);
					textFieldResult.setText("" + url);
				} catch (MalformedURLException e1) {
					JOptionPane.showMessageDialog(null, "Could not find URL", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(294, 321, 113, 50);
		contentPane.add(btnNewButton);
		
		textFieldProtocol = new JTextField();
		textFieldProtocol.setText("http");
		textFieldProtocol.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldProtocol.setBounds(113, 47, 487, 35);
		contentPane.add(textFieldProtocol);
		textFieldProtocol.setColumns(10);
		
		textFieldResult = new JTextField();
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldResult.setBounds(113, 406, 487, 35);
		contentPane.add(textFieldResult);
		textFieldResult.setColumns(10);
		
		textFieldHostName = new JTextField();
		textFieldHostName.setText("www.sun.com");
		textFieldHostName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHostName.setColumns(10);
		textFieldHostName.setBounds(113, 114, 487, 35);
		contentPane.add(textFieldHostName);
		
		JLabel lblNewLabel_2 = new JLabel("Protocol:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 55, 103, 16);
		contentPane.add(lblNewLabel_2);
		
		textFieldPort = new JTextField();
		textFieldPort.setText("8000");
		textFieldPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(113, 182, 487, 35);
		contentPane.add(textFieldPort);
		
		JLabel lblFile = new JLabel("Port:");
		lblFile.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFile.setBounds(10, 194, 103, 16);
		contentPane.add(lblFile);
		
		textFieldFile = new JTextField();
		textFieldFile.setText("/index.html");
		textFieldFile.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldFile.setColumns(10);
		textFieldFile.setBounds(113, 249, 487, 35);
		contentPane.add(textFieldFile);
		
		JLabel lblFile_1 = new JLabel("File:");
		lblFile_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFile_1.setBounds(10, 261, 103, 16);
		contentPane.add(lblFile_1);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(294, 474, 113, 50);
		contentPane.add(btnNewButton_1);
	}

}
