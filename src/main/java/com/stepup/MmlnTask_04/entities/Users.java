package com.stepup.MmlnTask_04.entities;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@Entity(name="Users")
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

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fio='" + fio + '\'' +
                '}';
    }
}

