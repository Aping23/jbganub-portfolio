import java.util.Random;

public class Minesweeper {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Minesweeper <rows> <cols> <mines>");
            return;
        }

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        if (k > m * n) {
            System.out.println("Number of mines cannot exceed total cells.");
            return;
        }

        char[][] grid = new char[m][n];
        int[][] mineCounts = new int[m][n];

        // Initialize grid with empty spaces
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.'; // Placeholder for empty cells
            }
        }

        // Place mines randomly
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < k) {
            int row = rand.nextInt(m);
            int col = rand.nextInt(n);
            if (grid[row][col] != '*') {
                grid[row][col] = '*';
                placedMines++;
            }
        }

        // Calculate neighboring mine counts
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') continue;
                int mineCount = 0;
                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == '*') {
                        mineCount++;
                    }
                }
                mineCounts[i][j] = mineCount;
            }
        }

        // Print the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    System.out.print("*  ");
                } else {
                    System.out.print(mineCounts[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
