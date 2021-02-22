/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlactivos.modelo.dao;

import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IGenericDao<T> {

    public T create(T t);

    public T read(Object id);

    public T update(T t);

    public void delete(T t);
    
 //Definir los parámetros
    public void beginTransaction();

    public void commit();

    public void rollback();

    public void closeTransaction();

    public void commitAndCloseTransaction();

    public void flush();

    public List<T> findAll();
}
