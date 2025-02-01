package nqueen;

import java.util.*;

public class Backtracking {

    static int N;
    static ArrayList<Integer> col = new ArrayList<>();
    static ArrayList<Integer> posDiag = new ArrayList<>();
    static ArrayList<Integer> negDiag = new ArrayList<>();
    static ArrayList<ArrayList<ArrayList<Integer>>> AllSolutions = new ArrayList<>();
    static int SolutionNumber = 1 ; 
    static boolean SolutionFound = false;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the board size: ");
        N = in.nextInt();
        in.close();
        solveNqueens();
    }

    public static void solveNqueens() {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add(0);
            }
            board.add(row);
        }
        solve(board, 0) ; 
        if(!SolutionFound) {
        	System.out.println("Solution not found !");
        }
    }

    public static boolean solve(ArrayList<ArrayList<Integer>> board, int r) {
        if (r == N) {
        	SolutionFound = true; 
        	System.out.println("Solution " + SolutionNumber++ + " :" );
        	printSolution(board); 
        	System.out.println("\n");
            return true;
        }
        for (int c = 0; c < N; c++) {
            if (isValid(r, c)) {
                board.get(r).set(c, 1); 
                col.add(c);
                posDiag.add(r + c);
                negDiag.add(r - c);

                solve(board , r+1) ;  

               // backtrack 
                board.get(r).set(c, 0); 
                col.remove(col.size() - 1);
                posDiag.remove(posDiag.size() - 1);
                negDiag.remove(negDiag.size() - 1);
            }
        }

        return false;
    }

    public static boolean isValid(int r, int c) {
        return !col.contains(c) && !posDiag.contains(r + c) && !negDiag.contains(r - c);
    }

    public static void printSolution(ArrayList<ArrayList<Integer>> board) {
        for (ArrayList<Integer> row : board) {
            for (int cell : row) {
                if (cell == 1) {
                    System.out.print("♛ ");
                } else {
                    System.out.print("▢ ");
                }
            }
            System.out.println();
        }
    }

}

