package algorithms1;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.stream.*;

public class Percolation {
	
	//Class members
	int ID[];
	int numOpenSites;
	boolean itPercolates;
	int sides;
	int total;	
	WeightedQuickUnionUF treeGrids;
	
	//Class Methods
	public Percolation(int n) {
		sides = n;
		total = n*n;
		int tt= total+1;
		ID = new int[tt];
		treeGrids = new WeightedQuickUnionUF(total+1);
		for (int i= 1; i<=sides; i++) {
			treeGrids.union(0, i);
		}
		
	}//create n-by-n grid with all sites blocked
	
	public void open (int row, int col) {
		boolean isItOpen = isOpen(row, col);
			
		if (isItOpen == false) {
		
			int index = (sides*(row-1))+ col;
			ID[index] = 1;
			int up = index-sides;
			int down = index+sides;
			int right = index+1;
			int left = index -1;
		
			if (row > 1) { //Check if up is inside grid
				if (ID[up] == 1) { // CHeckif up is open
				treeGrids.union(index, up);
				}
			}
			if (col >1) {
				if (ID[left] == 1) { // CHeckif left is open
				treeGrids.union(index, left);
				}
			}
			if (col < sides) {
				if (ID[right] == 1) { // CHeckif right is open
				treeGrids.union(index, right);
				}
			}
			if (row < sides) {
				if (ID[down] == 1) { // CHeckif right is open
				treeGrids.union(index, down);
				}
			}
		
		}
	} // open sited if it is not already open
	
	public boolean isOpen(int row, int col) {
		boolean openStatus = false;
		int index = (sides*(row-1))+ col;
		if (ID[index]==1) {openStatus = true;}
		return openStatus;
	}// is site (row, col) open?
	
	public boolean isFull(int row, int col) {
		boolean fullStatus = false;
		int index = (sides*(row-1))+ col;
		if(treeGrids.connected(0, index)) {}
		return fullStatus;
	}// is site (row, col) full?
	
	public int numberOfOpenSites() {
		return	IntStream.of(ID).sum();
	}// number of open sites
	
	public boolean percolates()  {
		for(int i= (total - sides); i<=total;i++) {
			if (treeGrids.connected(0, i)) {
				return true;
			}
		}
		return false;
	}// does the system percolate?

	public static void main(String[] args)  {
		//Monte Carlo Simulation
		int nGrid = 10;
		Percolation monteCarlo = new Percolation(nGrid);
//		System.out.println(monteCarlo.total);
//		System.out.println(monteCarlo.sides);
//		System.out.println(Arrays.toString(monteCarlo.ID));
//		monteCarlo.open(1,1);
//		monteCarlo.open(2,2);
//		monteCarlo.open(3,3);
//		monteCarlo.open(4,4);
//		//monteCarlo.open(5,5);
//		System.out.println(Arrays.toString(monteCarlo.ID));
//		System.out.println(monteCarlo.percolates());
//		monteCarlo.open(2,1);
//		monteCarlo.open(3,2);
//		monteCarlo.open(4,3);
//		monteCarlo.open(5,4);
//		System.out.println(Arrays.toString(monteCarlo.ID));
//		System.out.println(monteCarlo.percolates());
//		System.out.println(monteCarlo.numberOfOpenSites());
		
		while(!monteCarlo.percolates()) {
			monteCarlo.open(StdRandom.uniform(1, nGrid+1), StdRandom.uniform(1, nGrid+1));
		}
		System.out.println("number of Open sites = " + monteCarlo.numberOfOpenSites());
		System.out.println(Arrays.toString(monteCarlo.ID));
	} // test client (optional)
}
