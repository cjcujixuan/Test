package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed_name;
    private TextView tv_show;
    private Button btn_submit;
    private EditText ed_height;
    private EditText ed_weight;
    private RadioButton boy;
    private RadioButton girl;
    private TextView demo;
    private RadioButton boy1;
    private CheckBox kiwi;
    private CheckBox apple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        extracted();
    }

    private void extracted() {
        String msg = "";
        if(boy.isChecked()) {
            msg += boy.getText().toString();
        }
        else if(girl.isChecked()) {
            msg += girl.getText().toString();
        }
        else{
            demo.setText("尚未選取");
        }

        if(apple.isChecked()) {
            msg += apple.getText().toString();
        }
        if(kiwi.isChecked()) {
            msg += apple.getText().toString();
        }

        if(boy.isChecked()) {
            demo.setText("男生");
        }
        else if(girl.isChecked()) {
            demo.setText(girl.getText());
        }
        else{
            demo.setText("尚未選取");
        }
    }



    public void extracted(View view) {
        extracted();
    }
    @SuppressLint("SetTextI18n")
    public void submit(View view) {
        String name = ed_name.getText().toString();

        ed_name.setText("");
        double height =  Double.parseDouble(ed_height.getText().toString());
        double weight =  Double.parseDouble(ed_weight.getText().toString());
        double bmi = weight / ((height /100.0) * (height /100.0));

        tv_show.setText(name+ getString(R.string.welcome) + bmi);

    }

    private void findViews() {
        ed_name = findViewById(R.id.edName);
        tv_show = findViewById(R.id.tvShow);
        btn_submit = findViewById(R.id.btnSummit);
        ed_height = findViewById(R.id.edHeight);
        ed_weight = findViewById(R.id.edWeight);
        girl = findViewById(R.id.rbfemale);
        boy1 = findViewById(R.id.rbmale);
        demo = findViewById(R.id.TVdemo);

        apple = findViewById(R.id.cbapple);
        kiwi = findViewById(R.id.cbapple);


    }

    public void goResult(View view) {

        String name = ed_name.getText().toString();
        double height =  Double.parseDouble(ed_height.getText().toString());
        double weight =  Double.parseDouble(ed_weight.getText().toString());
        Intent intent = new Intent(this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("keyname",name);
        bundle.putDouble("keyheight",height);
        bundle.putDouble("keyweight",weight);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}