package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.Register;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/1/17.
 */

public class RegisterModel implements IRegidterModel {
    @Override
    public void regidter(String phone, String pwd, final NetListenter<Register> netListenter) {
        Flowable flowable= RetrofitUtils.getServerApi().regsinter(phone,pwd);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Register>() {

                    @Override
                    public void accept(Register register) throws Exception {
                        netListenter.onSccess(register);
                    }


                });
    }
}
