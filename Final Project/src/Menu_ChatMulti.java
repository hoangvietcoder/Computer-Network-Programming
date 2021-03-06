import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Menu_ChatMulti extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_ChatMulti frame = new Menu_ChatMulti();
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
	public Menu_ChatMulti() {
		setTitle("Menu_ChatMulti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SERVER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Server_Chat server = new Server_Chat();
				server.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(64, 130, 150, 150);
		contentPane.add(btnNewButton);
		
		JButton btnClient = new JButton("CLIENT");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client_Chat client = new Client_Chat();
				client.setVisible(true);
			}
		});
		btnClient.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClient.setBounds(397, 130, 150, 150);
		contentPane.add(btnClient);
		
		JLabel lblNewLabel = new JLabel("CHAT MULTI CLIENT/SERVER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(111, 44, 431, 37);
		contentPane.add(lblNewLabel);
	}
}
