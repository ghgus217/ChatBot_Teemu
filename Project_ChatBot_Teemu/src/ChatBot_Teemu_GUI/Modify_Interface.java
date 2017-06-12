package ChatBot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChatBot_Teemu_GUI.Select_Image;
import ChatBot_Teemu_User.User;
import ChatBot_Teemu_User.UserReader;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Modify_Interface extends GUI {
	
	private static Modify_Interface frame;
	private Chatting_interface chatinterface;
	private String username;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton airplaneRad = new JRadioButton("");
	private JRadioButton dogRad = new JRadioButton("");
	private JRadioButton catRad = new JRadioButton("");
	private User user;
	private UserReader usercont;
	
	private int selected=0;

	public int getSelected() {
		return selected;
	}

	/**
	 * Launch the application.
	 */
	public static void go(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = Modify_Interface.getInterface();
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
	public Modify_Interface() {
		setTitle("Change image");
		chatinterface = Chatting_interface.getChatting_interface();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectImage = new JLabel("Select Image");
		
		JPanel panel = new Select_Image();
		
		buttonGroup.add(airplaneRad);
		buttonGroup.add(dogRad);
		buttonGroup.add(catRad);
		
		username = chatinterface.getUser();

		File filename = new File(username+".txt");
		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			if(o instanceof User){
				user = (User)o;
			}
			ois.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(airplaneRad.isSelected()){
					File imgfile = new File("Airplane.jpg");
					File newfile = new File(username+".txt");
					this.modifyImage(newfile, imgfile);
					
					Userinfo_Interface ui = Userinfo_Interface.getUserinfo_Interface();
					ImgPanel panel = ui.getpanel();
					panel.setImage(imgfile);
					
					if(ui.isVisible() == true)
					{
						ui.setVisible(false);
						ui.setVisible(true);
					}

					frame.setVisible(false);
					
				}
				else if(dogRad.isSelected()){
					File imgfile = new File("Dog.jpg");
					File newfile = new File(username+".txt");
					this.modifyImage(newfile, imgfile);
					Userinfo_Interface ui = Userinfo_Interface.getUserinfo_Interface();
					ImgPanel panel = ui.getpanel();
					panel.setImage(imgfile);

					if(ui.isVisible() == true)
					{
						ui.setVisible(false);
						ui.setVisible(true);
					}

					
					frame.setVisible(false);

				}
				else if(catRad.isSelected()){
					File imgfile = new File("Cat.jpg");
					File newfile = new File(username+".txt");
					this.modifyImage(newfile, imgfile);
					
					Userinfo_Interface ui = Userinfo_Interface.getUserinfo_Interface();
					ImgPanel panel = ui.getpanel();
					panel.setImage(imgfile);
					
					if(ui.isVisible() == true)
					{
						ui.setVisible(false);
						ui.setVisible(true);
					}


					frame.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Select Image", "Caution", JOptionPane.INFORMATION_MESSAGE);
				}

			}

			private void modifyImage(File file, File image) {
				user.setUser_image(image);
				String filename = file.getName();
				file.delete();
				File newfile = new File(filename);
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(newfile);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(user);
					oos.close();
					fos.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectImage)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSave)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))
									.addGap(16))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(airplaneRad, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(80)
							.addComponent(dogRad, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(catRad, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblSelectImage)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(airplaneRad)
						.addComponent(dogRad)
						.addComponent(catRad))
					.addGap(20)
					.addComponent(btnSave)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public static Modify_Interface getInterface()
	{
		if(frame == null)
			frame = new Modify_Interface();
		return frame;
	}
	
	
	public JPanel getcontentPane()
	{
		return this.contentPane;
	}
	
}
