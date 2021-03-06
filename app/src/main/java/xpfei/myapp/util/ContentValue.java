package xpfei.myapp.util;

/**
 * Description: 常量
 * Author: xpfei
 * Date:   2017/2/8
 */
public class ContentValue {
    public static final class NET {
        public static final int NET_SUCCESS = 0x901;
        public static final int NET_LOAD = 0x902;
        public static final int NET_FAILURE = 0x903;
        public static final int NET_EMPTY = 0x904;
        public static final int NET_MSV_SUCCESS = 0x905;
        public static final int NET_MSV_LOAD = 0x906;
        public static final int NET_MSV_FAILURE = 0x907;
        public static final int NET_MSV_EMPTY = 0x98;
    }

    public static final class IntentKey {
        public static final String IntentKeyList = "IntentKeyList";
        public static final String IntentKeySer = "IntentKeySer";
        public static final String IntentKeyStr = "IntentKeyStr";
        public static final String IntentKeyInt = "IntentKeyInt";
        public static final String IntentKeyIndex = "IntentKeyIndex";
    }

    public static final class AcacheKey {
        public static final String ACACHEkEY_VERSION = "VERSIONCODE";
        public static final String ACACHEkEY_VIEWTHEME = "VIEWTHEME";
        public static final String ACACHE_USER = "ACache_USER";
        public static final String ACACHEKEY_BANNER = "ACACHEKEY_BANNER";
        public static final String ACACHEKEY_NEWSONG = "ACACHEKEY_NEWSONG";
        public static final String ACACHEKEY_ALBUM = "ACACHEKEY_ALBUM";
    }

    //首页布局分类
    public static final class ViewType {
        public static final int ViewHeader = 1;
        public static final int ViewCategory = 2;
        public static final int ViewNewSong = 3;
        public static final int ViewAlbum = 4;

        public static final int ViewDetail = 1;
        public static final int ViewButton = 2;
        public static final int ViewList = 3;
    }


    public static final class Json {
        public static final String List = "list";
        public static final String Banner = "pic";
        public static final String Song_List = "song_list";
        public static final String SongList = "songlist";
        public static final String ErrorCode = "error_code";
        public static final String Album = "plaze_album_list";
        public static final String RM = "RM";
        public static final String Album_List = "album_list";
        public static final String AlbumList = "albumlist";
        public static final String Result = "result";
        public static final String Content = "content";
        public static final String ArtList = "artist";
        public static final String Songinfo = "songinfo";
        public static final String Bitrate = "bitrate";
        public static final String Songurl = "songurl";
        public static final String Url = "url";
        public static final int Successcode = 22000;
    }

    public static final class PlayAction {
        public static final String Play = "xpfei.music.play";
        public static final String Pause = "xpfei.music.pause";
        public static final String Last = "xpfei.music.last";
        public static final String Next = "xpfei.music.Next";
    }
}
