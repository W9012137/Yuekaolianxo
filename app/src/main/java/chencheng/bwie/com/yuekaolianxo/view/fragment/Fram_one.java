package chencheng.bwie.com.yuekaolianxo.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.yuekaolianxo.Bean.DetailBean;
import chencheng.bwie.com.yuekaolianxo.R;
import chencheng.bwie.com.yuekaolianxo.presenter.DetailPresenter;
import chencheng.bwie.com.yuekaolianxo.view.GlideImageLoader;

/**
 * Created by dell on 2018/1/18.
 */

public class Fram_one extends Fragment implements IFragment_one {
    private List<String> list = new ArrayList<>();
    private View view;
    private Banner mBanner;
    /**
     * 年后
     */
    private TextView mTvTitle;
    /**
     * 年后
     */
    private TextView mTvSubhead;
    DetailPresenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.deta_one, null);
        Bundle bundle = getArguments();
        String pid = bundle.getString("pid");
        presenter=new DetailPresenter(this);
        initView(view);
        presenter.showdeta(pid);
        return view;
    }

    @Override
    public void show(DetailBean detailBean) {
        String icon[] = detailBean.getData().getImages().split("\\|");
        for(int i=0;i<icon.length;i++)
        {
            list.add(icon[i]);
        }
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setBannerAnimation(Transformer.DepthPage);
        mBanner.setImages(list);
        mBanner.setDelayTime(5000000);
//启动banner
        mBanner.start();
        mTvTitle.setText(detailBean.getData().getTitle());
        mTvSubhead.setText(detailBean.getData().getSubhead());
    }

    private void initView(View view) {
        mBanner = (Banner) view.findViewById(R.id.banner);
        mTvTitle = (TextView) view.findViewById(R.id.tvTitle);
        mTvSubhead = (TextView) view.findViewById(R.id.tvSubhead);
    }
}
