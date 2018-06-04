package com.ztw.pcadvisor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * The Persistent login.
 */
@Entity
public class PersistentLogins {

    /**
     * The Username.
     */
    @Column
    @NotNull
    String username;

    /**
     * The Series.
     */
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String series;

    /**
     * The Token.
     */
    @Column
    @NotNull
    String token;

    /**
     * The Last used.
     */
    @Column
    @NotNull
    Timestamp lastUsed;

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets series.
     *
     * @return the series
     */
    public String getSeries() {
        return series;
    }

    /**
     * Sets series.
     *
     * @param series the series
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets last used.
     *
     * @return the last used
     */
    public Timestamp getLastUsed() {
        return lastUsed;
    }

    /**
     * Sets last used.
     *
     * @param lastUsed the last used
     */
    public void setLastUsed(Timestamp lastUsed) {
        this.lastUsed = lastUsed;
    }
}
