package com.tassel.ingambe.sudoku.Factory;

import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.Solver.SudokuSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SudokuRandomizerTest {

    private Sudoku sudoku;

    public SudokuRandomizerTest() {
        sudoku = SudokuAbstractFactory.make(0, 9);
    }

    @Test
    public void testCorrectness() {
        SudokuRandomizer randomizer = new SudokuRandomizer(sudoku);
        Sudoku randomized = randomizer.randomize();
        SudokuSolver solver = new SudokuSolver(randomized);
        int[][] result = solver.getSolution();
        assertTrue(solver.nbSolutions >= 1);
        for(int i = 0; i < sudoku.getSize(); i++){
            for(int j = 0; j < sudoku.getSize(); j++){
                assertEquals("difference there (" + i + "," + j + ")", randomized.getFullGrid()[i][j], result[i][j]);
            }
        }
    }
}