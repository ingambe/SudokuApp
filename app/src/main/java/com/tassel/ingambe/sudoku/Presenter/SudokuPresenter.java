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

    public SudokuPresenter(SudokuView view) {
        this.view = view;
        this.difficulty = view.getDifficulty();
        this.size = view.getSize();
        initView();
    }

    public void initView(){
        model = SudokuAbstractFactory.make(difficulty, size);
        view.generateGrid(model);
        view.setDifficultyText(difficulty);
        view.startChronometer();
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
