package cn.pzhu.shorturl.domain;

import javax.persistence.*;
import lombok.Data;

@Data
public class Diyurl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户指定字符串
     */
    private String name;

    /**
     * 用户指定字符串地址
     */
    private String prefix;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户指定字符串
     *
     * @return name - 用户指定字符串
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户指定字符串
     *
     * @param name 用户指定字符串
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户指定字符串地址
     *
     * @return prefix - 用户指定字符串地址
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 设置用户指定字符串地址
     *
     * @param prefix 用户指定字符串地址
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}