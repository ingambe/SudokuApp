package com.tassel.ingambe.sudoku;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.Presenter.SolverPresenter;
import com.tassel.ingambe.sudoku.View.SolverView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SolverActivity extends AppCompatActivity implements SolverView {

    @BindView(R.id.bt_solver)
    Button btSolver;
    @BindView(R.id.tb_sudoku_solver)
    TableLayout tbSudoku;

    private SolverPresenter solverPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solver);
        ButterKnife.bind(this);
        solverPresenter = (SolverPresenter) getLastCustomNonConfigurationInstance();
        if(solverPresenter == null) {
            solverPresenter = new SolverPresenter();
            solverPresenter.initView(this);
        } else {
            solverPresenter.initView(this);
        }
    }

    @OnClick(R.id.bt_solver)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_solver:
                solverPresenter.verifySudoku();
                break;
        }
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
    public Object onRetainCustomNonConfigurationInstance() {
        return solverPresenter;
    }

    @Override
    protected void onDestroy() {
        solverPresenter.saveState();
        solverPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void colorGreenRow(int i, int j) {
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
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_bottom_green));
                    } else if(i == 5 && j == 3 || i == 5 && j == 6){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_bottom_green));
                    } else if(j == 3 || j == 6){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_left_green));
                    } else if(i == 2 || i == 5){
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_bottom_green));
                    } else {
                        editText.setBackground(getDrawable(R.drawable.sudoku_cell_green));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void showNoSolution() {
        String message = getResources().getText(R.string.solver_no_solution).toString();
        alertDialogInformation(message);
    }

    @Override
    public void showMultipleSolution() {
        String message = getResources().getText(R.string.solver_no_unique).toString();
        alertDialogInformation(message);
    }

    private void alertDialogInformation(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        builder.create().show();
    }
}
