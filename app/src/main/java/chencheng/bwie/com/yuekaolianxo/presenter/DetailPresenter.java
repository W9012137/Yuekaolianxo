package chencheng.bwie.com.yuekaolianxo.presenter;

import chencheng.bwie.com.yuekaolianxo.Bean.DetailBean;
import chencheng.bwie.com.yuekaolianxo.model.DetailModel;
import chencheng.bwie.com.yuekaolianxo.model.IDetailModel;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.view.fragment.Fram_one;
import chencheng.bwie.com.yuekaolianxo.view.fragment.IFragment_one;

/**
 * Created by dell on 2018/1/17.
 */

public class DetailPresenter {
    private IFragment_one fram_one;
    private final IDetailModel iDetailModel;

    public DetailPresenter (Fram_one fram_one){
        this.fram_one=fram_one;
        iDetailModel = new DetailModel();
    }
    public void showdeta(final String pid){
    iDetailModel.showdetail(pid, new NetListenter<DetailBean>() {
        @Override
        public void onSccess(DetailBean detailBean) {
            fram_one.show(detailBean);
        }

        @Override
        public void onFailuer(Exception e) {

        }
    });
    }
 }
