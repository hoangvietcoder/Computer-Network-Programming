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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BT18 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL1;
	private JTextField textFieldURL2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT18 frame = new BT18();
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
	public BT18() {
		setTitle("sameFile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter URL 1:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 31, 110, 30);
		contentPane.add(lblNewLabel);

		textFieldURL1 = new JTextField();
		textFieldURL1.setText("http://www.ncsa.uiuc.edu/HTMLPrimer.html#GS");
		textFieldURL1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL1.setBounds(130, 26, 447, 35);
		contentPane.add(textFieldURL1);
		textFieldURL1.setColumns(10);

		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(130, 285, 447, 85);
		contentPane.add(textAreaResult);

		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 314, 66, 21);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getURL1 = textFieldURL1.getText();
				String getURL2 = textFieldURL2.getText();

				try {
					URL url1 = new URL(getURL1);
					URL url2 = new URL(getURL2);

					if (url1.sameFile(url2)) {
						textAreaResult.setText(url1 + " is the same file as \n" + url2);
					} else {
						textAreaResult.setText(url1 + " is not the same file as \n" + url2);
					}

				} catch (MalformedURLException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + getURL1 + " or " + getURL2, "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(294, 197, 116, 51);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Enter URL 2:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 132, 110, 21);
		contentPane.add(lblNewLabel_2);

		textFieldURL2 = new JTextField();
		textFieldURL2.setText("http://www.ncsa.uiuc.edu/HTMLPrimer.html#HD");
		textFieldURL2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL2.setBounds(130, 127, 447, 35);
		contentPane.add(textFieldURL2);
		textFieldURL2.setColumns(10);
		
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
		btnNewButton_1.setBounds(294, 408, 116, 50);
		contentPane.add(btnNewButton_1);
	}
}
