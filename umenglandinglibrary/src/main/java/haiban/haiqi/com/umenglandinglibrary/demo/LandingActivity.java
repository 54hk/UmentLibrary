package haiban.haiqi.com.umenglandinglibrary.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import haiban.haiqi.com.umenglandinglibrary.Landing;
import haiban.haiqi.com.umenglandinglibrary.callback.AuthCallBack;
import haiban.haiqi.com.umenglandinglibrary.callback.ShareCallBack;

/**
 * 这是一个单独的DEMO
 */
public class LandingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        TODO 这是简单登陆的模型
        Landing.getAuth(this, SHARE_MEDIA.WEIXIN, new AuthCallBack() {
            @Override
            public void onComplete(Map<String, String> map) {

            }

            @Override
            public void onError(Throwable e) {

            }
        });


//        TODO 这是分享 的模型
        Landing.getShareWeb(this ,
                "" , "https://www.duba.com/?f=liebao"
                ,"这个是搜狗地址"
                ,"地址"
                ,SHARE_MEDIA.QQ
                ,new ShareCallBack() {
                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                        Toast.makeText(LandingActivity.this, "成功", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        Toast.makeText(LandingActivity.this, "失败", Toast.LENGTH_LONG).show();
                    }
                } );

    }

    //TODO 这个要在每一个Activity授权的时候要加
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
