
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Server_File extends JFrame  {
	static ArrayList<MyFile> myFiles = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		int fileId = 0;
		
		JFrame jFrame = new JFrame("Server receiver");
		jFrame.setSize(502, 425);
		jFrame.getContentPane().setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		
		JScrollPane jScrollPane = new JScrollPane(jPanel);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel  jlTitle = new JLabel("File nhận từ client");
		jlTitle.setFont(new Font("Arial",Font.BOLD, 25));
		jlTitle.setBorder(new EmptyBorder(20,0,10,0));
		jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
			
		jFrame.getContentPane().add(jlTitle);
		jFrame.getContentPane().add(jScrollPane);
		jFrame.setVisible(true);
		
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(1234);
		
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				
				int fileNameLength = dataInputStream.readInt();
				
				if(fileNameLength>0) {
					byte[] fileNameBytes = new byte[fileNameLength];
					dataInputStream.readFully(fileNameBytes, 0, fileNameBytes.length);
					String fileName = new String(fileNameBytes);
					
					int fileContentLength = dataInputStream.readInt();
					if(fileContentLength > 0) {
						byte[] fileContentBytes = new byte[fileContentLength];
						dataInputStream.readFully(fileContentBytes, 0, fileContentLength);
						
						JPanel jpFileRow = new JPanel();
						jpFileRow.setLayout(new BoxLayout(jpFileRow, BoxLayout.Y_AXIS));
						
						
						JLabel jlFileName = new JLabel(fileName);
						jlFileName.setFont(new Font("Arial",Font.BOLD,20));
						jlFileName.setBorder(new EmptyBorder(10,0,10,0));
						
						
						if(getFileExtension(fileName).equalsIgnoreCase("txt")) {
							jpFileRow.setName(String.valueOf(fileId));
							jpFileRow.addMouseListener(getMyMouseListener());
							
							jpFileRow.add(jlFileName);
							jPanel.add(jpFileRow);
							jFrame.validate();
						}
						else {
							jpFileRow.setName(String.valueOf(fileId));
							jpFileRow.addMouseListener(getMyMouseListener());
							
							jpFileRow.add(jlFileName);
							jPanel.add(jpFileRow);
							
							jFrame.validate();
					
						}
						
						myFiles.add(new MyFile(fileId, fileName, fileContentBytes, getFileExtension(fileName)));
					}
					
				}
			
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
	}
	
	public static MouseListener getMyMouseListener() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				JPanel jPanel = (JPanel) e.getSource();
				
				int fileId = Integer.parseInt(jPanel.getName());
				
				for(MyFile myFile: myFiles) {
					if(myFile.getId() == fileId) {
						JFrame jfPreview = createFrame(myFile.getName(), myFile.getData(), myFile.getFileExtension());
						jfPreview.setVisible(true);
					}
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
	
	}
	
	public static JFrame createFrame(String fileName, byte[] fileData, String fileExtension) {
		JFrame jFrame = new JFrame("File tai ve");
		jFrame.setSize(600,400);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		
		JLabel jlTitle = new JLabel("Tải file");
		jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		jlTitle.setFont(new Font("Arial",Font.BOLD,25));
		jlTitle.setBorder(new EmptyBorder(20,0,10,0));
		
		JLabel jlPromt = new JLabel("Bạn có chắc muốn tải file này không: " +fileName);
		jlPromt.setAlignmentX(Component.CENTER_ALIGNMENT);
		jlPromt.setFont(new Font("Arial",Font.BOLD,25));
		jlPromt.setBorder(new EmptyBorder(20,0,10,0));
		
		JButton jbYes = new JButton("Yes");
		jbYes.setPreferredSize(new Dimension(150,75));
		jbYes.setFont(new Font("Arial",Font.BOLD,20));
		
		JButton jbNo = new JButton("No");
		jbNo.setPreferredSize(new Dimension(150,75));
		jbNo.setFont(new Font("Arial",Font.BOLD,20));
		
		JLabel jlFileContent = new JLabel();
		jlFileContent.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel jpButtons = new JPanel();
		jpButtons.setBorder(new EmptyBorder(20,0,10,0));
		jpButtons.add(jbYes);
		jpButtons.add(jbNo);
		
		if(fileExtension.equalsIgnoreCase("txt")) {
			jlFileContent.setText("<html>" + new String(fileData) + "</html>");
		}else {
			jlFileContent.setIcon(new ImageIcon(fileData));
		}
		
		
		
		jbYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File fileDownload = new File(fileName);
				
				try {
					FileOutputStream fileOutputStream = new FileOutputStream(fileDownload);
					
					fileOutputStream.write(fileData);
					fileOutputStream.close();
					
				} catch (IOException e2) {
					// TODO: handle exception
					
					e2.printStackTrace();
				}
				
			}
		});
		
		jbNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
			}
		});
		
		jPanel.add(jlTitle);
		jPanel.add(jlPromt);
		jPanel.add(jlFileContent);
		jPanel.add(jpButtons);
		
		jFrame.getContentPane().add(jPanel);
		
		return jFrame;
	}
	
	public static String getFileExtension(String fileName) {
		int i  = fileName.lastIndexOf('.');
		if(i>0) {
			return fileName.substring(i + 1);
		}
		else {
			return "No extension";
		}
	}
}
