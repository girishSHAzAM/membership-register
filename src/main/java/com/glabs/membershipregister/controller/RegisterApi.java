package com.glabs.membershipregister.controller;

import com.glabs.membershipregister.models.User;
import com.glabs.membershipregister.service.RegisterService;
import com.glabs.membershipregister.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/membership-register")
public class RegisterApi {

    private final RegisterService registerService;

    @PostMapping("/")
    public ResponseEntity saveUsers(@RequestBody User user){
        return ResponseBuilder.prepareSuccessResponse(registerService.registerUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity updateUsers(@RequestBody User user){
        return ResponseBuilder.prepareSuccessResponse(registerService.updateUserById(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") String membershipId){
        return ResponseBuilder.prepareSuccessResponse(registerService.getUserById(membershipId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getUserById(){
        return ResponseBuilder.prepareSuccessResponse(registerService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") String membershipId){
        return ResponseBuilder.prepareSuccessResponse(registerService.deleteUserById(membershipId), HttpStatus.OK);
    }


}
