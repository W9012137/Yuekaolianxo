package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.AddBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;

/**
 * Created by dell on 2018/1/17.
 */

public interface IAddModel {
    public void addgw(String uid, String pid, NetListenter<AddBean> netListenter);
}
