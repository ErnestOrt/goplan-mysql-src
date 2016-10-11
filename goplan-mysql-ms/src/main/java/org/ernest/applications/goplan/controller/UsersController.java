package org.ernest.applications.goplan.controller;

import org.ernest.applications.goplan.ct.CreateUserInput;
import org.ernest.applications.goplan.ct.GetUserDetailsOutput;
import org.ernest.applications.goplan.ct.UserPersonalityDto;
import org.ernest.applications.goplan.dao.UsersMainInfoDao;
import org.ernest.applications.goplan.dao.UsersPersonalityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

        Long userId = usersMainInfoDao.retriveUserId(createUserInput.getFacebookId());

        if (userId == null) {
            userId = usersMainInfoDao.createUserMainInfo(createUserInput.getName(), createUserInput.getFacebookId());
            usersPersonalityDao.createUsersPersonality(userId);
        }

        return userId;
    }

    @RequestMapping("user/details/{userId}")
    public GetUserDetailsOutput getUserDetails(@PathVariable Long userId) {
        UserPersonalityDto userPersonalityDto = usersPersonalityDao.retrieveUsersPersonality(userId);

        return new GetUserDetailsOutput(usersMainInfoDao.retrieveUserMainInfo(userId).getDescription(),
                userPersonalityDto.getEat(), userPersonalityDto.getDrink(), userPersonalityDto.getParty(), userPersonalityDto.getSleep(),
                userPersonalityDto.getWork(), userPersonalityDto.getMature(), userPersonalityDto.getSport(), userPersonalityDto.getMovies(),
                userPersonalityDto.getSpirituality(), userPersonalityDto.getTravel(), userPersonalityDto.getFreak(), userPersonalityDto.getAnimals());
    }
}