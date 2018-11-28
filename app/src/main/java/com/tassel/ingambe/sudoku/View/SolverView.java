package com.tassel.ingambe.sudoku.View;

import com.tassel.ingambe.sudoku.Model.Sudoku;

public interface SolverView {

    int getGridElement(int i, int j);
    void setGridElement(int i, int j, int i1);
    void generateGrid(Sudoku model);
    void colorGreenRow(int i, int j);
    void showNoSolution();
    void showMultipleSolution();
}
