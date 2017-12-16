package com.yxy.peoplecaculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private Context mContet;
    private TextView tv_name;
    private TextView tv_sex;
    private String Intent_neme;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_result = (TextView) findViewById(R.id.tv_result);
        Intent intent = getIntent();
        Intent_neme = intent.getStringExtra("name");
        tv_name.setText(Intent_neme);
        tv_sex.setText(intent.getStringExtra("sex"));

        //根据输入的姓名和性别来计算人品得分
        byte[] bytes = Intent_neme.getBytes();
        int total = 0;
        for(byte b : bytes){
           int number =  b&0xff;  //与上一个1111 1111
            total = number + total;
        }
        int score = Math.abs(total)%100;

        if(score > 90){
            tv_result.setText("您的人品非常好，您家的祖坟都冒青烟了");
        }else if(score > 70){
            tv_result.setText("您的人品还行吧");
        }else if(score > 60){
            tv_result.setText("您的人品刚及格，继续努力吧");
        }else {
            tv_result.setText("您的人品不及格");
        }
    }
}
