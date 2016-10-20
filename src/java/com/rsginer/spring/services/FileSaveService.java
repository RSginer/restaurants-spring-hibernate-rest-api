/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.services;

import com.rsginer.exceptions.BussinessException;
import java.io.File;

/**
 *
 * @author Rubén
 */
public interface FileSaveService {
    public String saveFile(byte[] file, String nombre) throws BussinessException;
}
