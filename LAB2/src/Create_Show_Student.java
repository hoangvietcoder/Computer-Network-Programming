import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Create_Show_Student extends JFrame{
	
	String check[]= new String[10];
	Student student[] = new Student[10];
	
	private JTextField StudentNumber;
	private JTextField StudentCode;
	private JTextField StudentName;
	private JTextField StudentBirthday;
	private JTextField StudentScore;
	
	public Create_Show_Student() {
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().setLayout(null);
		setTitle("Create Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		
		JLabel lblNewLabel = new JLabel("Enter Student Info");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(116, 10, 172, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 71, 68, 13);
		getContentPane().add(lblNewLabel_1);
		
		StudentNumber = new JTextField();
		StudentNumber.setText("1");
		StudentNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		StudentNumber.setBounds(112, 68, 200, 19);
		getContentPane().add(StudentNumber);
		StudentNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Student Code:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 103, 106, 13);
		getContentPane().add(lblNewLabel_2);
		
		StudentCode = new JTextField();
		StudentCode.setText("SV1");
		StudentCode.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		StudentCode.setBounds(112, 101, 200, 19);
		getContentPane().add(StudentCode);
		StudentCode.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Full Name:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 137, 92, 13);
		getContentPane().add(lblNewLabel_3);
		
		StudentName = new JTextField();
		StudentName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		StudentName.setBounds(112, 135, 200, 19);
		getContentPane().add(StudentName);
		StudentName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Birthday:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 169, 68, 13);
		getContentPane().add(lblNewLabel_4);
		
		StudentBirthday = new JTextField();
		StudentBirthday.setText("2001");
		StudentBirthday.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		StudentBirthday.setBounds(112, 167, 200, 19);
		getContentPane().add(StudentBirthday);
		StudentBirthday.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Score:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 203, 45, 13);
		getContentPane().add(lblNewLabel_5);
		
		StudentScore = new JTextField();
		StudentScore.setText("5.0");
		StudentScore.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		StudentScore.setBounds(112, 201, 200, 19);
		getContentPane().add(StudentScore);
		StudentScore.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = Integer.parseInt(StudentNumber.getText());
				String studentCode = StudentCode.getText();
				String studentName = StudentName.getText();
				int studentBirth = Integer.parseInt(StudentBirthday.getText());
				double studentScore = Double.parseDouble(StudentScore.getText());
				int tmp = 0;
				for (int i = 0; i < 10; i++) {
					if (check[i] != null && check[i].equals(studentCode)) {
						tmp++;
					}
				}
				if (tmp == 0) {
					student[number] = new Student(studentName, studentCode, studentBirth, studentScore);
					check[number] = studentCode;
					StudentNumber.setText("" + (number + 1));
					StudentCode.setText("SV" + (number + 1));
					StudentName.setText("");
					StudentBirthday.setText("2001");
					StudentName.setText("");
					JOptionPane.showMessageDialog(null, "Tao sinh vien " + number + " thanh cong");
				} else
					JOptionPane.showMessageDialog(null, "Tao sinh vien " + number + " khong thanh cong");
				
			}
		});
		btnNewButton.setBounds(112, 257, 85, 33);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Student Info");
				setTitle("Show Student");
				int number = Integer.parseInt(StudentNumber.getText());
				if (student[number] != null) {
					StudentCode.setText(student[number].code);
					StudentName.setText(student[number].name);
					StudentBirthday.setText("" + student[number].birthday + " (" + student[number].getAge() + " tuoi" + ")");
					StudentScore.setText("" + student[number].score);
				} else
					JOptionPane.showMessageDialog(null, "Sinh vien " + number + " khong ton tai");
			}
		});
		btnNewButton_1.setBounds(227, 257, 85, 33);
		getContentPane().add(btnNewButton_1);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Show_Student frame = new Create_Show_Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
