package com.stepup.MmlnTask_04.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.stepup.MmlnTask_04.entities.Users;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@Entity(name="Logins")
public class Logins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Integer id;
    @Getter
    @Setter
    @Column(name = "access_date")
    private LocalDateTime access_date;
    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "user_id")
    private Users user_id;
    @Getter
    @Setter
    @Column(name = "application")
    private String application;

    public Logins(LocalDateTime access_date, Users user_id, String application) {
        this.access_date = access_date;
        this.user_id = user_id;
        this.application = application;
    }

    public Logins() {
    }

    public void setAccessDate(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        this.access_date = LocalDateTime.parse(date, dateTimeFormatter);
    }
    @Override
    public String toString() {
        return "Logins{" +
                "id=" + id +
                ", access_date='" + access_date + '\'' +
                ", user_id='" + user_id + '\'' +
                ", application='" + application + '\'' +
                '}';
    }
}
