package com.proteccion.seriefibonacci.service;

import com.proteccion.seriefibonacci.dto.GeneralResponseDto;

import org.springframework.stereotype.Service;

@Service
public interface IMailService {
    public abstract void sendEmail(GeneralResponseDto response);
}
