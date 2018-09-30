package com.tassel.ingambe.sudoku.Factory;

import com.tassel.ingambe.sudoku.Model.Sudoku;

public class SudokuAbstractFactory {

    public static Sudoku make(int difficultee, int taille){
        switch (difficultee){
            case 0:
                return SudokuEasyFactory.make(taille);
            case 1:
                return SudokuEasyFactory.make(taille);
            default:
                return SudokuEasyFactory.make(taille);
        }
    }

}
