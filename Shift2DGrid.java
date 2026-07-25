import java.util.*;

public class Shift2DGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k = k % total;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                int newIndex = (index + k) % total;
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                result.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int k = 1;

        List<List<Integer>> shifted = shiftGrid(grid, k);

        System.out.println("Shifted Grid:");
        for (List<Integer> row : shifted) {
            System.out.println(row);
        }
    }
}
