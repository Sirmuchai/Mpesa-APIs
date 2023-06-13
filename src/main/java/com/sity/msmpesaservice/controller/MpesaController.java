package com.sity.msmpesaservice.controller;

import com.sity.msmpesaservice.model.AccessTokenResponse;
import com.sity.msmpesaservice.service.DarajaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class MpesaController {
    private final DarajaApi darajaApi;

    public MpesaController(DarajaApi darajaApi) {
        this.darajaApi = darajaApi;
    }

    @GetMapping(path = "/token", produces = "application/json")
    public ResponseEntity<AccessTokenResponse> token(){
        return ResponseEntity.ok(darajaApi.getAccessToken());
    }
}
