package guiStuff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import towerStuff.*;

import javax.swing.*;

//Time to do thread stuff

public class MainPanel extends JPanel{

	/**
	 * 
	 */
	private JButton solve;
	private static JFrame frame;
	private int stepIndex;     //To keep track of what step we are at.
	private boolean plug;

	//Represent things in the hanoi puzzle
	private int numDiscs = 6;
	private int start = 0;
	private int end = 2;
	private Tower[] towers;
	private ArrayList<ArrayList<Integer>> steps;

	public MainPanel() {
//		solve = new JButton();
//		solve.setText("Solve");
//		solve.setToolTipText("starts solving the puzzle");
//
//
//		solve.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				frame.repaint();
//			}
//
//		});
//
//
//		this.setLayout(new BorderLayout());
//
//		add(solve, BorderLayout.SOUTH);
		//add(towers, BorderLayout.CENTER);

		//Stuff related to puzzle


		towers = new Tower[3];
		towers[start] = new Tower(numDiscs);
		towers[end] = new Tower();
		towers[3-start-end] = new Tower();
		
		System.out.println("This happened");

		steps = Tower.stepsOfSolution(towers, numDiscs, start, end);



	}

	@Override
	public void paint(Graphics g) {

		if (plug) {

			double tower1Center = this.getWidth()*0.2;  //center coordinate of the first tower
			double tower2Center = this.getWidth()*0.5;  //center coordinate of the second tower
			double tower3Center = this.getWidth()*0.8;  //center coordinate of the third tower

			double bottomPoint = (this.getHeight()*0.8); // the lowest point of all towers
			int numDiscs = 10;

			//giving required info for drawing the towers.
			DrawingUtilities.setBottomPoint(bottomPoint);
			DrawingUtilities.setNumDiscs(numDiscs);
			DrawingUtilities.setTowerHeight((int)(bottomPoint*0.8)); //A fraction of the space above bottomPoint
			DrawingUtilities.setTowerWidth((int)(0.2*getWidth()));

			//Creating required variables and getting the steps

			ArrayList<Integer> step = steps.get(stepIndex++);

			System.out.println(step);
			System.out.println(towers[step.get(0)]);
			Tower.moveDisc(towers[step.get(0)], towers[step.get(1)]);

			DrawingUtilities.drawTower(g, towers[0], tower1Center);
			DrawingUtilities.drawTower(g, towers[1], tower2Center);
			DrawingUtilities.drawTower(g, towers[2], tower3Center);

		}
//		else {
//			towers = new Tower[3];
//			towers[start] = new Tower(numDiscs);
//			towers[end] = new Tower();
//			towers[3-start-end] = new Tower();
//			
//			System.out.println("This happened");
//
//			steps = Tower.stepsOfSolution(towers, numDiscs, start, end);
//		}
		
		plug = true;


	}


	private static void displayFrame(MainPanel panel) {
		frame = new JFrame();
		frame.setContentPane(panel);
		frame.setSize(1000, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				frame.repaint();
			}
		}, 0, 1000);	
	}

	public static void main(String[] args) {

		MainPanel panel = new MainPanel();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				displayFrame(panel);

			}

		});

	}


}
