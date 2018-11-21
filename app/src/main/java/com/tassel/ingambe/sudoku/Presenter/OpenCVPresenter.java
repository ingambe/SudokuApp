package com.tassel.ingambe.sudoku.Presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tassel.ingambe.sudoku.Model.Sudoku;
import com.tassel.ingambe.sudoku.View.OpenCVView;

import java.util.ArrayList;
import java.util.List;

public class OpenCVPresenter {

    private OpenCVView view;
    private Sudoku model;
    // variable to save state
    private int[][] savedState;
    private long timeChronometer;
    private List<Couple> errorRow;
    private List<Couple> emptyRow;

    public void initView(OpenCVView view){
        this.view = view;
        String imagePath = view.pathOfImage();
        model = fromImage(imagePath);
        //model = SudokuAbstractFactory.make(difficulty, size);
        /**
        view.generateGrid(model);
        view.startChronometer();
         **/
        // if we need to restore state
        if(savedState != null){
            /**
            view.setChronometerTime(timeChronometer);
            for(int i = 0; i < model.getSize(); i++){
                for(int j = 0; j < model.getSize(); j++){
                    if(savedState[i][j] != -1){
                        view.setGridElement(i, j, savedState[i][j]);
                    }
                }
            }
            showIncorrectRow();
            showEmptyRow();
             **/
        } else {
            errorRow = new ArrayList<>();
            emptyRow = new ArrayList<>();
        }
    }

    public void detachView(){
        this.view = null;
    }

    public void restart(OpenCVView view){
        savedState = null;
        errorRow = null;
        emptyRow = null;
        //view.restartChronometer();
        initView(view);
    }

    public void saveState(){
        /**
        savedState = new int[model.getSize()][model.getSize()];
        //timeChronometer = view.getChronometerTime();
        for(int i = 0; i < model.getSize(); i++){
            for(int j = 0; j < model.getSize(); j++){
                if(model.getHoleGrid()[i][j]
                       // && view.getGridElement(i, j) != -1
                        ){
                    //savedState[i][j] = view.getGridElement(i, j);
                } else {
                    savedState[i][j] = -1;
                }
            }
        }
         **/
    }

    private Sudoku fromImage(String path){
        Bitmap sudoku_bitmap = BitmapFactory.decodeFile(path);



        /*
        Bitmap sudoku_bitmap = BitmapFactory.decodeFile(path);
        Mat sudoku = new Mat(sudoku_bitmap.getHeight(), sudoku_bitmap.getWidth(), CV_8UC1);
        Bitmap bmp32 = sudoku_bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Utils.bitmapToMat(bmp32, sudoku);
        cvtColor(sudoku, sudoku, COLOR_BGR2GRAY);
        Mat outerBox = new Mat(sudoku.size(), CV_8UC1);
        GaussianBlur(sudoku, sudoku, new Size(11,11), 0);
        adaptiveThreshold(sudoku, outerBox, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 5, 2);
        bitwise_not(outerBox, outerBox);
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(3, 3));
        dilate(outerBox, outerBox, kernel);

        Mat largestBlobMat = outerBox.clone();
        int height = largestBlobMat.height();
        int width = largestBlobMat.width();


        Point maxBlobOrigin = new Point(0, 0);

        int maxBlobSize = 0;
        Mat greyMask = new Mat(height + 2, width + 2, CvType.CV_8U, new Scalar(0, 0, 0));
        Mat blackMask = new Mat(height + 2, width + 2, CvType.CV_8U, new Scalar(0, 0, 0));
        for (int y = 0; y < height; y++) {
            Mat row = largestBlobMat.row(y);
            for (int x = 0; x < width; x++) {
                double[] value = row.get(0, x);
                Point currentPoint = new Point(x, y);

                if (value[0] > THRESHOLD) {
                    int blobSize = Imgproc.floodFill(largestBlobMat, greyMask, currentPoint, new Scalar(64));
                    if (blobSize > maxBlobSize) {
                        Imgproc.floodFill(largestBlobMat, blackMask, maxBlobOrigin, new Scalar(0));
                        maxBlobOrigin = currentPoint;
                        maxBlobSize = blobSize;
                    } else {
                        Imgproc.floodFill(largestBlobMat, blackMask, currentPoint, new Scalar(0));
                    }
                }
            }
        }
        Mat largeBlobMask = new Mat(height + 2, width + 2, CvType.CV_8U, new Scalar(0));
        double largestSize = (double) Imgproc.floodFill(largestBlobMat, largeBlobMask, maxBlobOrigin, new Scalar(255));
        double area = height * width;
        if(largestSize / area < 0.01) {
            Mat eraseMask = new Mat(height + 2, width + 2, CvType.CV_8U, new Scalar(0));
            Imgproc.floodFill(largestBlobMat, eraseMask, maxBlobOrigin, new Scalar(0));
        }

        height = outerBox.height();
        width = outerBox.width();
        for (int y = 0; y < height; y++) {
            Mat row = largestBlobMat.row(y);
            for (int x = 0; x < width; x++) {
                double[] value = row.get(0, x);
                Point currentPoint = new Point(x, y);
                if (value[0] > THRESHOLD) {
                    blackMask = new Mat(height + 2, width + 2, CvType.CV_8U, new Scalar(0, 0, 0));
                    Imgproc.floodFill(largestBlobMat, blackMask, currentPoint, new Scalar(0));
                    break;
                }
            }
        }*/

        return null;
    }

}