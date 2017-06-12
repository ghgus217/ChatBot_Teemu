package ChatBot_Teemu_GUI;

public class GUI_interface {
	
	GUI_interface GUI;
	Start_interface si;
	
	public void runGUI()
	{
		si = Start_interface.getStart_interface();
		si.go();
	}

}
