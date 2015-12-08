package com.wbq.mvp.view;

import com.wbq.mvp.bean.User;

/**
 * Created by JokeepDeveloperAD on 2015-11-11.
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
