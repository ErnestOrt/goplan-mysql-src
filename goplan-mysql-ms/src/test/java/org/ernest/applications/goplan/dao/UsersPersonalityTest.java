package org.ernest.applications.goplan.dao;


import org.ernest.applications.goplan.ct.UserPersonalityDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersPersonalityTest {

    @Autowired
    UsersPersonalityDao usersPersonalityDao;

    @Test
    public void CRUDUsersPersonality() {

        int userId = -1001;

        usersPersonalityDao.createUsersPersonality(userId);
        Assert.assertTrue(usersPersonalityDao.retrieveUsersPersonality(userId).getEat() == 0);

        usersPersonalityDao.updateUsersPersonality(userId, new UserPersonalityDto(1,0,0,0,0,0,0,0,0,0,0,0));
        Assert.assertTrue(usersPersonalityDao.retrieveUsersPersonality(userId).getEat()== 1);

        usersPersonalityDao.deleteUsersPersonality(userId);
        Assert.assertTrue(usersPersonalityDao.retrieveUsersPersonality(userId) == null);
    }
}
