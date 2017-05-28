package Chatbot_Teemu_GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
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

public class Select_Interface extends JFrame {

	private JPanel contentPane;
	Chatting_interface ci;
	JPanel panel;
	JButton bt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_Interface frame = new Select_Interface();
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
				bt.addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent arg0)
					{
						ci = new Chatting_interface();
						ci.setVisible(true);
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
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scr, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(121)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.setLayout(gl_contentPane);
	}
	
	

}
