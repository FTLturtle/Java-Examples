package jpa.crud.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Musician {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", length = 50)
    protected String firstName;

    @Column(name = "last_name", length = 50)
    protected String lastName;

    @Column(length = 5000)
    protected String bio;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    protected Date dateOfBirth;

    @Transient
    protected Integer age;

    @Column(name = "prefered_instrument")
    protected String preferedInstrument;

    public Musician() {}

    public Musician(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPreferedInstrument() {
        return preferedInstrument;
    }

    public void setPreferedInstrument(String preferedInstrument) {
        this.preferedInstrument = preferedInstrument;
    }
}
