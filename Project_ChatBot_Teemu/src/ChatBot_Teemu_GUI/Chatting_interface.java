package ChatBot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ChatBot_Teemu_User.User;
import Chatbot_Teemu_Translator.Translator;

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Chatting_interface extends GUI implements FrameController,ButtonController{
	
	private static Chatting_interface frame;

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextArea textArea;
	
	Userinfo_Interface uii;
	
	Translator ts = new Translator();

	String user;

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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		JMenuItem mntmThema = new JMenuItem("Theme");
		mnOption.add(mntmThema);
		
		JMenuItem mntmLogout = new JMenuItem("LogOut");
		mnOption.add(mntmLogout);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnAbout.add(mntmHelp);
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
		
		JButton btnImage = new JButton("Image");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImage.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JButton btnSamplecode = new JButton("Code");
		btnSamplecode.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JButton btnClass = new JButton("Quiz");
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
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String usertext = textField_1.getText();
				textField_1.setText("");
				
				ts.setUserName(user);
				
				int index= ts.setUserText(usertext);
				
				
				
				ts.translate(index);
				
			}
		});
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnSend.setFont(new Font("Serif", Font.PLAIN, 20));
		
		
		textArea = new JTextArea();
		JScrollPane sc = new JScrollPane(textArea);
		
		JButton btnLecture = new JButton("Lecture");
		btnLecture.setFont(new Font("Serif", Font.PLAIN, 20));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton_3)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnImage, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSamplecode, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(btnClass, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textField_1, 683, 683, 683))
						.addComponent(sc, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnUserInformation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLecture, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
							.addGap(49))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sc, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnUserInformation, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(76)
							.addComponent(btnLecture, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(173)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnClass, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSamplecode, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnImage, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
								.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static Chatting_interface  getChatting_interface()
	{
		if(frame == null)
			frame = new Chatting_interface();
		
		return frame;
	}
	
	public void setUser(String user)
	{
		if(user != null)
			this.user = user;
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
	
	public JTextArea getJTextArea()
	{
		return this.textArea;
	}
	

}
