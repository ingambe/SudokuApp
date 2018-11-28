package com.tassel.ingambe.sudoku.Model;

public class Sudoku {

    int size;
    private int fullGrid[][];
    private boolean holeGrid[][];

    public Sudoku(int size, int[][] fullGrid, boolean[][] holeGrid) {
        this.size = size;
        this.fullGrid = fullGrid;
        this.holeGrid = holeGrid;
    }

    public Sudoku(int size) {
        this.size = size;
        this.fullGrid = new int[size][size];
        this.holeGrid = new boolean[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.holeGrid[i][j] = true;
            }
        }
    }

    public Sudoku(Sudoku sudoku){
        this.size = sudoku.getSize();
        this.fullGrid = new int[size][size];
        this.holeGrid = new boolean[size][size];
        for(int i = 0; i < sudoku.getSize(); i++){
            for(int j = 0; j < sudoku.getSize(); j++){
                fullGrid[i][j] = sudoku.fullGrid[i][j];
                holeGrid[i][j] = sudoku.holeGrid[i][j];
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int[][] getFullGrid() {
        return fullGrid;
    }

    public boolean[][] getHoleGrid() {
        return holeGrid;
    }

}