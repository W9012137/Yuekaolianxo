package chencheng.bwie.com.yuekaolianxo.presenter;

import chencheng.bwie.com.yuekaolianxo.Bean.ProductsBean;
import chencheng.bwie.com.yuekaolianxo.model.IListModel;
import chencheng.bwie.com.yuekaolianxo.model.ListModel;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.view.IListActivity;

/**
 * Created by dell on 2018/1/17.
 */

public class ListPresenter {
    private IListActivity iListActivity;
    private final IListModel iListModel;

    public ListPresenter(IListActivity iListActivity){
        this.iListActivity=iListActivity;
        iListModel = new ListModel();
    }
    public void  showlist(final String pscid){
        iListModel.ShowList(pscid, new NetListenter<ProductsBean>() {
            @Override
            public void onSccess(ProductsBean productsBean) {
                iListActivity.showList(productsBean,pscid);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
