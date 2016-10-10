package org.ernest.applications.goplan.ct;

public class UserMainInfoDto {

    private long userId;
    private String name;
    private String description;
    private String facebookId;

    public UserMainInfoDto() {}

    public UserMainInfoDto(long userId, String name, String description, String facebookId) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.facebookId = facebookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
}