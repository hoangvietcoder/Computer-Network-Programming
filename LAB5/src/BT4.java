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
public class BT4 extends JFrame {

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
					BT4 frame = new BT4();
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
	public BT4() {
		setTitle("public URL(URL base, String relative)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Data 1:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 31, 110, 30);
		contentPane.add(lblNewLabel);

		textFieldURL1 = new JTextField();
		textFieldURL1.setText("http://www.ibiblio.org/javafaq/index.html");
		textFieldURL1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL1.setBounds(130, 30, 447, 35);
		contentPane.add(textFieldURL1);
		textFieldURL1.setColumns(10);

		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(130, 285, 447, 85);
		contentPane.add(textAreaResult);

		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 349, 66, 21);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getData1 = textFieldURL1.getText();
				String getData2 = textFieldURL2.getText();

				try {
					URL url1 = new URL(getData1);
					URL url2 = new URL(url1, getData2);
					
					textAreaResult.setText("" + url2);

				} catch (MalformedURLException e1) {
					JOptionPane.showMessageDialog(null, "Could not find URL", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(296, 197, 116, 51);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Enter Data 2:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 132, 110, 21);
		contentPane.add(lblNewLabel_2);

		textFieldURL2 = new JTextField();
		textFieldURL2.setText("mailinglists.html");
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
		btnNewButton_1.setBounds(296, 407, 116, 50);
		contentPane.add(btnNewButton_1);
	}

}
