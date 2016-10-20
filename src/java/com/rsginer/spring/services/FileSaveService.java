/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.services;

import com.rsginer.exceptions.BussinessException;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Rubén
 */
public interface FileSaveService {
    public int saveFile(MultipartFile file,HttpServletRequest httpServletRequest) throws BussinessException;
}
