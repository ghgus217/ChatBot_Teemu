package ChatBot_Teemu_GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImgPanel extends JPanel {
	File img;

	public ImgPanel(){
		
	}
	public ImgPanel(File file){
		img = file;
	}
	
	
	@Override
	protected void paintComponent(Graphics g){
	Image image = new ImageIcon(img.getName()).getImage();
	g.drawImage(image, 0,0, null);
	}

	public void setImage(File file){
		img = file;
	}
}
	