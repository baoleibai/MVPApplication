package android.letv.com.mvpapplication

import android.letv.com.mvpapplication.data.DataRepository
import android.letv.com.mvpapplication.data.IDataSource

/**
 * Created by bbai on 29/11/2017.
 */
class LoginPresenter : LoginContract.Presenter {

    private val mView:LoginContract.View
    private val mData:DataRepository

    constructor(view:LoginContract.View) {
        mView = view
        mData =  DataRepository.getInstance()
    }

    override fun start() {

    }

    override fun doLogin() {

        mData.doLogin(mView.name, mView.password, object : IDataSource.LoginCallback {
            override fun onLoginComplete() {
                mView.loginSuccess()
            }

            override fun onLoginFailed() {
                mView.loginFail()
            }
        })
    }
}