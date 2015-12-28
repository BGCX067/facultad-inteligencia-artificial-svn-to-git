package problema;



import aima.search.framework.GoalTest;

/**
 * @author Ravi Mohan
 * 
 */

public class EightPuzzleGoal implements GoalTest {
	EightPuzzleBoard goal = new EightPuzzleBoard(new int[] { 1,2,3,4,0,5,6,7,8 });

	public boolean isGoalState(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
		return board.equals(goal);
	}

}