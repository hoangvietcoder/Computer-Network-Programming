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
		setBounds(100, 100, 623, 417);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("URL Connection");
		mnNewMenu.setForeground(Color.RED);
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Opening URLConnections");
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
		
		JMenuItem mntmGetinputstream = new JMenuItem("getInputStream");
		mntmGetinputstream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT2 bt2 = new BT2();
				bt2.setVisible(true);
				
				setVisible(false);
				bt2.toFront();
				bt2.setVisible(true);
			}
		});
		mntmGetinputstream.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.add(mntmGetinputstream);
		
		JMenuItem mntmGetoutputstream = new JMenuItem("getOutputStream");
		mntmGetoutputstream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT3 bt3 = new BT3();
				bt3.setVisible(true);
				
				setVisible(false);
				bt3.toFront();
				bt3.setVisible(true);
			}
		});
		mntmGetoutputstream.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.add(mntmGetoutputstream);
		
		JMenu mnNewMenu_1 = new JMenu("Exercises");
		mnNewMenu_1.setForeground(Color.BLUE);
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmBt = new JMenuItem("Download a web page with the correct character set");
		mntmBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT4 bt4 = new BT4();
				bt4.setVisible(true);
				
				setVisible(false);
				bt4.toFront();
				bt4.setVisible(true);
			}
		});
		mntmBt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmBt);
		
		JMenuItem mntmBt_1 = new JMenuItem("Return the header");
		mntmBt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT5 bt5 = new BT5();
				bt5.setVisible(true);
				
				setVisible(false);
				bt5.toFront();
				bt5.setVisible(true);
			}
		});
		mntmBt_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmBt_1);
		
		JMenuItem mntmBt_2 = new JMenuItem("Retrieving Arbitrary Header Fields");
		mntmBt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT6 bt6 = new BT6();
				bt6.setVisible(true);
				
				setVisible(false);
				bt6.toFront();
				bt6.setVisible(true);
			}
		});
		mntmBt_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmBt_2);
		
		JMenuItem mntmBt_3 = new JMenuItem("Print the entire HTTP header");
		mntmBt_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT7 bt7 = new BT7();
				bt7.setVisible(true);
				
				setVisible(false);
				bt7.toFront();
				bt7.setVisible(true);
			}
		});
		mntmBt_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmBt_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("51900847 -  Mai Ho\u00E0ng Vi\u1EC7t");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(148, 59, 367, 198);
		contentPane.add(lblNewLabel);
	}
}
