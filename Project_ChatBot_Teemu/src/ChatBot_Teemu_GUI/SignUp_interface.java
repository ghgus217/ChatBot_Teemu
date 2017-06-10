package ChatBot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChatBot_Teemu_User.User;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class SignUp_interface extends GUI implements FrameController, Serializable{

	private static SignUp_interface frame;
	
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;
	private Select_Image selimg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private User user;
	private File airplane = new File("Airplane.jpg");
	private File dog = new File("Dog.jpg");
	private File cat = new File("Cat.jpg");

	

	
	/**
	 * Launch the application.
	 */
	public void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = getSignUp_interface();
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
	public SignUp_interface() {
		
		setTitle("Chat Bot Teemu");
		
		setBounds(100, 100, 483, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JPanel panel_1 = new Select_Image();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		
		JLabel lblChooseUserIcon = new JLabel("Choose User Icon");
		
		JRadioButton airplaneRad = new JRadioButton("");
		buttonGroup.add(airplaneRad);
		
		JRadioButton dogRad = new JRadioButton("");
		buttonGroup.add(dogRad);
		
		JRadioButton catRad = new JRadioButton("");
		buttonGroup.add(catRad);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblChooseUserIcon))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(291, Short.MAX_VALUE)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(airplaneRad)
							.addGap(80)
							.addComponent(dogRad, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(catRad, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblChooseUserIcon)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(airplaneRad)
						.addComponent(dogRad)
						.addComponent(catRad))
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(129, Short.MAX_VALUE))
		);
	
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				//duplication check
				if(frame.UnameDupcheck() == 1)
					JOptionPane.showMessageDialog(null, "User ID is Empty!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
				else if(frame.UnameDupcheck() == 2)
					JOptionPane.showMessageDialog(null, textField.getText() + " is already exsist User ID!", "Warning", JOptionPane.INFORMATION_MESSAGE);
				else if(frame.UnameDupcheck() == 3)
				{
					try {
						
						//append new user In in User.txt file
						File userfile = new File("User.txt");
						
						FileWriter writer = new FileWriter(userfile,true); 
						
						BufferedWriter bw = new BufferedWriter(writer);
					
						
						String line = textField.getText();
						
				
						bw.append(line+"\n");
						bw.close();
						
						JOptionPane.showMessageDialog(null,"User name"+ textField.getText() + " is Created succesfully!", "Anouncement", JOptionPane.INFORMATION_MESSAGE);
					
						
						//create new user name text file
						File newuser = new File(line+".txt");
					//	FileWriter fw1 = new FileWriter(newuser);
						
						FileOutputStream fos = new FileOutputStream(newuser);
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						
						if(dogRad.isSelected()){
						user=new User(line, dog);
						}
						else if(catRad.isSelected()){
						user=new User(line, cat);	
						}
						else if(airplaneRad.isSelected()){
						user=new User(line, airplane);
						}
						else{
							JOptionPane.showMessageDialog(null, "Choose Image!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
						}
						oos.writeObject(user);
						oos.close();
						fos.close();
					//	fw1.close();
						
						//create new chat log text file
						File newchatlog = new File(line+"clog.txt");
						FileWriter fw2 = new FileWriter(newchatlog);
						
						fw2.write("");
						
						fw2.close();
						
						
						//reset select button panel
						Select_Interface si = Select_Interface.getSelect_Interface();
						si.ButtonCreater(si.getpanel());
	
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					textField.setText("");
				}
			}
		});
		panel_2.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		panel_2.add(btnCancel);
				
		JLabel lblUserName = new JLabel("User Name :");
		panel.add(lblUserName);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnCheck = new JButton("Duplication Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(frame.UnameDupcheck() == 1)
					JOptionPane.showMessageDialog(null, "User ID is Empty!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
				else if(frame.UnameDupcheck() == 2)
					JOptionPane.showMessageDialog(null, textField.getText() + " is already exsist User ID!", "Warning", JOptionPane.INFORMATION_MESSAGE);
				else if(frame.UnameDupcheck() == 3)
					JOptionPane.showMessageDialog(null, textField.getText() + " is OK!", "Ok", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panel.add(btnCheck);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static SignUp_interface  getSignUp_interface()
	{
		if(frame == null)
			frame = new SignUp_interface();
		
		return frame;
	}

	@Override
	public void setVisibleFrame(JFrame frame) {
		frame.setVisible(true);
	}

	@Override
	public void setInvisibleFrame(JFrame frame) {
		frame.setVisible(false);
	}

	public int UnameDupcheck()
	{
		if(textField.getText().compareTo("")==0)
			return 1;
		else
		{
			try {
				
				File userfile = new File("User.txt");
				
				FileReader reader = new FileReader(userfile);
				
				BufferedReader br = new BufferedReader(reader);
				
				String line;
				
				while((line = br.readLine()) != null)
				{
					if(line.compareTo(textField.getText())==0)
						return 2;
				}
				
				reader.close();
				br.close();
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return 3;
	}
}
