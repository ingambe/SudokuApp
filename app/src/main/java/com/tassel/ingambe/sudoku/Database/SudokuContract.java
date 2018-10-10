package com.tassel.ingambe.sudoku.Database;

import android.provider.BaseColumns;

public final class SudokuContract {

    private SudokuContract() {}

    public static class SudokuEntry implements BaseColumns {
        public static final String TABLE_NAME = "sudoku";
        public static final String COLUMN_GRID = "grid";
        public static final String COLUMN_HOLE = "hole";
        public static final String COLUMN_BACKTRACK = "backtrack";
        public static final String COLUMN_DEPTH = "depth";
        public static final String COLUMN_FAIL= "fail";
        public static final String COLUMN_DECISION_COUNT= "decision_count";
    }

}
