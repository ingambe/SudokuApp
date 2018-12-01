package com.tassel.ingambe.sudoku.Solver;

import com.tassel.ingambe.sudoku.Factory.SudokuEasyFactory;
import com.tassel.ingambe.sudoku.Model.Sudoku;

import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.*;

public class SudokuSolverTest {

    private SudokuSolver solver;
    private Sudoku sudoku;

    @Before
    public void beforeAll(){
        int[][] grid = makeGrid(9);
        boolean[][] holes = makeHoles(9);
        // we remove the solution if we have a hole
        // prevent from cheating :P
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(holes[i][j]){
                    grid[i][j] = 0;
                }
            }
        }
        sudoku = new Sudoku(9, grid, holes);
    }

    @Test
    public void solverTestSolutionExist() {
        solver = new SudokuSolver(sudoku);
        int[][] sol = solver.getSolution();
        assertTrue(solver.nbSolutions >= 1);
        int[][] grid = makeGrid(9);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                assertEquals(sol[i][j], grid[i][j], "grid : " + grid[i][j] + " sol : " + sol[i][j]);
            }
        }
    }

    @Test
    public void solverTestSolutionDontExist() {
        sudoku.getFullGrid()[0][1] = 5;
        sudoku.getFullGrid()[0][5] = 5;
        solver = new SudokuSolver(sudoku);
        int[][] sol = solver.getSolution();
        assertEquals(solver.nbSolutions, 0, "Two times the same number in line, no solution");
    }

    @Test
    public void solverTestMoreThanOneSolution() {
        Sudoku sudokuVide = new Sudoku(9);
        solver = new SudokuSolver(sudokuVide);
        int[][] sol = solver.getSolution();
        assertTrue(solver.nbSolutions > 1, "An empty grid has more than one solution");
    }

    private static int[][] makeGrid(int size) {
        int[][] initialGrid = new int[size][size];
        initialGrid[0][0] = 9;
        initialGrid[0][1] = 4;
        initialGrid[0][2] = 8;
        initialGrid[0][3] = 2;
        initialGrid[0][4] = 3;
        initialGrid[0][5] = 1;
        initialGrid[0][6] = 7;
        initialGrid[0][7] = 5;
        initialGrid[0][8] = 6;
        initialGrid[1][0] = 2;
        initialGrid[1][1] = 3;
        initialGrid[1][2] = 6;
        initialGrid[1][3] = 8;
        initialGrid[1][4] = 5;
        initialGrid[1][5] = 7;
        initialGrid[1][6] = 9;
        initialGrid[1][7] = 1;
        initialGrid[1][8] = 4;
        initialGrid[2][0] = 1;
        initialGrid[2][1] = 7;
        initialGrid[2][2] = 5;
        initialGrid[2][3] = 4;
        initialGrid[2][4] = 9;
        initialGrid[2][5] = 6;
        initialGrid[2][6] = 2;
        initialGrid[2][7] = 3;
        initialGrid[2][8] = 8;
        initialGrid[3][0] = 8;
        initialGrid[3][1] = 9;
        initialGrid[3][2] = 3;
        initialGrid[3][3] = 6;
        initialGrid[3][4] = 1;
        initialGrid[3][5] = 4;
        initialGrid[3][6] = 5;
        initialGrid[3][7] = 2;
        initialGrid[3][8] = 7;
        initialGrid[4][0] = 7;
        initialGrid[4][1] = 2;
        initialGrid[4][2] = 1;
        initialGrid[4][3] = 5;
        initialGrid[4][4] = 8;
        initialGrid[4][5] = 9;
        initialGrid[4][6] = 6;
        initialGrid[4][7] = 4;
        initialGrid[4][8] = 3;
        initialGrid[5][0] = 6;
        initialGrid[5][1] = 5;
        initialGrid[5][2] = 4;
        initialGrid[5][3] = 7;
        initialGrid[5][4] = 2;
        initialGrid[5][5] = 3;
        initialGrid[5][6] = 8;
        initialGrid[5][7] = 9;
        initialGrid[5][8] = 1;
        initialGrid[6][0] = 5;
        initialGrid[6][1] = 6;
        initialGrid[6][2] = 7;
        initialGrid[6][3] = 1;
        initialGrid[6][4] = 4;
        initialGrid[6][5] = 2;
        initialGrid[6][6] = 3;
        initialGrid[6][7] = 8;
        initialGrid[6][8] = 9;
        initialGrid[7][0] = 3;
        initialGrid[7][1] = 1;
        initialGrid[7][2] = 2;
        initialGrid[7][3] = 9;
        initialGrid[7][4] = 6;
        initialGrid[7][5] = 8;
        initialGrid[7][6] = 4;
        initialGrid[7][7] = 7;
        initialGrid[7][8] = 5;
        initialGrid[8][0] = 4;
        initialGrid[8][1] = 8;
        initialGrid[8][2] = 9;
        initialGrid[8][3] = 3;
        initialGrid[8][4] = 7;
        initialGrid[8][5] = 5;
        initialGrid[8][6] = 1;
        initialGrid[8][7] = 6;
        initialGrid[8][8] = 2;
        return initialGrid;
    }

    private static boolean[][] makeHoles(int size) {
        boolean[][] holes = new boolean[size][size];
        holes[0][0] = true;
        holes[0][2] = true;
        holes[0][3] = true;
        holes[0][4] = true;

        holes[1][1] = true;
        holes[1][2] = true;
        holes[1][4] = true;
        holes[1][6] = true;
        holes[1][7] = true;
        holes[1][8] = true;

        holes[2][1] = true;
        holes[2][4] = true;
        holes[2][5] = true;
        holes[2][6] = true;

        holes[3][0] = true;
        holes[3][1] = true;
        holes[3][2] = true;
        holes[3][6] = true;
        holes[3][7] = true;

        holes[4][2] = true;
        holes[4][5] = true;
        holes[4][6] = true;

        holes[5][1] = true;
        holes[5][2] = true;
        holes[5][6] = true;
        holes[5][7] = true;
        holes[5][8] = true;

        holes[6][2] = true;
        holes[6][3] = true;
        holes[6][4] = true;
        holes[6][7] = true;

        holes[7][0] = true;
        holes[7][1] = true;
        holes[7][2] = true;
        holes[7][4] = true;
        holes[7][6] = true;
        holes[7][7] = true;

        holes[8][2] = true;
        holes[8][5] = true;
        holes[8][6] = true;
        holes[8][8] = true;
        return holes;
    }

}