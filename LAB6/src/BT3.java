import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
public class BT3 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldURL;


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
		setFont(new Font("Times New Roman", Font.BOLD, 18));
		setTitle("public OutputStream getOutputStream()");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Input URL:");
		lblNewLabel.setBounds(10, 34, 95, 27);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setBounds(10, 348, 72, 21);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);

		textFieldURL = new JTextField();
		textFieldURL.setBounds(115, 32, 577, 35);
		textFieldURL.setText("https://dantri.com.vn/the-gioi.htm");
		textFieldURL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(textFieldURL);
		textFieldURL.setColumns(10);

		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(115, 194, 577, 313);
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(textAreaResult);

		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.setBounds(339, 109, 122, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getURL = textFieldURL.getText();
				try {
					URL u = new URL(getURL);
					URLConnection uc = u.openConnection();
					InputStream raw = uc.getInputStream();
					BufferedInputStream buffer = new BufferedInputStream(raw);
					Reader r = new InputStreamReader(buffer);
					int c;
					OutputStream os = new FileOutputStream("OutputStream.html");
					while ((c = r.read()) != -1) {
						os.write((char) c);
					}
					os.close();

					textAreaResult.setText("C:\\Users\\Legion\\eclipse-workspace\\LAB5\\OutputStream.html");
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
		scrollPane.setBounds(115, 194, 577, 313);
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
		btnNewButton_1.setBounds(339, 537, 122, 50);
		contentPane.add(btnNewButton_1);

	}

}
