import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;

@SuppressWarnings("serial")
public class Weblog extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Weblog window = new Weblog();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Weblog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("HomeWork");
		this.setBounds(100, 100, 557, 447);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(1, 1, 424, 188);
		this.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(53, 107, 426, 190);
		this.getContentPane().add(scrollPane);

		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.setBounds(216, 31, 110, 45);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (FileInputStream fin = new FileInputStream("File\\testFile");
						Reader in = new InputStreamReader(fin);
						BufferedReader bin = new BufferedReader(in);) {

					for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
						// separate out the IP address
						int index = entry.indexOf(' ');
						String ip = entry.substring(0, index);
						String theRest = entry.substring(index);

						// Ask DNS for the host name and print it out
						try {
							InetAddress address = InetAddress.getByName(ip);
							textArea.setText(address.getHostName() + theRest);
						} catch (UnknownHostException ex) {
							textArea.setText(entry);
						}
					}
				} catch (IOException ex) {
					System.out.println("Exception: " + ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.getContentPane().add(btnNewButton);
		
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
		btnNewButton_1.setBounds(216, 333, 110, 45);
		getContentPane().add(btnNewButton_1);
	}
}
