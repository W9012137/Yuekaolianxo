package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.GetCartsBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;

/**
 * Created by dell on 2018/1/18.
 */

public interface IGetCartsModel {
    public void getCarts(NetListenter<GetCartsBean> netListenter ,String uid);
}
