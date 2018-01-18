package chencheng.bwie.com.yuekaolianxo.model;


import chencheng.bwie.com.yuekaolianxo.Bean.AddBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.net.RetrofitUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/1/17.
 */

public class AddModel implements IAddModel {
    @Override
    public void addgw(String uid, String pid, final NetListenter<AddBean> netListenter) {
       RetrofitUtils.getServerApi().addCart(pid,uid)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddBean>() {

                    @Override
                    public void accept(AddBean addBean) throws Exception {
                        netListenter.onSccess(addBean);
                    }
                });
    }
}
/*
new Consumer<AddBean>() {

@Override
public void accept(AddBean addBean) throws Exception {
        netListenter.onSccess(addBean);
        }
        }*/
