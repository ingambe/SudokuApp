package com.tassel.ingambe.sudoku;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.Presenter.SudokuPresenter;
import com.tassel.ingambe.sudoku.View.SudokuView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SudokuActivity extends AppCompatActivity implements SudokuView {

    @BindView(R.id.bt_submit)
    Button btSubmit;
    @BindView(R.id.tb_sudoku)
    TableLayout tbSudoku;
    @BindView(R.id.tv_selected_difficulty)
    TextView tvSelectedDifficulty;
    @BindView(R.id.chronometer)
    Chronometer chronometer;

    private SudokuPresenter sudokuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        ButterKnife.bind(this);
        sudokuPresenter = (SudokuPresenter) getLastCustomNonConfigurationInstance();
        if(sudokuPresenter == null) {
            sudokuPresenter = new SudokuPresenter();
            sudokuPresenter.initView(this);
        } else {
            sudokuPresenter.initView(this);
        }
    }

    @OnClick({R.id.bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_submit:
                sudokuPresenter.verifySudoku();
                break;
        }
    }

    @Override
    public int getDifficulty() {
        return getIntent().getIntExtra(MainActivity.EXTRA_LEVEL, 0);
    }

    @Override
    public int getSize() {
        return getIntent().getIntExtra(MainActivity.EXTRA_SIZE, 9);
    }

    /**
     * Generate the grid from the sudoku model
     * If it's a hole we made it fillable and empty
     * Otherwise we made it unfillable and with the correct number
     * @param model the sudoku model
     */
    @Override
    public void generateGrid(Sudoku model) {
        // we remove all view in case we restart
        tbSudoku.removeAllViews();
        for (int i = 0; i < model.getSize(); i++) {
            TableRow line = new TableRow(this);
            for (int j = 0; j < model.getSize(); j++) {
                EditText editText = new EditText(this);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setKeyListener(DigitsKeyListener.getInstance("123456789"));
                InputFilter[] inputArray = new InputFilter[1];
                inputArray[0] = new InputFilter.LengthFilter(1);
                editText.setFilters(inputArray);
                editText.setBackgroundColor(0);
                editText.setGravity(Gravity.CENTER);
                // if it's not a hole we need to fill it and desactivate user inputs
                if (!model.getHoleGrid()[i][j]) {
                    editText.setText("" + model.getFullGrid()[i][j]);
                    editText.setFocusable(false);
                    editText.setFocusableInTouchMode(false);
                    editText.setClickable(false);
                } else{
                    editText.setTextColor(getResources().getColor(R.color.colorAccent));
                    editText.setSelectAllOnFocus(true);
                }
                if(i == 2 && j == 3 || i == 2 && j == 6){
                    editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_bottom));
                } else if(i == 5 && j == 3 || i == 5 && j == 6){
                    editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_bottom));
                } else if(j == 3 || j == 6){
                    editText.setBackground(getDrawable(R.drawable.sudoku_cell_left));
                } else if(i == 2 || i == 5){
                    editText.setBackground(getDrawable(R.drawable.sudoku_cell_bottom));
                } else {
                    editText.setBackground(getDrawable(R.drawable.sudoku_cell));
                }
                line.addView(editText, new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            }
            tbSudoku.addView(line, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public void setDifficultyText(int difficulty) {
        tvSelectedDifficulty.setText(R.string.selected_difficulty);
        switch (difficulty) {
            case 0:
                tvSelectedDifficulty.append(" " + getResources().getString(R.string.easy));
                break;
            case 1:
                tvSelectedDifficulty.append(" " + getResources().getString(R.string.medium));
                break;
            default:
                tvSelectedDifficulty.append(" " + getResources().getString(R.string.hard));
                break;
        }
    }

    @Override
    public void startChronometer() {
        chronometer.setFormat("%s");
        chronometer.start();
    }

    @Override
    public void stopChronometer() {
        chronometer.stop();
    }

    @Override
    public int getGridElement(int i, int j) {
        View parentRow = tbSudoku.getChildAt(i);
        if(parentRow instanceof TableRow){
            TableRow tableRow = (TableRow) parentRow;
            EditText editText = (EditText) tableRow.getChildAt(j);
            // if empty we return a flag to change the color with
            // a different color than the one for an error
            if(editText.getText().toString().equals("")){
                return -1;
            } else {
                return Integer.parseInt(editText.getText().toString());
            }
        }
        return 0;
    }

    @Override
    public void setGridElement(int i, int j, int value) {
        View parentRow = tbSudoku.getChildAt(i);
        if(parentRow instanceof TableRow){
            TableRow tableRow = (TableRow) parentRow;
            EditText editText = (EditText) tableRow.getChildAt(j);
            // if empty we return a flag to change the color with
            // a different color than the one for an error
            editText.setText("" + value);
        }
    }

    @Override
    public void colorOrangeRow(int i, int j) {
        colorRow(i, j, 1);
    }

    @Override
    public void colorRedRow(int i, int j) {
        colorRow(i, j, 0);
    }

    /**
     * Color a row with the desire color
     * @param i line
     * @param j columm
     * @param color 0 == red
     *              1 == orange
     */
    private void colorRow(int i, int j, int color){
        View parentRow = tbSudoku.getChildAt(i);
        if(parentRow instanceof TableRow){
            TableRow tableRow = (TableRow) parentRow;
            EditText editText = (EditText) tableRow.getChildAt(j);
            switch (color){
                case 0:
                    if(i == 2 && j == 3 || i == 2 && j == 6){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_bottom_red));
                    } else if(i == 5 && j == 3 || i == 5 && j == 6){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_bottom_red));
                    } else if(j == 3 || j == 6){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_red));
                    } else if(i == 2 || i == 5){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_bottom_red));
                    } else {
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_red));
                    }
                    break;
                case 1:
                    if(i == 2 && j == 3 || i == 2 && j == 6){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_bottom_orange));
                    } else if(i == 5 && j == 3 || i == 5 && j == 6){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_bottom_orange));
                    } else if(j == 3 || j == 6){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_orange));
                    } else if(i == 2 || i == 5){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_bottom_orange));
                    } else {
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_orange));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @return time elapsed in milliseconds
     */
    @Override
    public long getChronometerTime() {
        return (SystemClock.elapsedRealtime() - chronometer.getBase());
    }

    @Override
    public void setChronometerTime(long milliseconds) {
        chronometer.setBase(SystemClock.elapsedRealtime() - milliseconds);
    }

    @Override
    public void restartChronometer() {
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return sudokuPresenter;
    }

    @Override
    protected void onDestroy() {
        sudokuPresenter.saveState();
        sudokuPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void alertDialogSuccess(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(true)
                .setNegativeButton(R.string.menu, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sudokuPresenter.restart(SudokuActivity.this);
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        btSubmit.setText(getResources().getText(R.string.retry));
                        btSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                sudokuPresenter.restart(SudokuActivity.this);
                                btSubmit.setText(getResources().getText(R.string.submit));
                                btSubmit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        sudokuPresenter.verifySudoku();
                                    }
                                });
                            }
                        });
                    }
                });
        builder.create().show();
    }

    /**
     * The success text depend on the difficulty
     * @param difficulty the difficulty
     * @return the text to display to the user in the alert dialog
     */
    @Override
    public String getTextSuccess(int difficulty) {
        int id;
        switch (difficulty){
            case 0:
                id = R.string.easy_success;
                break;
            case 1:
                id = R.string.medium_success;
                break;
            default:
                id = R.string.hard_success;
                break;
        }
        return getResources().getText(id).toString();
    }

    /**
     * Text for the success alert dialog
     * @return the text to inform about the time spent
     */
    @Override
    public String getTextTime() {
        return getResources().getText(R.string.time_success).toString();
    }

}