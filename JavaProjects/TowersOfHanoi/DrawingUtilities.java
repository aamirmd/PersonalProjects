import java.awt.Graphics;

/*Contains static methods to help in drawing the towers of hanoi*/

public class DrawingUtilities {
	
	
	private static int towerHeight;
	private static int towerWidth;
	private static int numDiscs;
	private static double bottomPoint;  //The lowest point of all 3 towers
	
	/*The 4 methods below are setters for all of them*/
	public static void setTowerHeight(int towerL) {
		towerHeight = towerL;
	}
	
	public static void setTowerWidth(int towerW) {
		towerWidth = towerW;
	}
	
	public static void setNumDiscs(int discNumber) {
		numDiscs = discNumber;
	}
	
	public static void setBottomPoint(double bottom) {
		bottomPoint = bottom;
	}
	
	/*Returns the height of each disc. This value is same regardless of height of disc*/
	private static int heightOfDisc() {
		return towerHeight/numDiscs;
	}
	
	
	/*
	 * Draws a disc on the GUI using graphics from AWT package.
	 * @param g - The Graphics object used to draw on a panel
	 * @param d - The disc which is to be drawn. Need it to calculate width of a disc, which is done using the size.
	 * @param center - The center coordinate of the disc.
	 * @param discNumber - Tells where the disc is located in the tower. The bottom-most disc is numbered 1, the second bottom 2, 
	 *                     and so on.
	 */
	public static void drawDisc(Graphics g, Disc d, double center, int discNumber) {
		//Width is calculated based on the size of the disc.
		//The width of the disc with greatest size is the entire width of the tower
		//The width is calculated as a fraction of the tower width
		double discWidth = (double)towerWidth/numDiscs*d.getSize();
		
		int x = (int)(center-discWidth/2);  //left top x coordinate of a disc. Center - half of width
		
		//left top y coordinate depends on how much higher we go from the bottomPoint.
		//Decreases as discNumber keeps increasing, hence going higher.
		int y = (int)(bottomPoint-discNumber*heightOfDisc());
		
		g.drawRect(x, y, (int)discWidth, heightOfDisc());
	}
	
	/*
	 * Draws a tower on the GUI.
	 * @param g - The Graphics object used to draw on a panel
	 * @param t - The tower which is to be drawn.
	 * @param center - The center coordinate of the tower. Same as all discs in the tower.
	 */
	public synchronized static void drawTower(Graphics g, Tower t, double center) {
		//Draws a line to denote the towers
		g.drawLine((int)center, (int)bottomPoint, (int)center, (int)bottomPoint-towerHeight);
		//Starts drawing from bottom to top i.e. the biggest disc gets drawn first, and so on.
		int discNumber = 1;
		for (Disc d : t) {
			drawDisc(g, d, center, discNumber++);
		}
	}

	
	


}
