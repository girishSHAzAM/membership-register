package com.glabs.membershipregister.controller;

import com.glabs.membershipregister.models.User;
import com.glabs.membershipregister.service.DashboardService;
import com.glabs.membershipregister.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/membership-dashboard")
public class DashboardApi {

    private final DashboardService dashboardService;

    @GetMapping("/all/unapproved")
    public ResponseEntity getMembershipRequests(){
        return ResponseBuilder.prepareSuccessResponse(dashboardService.getUnapprovedMembershipRequests(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateMembershipRequests(@RequestBody User user){
        return ResponseBuilder.prepareSuccessResponse(dashboardService.updateMembershipRequests(user), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAllMembershipRequests(){
        return ResponseBuilder.prepareSuccessResponse(dashboardService.getAllMembershipRequests(), HttpStatus.OK);
    }
}
