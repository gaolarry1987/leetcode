import java.util.ArrayList;
import java.util.Arrays;

public class MazeBacktrack {
    public static void main(String[] args) {
        System.out.println(count(3,4));
        path("",3,3);
        System.out.println(pathDiagonal("", 3,3));

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
                            };

        int[][] path = new int[board.length][board[0].length];

//        pathRestriction("", board, 0, 0);
        allPathPrint("",board, 0,0,path,1);
    }

    static int count(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }

        int left = count(row - 1, col);
        int right = count(row, col - 1);

        return left + right;
    }

    static void path(String processed, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(processed);
            return;
        }

        if(row > 1){
            path(processed+ 'D', row - 1, col);
        }

        if(col > 1){
            path(processed + 'R', row, col-1);
        }
    }

    static ArrayList<String> pathDiagonal(String processed, int row, int col){
        if(row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(row > 1 && col > 1){
            list.addAll(pathDiagonal("D", row - 1, col - 1));
        }

        if(row > 1){
            list.addAll(pathDiagonal(processed+ 'V', row - 1, col));
        }

        if(col > 1){
            list.addAll(pathDiagonal(processed + 'H', row, col-1));
        }

        return list;
    }

    static void pathRestriction(String processed, boolean[][] maze, int row, int col){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(processed);
            return;
        }

        if(maze[row][col] == false){
            return;
        }

        if(row < maze.length-1){
            pathRestriction(processed+ 'D', maze,row + 1, col);
        }

        if(col < maze[0].length-1){
            pathRestriction(processed + 'R', maze, row, col + 1);
        }
    }

    static void allPath(String processed, boolean[][] maze, int row, int col){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(processed);
            return;
        }

        if(maze[row][col] == false){
            return;
        }

        maze[row][col] = false;

        if(row < maze.length-1){
            allPath(processed+ 'D', maze,row + 1, col);
        }

        if(col < maze[0].length-1){
            allPath(processed + 'R', maze, row, col + 1);
        }

        if(row > 0){
            allPath(processed+ 'U', maze,row - 1, col);
        }

        if(col > 0){
            allPath(processed + 'L', maze, row, col-1);
        }

        maze[row][col] = true;
    }

    static void allPathPrint(String processed, boolean[][] maze, int row, int col, int[][] path, int step){
        if(row == maze.length-1 && col == maze[0].length-1){
            for(int[] arr: path){
                path[row][col] = step;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }

        if(maze[row][col] == false){
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;
        if(row < maze.length-1){
            allPathPrint(processed+ 'D', maze,row + 1, col, path, step+1);
        }

        if(col < maze[0].length-1){
            allPathPrint(processed + 'R', maze, row, col + 1, path, step+1);
        }

        if(row > 0){
            allPathPrint(processed+ 'U', maze,row - 1, col, path, step+1);
        }

        if(col > 0){
            allPathPrint(processed + 'L', maze, row, col-1, path, step+1);
        }

        maze[row][col] = true;
        path[row][col] = 0;
    }
}
