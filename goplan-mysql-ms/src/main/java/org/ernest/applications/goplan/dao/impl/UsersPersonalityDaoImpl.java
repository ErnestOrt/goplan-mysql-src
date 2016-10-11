package org.ernest.applications.goplan.dao.impl;


import org.ernest.applications.goplan.ct.UserPersonalityDto;
import org.ernest.applications.goplan.dao.UsersPersonalityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UsersPersonalityDaoImpl implements UsersPersonalityDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public long createUsersPersonality(long userId) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("userId", userId);

        new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource()).update("INSERT INTO users_personality (FK_USER_ID) VALUES (:userId)",
                namedParameters,
                generatedKeyHolder);

        return generatedKeyHolder.getKey().longValue();
    }

    @Override
    public UserPersonalityDto retrieveUsersPersonality(long userId) {
        return jdbcTemplate.query("SELECT eat, drink, party, sleep, work, mature, sport, movies, spirituality, travel, freak, animals FROM users_personality WHERE fk_user_id = ?",
                new Object[] { userId },
                (rs, rowNum) -> (new UserPersonalityDto(rs.getInt("eat"),
                        rs.getInt("drink"),
                        rs.getInt("party"),
                        rs.getInt("sleep"),
                        rs.getInt("work"),
                        rs.getInt("mature"),
                        rs.getInt("sport"),
                        rs.getInt("movies"),
                        rs.getInt("spirituality"),
                        rs.getInt("travel"),
                        rs.getInt("freak"),
                        rs.getInt("animals")))).stream().findFirst().orElse(null);
    }

    @Override
    public void updateUsersPersonality(int userId, UserPersonalityDto userPersonalityDto) {
        jdbcTemplate.update("UPDATE users_personality SET eat=?, drink=?, party=?, sleep=?, work=?, mature=?, sport=?, movies=?, spirituality=?, travel=?, freak=?, animals=? WHERE fk_user_id=?",
                userPersonalityDto.getEat(),
                userPersonalityDto.getDrink(),
                userPersonalityDto.getParty(),
                userPersonalityDto.getSleep(),
                userPersonalityDto.getWork(),
                userPersonalityDto.getMature(),
                userPersonalityDto.getSport(),
                userPersonalityDto.getMovies(),
                userPersonalityDto.getSpirituality(),
                userPersonalityDto.getTravel(),
                userPersonalityDto.getFreak(),
                userPersonalityDto.getAnimals(),
                userId);
    }

    @Override
    public void deleteUsersPersonality(long userId) {
        jdbcTemplate.update("DELETE FROM users_personality WHERE fk_user_id= ? ", userId);
    }
}
