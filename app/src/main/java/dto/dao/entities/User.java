package dto.dao.entities;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;

    private User(final String anId, final String aName, final String anEmail) {
        this.id = anId;
        this.name = aName;
        this.email = anEmail;
    }

    public static User build(final String aName, final String anEmail) {
        return new User(UUID.randomUUID().toString().replace("-", ""), aName, anEmail);
    }

    public static User with(final String anId, final String aName, final String anEmail) {
        return new User(anId, aName, anEmail);
    }

    public void changeName(final String newName) {
        if (newName.isBlank()) {
            throw new RuntimeException("User name shouldnt be blank");
        }

        if (newName.length() < 3) {
            throw new RuntimeException("User name must have at least 3 characters");
        }

        this.name = newName;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

}
