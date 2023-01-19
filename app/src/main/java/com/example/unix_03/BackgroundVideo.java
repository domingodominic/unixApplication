package com.example.unix_03;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.io.IOException;

public class BackgroundVideo extends SurfaceView implements SurfaceHolder.Callback {

    private MediaPlayer mp;
    private  Boolean isStarted = false;
    public BackgroundVideo(Context context) {
        super(context);

        init();
    }



    public BackgroundVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BackgroundVideo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BackgroundVideo(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        mp = new MediaPlayer();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        AssetFileDescriptor assetFileDescriptor = getResources().openRawResourceFd(R.raw.bgvideo);


        try {
        if(!isStarted){
            isStarted = true;
                mp.setDataSource(assetFileDescriptor.getFileDescriptor(),assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());




        }

            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = getHeight();
            layoutParams.width  = getWidth();
            setLayoutParams(layoutParams);
            mp.prepare();
            mp.setDisplay(getHolder());
            mp.setLooping(true);
            mp.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        mp.stop();

    }
}
