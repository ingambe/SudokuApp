package com.tassel.ingambe.sudoku.Presenter;

import android.util.Log;

import com.tassel.ingambe.sudoku.Factory.SudokuAbstractFactory;
import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.View.SudokuView;

import java.util.ArrayList;
import java.util.List;

public class SudokuPresenter {

    private SudokuView view;
    private Sudoku model;
    private int difficulty;
    private int size;
    // variable to save state
    private int[][] savedState;
    private long timeChronometer;

    public void initView(SudokuView view){
        this.view = view;
        this.difficulty = view.getDifficulty();
        this.size = view.getSize();
        model = SudokuAbstractFactory.make(difficulty, size);
        view.generateGrid(model);
        view.setDifficultyText(difficulty);
        view.startChronometer();
        // if we need to restore state
        if(savedState != null){
            view.setChronometerTime(timeChronometer);
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

    public void saveState(){
        savedState = new int[model.getSize()][model.getSize()];
        timeChronometer = view.getChronometerTime();
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
        List<Couple> errorRow = new ArrayList<>();
        List<Couple> emptyRow = new ArrayList<>();
        for(int i = 0; i < model.getSize(); i++){
            for(int j = 0; j < model.getSize(); j++){
                if(view.getGridElement(i, j) == -1){
                    emptyRow.add(new Couple(i, j));
                } else if(view.getGridElement(i, j) != model.getFullGrid()[i][j]){
                    errorRow.add(new Couple(i, j));
                }
            }
        }
        if(errorRow.isEmpty() && emptyRow.isEmpty()){
            Log.d("GRID_RESULT", "Correct !");
            view.stopChronometer();
        } else {
            // error row in red
            for(Couple error : errorRow){
                view.colorRedRow(error.i, error.j);
            }
            // empty row in orange
            for(Couple empty : emptyRow){
                view.colorOrangeRow(empty.i, empty.j);
            }
        }
    }

    public void showEmptyRow(){

    }

    public void showIncorrectRow(){

    }

    public void showSuccess(){

    }

}
