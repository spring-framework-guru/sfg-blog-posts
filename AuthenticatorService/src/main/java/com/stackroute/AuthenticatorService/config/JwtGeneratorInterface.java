package com.stackroute.AuthenticatorService.config;

import com.stackroute.AuthenticatorService.model.User;
import java.util.Map;

public interface JwtGeneratorInterface {

    Map<String, String> generateToken(User user);
}
