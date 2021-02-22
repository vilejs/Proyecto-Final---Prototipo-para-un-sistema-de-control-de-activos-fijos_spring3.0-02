package com.controlactivos.modelo.dao.impl;

import com.controlactivos.modelo.dao.IUserDao;
import com.controlactivos.modelo.entidades.Users;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author J. Simbaña
 */
public class UserDaoImpl extends GenericDaoImpl<Users> implements IUserDao {


    public UserDaoImpl(Class<Users> entityClass) {
        super(entityClass);
    }

    @Override
    public void insertarUser(Users nuevoUser) {
        this.beginTransaction();
        this.create(nuevoUser);
        this.commit();
        this.closeTransaction();
    }

 
    @Override
    public List<Users> listarUser(){
        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> p= cb.createQuery(Users.class);
        Root<Users> usuariosList= p.from(Users.class);
        p.select(usuariosList);
        return this.entityManager.createQuery(p).getResultList();
    }

    @Override
    public Users findUserbyName(Users usuario) {
       CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> p= cb.createQuery(Users.class);
        Root<Users> usuariosList= p.from(Users.class);
        p.select(usuariosList);
        p.select(usuariosList).where(cb.equal(usuariosList.get("userName"), usuario.getUserName()));        
        List<Users> lista= this.entityManager.createQuery(p).getResultList();
        if(lista!=null){
            Users recuperado=new Users();
            recuperado=(Users)lista.get(0);
            return recuperado;
        }
        return null;
    }
    
    @Override
    public void modificarObjeto(Users objeto) {
        try {
                this.beginTransaction();
                this.update(objeto);
                this.commit();
        } catch (Exception e) {
                this.rollback();
        }
    }
    
    @Override
    public void eliminarObjeto(Users objeto) {
        try {
                this.beginTransaction();
                this.delete(objeto);
                this.commit();
        } catch (Exception e) {
                this.rollback();
        }
    }

}
