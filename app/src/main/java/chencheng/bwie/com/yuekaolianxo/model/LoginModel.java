package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.LogBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/1/17.
 */

public class LoginModel implements ILoginModel {
    @Override
    public void login(String phone, String pwd, final NetListenter<LogBean> netListenter) {
        Flowable flowable= RetrofitUtils.getServerApi().login(phone,pwd);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LogBean>() {

                    @Override
                    public void accept(LogBean logBean) throws Exception {
                        netListenter.onSccess(logBean);
                    }


                });
    }
}
