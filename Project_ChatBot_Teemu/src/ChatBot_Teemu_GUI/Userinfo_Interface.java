package ChatBot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChatBot_Teemu_User.User;
import ChatBot_Teemu_User.UserReader;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class Userinfo_Interface extends GUI {

	private static Userinfo_Interface frame;
	
	private JPanel contentPane;
	private JTextField textField;
	private Chatting_interface chatinterface = new Chatting_interface().getChatting_interface();
	private User user;
	private UserReader userrd;
	private Modify_Interface imagepop;
	private JPanel panel;

	public void setPanel(File name) {
		this.panel = new ImgPanel(name);
	}

	/**
	 * Launch the application.
	 */
	public void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = Userinfo_Interface.getUserinfo_Interface();
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
	public Userinfo_Interface() {
		
		setBounds(100, 100, 414, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.setUsername();
		// Image section
		File imgfile = user.getUser_image();
		panel =new ImgPanel(imgfile);
		panel.setVisible(true);
		
		JLabel lblName = new JLabel("Name :");
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(chatinterface.getUser());
		
		JLabel lblQuizProgress = new JLabel("Quiz Progress");
		
		JProgressBar progressBar = new JProgressBar();
		
		JLabel lblLectureProgress = new JLabel("Lecture Progress");
		
		JProgressBar progressBar_1 = new JProgressBar();
		
		JButton btnExit = new JButton("Exit");
		
		JButton btnChangeImage = new JButton("Change Image");
		btnChangeImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagepop = new Modify_Interface().getInterface();
				imagepop.setVisible(true);
				
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnChangeImage)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuizProgress)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblLectureProgress)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnChangeImage))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addComponent(lblQuizProgress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLectureProgress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static Userinfo_Interface getUserinfo_Interface()
	{
		if(frame == null)
			frame = new Userinfo_Interface();
		
		return frame;
	}
	public void setUsername(){
		String username = chatinterface.getUser();
		File userFile = new File(username+".txt");
		FileInputStream fis;
		try {
			fis = new FileInputStream(userFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Object o = ois.readObject();
		    if(o instanceof User){
		    	user = (User)o;
		    }
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}
}
