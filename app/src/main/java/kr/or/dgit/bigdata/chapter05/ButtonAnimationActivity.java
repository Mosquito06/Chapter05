package kr.or.dgit.bigdata.chapter05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ButtonAnimationActivity extends AppCompatActivity {
    LinearLayout mLinear;
    int mCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_animation);

        mLinear = findViewById(R.id.root);
    }

    public void mOnClick(View view) {
        Button btn = new Button(this);
        btn.setText("B" + mCount);
        mCount++;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLinear.removeView(view);
            }
        });

        mLinear.addView(btn);
    }
}
