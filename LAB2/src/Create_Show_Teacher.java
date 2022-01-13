import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class Create_Show_Teacher extends JFrame {
	
	String check[] = new String[10];
	public Teacher teacher[] = new Teacher[10];
	
	private JTextField TeacherNumber;
	private JTextField TeacherCode;
	private JTextField TeacherName;
	private JTextField TeacherBirthday;
	private JTextField TeacherSalary;


	public Create_Show_Teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setTitle("Create and Show Teacher");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Teacher Info");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(106, 10, 170, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 64, 66, 13);
		getContentPane().add(lblNewLabel_1);
		
		TeacherNumber = new JTextField();
		TeacherNumber.setText("1");
		TeacherNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		TeacherNumber.setBounds(116, 61, 184, 19);
		getContentPane().add(TeacherNumber);
		TeacherNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher Code:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 104, 102, 13);
		getContentPane().add(lblNewLabel_2);
		
		TeacherCode = new JTextField();
		TeacherCode.setText("GV1");
		TeacherCode.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		TeacherCode.setBounds(116, 101, 184, 19);
		getContentPane().add(TeacherCode);
		TeacherCode.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Full Name:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 142, 82, 13);
		getContentPane().add(lblNewLabel_3);
		
		TeacherName = new JTextField();
		TeacherName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		TeacherName.setBounds(116, 140, 184, 19);
		getContentPane().add(TeacherName);
		TeacherName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Birthday:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 180, 66, 13);
		getContentPane().add(lblNewLabel_4);
		
		TeacherBirthday = new JTextField();
		TeacherBirthday.setText("1986");
		TeacherBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		TeacherBirthday.setBounds(116, 178, 184, 19);
		getContentPane().add(TeacherBirthday);
		TeacherBirthday.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Salary:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 219, 55, 13);
		getContentPane().add(lblNewLabel_5);
		
		TeacherSalary = new JTextField();
		TeacherSalary.setText("15000000");
		TeacherSalary.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		TeacherSalary.setBounds(116, 217, 184, 19);
		getContentPane().add(TeacherSalary);
		TeacherSalary.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = Integer.parseInt(TeacherNumber.getText());
				String teacherCode = TeacherCode.getText();
				String teacherName = TeacherName.getText();
				int teacherBirth = Integer.parseInt(TeacherBirthday.getText());
				int teacherSalary = Integer.parseInt(TeacherSalary.getText());
				int tmp = 0;
				for (int i = 0; i < 10; i++) {
					if (check[i] != null && check[i].equals(teacherCode)) {
						tmp++;
					}
				}
				if (tmp == 0) {
					teacher[number] = new Teacher(teacherName, teacherCode, teacherBirth, teacherSalary);
					check[number] = teacherCode;
					TeacherNumber.setText("" + (number + 1));
					TeacherCode.setText("GV" + (number + 1));
					TeacherName.setText("");
					TeacherBirthday.setText("2001");
					TeacherSalary.setText("");
					JOptionPane.showMessageDialog(null, "Tao giao vien " + number + " thanh cong");
				} else
					JOptionPane.showMessageDialog(null, "Tao giao vien " + number + " khong thanh cong");
			}
		});
		btnNewButton.setBounds(116, 258, 85, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Teacher Info");
				setTitle("Show Teacher Info");
				int number = Integer.parseInt(TeacherNumber.getText());
				if (teacher[number] != null) {
					TeacherCode.setText(teacher[number].code);
					TeacherName.setText(teacher[number].name);
					TeacherBirthday.setText("" + teacher[number].birthday + " (" + teacher[number].getAge() + " tuoi" + ")");
					TeacherSalary.setText("" + teacher[number].salary);
				} else
					JOptionPane.showMessageDialog(null, "Giao vien " + number + " khong ton tai");

			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(215, 258, 85, 29);
		getContentPane().add(btnNewButton_1);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Show_Teacher frame = new Create_Show_Teacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
