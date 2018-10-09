package com.tassel.ingambe.sudoku.Solver;

import com.tassel.ingambe.sudoku.Factory.SudokuAbstractFactory;
import com.tassel.ingambe.sudoku.Model.Sudoku;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SudokuSolverTest {

    private Sudoku sudoku;
    private SudokuSolver sudokuSolver;

    public SudokuSolverTest() {
        sudoku = SudokuAbstractFactory.make(0, 9);
        sudokuSolver = new SudokuSolver(sudoku);
    }

    @Test
    public void uniqueSolution() {
        assertTrue(sudokuSolver.solve());
        assertTrue(sudokuSolver.uniqueSolution());
    }

    @Test
    public void correctSolution() {
        int[][] solution = sudokuSolver.getSolution();
        for(int i = 0; i < sudoku.getSize(); i++){
            for(int j = 0; j < sudoku.getSize(); j++){
                assertEquals("difference there (" + i + "," + j + ")", solution[i][j], sudoku.getFullGrid()[i][j]);
            }
        }
    }
}