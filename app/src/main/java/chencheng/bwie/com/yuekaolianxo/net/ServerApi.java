package chencheng.bwie.com.yuekaolianxo.net;

import chencheng.bwie.com.yuekaolianxo.Bean.AddBean;
import chencheng.bwie.com.yuekaolianxo.Bean.DetailBean;
import chencheng.bwie.com.yuekaolianxo.Bean.LogBean;
import chencheng.bwie.com.yuekaolianxo.Bean.ProductsBean;
import chencheng.bwie.com.yuekaolianxo.Bean.Register;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dell on 2018/1/8.
 */

public interface ServerApi {
    //登录
    @GET("user/login")
    Flowable<LogBean> login(@Query("mobile") String phone, @Query("password") String pwd);
    //注册
    @GET("user/reg")
    Flowable<Register> regsinter(@Query("mobile") String phone, @Query("password") String pwd);
    //商品展示
    @GET("product/getProducts")
    Flowable<ProductsBean> products(@Query("pscid") String pscid );
    //详情页面
    @GET("product/getProductDetail")
    Flowable<DetailBean> detail(@Query("pid")String pid);
    //加入购物车
    @GET("product/addCart")
    Flowable<AddBean> addCart(@Query("pid")String pid,@Query("uid") String uid);
    //查询购物车
    @GET("product/getCarts")
    Flowable<AddBean> getCart(@Query("uid") String uid);
}
