package com.jykim.webservice.config.auth.dto;

import com.jykim.webservice.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter

public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }

}
