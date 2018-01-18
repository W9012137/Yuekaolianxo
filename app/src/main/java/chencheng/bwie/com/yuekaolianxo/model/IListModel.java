package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.ProductsBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;

/**
 * Created by dell on 2018/1/17.
 */

public interface IListModel {
    public void ShowList(String pscid, NetListenter<ProductsBean> netListenter);
}
