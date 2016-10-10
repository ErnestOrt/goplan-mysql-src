package org.ernest.applications.goplan.dao;


import org.ernest.applications.goplan.ct.UserMainInfoDto;

public interface UsersMainInfoDao {

    long createUserMainInfo(String userName, String facebookId);
    UserMainInfoDto retrieveUserMainInfo(long userId);
    void updateUserMainInfoDescription(long userId, String description);
    void deleteUserMainInfo(long userId);
}
