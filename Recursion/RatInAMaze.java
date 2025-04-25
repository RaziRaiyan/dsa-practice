package Recursion;

import java.util.List;
import java.util.ArrayList;

/*
    Rat in a Maze
    Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). 
    Find all possible paths that the rat can take to reach from source to destination. 
    The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). 
    Value 0 at a cell in the matrix represents that it is blocked and 
    the rat cannot move to it while value 1 at a cell in the matrix represents that rat can travel through it.
    Note: In a path, no cell can be visited more than one time.

    Print the answer in lexicographical(sorted) order

    Examples:
    Example 1:
    Input:
    N = 4
    m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1}, 
            {1, 1, 0, 0},
            {0, 1, 1, 1}}

    Output: DDRDRR DRDDRR
*/ 

public class RatInAMaze {
    private static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 0, 1}, 
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};
        int n = maze.length;
        helper(maze, n, 0, 0, new boolean[n][n], new StringBuilder());
        System.out.println(ans);
    }

    private static void helper(int[][] maze, int n, int x, int y, boolean[][] visited, StringBuilder res){
        if(x == n-1 && y == n-1){
            ans.add(new String(res.toString()));
        }

        if(visited[x][y]){
            return;
        }

        visited[x][y] = true;

        if(x > 0 && !visited[x-1][y] && maze[x-1][y] == 1){
            res.append('U');
            helper(maze, n, x-1, y, visited, res);
            res.deleteCharAt(res.length()-1);
        }

        if(y > 0 && !visited[x][y-1] && maze[x][y-1] == 1){
            res.append('L');
            helper(maze, n, x, y-1, visited, res);
            res.deleteCharAt(res.length()-1);
        }

        if(x < n-1 && !visited[x+1][y] && maze[x+1][y] == 1){
            res.append('D');
            helper(maze, n, x+1, y, visited, res);
            res.deleteCharAt(res.length()-1);
        }

        if(y < n-1 && !visited[x][y+1] && maze[x][y+1] == 1){
            res.append('R');
            helper(maze, n, x, y+1, visited, res);
            res.deleteCharAt(res.length()-1);
        }

        visited[x][y] = false;
    }
}
