import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 426);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Datagram Packet");
		mnNewMenu.setForeground(Color.ORANGE);
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Datagram");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT1 bt1 = new BT1();
				bt1.setVisible(true);
				
				setVisible(false);
				bt1.toFront();
				bt1.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Datagram Socket");
		mnNewMenu_1.setForeground(Color.BLUE);
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmBt = new JMenuItem("Look For Local UDP Ports");
		mntmBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT2 bt2 = new BT2();
				bt2.setVisible(true);
				
				setVisible(false);
				bt2.toFront();
				bt2.setVisible(true);
			}
		});
		mntmBt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmBt);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("51900847 -  Mai Ho\u00E0ng Vi\u1EC7t");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(157, 59, 367, 198);
		contentPane.add(lblNewLabel);
	}
}
