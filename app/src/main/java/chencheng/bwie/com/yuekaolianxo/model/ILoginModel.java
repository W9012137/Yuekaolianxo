package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.LogBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;

/**
 * Created by dell on 2018/1/17.
 */

public interface ILoginModel {
    public void login(String phone, String pwd, NetListenter<LogBean> netListenter);
 }
