package utils;


import entidades.*;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EjemplosPersistencia {
    
public void crearElementos() {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        /*
        Categoria judicial = new Categoria();
        judicial.setcodCategoria(1);
        judicial.setnombreCategoria("Judicial");
        judicial.setdescWebCategoria("Tramites");
        judicial.setdescCategoria("Son muchos tramites");
        
      
        FachadaPersistencia.getInstance().guardar(judicial);
        */
         /* 
        TipoTramite poder = new TipoTramite();
        poder.setcodTipoTramite(1);
        poder.setdescTipoTramite("nada");
        poder.setdescWebTipoTramite("menos");
        poder.setmaxDiasParaDocumentacion(30);
        poder.setnombreTipoTramite("poderes");
        poder.setcategoria(judicial);
        
        FachadaPersistencia.getInstance().guardar(poder);
        
        Usuario usuario1 = new Usuario();
        usuario1.setCodUsuario(1);
        usuario1.setusername("lucas5");
        usuario1.setpassword("1234567");

        FachadaPersistencia.getInstance().guardar(usuario1);
        
        Usuario usuario2 = new Usuario();
        usuario2.setCodUsuario(2);
        usuario2.setusername("nicoo");
        usuario2.setpassword("12345");

        FachadaPersistencia.getInstance().guardar(usuario2);
        
        Usuario usuario3 = new Usuario();
        usuario3.setCodUsuario(3);
        usuario3.setusername("valee");
        usuario3.setpassword("123456");

        FachadaPersistencia.getInstance().guardar(usuario3);
        
        Cliente cliente1 = new Cliente();
        cliente1.setnroCliente(1);
        cliente1.setnombreCliente("Lucas");
        cliente1.setApellidoCliente("Genaulaz");
        cliente1.setDNICliente(44139673);
        cliente1.setemailCliente("martin@gmail.com");
        cliente1.settelCliente(26342635);
        cliente1.setObservaciones("");
        cliente1.setusuario(usuario1);

        FachadaPersistencia.getInstance().guardar(cliente1);
        
        Cliente cliente2 = new Cliente();
        cliente2.setnroCliente(2);
        cliente2.setnombreCliente("Nico");
        cliente2.setApellidoCliente("Berducci");
        cliente2.setDNICliente(441309333);
        cliente2.setemailCliente("nico@gmail.com");
        cliente2.settelCliente(261426222);
        cliente2.setObservaciones("nadaa");
        cliente2.setusuario(usuario2);

        FachadaPersistencia.getInstance().guardar(cliente2);
        
        Cliente cliente3 = new Cliente();
        cliente3.setnroCliente(3);
        cliente3.setnombreCliente("Valen");
        cliente3.setApellidoCliente("Martinez");
        cliente3.setDNICliente(441309085);
        cliente3.setemailCliente("Vale@gmail.com");
        cliente3.settelCliente(261425122);
        cliente3.setObservaciones("nadaa");
        cliente3.setusuario(usuario3);

        FachadaPersistencia.getInstance().guardar(cliente3);
        
        Tramite tramite1 = new Tramite();
        tramite1.setdiscriminadorTramite("T1");
        tramite1.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite1.setnroTramite(1);
        tramite1.setObservaciones("nada");
        tramite1.setcliente(cliente1);
        tramite1.setTramiteCosto(20);
        
        FachadaPersistencia.getInstance().guardar(tramite1);
        
        Tramite tramite2 = new Tramite();
        tramite2.setdiscriminadorTramite("T2");
        tramite2.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite2.setnroTramite(2);
        tramite2.setObservaciones("esta finalizado");
        tramite2.setcliente(cliente2);
        tramite2.setfechaHoraFinTramiteReal(new Timestamp(System.currentTimeMillis()));
        tramite2.setTramiteCosto(50);
        
        FachadaPersistencia.getInstance().guardar(tramite2);
        
        Tramite tramite3 = new Tramite();
        tramite3.setdiscriminadorTramite("T3");
        tramite3.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite3.setnroTramite(3);
        tramite3.setObservaciones("esta anulado");
        tramite3.setcliente(cliente3);
        tramite3.setfechaAnulacion(new Timestamp(System.currentTimeMillis()));
        tramite3.setTramiteCosto(150);
        
        FachadaPersistencia.getInstance().guardar(tramite3);
        
        Tramite tramite4 = new Tramite();
        tramite4.setdiscriminadorTramite("T4");
        tramite4.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite4.setnroTramite(4);
        tramite4.setObservaciones("finalizado con cliente 1");
        tramite4.setcliente(cliente1);
        tramite4.setfechaHoraFinTramiteReal(new Timestamp(System.currentTimeMillis()));
        tramite4.setTramiteCosto(200);
        
        FachadaPersistencia.getInstance().guardar(tramite4);
        */
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }
}