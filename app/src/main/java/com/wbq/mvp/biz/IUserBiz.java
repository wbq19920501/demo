package com.wbq.mvp.biz;

/**
 * Created by JokeepDeveloperAD on 2015-11-11.
 */
public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
