import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

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
		setBounds(100, 100, 658, 492);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Creating New URLs");
		mnNewMenu.setForeground(Color.RED);
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("URL(String url)");
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
		
		JMenuItem mntmUrlstringProtocolString = new JMenuItem("URL(String protocol, String hostname, String file)");
		mntmUrlstringProtocolString.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT2 bt2 = new BT2();
				bt2.setVisible(true);
				
				setVisible(false);
				bt2.toFront();
				bt2.setVisible(true);
			}
		});
		mntmUrlstringProtocolString.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.add(mntmUrlstringProtocolString);
		
		JMenuItem mntmUrlstringProtocolString_1 = new JMenuItem("URL(String protocol, String host, int port, String file)");
		mntmUrlstringProtocolString_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT3 bt3 = new BT3();
				bt3.setVisible(true);
				
				setVisible(false);
				bt3.toFront();
				bt3.setVisible(true);
			}
		});
		mntmUrlstringProtocolString_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.add(mntmUrlstringProtocolString_1);
		
		JMenuItem mntmUrlurlBaseString = new JMenuItem("URL(URL base, String relative)");
		mntmUrlurlBaseString.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT4 bt4 = new BT4();
				bt4.setVisible(true);
				
				setVisible(false);
				bt4.toFront();
				bt4.setVisible(true);
			}
		});
		mntmUrlurlBaseString.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.add(mntmUrlurlBaseString);
		
		JMenu mnNewMenu_1 = new JMenu("Splitting a URL into Pieces");
		mnNewMenu_1.setForeground(Color.PINK);
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("getProtocol");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT5 bt5 = new BT5();
				bt5.setVisible(true);
				
				setVisible(false);
				bt5.toFront();
				bt5.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("getHost");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT6 bt6 = new BT6();
				bt6.setVisible(true);
				
				setVisible(false);
				bt6.toFront();
				bt6.setVisible(true);
			}
		});
		mntmNewMenuItem_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("getPort");
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT7 bt7 = new BT7();
				bt7.setVisible(true);
				
				setVisible(false);
				bt7.toFront();
				bt7.setVisible(true);
			}
		});
		mntmNewMenuItem_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_2);
		
		JMenuItem mntmNewMenuItem_1_3 = new JMenuItem("getDefaultPort");
		mntmNewMenuItem_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT8 bt8 = new BT8();
				bt8.setVisible(true);
				
				setVisible(false);
				bt8.toFront();
				bt8.setVisible(true);
			}
		});
		mntmNewMenuItem_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_3);
		
		JMenuItem mntmNewMenuItem_1_4 = new JMenuItem("getFile");
		mntmNewMenuItem_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT9 bt9 = new BT9();
				bt9.setVisible(true);
				
				setVisible(false);
				bt9.toFront();
				bt9.setVisible(true);
			}
		});
		mntmNewMenuItem_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_4);
		
		JMenuItem mntmNewMenuItem_1_5 = new JMenuItem("getPath");
		mntmNewMenuItem_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT10 bt10 = new BT10();
				bt10.setVisible(true);
				
				setVisible(false);
				bt10.toFront();
				bt10.setVisible(true);
			}
		});
		mntmNewMenuItem_1_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_5);
		
		JMenuItem mntmNewMenuItem_1_6 = new JMenuItem("getRef");
		mntmNewMenuItem_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT11 bt11 = new BT11();
				bt11.setVisible(true);
				
				setVisible(false);
				bt11.toFront();
				bt11.setVisible(true);
			}
		});
		mntmNewMenuItem_1_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_6);
		
		JMenuItem mntmNewMenuItem_1_7 = new JMenuItem("getQuery");
		mntmNewMenuItem_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT12 bt12 = new BT12();
				bt12.setVisible(true);
				
				setVisible(false);
				bt12.toFront();
				bt12.setVisible(true);
			}
		});
		mntmNewMenuItem_1_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_7);
		
		JMenuItem mntmNewMenuItem_1_8 = new JMenuItem("getUserInfo");
		mntmNewMenuItem_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT13 bt13 = new BT13();
				bt13.setVisible(true);
				
				setVisible(false);
				bt13.toFront();
				bt13.setVisible(true);
			}
		});
		mntmNewMenuItem_1_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_8);
		
		JMenuItem mntmNewMenuItem_1_8_1 = new JMenuItem("getAuthority");
		mntmNewMenuItem_1_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT14 bt14 = new BT14();
				bt14.setVisible(true);
				
				setVisible(false);
				bt14.toFront();
				bt14.setVisible(true);
			}
		});
		mntmNewMenuItem_1_8_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1_8_1);
		
		JMenu mnNewMenu_2 = new JMenu("Retrieving Data from a URL");
		mnNewMenu_2.setForeground(Color.BLUE);
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("openStream");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT15 bt15 = new BT15();
				bt15.setVisible(true);
				
				setVisible(false);
				bt15.toFront();
				bt15.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("openConnection");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT16 bt16 = new BT16();
				bt16.setVisible(true);
				
				setVisible(false);
				bt16.toFront();
				bt16.setVisible(true);
			}
		});
		mntmNewMenuItem_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_2.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_2_2 = new JMenuItem("getContent");
		mntmNewMenuItem_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT17 bt17 = new BT17();
				bt17.setVisible(true);
				
				setVisible(false);
				bt17.toFront();
				bt17.setVisible(true);
			}
		});
		mntmNewMenuItem_2_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_2.add(mntmNewMenuItem_2_2);
		
		JMenuItem mntmNewMenuItem_2_3 = new JMenuItem("sameFile");
		mntmNewMenuItem_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BT18 bt18 = new BT18();
				bt18.setVisible(true);
				
				setVisible(false);
				bt18.toFront();
				bt18.setVisible(true);
			}
		});
		mntmNewMenuItem_2_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_2.add(mntmNewMenuItem_2_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MAI HO\u00C0NG VI\u1EC6T - 51900847");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(145, 114, 386, 159);
		contentPane.add(lblNewLabel);
	}

}
