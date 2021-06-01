public class IslandMaxArea {
    static int m = 0;
    static int n = 0;

    static int processNeighbours(int i, int j, int[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || (grid[i][j] == 0))
            return 0;

        grid[i][j] = 0;
        return 1 + processNeighbours(i + 1, j, grid) + processNeighbours(i - 1, j, grid)
                + processNeighbours(i, j + 1, grid) + processNeighbours(i, j - 1, grid);

    }

    static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, processNeighbours(i, j, grid));
                }
            }
        }
        return max;
    }

    public static void main(String... arg) {
        int[][] arr = new int[][] { { 1, 0 }, { 0, 1 } };
        // initialize the above arr;
        int ans = maxAreaOfIsland(arr);
        System.out.print(ans);
    }
}