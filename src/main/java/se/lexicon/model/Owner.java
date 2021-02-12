package se.lexicon.model;

import java.io.Serializable;
import java.util.UUID;

public class Owner implements Serializable {

    private UUID ownerId;
    private String name;
    private String birthDate;

    public Owner() {
        this.ownerId = UUID.randomUUID();

    }

    public Owner(String name, String birthDate) {
        this.ownerId = UUID.randomUUID();
        this.name = name;
        this.birthDate = birthDate;
    }


    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
