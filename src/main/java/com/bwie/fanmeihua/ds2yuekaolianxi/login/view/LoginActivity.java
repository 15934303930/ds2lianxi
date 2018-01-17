package com.bwie.fanmeihua.ds2yuekaolianxi.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.fanmeihua.ds2yuekaolianxi.product.view.MainActivity;
import com.bwie.fanmeihua.ds2yuekaolianxi.login.model.bean.LoginBean;
import com.bwie.fanmeihua.ds2yuekaolianxi.R;
import com.bwie.fanmeihua.ds2yuekaolianxi.login.presenter.LoginPresenter;
import com.bwie.fanmeihua.ds2yuekaolianxi.reg.view.RegActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    /**
     * 手机号/会员号/邮箱
     */
    private EditText mLoginName;
    /**
     * 请输入密码
     */
    private EditText mLoginPwd;
    /**
     * 忘记密码
     */
    private TextView mTextView;
    /**
     * 新用户注册
     */
    private TextView mLoginReg;
    /**
     * 登录
     */
    private Button mLoginBtn;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void loginSuccess(LoginBean loginBean) {
        Toast.makeText(LoginActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFail() {
        Toast.makeText(LoginActivity.this,"失败",Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mLoginName = (EditText) findViewById(R.id.login_name);
        mLoginPwd = (EditText) findViewById(R.id.login_pwd);
        mTextView = (TextView) findViewById(R.id.textView);
        mLoginReg = (TextView) findViewById(R.id.login_reg);
        mLoginReg.setOnClickListener(this);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_btn:
                String mobile = mLoginName.getText().toString().trim();
                String password = mLoginPwd.getText().toString().trim();
                loginPresenter.getLoginUrl(mobile,password);
                break;
            case R.id.login_reg:
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
        }
    }
}
