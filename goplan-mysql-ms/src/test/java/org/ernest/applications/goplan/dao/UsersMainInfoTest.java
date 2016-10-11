package org.ernest.applications.goplan.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersMainInfoTest {

    @Autowired
    UsersMainInfoDao usersMainInfoDao;

    @Test
    public void CRUDUsersMainInfo() {

        long userId = usersMainInfoDao.createUserMainInfo("Ernest", "faceId");
        Assert.assertTrue(usersMainInfoDao.retrieveUserMainInfo(userId).getName().equals("Ernest"));

        Assert.assertTrue(usersMainInfoDao.retriveUserId("faceId") == userId);

        usersMainInfoDao.updateUserMainInfoDescription(userId, "description");
        Assert.assertTrue(usersMainInfoDao.retrieveUserMainInfo(userId).getDescription().equals("description"));

        usersMainInfoDao.deleteUserMainInfo(userId);
        Assert.assertTrue(usersMainInfoDao.retrieveUserMainInfo(userId) == null);
    }
}
