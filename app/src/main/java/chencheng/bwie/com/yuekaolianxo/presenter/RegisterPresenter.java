package chencheng.bwie.com.yuekaolianxo.presenter;

import android.text.TextUtils;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chencheng.bwie.com.yuekaolianxo.Bean.Register;
import chencheng.bwie.com.yuekaolianxo.model.IRegidterModel;
import chencheng.bwie.com.yuekaolianxo.model.RegisterModel;
import chencheng.bwie.com.yuekaolianxo.net.NetListenter;
import chencheng.bwie.com.yuekaolianxo.view.IRegisterActivity;

/**
 * Created by dell on 2018/1/17.
 */

public class RegisterPresenter {
    private IRegisterActivity iRegisterActivity;
    private final IRegidterModel iRegidterModel;

    public RegisterPresenter(IRegisterActivity iRegisterActivity){
        this.iRegisterActivity=iRegisterActivity;
        iRegidterModel = new RegisterModel();
    }
    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iRegisterActivity.show("请输入密码");
            return false;
        }


        if (pwd.length() != 6) {
            iRegisterActivity.show("请输入6位密码");
            return false;
        }
        return true;
    }




    /**
     * 验证手机号是否正确
     *
     * @param account
     */
    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            //给用户提示，输入的账号不能为空
            iRegisterActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iRegisterActivity.show("请输入正确的手机号");
            return false;
        }
        return true;
    }




    /*
    判断是否是手机号
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }




    public void register() {
        String account = iRegisterActivity.getAccount();
        String pwd = iRegisterActivity.getPwd();
        //判断账号密码是否正确
        if (checkAccount(account) && checkPwd(pwd)) {
            iRegidterModel.regidter(account, pwd, new NetListenter<Register>() {
                @Override
                public void onSccess(Register register) {
                    //成功以后，回到登陆界面
                    if (register.getCode().equals("1")) {
                        iRegisterActivity.show(register.getMsg());
                    } else {
                        iRegisterActivity.show(register.getMsg());
                        Log.i("AGT",register.getMsg());
                        iRegisterActivity.finishAc();

                    }
                }

                @Override
                public void onFailuer(Exception e) {

                }
            });
        }


    }
}
