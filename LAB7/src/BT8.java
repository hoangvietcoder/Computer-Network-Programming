import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BT8 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHostName;
	private JTextField textFieldPortNumber;
	private JTextField textFieldDomainName;

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
		setTitle("A command-line whois client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Host Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(23, 41, 105, 31);
		contentPane.add(lblNewLabel);

		textFieldHostName = new JTextField();
		textFieldHostName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldHostName.setText("whois.internic.net");
		textFieldHostName.setBounds(161, 37, 336, 40);
		contentPane.add(textFieldHostName);
		textFieldHostName.setColumns(10);

		JLabel lblPortNumber = new JLabel("Port Number:");
		lblPortNumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPortNumber.setBounds(559, 41, 117, 31);
		contentPane.add(lblPortNumber);

		JTextArea textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaResult.setBounds(138, 183, 665, 278);
		contentPane.add(textAreaResult);
		
		JScrollPane scrollPane = new JScrollPane(textAreaResult);
		scrollPane.setBounds(138, 183, 665, 278);
		contentPane.add(scrollPane);

		textFieldPortNumber = new JTextField();
		textFieldPortNumber.setText("43");
		textFieldPortNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPortNumber.setBounds(686, 37, 117, 40);
		contentPane.add(textFieldPortNumber);
		textFieldPortNumber.setColumns(10);

		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String domainName = textFieldDomainName.getText();
				 
		        String getHostName = textFieldHostName.getText();
		        int getPort = Integer.parseInt(textFieldPortNumber.getText());
		        
		        String result = "";
		 
		        try (Socket socket = new Socket(getHostName, getPort)) {
		 
		            OutputStream output = socket.getOutputStream();
		            PrintWriter writer = new PrintWriter(output, true);
		            writer.println(domainName);
		 
		            InputStream input = socket.getInputStream();
		 
		            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		 
		            String line;
		 
		            while ((line = reader.readLine()) != null) {
		                result += line + "\n";
		            }
		        } catch (UnknownHostException ex) {
		 
		        	textAreaResult.setText("Server not found: " + ex.getMessage());
		 
		        } catch (IOException ex) {
		 
		        	textAreaResult.setText("I/O error: " + ex.getMessage());
		        }
		        textAreaResult.setText(result);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(274, 497, 125, 50);
		contentPane.add(btnNewButton);

		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblResult.setBounds(23, 303, 84, 31);
		contentPane.add(lblResult);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				setVisible(false);
				menu.toFront();
				menu.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setBounds(531, 497, 125, 50);
		contentPane.add(btnBack);
		
		JLabel lblDomainName = new JLabel("Domain Name:");
		lblDomainName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDomainName.setBounds(23, 114, 133, 31);
		contentPane.add(lblDomainName);
		
		textFieldDomainName = new JTextField();
		textFieldDomainName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDomainName.setText("google.com");
		textFieldDomainName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldDomainName.setColumns(10);
		textFieldDomainName.setBounds(161, 110, 336, 40);
		contentPane.add(textFieldDomainName);
	}
}
