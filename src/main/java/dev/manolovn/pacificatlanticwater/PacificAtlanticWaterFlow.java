package dev.manolovn.pacificatlanticwater;

import java.util.ArrayList;
import java.util.List;

class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> solutions = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return solutions;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlanti = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, -1, pacific);
            dfs(matrix, i, n - 1, -1, atlanti);
        }

        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, -1, pacific);
            dfs(matrix, m - 1, i, -1, atlanti);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlanti[i][j]) {
                    List<Integer> aux = new ArrayList<>(2);
                    aux.add(i);
                    aux.add(j);
                    solutions.add(aux);
                }
            }
        }

        return solutions;
    }

    private void dfs(int[][] matrix, int x, int y, int h, boolean[][] ocean) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length
                || ocean[x][y] || h > matrix[x][y]) {
            return;
        }
        ocean[x][y] = true;
        dfs(matrix, x + 1, y, matrix[x][y], ocean);
        dfs(matrix, x, y + 1, matrix[x][y], ocean);
        dfs(matrix, x - 1, y, matrix[x][y], ocean);
        dfs(matrix, x, y - 1, matrix[x][y], ocean);
    }
}
