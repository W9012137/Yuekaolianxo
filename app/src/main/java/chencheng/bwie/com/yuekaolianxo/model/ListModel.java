package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.ProductsBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/1/17.
 */

public class ListModel implements IListModel {
    @Override
    public void ShowList(String pscid, final NetListenter<ProductsBean> netListenter) {
        Flowable flowable= RetrofitUtils.getServerApi().products(pscid);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ProductsBean>() {

                    @Override
                    public void accept(ProductsBean productsBean) throws Exception {
                        netListenter.onSccess(productsBean);
                    }
                });
    }
}
