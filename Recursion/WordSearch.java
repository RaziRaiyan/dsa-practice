package Recursion;

/*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, 
    where adjacent cells are horizontally or vertically neighboring. 
    The same letter cell may not be used more than once.

    Example 1:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true

    Example 2:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true

    Example 3:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    Output: false
    

    Constraints:
    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.
    
    Follow up: Could you use search pruning to make your solution faster with a larger board?
*/ 

public class WordSearch {
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        System.out.println(ws.exist(board, word));
        
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(helper(board, i, j, 0, word)){
                    return true;
                }
                // System.out.println("i: "+i+", j: "+j);
                // printBoard(board);
            }
        }

        return false;
    }

    public void printBoard(char[][] board){
        System.out.println("[ ");
        for(int i=0; i<board.length; i++){
            System.out.print("  [ ");
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j]+(j == board[i].length-1 ? "": " "));
            }
            System.out.println(" ]");
        }
        System.out.println("]");
    }

    public boolean helper(char[][] board, int i, int j, int index, String word){
        if(index >= word.length()){
            return true;
        }

        if(i < 0 || i >= board.length){
            return false;
        }

        if(j < 0 || j>= board[i].length){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }

        if(board[i][j] == 'v'){
            return false;
        }


        char original = board[i][j];

        board[i][j] = 'v';

        if(helper(board, i-1, j, index+1, word) || helper(board, i+1, j, index+1, word) || helper(board, i, j+1, index+1, word) || helper(board, i, j-1, index+1, word)){
            return true;
        }

        board[i][j] = original;

        return false;
    }
}
