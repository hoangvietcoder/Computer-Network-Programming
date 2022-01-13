import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class Menu extends JFrame {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		this.setTitle("Menu");
		this.setBounds(100, 100, 594, 377);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("The InetAddress Class");
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("getByName");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress_GetByName getByName = new InetAddress_GetByName();
				getByName.setVisible(true);
				setVisible(false);
				getByName.toFront();
				getByName.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("getAllByName");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress_GetAllByName getAllByName = new InetAddress_GetAllByName();
				getAllByName.setVisible(true);
				setVisible(false);
				getAllByName.toFront();
				getAllByName.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("getLocalHost");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress_GetLocalHost getLocalHost = new InetAddress_GetLocalHost();
				getLocalHost.setVisible(true);
				setVisible(false);
				getLocalHost.toFront();
				getLocalHost.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("getHostName");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress_GetHostName getHostName = new InetAddress_GetHostName();
				getHostName.setVisible(true);
				setVisible(false);
				getHostName.toFront();
				getHostName.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("getHostAddress");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress_GetHostAddress getHostAddress = new InetAddress_GetHostAddress();
				getHostAddress.setVisible(true);
				setVisible(false);
				getHostAddress.toFront();
				getHostAddress.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("getAddress");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress_GetAddress getAddress = new InetAddress_GetAddress();
				getAddress.setVisible(true);
				setVisible(false);
				getAddress.toFront();
				getAddress.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("AddressTypes");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress_AddressTypes addressTypes = new InetAddress_AddressTypes();
				addressTypes.setVisible(true);
				setVisible(false);
				addressTypes.toFront();
				addressTypes.setVisible(true);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("BooleanEquals");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InetAddress_BooleanEquals booleanEquals = new InetAddress_BooleanEquals();
				booleanEquals.setVisible(true);
				setVisible(false);
				booleanEquals.toFront();
				booleanEquals.setVisible(true);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("The NetworkInterface Class");
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("getByName");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetworkInterface_GetByName getByName = new NetworkInterface_GetByName();
				getByName.setVisible(true);
				setVisible(false);
				getByName.toFront();
				getByName.setVisible(true);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("getByInetAddress");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetworkInterface_GetByInetAddress getByInetAddress = new NetworkInterface_GetByInetAddress();
				getByInetAddress.setVisible(true);
				setVisible(false);
				getByInetAddress.toFront();
				getByInetAddress.setVisible(true);
				
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("getNetworkInterfaces");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enumeration_GetNetworkInterfaces getNetworkInterface = new Enumeration_GetNetworkInterfaces();
				getNetworkInterface.setVisible(true);
				setVisible(false);
				getNetworkInterface.toFront();
				getNetworkInterface.setVisible(true);
			}
		});
		mntmNewMenuItem_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_2 = new JMenu("HomeWork");
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("WebLog");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Weblog webLog = new Weblog();
				webLog.setVisible(true);
				setVisible(false);
				webLog.toFront();
				webLog.setVisible(true);
			}
		});
		mntmNewMenuItem_11.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_11);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mai Ho\u00E0ng Vi\u1EC7t - 51900847");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(138, 54, 310, 170);
		getContentPane().add(lblNewLabel);
	}
}
