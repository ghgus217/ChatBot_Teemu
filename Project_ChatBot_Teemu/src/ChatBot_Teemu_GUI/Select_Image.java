package ChatBot_Teemu_GUI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Select_Image extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		Image airplane = new ImageIcon("Airplane.jpg").getImage();
		Image dog = new ImageIcon("Dog.jpg").getImage();
		Image cat = new ImageIcon("Cat.jpg").getImage();

		g.drawImage(airplane, 0, 0, null);
		g.drawImage(dog, 110, 0, null);
		g.drawImage(cat, 220, 0, null);
	}
}