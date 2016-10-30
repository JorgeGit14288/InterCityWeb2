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
public class UsuariosController {
     HttpSession sesion;
    String codigo;
    @RequestMapping ("usuarios")
    public ModelAndView usuarios(HttpServletRequest request)
    { 
        ModelAndView mav = new ModelAndView();
        mav.setViewName("usuarios/usuarios");
        return mav;
        
    }
    
}
