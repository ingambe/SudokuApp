package com.tassel.ingambe.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.bt_easy)
    Button btEasy;
    @BindView(R.id.bt_medium)
    Button btMedium;
    @BindView(R.id.bt_hard)
    Button btHard;
    @BindView(R.id.bt_solver)
    Button btSolver;
    @BindView(R.id.tv_credit)
    TextView tvCredit;

    public static final String EXTRA_LEVEL = "EXTRA_LEVEL";
    public static final String EXTRA_SIZE = "EXTRA_SIZE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_easy, R.id.bt_medium, R.id.bt_hard, R.id.bt_solver})
    public void onViewClicked(View view) {
        Intent intent = new Intent(MainActivity.this, SudokuActivity.class);
        switch (view.getId()) {
            case R.id.bt_easy:
                intent.putExtra(MainActivity.EXTRA_LEVEL, 0);
                break;
            case R.id.bt_medium:
                intent.putExtra(MainActivity.EXTRA_LEVEL, 1);
                break;
            case R.id.bt_hard:
                intent.putExtra(MainActivity.EXTRA_LEVEL, 2);
                break;
            case R.id.bt_solver:
                intent = new Intent(MainActivity.this, SolverActivity.class);
                break;
        }
        startActivity(intent);
    }
}
