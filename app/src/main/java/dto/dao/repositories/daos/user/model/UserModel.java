package dto.dao.repositories.daos.user.model;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public record UserModel(
        String id,
        String name,
        String email,
        Instant createdAt) {

    public static UserModel build(
            final String anId,
            final String aName,
            final String anEmail) {
        return new UserModel(anId, aName, anEmail, Instant.now().truncatedTo(ChronoUnit.MICROS));
    }

    public static UserModel with(
            final String anId,
            final String aName,
            final String anEmail,
            final Instant createdAt) {
        return new UserModel(anId, aName, anEmail, createdAt);
    }
}
