package kr.or.dgit.bigdata.chapter05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        }
        startActivity(intent);


    }
}