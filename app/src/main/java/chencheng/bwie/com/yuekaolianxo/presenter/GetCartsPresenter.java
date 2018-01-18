package chencheng.bwie.com.yuekaolianxo.presenter;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.yuekaolianxo.Bean.GetCartsBean;
import chencheng.bwie.com.yuekaolianxo.model.GetCartsModel;
import chencheng.bwie.com.yuekaolianxo.model.IGetCartsModel;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.view.IGouwucheActivity;

/**
 * Created by dell on 2018/1/18.
 */

public class GetCartsPresenter {
    private IGouwucheActivity iGouwucheActivity;
    private final IGetCartsModel iGetCartsModel;

    public GetCartsPresenter(IGouwucheActivity iGouwucheActivity) {
        this.iGouwucheActivity = iGouwucheActivity;
        iGetCartsModel = new GetCartsModel();
    }
    public void GetCart(final String uid){
        iGetCartsModel.getCarts(new NetListenter<GetCartsBean>() {
            @Override
            public void onSccess(GetCartsBean getCartsBean) {
                final List<GetCartsBean.DataBean> data = getCartsBean.getData();
                List<List<GetCartsBean.DataBean.ListBean>> child=new ArrayList<>();
                for (int i=0;i<data.size();i++){
                    final List<GetCartsBean.DataBean.ListBean> list = data.get(i).getList();
                    child.add(list);
                }
                iGouwucheActivity.shouCarts(data,child,uid);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        },uid);
    }
}
