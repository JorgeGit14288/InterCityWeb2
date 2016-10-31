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
public class TelefonosController {

    HttpSession sesion;
    String sesionUser;

    //creando un metodo para guaradar el login
    // metodo que devuele la vista index de los usuarios, en donde se muestran los usuarios registrados
    @RequestMapping("indexu.htm")
    public ModelAndView getUsuarios(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        TelefonosDao userHelper = new TelefonosDao();
        String mensaje = null;
        try {
            if (sesion.getAttribute("usuario") == null) {
                mensaje = "Debe Loguearse para acceder";
                mav.addObject("mensaje", mensaje);
                mav.setViewName("login/login");
            } else {
                mensaje = null;
                mav.setViewName("telefonos/indexu");
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
    @ModelAttribute("listTel")
    public List<Telefonos> listaUsuarios() {

        //Data referencing for web framework checkboxes
        ModelAndView mav = new ModelAndView();
        TelefonosDao userHelper = new TelefonosDao();
        List<Telefonos> telefonosList = userHelper.getAllTelefonos();
        return telefonosList;
    }

    @ModelAttribute("userTels")
    public List<Telefonos> listaTelUser(HttpServletRequest request) {
        sesion = request.getSession();
        String uSesion = sesion.getAttribute("usuario").toString();
        System.out.println("Buscando los telefonos de " + uSesion);
        ModelAndView mav = new ModelAndView();
        TelefonosDao userHelper = new TelefonosDao();
        
        List<Telefonos> telefonosList = userHelper.getAllTelUser(uSesion);
        
        System.out.println("Pase por el controlador");
        return telefonosList;
    }

    // este medoto recibe el numero del telefono del usuario, para mostrar su configuracion.
    @RequestMapping(value = "editar.htm", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        Telefonos telefono = new Telefonos();
        TelefonosDao dao = new TelefonosDao();
        telefono.setTelefono(request.getParameter("telefono"));
        telefono = dao.getTelefono(telefono.getTelefonoArea());
        ModelAndView mav = new ModelAndView();
        mav.addObject("usuario", telefono);
        mav.setViewName("telefonos/editar");
        return mav;
    }

}
