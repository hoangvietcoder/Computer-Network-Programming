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
public class BT9 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL;
	private JTextField textFieldFileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT9 frame = new BT9();
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
	public BT9() {
		setTitle("getFile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter URL:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 50, 106, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FileName:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 204, 116, 21);
		contentPane.add(lblNewLabel_1);
		
		textFieldURL = new JTextField();
		textFieldURL.setText("https://www.amrood.com/index.htm?language=en#j2se");
		textFieldURL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL.setBounds(126, 45, 383, 35);
		contentPane.add(textFieldURL);
		textFieldURL.setColumns(10);
		
		textFieldFileName = new JTextField();
		textFieldFileName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldFileName.setBounds(126, 199, 383, 35);
		contentPane.add(textFieldFileName);
		textFieldFileName.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getURL = textFieldURL.getText();
				try {
					URL url = new URL(getURL);
					textFieldFileName.setText("" + url.getFile());
				} catch (MalformedURLException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + getURL, "Message", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(256, 116, 116, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(256, 270, 116, 50);
		contentPane.add(btnNewButton_1);
	}
}
