class Solution {

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {

                if (grid[row][col] == '1' && !visited[row][col]) {
                    count++;
                    dfs(row, col, grid, visited);
                }
            }
        }

        return count;
    }

    void dfs(int row, int col, char[][] grid, boolean[][] visited) {

        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        dfs(row - 1, col, grid, visited); // up
        dfs(row + 1, col, grid, visited); // down
        dfs(row, col - 1, grid, visited); // left
        dfs(row, col + 1, grid, visited); // right
    }
}