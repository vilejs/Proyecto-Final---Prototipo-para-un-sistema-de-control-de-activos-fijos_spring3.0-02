package com.controlactivos.modelo.dao;

import com.controlactivos.modelo.entidades.Users;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IUserDao {

    void insertarUser(Users nuevoClientes);
    List<Users> listarUser();
    Users findUserbyName(Users usuario);
    void modificarObjeto(Users objeto);
    void eliminarObjeto(Users objeto);
    
}
