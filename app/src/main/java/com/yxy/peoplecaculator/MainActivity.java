package com.yxy.peoplecaculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private EditText et_name;
    private RadioGroup rg_sex;
    private Button btn_caculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        et_name = (EditText) findViewById(R.id.name_id);
        rg_sex = (RadioGroup) findViewById(R.id.rg_group);
        btn_caculate = (Button) findViewById(R.id.caculate_id);
        btn_caculate.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String sex = null;
        String name = et_name.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(mContext,"请输入姓名",Toast.LENGTH_LONG).show();
            return;
        }
        int checkedRadioButton = rg_sex.getCheckedRadioButtonId();
        
        switch (checkedRadioButton){
            case R.id.rd_male:
                sex = "男";
                break;
            case R.id.rd_famale:
                sex = "女";
                break;
            case R.id.rd_other:
                sex = "其他";
                break;
        }

        if( sex == null){
            Toast.makeText(mContext,"请选择性别",Toast.LENGTH_LONG).show();
            return;
        }

        //跳转页面：
        Intent intent = new Intent(mContext,ResultActivity.class);
        //Intent的实现原理是通过Bundle,Bundle的实现是通过HashMap
        intent.putExtra("name",name);
        intent.putExtra("sex",sex);
        startActivity(intent);
    }
}
