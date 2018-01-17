package com.bwie.fanmeihua.ds2yuekaolianxi.reg.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.fanmeihua.ds2yuekaolianxi.R;
import com.bwie.fanmeihua.ds2yuekaolianxi.login.view.LoginActivity;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.model.bean.RegBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.presenter.RegPresenter;

public class RegActivity extends AppCompatActivity implements View.OnClickListener,IRegView{

    /**
     * 请输入用户名
     */
    private EditText mRegName;
    /**
     * 请输入密码
     */
    private EditText mRegPwd;
    /**
     * 确认输入密码
     */
    private EditText mRegRepwd;
    /**
     * 请输入邮箱
     */
    private EditText mRegEmail;
    /**
     * 注册
     */
    private Button mRegBtn;
    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
        regPresenter = new RegPresenter(this);
    }

    private void initView() {
        mRegName = (EditText) findViewById(R.id.reg_name);
        mRegPwd = (EditText) findViewById(R.id.reg_pwd);
        mRegRepwd = (EditText) findViewById(R.id.reg_repwd);
        mRegEmail = (EditText) findViewById(R.id.reg_email);
        mRegBtn = (Button) findViewById(R.id.reg_btn);
        mRegBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.reg_btn:
                regPresenter.getRegUrl(mRegName.getText().toString().trim(),mRegPwd.getText().toString().trim());
                break;
        }
    }

    @Override
    public void getRegSuccess(RegBean regBean) {
        Intent intent = new Intent(RegActivity.this, LoginActivity.class);
        startActivity(intent);
        Toast.makeText(RegActivity.this, regBean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getRegFail() {
        if (mRegName.getText().toString()==""||mRegName.getText().toString().equals("")){
            Toast.makeText(RegActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
        }else if(mRegPwd.getText().toString()==""||mRegPwd.getText().toString().equals("")&&mRegPwd.getText().toString().length()<6){
            Toast.makeText(RegActivity.this,"密码长度不能小于6位",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(RegActivity.this,"失败",Toast.LENGTH_SHORT).show();
        }

    }
}
