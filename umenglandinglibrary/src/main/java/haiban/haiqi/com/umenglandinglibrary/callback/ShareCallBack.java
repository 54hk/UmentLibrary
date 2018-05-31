package haiban.haiqi.com.umenglandinglibrary.callback;

import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * Created by 54hk on 2017/12/3.
 */

public interface ShareCallBack {
    void onResult(SHARE_MEDIA share_media);
    void onError(SHARE_MEDIA share_media, Throwable throwable);
}
