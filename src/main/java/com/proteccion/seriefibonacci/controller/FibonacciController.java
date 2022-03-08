package com.proteccion.seriefibonacci.controller;

import com.proteccion.seriefibonacci.dto.GeneralResponseDto;
import com.proteccion.seriefibonacci.service.IFibonacciService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proteccion")
public class FibonacciController {
    
    @Autowired
    IFibonacciService iFibonacciService;

    @GetMapping(path = "/fibonacci", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getFibonacci(){
        GeneralResponseDto resFibonacci = iFibonacciService.getFibonacci();
        return new ResponseEntity<Object>(resFibonacci, HttpStatus.OK);
    }
    
}
