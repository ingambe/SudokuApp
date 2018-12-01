package com.tassel.ingambe.sudoku.Factory;

import com.tassel.ingambe.sudoku.Model.Sudoku;

public class SudokuHardFactory {

    /**
     * We use a correct Sudoku that we shift
     *
     * @param size size of sudoku
     */
    public static Sudoku make(int size) {
        int[][] initialGrid = makeGrid(size);
        boolean[][] trous = makeHoles(size);
        Sudoku sudoku = new Sudoku(size, initialGrid, trous);
        /**
        int i = 0;
        int backtrack = Integer.MAX_VALUE;
        while (i < 1000 && backtrack > 10){
            SudokuRandomizer sudokuRandomizer = new SudokuRandomizer(sudoku);
            Sudoku tmp = sudokuRandomizer.randomize();
            SudokuSolver solver = new SudokuSolver(tmp);
            solver.solve();
            if(solver.getBacktracks() < backtrack){
                backtrack = solver.getBacktracks();
                sudoku = tmp;
            }
            i++;
        }
         **/
        SudokuRandomizer sudokuRandomizer = new SudokuRandomizer(sudoku);
        sudoku = sudokuRandomizer.randomize();
        return sudoku;
    }

    private static int[][] makeGrid(int size) {
        int[][] initialGrid = new int[size][size];
        if(size == 9) {
            initialGrid[0][0] = 5;
            initialGrid[0][1] = 8;
            initialGrid[0][2] = 2;
            initialGrid[0][3] = 3;
            initialGrid[0][4] = 7;
            initialGrid[0][5] = 9;
            initialGrid[0][6] = 4;
            initialGrid[0][7] = 1;
            initialGrid[0][8] = 6;
            initialGrid[1][0] = 3;
            initialGrid[1][1] = 9;
            initialGrid[1][2] = 1;
            initialGrid[1][3] = 8;
            initialGrid[1][4] = 6;
            initialGrid[1][5] = 4;
            initialGrid[1][6] = 7;
            initialGrid[1][7] = 2;
            initialGrid[1][8] = 5;
            initialGrid[2][0] = 7;
            initialGrid[2][1] = 4;
            initialGrid[2][2] = 6;
            initialGrid[2][3] = 1;
            initialGrid[2][4] = 2;
            initialGrid[2][5] = 5;
            initialGrid[2][6] = 9;
            initialGrid[2][7] = 8;
            initialGrid[2][8] = 3;
            initialGrid[3][0] = 6;
            initialGrid[3][1] = 7;
            initialGrid[3][2] = 8;
            initialGrid[3][3] = 2;
            initialGrid[3][4] = 5;
            initialGrid[3][5] = 3;
            initialGrid[3][6] = 1;
            initialGrid[3][7] = 4;
            initialGrid[3][8] = 9;
            initialGrid[4][0] = 2;
            initialGrid[4][1] = 5;
            initialGrid[4][2] = 9;
            initialGrid[4][3] = 4;
            initialGrid[4][4] = 8;
            initialGrid[4][5] = 1;
            initialGrid[4][6] = 3;
            initialGrid[4][7] = 6;
            initialGrid[4][8] = 7;
            initialGrid[5][0] = 4;
            initialGrid[5][1] = 1;
            initialGrid[5][2] = 3;
            initialGrid[5][3] = 6;
            initialGrid[5][4] = 9;
            initialGrid[5][5] = 7;
            initialGrid[5][6] = 2;
            initialGrid[5][7] = 5;
            initialGrid[5][8] = 8;
            initialGrid[6][0] = 9;
            initialGrid[6][1] = 2;
            initialGrid[6][2] = 5;
            initialGrid[6][3] = 7;
            initialGrid[6][4] = 1;
            initialGrid[6][5] = 6;
            initialGrid[6][6] = 8;
            initialGrid[6][7] = 3;
            initialGrid[6][8] = 4;
            initialGrid[7][0] = 8;
            initialGrid[7][1] = 3;
            initialGrid[7][2] = 7;
            initialGrid[7][3] = 5;
            initialGrid[7][4] = 4;
            initialGrid[7][5] = 2;
            initialGrid[7][6] = 6;
            initialGrid[7][7] = 9;
            initialGrid[7][8] = 1;
            initialGrid[8][0] = 1;
            initialGrid[8][1] = 6;
            initialGrid[8][2] = 4;
            initialGrid[8][3] = 9;
            initialGrid[8][4] = 3;
            initialGrid[8][5] = 8;
            initialGrid[8][6] = 5;
            initialGrid[8][7] = 7;
            initialGrid[8][8] = 2;
        }
        return initialGrid;
    }

    private static boolean[][] makeHoles(int size) {
        boolean[][] holes = new boolean[size][size];
        if(size == 9) {
            holes[0][0] = true;
            holes[0][3] = true;
            holes[0][5] = true;
            holes[0][6] = true;

            holes[1][0] = true;
            holes[1][2] = true;
            holes[1][4] = true;
            holes[1][5] = true;
            holes[1][6] = true;
            holes[1][7] = true;
            holes[1][8] = true;

            holes[2][0] = true;
            holes[2][1] = true;
            holes[2][4] = true;
            holes[2][6] = true;
            holes[2][8] = true;

            holes[3][0] = true;
            holes[3][2] = true;
            holes[3][3] = true;
            holes[3][4] = true;
            holes[3][6] = true;
            holes[3][7] = true;

            holes[4][2] = true;
            holes[4][3] = true;
            holes[4][5] = true;
            holes[4][6] = true;

            holes[5][0] = true;
            holes[5][1] = true;
            holes[5][3] = true;
            holes[5][4] = true;
            holes[5][5] = true;
            holes[5][7] = true;
            holes[5][8] = true;

            holes[6][0] = true;
            holes[6][1] = true;
            holes[6][2] = true;
            holes[6][4] = true;
            holes[6][5] = true;
            holes[6][6] = true;
            holes[6][7] = true;
            holes[6][8] = true;

            holes[7][0] = true;
            holes[7][1] = true;
            holes[7][2] = true;
            holes[7][3] = true;
            holes[7][4] = true;
            holes[7][7] = true;

            holes[8][1] = true;
            holes[8][2] = true;
            holes[8][3] = true;
            holes[8][4] = true;
            holes[8][5] = true;
            holes[8][6] = true;
            holes[8][7] = true;
        }
        return holes;
    }

}
