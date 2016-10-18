/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rubén
 */
public class BussinessException extends Exception {

 private List<BussinessMessage> bussinessMessages = new ArrayList<>();

    public BussinessException(List<BussinessMessage> bussinessMessages) {
        this.bussinessMessages.addAll(bussinessMessages);
    }

    public BussinessException(BussinessMessage bussinessMessage) {
        this.bussinessMessages.add(bussinessMessage);
    }

    public List<BussinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }
}
