package android.letv.com.mvpapplication.data;

import android.support.annotation.NonNull;

/**
 * Created by bbai on 29/11/2017.
 */

public interface IDataSource {

    interface LoginCallback {

        void onLoginComplete();

        void onLoginFailed();
    }

    void doLogin(String name, String pass, @NonNull LoginCallback callback);
}
