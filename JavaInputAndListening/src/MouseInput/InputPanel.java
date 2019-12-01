package MouseInput;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class InputPanel extends JPanel implements ActionListener{
	
	private int defaultWidth = 600;
	private int defaultHeight = 600;
	
	private Image dot;
	private ArrayList<Location> dots = new ArrayList<Location>();
	private Image explosion;
	private ArrayList<Location> explosions = new ArrayList<Location>();
	private Image star;
	private ArrayList<Location> stars = new ArrayList<Location>();
	
	private MyMouseListener mouseListener = new MyMouseListener(this);
	
	public InputPanel() {
		initializePanel();
	}
	
	private void initializePanel() {
		setBackground(Color.blue);
		this.setFocusable(true);

		setPreferredSize(new Dimension(defaultWidth, defaultHeight));
		
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		
		loadImages();

	}
	
	private void loadImages() {
		ImageIcon iiDot = new ImageIcon("src/resources/dot.png");
		dot = iiDot.getImage();
		ImageIcon iiExplosion = new ImageIcon("src/resources/explosion.png");
		explosion = iiExplosion.getImage();
		ImageIcon iiStar = new ImageIcon("src/resources/star.png");
		star = iiStar.getImage();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}


	
	private void doDrawing(Graphics g) {
		for(Location l : dots) {
			g.drawImage(dot, l.getxValue(), l.getyValue(), this);
		}
		for(Location l : explosions) {
			g.drawImage(explosion, l.getxValue(), l.getyValue(), this);
		}
		for(Location l : stars) {
			g.drawImage(star,  l.getxValue(),l.getyValue(), this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	private class MyMouseListener implements MouseListener, MouseMotionListener{
		
		private final InputPanel panel;
		
		public MyMouseListener(InputPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			this.panel.dots.add(new Location((int) arg0.getPoint().getX(), (int) arg0.getPoint().getY()));
			System.out.println("moved to " + arg0.getPoint());
			this.panel.repaint();
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			this.panel.explosions.add(new Location((int) arg0.getPoint().getX(), (int) arg0.getPoint().getY()));
			System.out.println("pressed at " + arg0.getPoint());
			this.panel.repaint();
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			this.panel.stars.add(new Location((int) arg0.getPoint().getX(), (int) arg0.getPoint().getY()));
			System.out.println("released at " + arg0.getPoint());
			this.panel.repaint();
		}
		
	}
}
