/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jorge
 */
@Controller
public class PanelController {
    
    HttpSession sesion;
    String sesionUser;

    @RequestMapping("panel.htm")
    public ModelAndView getPanel(HttpServletRequest request) {
        sesion = request.getSession();
        ModelAndView mav = new ModelAndView();
        String mensaje = null;

        if (sesion.getAttribute("usuario") == null) {
            mav.setViewName("login/login");

        } else {
            sesionUser = sesion.getAttribute("usuario").toString();
            mav.setViewName("panel/panel");
        }
        return mav;

    }
}
