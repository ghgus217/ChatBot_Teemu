package ChatBot_Teemu_GUI;

public class GUI_interface {
	
	GUI_interface GUI;
	Start_interface si;

	
	public GUI_interface()
	{
		
	}
	
	
	public void runGUI()
	{
		si = new Start_interface();
		si.go();
	}

}
