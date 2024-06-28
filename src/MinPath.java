public class MinPath {
    public static int solution(int[][] matrix) {
        int n = matrix.length;
        int minChanges = Integer.MAX_VALUE;

        // Possible values for 'Y' pattern
        int[] possibleValues = {0, 1, 2};

        // Iterate over all possible pairs of values for 'Y' and background
        for (int primary : possibleValues) {
            for (int secondary : possibleValues) {
                if (primary != secondary) {
                    minChanges = Math.min(minChanges, calculateChanges(matrix, primary, secondary));
                }
            }
        }

        return minChanges;
    }

    private static int calculateChanges(int[][] matrix, int primary, int secondary) {
        int n = matrix.length;
        int changes = 0;

        // Check each coordinate in the matrix and count necessary changes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isYCoordinate(i, j, n)) {
                    if (matrix[i][j] != primary) {
                        changes++;
                    }
                } else {
                    if (matrix[i][j] != secondary) {
                        changes++;
                    }
                }
            }
        }

        return changes;
    }

    // Helper method to check if the coordinate is part of the 'Y'
    private static boolean isYCoordinate(int i, int j, int n) {
        int center = n / 2;
        return (i == j && i <= center) || (i + j == n - 1 && i <= center) || (j == center && i >= center);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 2},
                {1, 2, 0},
                {0, 2, 0}
        };
        System.out.println(solution(matrix)); // Output should be 2
    }
}
