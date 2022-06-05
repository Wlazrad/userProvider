package com.example.userprovider.controller;

import com.example.userprovider.aspect.RequestCounter;
import com.example.userprovider.external.github.model.response.UserResponse;
import com.example.userprovider.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @RequestCounter
    @GetMapping(value = "/{login}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public UserResponse setContractorHeaderId(@PathVariable String login) {
        return userFacade.getUserResponse(login);
    }
}
