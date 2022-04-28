package towerStuff;

public class ConsoleTesting {
	
	private static Tower[] towers = {new Tower(), new Tower(), new Tower()};
	
	private static final int NUM_DISCS = 4;
	private static final int STARTING_POSITION = 0;
	private static final int ENDING_POSITION = 2;
	

	public static void main(String[] args) {
		
		for (int i = NUM_DISCS; i > 0; i--) {
			towers[STARTING_POSITION].addDisc(new Disc(i));
		}
		 
		printTowers();
		hanoiSolve(NUM_DISCS, STARTING_POSITION, ENDING_POSITION);
		
		

	}
	
	private static void printTowers() {
		System.out.println("----------------------------------\n");
		System.out.println("Tower1: " + towers[0]);
		System.out.println("Tower2: " + towers[1]);
		System.out.println("Tower3: " + towers[2]);
		System.out.println("\n----------------------------------\n");
		
	}
	
	private static void hanoiSolve(int num, int start, int end) {
		int other = 3-(start+end);
		
		if (num <= 0) {
			return;
		}
		
		hanoiSolve(num-1, start, other);
		Tower.moveDisc(towers[start], towers[end]);
		System.out.println("Moved " + towers[end].getTopDisc() + " from " + start + " to " + end);
		printTowers();
		hanoiSolve(num-1, other, end);
	}
	
	
	

}
