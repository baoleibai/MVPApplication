package android.letv.com.mvpapplication.data

import android.letv.com.mvpapplication.LoginHttp

/**
 * Created by bbai on 29/11/2017.
 */
class DataRepository : IDataSource {

    private var loginHttp: LoginHttp ?= null
    private constructor() {
        loginHttp = LoginHttp.getInstance()
    }

    companion object {
        @JvmStatic
        @Volatile
        private var sInstance : DataRepository ? = null

        @JvmStatic
        fun getInstance():DataRepository {
            if (sInstance == null) {
                synchronized(DataRepository.javaClass) {
                    sInstance = DataRepository()
                }
            }
            return sInstance as DataRepository
        }
    }

    override fun doLogin(name:String, pass:String, callback: IDataSource.LoginCallback) {
        if (loginHttp!!.doLogin(name, pass)) {
            callback.onLoginComplete()
        } else {
            callback.onLoginFailed()
        }
    }
}