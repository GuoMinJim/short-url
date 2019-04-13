package cn.pzhu.shorturl.domain;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
public class Urlmapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "long_url")
    private String longUrl;

    @Column(name = "create_time")
    private Date createTime;

    public Urlmapping() {
    }

    public Urlmapping(String shortUrl, String longUrl, Date createTime) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.createTime = createTime;
    }
}