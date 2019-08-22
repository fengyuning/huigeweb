package com.pirate.form.basketball.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 消息要经过网路传输,要实现Serializable
 */
public class MessagePO implements Serializable {

    private static final long serialVersionUID = -4088581597280698416L;

    private int id;

    @JsonIgnore
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String messageId;

    public MessagePO(int id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
