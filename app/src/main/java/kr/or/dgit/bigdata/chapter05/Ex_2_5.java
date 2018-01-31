package kr.or.dgit.bigdata.chapter05;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Ex_2_5 extends AppCompatActivity {
    AlertDialog customDialog;
    AlertDialog radioDialog;
    AlertDialog checkBoxDialog;
    AlertDialog alertDialog;
    ArrayList<String> checkBoxList;
    RelativeLayout dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_2_5);
        checkBoxList = new ArrayList<>();
    }

    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if(dialogInterface == checkBoxDialog && i == DialogInterface.BUTTON_POSITIVE){
                showToast(checkBoxList.toString());
            }else if(i ==DialogInterface.BUTTON_POSITIVE) {
                showToast("확인");
            }else if(i == DialogInterface.BUTTON_NEGATIVE){
                showToast("취소");
            }else if(dialogInterface == radioDialog){
                String[] items = getResources().getStringArray(R.array.dialog_array);
                showToast(items[i]);
            }
        }
    };

    DialogInterface.OnClickListener customListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if(i == DialogInterface.BUTTON_POSITIVE){
                // 체크박스는 전개된 layout에 존재하므로 전개하는 view를 지정해둠
                CheckBox cb = dialogView.findViewById(R.id.CustomCheckBox);
                String value = String.valueOf(cb.isChecked());
                showToast(value);
            }else{
                showToast("취소");
            }
        }
    };

    DialogInterface.OnMultiChoiceClickListener checkBoxListener = new DialogInterface.OnMultiChoiceClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
            String[] items = getResources().getStringArray(R.array.dialog_array);
            if(b){
                checkBoxList.add(items[i]);
                showToast(items[i] + "선택");
            }else{
                checkBoxList.remove(items[i]);
                showToast(items[i] + "취소");
            }

        }
    };


    public void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }


    public void mOnclickBtn(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Calendar c = Calendar.getInstance();
        switch (view.getId()) {
            case R.id.btn01:
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setTitle("알림");
                builder.setMessage("정말 종료 하시겠습니까?");
                builder.setPositiveButton("OK", dialogListener);
                builder.setNegativeButton("NO", dialogListener);
                alertDialog = builder.create();
                alertDialog.show();
                break;
            case R.id.btn02:
                builder.setSingleChoiceItems(R.array.dialog_array, 0,dialogListener);
                builder.setPositiveButton("OK", dialogListener);
                builder.setNegativeButton("NO", dialogListener);
                radioDialog = builder.create();
                radioDialog.show();
                break;
            case R.id.btn03:
                builder.setMultiChoiceItems(R.array.dialog_array, null, checkBoxListener);
                builder.setPositiveButton("OK", dialogListener);
                builder.setNegativeButton("NO", dialogListener);
                checkBoxDialog = builder.create();
                checkBoxDialog.show();
                break;
            case R.id.btn04:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setIcon(android.R.drawable.ic_dialog_alert);
                progressDialog.setTitle("Wait...");
                progressDialog.setMessage("서버 연동중입니다. 잠시만 기다리세요.");

                progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
                progressDialog.setIndeterminate(true);

                progressDialog.show();

                break;
            case R.id.btn05:

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dateDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                showToast(i + ":" + (i1+1) + ":" + i2);
                            }
                        }, year, month, day);
                dateDialog.show();
                break;
            case R.id.btn06:

                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                showToast(i + ":" + i1);
                            }
                        }, hour, minute, false);
                timePickerDialog.show();

                break;
            case R.id.btn07:
                dialogView = (RelativeLayout) View.inflate(this, R.layout.dialog_layout, null);
                builder.setView(dialogView);
                builder.setPositiveButton("확인", customListener);
                builder.setNegativeButton("취소", customListener);

                customDialog = builder.create();
                customDialog.show();
                break;
    }

    }
}
