package cn.oddcloud.www.Web.service;

/**
 * Created by vog1g on 2017/5/10.
 */
public interface UserService {
    int UserNameIsExsit(String name);
    int UserCheckAllMessage(String name,String passworld);

}
