/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.spring.dao;

import com.rsginer.exceptions.BussinessException;
import com.rsginer.spring.model.Restaurante;
import java.util.List;

/**
 *
 * @author Rubén
 */
public interface RestaurantesDAO {
   public void insert(Restaurante restaurante) throws BussinessException;
   public void update(int idRestaurante,Restaurante restaurante) throws BussinessException;
   public Restaurante get(int idRestaurante) throws BussinessException;
   public Restaurante getRandom() throws BussinessException;
   public void delete(int idRestaurante) throws BussinessException;
   public List<Restaurante> findAll() throws BussinessException;
}
