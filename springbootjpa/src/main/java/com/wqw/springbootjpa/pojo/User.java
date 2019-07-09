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

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    private Integer old;

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

    public String toString(){
        return " [ id="+id+", name="+name+", old="+old+" ]";
    }


}
