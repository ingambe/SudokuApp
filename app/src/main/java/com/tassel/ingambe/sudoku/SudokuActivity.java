package com.tassel.ingambe.sudoku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.Gravity;
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

        sudokuPresenter = new SudokuPresenter(this);
    }

    @Override
    public int getDifficulty() {
        return getIntent().getIntExtra(MainActivity.EXTRA_LEVEL, 0);
    }

    @Override
    public int getSize() {
        return getIntent().getIntExtra(MainActivity.EXTRA_SIZE, 9);
    }

    @Override
    public void generateGrid(Sudoku model) {
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
                tvSelectedDifficulty.append(getResources().getString(R.string.easy));
                break;
            case 1:
                tvSelectedDifficulty.append(getResources().getString(R.string.medium));
                break;
            default:
                tvSelectedDifficulty.append(getResources().getString(R.string.hard));
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
}