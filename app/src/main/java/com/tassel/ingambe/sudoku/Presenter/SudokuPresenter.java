package com.tassel.ingambe.sudoku.Presenter;

import com.tassel.ingambe.sudoku.Factory.SudokuAbstractFactory;
import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.View.SudokuView;

public class SudokuPresenter {

    private SudokuView view;
    private Sudoku model;
    private int difficulty;
    private int size;

    public SudokuPresenter(SudokuView view) {
        this.view = view;
        this.difficulty = view.getDifficulty();
        this.size = view.getSize();
        initView();
    }

    public void initView(){
        model = SudokuAbstractFactory.make(difficulty, size);
        view.generateGrid(model);
    }

}
