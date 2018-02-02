package kr.or.dgit.bigdata.chapter05;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class TextSwitcherActivity extends AppCompatActivity {
    TextSwitcher mSwitcher;
    int mAdldx = 0;
    String[] arAd = new String[]{"1. 정력짱! 롯데 삼계탕", "2. Ms 명품 마우스", "3. 애플 아이 사과 쥬스", "4. 신용 불량자 긴급대충"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);

        mSwitcher = findViewById(R.id.switcher);
        mSwitcher.setFactory(mFactory);
        mSwitcher.setText(arAd[mAdldx]);

    }

    public void mNextView(View view) {
        mAdldx = mAdldx == arAd.length - 1? 0 : mAdldx + 1;
        mSwitcher.setText(arAd[mAdldx]);

    }

    ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView text = new TextView(TextSwitcherActivity.this);
                text.setTextSize(22);
                text.setBackgroundColor(Color.YELLOW);
                text.setTextColor(Color.BLACK);
                return text;


            }
    };
}
