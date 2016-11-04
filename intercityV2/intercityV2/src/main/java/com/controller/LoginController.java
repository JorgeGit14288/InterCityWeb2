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
@SessionAttributes({"userSession"})
public class LoginController {

    HttpSession sesion;
    String sesionUser;

    // este metodo devolvera la vista del login vacia 
    @RequestMapping("login.htm")
    public ModelAndView Login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login/login");
        return mav;

    }

// este metodo sirve para validar el login
    @RequestMapping(value = "validarLogin.htm", method = RequestMethod.POST)
    public ModelAndView Validarlogin(HttpServletRequest request) {
        // creamos los objetos a utilizar
        ModelAndView mav = new ModelAndView();
        Telefonos tel2 = new Telefonos();
        TelefonosDao dao = new TelefonosDao();
        Usuarios user = new Usuarios();
        UsuariosDao userDao = new UsuariosDao();
        String mensaje = null;
        try {
            // recogemos los parametros
            sesion = request.getSession();
            String telefonoArea = (request.getParameter("codigo") + "-" + request.getParameter("telefono"));
            System.out.println("El telefono a busar es " + telefonoArea);
            Cifrar varCifrar = new Cifrar();
            String pass = varCifrar.Encriptar(request.getParameter("password"));

            tel2 = dao.getTelefono(telefonoArea);

            user = userDao.getUsuario(tel2.getIdUsuario());

            if (tel2 == null) {
                mensaje = "El usuario no existe en la base de datos";
                System.out.println("ha ocurrido un error");
                mav.setViewName("login/login");

            } else {
                System.out.println("DATOS EN SERVIDOR" + tel2.getTelefonoArea() + user.getPassword());
                System.out.println("DATOS DEL USUARIO " + telefonoArea + pass);
                if ((telefonoArea.compareTo(tel2.getTelefonoArea()) == 0) && (pass.compareTo(user.getPassword()) == 0)) {

                    String userSesion = tel2.getTelefonoArea();
                    sesion.setAttribute("usuario", userSesion);
                    mensaje = "Bienvenido";
                    mav.setViewName("panel/panel");
                } else {
                    mensaje = "LOS DATOS NO SON CORRECTOS";
                    System.out.println("ha ocurrido un error");
                    mav.setViewName("login/login");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("ha ocurrido un error");
            mensaje = "Ocurrio un error en la validacion de sus datos";
            mav.setViewName("usuarios/login");
        }
        mav.addObject("mensaje", mensaje);

        return mav;
    }

    // este metodo devolvera la vista para registrar a un usuario. tambien vacia
    @RequestMapping(value = "logout.htm", method = RequestMethod.POST)
    public ModelAndView LogOutPOST(HttpServletRequest request) {

        sesion = null;
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login/login");
        return mav;

    }

    @RequestMapping(value = "logout.htm", method = RequestMethod.GET)
    public ModelAndView LogOutGET(HttpServletRequest request) {
        sesion = request.getSession();
        sesion.invalidate();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login/login");
        return mav;

    }

}
