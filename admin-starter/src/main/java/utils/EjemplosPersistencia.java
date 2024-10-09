package utils;


import entidades.*;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EjemplosPersistencia {
    
public void crearElementos() {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        
        // Crear una fecha
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.SEPTEMBER, 26, 0, 0, 0); // Año, Mes (0-11), Día
        Date fechaEjemplo = calendar.getTime();
        
        Categoria judicial = new Categoria();
        judicial.setcodCategoria(1);
        judicial.setnombreCategoria("Judicial");
        judicial.setdescWebCategoria("Tramites");
        judicial.setdescCategoria("Son muchos tramites");
      
        FachadaPersistencia.getInstance().guardar(judicial);
        
        Categoria prueba2 = new Categoria();
        prueba2.setcodCategoria(2);
        prueba2.setnombreCategoria("prueba2");
        prueba2.setdescWebCategoria("prueba2");
        prueba2.setdescCategoria("Son muchos tramites");
      
        FachadaPersistencia.getInstance().guardar(prueba2);
        
        Categoria prueba3 = new Categoria();
        prueba3.setcodCategoria(3);
        prueba3.setnombreCategoria("prueba3");
        prueba3.setdescWebCategoria("prueba3");
        prueba3.setdescCategoria("Son muchos tramites");
      
        FachadaPersistencia.getInstance().guardar(prueba3);
        
        Categoria economico = new Categoria();
        economico.setcodCategoria(4);
        economico.setnombreCategoria("Economico");
        economico.setdescWebCategoria("Economia");
        economico.setdescCategoria("Son muchos tramites");
      
        FachadaPersistencia.getInstance().guardar(economico);
        
        EstadoTramite estado1 = new EstadoTramite();
        estado1.setcodEstadoTramite(1);
        estado1.setdescripcionEstadoTramite("Primer estado posible");
        estado1.setfechaBajaEstadoTramite(null);
        estado1.setnombreEstadoTramite("Ingresado");
        
        FachadaPersistencia.getInstance().guardar(estado1);
        
        EstadoTramite estado2 = new EstadoTramite();
        estado2.setcodEstadoTramite(2);
        estado2.setdescripcionEstadoTramite("Segundo estado posible");
        estado2.setfechaBajaEstadoTramite(null);
        estado2.setnombreEstadoTramite("Iniciado");
        
        FachadaPersistencia.getInstance().guardar(estado2);
        
        TramiteEstado tramest1 = new TramiteEstado();
        tramest1.setcontadorEstado(1);
        tramest1.setestadoTramite(estado1);
        tramest1.setetapa(1);
        tramest1.setfechaBajaTramiteEstado(null);
        tramest1.setfechaFinTramiteEstado(null);
        tramest1.setfechaInicioTramiteEstado(fechaEjemplo);

        FachadaPersistencia.getInstance().guardar(tramest1);
        
        TramiteEstado tramest2 = new TramiteEstado();
        tramest2.setcontadorEstado(2);
        tramest2.setestadoTramite(estado2);
        tramest2.setetapa(2);
        tramest2.setfechaBajaTramiteEstado(null);
        tramest2.setfechaFinTramiteEstado(null);
        tramest2.setfechaInicioTramiteEstado(fechaEjemplo);

        FachadaPersistencia.getInstance().guardar(tramest2);
       
        Usuario usuario0 = new Usuario();
        usuario0.setCodUsuario(10);
        usuario0.setusername("josepe");
        usuario0.setpassword("1234567");

        FachadaPersistencia.getInstance().guardar(usuario0);
        
        Usuario usuario6 = new Usuario();
        usuario6.setCodUsuario(7);
        usuario6.setusername("pepepe");
        usuario6.setpassword("1234567");

        FachadaPersistencia.getInstance().guardar(usuario6);
        
        Consultor consultor1 = new Consultor();
        consultor1.setcantMaximaTramites(20);
        consultor1.setfechaHoraBajaConsultor(null);
        consultor1.setnombreApellidoConsultor("José Perez");
        consultor1.setnroLegajoConsultor(202323);
        consultor1.setusuario(usuario0);
        
        FachadaPersistencia.getInstance().guardar(consultor1);
        
        Consultor consultor2 = new Consultor();
        consultor2.setcantMaximaTramites(20);
        consultor2.setfechaHoraBajaConsultor(null);
        consultor2.setnombreApellidoConsultor("Pepe Perez");
        consultor2.setnroLegajoConsultor(202323);
        consultor2.setusuario(usuario6);
        
        FachadaPersistencia.getInstance().guardar(consultor2);
              
        List<Consultor> consultorList = new ArrayList<>();
        consultorList.add(consultor1);
        consultorList.add(consultor2);

        AgendaSemanal agenda1 = new AgendaSemanal();
        agenda1.setañoAgendaSemanal(fechaEjemplo);
        agenda1.setfechaDesdeAgendaSemanal(fechaEjemplo);
        agenda1.setfechaHastaAgendaSemanal(fechaEjemplo);
        agenda1.setnroSemanaAgendaSemanal(1);
        agenda1.setConsultorList(consultorList);
         
        FachadaPersistencia.getInstance().guardar(agenda1);
        
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
        
        TipoDocumentacion tipodoc1 = new TipoDocumentacion();
        tipodoc1.setcodTipoDocumentacion(1);
        tipodoc1.setdescTipoDocumentacion("Nueva");
        tipodoc1.setfechaHoraBajaTD(null);
        tipodoc1.setnombreTipoDocumentacion("doc1");
        
        FachadaPersistencia.getInstance().guardar(tipodoc1);
        
        // Crear una fecha "desde" (1 de octubre de 2023)
        calendar.set(2023, Calendar.OCTOBER, 1, 0, 0, 0);
        Date fechaDesde = calendar.getTime();

        // Crear una fecha "hasta" (31 de octubre de 2023)
        calendar.set(2024, Calendar.OCTOBER, 31, 23, 59, 59);
        Date fechaHasta = calendar.getTime();
        
        TipoTramiteTipoDocumentacion tttd = new TipoTramiteTipoDocumentacion();
        tttd.setfechaDesdeTipoTramiteTipoDocumentacion(fechaDesde);
        tttd.setfechaHastaTipoTramiteTipoDocumentacion(fechaHasta);
        tttd.setcontadorTipoTramite(10);
        tttd.settipoDocumentacion(tipodoc1);
                
        FachadaPersistencia.getInstance().guardar(tttd);

        List<TipoTramiteTipoDocumentacion> tipoTramiteTipoDocumentacionList = new ArrayList<>();
        tipoTramiteTipoDocumentacionList.add(tttd);
        
        TipoTramite poder = new TipoTramite();
        poder.setcodTipoTramite(1);
        poder.setdescTipoTramite("nada");
        poder.setdescWebTipoTramite("menos");
        poder.setmaxDiasParaDocumentacion(30);
        poder.setnombreTipoTramite("poderes");
        poder.setcategoria(judicial);
        poder.settipoTramiteTipoDocumentacionList(tipoTramiteTipoDocumentacionList);
        
        FachadaPersistencia.getInstance().guardar(poder);
        
        TipoTramite plata = new TipoTramite();
        plata.setcodTipoTramite(2);
        plata.setdescTipoTramite("nada");
        plata.setdescWebTipoTramite("menos");
        plata.setmaxDiasParaDocumentacion(40);
        plata.setnombreTipoTramite("dinero");
        plata.setcategoria(economico);
        plata.settipoTramiteTipoDocumentacionList(tipoTramiteTipoDocumentacionList);
        
        FachadaPersistencia.getInstance().guardar(plata);

       
        TramiteDocumentacion tramdoc1 = new TramiteDocumentacion();
        tramdoc1.setfechaHoraEntregaDoc(null);
        tramdoc1.settipoDocumentacion(tipodoc1);
        
        FachadaPersistencia.getInstance().guardar(tramdoc1);
        
        List<TramiteEstado> tramiteEstadoList = new ArrayList<>();
        tramiteEstadoList.add(tramest1);
        tramiteEstadoList.add(tramest2);
        
        List<TramiteDocumentacion> tramiteDocumentacionList = new ArrayList<>();
        tramiteDocumentacionList.add(tramdoc1);
        
        
        Tramite tramite1 = new Tramite();
        tramite1.setdiscriminadorTramite("T1");
        tramite1.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite1.setnroTramite(1);
        tramite1.setObservaciones("nada");
        tramite1.setcliente(cliente1);
        tramite1.setTramiteCosto(20);
        tramite1.setconsultor(consultor1);
        tramite1.settipoTramite(plata);
        tramite1.setestadoTramite(estado1);
        //tramite1.settramiteEstadoList(tramiteEstadoList);
        tramite1.settramiteDocumentacionList(tramiteDocumentacionList);
        
        FachadaPersistencia.getInstance().guardar(tramite1);
        
        Tramite tramite2 = new Tramite();
        tramite2.setdiscriminadorTramite("T2");
        tramite2.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite2.setnroTramite(2);
        tramite2.setObservaciones("esta finalizado");
        tramite2.setcliente(cliente2);
        tramite2.setfechaHoraFinTramiteReal(new Timestamp(System.currentTimeMillis()));
        tramite2.setTramiteCosto(50);
        tramite2.setconsultor(consultor1);
        tramite2.settipoTramite(plata);
        tramite2.setestadoTramite(estado1);
        //tramite2.settramiteEstadoList(tramiteEstadoList);
        tramite2.settramiteDocumentacionList(tramiteDocumentacionList);
        
        FachadaPersistencia.getInstance().guardar(tramite2);
        
        Tramite tramite3 = new Tramite();
        tramite3.setdiscriminadorTramite("T3");
        tramite3.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite3.setnroTramite(3);
        tramite3.setObservaciones("esta anulado");
        tramite3.setcliente(cliente3);
        tramite3.setfechaAnulacion(new Timestamp(System.currentTimeMillis()));
        tramite3.setTramiteCosto(150);
        tramite3.setconsultor(consultor1);
        tramite3.settipoTramite(plata);
        tramite3.setestadoTramite(estado1);
        //tramite3.settramiteEstadoList(tramiteEstadoList);
        tramite3.settramiteDocumentacionList(tramiteDocumentacionList);
        
        FachadaPersistencia.getInstance().guardar(tramite3);
        
        Tramite tramite4 = new Tramite();
        tramite4.setdiscriminadorTramite("T4");
        tramite4.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite4.setnroTramite(4);
        tramite4.setObservaciones("finalizado con cliente 1");
        tramite4.setcliente(cliente1);
        tramite4.setfechaHoraFinTramiteReal(new Timestamp(System.currentTimeMillis()));
        tramite4.setTramiteCosto(200);
        tramite4.setconsultor(consultor1);
        tramite4.settipoTramite(plata);
        tramite4.setestadoTramite(estado1);
        //tramite4.settramiteEstadoList(tramiteEstadoList);
        tramite4.settramiteDocumentacionList(tramiteDocumentacionList);
        
        FachadaPersistencia.getInstance().guardar(tramite4);
             
        
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }
}