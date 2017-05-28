package ChatBot_Teemu_User;

import java.awt.Image;

public class User {

	private String user_name;
	private Image user_image;
	private int lecture_progress;
	private int quiz_progress;
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Image getUser_image() {
		return user_image;
	}
	public void setUser_image(Image user_image) {
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
