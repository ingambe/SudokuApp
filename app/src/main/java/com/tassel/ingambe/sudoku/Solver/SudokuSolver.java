package com.tassel.ingambe.sudoku.Solver;

import com.tassel.ingambe.sudoku.Model.Sudoku;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.measure.IMeasures;
import org.chocosolver.solver.variables.IntVar;

public class SudokuSolver {

    private Sudoku sudoku;
    private int nbRow;
    private Model model;
    private IntVar lines[][];
    private IntVar rows[][];
    private IntVar squares[][];
    private Solver solver;

    long nbSolutions;
    long nbBacktrack;

    public SudokuSolver(Sudoku sudoku) {
        this.sudoku = sudoku;
        this.nbRow = sudoku.getSize();
        model = new Model("Sudoku");
        lines = model.intVarMatrix("lines", nbRow, nbRow, 1, 9);
        rows = model.intVarMatrix("rows", nbRow, nbRow, 1, 9);
        squares = model.intVarMatrix("squares", nbRow, nbRow, 1, 9);
        nbSolutions = 0;
        nbBacktrack = 0;
    }

    public void applyConstraints(){
        for(int i = 0; i < nbRow; i++){
            model.allDifferent(lines[i]).post();
            model.allDifferent(rows[i]).post();
            model.allDifferent(squares[i]).post();
        }
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < nbRow; j++){
                model.arithm(lines[i][j], "=", rows[j][i]).post();
            }
        }
        int squareRows = (int) (Math.sqrt(nbRow) / 1);
        for(int i = 0; i < squareRows; i++){
            for(int j = 0; j < squareRows; j++) {
                for(int k = 0; k < squareRows; k++) {
                    for(int m = 0; m < squareRows; m++){
                        //model.arithm(squares[j + (k * squareRows)][i + (m * squareRows)], "=", rows[m + (k * squareRows)][i + (j * squareRows)]).post();
                        model.arithm(squares[squareRows * i + j][squareRows*k+m], "=", lines[squareRows*i+k][squareRows*j+m]).post();
                    }
                }
            }
        }
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < nbRow; j++){
                if(sudoku.getHoleGrid()[i][j]){
                    int valeurSudoku = sudoku.getFullGrid()[i][j];
                    model.arithm(lines[i][j], "=", valeurSudoku).post();
                }
            }
        }
    }

    public boolean solve(){
        applyConstraints();
        Solver solver = model.getSolver();
        if(solver.solve()){
            nbSolutions = solver.getSolutionCount();
            nbBacktrack = solver.getBackTrackCount();
            return true;
        }
        return false;
    }

    public boolean uniqueSolution(){
        return nbSolutions == 1;
    }

    public int[][] getSolution(){
        solve();
        int solution[][] = new int[nbRow][nbRow];
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < nbRow; j++){
                solution[i][j] = lines[i][j].getValue();
            }
        }
        return solution;
    }

    public int getBacktracks() {
        return (int) solver.getBackTrackCount();
    }

    public int getDepth() {
        return (int) solver.getMaxDepth();
    }

    public int getFails() {
        return (int) solver.getFailCount();
    }

}
