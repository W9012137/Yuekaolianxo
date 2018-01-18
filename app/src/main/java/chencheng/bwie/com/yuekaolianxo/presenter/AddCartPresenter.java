package chencheng.bwie.com.yuekaolianxo.presenter;

import android.util.Log;

import chencheng.bwie.com.yuekaolianxo.Bean.AddBean;
import chencheng.bwie.com.yuekaolianxo.model.AddModel;
import chencheng.bwie.com.yuekaolianxo.model.IAddModel;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.view.IDetailActivity;

/**
 * Created by dell on 2018/1/18.
 */

public class AddCartPresenter {
 private IDetailActivity iDetailActivity;
    private final IAddModel iAddModel;

    public AddCartPresenter(IDetailActivity iDetailActivity) {
        this.iDetailActivity = iDetailActivity;
        iAddModel = new AddModel();
    }
    public void AddCart(String pid,String uid){
    iAddModel.addgw(pid, uid, new NetListenter<AddBean>() {
        @Override
        public void onSccess(AddBean addBean) {
            iDetailActivity.showdeta(addBean.getMsg());
        }

        @Override
        public void onFailuer(Exception e) {
            Log.i("iol",e+"");
        }
    });
    }
}
