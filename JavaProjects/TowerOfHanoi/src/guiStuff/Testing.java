package guiStuff;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import towerStuff.Tower;

public class Testing {

	@Test
	public void testStepsArrayList() {
		
		int numDiscs = 3;
		
		Tower[] towers = {new Tower(numDiscs), new Tower(), new Tower()};
		
		int start = 0;
		int end = 2;
		
		ArrayList<ArrayList<Integer>> steps = Tower.stepsOfSolution(towers, numDiscs, start, end);
		
		System.out.println(steps);
		
		
	}

}
