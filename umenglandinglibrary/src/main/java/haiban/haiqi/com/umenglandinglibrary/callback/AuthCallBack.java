package haiban.haiqi.com.umenglandinglibrary.callback;

import java.util.Map;

/**
 * Created by 54hk on 2017/12/3.
 */

public interface AuthCallBack {
    void onComplete(Map<String, String> map);

    void onError(Throwable e);
}
