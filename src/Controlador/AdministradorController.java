/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AdministradorController {

    private static List<AdministradorController> administrador = new ArrayList();
    static FileOutputStream fout;
    static FileInputStream fin;

    public static void guardarAdministrador() {
        File directorio = new File("c:\\Administrador");
        directorio.mkdir();

        ObjectOutputStream out = null;
        try {
            fout = new FileOutputStream("C:\\Administrador\\administrador.txt");
            out = new ObjectOutputStream(fout);
            out.writeObject(administrador);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List cargarAdministrador() {
        ObjectInputStream ois = null;
        List provee = new ArrayList();
        try {
            fin = new FileInputStream("C:\\Administrador\\administrador.txt");
            ois = new ObjectInputStream(fin);
            try {
                provee = (List) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return provee;
    }

    
    public void agregar(Administrador a){
        administrador.add(a);
    }
    /**
     * @return the administrador
     */
    public static List<AdministradorController> getAdministrador() {
        return administrador;
    }

    /**
     * @param aAdministrador the administrador to set
     */
    public static void setAdministrador(List<AdministradorController> aAdministrador) {
        administrador = aAdministrador;
    }

}
