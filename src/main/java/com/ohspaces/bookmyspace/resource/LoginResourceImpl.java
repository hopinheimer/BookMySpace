package com.ohspaces.bookmyspace.resource;

import com.ohspaces.bookmyspace.exception.BookSpaceException;
import com.ohspaces.bookmyspace.model.LoginReponseModel;
import com.ohspaces.bookmyspace.model.LoginRequestModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResourceImpl implements LoginResource{
    @Override
    public LoginReponseModel login(LoginRequestModel request) throws BookSpaceException {
        return null;
    }
}
