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
    private List<Couple> errorRow;
    private List<Couple> emptyRow;

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
            showIncorrectRow();
            showEmptyRow();
        } else {
            errorRow = new ArrayList<>();
            emptyRow = new ArrayList<>();
        }
    }

    public void detachView(){
        this.view = null;
    }

    public void restart(SudokuView view){
        savedState = null;
        errorRow = null;
        emptyRow = null;
        view.restartChronometer();
        initView(view);
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
        errorRow = new ArrayList<>();
        emptyRow = new ArrayList<>();
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
            view.stopChronometer();
            showSuccess();
        } else {
            // error row in red
            showIncorrectRow();
            // empty row in orange
            showEmptyRow();
        }
    }

    public void showEmptyRow(){
        for(Couple empty : emptyRow){
            view.colorOrangeRow(empty.i, empty.j);
        }
    }

    public void showIncorrectRow(){
        for(Couple error : errorRow){
            view.colorRedRow(error.i, error.j);
        }
    }

    public void showSuccess(){
        StringBuilder builder = new StringBuilder();
        builder.append(view.getTextSuccess(view.getDifficulty()));
        builder.append("\n");
        builder.append(view.getTextTime());
        builder.append(view.getChronometerTime() / 1000.0);
        builder.append(view.getTextTime());
        view.alertDialogSuccess(builder.toString());
    }

}