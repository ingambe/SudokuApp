package com.tassel.ingambe.sudoku.Factory;

import com.tassel.ingambe.sudoku.Model.Sudoku;

import java.util.Random;

public class SudokuRandomizer {

    private int squareRows;
    private Random random;
    private Sudoku sudoku;

    public SudokuRandomizer(Sudoku sudoku) {
        this.sudoku = new Sudoku(sudoku);
        this.squareRows = (int) (Math.sqrt(sudoku.getSize()) / 1);
        random = new Random();
    }

    public Sudoku randomize(){
        for(int i = 0; i < random.nextInt(sudoku.getSize() * sudoku.getSize()) + sudoku.getSize() * sudoku.getSize(); i++) {
            randomizeRow();
            randomizeLine();
        }
        return sudoku;
    }

    public void randomizeRow(){
        int square = random.nextInt(squareRows);
        int row1 = random.nextInt(squareRows);
        int row2 = random.nextInt(squareRows);
        switchRow(squareRows * square + row1, squareRows * square + row2);
    }

    public void randomizeLine(){
        int square = random.nextInt(squareRows);
        int line1 = random.nextInt(squareRows);
        int line2 = random.nextInt(squareRows);
        switchLine(squareRows * square + line1, squareRows * square + line2);
    }


    public void switchLine(int i, int j){
        int temp;
        boolean tempBool;
        for(int k = 0; k < sudoku.getSize(); k++){
            temp = sudoku.getFullGrid()[i][k];
            sudoku.getFullGrid()[i][k] = sudoku.getFullGrid()[j][k];
            sudoku.getFullGrid()[j][k] = temp;
            tempBool = sudoku.getHoleGrid()[i][k];
            sudoku.getHoleGrid()[i][k] = sudoku.getHoleGrid()[j][k];
            sudoku.getHoleGrid()[j][k] = tempBool;
        }
    }

    public void switchRow(int i, int j){
        int temp;
        boolean tempBool;
        for(int k = 0; k < sudoku.getSize(); k++){
            temp = sudoku.getFullGrid()[k][i];
            sudoku.getFullGrid()[k][i] = sudoku.getFullGrid()[k][j];
            sudoku.getFullGrid()[k][j] = temp;
            tempBool = sudoku.getHoleGrid()[k][i];
            sudoku.getHoleGrid()[k][i] = sudoku.getHoleGrid()[k][j];
            sudoku.getHoleGrid()[k][j] = tempBool;
        }
    }

}
