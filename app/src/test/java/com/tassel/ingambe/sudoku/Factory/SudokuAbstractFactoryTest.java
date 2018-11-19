package com.tassel.ingambe.sudoku.Factory;

import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.Solver.SudokuSolver;

import org.junit.Test;

import static org.testng.Assert.*;

public class SudokuAbstractFactoryTest {

    private SudokuSolver solver;
    private Sudoku sudoku;

    @Test
    public void easy(){
        testDifficulty(0);
    }

    @Test
    public void medium(){
        //TODO FIX
        testDifficulty(1);
    }

    @Test
    public void hard(){
        testDifficulty(2);
    }

    public void testDifficulty(int difficulty){
        for(int i = 0; i < 100; i++) {
            sudoku = SudokuAbstractFactory.make(difficulty, 9);
            solver = new SudokuSolver(sudoku);
            solver.solve();
            assertTrue(solver.uniqueSolution(), "There is only one solution for a grid, i:" + i);
        }
    }
}