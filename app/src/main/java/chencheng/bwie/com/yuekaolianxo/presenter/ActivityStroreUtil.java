package chencheng.bwie.com.yuekaolianxo.presenter;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dell on 2018/1/17.
 */

public class ActivityStroreUtil {
    private static List<Activity> list = new LinkedList<>();


    /**
     * 用集合保存所有开启的Activity
     *
     * @param ac
     */
    public static void addActivity(Activity ac) {
        list.add(ac);
    }


    /**
     * 关闭已经开启的Activity
     */
    public void finishAll() {
        for (Activity ac : list) {
            if (ac != null)
                ac.finish();


        }
    }
}
