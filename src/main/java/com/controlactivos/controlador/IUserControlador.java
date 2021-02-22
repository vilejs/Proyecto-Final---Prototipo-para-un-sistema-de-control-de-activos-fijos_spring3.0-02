package com.controlactivos.controlador;

import com.controlactivos.modelo.entidades.Users;
import java.util.List;

/**
 *
 * @author J. Simbaña
 */
public interface IUserControlador {

    void insertarUser(Users nuevoClientes);
    List<Users> listarUser();
    void eliminarUser(Users usuario);
    Users findUserbyName(Users usuario);
    void modificarObjeto(Users objeto);
    
}
    



