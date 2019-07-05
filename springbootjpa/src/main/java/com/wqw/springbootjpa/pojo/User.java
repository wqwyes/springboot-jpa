package com.wqw.springbootjpa.pojo;

import javax.persistence.*;

/**
 * @Author: wangqiwei
 * @Date: 2019/7/4 11:04
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String old;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String toString(){
        return " [ id="+id+", name="+name+", old="+old+" ]";
    }


}
