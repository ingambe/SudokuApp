package com.tassel.ingambe.sudoku.Factory;

import com.tassel.ingambe.sudoku.Model.Sudoku;

public class SudokuAbstractFactory {

    public static Sudoku make(int difficulty, int size){
        switch (difficulty){
            case 0:
                return SudokuEasyFactory.make(size);
            case 1:
                return SudokuMediumFactory.make(size);
            default:
                return SudokuHardFactory.make(size);
        }
    }

}
