package com.tassel.ingambe.sudoku;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @BindView(R.id.bt_open_cv)
    Button btOpenCv;
    @BindView(R.id.tv_credit)
    TextView tvCredit;

    public static final String EXTRA_LEVEL = "EXTRA_LEVEL";
    public static final String EXTRA_SIZE = "EXTRA_SIZE";
    public static final String IOEXECPTION_TAG = "IOEXECPTION_TAG";
    public static final String EXTRA_PHOTO_PATH = "PHOTO_PATH";

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    
    private String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (!OpenCVLoader.initDebug()) {
            Log.e(this.getClass().getSimpleName(), "  OpenCVLoader.initDebug(), not working.");
        } else {
            Log.d(this.getClass().getSimpleName(), "  OpenCVLoader.initDebug(), working.");
        }
    }

    @OnClick({R.id.bt_easy, R.id.bt_medium, R.id.bt_hard, R.id.bt_open_cv})
    public void onViewClicked(View view) {
        Intent intent = new Intent(MainActivity.this, SudokuActivity.class);
        switch (view.getId()) {
            case R.id.bt_easy:
                intent.putExtra(MainActivity.EXTRA_LEVEL, 0);
                startActivity(intent);
                break;
            case R.id.bt_medium:
                intent.putExtra(MainActivity.EXTRA_LEVEL, 1);
                startActivity(intent);
                break;
            case R.id.bt_hard:
                intent.putExtra(MainActivity.EXTRA_LEVEL, 2);
                startActivity(intent);
                break;
            case R.id.bt_open_cv:
                dispatchTakePictureIntent();
                break;
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Log.d(IOEXECPTION_TAG, "IOException");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.tassel.ingambe.sudoku.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_sudoku";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == MainActivity.REQUEST_IMAGE_CAPTURE) {
            Intent newActivity = new Intent(MainActivity.this, OpenCVActivity.class);
            newActivity.putExtra(MainActivity.EXTRA_PHOTO_PATH, mCurrentPhotoPath);
            startActivity(newActivity);
        }
    }
}
