package com.ohspaces.bookmyspace.resource;

import com.ohspaces.bookmyspace.exception.BookSpaceException;
import com.ohspaces.bookmyspace.model.LoginReponseModel;
import com.ohspaces.bookmyspace.model.LoginRequestModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path ={"/com/ohspaces/bms"})
public interface LoginResource {

    @PostMapping(path = {"/login"},produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginReponseModel login(LoginRequestModel request) throws BookSpaceException;



}
