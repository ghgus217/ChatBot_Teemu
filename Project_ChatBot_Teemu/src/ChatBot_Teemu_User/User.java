package ChatBot_Teemu_User;

import java.io.File;
import java.io.Serializable;

public class User implements Serializable{

	private String user_name;
	private File user_image;
	private int lecture_progress;
	private int quiz_progress;
	
	public User(){
		lecture_progress=quiz_progress=0;
	}
	public User(String name, File image){
		lecture_progress=quiz_progress=0;
		user_name=name;
		user_image=image;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public File getUser_image() {
		return user_image;
	}
	public void setUser_image(File user_image) {
		this.user_image = user_image;
	}
	public int getLecture_progress() {
		return lecture_progress;
	}
	public void setLecture_progress(int lecture_progress) {
		this.lecture_progress = lecture_progress;
	}
	public int getQuiz_progress() {
		return quiz_progress;
	}
	public void setQuiz_progress(int quiz_progress) {
		this.quiz_progress = quiz_progress;
	}
	
}
