package jpa.crud.entities;

import jpa.crud.enums.Language;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Table(name= "T_AUTHOR")
public class Author {
    @Id
    @GeneratedValue()
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", length=50)
    private String firstName;

    @Column(name="last_name", length=50)
    private String lastName;

    @Column(length = 5000)
    private String bio;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Transient
    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    //@Enumerated(EnumType.STRING)
    private Language language;

    public Author(){}

    public Author(String firstName, String lastName, String bio, Date dateOfBirth, Language language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.setAge();
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        setAge();
    }

    public Integer getAge() {
        return age;
    }

    private void setAge() {
        this.age = new Date().getYear() - this.dateOfBirth.getYear();
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
