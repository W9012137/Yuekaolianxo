package chencheng.bwie.com.yuekaolianxo.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.yuekaolianxo.Adapter.ViewPagerAdapter;
import chencheng.bwie.com.yuekaolianxo.R;
import chencheng.bwie.com.yuekaolianxo.presenter.AddCartPresenter;
import chencheng.bwie.com.yuekaolianxo.view.fragment.Fram_one;
import chencheng.bwie.com.yuekaolianxo.view.fragment.Fram_three;
import chencheng.bwie.com.yuekaolianxo.view.fragment.Fram_two;

/**
 * Created by dell on 2018/1/17.
 */

public class DetailActivity extends AppCompatActivity implements IDetailActivity, View.OnClickListener {


    private ImageView mIvBack;
    private RadioButton mRbGoods;
    private RadioButton mRbDetails;
    private RadioButton mRbAppraise;
    private RadioGroup mRg;
    private ImageView mIvShare;
    private ImageView mIvMsg;
    private ViewPager mVp;
    private LinearLayout mLlSupplier;
    private LinearLayout mLlShop;
    private LinearLayout mLlAttention;
    private LinearLayout mLlCard;
    /**
     * 加入购物车
     */
    private TextView mTvAddCard;
    private String pid;
AddCartPresenter addCartPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        initView();
        //接收pid
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        getSharedPreferences("user", Context.MODE_PRIVATE).edit().putString("pid",pid).commit();
        Log.e("ProductDetailsActivity","pid:"+pid);
        addCartPresenter = new AddCartPresenter(this);
        //给viewPager填充内容
        final Fram_one fram_one = new Fram_one();
        final Fram_two fram_two = new Fram_two();
        final Fram_three fram_three = new Fram_three();
        List<Fragment> list=new ArrayList<>();
        list.add(fram_one);
        list.add(fram_three);
        list.add(fram_two);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        mVp.setAdapter(viewPagerAdapter);
        //传pid
        Bundle bundle = new Bundle();
        bundle.putString("pid", pid);
        fram_one.setArguments(bundle);

    }


    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.ivBack);
        mRbGoods = (RadioButton) findViewById(R.id.rbGoods);
        mRbDetails = (RadioButton) findViewById(R.id.rbDetails);
        mRbAppraise = (RadioButton) findViewById(R.id.rbAppraise);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mIvShare = (ImageView) findViewById(R.id.ivShare);
        mIvMsg = (ImageView) findViewById(R.id.ivMsg);
        mVp = (ViewPager) findViewById(R.id.vp);
        mLlSupplier = (LinearLayout) findViewById(R.id.llSupplier);
        mLlShop = (LinearLayout) findViewById(R.id.llShop);
        mLlAttention = (LinearLayout) findViewById(R.id.llAttention);
        mLlCard = (LinearLayout) findViewById(R.id.llCard);
        mLlCard.setOnClickListener(this);
        mTvAddCard = (TextView) findViewById(R.id.tvAddCard);
        mTvAddCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.llCard:
                startActivity(new Intent(DetailActivity.this,GouWoche.class));
                break;
            case R.id.tvAddCard:
                SharedPreferences sp = getSharedPreferences("user", Context.MODE_PRIVATE);
                addCartPresenter.AddCart(pid,sp.getString("uid","1"));
                break;
        }
    }
    @Override
    public void showdeta(String string) {
        Toast.makeText(DetailActivity.this, string, Toast.LENGTH_SHORT).show();
    }

}
