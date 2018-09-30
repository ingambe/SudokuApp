package com.tassel.ingambe.sudoku.View;

import com.tassel.ingambe.sudoku.Model.Sudoku;

public interface SudokuView {

    int getDifficulty();
    int getSize();
    void generateGrid(Sudoku model);
    void setDifficultyText(int difficulty);
    void startChronometer();
    void stopChronometer();

}
