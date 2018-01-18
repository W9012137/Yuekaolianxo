package chencheng.bwie.com.yuekaolianxo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import chencheng.bwie.com.yuekaolianxo.R;
import chencheng.bwie.com.yuekaolianxo.presenter.RegisterPresenter;

/**
 * Created by dell on 2018/1/17.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,IRegisterActivity {
    private ImageView mImageView;
    /**
     * 请输入用户名
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPwd;
    /**
     * 确认请输入密码
     */
    private EditText mPwd2;
    /**
     * 请填写邮编
     */
    private EditText mYoubian;
    /**
     * 注册
     */
    private Button mButton;
 RegisterPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        presenter=new RegisterPresenter(this);
        initView();
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setOnClickListener(this);
        mPhone = (EditText) findViewById(R.id.phone);
        mPwd = (EditText) findViewById(R.id.pwd);
        mPwd2 = (EditText) findViewById(R.id.pwd2);
        mYoubian = (EditText) findViewById(R.id.youbian);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imageView:
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                break;
            case R.id.button:
                presenter.register();
                break;
        }
    }

    @Override
    public String getAccount() {
        return mPhone.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mPwd.getText().toString().trim();
    }

    @Override
    public void finishAc() {
        finish();
    }

    @Override
    public void show(String str) {
        Toast.makeText(RegisterActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}
