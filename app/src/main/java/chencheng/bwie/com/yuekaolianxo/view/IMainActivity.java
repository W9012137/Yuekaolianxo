package chencheng.bwie.com.yuekaolianxo.view;

import chencheng.bwie.com.yuekaolianxo.Bean.LogBean;

/**
 * Created by dell on 2018/1/17.
 */

public interface IMainActivity {
    public String getAccount();


    public String getPwd();


    public void show(String str);


    public void toRegisterAc();


    public void toClassAc(LogBean bean);
}
