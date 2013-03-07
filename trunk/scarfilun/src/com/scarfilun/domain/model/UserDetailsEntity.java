package com.scarfilun.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
@Embeddable
public class UserDetailsEntity implements Serializable{

    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;

    @Column(name = "FIRST_NAME", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "GENDER", nullable = false)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "BIRTH_DATE", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
