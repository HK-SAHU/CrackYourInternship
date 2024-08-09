import java.util.*;

public class MazePathFinder {

	// Rows and columns in given maze
	private static int N = 9;
	// For searching in all 4 direction
	private static int[] row = { -1, 1, 0, 0 };
	private static int[] col = { 0, 0, -1, 1 };
	// Coordinates of 4 corners of matrix
	private static int[] _row = { 0, 0, N - 1, N - 1 };
	private static int[] _col = { 0, N - 1, 0, N - 1 };

	// check whether given cell is a valid cell or not.
	private static boolean isValid(ArrayList<int[]> visited,
								int[] pt)
	{
		// check if cell is not visited yet to
		// avoid cycles (infinite loop) and its
		// row and column number is in range
		return (pt[0] >= 0) && (pt[0] < N) && (pt[1] >= 0)
			&& (pt[1] < N)
			&& (!visited.stream().anyMatch(
				item
				-> item[0] == pt[0] && item[1] == pt[1]));
	}
	// Function to print path from source to middle
	// coordinate
	private static void printPath(ArrayList<int[]> path)
	{
		String pathStr = "";
		for (int[] i : path) {
			pathStr += "(" + i[0] + ", " + i[1] + ") -> ";
		}
		pathStr += "MID";
		System.out.println(pathStr);
		System.out.println();
	}

	private static void
	findPathInMazeUtil(int[][] maze, ArrayList<int[]> path,
					ArrayList<int[]> visited, int[] curr)
	{
		// If we have reached the destination cell.
		// print the complete path
		if (curr[0] == (N / 2) && curr[1] == (N / 2)) {
			printPath(path);
			return;
		}
		// consider each direction
		for (int i = 0; i < 4; i++) {
			// get value of current cell
			int n = maze[curr[0]][curr[1]];
			// We can move N cells in either of 4 directions
			int x = curr[0] + row[i] * n;
			int y = curr[1] + col[i] * n;
			int[] next = { x, y };
			// if valid pair
			if (isValid(visited, next)) {
				// mark cell as visited
				visited.add(next);
				// add cell to current path
				path.add(next);
				// recurse for next cell
				findPathInMazeUtil(maze, path, visited,
								next);
				// backtrack
				// remove cell from current path
				path.remove(path.size() - 1);
				visited.removeIf(item
								-> item[0] == next[0]
										&& item[1]
											== next[1]);
			}
		}
	}
	// Function to find a path from corner cell to
	// middle cell in maze containing positive numbers
	public static void findPathInMaze(int[][] maze)
	{
		// list to store complete path
		// from source to destination
		ArrayList<int[]> path = new ArrayList<>();
		// to store cells already visited in current path
		ArrayList<int[]> visited = new ArrayList<>();
		// Consider each corners as the starting
		// point and search in maze
		for (int i = 0; i < 4; i++) {
			int x = _row[i];
			int y = _col[i];
			int[] pt = { x, y };
			// mark cell as visited
			visited.add(pt);
			// add cell to current path
			path.add(pt);
			findPathInMazeUtil(maze, path, visited, pt);
			// backtrack
			// remove cell from current path
			path.remove(path.size() - 1);
			visited.removeIf(item
							-> item[0] == pt[0]
									&& item[1] == pt[1]);
		}
	}
	public static void main(String[] args)
	{
		// input maze
		int[][] maze = { { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
						{ 6, 7, 5, 6, 6, 2, 6, 6, 2 },
						{ 3, 3, 4, 3, 2, 5, 4, 7, 2 },
						{ 6, 5, 5, 1, 2, 3, 6, 5, 6 },
						{ 3, 3, 4, 3, 0, 1, 4, 3, 4 },
						{ 3, 5, 4, 3, 2, 2, 3, 3, 5 },
						{ 3, 5, 4, 3, 2, 6, 4, 4, 3 },
						{ 3, 5, 1, 3, 7, 5, 3, 6, 4 },
						{ 6, 2, 4, 3, 4, 5, 4, 5, 1 } };

		// find path from corner cell to middle cell in the
		// maze
		findPathInMaze(maze);
	}
}
