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
public class BT8 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL;
	private JTextField textFieldDefaultPort;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT8 frame = new BT8();
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
	public BT8() {
		setTitle("getDefaultPort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter URL:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 50, 106, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DefaultPort:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 204, 116, 21);
		contentPane.add(lblNewLabel_1);
		
		textFieldURL = new JTextField();
		textFieldURL.setText("https://www.amrood.com/index.htm?language=en#j2se");
		textFieldURL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL.setBounds(126, 45, 387, 35);
		contentPane.add(textFieldURL);
		textFieldURL.setColumns(10);
		
		textFieldDefaultPort = new JTextField();
		textFieldDefaultPort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldDefaultPort.setBounds(126, 199, 387, 35);
		contentPane.add(textFieldDefaultPort);
		textFieldDefaultPort.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getURL = textFieldURL.getText();
				try {
					URL url = new URL(getURL);
					textFieldDefaultPort.setText("" + url.getDefaultPort());
				} catch (MalformedURLException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + getURL, "Message", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(263, 114, 116, 50);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_1.setBounds(263, 270, 116, 50);
		contentPane.add(btnNewButton_1);
	}

}
