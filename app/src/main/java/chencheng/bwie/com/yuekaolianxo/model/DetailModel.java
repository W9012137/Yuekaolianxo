package chencheng.bwie.com.yuekaolianxo.model;

import chencheng.bwie.com.yuekaolianxo.Bean.DetailBean;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/1/17.
 */

public class DetailModel implements IDetailModel {
    @Override
    public void showdetail(String pid, final NetListenter<DetailBean> netListenter) {
        Flowable flowable= RetrofitUtils.getServerApi().detail(pid);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<DetailBean>() {

                    @Override
                    public void accept(DetailBean detailBean) throws Exception {
                        netListenter.onSccess(detailBean);
                    }

                });
    }
}
