/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entitys.Telefonos;
import com.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jorge
 */
public class TelefonosDao implements ITelefonosDao {

    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public List<Telefonos> getAllTelefonos() throws HibernateException {
        List<Telefonos> listaTelefonoss = null;

        try {
            iniciaOperacion();
            listaTelefonoss = sesion.createQuery("from Telefonos").list();
        } finally {
            sesion.close();
        }

        return listaTelefonoss;
    }

    public Telefonos getTelefono(String telefono) throws HibernateException {
        Telefonos tel = null;
        try {
            iniciaOperacion();
            String queryString = "from Telefonos where telefono_area = :telefono";
            Query query = sesion.createQuery(queryString);
            query.setString("telefono", telefono);
            tel = (Telefonos) query.uniqueResult();
            System.out.println("El usuario exite" + tel.getTelefonoArea());
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sesion.close();

        }

        return tel;
    }

    public Telefonos getTelefono2(String idTelefonos) throws HibernateException {
        Telefonos tel = null;
        try {
            iniciaOperacion();
            tel = (Telefonos) sesion.get(Telefonos.class, idTelefonos);
        } finally {
            sesion.close();
        }

        return tel;
    }

    public boolean deleteTelefonos(Telefonos tel) throws HibernateException {
        boolean resultado = false;
        try {
            iniciaOperacion();
            sesion.delete(tel);
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return resultado;
    }

    public boolean updateTelefono(Telefonos tel) throws HibernateException {
        boolean resultado = false;
        try {
            iniciaOperacion();
            sesion.update(tel);
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return resultado;
    }

    public boolean createTelefono(Telefonos tel) throws HibernateException {
        boolean resultado = false;

        try {
            iniciaOperacion();
            sesion.save(tel);
            tx.commit();
            resultado = true;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return resultado;
    }

    public boolean deleteTelefono(String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int countTelefonos() {

        int cantidad = 0;
        cantidad = this.getAllTelefonos().size()+1;
        System.out.println("el numero de registro es "+cantidad);
        
        return cantidad;

    }

}
