package xpfei.myapp.model;

/**
 * Description: banner的实体类
 * Author: xpfei
 * Date:   2017/08/21
 */
public class BannerInfo {
    private String code;
    private String randpic;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRandpic() {
        return randpic;
    }

    public void setRandpic(String randpic) {
        this.randpic = randpic;
    }
}
