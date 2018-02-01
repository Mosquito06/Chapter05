package kr.or.dgit.bigdata.chapter05.Chapter06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

import kr.or.dgit.bigdata.chapter05.R;

public class Ch06Hierarchy extends AppCompatActivity {
    private float initX;
    private long initTime;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            initX = event.getRawX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            float diffX = initX - event.getRawX();
            if (diffX > 30) {
                showToast("왼쪽으로 화면을 밀었습니다.");
            } else if (diffX < 30) {
                showToast("오른쪽으로 화면을 밀었습니다.");
            }
        }
        return true;
    }

   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime > 3000) {
                showToast("종료하려면 한번 더 누르세요.");
                initTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }*/

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - initTime > 3000) {
            showToast("종료하려면 한번 더 누르세요.");
            initTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch06_hierarchy);


    }

    public void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }
}
