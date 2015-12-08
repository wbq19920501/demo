package com.wbq.mvp.biz;

import com.wbq.mvp.bean.User;

/**
 * Created by JokeepDeveloperAD on 2015-11-11.
 */
public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();

}
