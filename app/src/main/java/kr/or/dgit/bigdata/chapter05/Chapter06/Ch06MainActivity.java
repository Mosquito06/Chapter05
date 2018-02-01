package kr.or.dgit.bigdata.chapter05.Chapter06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import kr.or.dgit.bigdata.chapter05.R;

public class Ch06MainActivity extends AppCompatActivity {
    private TextView bellTextView;
    private TextView labelTextView;
    private CheckBox repeatCheckView;
    private Switch switchView;
    private CheckBox vibrateCheckView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch06_main);
        setTitle("Chapter06 - 델리게이션 이벤트");

        bellTextView = findViewById(R.id.bell_name);
        labelTextView = findViewById(R.id.label);
        repeatCheckView = findViewById(R.id.repeatCheck);
        switchView = findViewById(R.id.onOff);
        vibrateCheckView = findViewById(R.id.vibrate);


        bellTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("벨 라벨 클릭 했다.");
            }
        });

        labelTextView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("라벨 클릭 했다.");
            }
        }));

        repeatCheckView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    showToast("반복으로 설정");
                }else{
                    showToast("반복하지 않음");
                }
            }
        });

        vibrateCheckView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    showToast("진동으로 설정");
                }else{
                    showToast("진동하지 않음");
                }
            }
        });

        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    showToast("스위치 On");
                }else{
                    showToast("스위치 Off");
                }
            }
        });
    }

    public void showToast(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }



}
