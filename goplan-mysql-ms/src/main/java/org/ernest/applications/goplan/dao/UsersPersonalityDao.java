package org.ernest.applications.goplan.dao;


import org.ernest.applications.goplan.ct.UserPersonalityDto;

public interface UsersPersonalityDao {

    long createUsersPersonality(long userId);
    UserPersonalityDto retrieveUsersPersonality(long rowId);
    void deleteUsersPersonality(long rowId);
    void updateUsersPersonality(int userId, UserPersonalityDto userPersonalityDto);
}
