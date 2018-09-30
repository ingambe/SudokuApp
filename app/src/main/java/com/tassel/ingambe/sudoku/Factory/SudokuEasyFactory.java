package com.tassel.ingambe.sudoku.Factory;

import com.tassel.ingambe.sudoku.Model.Sudoku;

public class SudokuEasyFactory {

    /**
     * We use a correct Sudoku that we shift
     *
     * @param taille size of sudoku
     */
    public static Sudoku make(int taille) {
        int[][] grilleInitiale = makeGrille(taille);
        boolean[][] trous = makeTrous(taille);
        return new Sudoku(taille, grilleInitiale, trous);
    }

    public static Sudoku make() {
        int[][] grilleInitiale = makeGrille(9);
        boolean[][] trous = makeTrous(9);
        return new Sudoku(9, grilleInitiale, trous);
    }

    private static int[][] makeGrille(int taille) {
        int[][] grilleInitiale = new int[taille][taille];
        grilleInitiale[0][0] = 7;
        grilleInitiale[0][1] = 3;
        grilleInitiale[0][2] = 5;
        grilleInitiale[0][3] = 9;
        grilleInitiale[0][4] = 2;
        grilleInitiale[0][5] = 4;
        grilleInitiale[0][6] = 6;
        grilleInitiale[0][7] = 1;
        grilleInitiale[0][8] = 8;
        grilleInitiale[1][0] = 4;
        grilleInitiale[1][1] = 6;
        grilleInitiale[1][2] = 2;
        grilleInitiale[1][3] = 1;
        grilleInitiale[1][4] = 8;
        grilleInitiale[1][5] = 3;
        grilleInitiale[1][6] = 7;
        grilleInitiale[1][7] = 9;
        grilleInitiale[1][8] = 5;
        grilleInitiale[2][0] = 8;
        grilleInitiale[2][1] = 9;
        grilleInitiale[2][2] = 1;
        grilleInitiale[2][3] = 7;
        grilleInitiale[2][4] = 6;
        grilleInitiale[2][5] = 5;
        grilleInitiale[2][6] = 3;
        grilleInitiale[2][7] = 4;
        grilleInitiale[2][8] = 2;
        grilleInitiale[3][0] = 3;
        grilleInitiale[3][1] = 4;
        grilleInitiale[3][2] = 7;
        grilleInitiale[3][3] = 2;
        grilleInitiale[3][4] = 5;
        grilleInitiale[3][5] = 1;
        grilleInitiale[3][6] = 8;
        grilleInitiale[3][7] = 6;
        grilleInitiale[3][8] = 9;
        grilleInitiale[4][0] = 5;
        grilleInitiale[4][1] = 1;
        grilleInitiale[4][2] = 9;
        grilleInitiale[4][3] = 6;
        grilleInitiale[4][4] = 4;
        grilleInitiale[4][5] = 8;
        grilleInitiale[4][6] = 2;
        grilleInitiale[4][7] = 3;
        grilleInitiale[4][8] = 7;
        grilleInitiale[5][0] = 2;
        grilleInitiale[5][1] = 8;
        grilleInitiale[5][2] = 6;
        grilleInitiale[5][3] = 3;
        grilleInitiale[5][4] = 7;
        grilleInitiale[5][5] = 9;
        grilleInitiale[5][6] = 1;
        grilleInitiale[5][7] = 5;
        grilleInitiale[5][8] = 4;
        grilleInitiale[6][0] = 6;
        grilleInitiale[6][1] = 5;
        grilleInitiale[6][2] = 4;
        grilleInitiale[6][3] = 8;
        grilleInitiale[6][4] = 3;
        grilleInitiale[6][5] = 7;
        grilleInitiale[6][6] = 9;
        grilleInitiale[6][7] = 2;
        grilleInitiale[6][8] = 1;
        grilleInitiale[7][0] = 1;
        grilleInitiale[7][1] = 2;
        grilleInitiale[7][2] = 8;
        grilleInitiale[7][3] = 4;
        grilleInitiale[7][4] = 9;
        grilleInitiale[7][5] = 6;
        grilleInitiale[7][6] = 5;
        grilleInitiale[7][7] = 7;
        grilleInitiale[7][8] = 3;
        grilleInitiale[8][0] = 9;
        grilleInitiale[8][1] = 7;
        grilleInitiale[8][2] = 3;
        grilleInitiale[8][3] = 5;
        grilleInitiale[8][4] = 1;
        grilleInitiale[8][5] = 2;
        grilleInitiale[8][6] = 4;
        grilleInitiale[8][7] = 8;
        grilleInitiale[8][8] = 6;
        return grilleInitiale;
    }

    private static boolean[][] makeTrous(int taille) {
        boolean[][] trous = new boolean[taille][taille];
        trous[0][1] = true;
        trous[0][3] = true;
        trous[0][4] = true;
        trous[0][6] = true;
        trous[0][7] = true;
        trous[0][8] = true;

        trous[1][0] = true;
        trous[1][1] = true;
        trous[1][2] = true;
        trous[1][3] = true;
        trous[1][5] = true;
        trous[1][6] = true;
        trous[1][8] = true;

        trous[2][0] = true;
        trous[2][3] = true;
        trous[2][4] = true;
        trous[2][6] = true;
        trous[2][7] = true;
        trous[2][8] = true;

        trous[3][2] = true;
        trous[3][4] = true;
        trous[3][5] = true;
        trous[3][7] = true;
        trous[3][8] = true;

        trous[4][1] = true;
        trous[4][3] = true;
        trous[4][4] = true;
        trous[4][5] = true;
        trous[4][6] = true;
        trous[4][8] = true;

        trous[5][0] = true;
        trous[5][1] = true;
        trous[5][3] = true;
        trous[5][4] = true;
        trous[5][6] = true;

        trous[6][0] = true;
        trous[6][1] = true;
        trous[6][3] = true;
        trous[6][5] = true;
        trous[6][8] = true;

        trous[7][0] = true;
        trous[7][2] = true;
        trous[7][3] = true;
        trous[7][5] = true;
        trous[7][6] = true;
        trous[7][7] = true;
        trous[7][8] = true;

        trous[8][0] = true;
        trous[8][1] = true;
        trous[8][2] = true;
        trous[8][4] = true;
        trous[8][5] = true;
        trous[8][8] = true;
        return trous;
    }

}
