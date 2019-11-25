package algorithms1;

import java.util.Arrays;

public class Board {
	
	/**
	 * // create a board from an n-by-n array of tiles,
     										// where tiles[row][col] = tile at (row, col)
	 */
	
	private int[][] unsolvedBoard;
	private int boardSize;
	
	public Board(int[][] tiles) {
		unsolvedBoard = tiles;
		boardSize = unsolvedBoard[1].length;
		
	}
	public String toString()               // string representation of this board
	{
		String toPrint = Integer.toString(boardSize) + "\n";
		for (int i = 0; i<boardSize; i++){
			toPrint+= Arrays.toString(unsolvedBoard[i]) + "\n";
		}
		return toPrint;
	}
	public int tileAt(int row, int col)    // tile at (row, col) or 0 if blank
	{
		return unsolvedBoard[row][col];
	}
	public int size()                      // board size n
	{
		return boardSize;
	}
	public int hamming()                   // number of tiles out of place
	{
		int hamTotal = 0;
		int[][] goalBoardArray = new int[boardSize][boardSize]; // Generate a goal Board for comparison
		for(int i =0; i<boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				if( j*i != (boardSize-1)*(boardSize-1)) 
				{
					goalBoardArray[i][j]= boardSize*i + j+1;
					if(unsolvedBoard[i][j] != goalBoardArray[i][j]) {
						hamTotal+=1;
					}
				}
				else { goalBoardArray[i][j] = 0; }
				
			}
		}
		Board goalBoard = new Board(goalBoardArray);
		System.out.println ("This is the goal board: \n" + goalBoard.toString());
		return hamTotal;
	}
	public int manhattan()                 // sum of Manhattan distances between tiles and goal
	{
		int manTotal = 0;
		int[][] goalBoardArray = new int[boardSize][boardSize];
		for(int i =0; i<boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				if( j*i != (boardSize-1)*(boardSize-1)) 
				{
					goalBoardArray[i][j]= boardSize*i + j+1;
				
				}
				else { goalBoardArray[i][j] = 0; }
				
				//Manhattan Distance 
				if(unsolvedBoard[i][j] != goalBoardArray[i][j] && unsolvedBoard[i][j] != 0) {
					int unsTile = unsolvedBoard[i][j];
					int goalTile = goalBoardArray[i][j];
					
					if (unsTile > goalTile){
					int vertDistance = (unsTile - goalTile)/boardSize;
					int horDistance = unsTile%goalTile;
					int totalDist = vertDistance + horDistance;
					manTotal+= totalDist;
					}
					
					if (unsTile < goalTile){
						int vertDistance = (goalTile - unsTile)/boardSize;
						int horDistance = goalTile%unsTile;
						int totalDist = vertDistance + horDistance;
						manTotal+= totalDist;
						}
					

				}
			}
		}
		Board goalBoard = new Board(goalBoardArray);
		System.out.println ("This is the goal baord: \n" + goalBoard.toString());	
		return manTotal;
	}
	//public boolean isGoal()                // is this board the goal board?
	//public boolean equals(Object y)        // does this board equal y?
	//public Iterable<Board> neighbors()     // all neighboring boards
	//public boolean isSolvable()            // is this board solvable?
	public static void main(String[] args) // unit testing (required)
	{
		int [][] test2DArray = {{1,2,3},{4,6,5},{7,0,8}};
		Board testBoard = new Board(test2DArray);
		System.out.println(testBoard.toString());
		//System.out.println(testBoard.tileAt(1, 1));
		System.out.println(testBoard.hamming());
		System.out.println(testBoard.manhattan());

	
	}
}
