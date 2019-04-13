package cn.pzhu.shorturl.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ip地址
     */
    @Column(name = "ip_addr")
    private String ipAddr;

    /**
     * 访问时间
     */
    @Column(name = "create_time")
    private Date createTime;

    public View() {
    }

    public View(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public View(String ipAddr, Date createTime) {
        this.ipAddr = ipAddr;
        this.createTime = createTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }
}