# Nqueen Problem 
# N-Queens Solver (Backtracking)

This Java program **solves the N-Queens problem** using **backtracking**. It finds and prints all possible solutions where **N queens** can be placed on an **N × N chessboard** such that **no two queens attack each other**.

## Features
- **Solves the N-Queens problem for any board size \( N \)**
- **Uses backtracking** to explore valid queen placements.
- **Prevents queen attacks** using:
  - Column tracking (`col`)
  - Positive diagonals (`posDiag`)
  - Negative diagonals (`negDiag`)
- **Prints solutions visually** using a chessboard representation.
- **Handles cases where no solution exists**.

## How It Works
1. **Takes user input** for board size \( N \).
2. **Initializes an empty board**.
3. **Uses backtracking** to place queens row by row:
   - Places a queen if it's **safe** (not in the same column or diagonal).
   - Moves to the next row.
   - If a solution is found, prints the board.
   - If no valid position is available, **backtracks** to try another configuration.
4. **Prints all valid solutions** or `"Solution not found!"` if no solution exists.

