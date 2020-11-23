package com.stackly.challenge.backend.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.stackly.challenge.backend.dto.UserDto;
import com.stackly.challenge.backend.entities.User;
import com.stackly.challenge.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public String SignUp(User user) {
        try {
            if (user.getEmail() == null) {
                return "Inserte un correo";
            } else if (user.getPassword() == null) {
                return "Inserte una contraseña";
            } else if (user.getName() == null) {
                return "Escriba su nombre";
            }
            User savedUser =  userRepository.save(user);
            Algorithm algorithm = Algorithm.HMAC256("superSecret");
            JWT.create().withClaim("userId", savedUser.getId()).sign(algorithm);
            return "Usuario Registrado Correctamente";
        } catch (JWTCreationException e) {
            return "Error: "+ e;
        }
    }

    public String SignInUser(UserDto user) {
        try {
            if (user.getEmail() == null || user.getPassword() == null) {
                return "Escriba correctamente sus credenciales";
            }
            User foundUser = userRepository.findByEmail(user.getEmail());
            if (foundUser == null) {
                return null;
            }

            if (!foundUser.getPassword().equals(user.getPassword())) {
                return null;
            }

            Algorithm algorithm = Algorithm.HMAC256("TopSecretMeLaPelan");
            return JWT.create()
                    .withClaim("userId", foundUser.getId())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            return null;
        }
    }
}
