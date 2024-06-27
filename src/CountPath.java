import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountPath {
    public static void main(String[] args) {
        // Define a grid with obstacles represented by "X" and empty cells represented by "."
        List<List<String>> grid = new ArrayList<>();
        grid.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".", "."));
        grid.add(Arrays.asList(".", "X", "X", ".", ".", "X", ".", ".", "X", "."));
        grid.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".", "."));
        grid.add(Arrays.asList(".", ".", "X", "X", ".", ".", ".", "X", ".", "."));
        grid.add(Arrays.asList(".", ".", ".", ".", ".", "X", ".", ".", ".", "."));
        grid.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", "X", "."));
        grid.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".", "."));
        grid.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".", "."));
        grid.add(Arrays.asList(".", ".", ".", ".", ".", ".", ".", ".", ".", "."));

        // Test the countPath method
        int result = CountPath.countPath(0, 0, grid);
        System.out.println("Number of paths in the grid: " + result);
    }

    static int countPath(int r, int c, List<List<String>> grid){
        return countPath(r,c,grid, new HashMap<>());
    }

    static int countPath(int r, int c, List<List<String>> grid, HashMap<List<Integer>, Integer> memo){
        if(r == grid.size() || c == grid.get(0).size()){
            return 0;
        }

        if(r == grid.size()-1 && c == grid.get(0).size()-1){
            return 1;
        }

        if(grid.get(r).get(c) == "X"){
            return 0;
        }

        List<Integer> pos = List.of(r,c);
        if(memo.containsKey(pos)){
            return memo.get(pos);
        }
        int result = countPath(r + 1, c, grid)+countPath(r, c+1, grid, memo);
        memo.put(pos, result);
        return result;
    }
}
