package com.kp.spring.hello.model.reqres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Data data;

    public User() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(data, user.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

class Data {
    private long id;

    @JsonProperty ("first_name")
    private String firstName;

    @JsonProperty ("last_name")
    private String lastName;

    @JsonProperty ("avatar")
    private String avatarURL;

    public Data() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatarURL='" + avatarURL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id &&
                Objects.equals(firstName, data.firstName) &&
                Objects.equals(lastName, data.lastName) &&
                Objects.equals(avatarURL, data.avatarURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, avatarURL);
    }
}
