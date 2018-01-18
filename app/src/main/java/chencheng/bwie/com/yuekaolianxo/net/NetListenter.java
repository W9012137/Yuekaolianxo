package chencheng.bwie.com.yuekaolianxo.net;

/**
 * Created by dell on 2018/1/8.
 */

public interface NetListenter<T> {
    //成功
    public void onSccess(T t);
    //失败
    public void onFailuer(Exception e);
}
