package guiStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;

public class TowerPanel extends JPanel{
	
	public TowerPanel() {
		this.setSize(100, 100);
	}
	
	@Override
	public void paint(Graphics g) {
		
		Random random = new Random();
		g.setColor(Color.GREEN);
		
		int height = random.nextInt(this.getWidth());
		int width = random.nextInt(this.getHeight());
		g.drawLine(0, 0, width, height);
	}
	
	
	

}
