package com.tassel.ingambe.sudoku.Factory;

import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.Solver.SudokuSolver;

import org.junit.Test;

import static org.testng.Assert.*;

public class SudokuAbstractFactoryTest {

    @Test
    public void easy(){
        testDifficulty(0);
    }

    @Test
    public void medium(){
        testDifficulty(1);
    }

    @Test
    public void hard(){
        testDifficulty(2);
    }

    public void testDifficulty(int difficulty){
        for(int i = 0; i < 100; i++) {
            Sudoku sudoku = SudokuAbstractFactory.make(difficulty, 9);
            SudokuSolver solver = new SudokuSolver(sudoku);
            solver.getSolution();
            assertTrue(solver.nbSolutions >= 1, "There is only one solution for a grid, i:" + i);
        }
    }
}