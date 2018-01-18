package chencheng.bwie.com.yuekaolianxo.view;

import java.util.List;

import chencheng.bwie.com.yuekaolianxo.Bean.GetCartsBean;

/**
 * Created by dell on 2018/1/18.
 */

public interface IGouwucheActivity {
    public void shouCarts(List<GetCartsBean.DataBean> group,List<List<GetCartsBean.DataBean.ListBean>> child,String uid);
}
