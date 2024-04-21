package com.stepup.MmlnTask_04.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    Integer id;
    @Getter
    @Setter
    @Column(name = "username")
    String username;
    @Getter
    @Setter
    @Column(name = "fio")
    String fio;

    public Users() {
    }

    public Users(String username, String fio) {
        this.username = username;
        this.fio = fio;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Logins> logins = new ArrayList<>();
    public void addLogins(Logins login){
        this.logins.add(login);
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fio='" + fio + '\'' +
                '}';
    }
}

