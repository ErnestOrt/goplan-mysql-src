package org.ernest.applications.goplan.dao.impl;

import org.ernest.applications.goplan.ct.UserMainInfoDto;
import org.ernest.applications.goplan.dao.UsersMainInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UsersMainInfoDaoImpl implements UsersMainInfoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long createUserMainInfo(String userName, String facebookId) {

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", userName);
        namedParameters.addValue("facebookId", facebookId);

        new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource()).update("INSERT INTO users_main_info (NAME, FACEBOOK_ID) VALUES (:name, :facebookId)",
                namedParameters,
                generatedKeyHolder);

        return generatedKeyHolder.getKey().longValue();
    }

    @Override
    public Long retriveUserId(String facebookId) {
        return jdbcTemplate.query("SELECT pk_id FROM users_main_info WHERE facebook_id = ?",
                new Object[] { facebookId },
                (rs, rowNum) -> (rs.getLong("pk_id"))).stream().findFirst().orElse(null);
    }

    @Override
    public UserMainInfoDto retrieveUserMainInfo(long userId) {
        return jdbcTemplate.query("SELECT name, description, facebook_id FROM users_main_info WHERE pk_id = ?",
                                  new Object[] { userId },
                                  (rs, rowNum) -> (new UserMainInfoDto(userId,
                                                                       rs.getString("name"),
                                                                       rs.getString("description"),
                                                                       rs.getString("facebook_id")))).stream().findFirst().orElse(null);
    }

    @Override
    public void updateUserMainInfoDescription(long userId, String description) {
        jdbcTemplate.update("UPDATE users_main_info SET DESCRIPTION=? WHERE PK_ID=?", description, userId);
    }

    @Override
    public void deleteUserMainInfo(long userId) {
        jdbcTemplate.update("DELETE FROM users_main_info WHERE `PK_ID`= ? ", userId);
    }


}


