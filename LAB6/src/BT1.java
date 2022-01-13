import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.net.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class BT1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT1 frame = new BT1();
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
	public BT1() {
		setTitle("Opening URLConnections");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Input URL:");
		lblNewLabel.setBounds(10, 34, 95, 27);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setBounds(10, 249, 72, 21);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);

		textFieldURL = new JTextField();
		textFieldURL.setBounds(115, 32, 450, 35);
		textFieldURL.setText("https://www.facebook.com/");
		textFieldURL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(textFieldURL);
		textFieldURL.setColumns(10);

		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(115, 194, 450, 185);
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(textAreaResult);

		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.setBounds(278, 106, 122, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getURL = textFieldURL.getText();
				try {
					URL u = new URL(getURL);
					URLConnection uc = u.openConnection();

					textAreaResult.setText("" + uc);
				} catch (MalformedURLException e1) {
					textAreaResult.setText("");
					JOptionPane.showMessageDialog(null, "Could not find URL: " + getURL, "MalformedURLException",
							JOptionPane.ERROR_MESSAGE);

				} catch (IOException e1) {
					textAreaResult.setText("");
					JOptionPane.showMessageDialog(null, "I/O devices disconnect", "IOException",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(115, 194, 450, 185);
		contentPane.add(scrollPane);
		
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
		btnNewButton_1.setBounds(278, 416, 122, 50);
		contentPane.add(btnNewButton_1);

	}
}
