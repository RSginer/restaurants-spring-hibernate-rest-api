/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.exceptions;

/**
 *
 * @author Rubén
 */
public class BussinessMessage  {
    private final String fieldName;
    private final String message;
 
    public BussinessMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
     
    public String getFieldName() {
        return fieldName;
    }
 
    public String getMessage() {
        return message;
    }
    
}
