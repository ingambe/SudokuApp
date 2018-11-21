package com.tassel.ingambe.sudoku;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.tassel.ingambe.sudoku.Presenter.OpenCVPresenter;
import com.tassel.ingambe.sudoku.View.OpenCVView;

public class OpenCVActivity extends AppCompatActivity implements OpenCVView {

    private OpenCVPresenter openCVPresenter;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_cv);
        imageView = (ImageView) findViewById(R.id.imageCamera);
        openCVPresenter = (OpenCVPresenter) getLastCustomNonConfigurationInstance();
        if(openCVPresenter == null) {
            openCVPresenter = new OpenCVPresenter();
        }
        openCVPresenter.initView(this);
        Bitmap bmImg = BitmapFactory.decodeFile(pathOfImage());
        imageView.setImageBitmap(bmImg);
    }

    @Override
    public String pathOfImage() {
        Intent intent = getIntent();
        return intent.getStringExtra(MainActivity.EXTRA_PHOTO_PATH);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return openCVPresenter;
    }

    @Override
    protected void onDestroy() {
        openCVPresenter.saveState();
        openCVPresenter.detachView();
        super.onDestroy();
    }

}
