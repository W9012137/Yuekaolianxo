package chencheng.bwie.com.yuekaolianxo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import chencheng.bwie.com.yuekaolianxo.Adapter.ListAdapter;
import chencheng.bwie.com.yuekaolianxo.Bean.ProductsBean;
import chencheng.bwie.com.yuekaolianxo.R;
import chencheng.bwie.com.yuekaolianxo.presenter.ListPresenter;

/**
 * Created by dell on 2018/1/17.
 */

public class ListActivity extends AppCompatActivity implements IListActivity{
    private RecyclerView mRv;
    private int pscid;
    private ListPresenter presenter;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);
        Intent intent = getIntent();
        pscid = intent.getIntExtra("pscid", 1);
        presenter=new ListPresenter(this);
        presenter.showlist("1");
        initView();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
    }

    @Override
    public void showList(ProductsBean productsBean, String pscid) {
        final List<ProductsBean.DataBean> data = productsBean.getData();
        final ListAdapter listAdapter = new ListAdapter(data, ListActivity.this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(listAdapter);
       listAdapter.setOnclickSpflAdpter(new ListAdapter.OnClickfl() {
           @Override
           public void onClickxq(int position) {
               final Intent intent = new Intent(ListActivity.this, DetailActivity.class);
               intent.putExtra("pid",position);
               startActivity(intent);
           }
       });
    }
}
