package kr.or.dgit.bigdata.chapter05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

import kr.or.dgit.bigdata.chapter05.Chapter06.Ch06Hierarchy;
import kr.or.dgit.bigdata.chapter05.Chapter06.Ch06MainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnclickBtn(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.toPart2_5:
                intent.setClass(getApplicationContext(), Ex_2_5.class);
                break;
            case R.id.eventDele:
                intent.setClass(getApplicationContext(), Ch06MainActivity.class);
                break;
            case R.id.eventHier:
                intent.setClass(getApplicationContext(), Ch06Hierarchy.class);
                break;
            case R.id.animation:
                intent.setClass(getApplicationContext(), AnimationActivity.class);
                break;
            case R.id.textSwitcher:
                intent.setClass(getApplicationContext(), TextSwitcherActivity.class);
                break;
            case R.id.ButtonAnimation:
                intent.setClass(getApplicationContext(), ButtonAnimationActivity.class);
                break;

        }
        startActivity(intent);


    }
}
