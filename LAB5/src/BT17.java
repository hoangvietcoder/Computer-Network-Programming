import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BT17 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT17 frame = new BT17();
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
	public BT17() {
		setTitle("getContent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter URL:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 31, 96, 21);
		contentPane.add(lblNewLabel);
		
		textFieldURL = new JTextField();
		textFieldURL.setText("https://www.oracle.com/");
		textFieldURL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldURL.setBounds(116, 26, 534, 35);
		contentPane.add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(116, 177, 534, 308);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(116, 177, 534, 308);
		
		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 318, 66, 21);
		contentPane.add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getURL = textFieldURL.getText();
				try {
					URL url = new URL(getURL);
					
					Object contents = url.getContent();
					
					textAreaResult.setText("" + contents);
				} catch (MalformedURLException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + getURL, "Message", JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Could not find " + getURL, "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(326, 94, 116, 51);
		contentPane.add(btnNewButton);
		getContentPane().add(scrollPane);
		
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
		btnNewButton_1.setBounds(326, 520, 116, 50);
		contentPane.add(btnNewButton_1);
	}
}