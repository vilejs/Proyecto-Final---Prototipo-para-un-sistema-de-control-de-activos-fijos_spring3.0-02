package com.controlactivos.vista;

import com.controlactivos.controlador.IUserControlador;
import com.controlactivos.controlador.impl.UserControladorImpl;
import com.controlactivos.modelo.entidades.Users;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "usercore")
@SessionScoped
public class UserVista implements Serializable {

    private Users usuarioSesion;
    private IUserControlador userControlador;
    private Users editarObjeto;

    public UserVista() {
        usuarioSesion=new Users();
    }

    @PostConstruct
    public void init() {
       userControlador=new UserControladorImpl();
    }

    public Users getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Users usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }
    
    public String cerrarSesion(){
         return "login";
    }
    
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "/login.xhtml?faces-redirect=true";
   }
    
    public String iniciarSesion(){
        if(usuarioSesion.getUserName()!=null && usuarioSesion.getPassword() != null){
            
            Users loggeado=userControlador.findUserbyName(usuarioSesion);
            if(loggeado!=null){
                if(loggeado.getPassword().equals(usuarioSesion.getPassword())){
                    setUsuarioSesion(loggeado);
                    return "indexprincipal";
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o Contraseña incorrecta"));
                }
            }else{
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario no existe en la base de datos"));
            }
             
        }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "INGRESE EL USUARIO Y LA CONTRASEÑA"));
        }
        return "";
    }
    
    
    public boolean getPreguntaAdministrador(){
        if(usuarioSesion.getFkPerfil().getIdPerfil()==1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean getPreguntaEditor(){
        if(usuarioSesion.getFkPerfil().getIdPerfil()==3){
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean getPreguntaNormal(){
        if(usuarioSesion.getFkPerfil().getIdPerfil()==2){
            return true;
        }else{
            return false;
        }
    }
    
    
    /***
     * Metodo para editar un objeto
     * @param obj
     */
    public void editarModalPanel(Users obj){
        setEditarObjeto(new Users());
        setEditarObjeto(obj);
    }
    
    /***
     * Metodo para eliminar objeto
     *  
     */
    public void eliminarModalPanel(){
        userControlador.eliminarUser(getEditarObjeto());
        this.init();
    }
    
    /***
     * Metodo para actualizar el registro en la base de datos
     */
    public void actualizarModalPanel(){
        try{
            userControlador.modificarObjeto(getEditarObjeto());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "ACTUALIZACION CORRECTA"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", e.getMessage()));
        }
    }

    public Users getEditarObjeto() {
        return editarObjeto;
    }

    public void setEditarObjeto(Users editarObjeto) {
        this.editarObjeto = editarObjeto;
    }
    
    
    
}
