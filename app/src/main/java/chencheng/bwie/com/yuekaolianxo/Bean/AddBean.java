package chencheng.bwie.com.yuekaolianxo.Bean;

/**
 * Created by dell on 2018/1/17.
 */

public class AddBean {

    /**
     * msg : 加购成功
     * code : 0
     */

    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AddBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
