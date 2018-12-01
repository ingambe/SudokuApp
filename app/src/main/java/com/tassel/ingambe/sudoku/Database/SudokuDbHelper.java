package com.tassel.ingambe.sudoku.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SudokuDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Sudoku.db";

    public SudokuDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase database){
        /**
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + SudokuContract.SudokuEntry.TABLE_NAME + " (" +
                        SudokuContract.SudokuEntry._ID + " INTEGER PRIMARY KEY," +
                        SudokuContract.SudokuEntry.COLUMN_GRID + " TEXT," +
                        SudokuContract.SudokuEntry.COLUMN_BACKTRACK + " INTEGER," +
                        SudokuContract.SudokuEntry.COLUMN_DECISION_COUNT + " INTEGER," +
                        SudokuContract.SudokuEntry.COLUMN_DEPTH + " INTEGER," +
                        SudokuContract.SudokuEntry.COLUMN_FAIL + " INTEGER," +
                        SudokuContract.SudokuEntry.COLUMN_HOLE + " TEXT," +
                        "CONSTRAINT sudoku_unique UNIQUE (" + SudokuContract.SudokuEntry.COLUMN_GRID + ", " + SudokuContract.SudokuEntry.COLUMN_HOLE + "))";
        database.execSQL(SQL_CREATE_ENTRIES);
         **/
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + SudokuContract.SudokuEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
