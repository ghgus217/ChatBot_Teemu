package ChatBot_Teemu_User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;

public class UserReader {
	private static String username;
	private static User user;

	public UserReader(String oriuser){
		username = oriuser;

		String filename = username+".txt";
		System.out.println(filename);
		File file = new File(filename);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();
			if(o instanceof User){
				user = (User)o;
			}
			

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public File getImage(){
		return user.getUser_image();
	}
}
