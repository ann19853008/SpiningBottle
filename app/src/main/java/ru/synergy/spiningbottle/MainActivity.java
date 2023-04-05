package ru.synergy.spiningbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    private int last_dir;
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = findViewById(R.id.bottle);
    }

    public void spinBottle(View v) {
        if (!spinning) {
            Random random = new Random();
            int new_dir = random.nextInt(2160);
            float pointWidth = bottle.getWidth() / 2;
            float pointHeight = bottle.getHeight() / 2;
            Animation rotation = new RotateAnimation(last_dir, new_dir, pointWidth, pointHeight);
            rotation.setDuration(2700);
            rotation.setFillAfter(true);
            rotation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            last_dir = new_dir;
            bottle.startAnimation(rotation);
        }
    }
}