package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.DetailBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;

/**
 * Created by dell on 2018/1/17.
 */

public interface IDetailModel {
    public void showdetail(String pid, NetListenter<DetailBean> netListenter);
}
