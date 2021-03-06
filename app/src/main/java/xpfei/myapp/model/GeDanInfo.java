package xpfei.myapp.model;

/**
 * Description: 歌单javabean
 * Author: xpfei
 * Date:   2017/08/24
 */
public class GeDanInfo {

    private int collectnum;//收藏数量
    private int listenum;//收听数量
    private String listid;//歌单id
    private String pic_300;//图片
    private String tag;//标签
    private String title;//名称

    public int getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(int collectnum) {
        this.collectnum = collectnum;
    }

    public int getListenum() {
        return listenum;
    }

    public void setListenum(int listenum) {
        this.listenum = listenum;
    }

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public String getPic_300() {
        return pic_300;
    }

    public void setPic_300(String pic_300) {
        this.pic_300 = pic_300;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
