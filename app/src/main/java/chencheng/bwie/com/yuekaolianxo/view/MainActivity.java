package chencheng.bwie.com.yuekaolianxo.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import chencheng.bwie.com.yuekaolianxo.Bean.LogBean;
import chencheng.bwie.com.yuekaolianxo.R;
import chencheng.bwie.com.yuekaolianxo.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMainActivity {

    private ImageView mImageView2;
    /**
     * 手机号/会员号/邮箱
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPwd;
    /**
     * 忘记密码
     */
    private TextView mTextView;
    /**
     * 新用户注册
     */
    private TextView mTextView2;
    /**
     * 登录
     */
    private Button mButton;
    private ImageView mImageView3;
    /**
     * QQ登录
     */
    private TextView mTextView3;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        initView();
    }

    private void initView() {
        mImageView2 = (ImageView) findViewById(R.id.imageView2);
        mPhone = (EditText) findViewById(R.id.phone);
        mPwd = (EditText) findViewById(R.id.pwd);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mImageView3 = (ImageView) findViewById(R.id.imageView3);
        mImageView3.setOnClickListener(this);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
             presenter.login();
                break;
            case R.id.imageView3:
                break;
            case R.id.textView2:
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
    public void show(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toRegisterAc() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void toClassAc(LogBean logBean) {
        if (logBean.getCode().equals("0")) {
            SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("uid", logBean.getData().getUid()+"");
            editor.commit();
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        }
    }
}
