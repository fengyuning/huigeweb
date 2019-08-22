package com.pirate.form.basketball.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author fengyn
 * @version 2019/01/26
 */
public class UserPO {
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

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
}
