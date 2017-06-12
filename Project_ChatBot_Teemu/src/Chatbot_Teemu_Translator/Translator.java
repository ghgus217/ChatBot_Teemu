package Chatbot_Teemu_Translator;

import java.io.*;

import javax.swing.*;

import ChatBot_Teemu_GUI.Chatting_interface;

public class Translator {
	
	String UserName;
	String teemu = "Teemu : \n";

	public int setUserText(String usertext)
	{

		if( usertext.compareTo("\n") == 0  || usertext.compareTo("") == 0);
		else
		{
			try {
				File keyword =  new File("keyword.txt");
				FileReader fr = new FileReader(keyword);
				BufferedReader br = new BufferedReader(fr); 
				
				String line;
				
				String[] userline = usertext.split(" ");
				
				while((line = br.readLine())!= null)
				{
					String[] keyline = line.split(" "); 
					
					for(String userkeyword : userline)
					{
						for(String keykeyword : keyline)
						{
							if(userkeyword.compareTo(keykeyword) == 0)
							{
								return Integer.parseInt(keyline[(keyline.length)-1]);
							}
						}
					}
				}		
				fr.close();
				br.close();
				
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	
	public void translate(int index)
	{
		Chatting_interface ci = Chatting_interface.getChatting_interface();
		
		if(index == 0)
		{
			
		}
		
		if(index == 1)
		{
			
			JTextArea ja = ci.getJTextArea();
			ja.setText(teemu+"Hi"+UserName+"\n");
			
			try {
				File userfile = new File(UserName+"clog.txt");
				FileWriter fr = new FileWriter(userfile);
				
				
				fr.append(teemu+"Hi"+UserName+"\n");
				
				fr.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void chatLoginitialization(JTextArea ta, String username)
	{
		
		try {
			
			File userlogfile = new File(username+"clog.txt");
			FileReader fr = new FileReader(userlogfile);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			while((line = br.readLine())!= null)
			{
				ta.append(line+"\n");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setUserName(String user)
	{
		this.UserName = user;
	}
}


