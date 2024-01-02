package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
//test git2
    @GetMapping("/add")
    public Double add(@RequestParam("num111") Double num1, @RequestParam("num222") Double num2){
        return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double substract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result = null;
        if(num1 > num2){
            return num1 - num2;
        }else {
            return num2 - num1;
        }
    }

    @PostMapping("/mul")
    public ResponseEntity multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}











