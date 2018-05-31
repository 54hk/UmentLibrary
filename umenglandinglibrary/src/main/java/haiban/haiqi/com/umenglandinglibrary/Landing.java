package haiban.haiqi.com.umenglandinglibrary;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.Map;

import haiban.haiqi.com.umenglandinglibrary.callback.AuthCallBack;
import haiban.haiqi.com.umenglandinglibrary.callback.ShareCallBack;

/**
 * Created by 54hk on 2017/12/3.
 */
public class Landing {

    //   登陆
    public static void getAuth(final Context context, SHARE_MEDIA shareMedia, final AuthCallBack authCallBack) {

        UMShareAPI.get(context).getPlatformInfo((Activity) context, shareMedia, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Toast.makeText(context, "开始", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                authCallBack.onComplete(map);
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                authCallBack.onError(throwable);
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
    }

    //    分享
    public static void getShareWeb(final Context context
            , String thumb_img
            , String url
            , String description
            , String title
            ,SHARE_MEDIA share_media
            , final ShareCallBack shareCallBack) {
        UMImage thumb = new UMImage(context, thumb_img);
        UMWeb web = new UMWeb(url);
        web.setThumb(thumb);
        web.setDescription(description);  //描述
        web.setTitle(title);  //标题
        new ShareAction((Activity) context).withMedia(web)
                .setPlatform(share_media)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Toast.makeText(context, "开始", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                        shareCallBack.onResult(share_media);
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        shareCallBack.onError(share_media, throwable);
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {

                    }
                }).share();
    }


}
