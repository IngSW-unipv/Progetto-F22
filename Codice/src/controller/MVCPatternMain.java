package controller;
import Sistema.Sistema;
import packageframe.Frame;

public class MVCPatternMain {

	public static void main(String[] args) {
		
		Frame view = new Frame();
		Sistema model = new Sistema();
		Controller controller = new Controller(model, view);
		
		controller.initComponents();
	
	}
}
