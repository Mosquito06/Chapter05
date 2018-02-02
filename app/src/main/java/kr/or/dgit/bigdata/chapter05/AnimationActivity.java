package kr.or.dgit.bigdata.chapter05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, R.anim.moveup);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Animation");
        setContentView(R.layout.activity_animation);

        overridePendingTransition(R.anim.movedown, 0);

        /*imageView = findViewById(R.id.img);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.in);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.move);
                anim.setFillAfter(true);
                imageView.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(anim);*/



    }


}
