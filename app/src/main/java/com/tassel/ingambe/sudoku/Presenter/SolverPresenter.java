package com.tassel.ingambe.sudoku.Presenter;

import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.Solver.SudokuSolver;
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
        for(int i = 0; i < model.getSize(); i++){
            for(int j = 0; j < model.getSize(); j++){
                int element = view.getGridElement(i, j);
                if(element != -1) {
                    model.getFullGrid()[i][j] = element;
                    model.getHoleGrid()[i][j] = false;
                } else {
                    model.getFullGrid()[i][j] = 0;
                    model.getHoleGrid()[i][j] = true;
                }
            }
        }
        SudokuSolver sudokuSolver = new SudokuSolver(model);
        int[][] sol = sudokuSolver.getSolution();
        if(sudokuSolver.nbSolutions >= 1){
            for(int i = 0; i < model.getSize(); i++) {
                for (int j = 0; j < model.getSize(); j++) {
                    if(model.getHoleGrid()[i][j]){
                        view.colorGreenRow(i, j);
                        view.setGridElement(i, j, sol[i][j]);
                    }
                }
            }
        } else {
            // TODO : SHOW SAME NUMBER
            view.showNoSolution();
        }
        /**
        else if(sudokuSolver.nbSolutions == 0){
            // TODO : SHOW SAME NUMBER
            view.showNoSolution();
        } else {
            view.showMultipleSolution();
        }
         **/
    }

}
