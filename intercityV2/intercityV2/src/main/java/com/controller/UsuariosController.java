/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.TelefonosDao;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.entitys.Telefonos;
import com.dao.UsuariosDao;
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
public class UsuariosController {

    HttpSession sesion;
    String sesionUser;

    //creando un metodo para guaradar el login
    // metodo que devuele la vista index de los usuarios, en donde se muestran los usuarios registrados
    @RequestMapping("indexu.htm")
    public ModelAndView getUsuarios() {
        ModelAndView mav = new ModelAndView();
        TelefonosDao userHelper = new TelefonosDao();
        String mensaje = null;
        try {
            if (sesion.getAttribute("usuario") == null) {
                mensaje = "Debe Loguearse para acceder";
                mav.addObject("mensaje", mensaje);
                mav.setViewName("usuarios/indexu");
            } else {
                mensaje = null;
                mav.setViewName("usuarios/indexu");
                mav.addObject("mensaje", mensaje);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "Debe logearse para acceder a los datos";
            mav.addObject("mensaje", mensaje);
            mav.setViewName("login/login");
        }

        return mav;
    }

    //al llamar a la vista index para mostrar el usuario, esta requerira de la lista de usuarios 
    // la cual se almacenan en este atributo
    @ModelAttribute("usuariosl")
    public List<Telefonos> listaUsuarios() {

        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        TelefonosDao userHelper = new TelefonosDao();
        List<Telefonos> telefonosList = userHelper.getAllTelefonos();
        return telefonosList;

    }

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
        Telefonos telefono = new Telefonos();
        Telefonos tel2 = new Telefonos();
        TelefonosDao dao = new TelefonosDao();
        String mensaje = null;
        try {

            // recogemos los parametros
            sesion = request.getSession();
            telefono.setCodigoArea(request.getParameter("codigo"));
            telefono.setTelefono(request.getParameter("telefono"));
            telefono.setTelefonoArea(telefono.getCodigoArea() + "-" + telefono.getTelefono());
            String pass = (request.getParameter("password"));
            Cifrar varCifrar = new Cifrar();
            telefono.setPassword(varCifrar.Encriptar(request.getParameter("password")));
            System.out.println(telefono.getTelefonoArea() + " " + telefono.getPassword());

            tel2 = dao.getTelefono(telefono.getTelefonoArea());
            if (tel2.getTelefonoArea().compareTo(null) == 0) {
                  mensaje = "El usuario no existe en la base de datos";
                    System.out.println("ha ocurrido un error");
                    mav.setViewName("login/login");

            } else {
                System.out.println(tel2.getTelefonoArea() + tel2.getPassword());

                System.out.println(telefono.getTelefonoArea() + telefono.getPassword());

                if ((telefono.getTelefonoArea().compareTo(tel2.getTelefonoArea()) == 0) && (telefono.getPassword().compareTo(tel2.getPassword()) == 0)) {

                    String userSesion = telefono.getTelefonoArea();
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

    // este medoto recibe el numero del telefono del usuario, para mostrar su configuracion.
    @RequestMapping(value = "editar.htm", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        Telefonos telefono = new Telefonos();
        TelefonosDao dao = new TelefonosDao();
        telefono.setTelefono(request.getParameter("telefono"));
        telefono = dao.getTelefono(telefono.getTelefonoArea());
        ModelAndView mav = new ModelAndView();
        mav.addObject("usuario", telefono);
        mav.setViewName("usuarios/editar");
        return mav;
    }

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
