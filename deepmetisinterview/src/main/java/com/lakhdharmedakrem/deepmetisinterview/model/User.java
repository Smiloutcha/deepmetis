package com.lakhdharmedakrem.deepmetisinterview.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class User {

    @Id
    private String username ;
    private String password;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate ;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate ;


    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
