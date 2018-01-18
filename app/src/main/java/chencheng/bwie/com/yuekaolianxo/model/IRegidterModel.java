package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.Register;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;

/**
 * Created by dell on 2018/1/17.
 */

public interface IRegidterModel {
    public void regidter(String phone, String pwd, NetListenter<Register> netListenter);
}
