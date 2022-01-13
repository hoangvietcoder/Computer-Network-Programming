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
public class BT11 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL;
	private JTextField textFieldRefName;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT11 frame = new BT11();
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
	public BT11() {
		setTitle("getRef");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter URL:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 50, 106, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RefName:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 204, 116, 21);
		contentPane.add(lblNewLabel_1);
		
		textFieldURL = new JTextField();
		textFieldURL.setText("https://www.amrood.com/index.htm?language=en#j2se");
		textFieldURL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL.setBounds(126, 45, 399, 35);
		contentPane.add(textFieldURL);
		textFieldURL.setColumns(10);
		
		textFieldRefName = new JTextField();
		textFieldRefName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldRefName.setBounds(126, 199, 399, 35);
		contentPane.add(textFieldRefName);
		textFieldRefName.setColumns(10);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getURL = textFieldURL.getText();
				try {
					URL url = new URL(getURL);
					textFieldRefName.setText("" + url.getRef());
				} catch (MalformedURLException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + getURL, "Message", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(265, 113, 116, 50);
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
		btnNewButton_1.setBounds(265, 270, 116, 50);
		contentPane.add(btnNewButton_1);
	}

}
