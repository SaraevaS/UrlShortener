package org.sevinc.SevincurlShortener.entity.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sevinc.SevincurlShortener.entity.db.Person;
import org.sevinc.SevincurlShortener.entity.db.Url;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UrlHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UrlHistorySequence")
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "ip")
    private String ip;

    @ManyToOne
    @JoinColumn(name = "urlid")
    private Url url;

    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;


    public UrlHistory(String date, String time, String ip, Url url, Person person) {
        this.date = date;
        this.time = time;
        this.ip = ip;
        this.url = url;
        this.person = person;
    }
}