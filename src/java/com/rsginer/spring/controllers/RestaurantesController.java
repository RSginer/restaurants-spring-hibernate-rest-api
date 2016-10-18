/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.controllers;

import com.rsginer.exceptions.BussinessException;
import com.rsginer.json.JsonTransformer;
import com.rsginer.spring.dao.RestaurantesDAO;
import com.rsginer.spring.model.Restaurante;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = {"/restaurantes"}, method = RequestMethod.GET,
            produces = "application/json")
    public void getRestaurantes(HttpServletRequest httpRequest,
            HttpServletResponse httpServletResponse) {
        try {
            List<Restaurante> listaRestaurantes = new ArrayList<>();
            listaRestaurantes = restaurantesDAO.findAll();
            String jsonSalida = jsonTransformer.toJson(listaRestaurantes);
            if (listaRestaurantes.size() <= 0) {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            }
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/restaurantes/{id}"}, method = RequestMethod.GET,
            produces = "application/json")
    public void getRestauranteById(HttpServletRequest httpRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("id") int idRestaurante) {
        try {
            Restaurante restaurante = restaurantesDAO.get(idRestaurante);
            String jsonSalida = jsonTransformer.toJson(restaurante);
            if (restaurante == null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            }
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/restaurantes"}, method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public void setRestaurante(HttpServletRequest httpRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada) {
        try {
            Restaurante restaurante = jsonTransformer.fromJSON(jsonEntrada, Restaurante.class);
            String jsonSalida = jsonTransformer.toJson(restaurante);
            if (restaurante != null && restaurante.getNombre() != null
                    && restaurante.getDireccion() != null
                    && restaurante.getDescripcion() != null
                    && restaurante.getPrecio() != null) {
                restaurantesDAO.insert(jsonTransformer.fromJSON(jsonSalida, Restaurante.class));
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);

        } catch (BussinessException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
