/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TelefonosDao;
import com.dao.UsuariosDao;
import com.entitys.Account;
import com.entitys.AccountLight;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.entitys.Telefonos;
import com.entitys.Usuarios;
import com.util.Cifrar;
import com.util.httpAccount;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author jorge
 */
@Controller
public class UsuariosController {
    
    
    public UsuariosController()
    {
        
    }

    HttpSession sesion;
    String sesionUser;

    @RequestMapping("usuarios.htm")
    public ModelAndView usuarios(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;

        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");

        } else {

            mav.setViewName("usuarios/usuarios");
        }
        return mav;
    }

    @RequestMapping("registrarUsuarios.htm")
    public ModelAndView registrarUsuarios(HttpServletRequest request
    ) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;

        if (sesion.getAttribute("usuario") == null) {

            mav.setViewName("login/login");

        } else {
            String sesUser = sesion.getAttribute("usuario").toString();
             
            mav.setViewName("usuarios/registrarUsuarios");
        }
        return mav;
    }

    @RequestMapping("editarUsuarios.htm")
    public ModelAndView editarUsuarios(HttpServletRequest request
    ) {

        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;
        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");

        } else {

            mav.setViewName("usuarios/editarUsuarios");
        }

        return mav;
    }

    @RequestMapping(value = "validarEditarUsuarios.htm", method = RequestMethod.POST)
    public ModelAndView validarEditarUsuarios(HttpServletRequest request
    ) {

        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;
        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");

        } else {

            mav.setViewName("usuarios/editarUsuarios");
        }

        return mav;
    }

    @RequestMapping(value = "validarRegistrarUsuarios.htm", method = RequestMethod.POST)
    public ModelAndView validarRegistrarUsuarios(HttpServletRequest request
    ) throws MalformedURLException, IOException {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;
        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");
        } else {
            String idUsuario = request.getParameter("idUsuario");
            String TelArea = request.getParameter(sesion.getAttribute("usuario").toString());
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String direccion = request.getParameter("direccion");
            String ciudad = request.getParameter("ciudad");
            String codigoPostal = request.getParameter("codigoPostal");
            String email = request.getParameter("email");
            String lenguaje = request.getParameter("lenguaje");
            boolean notifyEmail=false;
            boolean notifyFlag=false;

            if (request.getParameter("notifyEmail")!=null) {
                notifyEmail = true;
            }
            if (request.getParameter("notifyFlag")!=null) {
                notifyFlag = true;
            }
            AccountLight account = new AccountLight();
            Usuarios usuario = new Usuarios();
            UsuariosDao userDao = new UsuariosDao();
            
            account.setAddress(direccion);
            account.setCity(ciudad);
            account.setEmail(email);
            account.setFirstName(nombres);
            account.setLastName(apellidos);
            account.setNotifyEmail(notifyEmail);
            account.setNotifyEmail(notifyEmail);
            account.setPostalCode(codigoPostal);
            account.setLanguaje_id(lenguaje);
            
            usuario = userDao.getUsuario(idUsuario);

            usuario.setApellidos(apellidos);
            usuario.setEmail(email);
            //usuario.setIdUsuario(idUsuario);
            System.out.print("el id del usuario es "+idUsuario);
            usuario.setNombres(nombres);
            usuario.setPais(ciudad);
            usuario.setStatus("Activo");
            

            httpAccount accountHelper = new httpAccount();
            
            if(userDao.updateUsuarios(usuario))
            {
                
                usuario = userDao.getUsuario(idUsuario);
                if (usuario.getIdAccount()==null)
                {
                    System.out.println("No se ha enontrado el accountId del usuario se buscara");
                    usuario.setIdAccount(accountHelper.getIdAccount(TelArea));
                    userDao.updateUsuarios(usuario);
                    System.out.println("Se ha registrado el usuario con el servidor en linea ");
                }
                else
                {
                     System.out.println("Se encontro el accountId del usuario ");
                    accountHelper.setAccountObject(account, usuario.getIdAccount());
                      System.out.println("se ha actualizado el usuario al servidor ");
                }
                
                mav.setViewName("panel/perfil");
            }
            
            else
            {
                mav.setViewName("usuarios/registrarUsuarios");
            }         
        }
        return mav;
    }

   

    //ATRIBUTOS PARA CONSULTAR
    @ModelAttribute("listUser")
    public List<Usuarios> listaUsuarios() {

        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        UsuariosDao userDao = new UsuariosDao();
        List<Usuarios> listUser = userDao.getAllUsuarios();
        return listUser;
    }

    @ModelAttribute("user")
    public Usuarios getUsuario(HttpServletRequest request
    ) {
        sesion = request.getSession();
        String usr = sesion.getAttribute("usuario").toString();
        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        UsuariosDao userDao = new UsuariosDao();
        Usuarios user = new Usuarios();
        Telefonos tel = new Telefonos();
        TelefonosDao telDao = new TelefonosDao();
        tel = telDao.getTelefono(usr);
        user = userDao.getUsuario(tel.getUsuarios().getIdUsuario());

        return user;
    }

    @ModelAttribute("tel")
    public Telefonos getTelefono(HttpServletRequest request
    ) {
        sesion = request.getSession();
        String uSesion = sesion.getAttribute("usuario").toString();
        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        Telefonos tel = new Telefonos();
        TelefonosDao telDao = new TelefonosDao();
        tel = telDao.getTelefono(uSesion);

        return tel;
    }
    // validar si el usuario aun no tiene el AccountId
    @ModelAttribute("idAccount")
    public String getidAccount(HttpServletRequest request
    ) {
        sesion = request.getSession();
        String uSesion = sesion.getAttribute("usuario").toString();
        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        httpAccount accountHelper = new httpAccount();
        String resultado = accountHelper.getIdAccount(uSesion);

        return resultado;
    }

}
