![logo](https://upload.wikimedia.org/wikipedia/commons/2/27/Sudoku-by-L2G-20050714modif.svg)

This application generate Sudoku grids and can solve a Sudoku grid using constraint programming.

## Grid Generation

We start from an existing grid and we obtain a new one by swithing line and column within each square.

The randomizer is accessible here : [Sudoku Randomize](app/src/main/java/com/tassel/ingambe/sudoku/Factory/SudokuRandomizer.java)

## Solving Sudoku

[![Choco-solver](http://www.choco-solver.org/img/banner.svg)](http://www.choco-solver.org/?utm_source=badge&utm_medium=badge&utm_campaign=badge)

The solver use Choco-solver to solve the Sudoku grid.

With the following constraints:
```java
for(int i = 0; i < nbRow; i++){
    for(int j = 0; j < nbRow; j++){
       if(!sudoku.getHoleGrid()[i][j]){
          int rowValue = sudoku.getFullGrid()[i][j];
          model.arithm(lines[i][j], "=", rowValue).post();
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
```
The solver was purposely made generical to be able to solve `9*9`, `12*12`, ...

## TODO

* Generate grids using the solver and the number of backtrack to find the difficulty.
* Red background for cells in solver activity if incorrect input.
