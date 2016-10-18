/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.controllers;

import com.rsginer.json.JsonTransformer;
import com.rsginer.spring.model.Prueba;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Rubén
 */
@Controller
public class TestController {
    
    @Autowired
    JsonTransformer jsonTransformer;
    
    @RequestMapping(value = {"/test"})
    public void prueba(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException {

        Prueba p = new Prueba("prueba1",1); 
        httpServletResponse.getWriter().println("Spring Framework REST API Funcionando OK \n \n Injeccion de dependencias JsonTransformer test: " + jsonTransformer.toJson(p));
    }
}
