package com.tassel.ingambe.sudoku.Presenter;

import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.View.SolverView;

public class SolverPresenter {

    private SolverView view;
    private Sudoku model;
    // variable to save state
    private int[][] savedState;

    public void initView(SolverView view){
        this.view = view;
        if(model == null) {
            model = new Sudoku(9);
        }
        view.generateGrid(model);
        // if we need to restore state
        if(savedState != null){
            for(int i = 0; i < model.getSize(); i++){
                for(int j = 0; j < model.getSize(); j++){
                    if(savedState[i][j] != -1){
                        view.setGridElement(i, j, savedState[i][j]);
                    }
                }
            }
        }
    }

    public void detachView(){
        this.view = null;
    }

    public void restart(SolverView view){
        savedState = null;
        initView(view);
    }

    public void saveState(){
        savedState = new int[model.getSize()][model.getSize()];
        for(int i = 0; i < model.getSize(); i++){
            for(int j = 0; j < model.getSize(); j++){
                if(model.getHoleGrid()[i][j] && view.getGridElement(i, j) != -1){
                    savedState[i][j] = view.getGridElement(i, j);
                } else {
                    savedState[i][j] = -1;
                }
            }
        }
    }

    public void verifySudoku(){

    }

    public void showNoSolution(){

    }

    public void showMultipleSolution(){

    }
}
