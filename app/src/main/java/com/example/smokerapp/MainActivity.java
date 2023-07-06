package com.example.smokerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.bumptech.glide.Glide;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private GifDrawable gifDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gifImageView = findViewById(R.id.gifImageView);
        gifDrawable = (GifDrawable) gifImageView.getDrawable();
        gifDrawable.pause();

        // Add a listener to detect exhaling
        gifImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN) {
                    // Exhale detected, resume the GIF
                    gifDrawable.start();
                } else if (action == MotionEvent.ACTION_UP) {
                    // Inhale detected, pause the GIF
                    gifDrawable.pause();
                }
                return true;
            }
        });
    }
}