package ChatBot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChatBot_Teemu_User.User;

import javax.swing.GroupLayout;
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

public class SignUp_interface extends GUI implements FrameController{

	private static SignUp_interface frame;
	
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox;

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
		
		setBounds(100, 100, 483, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		JLabel lblChooseUserIcon = new JLabel("Choose User Icon");
		panel_1.add(lblChooseUserIcon);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton btnOk = new JButton("OK");
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
						FileWriter fw1 = new FileWriter(newuser);
					
						fw1.write(line+"\n");
						
						fw1.close();
						
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
		
		comboBox = new JComboBox();
		panel_1.add(comboBox);
		
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
