import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Tower implements Iterable<Disc>{

	private Stack<Disc> stack;
	
	public Tower() {
		stack = new Stack<Disc>();
	}
	
	public Tower(int numDiscs) {
		stack = new Stack<Disc>();
		
		for (int i = numDiscs; i >0; i--) {
			stack.add(new Disc(i));
		}
	}
	
	public boolean isEmpty() {
		return stack.empty();
	}
	
	public boolean addDisc(Disc item) {
		if (item == null) {
			return false;
		}
		
		stack.push(item);
		return true;
		
	}
	
	public Disc removeDisc() {
		return stack.pop();
	}
	
	public Disc getTopDisc() {
		return stack.peek();
	}
	
	/*Moves disc from tower 1 to tower 2.
	 * Throws an exception if a larger disc is put on top of a smaller disc
	 * */
	public static void moveDisc(Tower t1, Tower t2) {
		
		Disc item = t1.removeDisc(); //The Disc to be switched
		
		if (!t2.isEmpty() && t2.getTopDisc().compareTo(item) < 0) {   //If the disc transfer is illegal because of size
			//Could not think of a better exception
			throw new IllegalArgumentException("Trying to put " + item + " on top of " + t2.getTopDisc());
		}
		
		t2.addDisc(item);
	}
	
	public String toString() {
		return stack.toString();
	}

	@Override
	public Iterator<Disc> iterator() {
		return stack.iterator();
	}
	
	/*
	 * This method takes in a few parameters about the hanoi towers puzzle we are trying to solve and returns 
	 * the steps taken to solve it.
	 * @param towers - The array which contains the 3 towers in the hanoi towers puzzle
	 * @param num - The number of discs in the towers of hanoi puzzle
	 * @param start - The starting tower of the puzzle (should be from 0-2)
	 * @param end - The ending tower of the puzzle (should be from 0-2)
	 * 
	 * @return An ArrayList of int[]. Each item in the ArrayList is an int[] of size 2. 
	 * The first int is the starting index of a disc and the second position is the ending index of that disc.
	 * 
	 * @throws IllegalArgumentException in the following cases.
	 * - The length of towers is not 3
	 * - The start and end positions are not within the range 0-2
	 */
	public static ArrayList<ArrayList<Integer>> stepsOfSolution(Tower[] towers, int num, int start, int end) {
		
		if (towers.length != 3) {
			throw new IllegalArgumentException("Number of towers is NOT three");
		}
		
		if (towers[start].isEmpty()) {
			throw new IllegalArgumentException("Starting tower index " + start + " is empty");
		}
		
		if (!(start >= 0 && start <= 2) || !(end >= 0 && end <= 2)) {
			throw new IllegalArgumentException("start is " + start + " and end is " + end);
		}
		
		ArrayList<ArrayList<Integer>> steps = new ArrayList<ArrayList<Integer>>();
		
		hanoiSolve(towers, steps, num, start, end);
		
		return steps;
		
	}
	
	/*
	 * Solves the hanoi puzzle using recursion.
	 * @param towers - The array which has the 3 towers of hanoi
	 * @param steps - The ArrayList where the steps are recorded
	 * @param num - The number of discs to be moved from start to end
	 * @param start - The starting tower of the puzzle (should be from 0-2)
	 * @param end - The ending tower of the puzzle (should be from 0-2)
	 */
	private static void hanoiSolve(Tower[] towers, ArrayList<ArrayList<Integer>> steps, int num, int start, int end) {
		
		if (num <= 0) {
			return;    //base case
		}
		
		int other = 3-(start+end);  //calculating the third index
		
		hanoiSolve(towers, steps, num-1, start, other);  //moves num-1 discs to the third index named other
		Tower.moveDisc(towers[start], towers[end]);     //moves the 1 remaining disc to the destination
		
		ArrayList<Integer> step = new ArrayList<Integer>();  //Adds the step to the steps ArrayList
		
		step.add(start);
		step.add(end);
		steps.add(step);
		
		hanoiSolve(towers, steps, num-1, other, end);   //moves the num-1 discs at other to the destination
	}
	
	
}
