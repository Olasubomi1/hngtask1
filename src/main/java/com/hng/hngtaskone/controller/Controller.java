package com.hng.hngtaskone.controller;

import com.hng.hngtaskone.dto.ServerResponse;
import com.hng.hngtaskone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class Controller {
    @Autowired
    private IUserService userService;



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServerResponse> handleGetUser(@RequestParam(value = "slack_name") String slack_name, @RequestParam(value = "track") String track){
        ServerResponse serverResponse = userService.getUser(slack_name, track);
        return ResponseEntity.ok(serverResponse);
    }
}
