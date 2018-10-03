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