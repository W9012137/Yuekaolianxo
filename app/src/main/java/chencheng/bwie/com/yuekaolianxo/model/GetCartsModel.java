package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.GetCartsBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/1/18.
 */

public class GetCartsModel implements IGetCartsModel {
    @Override
    public void getCarts(final NetListenter<GetCartsBean> netListenter, String uid) {
        Flowable flowable= RetrofitUtils.getServerApi().getCart(uid);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetCartsBean>() {

                    @Override
                    public void accept(GetCartsBean getCartsBean) throws Exception {
                        netListenter.onSccess(getCartsBean);
                    }


                });
    }
}
