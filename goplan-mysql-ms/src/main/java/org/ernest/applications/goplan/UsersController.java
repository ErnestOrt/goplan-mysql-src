package org.ernest.applications.goplan;

import org.ernest.applications.goplan.ct.CreateUserInput;
import org.ernest.applications.goplan.dao.UsersMainInfoDao;
import org.ernest.applications.goplan.dao.UsersPersonalityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    UsersMainInfoDao usersMainInfoDao;

    @Autowired
    UsersPersonalityDao usersPersonalityDao;

    @RequestMapping("user/create")
    public long createUser(@RequestBody CreateUserInput createUserInput) {

        long userId = usersMainInfoDao.createUserMainInfo(createUserInput.getName(), createUserInput.getFacebookId());
        usersPersonalityDao.createUsersPersonality(userId);

        return userId;
    }
}
