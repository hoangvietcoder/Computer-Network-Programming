import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Main_Menu extends JFrame {
	
	public Student student[] = new Student[10];
	public Teacher teacher[] =  new Teacher[10];
	
	public Main_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setTitle("Main Menu");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Create User");
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Create Student");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create_Show_Student create_show_Student = new Create_Show_Student();
				create_show_Student.setVisible(true);
			}
		});
		mntmNewMenuItem.setForeground(Color.BLACK);
		mntmNewMenuItem.setFont(new Font("Fira Code", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Create Teacher");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Create_Show_Teacher create_show_Teacher = new Create_Show_Teacher();
				create_show_Teacher.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setForeground(Color.BLACK);
		mntmNewMenuItem_1.setFont(new Font("Fira Code", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Show User");
		mnNewMenu_1.setBackground(Color.WHITE);
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);
			
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Show Student");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " Student Code:" + student[0].code+ "\nStudent Name: " + student[0].name);
			}
		});
		mntmNewMenuItem_2.setForeground(Color.BLACK);
		mntmNewMenuItem_2.setFont(new Font("Fira Code", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Show Teacher");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " Teacher Code:"+ teacher[0].code+ "\nTeacher Name: " + teacher[0].name);
			}
		});
		mntmNewMenuItem_3.setForeground(Color.BLACK);
		mntmNewMenuItem_3.setFont(new Font("Fira Code", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MAI HO\u00C0NG VI\u1EC6T - 51900847");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(47, 96, 299, 87);
		panel.add(lblNewLabel);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu frame = new Main_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
