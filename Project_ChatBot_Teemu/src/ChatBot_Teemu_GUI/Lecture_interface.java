package ChatBot_Teemu_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

public class Lecture_interface extends JFrame {
	private JPanel contentPane;

	static Lecture_interface frame;

	int i = 1;
	int j = 1;
	int k = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Lecture_interface();
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
	public Lecture_interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		JPanel panel_chapter = new JPanel();
		panel_chapter.setBorder(new TitledBorder(null, "Chapter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(panel_chapter);
		panel_chapter.setLayout(new GridLayout(10, 1, 0, 0));

		JPanel panel_unit = new JPanel();
		panel_unit.setBorder(new TitledBorder(null, "Unit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_unit);
		panel_unit.setLayout(new GridLayout(10, 1, 0, 0));

		JPanel panel_innerunit = new JPanel();
		panel_innerunit
				.setBorder(new TitledBorder(null, "Inner Unit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_innerunit);
		panel_innerunit.setLayout(new GridLayout(10, 1, 0, 0));

		// fileReader

		// show chapter panel
		try {
			// reading chapter names from textFile
			JButton bt_c;
			File chapterFile = new File("chapter.txt");
			FileReader reader_c = new FileReader(chapterFile);
			BufferedReader br_c = new BufferedReader(reader_c);
			String line_c;

			// create chapter buttons and set text with while loop
			while ((line_c = br_c.readLine()) != null) {
				bt_c = new JButton();
				bt_c.setText(line_c);
				panel_chapter.add(bt_c);				

				// addMouselistener for each button
				bt_c.addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						panel_unit.removeAll();
						panel_innerunit.removeAll();

						JButton clickedChapter = (JButton) e.getSource();
						String unitName = clickedChapter.getText();

						// show unit panel
						try {
							// reading unit names from textFile
							JButton bt_u;
							File unitFile = new File(unitName + ".txt");
							FileReader reader_u;
							reader_u = new FileReader(unitFile);
							BufferedReader br_u = new BufferedReader(reader_u);
							String line_u;

							// create unit buttons and set text with while loop
							while ((line_u = br_u.readLine()) != null) {
								bt_u = new JButton();
								bt_u.setText(line_u);
								panel_unit.add(bt_u);

								// addMouselistener for each button
								bt_u.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										panel_innerunit.removeAll();

										JButton clickedUnit = (JButton) e.getSource();
										String innerUnitName = clickedUnit.getText();

										// show innerUnit panel
										try {
											// reading innerUnit name from textFile											
											JButton bt_iu;
											File innerunitFile = new File(innerUnitName + ".txt");
											FileReader reader_iu;
											reader_iu = new FileReader(innerunitFile);
											BufferedReader br_iu = new BufferedReader(reader_iu);
											String line_iu;

											// create innerUnit buttons and set text with while loop
											while((line_iu = br_iu.readLine()) != null) {
												bt_iu = new JButton();
												bt_iu.setText(line_iu);
												panel_innerunit.add(bt_iu);

												// addMouselistener for each button
												bt_iu.addMouseListener(new MouseAdapter() {
													@Override
													public void mousePressed(MouseEvent arg0) {
														System.out.println("No Errors");
													}
												});												
											}

											br_iu.close();
										} catch (FileNotFoundException f) {
											// TODO Auto-generated catch block
											f.printStackTrace();
										} catch (IOException f) {
											// TODO Auto-generated catch block
											f.printStackTrace();
										}
										
										panel_innerunit.validate();

									}
								});

							}
							br_u.close();
						} catch (FileNotFoundException f) {
							// TODO Auto-generated catch block
							f.printStackTrace();
						} catch (IOException f) {
							// TODO Auto-generated catch block
							f.printStackTrace();
						}
						
						panel_unit.validate();
						panel_innerunit.validate();

					}
				});
			}
			br_c.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
