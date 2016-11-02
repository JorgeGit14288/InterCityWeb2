/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TelefonosDao;
import com.dao.UsuariosDao;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.entitys.Telefonos;
import com.entitys.Usuarios;
import com.util.Cifrar;
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
    ) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;
        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");

        } else {
            String idUsuario = request.getParameter("idUsuaro");
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

            System.out.println("los checkbox tienen valor " + notifyEmail + notifyFlag);

            mav.setViewName("panel/panel");
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
        user = userDao.getUsuario(tel.getIdUsuario());

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

}
