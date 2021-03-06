package com.tassel.ingambe.sudoku.Solver;

import com.tassel.ingambe.sudoku.Model.Sudoku;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.criteria.Criterion;

import java.util.List;

public class SudokuSolver {

    private Sudoku sudoku;
    private int nbRow;
    private Model model;
    private IntVar lines[][];
    private IntVar rows[][];
    private IntVar squares[][];

    public long nbSolutions;
    public long nbBacktrack;

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

    private void applyConstraints(){
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < nbRow; j++){
                if(!sudoku.getHoleGrid()[i][j]){
                    int valeurSudoku = sudoku.getFullGrid()[i][j];
                    model.arithm(lines[i][j], "=", valeurSudoku).post();
                }
            }
        }
        for(int i = 0; i < nbRow; i++){
            for(int j = 0; j < nbRow; j++){
                model.distance(lines[i][j], rows[j][i], "=", 0).post();
            }
        }
        int squareRows = (int) (Math.sqrt(nbRow) / 1);
        for(int i = 0; i < squareRows; i++){
            for(int j = 0; j < squareRows; j++) {
                for(int k = 0; k < squareRows; k++) {
                    for(int m = 0; m < squareRows; m++) {
                        squares[j + k * 3][i + m * squareRows] = lines[k * 3 + m][i + j * 3];
                    }
                }
            }
        }
        for(int i = 0; i < nbRow; i++){
            model.allDifferent(lines[i], "AC").post();
            model.allDifferent(rows[i], "AC").post();
            model.allDifferent(squares[i], "AC").post();
        }
    }

    private boolean solve(){
        applyConstraints();
        Solver solver = model.getSolver();
        // we do this to find if there is more than one solution ore not
        List<Solution> solutions = solver.findAllSolutions(new Criterion() {
            @Override
            public boolean isMet() {
                return solver.getSolutionCount() > 1;
            }
        });
        if(!solutions.isEmpty()){
            solver.solve();
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
        boolean solutionExist = solve();
        int solution[][] = new int[nbRow][nbRow];
        if (solutionExist) {
            for (int i = 0; i < nbRow; i++) {
                for (int j = 0; j < nbRow; j++) {
                    solution[i][j] = lines[i][j].getValue();
                }
            }
        }
        return solution;
    }

}
