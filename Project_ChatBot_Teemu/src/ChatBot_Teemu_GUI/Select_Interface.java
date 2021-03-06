package ChatBot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import ChatBot_Teemu_User.User;
import Chatbot_Teemu_Translator.Translator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Scrollbar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Select_Interface extends GUI implements FrameController,ButtonController{

	private static Select_Interface frame;
	
	Chatting_interface ci;
	Start_interface si;
	Translator ts = new Translator();
	
	JPanel contentPane;
	JPanel panel = new JPanel();
	JButton bt;
	private String username;
	public String getUsername() {
		return username;
	}

	/**
	 * Launch the application.
	 */
	public void go() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = getSelect_Interface();
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
	public Select_Interface() {
		
		setTitle("Chat Bot Teemu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		
		try
		{
			JButton bt;
		
			File userfile = new File("User.txt");
		
			FileReader reader = new FileReader(userfile);
		
			BufferedReader br = new BufferedReader(reader);
		
			String line;

			while((line = br.readLine()) != null)
			{
				bt = new JButton();
				bt.setText(line);
				
				username = line;
				
				bt.addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent arg0)
					{
						ci = Chatting_interface.getChatting_interface();
						ci.setVisible(true);
						
						ci.setUser(username);
						
						JTextArea ja = ci.getJTextArea();						
						
						ts.chatLoginitialization(ja,username);
						
						frame.setVisible(false);
						
					}
				}
						);
				panel.add(bt);
			}
		
			br.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JScrollPane scr = new JScrollPane(panel);
		JLabel lblNewLabel = new JLabel("Choose User");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Back\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				si = Start_interface.getStart_interface();
				si.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 20));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(37))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scr, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.setLayout(gl_contentPane);
	}
	
	public static Select_Interface  getSelect_Interface()
	{
		if(frame == null)
			frame = new Select_Interface();
		
		return frame;
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
	
	
	public JPanel getpanel()
	{
		return panel;
	}


	public void ButtonCreater(JPanel panel)
	{
		try
		{
			panel.removeAll();
			JButton bt;
		
			File userfile = new File("User.txt");
		
			FileReader reader = new FileReader(userfile);
		
			BufferedReader br = new BufferedReader(reader);
		
			String line;

			while((line = br.readLine()) != null)
			{
				bt = new JButton();
				bt.setText(line);
				
				String username = line;
				
				bt.addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent arg0)
					{
						ci = Chatting_interface.getChatting_interface();
						ci.setVisible(true);
						
						ci.setUser(username);
						
						JTextArea ja = ci.getJTextArea();						
						
						ts.chatLoginitialization(ja,username);
						
						frame.setVisible(false);
						
					}
				}
						);
				panel.add(bt);
			}
		
			br.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
