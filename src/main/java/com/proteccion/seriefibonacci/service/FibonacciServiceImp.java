package com.proteccion.seriefibonacci.service;

import java.time.LocalDateTime;

import com.proteccion.seriefibonacci.domain.FibonacciModified;
import com.proteccion.seriefibonacci.dto.GeneralResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImp implements IFibonacciService{

    @Autowired
    MailServiceImp mailServiceImp;

    @Override
    public GeneralResponseDto getFibonacci() {
        GeneralResponseDto responseFibonacci = new GeneralResponseDto();
        LocalDateTime now = LocalDateTime.now();
        Integer seed1 = 0;
        Integer seed2 = 0;
        Integer limit = 0;

        String seed = String.valueOf(now.getMinute());

        if(seed.length() == 1){
            seed = "0" + String.valueOf(now.getMinute());
        }

        try{
            seed1 = Character.getNumericValue(seed.charAt(0));
            seed2 = Character.getNumericValue(seed.charAt(1));
            limit = now.getSecond();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        FibonacciModified fibonacci = new FibonacciModified(seed1, seed2, limit);

        String resultFibonacci = getFibonacci(fibonacci);

        responseFibonacci.setMensaje("Se ha generado correctamente la sucesión de fibonacci para la hora: " + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());
        responseFibonacci.setFibonacciResultado(resultFibonacci);

        // Send mail
        mailServiceImp.sendMail(responseFibonacci);

        return responseFibonacci;
    }

    public String getFibonacci(FibonacciModified fibonacciModified){
        StringBuilder resultFibonacci = new StringBuilder();
        Integer contador = 0;

        resultFibonacci.append(fibonacciModified.getseed1().toString());
        resultFibonacci.append(", ");
        resultFibonacci.append(fibonacciModified.getSeed2().toString());
        resultFibonacci.append(", ");

        try{
            while(contador < fibonacciModified.getLimit()){
                Integer resultTmp = fibonacciModified.getseed1() + fibonacciModified.getSeed2();
                fibonacciModified.setseed1(fibonacciModified.getSeed2());
                fibonacciModified.setSeed2(resultTmp);
                resultFibonacci.append(resultTmp.toString());
                resultFibonacci.append(", ");
                contador++;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return resultFibonacci.toString();
    }
    
}
