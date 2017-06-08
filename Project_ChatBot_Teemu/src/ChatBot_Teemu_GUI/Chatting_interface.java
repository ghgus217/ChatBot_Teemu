package ChatBot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ChatBot_Teemu_User.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class Chatting_interface extends GUI implements FrameController,ButtonController{
	
	private static Chatting_interface frame;

	private JPanel contentPane;
	private JTextField textField_1;
	
	Userinfo_Interface uii;
	
	User user;
	

	/**
	 * Launch the application.
	 */
	public void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = getChatting_interface();
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
	public Chatting_interface() {
		setTitle("Chat Bot Teemu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Font font = new Font("Serif",Font.PLAIN,20);
		
		JButton btnNewButton_3 = new JButton("Explanation");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setFont(font);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnUserInformation = new JButton("User Information");
		btnUserInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uii = new Userinfo_Interface();
				uii.setVisible(true);
				
			}
		});
		btnUserInformation.setFont(font);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHelp.setFont(font);
		
		JButton btnSdkjsakdalsjkdlkjas = new JButton("Lecture");
		btnSdkjsakdalsjkdlkjas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSdkjsakdalsjkdlkjas.setFont(font);
		
		JButton btnImage = new JButton("Image");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImage.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JButton btnSamplecode = new JButton("Code");
		btnSamplecode.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JButton btnClass = new JButton("Class");
		btnClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClass.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JButton btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnSend.setFont(new Font("Serif", Font.PLAIN, 20));
		
		
		JTextArea textArea = new JTextArea();
		JScrollPane sc = new JScrollPane(textArea);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnImage, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSamplecode, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnClass, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_1, 683, 683, 683))
						.addComponent(sc, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSdkjsakdalsjkdlkjas, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addComponent(btnUserInformation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnHelp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
							.addGap(49))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(sc, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUserInformation, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(263)
										.addComponent(btnHelp, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
									.addComponent(btnSdkjsakdalsjkdlkjas, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(45)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btnClass, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btnSamplecode, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
														.addGap(34))
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnImage, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED))))))
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(33))))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static Chatting_interface  getChatting_interface()
	{
		if(frame == null)
			frame = new Chatting_interface();
		
		return frame;
	}
	
	public void setUser(User getinuser)
	{
		if(getinuser != null)
			user = getinuser;
	}

	@Override
	public void setVisibleButton(JButton button) {
		button.setVisible(true);
		
	}

	@Override
	public void setInvisibleButton(JButton button) {
		button.setVisible(false);
		
	}

	@Override
	public void setNameButton(JButton button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVisibleFrame(JFrame frame) {
		frame.setVisible(true);
	}

	@Override
	public void setInvisibleFrame(JFrame frame) {
		frame.setVisible(false);
	}
}
