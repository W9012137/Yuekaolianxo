package chencheng.bwie.com.yuekaolianxo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

import chencheng.bwie.com.yuekaolianxo.Adapter.EvAdapter;
import chencheng.bwie.com.yuekaolianxo.Bean.GetCartsBean;
import chencheng.bwie.com.yuekaolianxo.R;
import chencheng.bwie.com.yuekaolianxo.presenter.GetCartsPresenter;

/**
 * Created by dell on 2018/1/18.
 */

public class GouWoche extends AppCompatActivity implements IGouwucheActivity{
    private static TextView mTvTotal;
    private static TextView mTvCount;
    private static CheckBox mCb;
    private ExpandableListView mElv;
    EvAdapter elvAdapter;

    /**
     * 全选
     */

    /**
     * 合计:
     */

    /**
     * 去结算(0)
     */

GetCartsPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gouwuche);
        initView();
        presenter=new GetCartsPresenter(this);
        presenter.GetCart("11794");
    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCb = (CheckBox) findViewById(R.id.cb);
        mTvTotal = (TextView) findViewById(R.id.tvTotal);
        mTvCount = (TextView) findViewById(R.id.tvCount);
       /* mTvCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createOrderPresenter.CreateOrder();
                Intent intent = new Intent(GouWoche.this, OrderActivity.class);
                startActivity(intent);
            }
        });*/
    }
    public static void setPriceAndCount(PriceAndCount priceAndCount) {
        mTvTotal.setText("合计：" + priceAndCount.getPrice());
        mTvCount.setText("去结算(" + priceAndCount.getCount() + ")");


    }
    public static void setAllChecked(boolean bool) {
        mCb.setChecked(bool);
    }
    @Override
    public void shouCarts(List<GetCartsBean.DataBean> group, List<List<GetCartsBean.DataBean.ListBean>> child,String uid) {

            elvAdapter = new EvAdapter(GouWoche.this, group, child);
            mElv.setAdapter(elvAdapter);
            for (int i = 0; i < group.size(); i++) {
                mElv.expandGroup(i);
            }
    }
}
