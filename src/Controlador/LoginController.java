/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.LoginM;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LoginController {

    private static List<LoginM> login = new ArrayList();
    static FileOutputStream fout;
    static FileInputStream fin;
    
    public  LoginController(){
    
        generarInicio();
        
    }
    
    public void generarInicio(){
        agregar(new LoginM("Jose","12345"));
        agregar(new LoginM("Romario","12345"));
    }
    
    public void agregar(LoginM a) {

        login.add(a);

    }
    
    public void listar(){
    
        Iterator iter = login.iterator();
while (iter.hasNext())
  System.out.println(iter.next());

    
    }
    
    public void remover(LoginM a) {

        login.add(a);

    }

    public static void guardarUsuarios() {
        File directorio = new File("c:\\Usuarios");
        directorio.mkdir();

        ObjectOutputStream out = null;
        try {
            fout = new FileOutputStream("C:\\Usuarios\\login.txt");
            out = new ObjectOutputStream(fout);
            out.writeObject(login);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List cargarUsuarios() {
        ObjectInputStream ois = null;
        List provee = new ArrayList();
        try {
            fin = new FileInputStream("C:\\Usuarios\\login.txt");
            ois = new ObjectInputStream(fin);
            try {
                provee = (List) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return provee;
    }
    
     public static LoginM consultar(String n){
        LoginController.cargarUsuarios();
         LoginM j=null;
         for(int i=0;i<getLogin().size();i++){
            j=(LoginM)LoginController.getLogin().get(i);
               if(j.getUsuario().equals(n)){
                return j;
               }
        }
         return j;
    }
     
     public static LoginM consultar2(String n){
        LoginM j=null;
         for(int i=0;i<getLogin().size();i++){
            j=(LoginM)LoginController.getLogin().get(i);
               if(j.getContrasena().equals(n)){
                return j;
               }
        }
         return j;
    }

    /**
     * @return the login
     */
    public static List<LoginM> getLogin() {
        return login;
    }

    /**
     * @param aLogin the login to set
     */
    public static void setLogin(List<LoginM> aLogin) {
        login = aLogin;
    }
}
