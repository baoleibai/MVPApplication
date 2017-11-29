package android.letv.com.mvpapplication

/**
 * Created by bbai on 29/11/2017.
 */
class LoginHttp private constructor() {
    companion object {
        @JvmStatic
        @Volatile
        private var sLoginHttp : LoginHttp? = null

        @JvmStatic
        fun getInstance(): LoginHttp {
            if (sLoginHttp == null) {
                synchronized(LoginHttp.javaClass) {
                    sLoginHttp = LoginHttp()
                }
            }
            return sLoginHttp as LoginHttp
        }
    }

    fun doLogin(name:String, pass:String): Boolean {
        return (name.equals("aaa") && pass.equals("bbb"))
    }
}