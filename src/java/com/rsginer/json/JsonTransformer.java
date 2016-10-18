/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsginer.json;

/**
 *
 * @author Rubén
 */
public interface JsonTransformer {
     String toJson(Object data);
    <T> T fromJSON(String json, Class<T> clazz);
}
