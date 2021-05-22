package RecursionAndBackTrackingPractice;

import java.util.Scanner;

public class RB_001 {

    private static void solveSudoku(int[][] board, int i, int j) {

        if(i==board.length){
            displayBoard(board);
        }

        int ni = 0;
        int nj = 0;

        if(j == board.length){
            ni = i+1;
            nj = 0;
        }else{
            ni = i;
            nj = j+1;
        }
        if(board[i][j]!=0){
            for(int po=1; po<=9; po++){
                if(isValid(board, i, j, po)){
                    board[i][j] = po;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean isValid(int[][] board, int x, int y, int po) {

        for(int j=0; j<9; j++){
            if(board[x][j] == po){
                return false;
            }
        }
        for(int i=0; i<9; i++){
            if(board[i][y] == po){
                return false;
            }
        }
        int smi = 3 * x/3;
        int smj = 3 * y/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[smi+i][smj+j]==po){
                    return false;
                }
            }
        }
        return true;
    }

    public static void displayBoard(int[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                board[i][j] = sc.nextInt();
            }
        }
        solveSudoku(board, 0, 0);
    }

}
