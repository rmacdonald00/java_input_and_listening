package KeyboardInput;

import javax.swing.JFrame;

public class ScreenFrame extends JFrame{
	
	public ScreenFrame() {
		initializeUserInterface();
	}
	
	private void initializeUserInterface() {
		add(new InputPanel());
		
		setResizable(true);
		pack();
		
		setTitle("Keyboard Input Screen");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		
		JFrame keys = new ScreenFrame();
		keys.setVisible(true);
		
	}

}
