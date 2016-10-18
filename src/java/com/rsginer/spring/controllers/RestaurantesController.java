/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.controllers;

import com.rsginer.json.JsonTransformer;
import com.rsginer.spring.dao.RestaurantesDAO;
import com.rsginer.spring.model.Restaurante;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = {"/restaurantes"}, method=RequestMethod.GET,
                            produces = "application/json; charset=UTF-8")
    public void get(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Restaurante> listaRestaurantes = new ArrayList<>();
        listaRestaurantes = restaurantesDAO.findAll();
        String jsonListaRestaurantes = jsonTransformer.toJson(listaRestaurantes);
        httpServletResponse.getWriter().println(jsonListaRestaurantes);
    }
 
}


