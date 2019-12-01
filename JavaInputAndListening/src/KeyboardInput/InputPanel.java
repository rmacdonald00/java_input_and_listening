package KeyboardInput;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InputPanel extends JPanel{
	
	private int defaultWidth = 600;
	private int defaultHeight = 600;
	private JTextArea text;
	
	private enum Direction{
		UP, DOWN, LEFT, RIGHT;
	}
	
	private Direction dir = null;
	
	public InputPanel() {
		initializePanel();
	}
	
	private void initializePanel() {
		setBackground(Color.blue);
		this.setFocusable(true);

		setPreferredSize(new Dimension(defaultWidth, defaultHeight));
		
		text = new JTextArea("Click an arrow: \n", 15, 30);
		text.setFont(new Font("Serif", Font.PLAIN, 20));
        text.setLineWrap(true);

		this.add(text);
		this.addKeyListener(new MyAdapter());
	}
	
	private void changeWord() {
		if(dir == Direction.UP) {
			text.append("Up ");
		} else if(dir == Direction.DOWN) {
			text.append("Down ");
		} else if(dir == Direction.RIGHT) {
			text.append("Right ");
		} else {
			text.append("Left ");
		}
	//	this.add(text);
	}
	
	private class MyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();
			
		//	System.out.println("key pressed");
			
			if (key == KeyEvent.VK_RIGHT) {
				dir = Direction.RIGHT;
			}
			
			if(key == KeyEvent.VK_LEFT){
				dir = Direction.LEFT;
			}
			
			if(key == KeyEvent.VK_DOWN) {
				dir = Direction.DOWN;
			}
			
			if(key == KeyEvent.VK_UP){
				dir = Direction.UP;
			}
			
			changeWord();
		}
		
	}
}
