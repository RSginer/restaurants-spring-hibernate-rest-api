/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.controllers;

import com.rsginer.json.JsonTransformer;
import com.rsginer.spring.dao.RestaurantesDAO;
import com.rsginer.spring.model.Restaurante;
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
public class RestaurantesController {

    @Autowired
    private JsonTransformer jsonTransformer;

    @Autowired
    private RestaurantesDAO restaurantesDAO;

    @RequestMapping(value = {"/restaurantes"})
    public void prueba(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        Restaurante restaurante = restaurantesDAO.get(1);
        String jsonRestaurante = jsonTransformer.toJson(restaurante);
        if (restaurante != null) {
            httpServletResponse.getWriter().println(jsonRestaurante);
        }else{
            httpServletResponse.getWriter().println("el restaurante no se ha recogido con exito");
        }
        
    }
 
}


