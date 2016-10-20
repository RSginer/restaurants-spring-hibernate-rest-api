/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.services;

import com.rsginer.exceptions.BussinessException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Rubén
 */
public class FileSaveServiceImpl implements FileSaveService {

    @Override
    public int saveFile(MultipartFile file, HttpServletRequest httpServletRequest) throws BussinessException {
            try {
                String rutaRelativa = "/uploads";
                String rutaAbsoluta = httpServletRequest.getServletContext().getRealPath(rutaRelativa);
                byte[] bytes = file.getBytes();
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(rutaAbsoluta + "/" + file.getOriginalFilename())))) {
                    stream.write(bytes);
                }
                return 200;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


