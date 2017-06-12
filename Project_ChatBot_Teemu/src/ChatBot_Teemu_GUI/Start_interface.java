package ChatBot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Start_interface extends GUI implements FrameController{

	private static Start_interface frame;
	
	Select_Interface select;
	SignUp_interface signup;

	JPanel contentPane;
	JLabel titlelabel;
	JButton createUser;
	JButton chooseUser;
	
	/**
	 * Launch the application.
	 */
	public void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = getStart_interface();
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
	
	public Start_interface() {
		
		setTitle("Chat Bot Teemu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Font font = new Font("Serif",Font.PLAIN, 50);
		
		titlelabel = new JLabel("Chat Bot Teemu");
		
		createUser = new JButton("Create User");
		createUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				signup = SignUp_interface.getSignUp_interface();
				signup.setVisible(true);
			}
		});
		
		
		chooseUser = new JButton("Chose User");
		chooseUser.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent arg0) {
				select = Select_Interface.getSelect_Interface();
				select.setVisible(true);
				frame.setVisible(false);
			}
		});

		titlelabel.setFont(font);
		
		font = new Font("Serif",Font.PLAIN, 20);
		createUser.setFont(font);
		chooseUser.setFont(font);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addComponent(chooseUser, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(createUser, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(123)
					.addComponent(titlelabel, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addGap(115))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(titlelabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(createUser, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(chooseUser, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGap(142))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public static Start_interface  getStart_interface()
	{
		if(frame == null)
			frame = new Start_interface();
		
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


	
	
}
