package DEV;

import static DEV.Conexion.conexion;
import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Metodos {

    public static String getNombreMetodo() {
        return new Exception().getStackTrace()[1].getMethodName();
    }

    public static void MostrarError(Object error, String metodo) {
        JOptionPane.showMessageDialog(null, "Se ha detectado un error con los datos ingresados." + error);
        sendEmail(String.valueOf(error + " Ref: " + metodo));
    }

    public static Date Fecha_hoy() {
        Date hoy = new Date();
        return hoy;
    }

    public static void sendEmail(String mensaje) {

        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "estudiocuatrok@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("estudiocuatrok@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("estudiocuatrok@gmail.com"));
            message.setSubject("ERROR en Sistema Silos");
            message.setText(mensaje);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("estudiocuatrok@gmail.com", "Michalik87");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (MessagingException ex) {
            MostrarError(ex, getNombreMetodo());
        }

    }

    // -------------------------------------- Definicion de variables globales
    public static int max = 0;
    public static int id_transportista = 0;
    public static int recibo_de_dinero_id_cliente = 0;
    public static int recibo_de_dinero_id_moneda = 0;
    public static int combustible_uso_id_personal = 0;
    public static int combustible_venta_id_cliente = 0;
    public static int id_ticket = 0;
    public static int productos_aplicacion_id_parcela = 0;
    public static int productos_aplicacion_id_cultivo = 0;
    public static int id_combustible = 0;
    public static int id_vehiculo = 0;
    public static int id_parcela = 0;
    public static int id_camion = 0;
    public static int ventas_id_forma_pago = 0;
    public static int ventas_id_moneda = 0;
    public static int ventas_id_cliente = 0;
    public static int id_producto_aplicacion_detalle = 0;
    public static int id_facturas_compras = 0;
    public static int id_facturas_compras_detalle = 0;
    public static int compras_tipo = 0;
    public static int id_chofer = 0;
    public static int recepcion_id_motivo = 0;
    public static int Productos_aplicacion_abm_id_zafra = 0;
    public static int productos_aplicacion_abm_id_producto = 0;
    public static int recepcion_id_recepcion_detalle = 0;
    public static int productos_aplicacion_detalle_id_producto_aplicacion_detalle = 0;
    public static int recepcion_id_motivo_de_descuento = 0;
    public static int recibo_de_dinero_id_banco = 0;
    public static int tabla_ad_id_tipo = 0;
    public static int liquidaciones_multiples_id_recepcion = 0;
    public static int personales_pagos_id_concepto = 0;
    public static int personales_pagos_id_empleado = 0;
    public static int personales_pago_id_mes = 0;
    public static int consultas_id_recepcion = 0;
    public static int seleccionado = 0;
    public static int compras_id_moneda = 0;
    public static int consultas_id_cliente = 0;
    public static int compras_id_proveedor = 0;
    public static int contratos_recepcion_id_contrato = 0;
    public static int ventas_id_producto = 0;
    public static int id_combustible_uso_selected = 0;
    public static int id_sucursal_selected = 0;
    public static int listado_id_remitente = 0;
    public static int configuracion_id_sucursal_selected = 0;
    public static int combustibles_uso_id_vehiculo = 0;
    public static int id_carreta = 0;
    public static int id_empleado_cargo = 0;
    public static int id_granos_tipo = 0;
    public static int Contratos_listado_id_cliente = 0;
    public static int id_recepcion = 0;
    public static int dato_int = 0;
    public static int id_moneda = 0;
    public static int id_remitente = 0;
    public static int id_tecnologia = 0;
    public static int compras_id_producto = 0;
    public static int id_empleado = 0;
    public static boolean ismac = false;
    public static long cant = 0;
    public static long total_sin_descuento = 0;
    public static long cant_san_rafael = 0;
    public static int id_cuenta = 0;
    public static int id_recibo = 0;
    public static int id_usuario_selected = 0;
    public static int factura = 0;
    public static int id_cuenta_max = 0;
    public static int id_cliente = 0;
    public static int id_chofer_nuevo = 0;
    public static int id_usuario_buscar = 0;
    public static int id_ubicacion = 0;
    public static int id_cuenta_detalle = 0;
    public static int id_cuenta_detalle_facturacion = 0;
    public static int id = 0;
    public static int id_combustible_uso = 0;
    public static int formulario_que_pide = 0;
    public static ResultSetMetaData rsm;
    public static DefaultTableModel dtm;
    public static String comercio;
    public static String titulo;
    public static int id_comercio;
    public static int id_sucursal;
    public static int privilegio;
    public static int id_sueldo;
    public static int id_sueldo_detalle;
    public static String comercio_direccion;
    public static String empresa;
    public static String empresa_datos;
    public static String sucursal;
    public static String imagen;
    public static String path;
    public static String remitente;
    public static String ubicacion_proyecto;
    public static String ubicacion_reportes;
    public static String comercio_telefono;
    public static String comercio_email;
    public static String comercio_ruc;
    public static int id_proveedor = 1;
    public static int consultas_id_estado = 0;
    public static int id_productos_precio = 1;
    public static int id_medio_de_pago = 0;
    public static int id_producto_listado = 0;
    public static int habilitar_control_individual_de_pago = 0;
    public static int habilitar_medio_de_pago = 0;
    public static int bloquear_facturas = 0;
    public static int alerta_stock = 0;
    public static int habilitar_facturacion = 0;
    public static String caja_numero = "000";
    public static String sucursal_numero = "000";
    public static String rubro = "";
    public static int id_productos_tipo = 0;
    public static int id_producto = 0;
    public static int tabla_ad_id_concepto = 0;
    public static int id_rubro = 0;
    public static int id_venta = 0;
    public static int id_recepcion_detalle = 0;
    public static int id_venta_detalle = 0;
    public static boolean error;
    public static boolean error_cuenta_detalle;
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static int id_pedido_interno = 0;
    public static int id_pagare = 0;
    public static int id_zafra = 0;
    public static int id_contrato = 0;
    public static int productos_id_proveedor = 0;
    public static int id_combustible_venta = 0;
    public static int id_producto_aplicacion = 0;
    public static int pedidos = 0;
    public static int precio_automatico = 0;
    public static int venta_terminar = 0;
    public static int venta_terminar_con_nedio_de_pago = 0;
    public static int formulario_externo = 0;
    public static int entro = 0;
    public static String id_pedido_seleccionado = null;
    public static String nombre = null;
    public static String ruta_imagen = null;
    public static ArrayList<String> AI = new ArrayList<>();
    public static boolean existe = false;
    public static int tipo_de_venta = 0;
    public static int id_cliente_listado = 0;
    public static int id_usuario_ABM = 0;
    public static int id_usuario = 0;
    public static int id_motivo = 0;
    public static int contrato_recepcion_id_zafra = 0;
    public static int contrato_recepcion_id_cliente = 0;
    public static int recepcion_id_zafra = 0;
    public static int uso_de_productos_listado_id_parcela = 0;
    public static int uso_de_productos_listado_id_zafra = 0;
    public static int uso_de_productos_listado_id_cultivo = 0;
    public static int recepcion_id_variedad = 0;
    public static int recepcion_id_remitente = 0;
    public static int contratos_id_zafra = 0;
    public static int contratos_id_cliente = 0;
    public static int listado_recepcion_pendiente_id_cliente = 0;
    public static int ultimo_producto_agregado_id_cuenta_detalle = 0;
    public static int productos_aplicacion_id_tipo = 0;
    public static long total = 0;
    public static Date hoy = new Date();
    public static boolean error_impurezas;
    public static boolean error_humedad;
    public static boolean error_ardido;
    public static boolean error_quebrado;
    public static boolean error_chuzos;
    public static boolean error_verdes;

    public static DecimalFormat formato = new DecimalFormat("#,###,###,###");

//    public static void Contratos_clear() {
//        Contratos.jTextField_cliente.setText("");
//        Contratos.jTextField_contrato.setText("");
//        Contratos.jTextField_premio.setText("");
//        Contratos.jTextField_toneladas.setText("");
//        Contratos.jTextField_zafra.setText("");
//        id_contrato = 0;
//        contratos_id_cliente = 0;
//        contratos_id_zafra = 0;
//        Contratos.jTextField_cliente.requestFocus();
//    }

    public static double Recepcion_total_a_pagar(String precio) {
        double total_a_pagar = 0;
        double total_a_pagar_long = 0;
        double neto = 0;
        try {
            Statement ST_recepcion = conexion.createStatement();
            ResultSet RS_recepcion = ST_recepcion.executeQuery("SELECT * FROM recepcion where id_recepcion = '" + id_recepcion + "'");
            while (RS_recepcion.next()) {
                neto = RS_recepcion.getLong("total_neto_carga");
            }
            total_a_pagar = Double.parseDouble(precio) * (neto / 1000);
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
        return total_a_pagar;
    }

//    public static void Compras_buscar() {
//        try {
//            Statement ST_recepcion = conexion.createStatement();
//            ResultSet RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT * "
//                    + "FROM facturas_compra "
//                    + "inner join proveedor on proveedor.id_proveedor = facturas_compra.id_proveedor "
//                    + "inner join factura_tipo on factura_tipo.id_factura_tipo = facturas_compra.id_factura_tipo "
//                    + "inner join moneda on moneda.id_moneda = facturas_compra.id_moneda "
//                    + "where id_facturas_compra = '" + id_facturas_compras + "'");
//            while (RS_recepcion.next()) {
//                Compras.jT_factura_nro.setText(RS_recepcion.getString("numero").trim());
//                Compras.jDateChooser.setDate(RS_recepcion.getDate("fecha"));
//                Compras.jT_Proveedor.setText(RS_recepcion.getString("nombre").trim());
//                Compras.jT_tipo.setText(RS_recepcion.getString("tipo").trim());
//                Compras.jT_moneda.setText(RS_recepcion.getString("moneda").trim());
//                compras_id_proveedor = RS_recepcion.getInt("id_proveedor");
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }

//    public static void Compras_total() {
//        try {
//            Statement ST_recepcion = conexion.createStatement();
//            ResultSet RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT SUM(precio) "
//                    + "FROM facturas_compra_detalle "
//                    + "where id_facturas_compra = '" + id_facturas_compras + "'");
//            while (RS_recepcion.next()) {
//                Compras.jTextField_total.setText(RS_recepcion.getString(1));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }

//    public static void Ventas_traer_datos() {
//        try {
//            Statement ST_recepcion = conexion.createStatement();
//            ResultSet RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT * "
//                    + "FROM venta "
//                    + "inner join cliente on cliente.id_cliente = venta.id_cliente "
//                    + "inner join venta_forma_pago on venta_forma_pago.id_venta_forma_pago = venta.id_venta_forma_pago "
//                    + "inner join moneda on moneda.id_moneda = venta.id_moneda "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_cliente.setText(RS_recepcion.getString("nombre").trim());
//                Ventas.jTextField_forma_pago.setText(RS_recepcion.getString("forma_pago"));
//                ventas_id_forma_pago = RS_recepcion.getInt("id_venta_forma_pago");
//                Ventas.jTextField_moneda.setText(RS_recepcion.getString("moneda"));
//                ventas_id_moneda = RS_recepcion.getInt("id_moneda");
//                Ventas.jTextField_numero.setText(RS_recepcion.getString("numero"));
//                Ventas.jTextField_total.setText(num.format(RS_recepcion.getLong("total")));
//                Ventas.jDateChooser_fecha.setDate(RS_recepcion.getDate("fecha"));
//                Ventas.jTextField_numero.setText(RS_recepcion.getString("id_venta"));
//            }
//            ST_recepcion = conexion.createStatement();
//            RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT sum(exentas) "
//                    + "FROM venta_detalle "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_total_0.setText(String.valueOf(num.format(RS_recepcion.getDouble(1))));
//            }
//
//            ST_recepcion = conexion.createStatement();
//            RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT sum(cinco) "
//                    + "FROM venta_detalle "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_total_5.setText(String.valueOf(num.format(RS_recepcion.getDouble(1))));
//                double iva5 = 0;
//                iva5 = (RS_recepcion.getDouble(1) / 21);
//                Ventas.jTextField_iva_5.setText(String.valueOf(num.format(iva5)));
//            }
//            ST_recepcion = conexion.createStatement();
//            RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT sum(diez) "
//                    + "FROM venta_detalle "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_total_10.setText(String.valueOf(num.format(RS_recepcion.getDouble(1))));
//                double iva10 = 0;
//                iva10 = (RS_recepcion.getDouble(1) / 11);
//                Ventas.jTextField_iva_10.setText(String.valueOf(num.format(iva10)));
//            }
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static void Recibo_de_dinero_traer_datos() {
//        try {
//            Statement ST_recepcion = conexion.createStatement();
//            ResultSet RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT * "
//                    + "FROM recibo "
//                    + "inner join cliente on cliente.id_cliente = recibo.id_cliente "
//                    + "inner join moneda on moneda.id_moneda = recibo.id_moneda "
//                    + "inner join banco on banco.id_banco = recibo.id_banco "
//                    + "where id_recibo = '" + id_recibo + "' ");
//            while (RS_recepcion.next()) {
//                recibo_de_dinero_id_banco = RS_recepcion.getInt("id_banco");
//                recibo_de_dinero_id_cliente = RS_recepcion.getInt("id_cliente");
//                recibo_de_dinero_id_moneda = RS_recepcion.getInt("id_moneda");
//
//                Recibo_de_dinero.jTextField_cliente.setText(RS_recepcion.getString("nombre").trim());
//                Recibo_de_dinero.jTextField_banco.setText(RS_recepcion.getString("banco"));
//                Recibo_de_dinero.jTextField_moneda.setText((RS_recepcion.getString("moneda")));
//                Recibo_de_dinero.jDateChooser2.setDate(RS_recepcion.getDate("fecha"));
//                Recibo_de_dinero.jTextField_cheque.setText(RS_recepcion.getString("cheque"));
//                Recibo_de_dinero.jTextField_concepto.setText(RS_recepcion.getString("concepto"));
//                Recibo_de_dinero.jTextField_dinero.setText(String.valueOf(RS_recepcion.getLong("cantidad")));
//            }
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static void Ventas_calculo() {
//        try {
//
//            Statement ST_recepcion = conexion.createStatement();
//            ResultSet RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT * "
//                    + "FROM venta "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_total.setText(num.format(RS_recepcion.getLong("total")));
//            }
//
//            ST_recepcion = conexion.createStatement();
//            RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT sum(exentas) "
//                    + "FROM venta_detalle "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_total_0.setText(String.valueOf(num.format(RS_recepcion.getDouble(1))));
//            }
//
//            ST_recepcion = conexion.createStatement();
//            RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT sum(cinco) "
//                    + "FROM venta_detalle "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_total_5.setText(String.valueOf(num.format(RS_recepcion.getDouble(1))));
//                double iva5 = 0;
//                iva5 = (RS_recepcion.getDouble(1) / 21);
//                Ventas.jTextField_iva_5.setText(String.valueOf(num.format(iva5)));
//            }
//            ST_recepcion = conexion.createStatement();
//            RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT sum(diez) "
//                    + "FROM venta_detalle "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_total_10.setText(String.valueOf(num.format(RS_recepcion.getDouble(1))));
//                double iva10 = 0;
//                iva10 = (RS_recepcion.getDouble(1) / 11);
//                Ventas.jTextField_iva_10.setText(String.valueOf(num.format(iva10)));
//            }
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static DecimalFormat num = new DecimalFormat("#,###.##");
//
//    public static void Sueldo_detalle_get_total() {
//        try {
//            long total = 0;
//            long diferencia = 0;
//
//            Statement ST_recepcion = conexion.createStatement();
//            ResultSet RS_recepcion = ST_recepcion.executeQuery(""
//                    + "select * "
//                    + "from sueldo_detalle "
//                    + "inner join concepto_de_pago on concepto_de_pago.id_concepto_de_pago = sueldo_detalle.id_concepto_de_pago "
//                    + "where id_sueldo = '" + id_sueldo + "'");
//            while (RS_recepcion.next()) {
//                if (RS_recepcion.getLong("importe") < 1) {
//
//                } else {
//                    total = (RS_recepcion.getLong("importe")) + total;
//                }
//                diferencia = RS_recepcion.getLong("importe") + diferencia;
//            }
//            Personales_pagos_ABM.jTextField_diferencia.setText(formato.format(diferencia));
//            Personales_pagos_ABM.jTextField_total.setText(formato.format(total));
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static void Contrato_traer_datos() {
//        try {
//            Statement ST = conexion.createStatement();
//            ResultSet RS = ST.executeQuery(""
//                    + "SELECT * FROM contrato "
//                    + "inner join cliente on cliente.id_cliente = contrato.id_cliente "
//                    + "inner join zafra on zafra.id_zafra = contrato.id_zafra "
//                    + "where id_contrato = '" + id_contrato + "' ");
//            while (RS.next()) {
//                if (RS.getString("nombre") != null) {
//                    Contratos.jTextField_cliente.setText(RS.getString("nombre").trim());
//                }
//                contratos_id_cliente = RS.getInt("id_cliente");
//                if (RS.getString("nro") != null) {
//                    Contratos.jTextField_contrato.setText(RS.getString("nro").trim());
//                }
//                if (RS.getString("premio") != null) {
//                    Contratos.jTextField_premio.setText(RS.getString("premio").trim());
//                }
//                if (RS.getString("tonelada") != null) {
//                    Contratos.jTextField_toneladas.setText(RS.getString("tonelada").trim());
//                }
//                if (RS.getString("zafra") != null) {
//                    Contratos.jTextField_zafra.setText(RS.getString("zafra").trim());
//                }
//                if (RS.getString("fecha") != null) {
//                    Contratos.jDateChooser_fecha.setDate(RS.getDate("fecha"));
//                }
//                contratos_id_zafra = RS.getInt("id_zafra");
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public synchronized static void Compras_actualizar(String numero) {
//        try {
//            PreparedStatement st = conexion.prepareStatement(""
//                    + "UPDATE facturas_compra "
//                    + "SET fecha_date ='" + util_Date_to_sql_date(Compras.jDateChooser.getDate()) + "', "
//                    + "id_proveedor ='" + id_proveedor + "', "
//                    + "numero ='" + numero + "' "
//                    + "WHERE id_facturas_compra = '" + id_facturas_compras + "'");
//            st.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public synchronized static void Compras_tipo_factura_update() {
//        try {
//            int tipo = 0;
//            Statement ST = conexion.createStatement();
//            ResultSet RS = ST.executeQuery(""
//                    + "SELECT * FROM facturas_compra "
//                    + "where id_facturas_compra = '" + id_facturas_compras + "' ");
//            while (RS.next()) {
//                tipo = RS.getInt("id_factura_tipo");
//            }
//            if (tipo == 2) {
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE facturas_compra "
//                        + "SET id_factura_tipo ='1' "
//                        + "WHERE id_facturas_compra = '" + id_facturas_compras + "'");
//                st.executeUpdate();
//                Compras.jT_tipo.setText("CONTADO");
//            } else {
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE facturas_compra "
//                        + "SET id_factura_tipo ='2' "
//                        + "WHERE id_facturas_compra = '" + id_facturas_compras + "'");
//                st.executeUpdate();
//                Compras.jT_tipo.setText("CREDITO");
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public synchronized static void Compras_moneda_update() {
//        try {
//            int tipo = 0;
//            Statement ST = conexion.createStatement();
//            ResultSet RS = ST.executeQuery(""
//                    + "SELECT * FROM facturas_compra "
//                    + "where id_facturas_compra = '" + id_facturas_compras + "' ");
//            while (RS.next()) {
//                tipo = RS.getInt("id_moneda");
//            }
//            if (tipo == 2) {
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE facturas_compra "
//                        + "SET id_moneda ='1' "
//                        + "WHERE id_facturas_compra = '" + id_facturas_compras + "'");
//                st.executeUpdate();
//                Compras.jT_moneda.setText("GS");
//            } else {
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE facturas_compra "
//                        + "SET id_moneda ='2' "
//                        + "WHERE id_facturas_compra = '" + id_facturas_compras + "'");
//                st.executeUpdate();
//                Compras.jT_moneda.setText("USD");
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public synchronized static void Ventas_actualizar_tipo() {
//        try {
//            int tipo = 0;
//            Statement ST = conexion.createStatement();
//            ResultSet RS = ST.executeQuery(""
//                    + "SELECT * FROM venta "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS.next()) {
//                tipo = RS.getInt("id_venta_forma_pago");
//            }
//            if (tipo == 2) {
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE venta "
//                        + "SET id_venta_forma_pago ='1' "
//                        + "WHERE id_venta = '" + id_venta + "'");
//                st.executeUpdate();
//                Ventas.jTextField_forma_pago.setText("CONTADO");
//            } else {
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE venta "
//                        + "SET id_venta_forma_pago ='2' "
//                        + "WHERE id_venta = '" + id_venta + "'");
//                st.executeUpdate();
//                Ventas.jTextField_forma_pago.setText("CREDITO");
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public synchronized static void Ventas_moneda_update() {
//        try {
//
//            int moneda = 0;
//
//            Statement ST = conexion.createStatement();
//            ResultSet RS = ST.executeQuery(""
//                    + "SELECT * FROM venta "
//                    + "where id_venta = '" + id_venta + "' ");
//            while (RS.next()) {
//                moneda = RS.getInt("id_moneda");
//            }
//
//            if (moneda == 1) {
//                moneda = 2;
//                Ventas.jTextField_moneda.setText("USD");
//            } else {
//                Ventas.jTextField_moneda.setText("GS.");
//                moneda = 1;
//            }
//
//            PreparedStatement st = conexion.prepareStatement(""
//                    + "UPDATE venta "
//                    + "SET id_moneda ='" + moneda + "' "
//                    + "WHERE id_venta = '" + id_venta + "'");
//            st.executeUpdate();
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public synchronized static void Consultas_seleccionar_update() {
//        try {
//            PreparedStatement st = conexion.prepareStatement(""
//                    + "UPDATE recepcion "
//                    + "SET seleccionado ='" + seleccionado + "' "
//                    + "WHERE id_recepcion = '" + consultas_id_recepcion + "'");
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    public synchronized static void Liquidaciones_multiples_recepcion_update(int valor) {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE recepcion "
                    + "SET seleccionado ='" + valor + "' "
                    + "WHERE id_recepcion = '" + liquidaciones_multiples_id_recepcion + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Consultas_seleccionar_update_all() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE recepcion "
                    + "SET seleccionado ='" + seleccionado + "' "
                    + "WHERE seleccionado = '1'");
            st.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Ventas_update_moneda() {
        try {
            int dolar = 0;
            if (ventas_id_moneda == 1) {
                dolar = 1;
            }

            if (ventas_id_moneda == 2) {
                PreparedStatement ps3 = conexion.prepareStatement("select * from configuracion ");
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {
                    dolar = rs3.getInt("dolar");
                }
            }

            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE venta "
                    + "SET id_moneda ='" + ventas_id_moneda + "', "
                    + "dolar = '" + dolar + "' "
                    + "WHERE id_venta = '" + id_venta + "'"
            );
            st.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }
//
//    public synchronized static void Compras_tipo_update() {
//        try {
//
//            if (compras_tipo == 2) {
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE facturas_compra "
//                        + "SET tipo = '1',"
//                        + "tipo_str = 'CONTADO' "
//                        + "WHERE id_facturas_compra = '" + id_facturas_compras + "'");
//                st.executeUpdate();
//                compras_tipo = 1;
//                Compras.jT_tipo.setText("CONTADO");
//            } else {
//                PreparedStatement st = conexion.prepareStatement(""
//                        + "UPDATE facturas_compra "
//                        + "SET tipo = '2',"
//                        + "tipo_str = 'CREDITO' "
//                        + "WHERE id_facturas_compra = '" + id_facturas_compras + "'");
//                st.executeUpdate();
//                compras_tipo = 2;
//                Compras.jT_tipo.setText("CREDITO");
//
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    public synchronized static void Contratos_recepcion_update() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE contrato "
                    + "SET estado ='2', "
                    + "estado_str = 'Cumplido' "
                    + "WHERE id_contrato = '" + contratos_recepcion_id_contrato + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Ventas_update_cliente() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE venta "
                    + "SET id_cliente ='" + ventas_id_cliente + "' "
                    + "WHERE id_venta = '" + id_venta + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Configuracion_sucursal_guardar(String numero) {
        try {

            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE sucursal "
                    + "SET numero_remision ='" + Integer.parseInt(numero) + "' "
                    + "where id_sucursal ='" + configuracion_id_sucursal_selected + "'");
            st.executeUpdate();

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Combustible_venta_max() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_combustible_venta) FROM combustible_venta");
            if (result.next()) {
                id_combustible_venta = result.getInt(1);
            }
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Productos_aplicacion_abm_max() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_producto_aplicacion) FROM producto_aplicacion");
            if (result.next()) {
                id_producto_aplicacion = result.getInt(1);
            }
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Sueldo_max() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_sueldo) FROM sueldo");
            if (result.next()) {
                id_sueldo = result.getInt(1);
            }
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Compras_max() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_facturas_compra) FROM facturas_compra");
            if (result.next()) {
                id_facturas_compras = result.getInt(1);
            }
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Ventas_max() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_venta) FROM venta ");
            if (result.next()) {
                id_venta = result.getInt(1);
            }
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Ventas_guardar() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_venta) FROM venta");
            if (result.next()) {
                id_venta = result.getInt(1) + 1;
            }

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO venta VALUES(?,?,?,?,?,?,?)");
            stUpdateProducto.setInt(1, id_venta);
            stUpdateProducto.setInt(2, 0);
            stUpdateProducto.setDate(3, util_Date_to_sql_date(hoy));
            stUpdateProducto.setLong(4, 0);
            stUpdateProducto.setInt(5, ventas_id_cliente);
            stUpdateProducto.setInt(6, ventas_id_forma_pago);
            stUpdateProducto.setInt(7, ventas_id_moneda);
            stUpdateProducto.executeUpdate();

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void TablaAD_guardar(String cantidad, String porcentaje) {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_tablaad) FROM tabla_ad");
            if (result.next()) {
                id = result.getInt(1) + 1;
            }

            PreparedStatement st = conexion.prepareStatement("INSERT INTO tabla_ad VALUES(?,?,?,?,?,?)");
            st.setInt(1, id);
            st.setInt(2, tabla_ad_id_tipo);
            st.setInt(3, tabla_ad_id_concepto);
            st.setDouble(4, Double.parseDouble(cantidad));
            st.setDouble(5, Double.parseDouble(porcentaje));
            st.setString(6, "D");
            st.executeUpdate();

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

//    public synchronized static void Productos_aplicacion_abm_guardar_detalle(String dosis, String has_str) {
//        try {
//
//            double dosis_double = Double.parseDouble(dosis);
//            double has = Double.parseDouble(has_str);
//            double precio = 0;
//            Statement st1 = conexion.createStatement();
//            ResultSet result = st1.executeQuery("SELECT * FROM productos where id_producto = '" + productos_aplicacion_abm_id_producto + "' ");
//            if (result.next()) {
//                precio = result.getDouble("precio");
//            }
//
//            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO producto_aplicacion_detalle VALUES(?,?,?,?,?,?,?)");
//            stUpdateProducto.setInt(1, MAX_tabla("id_producto_aplicacion_detalle", "producto_aplicacion_detalle"));
//            stUpdateProducto.setInt(2, id_producto_aplicacion);
//            stUpdateProducto.setInt(3, productos_aplicacion_abm_id_producto);
//            stUpdateProducto.setDouble(4, dosis_double);
//            stUpdateProducto.setDouble(5, dosis_double * has);
//            stUpdateProducto.setDouble(6, has);
//            stUpdateProducto.setDouble(7, precio);
//            stUpdateProducto.executeUpdate();
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    public synchronized static void Productos_aplicacion_abm_guardar(Date fecha) {
        try {

            if (productos_aplicacion_id_cultivo == 0) {
                JOptionPane.showMessageDialog(null, "Debes elegir un tipo de cultivo para continuar.");
            } else {

                if (id_producto_aplicacion == 0) {
                    Statement st1 = conexion.createStatement();
                    ResultSet result = st1.executeQuery("SELECT MAX(id_producto_aplicacion) FROM producto_aplicacion ");
                    if (result.next()) {
                        id_producto_aplicacion = result.getInt(1) + 1;
                    }
                    int aplicacion = 1;
                    ResultSet rs3 = st1.executeQuery("SELECT MAX(aplicacion) FROM producto_aplicacion "
                            + "where id_granos_tipo = '" + productos_aplicacion_id_cultivo + "' "
                            + "and  id_parcela = '" + productos_aplicacion_id_parcela + "' "
                            + "and id_zafra = '" + Productos_aplicacion_abm_id_zafra + "' "
                            + "and aplicacion != '2' ");
                    while (rs3.next()) {
                        aplicacion = rs3.getInt(1) + 1;
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO producto_aplicacion VALUES(?,?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id_producto_aplicacion);
                    stUpdateProducto.setInt(2, productos_aplicacion_id_cultivo);
                    stUpdateProducto.setInt(3, productos_aplicacion_id_parcela);
                    stUpdateProducto.setInt(4, Productos_aplicacion_abm_id_zafra);
                    stUpdateProducto.setDate(5, util_Date_to_sql_date(fecha));
                    stUpdateProducto.setInt(6, aplicacion);
                    stUpdateProducto.setInt(7, productos_aplicacion_id_tipo);
                    stUpdateProducto.executeUpdate();

                } else {
                    PreparedStatement st2 = conexion.prepareStatement(""
                            + "UPDATE producto_aplicacion "
                            + "SET id_granos_tipo ='" + productos_aplicacion_id_cultivo + "', "
                            + "id_parcela ='" + productos_aplicacion_id_parcela + "', "
                            + "fecha ='" + util_Date_to_sql_date(fecha) + "', "
                            + "id_zafra ='" + Productos_aplicacion_abm_id_zafra + "' "
                            + "WHERE id_producto_aplicacion = '" + id_producto_aplicacion + "'");
                    st2.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public static boolean Verificar_tabla_ad(int tipo_descuento, double valor, int tipo) {
        error = true;
        try {

            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + valor + "' and id_concepto_tabla_ad='" + tipo_descuento + "' and id_granos_tipo = '" + tipo + "' ");
            while (RS.next()) {
                error = false;
            }

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
        return error;
    }

    public synchronized static void Recepcion_detalle_guardar(String valor) {
        try {

            double valor_double = Double.parseDouble(valor);
            Verificar_tabla_ad(recepcion_id_motivo_de_descuento, valor_double, id_granos_tipo);
            if (error == false) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_recepcion_detalle) FROM recepcion_detalle ");
                if (result.next()) {
                    id_recepcion_detalle = result.getInt(1) + 1;
                }

                double peso_neto = 0;
                double total_descuento = 0;

                double valor_porcentaje = valor_double;
                st1 = conexion.createStatement();
                result = st1.executeQuery("SELECT * FROM recepcion where id_recepcion = '" + id_recepcion + "'");
                if (result.next()) {
                    peso_neto = result.getDouble("peso_neto");
                }

                st1 = conexion.createStatement();
                result = st1.executeQuery(""
                        + "SELECT * FROM tabla_ad "
                        + "where cantidad= '" + valor_double + "'"
                        + "and id_concepto_tabla_ad='" + recepcion_id_motivo_de_descuento + "' and id_granos_tipo = '" + id_granos_tipo + "'");
                while (result.next()) {
                    valor_double = result.getDouble("porcentaje");
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO recepcion_detalle VALUES(?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_recepcion_detalle);
                stUpdateProducto.setInt(2, id_recepcion);
                stUpdateProducto.setInt(3, recepcion_id_motivo_de_descuento);
                stUpdateProducto.setDouble(4, valor_double);
                stUpdateProducto.setDouble(5, peso_neto * valor_double / 100);
                stUpdateProducto.setDouble(6, valor_porcentaje);
                stUpdateProducto.executeUpdate();

            } else {
                JOptionPane.showMessageDialog(null, "ATENCION. El valor ingresado no se encuentra en la tabla de DESCUENTOS.");
            }

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Remitente_guardar(String remitente) {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_remitente) FROM remitente");
            if (result.next()) {
                id_remitente = result.getInt(1) + 1;
            }

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO remitente VALUES(?,?)");
            stUpdateProducto.setInt(1, id_remitente);
            stUpdateProducto.setString(2, remitente);
            stUpdateProducto.executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Compras_guardar() {
        try {

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_facturas_compra) FROM facturas_compra ");
            if (result.next()) {
                id_facturas_compras = result.getInt(1) + 1;
            }

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO facturas_compra VALUES(?,?,?,?,?,?,?,?)");
            stUpdateProducto.setInt(1, id_facturas_compras);
            stUpdateProducto.setString(2, "0");
            stUpdateProducto.setInt(3, 0); // proveedor no especificado
            stUpdateProducto.setDate(4, util_Date_to_sql_date(hoy));
            stUpdateProducto.setLong(5, 1);
            stUpdateProducto.setLong(6, 1);
            stUpdateProducto.setLong(7, 0);
            stUpdateProducto.setLong(8, 1);
            stUpdateProducto.executeUpdate();

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Ventas_detalle_guardar(String precio, String unidad) {
        try {

            double precio_double = Double.valueOf(precio);
            double unidad_double = Double.valueOf(unidad);

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_venta_detalle) FROM venta_detalle");
            if (result.next()) {
                id_venta_detalle = result.getInt(1) + 1;
            }
            int iva = 0;
            st1 = conexion.createStatement();
            result = st1.executeQuery("SELECT * FROM productos where id_producto = '" + ventas_id_producto + "'");
            if (result.next()) {
                if (result.getInt("iva") == 5) {
                    iva = 5;
                }
                if (result.getInt("iva") == 10) {
                    iva = 10;
                }
            }

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO venta_detalle VALUES(?,?,?,?,?,?,?,?,?)");
            stUpdateProducto.setInt(1, id_venta_detalle);
            stUpdateProducto.setDouble(2, precio_double);
            stUpdateProducto.setDouble(3, unidad_double);
            stUpdateProducto.setDouble(4, 0);
            stUpdateProducto.setInt(5, id_venta);
            stUpdateProducto.setInt(6, ventas_id_producto);
            if (iva == 0) {
                stUpdateProducto.setDouble(7, (precio_double * unidad_double));
            } else {
                stUpdateProducto.setDouble(7, 0);
            }
            if (iva == 5) {
                stUpdateProducto.setDouble(8, (precio_double * unidad_double));

            } else {
                stUpdateProducto.setDouble(8, 0);

            }
            if (iva == 10) {
                stUpdateProducto.setDouble(9, (precio_double * unidad_double));
            } else {
                stUpdateProducto.setDouble(9, 0);
            }
            stUpdateProducto.executeUpdate();

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static long Recepcion_total_a_pagar_long(String precio) {
        long total_a_pagar = 0;
        long neto = 0;
        try {
            Statement ST_recepcion = conexion.createStatement();
            ResultSet RS_recepcion = ST_recepcion.executeQuery("SELECT * FROM recepcion where id_recepcion = '" + id_recepcion + "'");
            while (RS_recepcion.next()) {
                neto = RS_recepcion.getLong("total_neto_carga");
            }
            total_a_pagar = Long.parseLong(precio) * neto;

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }

        return total_a_pagar;

    }

//    public static void Ventas_calculo() {
//        try {
//            Statement ST_recepcion = conexion.createStatement();
//            ResultSet RS_recepcion = ST_recepcion.executeQuery(""
//                    + "SELECT sum(total) "
//                    + "FROM venta_detalle "
//                    + "where id_venta = '" + id_venta + "'");
//            while (RS_recepcion.next()) {
//                Ventas.jTextField_total.setText(String.valueOf(RS_recepcion.getDouble(1)));
//            }
//
//        } catch (SQLException ex) {
//          MostrarError(ex, getNombreMetodo());  
//        }
//    }
    public static String Obtener_peso() {
        String peso = "";
        JOptionPane.showMessageDialog(null, "Entrando..");
        try {
            SerialPort serialPort = new SerialPort();
            List<String> lstFreeSerialPort = serialPort.getFreeSerialPort();//Gets a list of serial ports free
            JOptionPane.showMessageDialog(null, "puerto asignado: " + lstFreeSerialPort.get(0));
            Parameters parameters = new Parameters();//Create a parameter object
            parameters.setPort(lstFreeSerialPort.get(0));//assigns the first port found
            parameters.setBaudRate(Baud._4800);//assigns baud rate
            parameters.setByteSize("8");// assigns byte size
            parameters.setParity("N");// assigns parity
            Com com = new Com(parameters);// With the "parameters" creates a "Com"

            int ok = 0;
            int dataReceived = 0;
            for (int i = 0; i < 20; i++) {//Send and receive data every 800 milliseconds
                dataReceived = com.receiveSingleCharAsInteger();
                if (dataReceived > 0) {
                    if (ok == 0) {
                        peso = String.valueOf(dataReceived);
                        ok = 1;
                    }
                }
                JOptionPane.showMessageDialog(null, "Alerta " + String.valueOf(dataReceived));

            }
            com.close();
        } catch (Exception ex) {
            MostrarError(ex, getNombreMetodo());
        }
        return peso;
    }
//
//    public static void Humedad_verificar() {
//        try {
//            error_humedad = true;
//            if (isNumericDouble(Recepcion_ABM.jTextField_humedad.getText().trim())) {
//
//                Statement ST_tabla_ad_humedad = conexion.createStatement();
//                ResultSet RS_tabla_ad_humedad = ST_tabla_ad_humedad.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + Recepcion_ABM.jTextField_humedad.getText() + "' and id_concepto_tabla_ad='1'");
//                while (RS_tabla_ad_humedad.next()) {
//                    error_humedad = false;
//                }
//                if (error_humedad) {
//                    JOptionPane.showMessageDialog(null, "ATENCION. Valor de humedad no encontrado en la tabla AD.");
//                    Recepcion_ABM.jTextField_humedad.setText("");
//                    Recepcion_ABM.jTextField_humedad.requestFocus();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "ATENCION. Valor de humedad.");
//                Recepcion_ABM.jTextField_humedad.requestFocus();
//            }
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

//    public static void Ardidos_verificar() {
//        try {
//            error_ardido = true;
//            if (isNumericDouble(Recepcion_ABM.jTextField_ardidos.getText().trim())) {
//                Statement ST_tabla_ad_ardidos = conexion.createStatement();
//                ResultSet RS_tabla_ad_ardidos = ST_tabla_ad_ardidos.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + Recepcion_ABM.jTextField_ardidos.getText() + "' and id_concepto_tabla_ad='5'");
//                while (RS_tabla_ad_ardidos.next()) {
//                    error_ardido = false;
//                }
//                if (error_ardido) {
//                    JOptionPane.showMessageDialog(null, "ATENCION. Valor de Ardidos no encontrado en la tabla AD.");
//                    Recepcion_ABM.jTextField_ardidos.setText("");
//                    Recepcion_ABM.jTextField_ardidos.requestFocus();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "ATENCION. Valor de Ardidos.");
//                Recepcion_ABM.jTextField_ardidos.requestFocus();
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//    public static void Quebrados_verificar() {
//        try {
//            error_quebrado = true;
//            if (isNumericDouble(Recepcion_ABM.jTextField_g_quebrados.getText().trim())) {
//                Statement ST_tabla_ad_quebrados = conexion.createStatement();
//                ResultSet RS_tabla_ad_quebrados = ST_tabla_ad_quebrados.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + Recepcion_ABM.jTextField_g_quebrados.getText() + "' and id_concepto_tabla_ad='6'");
//                while (RS_tabla_ad_quebrados.next()) {
//                    error_quebrado = false;
//                }
//                if (error_quebrado) {
//                    JOptionPane.showMessageDialog(null, "ATENCION. Valor de Granos Quebrados no encontrado en la tabla AD.");
//                    Recepcion_ABM.jTextField_g_quebrados.setText("");
//                    Recepcion_ABM.jTextField_g_quebrados.requestFocus();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "ATENCION. Valor de Granos Quebrados.");
//                Recepcion_ABM.jTextField_g_quebrados.requestFocus();
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//    public static void Verdes_verificar() {
//        try {
//            error_verdes = true;
//            if (isNumericDouble(Recepcion_ABM.jTextField_g_verdes.getText().trim())) {
//
//                Statement ST_tabla_ad_granos_verdes = conexion.createStatement();
//                ResultSet RS_tabla_ad_granos_verdes = ST_tabla_ad_granos_verdes.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + Recepcion_ABM.jTextField_g_verdes.getText() + "' and id_concepto_tabla_ad='3'");
//                while (RS_tabla_ad_granos_verdes.next()) {
//                    error_verdes = false;
//                }
//                if (error_verdes) {
//                    JOptionPane.showMessageDialog(null, "ATENCION. Valor de Granos Verdes no encontrado en la tabla AD.");
//                    Recepcion_ABM.jTextField_g_verdes.setText("");
//                    Recepcion_ABM.jTextField_g_verdes.requestFocus();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "ATENCION. Valor de Granos Verdes.");
//                Recepcion_ABM.jTextField_g_verdes.requestFocus();
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//    public static void Chuzos_verificar() {
//        try {
//            error_chuzos = true;
//            if (isNumericDouble(Recepcion_ABM.jTextField_chuzos.getText().trim())) {
//
//                Statement ST_tabla_ad_chuzos = conexion.createStatement();
//                ResultSet RS_tabla_ad_chuzos = ST_tabla_ad_chuzos.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + Recepcion_ABM.jTextField_chuzos.getText() + "' and id_concepto_tabla_ad='4'");
//                while (RS_tabla_ad_chuzos.next()) {
//                    error_chuzos = false;
//                }
//                if (error_chuzos) {
//                    JOptionPane.showMessageDialog(null, "ATENCION. Valor de Chuzos no encontrado en la tabla AD.");
//                    Recepcion_ABM.jTextField_chuzos.setText("");
//                    Recepcion_ABM.jTextField_chuzos.requestFocus();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "ATENCION. Valor de Chuzos.");
//                Recepcion_ABM.jTextField_chuzos.requestFocus();
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//    public static void Impurezas_verificar() {
//        try {
//
//            if (isNumericDouble(Recepcion_ABM.jTextField_c_extranhos.getText().trim())) {
//                Statement ST_tabla_ad_impurezas = conexion.createStatement();
//                ResultSet RS_tabla_ad_impurezas = ST_tabla_ad_impurezas.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + Recepcion_ABM.jTextField_c_extranhos.getText() + "' and id_concepto_tabla_ad='2'");
//                while (RS_tabla_ad_impurezas.next()) {
//                    error_impurezas = false;
//                }
//                if (error_impurezas) {
//                    JOptionPane.showMessageDialog(null, "ATENCION. Valor de Cuerpos Extraños no encontrado en la tabla AD.");
//                    Recepcion_ABM.jTextField_c_extranhos.setText("");
//                    Recepcion_ABM.jTextField_c_extranhos.requestFocus();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "ATENCION. Valor de Cuerpos Extraños.");
//                Recepcion_ABM.jTextField_c_extranhos.requestFocus();
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//    
//    public static void Remision_clear() {
//
//        Recepcion_ABM.jLabel1.setText("");
////        Recepcion_ABM.jTextField_tipo.setText("SOJA");
//        Metodos.id_granos_tipo = 0;
//        Recepcion_ABM.jDateChooser_fecha.setDate(hoy);
//        Recepcion_ABM.jDateChooser_inicio.setDate(hoy);
//        Recepcion_ABM.jDateChooser_fin.setDate(hoy);
////        Recepcion_ABM.jTextField_ardidos.setText("0");
//        Recepcion_ABM.jTextField_bruto.setText("");
////        Recepcion_ABM.jTextField_c_extranhos.setText("0");
//        Recepcion_ABM.jTextField_camion.setText("");
//        id_camion = 0;
//        Recepcion_ABM.jTextField_carreta.setText("");
//        id_carreta = 0;
//        Recepcion_ABM.jTextField_chofer.setText("");
//        id_chofer = 0;
////        Recepcion_ABM.jTextField_chuzos.setText("0");
//        Recepcion_ABM.jTextField_cliente.setText("");
//        id_cliente = 0;
//        Recepcion_ABM.jTextField_parcela.setText("");
//        id_parcela = 0;
//        Recepcion_ABM.jTextField_comp_pesaje.setText("");
//        Recepcion_ABM.jTextField_destino.setText("");
////        Recepcion_ABM.jTextField_g_quebrados.setText("0");
////        Recepcion_ABM.jTextField_g_verdes.setText("0");
////        Recepcion_ABM.jTextField_humedad.setText("0");
//        Recepcion_ABM.jTextField_neto.setText("");
//        Recepcion_ABM.jTextField_numero.setText("");
//        Recepcion_ABM.jTextField_origen.setText("");
////        Recepcion_ABM.jTextField_ruc.setText("");
//        Recepcion_ABM.jTextField_tara.setText("0");
//        //    Recepcion_ABM.jTextField_telefono.setText("");
//        Recepcion_ABM.jTextField_tipo.setText("");
//        Recepcion_ABM.jTextField_precio.setText("0");
//        Recepcion_ABM.jTextField_total.setText("0");
//        Recepcion_ABM.jTextField_neto_descuento.setText("0");
//        Recepcion_ABM.jCheckBox_recepcion.setSelected(false);
//        Recepcion_ABM.jCheckBox_remision.setSelected(true);
//
//        Recepcion_ABM.jTextField_numero.requestFocus();
//        id_recepcion = 0;
//
//        Recepcion_ABM.jTextField_moneda.setText("GS");
//        id_moneda = 1;
//
//        Recepcion_ABM.jTextField_motivo.setText("");
//        recepcion_id_motivo = 0;
//
//        Recepcion_ABM.jTextField_zafra.setText("");
//        recepcion_id_zafra = 0;
//
//        Recepcion_ABM.jTextField_variedad.setText("");
//        recepcion_id_variedad = 0;
//
//        recepcion_id_remitente = 1;
//        Recepcion_remitente();
//        Recepcion_ABM.jTextField_remitente.setText(remitente);
//        Recepcion_ABM.jTextField_parcela.requestFocus();
//        Recepcion_ABM.jTextField_remitente.setText(remitente);
//
//        Recepcion_ABM.jButton_borrar.setVisible(false);
//        Recepcion_ABM.jButton_print.setVisible(false);
//
//    }
//
//    public static void Recepcion_MAX() {
//        try {
//
//            Conexion.Verificar_conexion();
//            String sql = "select MAX(id_recepcion) from recepcion";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            if (RS_Productos.next()) {
//                id_recepcion = RS_Productos.getInt(1);
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static int MAX_tabla(String id, String tabla) {
//        dato_int = 0;
//        try {
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery("SELECT MAX(" + id + ") FROM " + tabla + " ");
//            while (rs.next()) {
//                dato_int = rs.getInt(1) + 1;
//            }
//            rs.close();
//            st.close();
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//        return dato_int;
//    }
//
//    public static void Recepcion_remitente() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            String sql = "select * from remitente where id_remitente = '1' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            if (RS_Productos.next()) {
//                remitente = RS_Productos.getString("remitente");
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public synchronized static int Factura_de_compra_Max() {
//        try {
//            ResultSet RS_Productos;
//            try (Statement ST_Productos = conexion.createStatement()) {
//                RS_Productos = ST_Productos.executeQuery("SELECT MAX(id_facturas_compra) from facturas_compra");
//                if (RS_Productos.next()) {
//                    max = RS_Productos.getInt(1);
//                }
//            }
//            RS_Productos.close();
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//
//        return max;
//
//    }
//
//    public synchronized static String getHoy_format2() {
//        Date dNow = new Date();
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String hoy = ft.format(dNow);
//        return hoy;
//    }
//
//    public synchronized static void Compras_clear() {
//        Compras.jT_Proveedor.setText("");
//        Compras.jT_factura_nro.setText("");
//        Compras.jTextField_total.setText("0");
//        id_proveedor = 0;
//        Compras.jButton_borrar.setVisible(false);
//        Compras.jT_factura_nro.requestFocus();
//    }
//
//    public synchronized static void Compras_Verificar_Numero_de_Factura(String numero) {
//        try {
//            if (id_facturas_compras == 0) {
//                boolean factura_registrada = false;
//                if (numero.length() > 1) {
//                    String numero_de_factura_ingresado = numero.trim();
//                    numero_de_factura_ingresado = numero_de_factura_ingresado.replace("-", "");
//                    Statement st1 = conexion.createStatement();
//                    ResultSet result = st1.executeQuery(""
//                            + "SELECT * FROM facturas_compra "
//                            + "where id_comercio = '" + id_comercio + "' "
//                            + "and id_proveedor = '" + id_proveedor + "' "
//                            + "and borrado != '1'");
//                    while (result.next()) {
//                        numero = result.getString("numero").trim();
//                        numero = numero.replace("-", "");
//                        if (numero.equals(numero_de_factura_ingresado)) {
//                            id_facturas_compras = result.getInt("id_facturas_compra");
//                            Compras.jDateChooser.setDate(result.getDate("fecha_date"));
//                            JOptionPane.showMessageDialog(null, "Factura registrada");
//                            RefreshListCompras();
//                            factura_registrada = true;
//                        }
//                    }
//
//                }
//            } else {
//                Compras_actualizar(numero);
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public synchronized static void RefreshListCompras() {
//        DefaultTableModel modelo = (DefaultTableModel) Compras.jTable1.getModel();
//        while (modelo.getRowCount() > 0) {
//            modelo.removeRow(0);
//        }
//        try {
//            PreparedStatement ps = conexion.prepareStatement(""
//                    + "select id_facturas_compra_detalle, nombre, cantidad, facturas_compra_detalle.precio, facturas_compra_detalle.total  "
//                    + "from facturas_compra_detalle "
//                    + "inner join productos "
//                    + "on productos.id_producto = facturas_compra_detalle.id_producto "
//                    + "where id_facturas_compra = '" + id_facturas_compras + "'");
//            ResultSet rs = ps.executeQuery();
//            rsm = rs.getMetaData();
//
//            long total = 0;
//
//            ArrayList<Object[]> data = new ArrayList<>();
//            while (rs.next()) {
//                total = rs.getInt("total") + total;
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs.getObject(i + 1) != null) {
//                        if (rs.getObject(i + 1).toString().length() > 1) {
//                            rows[0] = rs.getObject(1).toString();
//                            rows[1] = rs.getObject(2).toString().trim();
//                            rows[2] = (rs.getObject(3).toString());
//                            if (rs.getObject(4) == null) {
//                            } else {
//                                rows[3] = getSepararMiles(rs.getObject(4).toString());
//                            }
//                            if (rs.getObject(5) == null) {
//                            } else {
//                                rows[4] = getSepararMiles(rs.getObject(5).toString());
//                            }
//                        }
//                    }
//                }
//                data.add(rows);
//            }
//            DefaultTableModel dtm = (DefaultTableModel) Compras.jTable1.getModel();
//            for (int i = 0; i < data.size(); i++) {
//                dtm.addRow(data.get(i));
//            }
//            String strLong = Long.toString(total);
//            String nuevo = DEV.Metodos.getSepararMiles(strLong);
//
//            // -------------- SETEAR VALORES EN FORM
//            Compras.jTextField_total.setText(nuevo);
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static void Recepcion_buscar() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            String sql = "select *, camion.marca as camionmarca, camion.chapa as camionchapa, "
//                    + "carreta.marca as carretamarca, carreta.chapa as carretachapa, chofer.nombre as chonombre "
//                    + "from recepcion "
//                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = recepcion.id_granos_tipo "
//                    + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                    + "inner join camion on camion.id_camion = recepcion.id_camion "
//                    + "inner join carreta on carreta.id_carreta = recepcion.id_carreta "
//                    + "inner join chofer on chofer.id_chofer = recepcion.id_chofer "
//                    + "inner join parcela on parcela.id_parcela = recepcion.id_parcela "
//                    + "inner join moneda on moneda.id_moneda = recepcion.id_moneda "
//                    + "inner join motivo on motivo.id_motivo = recepcion.id_motivo "
//                    + "inner join sucursal on sucursal.id_sucursal = recepcion.id_sucursal "
//                    + "inner join variedad on variedad.id_variedad = recepcion.id_variedad "
//                    + "inner join remitente on remitente.id_remitente = recepcion.id_remitente "
//                    + "inner join zafra on zafra.id_zafra = recepcion.id_zafra "
//                    + "where id_recepcion = '" + id_recepcion + "' "
//                    + "and (recepcion.borrado_int != '1' or recepcion.borrado_int is null)";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            if (RS_Productos.next()) {
//                Recepcion_ABM.jTextField_numero.setText(RS_Productos.getString("numero"));
//                Recepcion_ABM.jDateChooser_fecha.setDate(RS_Productos.getDate("fecha"));
//                Recepcion_ABM.jDateChooser_fin.setDate(RS_Productos.getDate("fecha_salida"));
//                Recepcion_ABM.jDateChooser_inicio.setDate(RS_Productos.getDate("fecha_llegada"));
//                if (RS_Productos.getInt("movimiento") == 1) {
//                    Recepcion_ABM.jCheckBox_recepcion.setSelected(true);
//                    Recepcion_ABM.jCheckBox_remision.setSelected(false);
//                }
//                if (RS_Productos.getInt("movimiento") == 2) {
//                    Recepcion_ABM.jCheckBox_recepcion.setSelected(false);
//                    Recepcion_ABM.jCheckBox_remision.setSelected(true);
//                }
//                Recepcion_ABM.jTextField_tipo.setText(RS_Productos.getString("tipo").trim());
//                Recepcion_ABM.jTextField_cliente.setText(RS_Productos.getString("nombre").trim());
//                if (RS_Productos.getString("ruc") != null) {
////                    Recepcion_ABM.jTextField_ruc.setText(RS_Productos.getString("ruc").trim());
//                }
//                if (RS_Productos.getString("telefono") != null) {
//                    //      Recepcion_ABM.jTextField_telefono.setText(RS_Productos.getString("telefono").trim());
//                }
//                Recepcion_ABM.jTextField_camion.setText(
//                        RS_Productos.getString("camionmarca").trim()
//                        + " - " + RS_Productos.getString("camionchapa").trim());
//                Recepcion_ABM.jTextField_carreta.setText(
//                        RS_Productos.getString("carretamarca").trim()
//                        + " - " + RS_Productos.getString("carretachapa").trim());
//                Recepcion_ABM.jTextField_chofer.setText(RS_Productos.getString("chonombre").trim());
//                Recepcion_ABM.jTextField_comp_pesaje.setText(RS_Productos.getString("comp_pesaje").trim());
//
//                if (RS_Productos.getString("peso_bruto") != null) {
//                    Recepcion_ABM.jTextField_bruto.setText(getSepararMiles(RS_Productos.getString("peso_bruto").trim()));
//                } else {
//                    Recepcion_ABM.jTextField_bruto.setText("0");
//                }
//                if (RS_Productos.getString("peso_tara") != null) {
//                    Recepcion_ABM.jTextField_tara.setText(getSepararMiles(RS_Productos.getString("peso_tara").trim()));
//                } else {
//                    Recepcion_ABM.jTextField_tara.setText("0");
//                }
//                if (RS_Productos.getString("peso_neto") != null) {
//                    Recepcion_ABM.jTextField_neto.setText(getSepararMiles(RS_Productos.getString("peso_neto").trim()));
//                } else {
//                    Recepcion_ABM.jTextField_neto.setText("0");
//                }
//                if (RS_Productos.getString("precio") != null) {
//                    Recepcion_ABM.jTextField_precio.setText(getSepararMiles(RS_Productos.getString("precio").trim()));
//                } else {
//                    Recepcion_ABM.jTextField_precio.setText("0");
//                }
//                DecimalFormat num = new DecimalFormat("#,###.##");
//
//                if (RS_Productos.getString("total_a_pagar") != null) {
//                    Recepcion_ABM.jTextField_total.setText(num.format(Double.parseDouble(RS_Productos.getString("total_a_pagar"))));
//                } else {
//                    Recepcion_ABM.jTextField_total.setText("0");
//                }
//                if (RS_Productos.getString("origen") != null) {
//                    Recepcion_ABM.jTextField_origen.setText(RS_Productos.getString("origen").trim());
//                } else {
//                    Recepcion_ABM.jTextField_origen.setText("0");
//                }
//                if (RS_Productos.getString("origen") != null) {
//                    Recepcion_ABM.jTextField_origen.setText(RS_Productos.getString("origen").trim());
//                } else {
//                    Recepcion_ABM.jTextField_origen.setText("0");
//                }
//                if (RS_Productos.getString("destino") != null) {
//                    Recepcion_ABM.jTextField_destino.setText(RS_Productos.getString("destino").trim());
//                } else {
//                    Recepcion_ABM.jTextField_destino.setText("0");
//                }
////                Recepcion_ABM.jTextField_humedad.setText(RS_Productos.getString("humedad").trim());
////                Recepcion_ABM.jTextField_c_extranhos.setText(RS_Productos.getString("impurezas").trim());
////                Recepcion_ABM.jTextField_g_verdes.setText(RS_Productos.getString("granos_verdes").trim());
////                Recepcion_ABM.jTextField_g_quebrados.setText(RS_Productos.getString("quebrados").trim());
////                Recepcion_ABM.jTextField_ardidos.setText(RS_Productos.getString("ardidos").trim());
////                Recepcion_ABM.jTextField_chuzos.setText(RS_Productos.getString("chuzos").trim());
//                Recepcion_ABM.jTextField_parcela.setText(RS_Productos.getString("parcela"));
//                Recepcion_ABM.jTextField_precio.setText(RS_Productos.getString("precio"));
//                Recepcion_ABM.jTextField_observaciones.setText(RS_Productos.getString("observaciones"));
//                Recepcion_ABM.jTextField_moneda.setText(RS_Productos.getString("moneda"));
//                Recepcion_ABM.jTextField_neto_descuento.setText(getSepararMiles(RS_Productos.getString("total_neto_carga")));
//                Recepcion_ABM.jTextField_motivo.setText((RS_Productos.getString("motivo")));
//                Recepcion_ABM.jTextField_zafra.setText((RS_Productos.getString("zafra")));
//                Recepcion_ABM.jTextField_variedad.setText((RS_Productos.getString("variedad")));
//                Recepcion_ABM.jTextField_remitente.setText((RS_Productos.getString("remitente")));
//                Recepcion_ABM.jLabel1.setText(RS_Productos.getString("sucursal"));
//
//                id_cliente = RS_Productos.getInt("id_cliente");
//                id_parcela = RS_Productos.getInt("id_parcela");
//                id_chofer = RS_Productos.getInt("id_chofer");
//                id_carreta = RS_Productos.getInt("id_carreta");
//                id_camion = RS_Productos.getInt("id_camion");
//                id_granos_tipo = RS_Productos.getInt("id_granos_tipo");
//                id_moneda = RS_Productos.getInt("id_moneda");
//                recepcion_id_motivo = RS_Productos.getInt("id_motivo");
//                recepcion_id_zafra = RS_Productos.getInt("id_zafra");
//                recepcion_id_variedad = RS_Productos.getInt("id_variedad");
//                recepcion_id_remitente = RS_Productos.getInt("id_remitente");
//
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static void Trasnportista_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Transportista_listado.jTable1.getModel();
//            for (int j = 0; j < Transportista_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from transportista "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "and borrado_int != '1'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Transportista_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_detalle_jtable() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_detalle.getModel();
//            for (int j = 0; j < Recepcion_ABM.jTable_detalle.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_recepcion_detalle, concepto, valor_porcentaje, valor, descuento  "
//                    + "from recepcion_detalle "
//                    + "inner join concepto_tabla_ad on concepto_tabla_ad.id_concepto_tabla_ad = recepcion_detalle.id_concepto_tabla_ad "
//                    + "where id_recepcion = '" + id_recepcion + "' "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_detalle.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void TablaAD_concepto_jtable() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) TablaAD.jTable_concepto.getModel();
//            for (int j = 0; j < TablaAD.jTable_concepto.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_concepto_tabla_ad, concepto  "
//                    + "from concepto_tabla_ad "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) TablaAD.jTable_concepto.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Productos_aplicacion_buscar_jtable(String cultivo, String parcela, String zafra) {
//        try {
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_buscar.getModel();
//            for (int j = 0; j < Productos_aplicacion_ABM.jTable_buscar.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_producto_aplicacion, fecha, zafra, parcela, tipo  "
//                    + "from producto_aplicacion "
//                    + "inner join zafra on zafra.id_zafra = producto_aplicacion.id_zafra "
//                    + "inner join parcela on parcela.id_parcela = producto_aplicacion.id_parcela "
//                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = producto_aplicacion.id_granos_tipo "
//                    + "where granos_tipo.tipo ilike '%" + cultivo + "%' "
//                    + "and zafra ilike '%" + zafra + "%' "
//                    + "and parcela ilike '%" + parcela + "%' "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_buscar.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Productos_aplicacion_detalle_jtable() {
//        try {
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_detalle.getModel();
//            for (int j = 0; j < Productos_aplicacion_ABM.jTable_detalle.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_producto_aplicacion_detalle, nombre, dosis, total  "
//                    + "from producto_aplicacion_detalle "
//                    + "inner join productos on productos.id_producto = producto_aplicacion_detalle.id_producto "
//                    + "where id_producto_aplicacion = '" + id_producto_aplicacion + "' "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_detalle.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Productos_aplicacion_abm_productos_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_productos.getModel();
//            for (int j = 0; j < Productos_aplicacion_ABM.jTable_productos.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_producto, nombre  "
//                    + "from productos "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_productos.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Productos_aplicacion_abm_zafra_jtable() {
//        try {
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_zafra.getModel();
//            for (int j = 0; j < Productos_aplicacion_ABM.jTable_zafra.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_zafra, zafra  "
//                    + "from zafra "
//                    + "order by zafra");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_zafra.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static void Productos_aplicacion_abm_cultivo_jtable() {
//        try {
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_cultivo.getModel();
//            for (int j = 0; j < Productos_aplicacion_ABM.jTable_cultivo.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_granos_tipo, tipo  "
//                    + "from granos_tipo "
//                    + "order by tipo ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_cultivo.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static void Productos_aplicacion_parcela_jtable(String buscar) {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_parcela.getModel();
//            for (int j = 0; j < Productos_aplicacion_ABM.jTable_parcela.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_parcela, parcela  "
//                    + "from parcela "
//                    + "where parcela ilike '%" + buscar + "%' "
//                    + "order by parcela ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_parcela.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Compras_detalle_jtable() {
//        try {
//            dtm = (DefaultTableModel) Compras.jTable1.getModel();
//            for (int j = 0; j < Compras.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_facturas_compra_detalle, nombre, unidades, facturas_compra_detalle.precio as precio "
//                    + "from facturas_compra_detalle "
//                    + "inner join productos on productos.id_producto = facturas_compra_detalle.id_producto "
//                    + "where id_facturas_compra = '" + id_facturas_compras + "'  "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Compras.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Compras_buscar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Compras.jTable_buscar.getModel();
//            for (int j = 0; j < Compras.jTable_buscar.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_facturas_compra, nombre, numero, fecha, total "
//                    + "from facturas_compra "
//                    + "inner join proveedor on proveedor.id_proveedor = facturas_compra.id_proveedor "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "order by fecha, numero ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Compras.jTable_buscar.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Consultas_jtable(Date desde, Date hasta) {
//        try {
//            if (desde != null && hasta != null) {
//
//                String sql = "";
//                if (consultas_id_estado == 0) {
//                    sql = "select sum(total_neto_carga) "
//                            + "from recepcion "
//                            + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                            + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                            + "where recepcion.id_cliente = '" + consultas_id_cliente + "' "
//                            + "and fecha >= '" + desde + "' "
//                            + "and fecha <= '" + hasta + "' "
//                            + "and recepcion.borrado_int != '1' "
//                            + "and movimiento = '1' "
//                            + "and seleccionado != '1'";
//                } else {
//                    sql = "select sum(total_neto_carga) "
//                            + "from recepcion "
//                            + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                            + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                            + "where recepcion.id_cliente = '" + consultas_id_cliente + "' "
//                            + "and fecha >= '" + desde + "' "
//                            + "and fecha <= '" + hasta + "' "
//                            + "and recepcion.borrado_int != '1' "
//                            + "and movimiento = '1' "
//                            + "and recepcion.id_recepcion_estado = '" + consultas_id_estado + "'"
//                            + "and seleccionado != '1'";
//
//                }
//
//                Statement ST_Productos = conexion.createStatement();
//                ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//                if (RS_Productos.next()) {
//                    Consultas.jTextField_total.setText(RS_Productos.getString(1));
//                }
//
//                dtm = (DefaultTableModel) Consultas.jTable_movimientos.getModel();
//                for (int j = 0; j < Consultas.jTable_movimientos.getRowCount(); j++) {
//                    dtm.removeRow(j);
//                    j -= 1;
//                }
//
//                sql = ""
//                        + "select id_recepcion, numero, nombre, movimiento_string, recepcion_estado.estado, fecha, peso_neto, total_descuento, total_neto_carga "
//                        + "from recepcion "
//                        + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                        + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                        + "where recepcion.id_cliente = '" + consultas_id_cliente + "' "
//                        + "and fecha >= '" + desde + "' "
//                        + "and fecha <= '" + hasta + "' "
//                        + "and movimiento = '1' "
//                        + "and seleccionado != '1'";
//
//                if (consultas_id_estado != 0) {
//                    sql = ""
//                            + "select id_recepcion, numero, nombre, movimiento_string, recepcion_estado.estado, fecha, peso_neto, total_descuento, total_neto_carga "
//                            + "from recepcion "
//                            + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                            + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                            + "where recepcion.id_cliente = '" + consultas_id_cliente + "' "
//                            + "and fecha >= '" + desde + "' "
//                            + "and fecha <= '" + hasta + "' "
//                            + "and recepcion.borrado_int != '1' "
//                            + "and recepcion.id_recepcion_estado = '" + consultas_id_estado + "'"
//                            + "and movimiento = '1' "
//                            + "and seleccionado != '1'";
//                }
//
//                PreparedStatement ps2 = conexion.prepareStatement(sql);
//                ResultSet rs2 = ps2.executeQuery();
//                rsm = rs2.getMetaData();
//                ArrayList<Object[]> data2 = new ArrayList<>();
//                while (rs2.next()) {
//                    Object[] rows = new Object[rsm.getColumnCount()];
//                    for (int i = 0; i < rows.length; i++) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                    data2.add(rows);
//                }
//                dtm = (DefaultTableModel) Consultas.jTable_movimientos.getModel();
//                for (int i = 0; i < data2.size(); i++) {
//                    dtm.addRow(data2.get(i));
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Consultas_seleccionado_jtable(Date desde, Date hasta) {
//        try {
//            if (desde != null && hasta != null) {
//
//                String sql = "select sum(total_neto_carga) "
//                        + "from recepcion "
//                        + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                        + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                        + "where recepcion.id_cliente = '" + consultas_id_cliente + "' "
//                        + "and seleccionado = '1' "
//                        + "and fecha >= '" + desde + "' "
//                        + "and fecha <= '" + hasta + "' "
//                        + "and recepcion.borrado_int != '1' ";
//
//                Statement ST_Productos = conexion.createStatement();
//                ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//                if (RS_Productos.next()) {
//                    Consultas.jTextField_seleccionado.setText(RS_Productos.getString(1));
//                }
//
//                dtm = (DefaultTableModel) Consultas.jTable_seleccionados.getModel();
//                for (int j = 0; j < Consultas.jTable_seleccionados.getRowCount(); j++) {
//                    dtm.removeRow(j);
//                    j -= 1;
//                }
//                PreparedStatement ps2 = conexion.prepareStatement(""
//                        + "select id_recepcion, numero, nombre, movimiento_string, recepcion_estado.estado, fecha, peso_neto, total_descuento, total_neto_carga "
//                        + "from recepcion "
//                        + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                        + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                        + "where recepcion.id_cliente = '" + consultas_id_cliente + "' "
//                        + "and seleccionado = '1' "
//                        + "and fecha >= '" + desde + "' "
//                        + "and fecha <= '" + hasta + "' "
//                        + "and recepcion.borrado_int != '1' ");
//                ResultSet rs2 = ps2.executeQuery();
//                rsm = rs2.getMetaData();
//                ArrayList<Object[]> data2 = new ArrayList<>();
//                while (rs2.next()) {
//                    Object[] rows = new Object[rsm.getColumnCount()];
//                    for (int i = 0; i < rows.length; i++) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                    data2.add(rows);
//                }
//                dtm = (DefaultTableModel) Consultas.jTable_seleccionados.getModel();
//                for (int i = 0; i < data2.size(); i++) {
//                    dtm.addRow(data2.get(i));
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Personales_pagos_empleados_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_empleado.getModel();
//            for (int j = 0; j < Personales_pagos_ABM.jTable_empleado.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_empleado, nombre "
//                    + "from empleado "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_empleado.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Pago_salario_mes_jtable() {
//        try {
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_mes.getModel();
//            for (int j = 0; j < Personales_pagos_ABM.jTable_mes.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from mes "
//                    + "order by id_mes");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_mes.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void TablaAD_tipo_jtable() {
//        try {
//            dtm = (DefaultTableModel) TablaAD.jTable_tipo.getModel();
//            for (int j = 0; j < TablaAD.jTable_tipo.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from granos_tipo "
//                    + "order by granos_tipo");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) TablaAD.jTable_tipo.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Liquidaciones_multiples_moneda_jtable() {
//        try {
//            dtm = (DefaultTableModel) Liquidaciones_multiples.jTable_moneda.getModel();
//            for (int j = 0; j < Liquidaciones_multiples.jTable_moneda.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from moneda "
//                    + "order by moneda");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Liquidaciones_multiples.jTable_moneda.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Liquidaciones_multiples_recepciones_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Liquidaciones_multiples.jTable_recepciones.getModel();
//            for (int j = 0; j < Liquidaciones_multiples.jTable_recepciones.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + " select id_recepcion, nombre, fecha, total_neto_carga "
//                    + " from recepcion "
//                    + " inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                    + " where recepcion.borrado != '1' "
//                    + " and nombre ilike '%" + buscar + "%' and seleccionado = '0' "
//                    + " order by id_recepcion DESC ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Liquidaciones_multiples.jTable_recepciones.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recibo_de_dinero_recibos_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Recibo_de_dinero.jTable_recibos.getModel();
//            for (int j = 0; j < Recibo_de_dinero.jTable_recibos.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + " select id_recibo, nombre, fecha, cantidad "
//                    + " from recibo "
//                    + " inner join cliente on cliente.id_cliente = recibo.id_cliente "
//                    + " where nombre ilike '%" + buscar + "%' "
//                    + " order by fecha DESC ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1);
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recibo_de_dinero.jTable_recibos.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Liquidaciones_multiples_Seleccionado_jtable() {
//        try {
//            Liquidaciones_multiples.jTextField1.setText("0");
//
//            long total_neto_carga = 0;
//            Statement ST_26 = conexion.createStatement();
//            ResultSet RS_26 = ST_26.executeQuery(""
//                    + " select SUM(total_neto_carga) "
//                    + " from recepcion "
//                    + " where seleccionado = '1' "
//                    + " ");
//            while (RS_26.next()) {
//                total_neto_carga = RS_26.getLong(1);
//            }
//
//            Liquidaciones_multiples.jTextField1.setText(getSepararMiles(String.valueOf(total_neto_carga)));
//
//            dtm = (DefaultTableModel) Liquidaciones_multiples.jTable_seleccionadas.getModel();
//            for (int j = 0; j < Liquidaciones_multiples.jTable_seleccionadas.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + " select id_recepcion, nombre, fecha, total_neto_carga "
//                    + " from recepcion "
//                    + " inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                    + " where seleccionado = '1' "
//                    + " order by fecha ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Liquidaciones_multiples.jTable_seleccionadas.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_tipo_jtable() {
//        try {
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_tipo.getModel();
//            for (int j = 0; j < Recepcion_ABM.jTable_tipo.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from granos_tipo "
//                    + "order by tipo");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_tipo.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Personales_pagos_sueldo_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_sueldos.getModel();
//            for (int j = 0; j < Personales_pagos_ABM.jTable_sueldos.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_sueldo, nombre, mes, anho, total "
//                    + "from sueldo "
//                    + "inner join empleado on empleado.id_empleado = sueldo.id_empleado "
//                    + "inner join mes on mes.id_mes = sueldo.id_mes "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "order by id_sueldo");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_sueldos.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Sueldo_detalle_jtable() {
//        try {
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_detalle.getModel();
//            for (int j = 0; j < Personales_pagos_ABM.jTable_detalle.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_sueldo_detalle, concepto_de_pago, importe, importe "
//                    + "from sueldo_detalle "
//                    + "inner join concepto_de_pago on concepto_de_pago.id_concepto_de_pago = sueldo_detalle.id_concepto_de_pago "
//                    + "where id_sueldo = '" + id_sueldo + "'"
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[0] = rs2.getObject(1).toString();
//                    rows[1] = rs2.getObject(2).toString().trim();
//                    if (Long.parseLong(rs2.getObject(3).toString()) > 0) {
//                        rows[2] = "0";
//                        rows[3] = rs2.getObject(3).toString();
//                    }
//                    if (Long.parseLong(rs2.getObject(3).toString()) < 0) {
//                        rows[2] = rs2.getObject(3).toString();
//                        rows[3] = "0";
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_detalle.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Personales_pagos_conceptos_jtable() {
//        try {
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_concepto.getModel();
//            for (int j = 0; j < Personales_pagos_ABM.jTable_concepto.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from concepto_de_pago "
//                    + "order by concepto_de_pago");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Personales_pagos_ABM.jTable_concepto.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Compras_proveedor_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Compras.jTable_proverdor.getModel();
//            for (int j = 0; j < Compras.jTable_proverdor.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_proveedor, nombre "
//                    + "from proveedor "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "order by nombre ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Compras.jTable_proverdor.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Compras_producto_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Compras.jTable_producto.getModel();
//            for (int j = 0; j < Compras.jTable_producto.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_producto, nombre "
//                    + "from productos "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "and borrado != '1'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Compras.jTable_producto.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Listado_recepcion_remitente_jtable() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Listado_recepciones_remitente.jTable_remitente.getModel();
//            for (int j = 0; j < Listado_recepciones_remitente.jTable_remitente.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from remitente ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Listado_recepciones_remitente.jTable_remitente.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Tecnologia_cargar_jtable() {
//        try {
//            dtm = (DefaultTableModel) Tecnologia.jTable_tecnologia.getModel();
//            for (int j = 0; j < Tecnologia.jTable_tecnologia.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_variedad, variedad, tipo "
//                    + "from variedad "
//                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = variedad.id_granos_tipo  ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Tecnologia.jTable_tecnologia.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Ventas_detalle_jtable() {
//        try {
//            dtm = (DefaultTableModel) Ventas.jTable_detalle.getModel();
//            for (int j = 0; j < Ventas.jTable_detalle.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_venta_detalle, nombre, unidad, venta_detalle.precio, exentas, cinco, diez "
//                    + "from venta_detalle "
//                    + "inner join productos on productos.id_producto = venta_detalle.id_producto "
//                    + "where id_venta = '" + id_venta + "' ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Ventas.jTable_detalle.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Ventas_buscar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Ventas.jTable_ventas.getModel();
//            for (int j = 0; j < Ventas.jTable_ventas.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_venta, nombre, fecha, total "
//                    + "from venta "
//                    + "inner join cliente on cliente.id_cliente = venta.id_cliente "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    } else {
//                        rows[i] = rs2.getObject(i + 1);
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Ventas.jTable_ventas.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Ventas_cliente_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Ventas.jTable_cliente.getModel();
//            for (int j = 0; j < Ventas.jTable_cliente.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_cliente, nombre "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    } else {
//                        rows[i] = rs2.getObject(i + 1);
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Ventas.jTable_cliente.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Ventas_moneda_jtable() {
//        try {
//            dtm = (DefaultTableModel) Ventas.jTable_moneda.getModel();
//            for (int j = 0; j < Ventas.jTable_moneda.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from moneda ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Ventas.jTable_moneda.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Ventas_agregar_producto_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Ventas.jTable_productos.getModel();
//            for (int j = 0; j < Ventas.jTable_productos.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_producto, nombre, precio "
//                    + "from productos "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "and borrado != '1'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Ventas.jTable_productos.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Configuracion_sucursal_jtable() {
//        try {
//            dtm = (DefaultTableModel) Configuracion.jTable_sucursal.getModel();
//            for (int j = 0; j < Configuracion.jTable_sucursal.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from sucursal where id_sucursal = '" + id_sucursal + "' ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1);
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Configuracion.jTable_sucursal.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Listado_recepciones_sucursal_jtable() {
//        try {
//            dtm = (DefaultTableModel) Listado_recepciones.jTable_sucursal.getModel();
//            for (int j = 0; j < Listado_recepciones.jTable_sucursal.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from sucursal ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Listado_recepciones.jTable_sucursal.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Contratos_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Contratos.jTable_contratos.getModel();
//            for (int j = 0; j < Contratos.jTable_contratos.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_contrato, nombre "
//                    + "from contrato "
//                    + "inner join cliente on cliente.id_cliente = contrato.id_cliente "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Contratos.jTable_contratos.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Tickets_jtable() {
//        try {
//            dtm = (DefaultTableModel) Tickets.jTable1.getModel();
//            for (int j = 0; j < Tickets.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_recepcion, fecha, nombre, peso_bruto, peso_tara, peso_neto "
//                    + "from recepcion inner join cliente on recepcion.id_cliente = cliente.id_cliente "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Tickets.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Contratos_recepcion_contratos_jtable() {
//        try {
//            dtm = (DefaultTableModel) Contratos_recepcion.jTable_contratos.getModel();
//            for (int j = 0; j < Contratos_recepcion.jTable_contratos.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_contrato, nro, fecha, tonelada, premio, estado_str "
//                    + "from contrato "
//                    + "where id_cliente = '" + contrato_recepcion_id_cliente + "' "
//                    + "and id_zafra = '" + contrato_recepcion_id_zafra + "' "
//                    + "order by id_contrato DESC");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Contratos_recepcion.jTable_contratos.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Contratos_recepcion_recepciones_jtable() {
//        try {
//            dtm = (DefaultTableModel) Contratos_recepcion.jTable_recepciones.getModel();
//            for (int j = 0; j < Contratos_recepcion.jTable_recepciones.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_recepcion, fecha, peso_neto, total_neto_carga, recepcion_estado.estado as recepcion_estado, precio, total_a_pagar "
//                    + "from recepcion "
//                    + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                    + ""
//                    + "where id_cliente = '" + contrato_recepcion_id_cliente + "' "
//                    + "and id_zafra = '" + contrato_recepcion_id_zafra + "' "
//                    + " and peso_neto > '0' "
//                    + "and recepcion.borrado_int != '1' ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (isNumericDouble(rs2.getObject(i + 1).toString())) {
//                        //rows[i] = (rs2.getObject(i + 1).toString().trim());
//
//                        double total_double = Double.parseDouble(rs2.getObject(i + 1).toString());
//
//                        if (total_double > 1000000) {
//                            long total_long = (long) total_double;
//
//                            String total_long_str = getSepararMiles((String.valueOf(total_long)));
//                            rows[i] = total_long_str;
//
//                        } else {
//                            rows[i] = rs2.getObject(i + 1).toString();
//                        }
//
//                    } else {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Contratos_recepcion.jTable_recepciones.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Contratos_recepcion_calculo() {
//        try {
//
//            double toneladas_cumplidas = 0;
//            Statement ST_26 = conexion.createStatement();
//            ResultSet RS_26 = ST_26.executeQuery(""
//                    + "select SUM(tonelada) "
//                    + "from contrato "
//                    + "where id_cliente = '" + contrato_recepcion_id_cliente + "' "
//                    + "and id_zafra = '" + contrato_recepcion_id_zafra + "' "
//                    + "and estado = '2' "
//                    + " ");
//            while (RS_26.next()) {
//                toneladas_cumplidas = RS_26.getDouble(1) + toneladas_cumplidas;
//            }
//
//            double toneladas = 0;
//            Statement ST_2 = conexion.createStatement();
//            ResultSet RS_2 = ST_2.executeQuery(""
//                    + "select SUM(tonelada) "
//                    + "from contrato "
//                    + "where id_cliente = '" + contrato_recepcion_id_cliente + "' "
//                    + "and id_zafra = '" + contrato_recepcion_id_zafra + "' "
//                    + " ");
//            while (RS_2.next()) {
//                toneladas = RS_2.getDouble(1) + toneladas;
//            }
//
//            Statement ST_tabla_ad_humedad = conexion.createStatement();
//            ResultSet RS_tabla_ad_humedad = ST_tabla_ad_humedad.executeQuery(""
//                    + "select SUM(total_neto_carga) "
//                    + "from recepcion "
//                    + "where id_cliente = '" + contrato_recepcion_id_cliente + "' "
//                    + "and id_zafra = '" + contrato_recepcion_id_zafra + "' "
//                    + " and peso_neto > '0' "
//                    + "and borrado != '1' ");
//            while (RS_tabla_ad_humedad.next()) {
//                double total = RS_tabla_ad_humedad.getDouble(1) / 1000;
//
//                Contratos_recepcion.jTextField_total.setText(String.format("%,4g%n", (total - toneladas_cumplidas)));
//                Contratos_recepcion.jTextField_faltante.setText(String.format("%,4g%n", (toneladas - total)));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Contrato_recepcion_cliente_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Contratos_recepcion.jTable_cliente.getModel();
//            for (int j = 0; j < Contratos_recepcion.jTable_cliente.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_cliente, nombre "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by nombre ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    } else {
//                        rows[i] = rs2.getObject(i + 1);
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Contratos_recepcion.jTable_cliente.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Contrato_recepcion_zafra_jtable() {
//        try {
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Contratos_recepcion.jTable_zafra.getModel();
//            for (int j = 0; j < Contratos_recepcion.jTable_zafra.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_zafra, zafra "
//                    + "from zafra "
//                    + "order by zafra ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    } else {
//                        rows[i] = rs2.getObject(i + 1);
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Contratos_recepcion.jTable_zafra.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Contrato_zafra_jtable() {
//        try {
//            dtm = (DefaultTableModel) Contratos.jTable_zafra.getModel();
//            for (int j = 0; j < Contratos.jTable_zafra.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from zafra "
//                    + " order by zafra");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Contratos.jTable_zafra.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Combustible_uso_vehiculo_jtable() {
//        try {
//            dtm = (DefaultTableModel) Combustible_uso.jTable_vehiculo.getModel();
//            for (int j = 0; j < Combustible_uso.jTable_vehiculo.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_vehiculo, tipo, modelo, descripcion "
//                    + "from vehiculo "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Combustible_uso.jTable_vehiculo.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Consultas_cliente_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Consultas.jTable_clientes.getModel();
//            for (int j = 0; j < Consultas.jTable_clientes.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_cliente, nombre "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "and borrado_int != '1' "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Consultas.jTable_clientes.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Combustible_uso_personales_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Combustible_uso.jTable_personales.getModel();
//            for (int j = 0; j < Combustible_uso.jTable_personales.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_empleado, nombre "
//                    + "from empleado "
//                    + "where nombre ilike '%" + buscar + "%'"
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Combustible_uso.jTable_personales.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Combustible_uso_clientes_jtable() {
//        try {
//            dtm = (DefaultTableModel) Combustible_venta.jTable_clientes.getModel();
//            for (int j = 0; j < Combustible_venta.jTable_clientes.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_cliente, nombre "
//                    + "from cliente "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Combustible_venta.jTable_clientes.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Combustible_venta_buscar() {
//        try {
//            dtm = (DefaultTableModel) Combustible_venta.jTable_buscar.getModel();
//            for (int j = 0; j < Combustible_venta.jTable_buscar.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_combustible_venta, nombre, litros, fecha, descripcion "
//                    + "from combustible_venta "
//                    + "inner join cliente on cliente.id_cliente = combustible_venta.id_cliente "
//                    + "order by fecha DESC");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Combustible_venta.jTable_buscar.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Vehiculos_jtable() {
//        try {
//            dtm = (DefaultTableModel) Vehiculo.jTable_vehiculos.getModel();
//            for (int j = 0; j < Vehiculo.jTable_vehiculos.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_vehiculo, marca, modelo, descripcion  "
//                    + "from vehiculo "
//                    + "where id_vehiculo > '0'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1);
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Vehiculo.jTable_vehiculos.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Contrato_cliente_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Contratos.jTable_cliente.getModel();
//            for (int j = 0; j < Contratos.jTable_cliente.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    } else {
//                        rows[i] = rs2.getObject(i + 1);
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Contratos.jTable_cliente.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Listado_recepciones_pendientes_cliente_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Listado_recepciones_pendientes.jTable_cliente.getModel();
//            for (int j = 0; j < Listado_recepciones_pendientes.jTable_cliente.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_cliente, nombre "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "and borrado_int != '1'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Listado_recepciones_pendientes.jTable_cliente.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_motivo_jtable() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_motivo.getModel();
//            for (int j = 0; j < Recepcion_ABM.jTable_motivo.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from motivo "
//                    + "order by motivo");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_motivo.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_motivo_de_descuento_jtable() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_motivo_de_descuento.getModel();
//            for (int j = 0; j < Recepcion_ABM.jTable_motivo_de_descuento.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select distinct (concepto_tabla_ad.id_concepto_tabla_ad), concepto "
//                    + "from concepto_tabla_ad "
//                    + "inner join tabla_ad on tabla_ad.id_concepto_tabla_ad = concepto_tabla_ad.id_concepto_tabla_ad "
//                    + "where id_granos_tipo = '" + id_granos_tipo + "'"
//                    + "order by concepto ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_motivo_de_descuento.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_variedad_jtable() {
//        try {
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_variedad.getModel();
//            for (int j = 0; j < Recepcion_ABM.jTable_variedad.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from variedad "
//                    + "order by variedad");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_variedad.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_zafra_jtable() {
//        try {
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_zafra.getModel();
//            for (int j = 0; j < Recepcion_ABM.jTable_zafra.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from zafra "
//                    + "order by zafra");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_zafra.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_remitente_jtable() {
//        try {
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_remitente.getModel();
//            for (int j = 0; j < Recepcion_ABM.jTable_remitente.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from remitente "
//                    + "order by remitente");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_ABM.jTable_remitente.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_mondea_jtable() {
//        try {
//            dtm = (DefaultTableModel) Recepcion_Moneda_listado.jTable1.getModel();
//            for (int j = 0; j < Recepcion_Moneda_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from moneda ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_Moneda_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_granos_tipo_jtable() {
//        try {
//            dtm = (DefaultTableModel) Recepcion_productos_tipo.jTable1.getModel();
//            for (int j = 0; j < Recepcion_productos_tipo.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from granos_tipo ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_productos_tipo.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_listado_jtable(String buscar) {
//        try {
//            String sql = "";
//            dtm = (DefaultTableModel) Recepcion_listado.jTable1.getModel();
//            for (int j = 0; j < Recepcion_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//
//            if (privilegio == 1) {
//                sql = ""
//                        + "select id_recepcion, numero, nombre, movimiento_string, fecha,  tipo, parcela, recepcion_estado.estado as recepcionestado, sucursal "
//                        + "from recepcion "
//                        + "inner join parcela on parcela.id_parcela = recepcion.id_parcela "
//                        + "inner join sucursal on sucursal.id_sucursal = recepcion.id_sucursal "
//                        + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                        + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                        + "inner join granos_tipo on granos_tipo.id_granos_tipo = recepcion.id_granos_tipo "
//                        + "where (recepcion.borrado != 'SI' "
//                        + "and recepcion.borrado_int != '1' "
//                        + "or recepcion.borrado_int is null) "
//                        + "and nombre ilike '%" + buscar + "%' "
//                        + "order by id_recepcion DESC ";
//            }
//            if (privilegio == 2) {
//                sql = ""
//                        + "select id_recepcion, numero, nombre, movimiento_string, fecha,  tipo, parcela, recepcion_estado.estado as recepcionestado, sucursal "
//                        + "from recepcion "
//                        + "inner join parcela on parcela.id_parcela = recepcion.id_parcela "
//                        + "inner join sucursal on sucursal.id_sucursal = recepcion.id_sucursal "
//                        + "inner join cliente on cliente.id_cliente = recepcion.id_cliente "
//                        + "inner join recepcion_estado on recepcion_estado.id_recepcion_estado = recepcion.id_recepcion_estado "
//                        + "inner join granos_tipo on granos_tipo.id_granos_tipo = recepcion.id_granos_tipo "
//                        + "where (recepcion.borrado != 'SI' "
//                        + "and recepcion.borrado_int != '1' "
//                        + "or recepcion.borrado_int is null) "
//                        + "and nombre ilike '%" + buscar + "%' "
//                        + "and recepcion.id_sucursal = '" + id_sucursal + "' "
//                        + "order by id_recepcion DESC ";
//            }
//
//            PreparedStatement ps2 = conexion.prepareStatement(sql);
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Tabla_AD_jtable() {
//        try {
//            dtm = (DefaultTableModel) Tabla_AD_listado.jTable1.getModel();
//            for (int j = 0; j < Tabla_AD_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_tablaad, tipo, concepto, cantidad, porcentaje, ad "
//                    + "from tabla_ad "
//                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = tabla_ad.id_granos_tipo "
//                    + "inner join concepto_tabla_ad on concepto_tabla_ad.id_concepto_tabla_ad = tabla_ad.id_concepto_tabla_ad "
//                    + "order by tipo, concepto, cantidad");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Tabla_AD_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Stock_de_granos() {
//        try {
//            cant = 0;
//            cant_san_rafael = 0;
//
//            dtm = (DefaultTableModel) Stock.jTable_stock.getModel();
//            for (int j = 0; j < Stock.jTable_stock.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select distinct recepcion.id_granos_tipo, tipo, tipo, sucursal from recepcion "
//                    + "inner join sucursal on sucursal.id_sucursal = recepcion.id_sucursal "
//                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = recepcion.id_granos_tipo "
//                    + "where recepcion.borrado_int != '1' "
//                    + " ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//
//                    Statement ST_Recepcion = conexion.createStatement();
//                    ResultSet RS_Recepcion = ST_Recepcion.executeQuery(""
//                            + "select * from recepcion "
//                            + "inner join sucursal on sucursal.id_sucursal = recepcion.id_sucursal "
//                            + "where id_granos_tipo='" + rs2.getObject(1) + "' "
//                            + "and borrado_int != '1' "
//                            + " ");
//                    while (RS_Recepcion.next()) {
////                    if (privilegio == 1) {
//                        if (RS_Recepcion.getLong("movimiento") == 1 && RS_Recepcion.getLong("id_sucursal") == 1) {
//                            cant = RS_Recepcion.getLong("total_neto_carga") + cant;
//                        }
//                        if (RS_Recepcion.getLong("movimiento") == 2 && RS_Recepcion.getLong("id_sucursal") == 1) {
//                            cant = cant - RS_Recepcion.getLong("total_neto_carga");
//                        }
////                    }
////                    if (RS_Recepcion.getLong("movimiento") == 1 && RS_Recepcion.getLong("id_sucursal") == 2) {
////                        cant_san_rafael = RS_Recepcion.getLong("peso_neto") + cant_san_rafael;
////                    }
////                    if (RS_Recepcion.getLong("movimiento") == 2 && RS_Recepcion.getLong("id_sucursal") == 2) {
////                        cant_san_rafael = cant_san_rafael - RS_Recepcion.getLong("peso_neto");
////                    }
//
//                    }
//
//                    rows[0] = rs2.getObject(1);
//                    rows[1] = rs2.getObject(2).toString().trim();
//                    rows[2] = cant;
//                    rows[3] = rs2.getObject(4);
//                    cant = 0;
//
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Stock.jTable_stock.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//
//            String cantidad = Long.toString(cant);
////            Stock.jTextField_stock.setText(getSepararMiles(cantidad));
//
//            String cantidad_san_rafael = Long.toString(cant_san_rafael);
////            Stock.jTextField_stock_san_rafael.setText(getSepararMiles(cantidad_san_rafael));
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Stock_de_Combustible() {
//        try {
//            long cant_litros_entrada = 0;
//            long cant_litros_salida = 0;
//            Statement ST_Granos_Tipo = conexion.createStatement();
//            ResultSet RS_Granos_Tipo = ST_Granos_Tipo.executeQuery("select SUM(litros) from combustible where id_sucursal = '1'");
//            while (RS_Granos_Tipo.next()) {
//                cant_litros_entrada = RS_Granos_Tipo.getLong(1);
//            }
//            Statement ST_Recepcion = conexion.createStatement();
//            ResultSet RS_Recepcion = ST_Recepcion.executeQuery("select SUM(litros) from combustible_uso where id_sucursal = '1'");
//            while (RS_Recepcion.next()) {
//                cant_litros_salida = RS_Recepcion.getLong(1);
//
//            }
//
//            String cantidad = Long.toString(cant_litros_entrada - cant_litros_salida);
//            Stock_combustible.jTextField_stock.setText(getSepararMiles(cantidad));
//
//            cant_litros_entrada = 0;
//            cant_litros_salida = 0;
//            ST_Granos_Tipo = conexion.createStatement();
//            RS_Granos_Tipo = ST_Granos_Tipo.executeQuery("select SUM(litros) from combustible where id_sucursal = '2'");
//            while (RS_Granos_Tipo.next()) {
//                cant_litros_entrada = RS_Granos_Tipo.getLong(1);
//            }
//            ST_Recepcion = conexion.createStatement();
//            RS_Recepcion = ST_Recepcion.executeQuery("select SUM(litros) from combustible_uso where id_sucursal = '2'");
//            while (RS_Recepcion.next()) {
//                cant_litros_salida = RS_Recepcion.getLong(1);
//            }
//
//            cantidad = Long.toString(cant_litros_entrada - cant_litros_salida);
//            Stock_combustible.jTextField_stock_san_rafael.setText(getSepararMiles(cantidad));
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Stock_de_granos2() {
//        try {
//            cant = 0;
//            Statement ST_Granos_Tipo = conexion.createStatement();
//            ResultSet RS_Granos_Tipo = ST_Granos_Tipo.executeQuery("select * from granos_tipo where borrado != '1'");
//            while (RS_Granos_Tipo.next()) {
//                Statement ST_Recepcion = conexion.createStatement();
//                ResultSet RS_Recepcion = ST_Recepcion.executeQuery(""
//                        + "select * from recepcion "
//                        + "where id_granos_tipo='" + RS_Granos_Tipo.getInt("id_granos_tipo") + "' "
//                        + "and borrado_int != '1' and id_sucursal = '" + id_sucursal_selected + "'  ");
//                while (RS_Recepcion.next()) {
//                    if (RS_Recepcion.getLong("movimiento") == 1) {
//                        cant = RS_Recepcion.getLong("total_neto_carga") + cant;
//                    }
//                    if (RS_Recepcion.getLong("movimiento") == 2) {
//                        cant = cant - RS_Recepcion.getLong("total_neto_carga");
//                    }
//
//                }
//            }
//            RS_Granos_Tipo = ST_Granos_Tipo.executeQuery("select * from granos_tipo where borrado != '1'");
//            while (RS_Granos_Tipo.next()) {
//                Statement ST_Recepcion = conexion.createStatement();
//                ResultSet RS_Recepcion = ST_Recepcion.executeQuery(""
//                        + "select * from recepcion "
//                        + "where id_granos_tipo='" + RS_Granos_Tipo.getInt("id_granos_tipo") + "' "
//                        + "and borrado_int != '1' "
//                        + "and id_sucursal = '" + id_sucursal_selected + "'  ");
//                while (RS_Recepcion.next()) {
//                    if (RS_Recepcion.getLong("movimiento") == 1) {
//                        total_sin_descuento = RS_Recepcion.getLong("peso_neto") + total_sin_descuento;
//                    }
//                    if (RS_Recepcion.getLong("movimiento") == 2) {
//                        total_sin_descuento = total_sin_descuento - RS_Recepcion.getLong("peso_neto");
//                    }
//                }
//            }
//
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Camion_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Camion_listado.jTable1.getModel();
//            for (int j = 0; j < Camion_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_camion,marca,modelo,anho,chapa, nombre "
//                    + "from camion "
//                    + "inner join transportista on transportista.id_transportista = camion.id_transportista "
//                    + "where marca ilike '%" + buscar + "%'  "
//                    + "and camion.borrado_int != '1'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Camion_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Productos_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Productos_listado.jTable1.getModel();
//            for (int j = 0; j < Productos_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_producto, nombre "
//                    + "from productos  "
//                    + "where nombre ilike '%" + buscar + "%'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Productos_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Parcela_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Parcela_listado.jTable1.getModel();
//            for (int j = 0; j < Parcela_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_parcela, parcela, precio_del_flete, porcentaje, has "
//                    + "from parcela "
//                    + "where parcela ilike '%" + buscar + "%' "
//                    + "order by parcela");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//
//                    } else {
//                        rows[i] = rs2.getObject(i + 1);
//
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Parcela_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_Parcela_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Recepcion_Parcela_listado.jTable1.getModel();
//            for (int j = 0; j < Recepcion_Parcela_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_parcela, parcela, precio_del_flete "
//                    + "from parcela "
//                    + "where parcela ilike '%" + buscar + "%' ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_Parcela_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Listados_Parcela_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Listados_Parcela_listado.jTable1.getModel();
//            for (int j = 0; j < Listados_Parcela_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_parcela, parcela "
//                    + "from parcela "
//                    + "where parcela ilike '%" + buscar + "%' ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Listados_Parcela_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_Camion_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Recepcion_Camion_listado.jTable1.getModel();
//            for (int j = 0; j < Recepcion_Camion_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_camion,marca,modelo,anho,chapa, nombre "
//                    + "from camion "
//                    + "inner join transportista on transportista.id_transportista = camion.id_transportista "
//                    + "where chapa ilike '%" + buscar + "%'  "
//                    + "and camion.borrado_int != '1'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_Camion_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Cliente_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Cliente_listado.jTable1.getModel();
//            for (int j = 0; j < Cliente_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_cliente,nombre,ruc,telefono,direccion "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Cliente_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Personales_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Personales_listado.jTable1.getModel();
//            for (int j = 0; j < Personales_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_empleado,nombre,ci,telefono,descripcion_del_trabajo, salario "
//                    + "from empleado "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Personales_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Empleado_cargo_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Personales_Cargo_listado.jTable1.getModel();
//            for (int j = 0; j < Personales_Cargo_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_empleado_cargo, cargo "
//                    + "from empleado_cargo "
//                    + "where cargo ilike '%" + buscar + "%'  "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Personales_Cargo_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Producto_proveedor_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Producto_proveedor_listado.jTable1.getModel();
//            for (int j = 0; j < Producto_proveedor_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_proveedor, nombre, ruc "
//                    + "from proveedor "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Producto_proveedor_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Listado_recepciones_Cliente_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Listado_recepciones_Cliente_buscar.jTable1.getModel();
//            for (int j = 0; j < Listado_recepciones_Cliente_buscar.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_cliente,nombre "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Listado_recepciones_Cliente_buscar.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Listado_recepciones_Usuario_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Listado_recepciones_Usuario_buscar.jTable1.getModel();
//            for (int j = 0; j < Listado_recepciones_Usuario_buscar.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_usuario,nombre_real  "
//                    + "from usuario "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Listado_recepciones_Usuario_buscar.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_Cliente_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Recepcion_Cliente_listado.jTable1.getModel();
//            for (int j = 0; j < Recepcion_Cliente_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_cliente,nombre "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_Cliente_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Chofer_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Conductor_listado.jTable1.getModel();
//            for (int j = 0; j < Conductor_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_chofer,nombre,ci,telefono,direccion "
//                    + "from chofer "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Conductor_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Consultas_estado_jtable() {
//        try {
//            dtm = (DefaultTableModel) Consultas.jTable_estado.getModel();
//            for (int j = 0; j < Consultas.jTable_estado.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from recepcion_estado "
//                    + "order by recepcion_estado ");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Consultas.jTable_estado.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Listado_recepciones_Chofer_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Listados_recepciones_Chofer_listado.jTable1.getModel();
//            for (int j = 0; j < Listados_recepciones_Chofer_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_chofer,nombre,ci,telefono,direccion "
//                    + "from chofer "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Listados_recepciones_Chofer_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_Chofer_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Recepcion_Chofer_listado.jTable1.getModel();
//            for (int j = 0; j < Recepcion_Chofer_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_chofer,nombre,ci,telefono,direccion "
//                    + "from chofer "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_Chofer_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Carreta_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Carreta_listado.jTable1.getModel();
//            for (int j = 0; j < Carreta_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_carreta,marca,modelo,chapa,anho "
//                    + "from carreta "
//                    + "where marca ilike '%" + buscar + "%'  "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by marca");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Carreta_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Proveedor_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Proveedor_listado.jTable1.getModel();
//            for (int j = 0; j < Proveedor_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_proveedor, nombre, telefono, ruc "
//                    + "from proveedor "
//                    + "where nombre ilike '%" + buscar + "%'  "
//                    + "order by nombre");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Proveedor_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Recepcion_Carreta_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Recepcion_Carreta_listado.jTable1.getModel();
//            for (int j = 0; j < Recepcion_Carreta_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_carreta,marca,modelo,chapa,anho "
//                    + "from carreta "
//                    + "where marca ilike '%" + buscar + "%'  "
//                    + "and (borrado_int != '1' or borrado_int is null) "
//                    + "order by marca");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    if (rs2.getObject(i + 1) != null) {
//                        rows[i] = rs2.getObject(i + 1).toString().trim();
//                    }
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recepcion_Carreta_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Camion_Trasnportista_cargar_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Camion_transportista_listado.jTable1.getModel();
//            for (int j = 0; j < Camion_transportista_listado.jTable1.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from transportista "
//                    + "where nombre ilike '%" + buscar + "%' "
//                    + "and borrado_int != '1'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Camion_transportista_listado.jTable1.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Combustibles_uso_litros(Date fecha) {
//        try {
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(""
//                    + "SELECT SUM(litros) "
//                    + "from combustible_uso "
//                    + "where fecha = '" + fecha + "' "
//                    + "and id_sucursal = '" + id_sucursal + "'");
//            if (RS_Productos.next()) {
//                if (RS_Productos.getString(1) != null) {
//                    Combustible_uso.jTextField_total.setText(getSepararMiles(RS_Productos.getString(1)));
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Combustibles_uso_jtable(Date fecha) {
//        try {
//            dtm = (DefaultTableModel) Combustible_uso.jTable_combustible_uso.getModel();
//            for (int j = 0; j < Combustible_uso.jTable_combustible_uso.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_combustible_uso, fecha, litros, combustible_uso.descripcion, tipo, modelo, vehiculo.descripcion, nombre "
//                    + "from combustible_uso "
//                    + "inner join vehiculo on vehiculo.id_vehiculo = combustible_uso.id_vehiculo "
//                    + "inner join empleado on empleado.id_empleado = combustible_uso.id_empleado "
//                    + "where fecha = '" + fecha + "' "
//                    + "and id_sucursal = '" + id_sucursal + "'"
//                    + "order by fecha, id_combustible_uso DESC");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Combustible_uso.jTable_combustible_uso.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    public static void Transportista_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "UPDATE transportista "
                    + "SET borrado_int = '1' "
                    + "WHERE id_transportista  ='" + id_transportista + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Contrato_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "DELETE from contrato "
                    + "WHERE id_contrato  ='" + id_contrato + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void productos_aplicacion_abm_id_detalle_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "DELETE from producto_aplicacion_detalle "
                    + "WHERE id_producto_aplicacion_detalle  ='" + productos_aplicacion_detalle_id_producto_aplicacion_detalle + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Recepcion_detalle_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "DELETE from recepcion_detalle "
                    + "WHERE id_recepcion_detalle  ='" + recepcion_id_recepcion_detalle + "'");
            stClienteBorrar.executeUpdate();

            double peso_neto = 0;
            double total_descuento = 0;

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT * FROM recepcion where id_recepcion = '" + id_recepcion + "'");
            if (result.next()) {
                peso_neto = result.getDouble("peso_neto");
            }

            st1 = conexion.createStatement();
            result = st1.executeQuery("SELECT SUM(descuento) FROM recepcion_detalle where id_recepcion = '" + id_recepcion + "'");
            if (result.next()) {
                total_descuento = result.getLong(1);
            }

            double total_neto_carga = peso_neto - total_descuento;
            long tnc = (long) total_neto_carga;
            long total_desc = (long) total_descuento;

            PreparedStatement st2 = conexion.prepareStatement(""
                    + "UPDATE recepcion "
                    + "SET total_descuento ='" + total_desc + "', "
                    + "total_neto_carga ='" + tnc + "' "
                    + "WHERE id_recepcion = '" + id_recepcion + "'");
            st2.executeUpdate();

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Compra_detalle_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "DELETE from facturas_compra_detalle "
                    + "WHERE id_facturas_compra_detalle  ='" + id_facturas_compras_detalle + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Personales_pagos_detalle_borrar() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "DELETE from sueldo_detalle "
                    + "WHERE id_sueldo_detalle  ='" + id_sueldo_detalle + "'");
            st.executeUpdate();

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT SUM(importe) FROM sueldo_detalle where id_sueldo = '" + id_sueldo + "'");
            if (result.next()) {
                st = conexion.prepareStatement(""
                        + "UPDATE sueldo "
                        + "SET total ='" + result.getLong(1) + "' "
                        + "WHERE id_sueldo = '" + id_sueldo + "'");
                st.executeUpdate();
            }

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Parcela_borrar() {
        try {
            PreparedStatement st = conexion.prepareStatement(""
                    + "DELETE from parcela "
                    + "WHERE id_parcela  ='" + id_parcela + "'");
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Borrado correctamente");
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Ventas_detalle_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "DELETE from venta_detalle "
                    + "WHERE id_venta_detalle  ='" + id_venta_detalle + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Recepcion_anular() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "UPDATE recepcion "
                    + "SET borrado_int = '1' "
                    + "WHERE id_recepcion  ='" + id_recepcion + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Cliente_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "UPDATE cliente "
                    + "SET borrado_int ='1' "
                    + "WHERE id_cliente  ='" + id_cliente + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Chofer_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "UPDATE chofer "
                    + "SET borrado_int ='1' "
                    + "WHERE id_chofer  ='" + id_chofer + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Carreta_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "UPDATE carreta "
                    + "SET borrado_int ='1' "
                    + "WHERE id_carreta  ='" + id_carreta + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public static void Combustible_uso_borrar() {
        try {
            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "DELETE from combustible_uso "
                    + "WHERE id_combustible_uso  ='" + id_combustible_uso_selected + "'");
            stClienteBorrar.executeUpdate();
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }
//
//    public static void Cofiguracion_obtener_datos() {
//        try {
//            Statement ST31 = conexion.createStatement();
//            ResultSet RS31 = ST31.executeQuery(""
//                    + "SELECT * FROM configuracion ");
//            while (RS31.next()) {
//                Configuracion.jTextField_anho.setText(RS31.getString("anho"));
//                Configuracion.jTextField_empresa.setText(RS31.getString("empresa").trim());
//                Configuracion.jTextField_telefono.setText(RS31.getString("telefono").trim());
//                Configuracion.jTextField_ruc.setText(RS31.getString("ruc").trim());
//                Configuracion.jTextField_dolar.setText(RS31.getString("dolar").trim());
//                Configuracion.jTextField_direccion.setText(RS31.getString("direccion").trim());
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    public static synchronized void Recepcion_guardar(
            String numero,
            Date fecha,
            String comp_pesaje,
            String peso_bruto_str,
            String peso_tara_str,
            //            String humedad,
            //            String impurezas,
            //            String quebrados,
            //            String granos_verdes,
            //            String ardidos,
            //            String chuzos,
            String origen,
            String destino,
            Date fecha_salida,
            Date fecha_llegada,
            String precio,
            String observaciones,
            String total_a_pagar) {
        try {

            if (id_cliente == 0) {
                JOptionPane.showMessageDialog(null, "Complete el cliente");
            }
            if (id_chofer == 0) {
                JOptionPane.showMessageDialog(null, "Complete el chofer");

            }
            if (id_camion == 0) {
                JOptionPane.showMessageDialog(null, "Complete el camion");

            }
            if (id_carreta == 0) {
                JOptionPane.showMessageDialog(null, "Complete la carreta");

            }

            if (id_cliente == 0 || id_chofer == 0 || id_carreta == 0 || id_camion == 0) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos.");
            } else {

                if (isNumeric(precio) || isNumericDouble(precio)) {
                } else {
                    precio = "0";
//                    Recepcion_ABM.jTextField_precio.setText("0");
                }

                long peso_tara = Long.parseLong(peso_tara_str.replace(".", ""));
                long peso_bruto = Long.parseLong(peso_bruto_str.replace(".", ""));

                DecimalFormat num = new DecimalFormat("#,###,###");

                double descuento_humedad = 0;
                double descuento_humedad_kg = 0;
                String descuento_humedad_string = null;

                double descuento_ardidos = 0;
                double descuento_ardidos_kg = 0;
                String descuento_ardidos_string = null;

                double descuento_chuzos = 0;
                double descuento_chuzos_kg = 0;
                String descuento_chuzos_string = null;

                double descuento_quebrados = 0;
                double descuento_quebrados_kg = 0;
                String descuento_quebrados_string = null;

                double descuento_impurezas = 0;
                double descuento_impurezas_kg = 0;
                String descuento_impurezas_string = null;

                double descuento_granos_verdes = 0;
                double descuento_granos_verdes_kg = 0;
                String descuento_granos_verdes_string = "0.00";

                int error = 0;
                int error_general = 0;
                String error_detalle = "";
                String movimiento_string = "";

                double total_descuento_kg = 0;

//                Statement ST_tabla_ad_humedad = conexion.createStatement();
//                ResultSet RS_tabla_ad_humedad = ST_tabla_ad_humedad.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + humedad + "' and id_concepto_tabla_ad='1'");
//                while (RS_tabla_ad_humedad.next()) {
//                    descuento_humedad_string = RS_tabla_ad_humedad.getString("porcentaje");
//                }
//                Statement ST_tabla_ad_impurezas = conexion.createStatement();
//                ResultSet RS_tabla_ad_impurezas = ST_tabla_ad_impurezas.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + impurezas + "' and id_concepto_tabla_ad='2'");
//                while (RS_tabla_ad_impurezas.next()) {
//                    descuento_impurezas_string = RS_tabla_ad_impurezas.getString("porcentaje");
//                }
//                Statement ST_tabla_ad_chuzos = conexion.createStatement();
//                ResultSet RS_tabla_ad_chuzos = ST_tabla_ad_chuzos.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + chuzos + "' and id_concepto_tabla_ad='4'");
//                while (RS_tabla_ad_chuzos.next()) {
//                    descuento_chuzos_string = RS_tabla_ad_chuzos.getString("porcentaje");
//                }
//                Statement ST_tabla_ad_ardidos = conexion.createStatement();
//                ResultSet RS_tabla_ad_ardidos = ST_tabla_ad_ardidos.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + ardidos + "' and id_concepto_tabla_ad='5'");
//                while (RS_tabla_ad_ardidos.next()) {
//                    descuento_ardidos_string = RS_tabla_ad_ardidos.getString("porcentaje");
//                }
//                Statement ST_tabla_ad_quebrados = conexion.createStatement();
//                ResultSet RS_tabla_ad_quebrados = ST_tabla_ad_quebrados.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + quebrados + "' and id_concepto_tabla_ad='6'");
//                while (RS_tabla_ad_quebrados.next()) {
//                    descuento_quebrados_string = RS_tabla_ad_quebrados.getString("porcentaje");
//                }
//
//                Statement ST_tabla_ad_granos_verdes = conexion.createStatement();
//                ResultSet RS_tabla_ad_granos_verdes = ST_tabla_ad_granos_verdes.executeQuery("SELECT * FROM tabla_ad where cantidad= '" + granos_verdes + "' and id_concepto_tabla_ad='3'");
//                while (RS_tabla_ad_granos_verdes.next()) {
//                    descuento_granos_verdes_string = RS_tabla_ad_granos_verdes.getString("porcentaje");
//                }
//
//                descuento_humedad = Double.parseDouble((descuento_humedad_string));
//                descuento_impurezas = Double.parseDouble((descuento_impurezas_string));
//                descuento_granos_verdes = Double.parseDouble((descuento_granos_verdes_string));
//                descuento_chuzos = Double.parseDouble((descuento_chuzos_string));
//                descuento_ardidos = Double.parseDouble((descuento_ardidos_string));
//                descuento_quebrados = Double.parseDouble((descuento_quebrados_string));
                Long peso_neto_long = new Long(peso_bruto - peso_tara);
                double peso_neto_double = peso_neto_long.doubleValue();

//                descuento_humedad_kg = (peso_neto_double * descuento_humedad / 100);
//                descuento_impurezas_kg = (peso_neto_double * descuento_impurezas / 100);
//                descuento_granos_verdes_kg = (peso_neto_double * descuento_granos_verdes / 100);
//                descuento_chuzos_kg = (peso_neto_double * descuento_chuzos / 100);
//                descuento_ardidos_kg = (peso_neto_double * descuento_ardidos / 100);
//                descuento_quebrados_kg = (peso_neto_double * descuento_quebrados / 100);
                total_descuento_kg = (descuento_impurezas_kg + descuento_humedad_kg + descuento_granos_verdes_kg + descuento_chuzos_kg + descuento_ardidos_kg + descuento_quebrados_kg);

//                long total_descuento = 0;
//                long total_descuento = (new Double(total_descuento_kg)).longValue();
//                long descuento_humedad_kg_long = (new Double(descuento_humedad_kg)).longValue();
//                long descuento_impurezas_kg_long = (new Double(descuento_impurezas_kg)).longValue();
//                long descuento_granos_verdes_kg_long = (new Double(descuento_granos_verdes_kg)).longValue();
//                long descuento_chuzos_kg_long = (new Double(descuento_chuzos_kg)).longValue();
//                long descuento_ardidos_kg_long = (new Double(descuento_ardidos_kg)).longValue();
//                long descuento_quebrados_kg_long = (new Double(descuento_quebrados_kg)).longValue();
                long total_descuento = 0;
                long descuento_humedad_kg_long = 0;
                long descuento_impurezas_kg_long = 0;
                long descuento_granos_verdes_kg_long = 0;
                long descuento_chuzos_kg_long = 0;
                long descuento_ardidos_kg_long = 0;
                long descuento_quebrados_kg_long = 0;

                long peso_neto = (peso_bruto - peso_tara);
                long total_neto_carga = (peso_neto - total_descuento);

                int estado = 0;
                int guardo = 0;
                long _num = id_recepcion;

                Statement ST_Configuracion = conexion.createStatement();
                ResultSet RS_Configuracion = ST_Configuracion.executeQuery("SELECT * FROM sucursal where id_sucursal = '" + id_sucursal + "'");
                while (RS_Configuracion.next()) {
                    _num = RS_Configuracion.getLong("numero_remision") + 1;
                }
                String moneda_str = "";
                Statement ST_moneda = conexion.createStatement();
                ResultSet RS_moneda = ST_moneda.executeQuery("SELECT * FROM moneda where id_moneda = '" + id_moneda + "'");
                while (RS_moneda.next()) {
                    moneda_str = RS_moneda.getString("moneda");
                }

                int movimiento = 0;
//                if (Recepcion_ABM.jCheckBox_recepcion.isSelected()) {
//                    movimiento = 1;
//                }
//                if (Recepcion_ABM.jCheckBox_remision.isSelected()) {
//                    movimiento = 2;
//                }
                java.sql.Date fecha_sql_date = util_Date_to_sql_date(fecha);

                if (peso_tara == 0) {
                    estado = 3;
                }

                if (movimiento == 1) {
                    movimiento_string = "Recepcion";
                }
                if (movimiento == 2) {
                    movimiento_string = "Remision";
                }

                java.sql.Date fecha_salida_sql_date = util_Date_to_sql_date(fecha_salida);
                java.sql.Date fecha_llegada_sql_date = util_Date_to_sql_date(fecha_llegada);
                if (id_recepcion == 0) {

                    /// INSERT NUEVO
//                    Recepcion_MAX();
                    id_recepcion = id_recepcion + 1;
                    PreparedStatement st2 = conexion.prepareStatement(""
                            + "INSERT INTO recepcion VALUES("
                            + "?,?,?,?,?, ?,?,?,?,?,"
                            + "?,?,?,?,?, ?,?,?,?,?,"
                            + "?,?,?,?,?, ?,?,?,?,?,"
                            + "?,?,?,?,?, ?,?,?,?,?,"
                            + "?,?,?,?,?, ?,?,?,?,?,"
                            + "?,?,?,?,?, ?,?,?)");
                    st2.setInt(1, id_recepcion);

                    if (movimiento == 2) {
                        st2.setLong(2, _num);
                        guardo = 1;

                    } else {
                        st2.setInt(2, id_recepcion);
                    }
                    st2.setDate(3, fecha_sql_date);
                    st2.setInt(4, id_cliente);
                    st2.setInt(5, id_granos_tipo);
                    st2.setInt(6, id_camion);
                    st2.setInt(7, id_carreta);
                    st2.setInt(8, id_chofer);
                    st2.setString(9, comp_pesaje);
                    st2.setLong(10, peso_bruto);
                    st2.setLong(11, peso_tara);
                    st2.setLong(12, peso_neto);
                    st2.setString(13, "");
                    st2.setString(13, "");
                    st2.setString(14, "");
                    st2.setString(15, "");
                    st2.setString(16, "");
                    st2.setString(17, "");
                    st2.setString(18, "");
                    st2.setLong(19, total_descuento);
                    st2.setLong(20, total_neto_carga);
                    st2.setString(21, "NO");
                    st2.setInt(22, 0);
                    st2.setInt(23, estado);
                    st2.setString(24, "");
                    st2.setString(25, "");
//                    st2.setString(26, humedad + " % - " + descuento_humedad + " % - " + num.format(descuento_humedad_kg_long) + " Kg");
//                    st2.setString(27, impurezas + " % - " + descuento_impurezas + " % - " + num.format(descuento_impurezas_kg_long) + " Kg");
//                    st2.setString(28, quebrados + " % - " + descuento_quebrados + " % - " + num.format(descuento_quebrados_kg_long) + " Kg");
//                    st2.setString(29, granos_verdes + " % - " + descuento_granos_verdes + " % - " + num.format(descuento_granos_verdes_kg_long) + " Kg");
//                    st2.setString(30, ardidos + " % - " + descuento_ardidos + " % - " + num.format(descuento_ardidos_kg_long) + " Kg");
//                    st2.setString(31, chuzos + " % - " + descuento_chuzos + " % - " + num.format(descuento_chuzos_kg_long) + " Kg");
                    st2.setString(26, "");
                    st2.setString(27, "");
                    st2.setString(28, "");
                    st2.setString(29, "");
                    st2.setString(30, "");
                    st2.setString(31, "");
                    st2.setInt(32, movimiento);
                    st2.setString(33, movimiento_string);
                    st2.setString(34, origen);
                    st2.setString(35, destino);
                    st2.setDate(36, fecha_salida_sql_date);
                    st2.setDate(37, fecha_llegada_sql_date);
                    st2.setInt(38, 0);
                    st2.setDouble(39, Double.parseDouble(precio));
                    st2.setInt(40, id_parcela);
                    st2.setString(41, observaciones);
                    st2.setString(42, descuento_humedad + " %");
                    st2.setLong(43, descuento_humedad_kg_long);
                    st2.setString(44, descuento_impurezas + " %");
                    st2.setLong(45, descuento_impurezas_kg_long);
                    st2.setString(46, descuento_quebrados + " %");
                    st2.setLong(47, descuento_quebrados_kg_long);
                    st2.setString(48, descuento_ardidos + " %");
                    st2.setLong(49, descuento_quebrados_kg_long);
                    st2.setInt(50, id_usuario);
//                    st2.setDouble(51, Double.parseDouble(Recepcion_ABM.jTextField_total.getText().replace(".", "").replace(",", ".")));
                    st2.setLong(52, id_moneda);
                    st2.setInt(53, recepcion_id_motivo);
                    st2.setInt(54, recepcion_id_zafra);
                    if (Double.parseDouble(precio) >= 1) {
                        st2.setInt(55, 2);
                    } else {
                        st2.setInt(55, 1);
                    }
                    st2.setInt(56, id_sucursal);
                    st2.setInt(57, recepcion_id_variedad);
                    st2.setInt(58, recepcion_id_remitente);

                    //    if (id_recepcion < 500) {
                    st2.executeUpdate();

//                    Recepcion_ABM.jTextField_neto_descuento.setText(getSepararMiles(String.valueOf(total_neto_carga)));

                    //    }
                    int id_recibo = 1;
                    Statement st_recibo_id = conexion.createStatement();
                    ResultSet result_recibo_id = st_recibo_id.executeQuery("SELECT MAX(id_recibo) FROM recibo");
                    if (result_recibo_id.next()) {
                        id_recibo = result_recibo_id.getInt(1) + 1;
                    }

                    Calendar fecha2 = new GregorianCalendar();
                    int anho = fecha2.get(Calendar.YEAR);
                    int mes = fecha2.get(Calendar.MONTH);
                    int dia = fecha2.get(Calendar.DAY_OF_MONTH);

                    PreparedStatement st3 = conexion.prepareStatement("INSERT INTO recibo VALUES(?,?,?,?,?,?,?,?)");

                    st3.setInt(1, id_recibo);
                    st3.setInt(2, id_cliente);
                    st3.setDate(3, fecha_sql_date);
                    st3.setString(4, "Recepcion de granos segun nota de remision adjunta nro" + numero);
                    st3.setLong(5, 450 * total_neto_carga);
                    st3.setString(6, "NO");
                    st3.setString(7, "Natalio, " + dia + " del " + (mes + 1) + " del " + anho + ";");
                    st3.setString(8, "NO");

                    st3.executeUpdate();
                    if (guardo == 1) {
                        PreparedStatement stUpdateAuxiliar = conexion.prepareStatement(""
                                + "UPDATE sucursal "
                                + "SET numero_remision ='" + _num + "'  "
                                + "WHERE id_sucursal ='" + id_sucursal + "'");
                        stUpdateAuxiliar.executeUpdate();
                        guardo = 0;
                    }
//                    JOptionPane.showMessageDialog(null, "Guardado correctamente");
                    // FIN INSERT

                } else { // update

                    int id_recepcion_estado = 0;
                    if (Double.parseDouble(precio) >= 1) {
                        id_recepcion_estado = 2;
                    } else {
                        id_recepcion_estado = 1;
                    }

                    if (movimiento == 2) {
                        numero = String.valueOf(_num);
                    }
                    if (movimiento == 1) {
                        numero = String.valueOf(id_recepcion);
                    }

                    PreparedStatement stUpdateAuxiliar = conexion.prepareStatement(""
                            + "UPDATE recepcion "
                            + "SET fecha ='" + fecha_sql_date + "', "
                            + "numero ='" + numero + "', "
                            + "id_cliente ='" + id_cliente + "', "
                            + "id_granos_tipo ='" + id_granos_tipo + "', "
                            + "id_camion ='" + id_camion + "', "
                            + "id_carreta ='" + id_carreta + "', "
                            + "id_chofer ='" + id_chofer + "', "
                            + "comp_pesaje ='" + comp_pesaje + "', "
                            + "peso_bruto ='" + peso_bruto + "', "
                            + "peso_tara ='" + peso_tara + "', "
                            + "peso_neto ='" + peso_neto + "', "
                            //                            + "humedad ='" + humedad + "', "
                            //                            + "impurezas ='" + impurezas + "', "
                            //                            + "quebrados ='" + quebrados + "', "
                            //                            + "granos_verdes ='" + granos_verdes + "', "
                            //                            + "total_descuento ='" + total_descuento + "', "
                            //                            + "total_neto_carga ='" + total_neto_carga + "', "
                            + "estado ='" + estado + "', "
                            //                            + "ardidos ='" + ardidos + "', "
                            //                            + "chuzos ='" + chuzos + "', "
                            //                            + "por_humedad ='" + humedad + " % - " + descuento_humedad + " % - " + num.format(descuento_humedad_kg_long) + " Kg" + "', "
                            //                            + "por_impurezas ='" + impurezas + " % - " + descuento_impurezas + " % - " + num.format(descuento_impurezas_kg_long) + " Kg" + "', "
                            //                            + "por_quebrados ='" + quebrados + " % - " + descuento_quebrados + " % - " + num.format(descuento_quebrados_kg_long) + " Kg" + "', "
                            //                            + "por_granos_verdes ='" + granos_verdes + " % - " + descuento_granos_verdes + " % - " + num.format(descuento_granos_verdes_kg_long) + " Kg" + "', "
                            //                            + "por_ardidos ='" + ardidos + " % - " + descuento_ardidos + " % - " + num.format(descuento_ardidos_kg_long) + " Kg" + "', "
                            //                            + "por_chuzos ='" + chuzos + " % - " + descuento_chuzos + " % - " + num.format(descuento_chuzos_kg_long) + " Kg" + "', "
                            + "movimiento ='" + movimiento + "', "
                            + "movimiento_string ='" + movimiento_string + "', "
                            + "origen ='" + origen + "', "
                            + "destino ='" + destino + "', "
                            + "observaciones ='" + observaciones + "', "
                            + "id_recepcion_estado ='" + id_recepcion_estado + "', "
                            + "id_parcela ='" + id_parcela + "', "
                            //                            + "humedad_descuento_por ='" + descuento_humedad + " %" + "', "
                            //                            + "humedad_descuento_kg ='" + descuento_humedad_kg_long + "', "
                            //                            + "impurezas_descuento_por ='" + descuento_impurezas + " %" + "', "
                            //                            + "impurezas_descuento_kg ='" + descuento_impurezas_kg_long + "', "
                            //                            + "quebrados_descuento_por ='" + descuento_quebrados + " %" + "', "
                            //                            + "quebrados_descuento_kg ='" + descuento_quebrados_kg_long + "', "
                            //                            + "ardidos_descuento_por ='" + descuento_ardidos + " %" + "', "
                            //                            + "ardidos_descuento_kg ='" + descuento_ardidos_kg_long + "', "
                            + "precio ='" + Double.parseDouble(precio) + "', "
//                            + "total_a_pagar ='" + Double.parseDouble(Recepcion_ABM.jTextField_total.getText().replace(".", "").replace(",", ".")) + "', "
                            + "fecha_salida ='" + fecha_salida_sql_date + "', "
                            + "id_moneda ='" + id_moneda + "', "
                            + "id_motivo ='" + recepcion_id_motivo + "', "
                            + "id_zafra ='" + recepcion_id_zafra + "', "
                            + "id_variedad ='" + recepcion_id_variedad + "', "
                            + "id_remitente ='" + recepcion_id_remitente + "', "
                            + "fecha_llegada ='" + fecha_llegada_sql_date + "' "
                            + "WHERE id_recepcion ='" + id_recepcion + "'");
                    stUpdateAuxiliar.executeUpdate();

//                    Recepcion_ABM.jTextField_neto_descuento.setText(getSepararMiles(String.valueOf(total_neto_carga)));
//                    JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en uno de los campos." + ex);
        }

    }

    public static DecimalFormat num_decimal_dolares = new DecimalFormat("#.##");
    public static DecimalFormat num_decimal_gs = new DecimalFormat("###,###,###,###");

    static void Recibo_de_dinero_update(String cheque, String concepto, String dinero, Date fecha) {
        try {
            PreparedStatement st2 = conexion.prepareStatement("UPDATE recibo "
                    + "SET id_cliente = '" + recibo_de_dinero_id_cliente + "', "
                    + "id_banco = '" + recibo_de_dinero_id_banco + "', "
                    + "id_moneda = '" + recibo_de_dinero_id_moneda + "', "
                    + "concepto = '" + concepto + "', "
                    + "cheque = '" + cheque + "', "
                    + "fecha = '" + util_Date_to_sql_date(fecha) + "', "
                    + "cantidad = '" + Long.parseLong(dinero.replace(".", "")) + "' "
                    + "WHERE id_recibo = '" + id_recibo + "' ");
            st2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizado correctamente.");
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());

        }
    }

    public synchronized static void Recepcion_imprimir(String precio) {

        try {

            Conexion.Verificar_conexion();

            int duenho = 0;
            Statement ST_Recepcion22 = conexion.createStatement();
            ResultSet RS_Recepcion22 = ST_Recepcion22.executeQuery("select * from cliente where duenho = '1'");
            while (RS_Recepcion22.next()) {
                duenho = RS_Recepcion22.getInt("id_cliente");
            }

            if (isNumeric(precio)) {
            } else {
                precio = "0";
            }

            long precio_long = Long.parseLong(precio);
            String reporte = "";
            if (precio_long > 0) {
                reporte = "liquidacion_lovera";
            } else {
                reporte = "compra_lovera";
            }

            if (duenho == id_cliente) {
                reporte = "recepcion_lovera";
            }
            long descuento = 0;
            int id_movimiento = 0;
            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery("select * from recepcion where id_recepcion='" + id_recepcion + "'");
            while (RS_Recepcion2.next()) {
                id_movimiento = RS_Recepcion2.getInt("movimiento");
                descuento = RS_Recepcion2.getLong("humedad_descuento_kg")
                        + RS_Recepcion2.getLong("impurezas_descuento_kg")
                        + RS_Recepcion2.getLong("quebrados_descuento_kg")
                        + RS_Recepcion2.getLong("ardidos_descuento_kg");
            }

            PreparedStatement st2 = conexion.prepareStatement("UPDATE recepcion SET print='0' WHERE print='1' ");
            st2.executeUpdate();

            PreparedStatement st = conexion.prepareStatement("UPDATE recepcion SET print='1' WHERE id_recepcion='" + id_recepcion + "'");
            st.executeUpdate();
            String dir = "";
            if (id_movimiento == 2) {
                dir = "remision_lovera";  // establecimiento san esteban
            }
            if (id_movimiento == 1) {
//              dir = "recepcion_lovera"; // establecimiento san esteban
//              dir = "recepcion_agrosem"; // establecimiento don esteban
                dir = reporte; // establecimiento san esteban
            }

            Map parametros = new HashMap();
            if (id_moneda == 1) {
                parametros.put("kilo", "Kilo");
            }
            if (id_moneda == 2) {
                parametros.put("kilo", "Tonelada");
            }
            String venta = "";
            String exportacion = "";
            String compra = "";
            String importacion = "";
            String consignacion = "";
            String devolucion = "";
            String traslado = "";
            String transformacion = "";
            String reparacion = "";
            String emisor_movil = "";
            String exhibicion = "";
            String ferias = "";
            if (recepcion_id_motivo == 2) {
                venta = "X";
            }
            if (recepcion_id_motivo == 3) {
                exportacion = "X";
            }
            if (recepcion_id_motivo == 4) { // venta
                compra = "X";
            }
            if (recepcion_id_motivo == 5) { // venta
                importacion = "X";
            }
            if (recepcion_id_motivo == 6) { // venta
                consignacion = "X";
            }
            if (recepcion_id_motivo == 7) { // venta
                devolucion = "X";
            }
            if (recepcion_id_motivo == 8) { // venta
                traslado = "X";
            }
            if (recepcion_id_motivo == 9) { // venta
                transformacion = "X";
            }
            if (recepcion_id_motivo == 10) { // venta
                reparacion = "X";
            }
            if (recepcion_id_motivo == 11) { // venta
                emisor_movil = "X";
            }
            if (recepcion_id_motivo == 12) { // venta
                exhibicion = "X";
            }
            if (recepcion_id_motivo == 13) { // venta
                ferias = "X";
            }
            String detalle = path + "liquidacion_detalle.";

            parametros.put("venta", venta);
            parametros.put("exportacion", exportacion);
            parametros.put("compra", compra);
            parametros.put("importacion", importacion);
            parametros.put("consignacion", consignacion);
            parametros.put("devolucion", devolucion);
            parametros.put("traslado", traslado);
            parametros.put("transformacion", transformacion);
            parametros.put("reparacion", reparacion);
            parametros.put("emisor_movil", emisor_movil);
            parametros.put("exhibicion", exhibicion);
            parametros.put("ferias", ferias);
            parametros.put("descuento", descuento);
            parametros.put("direccion", detalle);

            Conexion.Verificar_conexion();
            String reporte_dir = path + dir + ".jasper";
            System.err.println(reporte_dir);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

//    public synchronized static void Listado_Recepcion_imprimir() {
//
//        try {
//            String reporte_dir = path + "recepcion_listado_dia.jasper";
//            Stock_de_granos2();
//
//            Map parametros = new HashMap();
//            parametros.put("desde", Listado_recepciones.jDateChooser_desde.getDate());
//            parametros.put("hasta", Listado_recepciones.jDateChooser_hasta.getDate());
//            parametros.put("total", cant);
//            parametros.put("total_sin_descuento", total_sin_descuento);
//            parametros.put("id_sucursal", id_sucursal_selected);
//            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
//            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
//            JasperViewer jv = new JasperViewer(jp, false);
//            jv.setVisible(true);
//
//        } catch (JRException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }

    public synchronized static void Uso_de_productos_listado_imprimir(Date desde, Date hasta) {
        try {

            boolean entro = false;

            String parcela = "";

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            String desde_str = df.format(desde);
            String hasta_str = df.format(hasta);

            PreparedStatement stClienteBorrar = conexion.prepareStatement(""
                    + "DELETE from imprimir ");
            stClienteBorrar.executeUpdate();

            Statement ST_Productos = conexion.createStatement();
            String sql = ""
                    + "select *, producto_aplicacion_detalle.precio as precio_app  from producto_aplicacion "
                    + "inner join parcela on parcela.id_parcela = producto_aplicacion.id_parcela "
                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = producto_aplicacion.id_granos_tipo "
                    + "inner join zafra on zafra.id_zafra= producto_aplicacion.id_zafra "
                    + "inner join producto_aplicacion_detalle on producto_aplicacion_detalle.id_producto_aplicacion = producto_aplicacion.id_producto_aplicacion "
                    + "inner join productos on productos.id_producto = producto_aplicacion_detalle.id_producto "
                    + "where fecha >= '" + desde_str + "' and fecha <= '" + hasta_str + "' "
                    + "and producto_aplicacion.id_parcela = '" + uso_de_productos_listado_id_parcela + "' "
                    + "and producto_aplicacion.id_zafra = '" + uso_de_productos_listado_id_zafra + "' "
                    + "and producto_aplicacion.id_granos_tipo = '" + uso_de_productos_listado_id_cultivo + "' "
                    + "and tipo_aplicacion = '2' "
                    + "order by fecha, aplicacion, parcela, granos_tipo";

//            System.err.println(sql);
            id = 1;

            double total = 0;
            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
            while (RS_Productos.next()) {

                entro = true;

                parcela = RS_Productos.getString("parcela");

                PreparedStatement st3 = conexion.prepareStatement("INSERT INTO imprimir VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                st3.setInt(1, id);
                st3.setString(2, parcela);
                st3.setString(3, RS_Productos.getString("zafra"));
                st3.setString(4, RS_Productos.getString("nombre"));
                st3.setString(5, RS_Productos.getString("tipo"));
                st3.setString(6, RS_Productos.getString("tipo_aplicacion"));
                st3.setDouble(7, RS_Productos.getDouble("dosis"));
                st3.setDouble(8, RS_Productos.getDouble("hectareas"));
                st3.setDouble(9, RS_Productos.getDouble("total"));
                st3.setDouble(10, RS_Productos.getDouble("hectareas") * RS_Productos.getDouble("precio_app") * RS_Productos.getDouble("dosis"));
                st3.setInt(11, 0);
                st3.setDouble(12, 0);
                st3.setDate(13, RS_Productos.getDate("fecha"));
                if (RS_Productos.getInt("aplicacion") > 0) {
                    st3.setString(14, RS_Productos.getString("aplicacion"));
                } else {
                    st3.setString(14, " ");
                }
                st3.executeUpdate();

                id = id + 1;

                total = total + RS_Productos.getDouble("hectareas") * RS_Productos.getDouble("precio_app") * RS_Productos.getDouble("dosis");

            }
            if (entro == true) {
                PreparedStatement st3 = conexion.prepareStatement("INSERT INTO imprimir VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                st3.setInt(1, id);
                st3.setString(2, parcela);
                st3.setString(3, " ");
                st3.setString(4, " --------- COSTOS DE LA SIEMBRA ");
                st3.setString(5, " ");
                st3.setString(6, "  ");
                st3.setDouble(7, 0);
                st3.setDouble(8, 0);
                st3.setDouble(9, 0);
                st3.setDouble(10, total);
                st3.setInt(11, 0);
                st3.setInt(12, 0);
                st3.setDate(13, null);
                st3.executeUpdate();
            }

            entro = false;

            sql = ""
                    + "select *, producto_aplicacion_detalle.precio as precio_app   from producto_aplicacion "
                    + "inner join parcela on parcela.id_parcela = producto_aplicacion.id_parcela "
                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = producto_aplicacion.id_granos_tipo "
                    + "inner join zafra on zafra.id_zafra= producto_aplicacion.id_zafra "
                    + "inner join producto_aplicacion_detalle on producto_aplicacion_detalle.id_producto_aplicacion = producto_aplicacion.id_producto_aplicacion "
                    + "inner join productos on productos.id_producto = producto_aplicacion_detalle.id_producto "
                    + "where fecha >= '" + desde_str + "' and fecha <= '" + hasta_str + "' "
                    + "and producto_aplicacion.id_parcela = '" + uso_de_productos_listado_id_parcela + "' "
                    + "and producto_aplicacion.id_zafra = '" + uso_de_productos_listado_id_zafra + "' "
                    + "and producto_aplicacion.id_granos_tipo = '" + uso_de_productos_listado_id_cultivo + "' "
                    + "and tipo_aplicacion = '1' "
                    + "order by  fecha, aplicacion, parcela, granos_tipo";

            int app = 0;
            int app_ant = 0;

            total = 0;
            int id2 = id;

            RS_Productos = ST_Productos.executeQuery(sql);
            while (RS_Productos.next()) {
                entro = true;
                if (id == id2) {
                    app = RS_Productos.getInt("aplicacion");
                    app_ant = RS_Productos.getInt("aplicacion");
                }

                id = id + 1;

                app = RS_Productos.getInt("aplicacion");
                parcela = RS_Productos.getString("parcela");

                if ((app_ant != app)) {

                    PreparedStatement st3 = conexion.prepareStatement("INSERT INTO imprimir VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    st3.setInt(1, id);
                    st3.setString(2, parcela);
                    st3.setString(3, " ");
                    st3.setString(4, " --------- COSTOS DE LA APLICACION  ");
                    st3.setString(5, " ");
                    st3.setString(6, "  ");
                    st3.setDouble(7, 0);
                    st3.setDouble(8, 0);
                    st3.setDouble(9, 0);
                    st3.setDouble(10, total);
                    st3.setInt(11, 0);
                    st3.setInt(12, 0);
                    st3.setDate(13, null);
                    st3.executeUpdate();
                    id = id + 1;
                    total = 0;

                }

                app_ant = RS_Productos.getInt("aplicacion");

                PreparedStatement st3 = conexion.prepareStatement("INSERT INTO imprimir VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                st3.setInt(1, id);
                st3.setString(2, parcela);
                st3.setString(3, RS_Productos.getString("zafra"));
                st3.setString(4, RS_Productos.getString("nombre"));
                st3.setString(5, RS_Productos.getString("tipo"));
                st3.setString(6, RS_Productos.getString("tipo_aplicacion"));
                st3.setDouble(7, RS_Productos.getDouble("dosis"));
                st3.setDouble(8, RS_Productos.getDouble("hectareas"));
                st3.setDouble(9, RS_Productos.getDouble("total"));
                st3.setDouble(10, RS_Productos.getDouble("hectareas") * RS_Productos.getDouble("precio_app") * RS_Productos.getDouble("dosis"));
                st3.setInt(11, RS_Productos.getInt("aplicacion"));
                st3.setDouble(12, 0);
                st3.setDate(13, RS_Productos.getDate("fecha"));
                if (RS_Productos.getInt("aplicacion") > 0) {
                    st3.setString(14, RS_Productos.getString("aplicacion"));
                } else {
                    st3.setString(14, " ");
                }
                st3.executeUpdate();

                total = total + RS_Productos.getDouble("hectareas") * RS_Productos.getDouble("precio_app") * RS_Productos.getDouble("dosis");

                id = id + 1;

            }

            if (entro == true) {

                PreparedStatement st3 = conexion.prepareStatement("INSERT INTO imprimir VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                st3.setInt(1, id);
                st3.setString(2, parcela);
                st3.setString(3, " ");
                st3.setString(4, " --------- COSTOS DE LA APLICACION  ");
                st3.setString(5, " ");
                st3.setString(6, "  ");
                st3.setDouble(7, 0);
                st3.setDouble(8, 0);
                st3.setDouble(9, 0);
                st3.setDouble(10, total);
                st3.setInt(11, 0);
                st3.setInt(12, 0);
                st3.setDate(13, null);
                st3.executeUpdate();
            }

            Map parametros = new HashMap();

            String reporte_dir = path + "aplicacion_de_productos.jasper";
//            if (uso_de_productos_listado_id_parcela != 0) {
//                reporte_dir = path + "aplicacion_productos_parcela.jasper";
//                parametros.put("id_parcela", uso_de_productos_listado_id_parcela);
//            }
//            if ((uso_de_productos_listado_id_parcela != 0) && (uso_de_productos_listado_id_zafra != 0)) {
//                reporte_dir = path + "aplicacion_productos_parcela_zafra.jasper";
//                parametros.put("id_parcela", uso_de_productos_listado_id_parcela);
//                parametros.put("id_zafra", uso_de_productos_listado_id_zafra);
//            }
//            if ((uso_de_productos_listado_id_parcela != 0)
//                    && (uso_de_productos_listado_id_zafra != 0)
//                    && (uso_de_productos_listado_id_cultivo != 0)) {
//                reporte_dir = path + "aplicacion_productos_parcela_zafra_cultivo.jasper";
//                parametros.put("id_parcela", uso_de_productos_listado_id_parcela);
//                parametros.put("id_zafra", uso_de_productos_listado_id_zafra);
//                parametros.put("id_cultivo", uso_de_productos_listado_id_cultivo);
//            }
            total = 0;
            ST_Productos = conexion.createStatement();
            RS_Productos = ST_Productos.executeQuery(""
                    + "select *, producto_aplicacion_detalle.precio as precio_app   from producto_aplicacion "
                    + "inner join parcela on parcela.id_parcela = producto_aplicacion.id_parcela "
                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = producto_aplicacion.id_granos_tipo "
                    + "inner join zafra on zafra.id_zafra= producto_aplicacion.id_zafra "
                    + "inner join producto_aplicacion_detalle on producto_aplicacion_detalle.id_producto_aplicacion = producto_aplicacion.id_producto_aplicacion "
                    + "inner join productos on productos.id_producto = producto_aplicacion_detalle.id_producto "
                    + "where fecha >= '" + desde_str + "' and fecha <= '" + hasta_str + "' "
                    + "and producto_aplicacion.id_parcela = '" + uso_de_productos_listado_id_parcela + "' "
                    + "and producto_aplicacion.id_zafra = '" + uso_de_productos_listado_id_zafra + "' "
                    + "and producto_aplicacion.id_granos_tipo = '" + uso_de_productos_listado_id_cultivo + "' ");
            while (RS_Productos.next()) {
                total = total + RS_Productos.getDouble("hectareas") * RS_Productos.getDouble("precio_app") * RS_Productos.getDouble("dosis");
            }

            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            parametros.put("total", total);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Stock_de_productos() {
        try {

            String reporte_dir = path + "stock.jasper";

            Statement st = conexion.createStatement();
            st.executeUpdate("truncate table listados");

            int compras = 0;
            int ventas = 0;
            int stock = 0;

            Statement ST_Productos = conexion.createStatement();
            ResultSet RS_Productos = ST_Productos.executeQuery("select * from productos order by nombre");
            while (RS_Productos.next()) {

                Statement st_compras = conexion.createStatement();
                ResultSet rs_compras = st_compras.executeQuery(""
                        + "SELECT SUM(unidades) "
                        + "FROM facturas_compra_detalle "
                        + "where id_producto = '" + RS_Productos.getInt("id_producto") + "'");
                if (rs_compras.next()) {
                    compras = rs_compras.getInt(1);
                }

                Statement st_ventas = conexion.createStatement();
                ResultSet rs_ventas = st_ventas.executeQuery(""
                        + "SELECT SUM(unidad) "
                        + "FROM venta_detalle "
                        + "where id_producto = '" + RS_Productos.getInt("id_producto") + "'");
                if (rs_ventas.next()) {
                    ventas = rs_ventas.getInt(1);
                }

                Statement st_max = conexion.createStatement();
                ResultSet rs_max = st_max.executeQuery("SELECT MAX(id) FROM listados");
                if (rs_max.next()) {
                    id = rs_max.getInt(1) + 1;
                }

                stock = compras - ventas;

                PreparedStatement st3 = conexion.prepareStatement("INSERT INTO listados VALUES(?,?,?)");
                st3.setInt(1, id);
                st3.setString(2, RS_Productos.getString("nombre").toUpperCase());
                st3.setInt(3, stock);
                st3.executeUpdate();

                compras = 0;
                ventas = 0;
                stock = 0;

            }

            Map parametros = new HashMap();
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Ventas_listado_imprimir(Date desde, Date hasta) {
        try {

            float total_gs = 0;
            float total_usd = 0;

            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery("select SUM(total) from venta where id_moneda ='1' and fecha >= '" + desde + "' and fecha <= '" + hasta + "' ");
            while (RS_Recepcion2.next()) {
                total_gs = RS_Recepcion2.getFloat(1);
            }

            RS_Recepcion2 = ST_Recepcion2.executeQuery("select SUM(total) from venta where id_moneda ='2' and fecha >= '" + desde + "' and fecha <= '" + hasta + "'  ");
            while (RS_Recepcion2.next()) {
                total_usd = RS_Recepcion2.getFloat(1);
            }

            String reporte_dir = path + "ventas_listado_dia.jasper";
            Map parametros = new HashMap();

            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            parametros.put("total_gs", total_gs);
            parametros.put("total_usd", total_usd);

            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }

    }

    public synchronized static void Compras_listado_imprimir(Date desde, Date hasta) {
        try {

            float total_gs = 0;
            float total_usd = 0;

//            Statement ST_Recepcion2 = conexion.createStatement();
//            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery(""
//                    + "select SUM(total) "
//                    + "from compras where id_moneda ='1' "
//                    + "and fecha >= '" + desde + "' and fecha <= '" + hasta + "' ");
//            while (RS_Recepcion2.next()) {
//                total_gs = RS_Recepcion2.getFloat(1);
//            }
//
//            RS_Recepcion2 = ST_Recepcion2.executeQuery("select SUM(total) from venta where id_moneda ='2' and fecha >= '" + desde + "' and fecha <= '" + hasta + "'  ");
//            while (RS_Recepcion2.next()) {
//                total_usd = RS_Recepcion2.getFloat(1);
//            }
            String reporte_dir = path + "compras_listado_dia.jasper";
            Map parametros = new HashMap();

            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
//            parametros.put("total_gs", total_gs);
//            parametros.put("total_usd", total_usd);

            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }

    }

    public synchronized static void Liquidaciones_multiples_imprimir() {

        try {
            String reporte_dir = path + "liquidaciones_multiples.jasper";

            Map parametros = new HashMap();

            parametros.put("direccion", path + "\\liquidaciones_multiples_detalle.");

            Metodos.imagen = ubicacion_reportes + "\\reportes\\logo.jpg";
            if (ismac == true) {
                Metodos.imagen = ubicacion_reportes + "//reportes//logo.jpg";
            }
            parametros.put("imagen", imagen);

            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Venta_imprimir_pagare() {

        try {
            String reporte_dir = path + "pagare.jasper";

            Map parametros = new HashMap();

            parametros.put("id_pagare", id_pagare);

            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Recibo_imprimir() {

        try {
            long total = 0;
            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery("select * from recibo where id_recibo='" + id_recibo + "'");
            while (RS_Recepcion2.next()) {
                total = RS_Recepcion2.getLong("cantidad");
            }
            String reporte_dir = path + "recibo.jasper";

            Map parametros = new HashMap();

            parametros.put("id_recibo", id_recibo);
            parametros.put("cantidad_string", Numero_a_String(total));

            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (SQLException | ClassNotFoundException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Sueldos_imprimir() {

        try {
            String reporte_dir = path + "sueldos.jasper";

            Map parametros = new HashMap();
            parametros.put("id_sueldo", id_sueldo);
            parametros.put("empresa", empresa);
            parametros.put("empresa_datos", empresa_datos);
            parametros.put("imagen", imagen);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Listado_Movimientos_remitente_imprimir(Date desde, Date hasta) {
        try {
            Map parametros = new HashMap();
            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            parametros.put("id_remitente", listado_id_remitente);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(ubicacion_reportes + "recepcion_listado_remitente.jasper");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void combustible_venta_imprimir() {
        try {
            String reporte_dir = path + "combustibles.jasper";
            Map parametros = new HashMap();
            parametros.put("id_combustible_venta", id_combustible_venta);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Contratos_imprimir() {

        try {
            String reporte_dir = path + "contratos.jasper";
//            Stock_de_granos2();

            Map parametros = new HashMap();
//            parametros.put("desde", Listado_recepciones.jDateChooser_desde.getDate());
//            parametros.put("hasta", Listado_recepciones.jDateChooser_hasta.getDate());
//            parametros.put("total", cant);
            parametros.put("imagen", imagen);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Tickets_imprimir() {

        try {
            String reporte_dir = path + "tickets.jasper";
            Map parametros = new HashMap();
            parametros.put("id_recepcion", id_ticket);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Listado_Combustible_imprimir(Date desde, Date hasta) {
        try {
            String reporte_dir = path + "combustibles_listado.jasper";
            Map parametros = new HashMap();
            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            parametros.put("imagen", imagen);
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Listado_Movimientos_pendientes_imprimir(Date desde, Date hasta) {
        try {
            int id_duenho = 0;
            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery("select * from cliente where duenho = '1'");
            while (RS_Recepcion2.next()) {
                id_duenho = RS_Recepcion2.getInt("id_cliente");
            }
            String reporte = "listado_movimientos_pendientes.jasper";
            if (listado_recepcion_pendiente_id_cliente == 0) {
                reporte = "listado_movimientos_pendientes_all.jasper";
            }

            Map parametros = new HashMap();
            parametros.put("id_cliente", listado_recepcion_pendiente_id_cliente);
            parametros.put("id_duenho", id_duenho);
            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            String reporte_dir = path + reporte;
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Listado_Movimientos_liquidados_imprimir(Date desde, Date hasta) {
        try {
            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery("select * from cliente where duenho = '1'");
            while (RS_Recepcion2.next()) {
                id_cliente = RS_Recepcion2.getInt("id_cliente");
            }

            Map parametros = new HashMap();
            parametros.put("id_cliente", id_cliente);
            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            String reporte_dir = path + "listado_movimientos_liquidados.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Productos_uso_imprimir() {

        try {
            Map parametros = new HashMap();

            String reporte_dir = path + "productos_uso.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Listado_Movimientos_parcela_imprimir(String parcela, Date desde, Date hasta) {

        try {
            long neto = 0;
            long neto_sin_descuento = 0;
            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery(""
                    + "SELECT sum(total_neto_carga) "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and id_parcela = '" + id_parcela + "' "
                    + "and movimiento = '1' ");
            while (RS_Recepcion2.next()) {
                neto = RS_Recepcion2.getInt(1);
            }
            Statement ST_Recepcion25 = conexion.createStatement();
            ResultSet RS_Recepcion25 = ST_Recepcion25.executeQuery(""
                    + "SELECT sum(peso_neto) "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and id_parcela = '" + id_parcela + "' "
                    + "and movimiento = '1' ");
            while (RS_Recepcion25.next()) {
                neto_sin_descuento = RS_Recepcion25.getInt(1);
            }
            Statement ST_Recepcion21 = conexion.createStatement();
            ResultSet RS_Recepcion21 = ST_Recepcion21.executeQuery(""
                    + "SELECT sum(total_neto_carga) "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and id_parcela = '" + id_parcela + "' "
                    + "and movimiento = '2' ");
            while (RS_Recepcion21.next()) {
                neto = neto - RS_Recepcion21.getInt(1);
            }
            Statement ST_Recepcion216 = conexion.createStatement();
            ResultSet RS_Recepcion216 = ST_Recepcion216.executeQuery(""
                    + "SELECT sum(peso_neto) "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and id_parcela = '" + id_parcela + "' "
                    + "and movimiento = '2' ");
            while (RS_Recepcion216.next()) {
                neto_sin_descuento = neto_sin_descuento - RS_Recepcion216.getInt(1);
            }

            Map parametros = new HashMap();
            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            parametros.put("id_parcela", id_parcela);
            parametros.put("parcela", parcela);
            parametros.put("neto", neto);
            parametros.put("neto_sin_descuento", neto_sin_descuento);
            parametros.put("imagen", imagen);

            String reporte_dir = path + "listado_movimientos_por_parcela.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Listado_Movimientos_cliente_imprimir(String parcela, Date desde, Date hasta) {
        try {
            long neto = 0;
            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery(""
                    + "SELECT sum(total_neto_carga) "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and recepcion.id_cliente = '" + id_cliente + "' "
                    + "and movimiento = '1' ");
            while (RS_Recepcion2.next()) {
                neto = RS_Recepcion2.getInt(1);
            }
            Statement ST_Recepcion21 = conexion.createStatement();
            ResultSet RS_Recepcion21 = ST_Recepcion21.executeQuery(""
                    + "SELECT sum(total_neto_carga) "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and recepcion.id_cliente = '" + id_cliente + "' "
                    + "and movimiento = '2' ");
            while (RS_Recepcion21.next()) {
                neto = neto - RS_Recepcion21.getInt(1);
            }

            Map parametros = new HashMap();

            String reporte_dir = path + "listado_movimientos_por_cliente.jasper";

            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            parametros.put("id_cliente", id_cliente);
            parametros.put("neto", neto);
            parametros.put("imagen", imagen);

            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Listado_Movimientos_usuario_imprimir(String parcela, Date desde, Date hasta) {
        try {
            long neto = 0;
            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery(""
                    + "SELECT sum(total_neto_carga) "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and recepcion.id_usuario = '" + id_usuario_buscar + "' "
                    + "and movimiento = '1' ");
            while (RS_Recepcion2.next()) {
                neto = RS_Recepcion2.getInt(1);
            }
            Statement ST_Recepcion21 = conexion.createStatement();
            ResultSet RS_Recepcion21 = ST_Recepcion21.executeQuery(""
                    + "SELECT sum(total_neto_carga) "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and recepcion.id_usuario = '" + id_usuario_buscar + "' "
                    + "and movimiento = '2' ");
            while (RS_Recepcion21.next()) {
                neto = neto - RS_Recepcion21.getInt(1);
            }

            Map parametros = new HashMap();

            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            parametros.put("id_usuario", id_usuario_buscar);
            parametros.put("neto", neto);

            String reporte_dir = path + "listado_movimientos_por_usuario.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Listado_Movimientos_conductor_imprimir(String parcela, Date desde, Date hasta) {
        try {
            long neto = 0;
            Statement ST_Recepcion2 = conexion.createStatement();
            ResultSet RS_Recepcion2 = ST_Recepcion2.executeQuery(""
                    + "SELECT *, chofer.nombre as chonombre "
                    + "FROM recepcion "
                    + "INNER JOIN cliente "
                    + "ON recepcion.id_cliente = cliente.id_cliente "
                    + "INNER JOIN parcela "
                    + "ON recepcion.id_parcela = parcela.id_parcela "
                    + "INNER JOIN chofer "
                    + "ON recepcion.id_chofer = chofer.id_chofer "
                    + "inner join granos_tipo "
                    + "on recepcion.id_granos_tipo = granos_tipo.id_granos_tipo "
                    + " where fecha >= '" + desde + "' "
                    + " and fecha <= '" + hasta + "' "
                    + "and recepcion.borrado_int != '1' "
                    + "and recepcion.id_chofer = '" + id_chofer + "'");
            while (RS_Recepcion2.next()) {
                neto = neto + (RS_Recepcion2.getLong("peso_neto") * RS_Recepcion2.getLong("precio_del_flete") * RS_Recepcion2.getLong("porcentaje")) / 100;
            }

            Map parametros = new HashMap();

            parametros.put("desde", desde);
            parametros.put("hasta", hasta);
            parametros.put("id_chofer", id_chofer);
            parametros.put("neto", neto);

            String reporte_dir = path + "listado_movimientos_por_conductor.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(reporte_dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }
//
//    public static void Transportista_clear() {
//        id_transportista = 0;
//        Transportista_ABM.jTextField_ci.setText("0");
//        Transportista_ABM.jTextField_ruc.setText("");
//        Transportista_ABM.jTextField_telefono.setText("");
//        Transportista_ABM.jTextField_direccion.setText("");
//        Transportista_ABM.jTextField_nombre.setText("");
//    }
//
//    public static void Cliente_clear() {
//        id_cliente = 0;
//        Cliente.jTextField_nombre.setText("");
//        Cliente.jTextField_direccion.setText("");
//        Cliente.jTextField_ruc.setText("");
//        Cliente.jTextField_telefono.setText("");
//        Cliente.jTextField_nombre.requestFocus();
//    }
//
//    public static void Chofer_clear() {
//        id_chofer_nuevo = 0;
//        Conductor_ABM.jTextField_nombre.setText("");
//        Conductor_ABM.jTextField_direccion.setText("");
//        Conductor_ABM.jTextField_ci.setText("");
//        Conductor_ABM.jTextField_telefono.setText("");
//        Conductor_ABM.jTextField_nombre.requestFocus();
//    }
//
//    public static void Carreta_clear() {
//        id_carreta = 0;
//        Carreta_ABM.jTextField_marca.setText("");
//        Carreta_ABM.jTextField_anho.setText("");
//        Carreta_ABM.jTextField_chapa.setText("");
//        Carreta_ABM.jTextField_modelo.setText("");
//        Carreta_ABM.jTextField_marca.requestFocus();
//    }

    public synchronized static void Transportista_guardar(
            String nombre, String ci, String ruc, String direccion, String telefono) {
        try {

            if ((nombre == null) && (nombre.length() < 1)) {
                JOptionPane.showMessageDialog(null, "Ingresar el Nombre");
            } else if (id_transportista == 0) {

                int id = 0;
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_transportista) FROM transportista");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO transportista VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, nombre);
                stUpdateProducto.setString(3, ruc);
                stUpdateProducto.setString(4, ci);
                stUpdateProducto.setString(5, telefono);
                stUpdateProducto.setString(6, direccion);
                stUpdateProducto.setString(7, "-");
                stUpdateProducto.setInt(8, 0);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE trasnportista "
                        + " SET nombre ='" + nombre + "',"
                        + " direccion ='" + direccion + "',"
                        + " telefono ='" + telefono + "',"
                        + " ruc ='" + ruc + "',"
                        + " ci ='" + ci + "' "
                        + " WHERE id_trasportista = '" + id_transportista + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Combustibles_uso_guardar(Date fecha, String litros, String descripcion) {
        try {

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_combustible_uso) FROM combustible_uso");
            if (result.next()) {
                id_combustible_uso = result.getInt(1) + 1;
            }

            if (litros.length() > 0) {
                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO combustible_uso VALUES(?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_combustible_uso);
                stUpdateProducto.setDate(2, util_Date_to_sql_date(fecha));
                stUpdateProducto.setInt(3, Integer.parseInt(litros));
                stUpdateProducto.setString(4, descripcion);
                stUpdateProducto.setInt(5, combustibles_uso_id_vehiculo);
                stUpdateProducto.setInt(6, combustible_uso_id_personal);
                stUpdateProducto.setInt(7, id_sucursal);
                stUpdateProducto.executeUpdate();

//                Combustibles_uso_clear();

            } else {

                JOptionPane.showMessageDialog(null, "Ingresa un valor en litros.");

            }

        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Combustibles_venta_guardar(Date fecha, String litros, String descripcion, String precio) {
        try {

            if (id_combustible_venta == 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_combustible_venta) FROM combustible_venta");
                if (result.next()) {
                    id_combustible_venta = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO combustible_venta VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_combustible_venta);
                stUpdateProducto.setDate(2, util_Date_to_sql_date(fecha));
                stUpdateProducto.setInt(3, Integer.parseInt(litros));
                stUpdateProducto.setString(4, descripcion);
                stUpdateProducto.setInt(5, combustible_venta_id_cliente);
                stUpdateProducto.setInt(6, id_sucursal);
                stUpdateProducto.setLong(7, Long.parseLong(precio));
                stUpdateProducto.setLong(8, (Long.parseLong(litros) * Long.parseLong((precio))));
                stUpdateProducto.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente.");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE combustible_venta "
                        + " SET id_cliente ='" + combustible_venta_id_cliente + "', "
                        + " precio ='" + Long.parseLong(precio) + "', "
                        + " fecha ='" + util_Date_to_sql_date(fecha) + "', "
                        + " litros ='" + Integer.parseInt(litros) + "', "
                        + " descripcion ='" + descripcion + "', "
                        + " total ='" + Long.parseLong(litros) * Long.parseLong(precio) + "' "
                        + " WHERE id_combustible_venta = '" + id_combustible_venta + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }

        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Contrato_guardar(String contrato, String toneladas, String premio, Date fecha) {
        try {
            if (id_contrato == 0) {
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_contrato) FROM contrato");
                if (result.next()) {
                    id_contrato = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO contrato VALUES(?,?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_contrato);
                stUpdateProducto.setLong(2, Long.parseLong(premio));
                stUpdateProducto.setInt(3, id_contrato);
                stUpdateProducto.setDate(4, util_Date_to_sql_date(fecha));
                stUpdateProducto.setDouble(5, Double.valueOf(toneladas));
                stUpdateProducto.setInt(6, contratos_id_zafra);
                stUpdateProducto.setInt(7, contratos_id_cliente);
                stUpdateProducto.setInt(8, 1);
                stUpdateProducto.setString(9, "ACTIVO");
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE contrato "
                        + " SET id_cliente ='" + contratos_id_cliente + "', "
                        + " premio ='" + Long.parseLong(premio) + "', "
                        + " nro ='" + Integer.parseInt(contrato) + "', "
                        + " fecha ='" + util_Date_to_sql_date(fecha) + "', "
                        + " tonelada ='" + Double.valueOf(toneladas) + "', "
                        + " id_zafra ='" + contratos_id_zafra + "' "
                        + " WHERE id_contrato = '" + id_contrato + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Zafra_guardar(String zafra) {
        try {
            if (id_zafra == 0) {
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_zafra) FROM zafra");
                if (result.next()) {
                    id_zafra = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO zafra VALUES(?,?)");
                stUpdateProducto.setInt(1, id_zafra);
                stUpdateProducto.setString(2, zafra);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE zafra "
                        + " SET zafra ='" + nombre + "' "
                        + " WHERE id_zafra = '" + id_zafra + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Empleado_guardar(
            String nombre, String ci, String telefono, String descripcion, String salario) {
        try {

            if (id_empleado == 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_empleado) FROM empleado");
                if (result.next()) {
                    id_empleado = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO empleado VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_empleado);
                stUpdateProducto.setString(2, nombre);
                stUpdateProducto.setString(3, ci);
                stUpdateProducto.setString(4, telefono);
                stUpdateProducto.setString(5, "");
                stUpdateProducto.setString(6, descripcion);
                stUpdateProducto.setLong(7, Long.parseLong(salario.replace(".", "")));
                stUpdateProducto.setInt(8, id_empleado_cargo);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE empleado "
                        + " SET nombre ='" + nombre + "',"
                        + " ci ='" + ci + "',"
                        + " telefono ='" + telefono + "',"
                        + " descripcion_del_trabajo ='" + descripcion + "',"
                        + " id_empleado_cargo ='" + id_empleado_cargo + "',"
                        + " salario ='" + Long.parseLong(salario.replace(".", "")) + "' "
                        + " WHERE id_empleado = '" + id_empleado + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Camion_guardar(
            String marca, String modelo, String anho, String chapa) {
        try {

            if ((marca == null) && (marca.length() < 1) && (id_transportista > 0)) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos");
            } else if (id_camion == 0) {

                int id = 0;
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_camion) FROM camion");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO camion VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, marca);
                stUpdateProducto.setString(3, modelo);
                stUpdateProducto.setString(4, anho);
                stUpdateProducto.setString(5, chapa);
                stUpdateProducto.setString(6, "-");
                stUpdateProducto.setInt(7, id_transportista);
                stUpdateProducto.setInt(8, 0);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE camion "
                        + " SET marca ='" + marca + "',"
                        + " modelo ='" + modelo + "',"
                        + " anho ='" + anho + "',"
                        + " id_transportista ='" + id_transportista + "',"
                        + " chapa ='" + chapa + "' "
                        + " WHERE id_camion = '" + id_camion + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
//            Camion_clear();
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Tecnologia_guardar(String tecnologia) {
        try {

            if (id_tecnologia == 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_variedad) FROM variedad");
                if (result.next()) {
                    id_tecnologia = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO variedad VALUES(?,?,?)");
                stUpdateProducto.setInt(1, id_tecnologia);
                stUpdateProducto.setString(2, tecnologia);
                stUpdateProducto.setInt(3, 1); // soja
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE variedad "
                        + " SET variedad ='" + tecnologia + "',"
                        + " id_granos_tipo ='" + 1 + "' "
                        + " WHERE id_variedad = '" + id_tecnologia + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Vehiculos_guardar(
            String tipo, String modelo, String descripcion) {
        try {

            if (id_vehiculo == 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_vehiculo) FROM vehiculo");
                if (result.next()) {
                    id_vehiculo = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO vehiculo VALUES(?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_vehiculo);
                stUpdateProducto.setString(2, tipo);
                stUpdateProducto.setString(3, modelo);
                stUpdateProducto.setString(4, "");
                stUpdateProducto.setString(5, descripcion);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE vehiculo "
                        + " SET tipo ='" + tipo + "',"
                        + " modelo ='" + modelo + "',"
                        + " descripcion ='" + descripcion + "' "
                        + " WHERE id_vehiculo = '" + id_vehiculo + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Combustibles_guardar(
            String factura, String litros, Date fecha) {
        try {
            if (id_combustible == 0) {
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_combustible) FROM combustible");

                if (result.next()) {
                    id_combustible = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO combustible VALUES(?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_combustible);
                stUpdateProducto.setString(2, factura);
                stUpdateProducto.setDate(3, util_Date_to_sql_date(fecha));
                stUpdateProducto.setLong(4, Long.parseLong(litros));
                stUpdateProducto.setLong(5, 0);
                stUpdateProducto.setInt(6, id_sucursal);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");

            } else {

                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE combustible "
                        + " SET factura ='" + factura + "',"
                        + " fecha ='" + util_Date_to_sql_date(fecha) + "',"
                        + " litros ='" + Long.parseLong(litros) + "',"
                        + " precio ='0' "
                        + " WHERE id_combustible = '" + id_combustible + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");

            }
            //Camion_clear();
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Zafra_guardar(
            String marca, String modelo, String anho, String chapa) {
        try {

            if ((marca == null) && (marca.length() < 1) && (id_transportista > 0)) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos");
            } else if (id_camion == 0) {

                int id = 0;
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_camion) FROM camion");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO camion VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, marca);
                stUpdateProducto.setString(3, modelo);
                stUpdateProducto.setString(4, anho);
                stUpdateProducto.setString(5, chapa);
                stUpdateProducto.setString(6, "-");
                stUpdateProducto.setInt(7, id_transportista);
                stUpdateProducto.setInt(8, 0);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE camion "
                        + " SET marca ='" + marca + "',"
                        + " modelo ='" + modelo + "',"
                        + " anho ='" + anho + "',"
                        + " id_transportista ='" + id_transportista + "',"
                        + " chapa ='" + chapa + "' "
                        + " WHERE id_camion = '" + id_camion + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
//            Camion_clear();
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Proveedor_guardar(String nombre, String telefono, String ruc, String direccion, String descripcion, String nombre_vendedor, String telefono_vendedor) {
        try {

            if (id_proveedor == 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_proveedor) FROM proveedor");
                if (result.next()) {
                    id_proveedor = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO proveedor VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_proveedor);
                stUpdateProducto.setString(2, nombre);
                stUpdateProducto.setString(3, telefono);
                stUpdateProducto.setString(4, ruc);
                stUpdateProducto.setString(5, descripcion);
                stUpdateProducto.setString(6, direccion);
                stUpdateProducto.setString(7, nombre_vendedor);
                stUpdateProducto.setString(8, telefono_vendedor);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE proveedor "
                        + " SET nombre ='" + nombre + "', "
                        + " telefono ='" + telefono + "', "
                        + " ruc ='" + ruc + "', "
                        + " direccion ='" + direccion + "', "
                        + " descripcion ='" + descripcion + "', "
                        + " nombre_vendedor ='" + nombre_vendedor + "',  "
                        + " telefono_vendedor ='" + telefono_vendedor + "' "
                        + " WHERE id_proveedor = '" + id_proveedor + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Actualizado correctamente");
            }

        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Parcela_guardar(
            String parcela, String precio, String porcentaje, String has) {
        try {

            if (id_parcela == 0) {

                int id = 0;
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_parcela) FROM parcela");
                if (result.next()) {
                    id_parcela = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO parcela VALUES(?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_parcela);
                stUpdateProducto.setString(2, parcela);
                stUpdateProducto.setLong(3, Long.parseLong(precio));
                stUpdateProducto.setInt(4, Integer.parseInt(porcentaje));
                stUpdateProducto.setInt(5, Integer.parseInt(has));
                stUpdateProducto.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");

            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE parcela "
                        + " SET parcela ='" + parcela + "',"
                        + " precio_del_flete ='" + Long.parseLong(precio) + "', "
                        + " has ='" + Integer.parseInt(has) + "' "
                        + " WHERE id_parcela = '" + id_parcela + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }

        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Configuracion_guardar(
            String anho, String empresa, String telefono, String ruc, String direccion, String dolar) {
        try {
            PreparedStatement st = conexion.prepareStatement(
                    " UPDATE configuracion "
                    + " SET anho ='" + anho + "', "
                    + " telefono ='" + telefono + "', "
                    + " ruc ='" + ruc + "', "
                    + " dolar ='" + dolar + "', "
                    + " direccion ='" + direccion + "', "
                    + " empresa ='" + empresa + "' "
                    + "  ");
            st.executeUpdate();

            PreparedStatement ps2 = conexion.prepareStatement("select * from configuracion ");
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                titulo = rs2.getString("empresa") + " - " + nombre;
                empresa = rs2.getString("empresa").trim();
                empresa_datos = "RUC. " + rs2.getString("ruc").trim() + " - Telf." + rs2.getString("telefono").trim() + " - Dir." + rs2.getString("direccion").trim();
            }

            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos. ");
        }
    }

    public synchronized static void Cliente_guardar(
            String nombre, String direccion, String ruc, String telefono) {
        try {

            Conexion.Verificar_conexion();

            if ((nombre == null) && (nombre.length() < 1)) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos");
            } else if (id_cliente == 0) {

                int id = 0;
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_cliente) FROM cliente");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, nombre);
                stUpdateProducto.setString(3, direccion);
                stUpdateProducto.setString(4, telefono);
                stUpdateProducto.setString(5, "");
                stUpdateProducto.setString(6, "-");
                stUpdateProducto.setString(7, ruc);
                stUpdateProducto.setInt(8, 0);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE cliente "
                        + " SET nombre ='" + nombre + "',"
                        + " direccion ='" + direccion + "',"
                        + " telefono ='" + telefono + "',"
                        + " ruc ='" + ruc + "' "
                        + " WHERE id_cliente = '" + id_cliente + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
//            Cliente_clear();
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Producto_guardar(
            String descripcion, String precio, String ubicacion, String obs, String iva) {
        try {

            if (precio.length() > 0) {

            } else {
                precio = "0";
            }
            if (iva.length() > 0) {
            } else {
                iva = "0";
            }

            if (descripcion.length() > 0) {

                if (id_producto == 0) {
                    int id = 0;
                    Statement st1 = conexion.createStatement();
                    ResultSet result = st1.executeQuery("SELECT MAX(id_producto) FROM productos");
                    if (result.next()) {
                        id = result.getInt(1) + 1;
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                            + "INSERT INTO productos VALUES(?,?,?,?,?,?,?,?,?,?)");
                    stUpdateProducto.setInt(1, id);
                    stUpdateProducto.setInt(2, productos_id_proveedor);
                    stUpdateProducto.setString(3, descripcion);
                    stUpdateProducto.setDouble(4, Double.parseDouble(precio));
                    stUpdateProducto.setInt(5, Integer.parseInt(iva));
                    stUpdateProducto.setInt(6, 0);
                    stUpdateProducto.setInt(7, 0);
                    stUpdateProducto.setString(8, ubicacion);
                    stUpdateProducto.setString(9, obs);
                    stUpdateProducto.setInt(10, 0);
                    stUpdateProducto.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Guardado correctamente");
                } else {
                    PreparedStatement st = conexion.prepareStatement(
                            " UPDATE productos "
                            + " SET nombre ='" + descripcion + "', "
                            + " precio ='" + Long.parseLong(precio.replace(".", "")) + "', "
                            + " obs ='" + obs + "',"
                            + " iva ='" + Integer.parseInt(iva) + "', "
                            + " ubicacion ='" + ubicacion + "', "
                            + " id_proveedor ='" + productos_id_proveedor + "' "
                            + " WHERE id_producto = '" + id_producto + "'");
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Guardado correctamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Complete los campos.");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Chofer_guradar(
            String nombre, String direccion, String ci, String telefono) {
        try {

            if ((nombre == null) && (nombre.length() < 1)) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos");
            } else if (id_chofer_nuevo == 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_chofer) FROM chofer");
                if (result.next()) {
                    id_chofer_nuevo = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO chofer VALUES(?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_chofer_nuevo);
                stUpdateProducto.setString(2, nombre);
                stUpdateProducto.setString(3, ci);
                stUpdateProducto.setString(4, telefono);
                stUpdateProducto.setString(5, direccion);
                stUpdateProducto.setString(6, "-");
                stUpdateProducto.setInt(7, 0);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE chofer "
                        + " SET nombre ='" + nombre + "',"
                        + " direccion ='" + direccion + "',"
                        + " telefono ='" + telefono + "',"
                        + " ci ='" + ci + "' "
                        + " WHERE id_chofer = '" + id_chofer_nuevo + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
//            Chofer_clear();
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Carreta_guradar(
            String marca, String modelo, String chapa, String anho) {
        try {

            if ((marca == null) && (marca.length() < 1)) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos");
            } else if (id_carreta == 0) {

                int id = 0;
                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_carreta) FROM carreta");
                if (result.next()) {
                    id = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO carreta VALUES(?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id);
                stUpdateProducto.setString(2, marca);
                stUpdateProducto.setString(3, modelo);
                stUpdateProducto.setString(4, anho);
                stUpdateProducto.setString(5, chapa);
                stUpdateProducto.setString(6, "-");
                stUpdateProducto.setInt(7, 0);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE carreta "
                        + " SET marca ='" + marca + "',"
                        + " modelo ='" + modelo + "',"
                        + " chapa ='" + chapa + "',"
                        + " anho ='" + anho + "' "
                        + " WHERE id_carreta = '" + id_carreta + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
//            Carreta_clear();
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Empleado_cargo_guardar(
            String cargo) {
        try {
            if (id_empleado_cargo == 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_empleado_cargo) FROM empleado_cargo");
                if (result.next()) {
                    id_empleado_cargo = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement(""
                        + "INSERT INTO empleado_cargo VALUES(?,?)");
                stUpdateProducto.setInt(1, id_empleado_cargo);
                stUpdateProducto.setString(2, cargo);
                stUpdateProducto.executeUpdate();

                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE empleado_cargo "
                        + " SET cargo ='" + cargo + "',"
                        + " WHERE id_empleado_cargo = '" + id_empleado_cargo + "'");
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Compras_proveedor_update() {
        try {
            PreparedStatement st = conexion.prepareStatement(
                    " UPDATE facturas_compra "
                    + " SET id_proveedor ='" + compras_id_proveedor + "' "
                    + " WHERE id_facturas_compra = '" + id_facturas_compras + "'");
            st.executeUpdate();
            System.out.println("Proveedor actualizado");
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Compras_update_total() {
        try {
            float total = 0;
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT SUM(precio) FROM facturas_compra_detalle where id_facturas_compra = '" + id_facturas_compras + "'");
            if (result.next()) {
                total = result.getFloat(1);
            }

            PreparedStatement st = conexion.prepareStatement(
                    " UPDATE facturas_compra "
                    + " SET total ='" + total + "' "
                    + " WHERE id_facturas_compra = '" + id_facturas_compras + "'");
            st.executeUpdate();
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Compras_factura_update(String factura, Date fecha) {
        try {
            PreparedStatement st = conexion.prepareStatement(
                    " UPDATE facturas_compra "
                    + " SET numero ='" + factura + "', fecha = '" + util_Date_to_sql_date(fecha) + " ' "
                    + " WHERE id_facturas_compra = '" + id_facturas_compras + "'");
            st.executeUpdate();

        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static void Compras_fecha_update(Date fecha) {
        try {
            if (fecha != null) {
                PreparedStatement st = conexion.prepareStatement(
                        " UPDATE facturas_compra "
                        + " SET fecha ='" + util_Date_to_sql_date(fecha) + "' "
                        + " WHERE id_facturas_compra = '" + id_facturas_compras + "'");
                st.executeUpdate();
                System.out.println("Fecha actualizada");
            }
        } catch (NumberFormatException | SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }
//
//    public static void Camion_clear() {
//        id_transportista = 0;
//        Camion_ABM.jTextField_marca.setText("");
//        Camion_ABM.jTextField_modelo.setText("");
//        Camion_ABM.jTextField_anho.setText("");
//        Camion_ABM.jTextField_chapa.setText("");
//        Camion_ABM.jButton_borrar.setVisible(false);
//    }
//
//    public synchronized static void Recepcion_motivo_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_ABM.jTable_motivo.getModel();
//        recepcion_id_motivo = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_motivo.getSelectedRow(), 0)));
//        Recepcion_ABM.jTextField_motivo.setText(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_motivo.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Productos_aplicacion_abm_productos_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_productos.getModel();
//        productos_aplicacion_abm_id_producto = Integer.parseInt(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_productos.getSelectedRow(), 0)));
//        Productos_aplicacion_ABM.jTextField_producto.setText(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_productos.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void TablaAD_concepto_selected() {
//        DefaultTableModel tm = (DefaultTableModel) TablaAD.jTable_concepto.getModel();
//        tabla_ad_id_concepto = Integer.parseInt(String.valueOf(tm.getValueAt(TablaAD.jTable_concepto.getSelectedRow(), 0)));
//        TablaAD.jTextField_concepto.setText(String.valueOf(tm.getValueAt(TablaAD.jTable_concepto.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Productos_aplicacion_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_buscar.getModel();
//        id_producto_aplicacion = Integer.parseInt(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_buscar.getSelectedRow(), 0)));
//
//    }
//
//    public synchronized static void Productos_aplicacion_abm_zafra_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_zafra.getModel();
//        Productos_aplicacion_abm_id_zafra = Integer.parseInt(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_zafra.getSelectedRow(), 0)));
//        Productos_aplicacion_ABM.jTextField_zafra.setText(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_zafra.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_motivo_descuento_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_ABM.jTable_motivo_de_descuento.getModel();
//        recepcion_id_motivo_de_descuento = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_motivo_de_descuento.getSelectedRow(), 0)));
//        Recepcion_ABM.jTextField_motivo_descuento.setText(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_motivo_de_descuento.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_detalle_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_ABM.jTable_detalle.getModel();
//        recepcion_id_recepcion_detalle = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_detalle.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Productos_aplicacion_detalle_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_detalle.getModel();
//        productos_aplicacion_detalle_id_producto_aplicacion_detalle = Integer.parseInt(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_detalle.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Compras_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Compras.jTable_buscar.getModel();
//        id_facturas_compras = Integer.parseInt(String.valueOf(tm.getValueAt(Compras.jTable_buscar.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Compras_detalle_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Compras.jTable1.getModel();
//        id_facturas_compras_detalle = Integer.parseInt(String.valueOf(tm.getValueAt(Compras.jTable1.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Recibo_de_dinero_recibos_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recibo_de_dinero.jTable_recibos.getModel();
//        id_recibo = Integer.parseInt(String.valueOf(tm.getValueAt(Recibo_de_dinero.jTable_recibos.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Recibo_de_dinero_cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recibo_de_dinero.jTable_cliente.getModel();
//        recibo_de_dinero_id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Recibo_de_dinero.jTable_cliente.getSelectedRow(), 0)));
//        Recibo_de_dinero.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Recibo_de_dinero.jTable_cliente.getSelectedRow(), 1)).trim());
//    }
//
//    public synchronized static void Recibo_de_dinero_moneda_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recibo_de_dinero.jTable_moneda.getModel();
//        recibo_de_dinero_id_moneda = Integer.parseInt(String.valueOf(tm.getValueAt(Recibo_de_dinero.jTable_moneda.getSelectedRow(), 0)));
//        Recibo_de_dinero.jTextField_moneda.setText(String.valueOf(tm.getValueAt(Recibo_de_dinero.jTable_moneda.getSelectedRow(), 1)).trim());
//    }
//
//    public synchronized static void Recibo_de_dinero_banco_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recibo_de_dinero.jTable_banco.getModel();
//        recibo_de_dinero_id_banco = Integer.parseInt(String.valueOf(tm.getValueAt(Recibo_de_dinero.jTable_banco.getSelectedRow(), 0)));
//        Recibo_de_dinero.jTextField_banco.setText(String.valueOf(tm.getValueAt(Recibo_de_dinero.jTable_banco.getSelectedRow(), 1)).trim());
//    }
//
//    public synchronized static void Producto_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Productos_listado.jTable1.getModel();
//        id_producto = Integer.parseInt(String.valueOf(tm.getValueAt(Productos_listado.jTable1.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void TablaAD_tipo_selected() {
//        DefaultTableModel tm = (DefaultTableModel) TablaAD.jTable_tipo.getModel();
//        tabla_ad_id_tipo = Integer.parseInt(String.valueOf(tm.getValueAt(TablaAD.jTable_tipo.getSelectedRow(), 0)));
//        TablaAD.jTextField_tipo.setText(String.valueOf(tm.getValueAt(TablaAD.jTable_tipo.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Liquidaciones_multiples_moneda_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Liquidaciones_multiples.jTable_moneda.getModel();
//        id_moneda = Integer.parseInt(String.valueOf(tm.getValueAt(Liquidaciones_multiples.jTable_moneda.getSelectedRow(), 0)));
//        Liquidaciones_multiples.jTextField_moneda.setText(String.valueOf(tm.getValueAt(Liquidaciones_multiples.jTable_moneda.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Liquidaciones_multiples_recepcion_jtable_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Liquidaciones_multiples.jTable_recepciones.getModel();
//        liquidaciones_multiples_id_recepcion = Integer.parseInt(String.valueOf(tm.getValueAt(Liquidaciones_multiples.jTable_recepciones.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Liquidaciones_multiples_seleccionado_jtable_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Liquidaciones_multiples.jTable_seleccionadas.getModel();
//        liquidaciones_multiples_id_recepcion = Integer.parseInt(String.valueOf(tm.getValueAt(Liquidaciones_multiples.jTable_seleccionadas.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Sueldo_detalle_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Personales_pagos_ABM.jTable_detalle.getModel();
//        id_sueldo_detalle = Integer.parseInt(String.valueOf(tm.getValueAt(Personales_pagos_ABM.jTable_detalle.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Personales_suledo_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Personales_pagos_ABM.jTable_sueldos.getModel();
//        id_sueldo = Integer.parseInt(String.valueOf(tm.getValueAt(Personales_pagos_ABM.jTable_sueldos.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Personales_pagos_concepto_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Personales_pagos_ABM.jTable_concepto.getModel();
//        personales_pagos_id_concepto = Integer.parseInt(String.valueOf(tm.getValueAt(Personales_pagos_ABM.jTable_concepto.getSelectedRow(), 0)));
//        Personales_pagos_ABM.jTextField_concepto.setText(String.valueOf(tm.getValueAt(Personales_pagos_ABM.jTable_concepto.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Personales_pagos_empleado_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Personales_pagos_ABM.jTable_empleado.getModel();
//        personales_pagos_id_empleado = Integer.parseInt(String.valueOf(tm.getValueAt(Personales_pagos_ABM.jTable_empleado.getSelectedRow(), 0)));
//        Personales_pagos_ABM.jTextField_empleado.setText(String.valueOf(tm.getValueAt(Personales_pagos_ABM.jTable_empleado.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Personales_pago_mes_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Personales_pagos_ABM.jTable_mes.getModel();
//        personales_pago_id_mes = Integer.parseInt(String.valueOf(tm.getValueAt(Personales_pagos_ABM.jTable_mes.getSelectedRow(), 0)));
//        Personales_pagos_ABM.jTextField_mes.setText(String.valueOf(tm.getValueAt(Personales_pagos_ABM.jTable_mes.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Consultas_seleccionar_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Consultas.jTable_movimientos.getModel();
//        consultas_id_recepcion = Integer.parseInt(String.valueOf(tm.getValueAt(Consultas.jTable_movimientos.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Conultas_estado_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Consultas.jTable_estado.getModel();
//        consultas_id_estado = Integer.parseInt(String.valueOf(tm.getValueAt(Consultas.jTable_estado.getSelectedRow(), 0)));
//        Consultas.jTextField_estado.setText(String.valueOf(tm.getValueAt(Consultas.jTable_estado.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Consultas_seleccionado_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Consultas.jTable_seleccionados.getModel();
//        consultas_id_recepcion = Integer.parseInt(String.valueOf(tm.getValueAt(Consultas.jTable_seleccionados.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Consultas_cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Consultas.jTable_clientes.getModel();
//        consultas_id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Consultas.jTable_clientes.getSelectedRow(), 0)));
//        Consultas.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Consultas.jTable_clientes.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Compras_proveedor_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Compras.jTable_proverdor.getModel();
//        compras_id_proveedor = Integer.parseInt(String.valueOf(tm.getValueAt(Compras.jTable_proverdor.getSelectedRow(), 0)));
//        Compras.jT_Proveedor.setText(String.valueOf(tm.getValueAt(Compras.jTable_proverdor.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Tecnologia_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Tecnologia.jTable_tecnologia.getModel();
//        id_tecnologia = Integer.parseInt(String.valueOf(tm.getValueAt(Tecnologia.jTable_tecnologia.getSelectedRow(), 0)));
//        Tecnologia.jTextField_tecnologia.setText(String.valueOf(tm.getValueAt(Tecnologia.jTable_tecnologia.getSelectedRow(), 1)));
//        Tecnologia.jTextField_tipo_de_grano.setText(String.valueOf(tm.getValueAt(Tecnologia.jTable_tecnologia.getSelectedRow(), 2)));
//    }
//
//    public synchronized static void Compras_productos_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Compras.jTable_producto.getModel();
//        compras_id_producto = Integer.parseInt(String.valueOf(tm.getValueAt(Compras.jTable_producto.getSelectedRow(), 0)));
//        Compras.jTextField_producto.setText(String.valueOf(tm.getValueAt(Compras.jTable_producto.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Contratos_recepcion_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Contratos_recepcion.jTable_contratos.getModel();
//        contratos_recepcion_id_contrato = Integer.parseInt(String.valueOf(tm.getValueAt(Contratos_recepcion.jTable_contratos.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Ventas_detalle_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Ventas.jTable_detalle.getModel();
//        id_venta_detalle = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas.jTable_detalle.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Ventas_moneda_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Ventas.jTable_moneda.getModel();
//        ventas_id_moneda = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas.jTable_moneda.getSelectedRow(), 0)));
//        Ventas.jTextField_moneda.setText(String.valueOf(tm.getValueAt(Ventas.jTable_moneda.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Ventas_cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Ventas.jTable_cliente.getModel();
//        ventas_id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas.jTable_cliente.getSelectedRow(), 0)));
//        Ventas.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Ventas.jTable_cliente.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Ventas_buscar_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Ventas.jTable_ventas.getModel();
//        id_venta = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas.jTable_ventas.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Ventas_producto_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Ventas.jTable_productos.getModel();
//        ventas_id_producto = Integer.parseInt(String.valueOf(tm.getValueAt(Ventas.jTable_productos.getSelectedRow(), 0)));
//        Ventas.jTextField_producto.setText(String.valueOf(tm.getValueAt(Ventas.jTable_productos.getSelectedRow(), 1)));
//        Ventas.jTextField_precio.setText(String.valueOf(tm.getValueAt(Ventas.jTable_productos.getSelectedRow(), 2)));
//        Ventas.jTextField_unidad.setText("1");
//    }
//
//    public synchronized static void Combustible_uso_detalle_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Combustible_uso.jTable_combustible_uso.getModel();
//        id_combustible_uso_selected = Integer.parseInt(String.valueOf(tm.getValueAt(Combustible_uso.jTable_combustible_uso.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Listado_recepciones_sucursal_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Listado_recepciones.jTable_sucursal.getModel();
//        id_sucursal_selected = Integer.parseInt(String.valueOf(tm.getValueAt(Listado_recepciones.jTable_sucursal.getSelectedRow(), 0)));
//        Listado_recepciones.jTextField_sucursal.setText(String.valueOf(tm.getValueAt(Listado_recepciones.jTable_sucursal.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Configuracion_sucursal_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Configuracion.jTable_sucursal.getModel();
//        configuracion_id_sucursal_selected = Integer.parseInt(String.valueOf(tm.getValueAt(Configuracion.jTable_sucursal.getSelectedRow(), 0)));
//        Configuracion.jTextField_sucursal.setText(String.valueOf(tm.getValueAt(Configuracion.jTable_sucursal.getSelectedRow(), 1)));
//        Configuracion.jTextField_numero.setText(String.valueOf(tm.getValueAt(Configuracion.jTable_sucursal.getSelectedRow(), 2)));
//    }
//
//    public synchronized static void Vehiculos_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Vehiculo.jTable_vehiculos.getModel();
//        id_vehiculo = Integer.parseInt(String.valueOf(tm.getValueAt(Vehiculo.jTable_vehiculos.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Combustibles_uso_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Combustible_uso.jTable_vehiculo.getModel();
//        combustibles_uso_id_vehiculo = Integer.parseInt(String.valueOf(tm.getValueAt(Combustible_uso.jTable_vehiculo.getSelectedRow(), 0)));
//        Combustible_uso.jTextField_vehiculo.setText(
//                String.valueOf(tm.getValueAt(Combustible_uso.jTable_vehiculo.getSelectedRow(), 1))
//                + " " + String.valueOf(tm.getValueAt(Combustible_uso.jTable_vehiculo.getSelectedRow(), 2))
//                + " " + String.valueOf(tm.getValueAt(Combustible_uso.jTable_vehiculo.getSelectedRow(), 3)));
//    }
//
//    public synchronized static void Contrato_recepcion_zafra_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Contratos_recepcion.jTable_zafra.getModel();
//        contrato_recepcion_id_zafra = Integer.parseInt(String.valueOf(tm.getValueAt(Contratos_recepcion.jTable_zafra.getSelectedRow(), 0)));
//        Contratos_recepcion.jTextField_zafra.setText(String.valueOf(tm.getValueAt(Contratos_recepcion.jTable_zafra.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Contrato_recepcion_cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Contratos_recepcion.jTable_cliente.getModel();
//        contrato_recepcion_id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Contratos_recepcion.jTable_cliente.getSelectedRow(), 0)));
//        Contratos_recepcion.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Contratos_recepcion.jTable_cliente.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_zafra_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_ABM.jTable_zafra.getModel();
//        recepcion_id_zafra = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_zafra.getSelectedRow(), 0)));
//        Recepcion_ABM.jTextField_zafra.setText(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_zafra.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Uso_de_Productos_listado_parcela_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Uso_de_productos_listado.jTable_parcela.getModel();
//        uso_de_productos_listado_id_parcela = Integer.parseInt(String.valueOf(tm.getValueAt(Uso_de_productos_listado.jTable_parcela.getSelectedRow(), 0)));
//        Uso_de_productos_listado.jTextField_parcela.setText(String.valueOf(tm.getValueAt(Uso_de_productos_listado.jTable_parcela.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Uso_de_Productos_listado_zafra_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Uso_de_productos_listado.jTable_zafra.getModel();
//        uso_de_productos_listado_id_zafra = Integer.parseInt(String.valueOf(tm.getValueAt(Uso_de_productos_listado.jTable_zafra.getSelectedRow(), 0)));
//        Uso_de_productos_listado.jTextField_zafra.setText(String.valueOf(tm.getValueAt(Uso_de_productos_listado.jTable_zafra.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Uso_de_Productos_listado_cultivo_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Uso_de_productos_listado.jTable_cultivo.getModel();
//        uso_de_productos_listado_id_cultivo = Integer.parseInt(String.valueOf(tm.getValueAt(Uso_de_productos_listado.jTable_cultivo.getSelectedRow(), 0)));
//        Uso_de_productos_listado.jTextField_cultivo.setText(String.valueOf(tm.getValueAt(Uso_de_productos_listado.jTable_cultivo.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_variedad_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_ABM.jTable_variedad.getModel();
//        recepcion_id_variedad = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_variedad.getSelectedRow(), 0)));
//        Recepcion_ABM.jTextField_variedad.setText(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_variedad.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_remitente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_ABM.jTable_remitente.getModel();
//        recepcion_id_remitente = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_remitente.getSelectedRow(), 0)));
//        Recepcion_ABM.jTextField_remitente.setText(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_remitente.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Contrato_zafra_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Contratos.jTable_zafra.getModel();
//        contratos_id_zafra = Integer.parseInt(String.valueOf(tm.getValueAt(Contratos.jTable_zafra.getSelectedRow(), 0)));
//        Contratos.jTextField_zafra.setText(String.valueOf(tm.getValueAt(Contratos.jTable_zafra.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Contrato_cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Contratos.jTable_cliente.getModel();
//        contratos_id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Contratos.jTable_cliente.getSelectedRow(), 0)));
//        Contratos.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Contratos.jTable_cliente.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Listado_recepciones_pendientes_cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Listado_recepciones_pendientes.jTable_cliente.getModel();
//        listado_recepcion_pendiente_id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Listado_recepciones_pendientes.jTable_cliente.getSelectedRow(), 0)));
//        Listado_recepciones_pendientes.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Listado_recepciones_pendientes.jTable_cliente.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Transportista_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Transportista_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Transportista_listado.jTable1.getSelectedRow(), 0));
//        id_transportista = Integer.parseInt(selected.replace(".", ""));
//    }
//
//    public synchronized static void Camion_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Camion_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Camion_listado.jTable1.getSelectedRow(), 0));
//        id_camion = Integer.parseInt(selected.replace(".", ""));
//    }
//
//    public synchronized static void Parcela_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Parcela_listado.jTable1.getModel();
//        id_parcela = Integer.parseInt(String.valueOf(tm.getValueAt(Parcela_listado.jTable1.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Recepcion_Parcela_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_Parcela_listado.jTable1.getModel();
//        id_parcela = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_Parcela_listado.jTable1.getSelectedRow(), 0)));
//        Recepcion_ABM.jTextField_parcela.setText(String.valueOf(tm.getValueAt(Recepcion_Parcela_listado.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Listados_Parcela_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Listados_Parcela_listado.jTable1.getModel();
//        id_parcela = Integer.parseInt(String.valueOf(tm.getValueAt(Listados_Parcela_listado.jTable1.getSelectedRow(), 0)));
//        Listado_recepciones_parcela.jTextField_parcela.setText(String.valueOf(tm.getValueAt(Listados_Parcela_listado.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_Camion_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_Camion_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Recepcion_Camion_listado.jTable1.getSelectedRow(), 0));
//        id_camion = Integer.parseInt(selected.replace(".", ""));
//        Recepcion_ABM.jTextField_camion.setText(String.valueOf(tm.getValueAt(Recepcion_Camion_listado.jTable1.getSelectedRow(), 4)));
//    }
//
//    public synchronized static void Recepcion_Moneda_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_Moneda_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Recepcion_Moneda_listado.jTable1.getSelectedRow(), 0));
//        id_moneda = Integer.parseInt(selected.replace(".", ""));
//        Recepcion_ABM.jTextField_moneda.setText(String.valueOf(tm.getValueAt(Recepcion_Moneda_listado.jTable1.getSelectedRow(), 1)));
//    }
//
////    public synchronized static void Recepcion_granos_tipo_selected() {
////        DefaultTableModel tm = (DefaultTableModel) Recepcion_productos_tipo.jTable1.getModel();
////        id_granos_tipo = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_productos_tipo.jTable1.getSelectedRow(), 0)));
////        Recepcion_ABM.jTextField_tipo.setText(String.valueOf(tm.getValueAt(Recepcion_productos_tipo.jTable1.getSelectedRow(), 1)));
////    }
//    public synchronized static void Recepcion_tipo_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_ABM.jTable_tipo.getModel();
//        id_granos_tipo = Integer.parseInt(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_tipo.getSelectedRow(), 0)));
//        Recepcion_ABM.jTextField_tipo.setText(String.valueOf(tm.getValueAt(Recepcion_ABM.jTable_tipo.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_habilitar_detalle() {
////        if (id_granos_tipo == 1) {
////            Recepcion_ABM.jPanel_Soja.setVisible(true);
////            Recepcion_ABM.jPanel_canola.setVisible(false);
////            Recepcion_ABM.jPanel_trigo.setVisible(false);
////        }
////        if (id_granos_tipo == 2) {
////            Recepcion_ABM.jPanel_Soja.setVisible(false);
////            Recepcion_ABM.jPanel_canola.setVisible(true);
////            Recepcion_ABM.jPanel_trigo.setVisible(false);
////        }
////        if (id_granos_tipo == 3) {
////            Recepcion_ABM.jPanel_Soja.setVisible(false);
////            Recepcion_ABM.jPanel_canola.setVisible(false);
////            Recepcion_ABM.jPanel_trigo.setVisible(true);
////        }
//    }
//
//    public synchronized static void Recepcion_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Recepcion_listado.jTable1.getSelectedRow(), 0));
//        id_recepcion = Integer.parseInt(selected.replace(".", ""));
//    }
//
//    public synchronized static void Cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Cliente_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Cliente_listado.jTable1.getSelectedRow(), 0));
//        id_cliente = Integer.parseInt(selected.replace(".", ""));
//    }
//
//    public synchronized static void Personales_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Personales_listado.jTable1.getModel();
//        id_empleado = Integer.parseInt(String.valueOf(tm.getValueAt(Personales_listado.jTable1.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Empleado_cargo_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Cargo_listado.jTable1.getModel();
//        id_empleado_cargo = Integer.parseInt(String.valueOf(tm.getValueAt(Cargo_listado.jTable1.getSelectedRow(), 0)));
//        Cargo_ABM.jTextField_cargo.setText(String.valueOf(tm.getValueAt(Cargo_listado.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Personales_cargo_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Personales_Cargo_listado.jTable1.getModel();
//        id_empleado_cargo = Integer.parseInt(String.valueOf(tm.getValueAt(Personales_Cargo_listado.jTable1.getSelectedRow(), 0)));
//        Personales_ABM.jTextField_cargo.setText(String.valueOf(tm.getValueAt(Personales_Cargo_listado.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Producto_proveedor_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Producto_proveedor_listado.jTable1.getModel();
//        productos_id_proveedor = Integer.parseInt(String.valueOf(tm.getValueAt(Producto_proveedor_listado.jTable1.getSelectedRow(), 0)));
//        Productos.jTextField_proveedor.setText(String.valueOf(tm.getValueAt(Producto_proveedor_listado.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Receciones_listado_Cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Listado_recepciones_Cliente_buscar.jTable1.getModel();
//        id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Listado_recepciones_Cliente_buscar.jTable1.getSelectedRow(), 0)));
//        Listado_recepciones_cliente.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Listado_recepciones_Cliente_buscar.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Receciones_listado_Usuario_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Listado_recepciones_Usuario_buscar.jTable1.getModel();
//        id_usuario_buscar = Integer.parseInt(String.valueOf(tm.getValueAt(Listado_recepciones_Usuario_buscar.jTable1.getSelectedRow(), 0)));
//        Listado_recepciones_usuario.jTextField_usuario.setText(String.valueOf(tm.getValueAt(Listado_recepciones_Usuario_buscar.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_Cliente_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_Cliente_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Recepcion_Cliente_listado.jTable1.getSelectedRow(), 0));
//        id_cliente = Integer.parseInt(selected.replace(".", ""));
//        Recepcion_ABM.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Recepcion_Cliente_listado.jTable1.getSelectedRow(), 1)));
//        //Recepcion_ABM.jTextField_ruc.setText(String.valueOf(tm.getValueAt(Recepcion_Cliente_listado.jTable1.getSelectedRow(), 2)));
//        //Recepcion_ABM.jTextField_telefono.setText(String.valueOf(tm.getValueAt(Recepcion_Cliente_listado.jTable1.getSelectedRow(), 3)));
//    }
//
//    public synchronized static void Chofer_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Conductor_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Conductor_listado.jTable1.getSelectedRow(), 0));
//        id_chofer_nuevo = Integer.parseInt(selected.replace(".", ""));
//    }
//
//    public synchronized static void Listado_recepciones_Conductor_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Listados_recepciones_Chofer_listado.jTable1.getModel();
//        id_chofer = Integer.parseInt(String.valueOf(tm.getValueAt(Listados_recepciones_Chofer_listado.jTable1.getSelectedRow(), 0)));
//        Listado_recepciones_personales.jTextField_conductor.setText(String.valueOf(tm.getValueAt(Listados_recepciones_Chofer_listado.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Recepcion_Chofer_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_Chofer_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Recepcion_Chofer_listado.jTable1.getSelectedRow(), 0));
//        id_chofer = Integer.parseInt(selected.replace(".", ""));
//        Recepcion_ABM.jTextField_chofer.setText(String.valueOf(tm.getValueAt(Recepcion_Chofer_listado.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Carreta_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Carreta_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Carreta_listado.jTable1.getSelectedRow(), 0));
//        id_carreta = Integer.parseInt(selected.replace(".", ""));
//    }
//
//    public synchronized static void Proveedor_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Proveedor_listado.jTable1.getModel();
////        id_proveedor = String.valueOf(tm.getValueAt(Proveedor_listado.jTable1.getSelectedRow(), 0));
//    }
//
//    public synchronized static void Recepcion_Carreta_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Recepcion_Carreta_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Recepcion_Carreta_listado.jTable1.getSelectedRow(), 0));
//        id_carreta = Integer.parseInt(selected.replace(".", ""));
//        Recepcion_ABM.jTextField_carreta.setText(String.valueOf(tm.getValueAt(Recepcion_Carreta_listado.jTable1.getSelectedRow(), 3)));
//    }
//
//    public synchronized static void Camion_Transportista_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Camion_transportista_listado.jTable1.getModel();
//        String selected = String.valueOf(tm.getValueAt(Camion_transportista_listado.jTable1.getSelectedRow(), 0));
//        id_transportista = Integer.parseInt(selected.replace(".", ""));
//        Camion_ABM.jTextField_transportista.setText(String.valueOf(tm.getValueAt(Camion_transportista_listado.jTable1.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Contrato_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Contratos.jTable_contratos.getModel();
//        id_contrato = Integer.parseInt(String.valueOf(tm.getValueAt(Contratos.jTable_contratos.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Combustibles_uso_personal_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Combustible_uso.jTable_personales.getModel();
//        combustible_uso_id_personal = Integer.parseInt(String.valueOf(tm.getValueAt(Combustible_uso.jTable_personales.getSelectedRow(), 0)));
//        Combustible_uso.jTextField_personal.setText(String.valueOf(tm.getValueAt(Combustible_uso.jTable_personales.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Combustibles_venta_clientes_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Combustible_venta.jTable_clientes.getModel();
//        combustible_venta_id_cliente = Integer.parseInt(String.valueOf(tm.getValueAt(Combustible_venta.jTable_clientes.getSelectedRow(), 0)));
//        Combustible_venta.jTextField_cliente.setText(String.valueOf(tm.getValueAt(Combustible_venta.jTable_clientes.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Ticket_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Tickets.jTable1.getModel();
//        id_ticket = Integer.parseInt(String.valueOf(tm.getValueAt(Tickets.jTable1.getSelectedRow(), 0)));
//    }
//
//    public synchronized static void Productos_aplicacion_parcela_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_parcela.getModel();
//        productos_aplicacion_id_parcela = Integer.parseInt(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_parcela.getSelectedRow(), 0)));
//        Productos_aplicacion_ABM.jTextField_parcela.setText(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_parcela.getSelectedRow(), 1)));
//    }
//
//    public synchronized static void Productos_aplicacion_cultivo_selected() {
//        DefaultTableModel tm = (DefaultTableModel) Productos_aplicacion_ABM.jTable_cultivo.getModel();
//        productos_aplicacion_id_cultivo = Integer.parseInt(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_cultivo.getSelectedRow(), 0)));
//        Productos_aplicacion_ABM.jTextField_cultivo.setText(String.valueOf(tm.getValueAt(Productos_aplicacion_ABM.jTable_cultivo.getSelectedRow(), 1)));
//    }
//
//    public static void Transportistas_editar() {
//        try {
//            String sql = "select  * "
//                    + "from transportista "
//                    + "where id_transportista ='" + id_transportista + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//                Transportista_ABM.jTextField_nombre.setText(RS_Productos.getString("nombre").trim());
//                if (RS_Productos.getString("ci") != null) {
//                    Transportista_ABM.jTextField_ci.setText(RS_Productos.getString("ci").trim());
//                }
//                if (RS_Productos.getString("ruc") != null) {
//                    Transportista_ABM.jTextField_ruc.setText(RS_Productos.getString("ruc").trim());
//                }
//                if (RS_Productos.getString("telefono") != null) {
//                    Transportista_ABM.jTextField_telefono.setText(RS_Productos.getString("telefono").trim());
//                }
//                if (RS_Productos.getString("direccion") != null) {
//                    Transportista_ABM.jTextField_direccion.setText(RS_Productos.getString("direccion").trim());
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Producto_editar() {
//        try {
//            String sql = "select  *, proveedor.nombre as pro_nombre "
//                    + "from productos "
//                    + "inner join proveedor on proveedor.id_proveedor = productos.id_proveedor "
//                    + "where id_producto ='" + id_producto + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//
//                productos_id_proveedor = RS_Productos.getInt("id_proveedor");
//                Productos.jTextField_descripcion.setText(RS_Productos.getString("nombre").trim());
////                Productos.jTextField_iva.setText(RS_Productos.getString("iva"));
//                Productos.jTextField_precio.setText(RS_Productos.getString("precio"));
//                Productos.jTextField_observaciones.setText(RS_Productos.getString("obs"));
//                Productos.jTextField_proveedor.setText(RS_Productos.getString("pro_nombre").trim());
//                Productos.jTextField_ubicacion.setText(RS_Productos.getString("ubicacion"));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Vehiculos_traer_datos() {
//        try {
//            String sql = "select  * "
//                    + "from vehiculo "
//                    + "where id_vehiculo ='" + id_vehiculo + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//
//                if (RS_Productos.getString("marca") != null) {
//                    Vehiculo.jTextField_tipo.setText(RS_Productos.getString("marca").trim());
//                }
//                if (RS_Productos.getString("modelo") != null) {
//                    Vehiculo.jTextField_modelo.setText(RS_Productos.getString("modelo").trim());
//                }
//                if (RS_Productos.getString("descripcion") != null) {
//                    Vehiculo.jTextField_descripcion.setText(RS_Productos.getString("descripcion").trim());
//                }
//
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void productos_aplicaion_traer_datos() {
//        try {
//            String sql = "select  * "
//                    + "from producto_aplicacion "
//                    + "inner join granos_tipo on granos_tipo.id_granos_tipo = producto_aplicacion.id_granos_tipo "
//                    + "inner join zafra on zafra.id_zafra = producto_aplicacion.id_zafra "
//                    + "inner join parcela on parcela.id_parcela = producto_aplicacion.id_parcela "
//                    + "where id_producto_aplicacion ='" + id_producto_aplicacion + "'"
//                    + "";
//            Statement ST = conexion.createStatement();
//            ResultSet RS = ST.executeQuery(sql);
//            while (RS.next()) {
//                Productos_aplicacion_ABM.jDateChooser_fecha.setDate(RS.getDate("fecha"));
//                Productos_aplicacion_ABM.jTextField_cultivo.setText(RS.getString("tipo").trim());
//                Productos_aplicacion_ABM.jTextField_parcela.setText(RS.getString("parcela").trim());
//                Productos_aplicacion_ABM.jTextField_zafra.setText(RS.getString("zafra").trim());
//
//                productos_aplicacion_id_tipo = RS.getInt("tipo_aplicacion");
//                if (productos_aplicacion_id_tipo == 1) {
//                    Productos_aplicacion_ABM.jTextField_tipo.setText("APLICACION");
//                } else {
//                    Productos_aplicacion_ABM.jTextField_tipo.setText("SIEMBRA");
//                }
//
//                productos_aplicacion_id_cultivo = RS.getInt("id_granos_tipo");
//                productos_aplicacion_id_parcela = RS.getInt("id_parcela");
//                Productos_aplicacion_abm_id_zafra = RS.getInt("id_zafra");
//
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }
//
//    public static void Sueldo_traer_datos() {
//        try {
//            String sql = "select  * "
//                    + "from sueldo "
//                    + "inner join mes on mes.id_mes = sueldo.id_mes "
//                    + "inner join empleado on empleado.id_empleado = sueldo.id_empleado "
//                    + "where id_sueldo ='" + id_sueldo + "' ";
//            Statement ST = conexion.createStatement();
//            ResultSet RS = ST.executeQuery(sql);
//            while (RS.next()) {
//
//                personales_pago_id_mes = RS.getInt("id_mes");
//                personales_pagos_id_empleado = RS.getInt("id_empleado");
//
//                Personales_pagos_ABM.jTextField_mes.setText(RS.getString("mes").trim());
//                Personales_pagos_ABM.jTextField_anho.setText(RS.getString("anho").trim());
//                Personales_pagos_ABM.jTextField_empleado.setText(RS.getString("nombre").trim());
//                Personales_pagos_ABM.jTextField_dias_trabajados.setText(RS.getString("dias").trim());
//                Personales_pagos_ABM.jTextField_total.setText(RS.getString("total").trim());
//                Personales_pagos_ABM.jDateChooser_inicio.setDate(RS.getDate("fecha"));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Combustible_venta_traer_datos() {
//        try {
//            String sql = "select  * "
//                    + "from combustible_venta "
//                    + "inner join cliente on cliente.id_cliente = combustible_venta.id_cliente "
//                    + "where id_combustible_venta ='" + id_combustible_venta + "' "
//                    + "";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//                Combustible_venta.jTextField_cliente.setText(RS_Productos.getString("nombre").trim());
//                Combustible_venta.jTextField_descripcion.setText(RS_Productos.getString("descripcion"));
//                Combustible_venta.jTextField_litros.setText(RS_Productos.getString("litros"));
//                Combustible_venta.jTextField_precio.setText(RS_Productos.getString("precio"));
//                Combustible_venta.jTextField_total.setText(RS_Productos.getString("total"));
//                Combustible_venta.jDateChooser_fecha.setDate(RS_Productos.getDate("fecha"));
//                combustible_venta_id_cliente = RS_Productos.getInt("id_cliente");
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Camion_editar() {
//        try {
//            String sql = "select  * "
//                    + "from camion "
//                    + "inner join transportista on transportista.id_transportista = camion.id_transportista "
//                    + "where id_camion ='" + id_camion + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//                Camion_ABM.jTextField_marca.setText(RS_Productos.getString("marca").trim());
//                id_transportista = RS_Productos.getInt("id_transportista");
//                Camion_ABM.jTextField_transportista.setText(RS_Productos.getString("nombre").trim());
//                if (RS_Productos.getString("modelo") != null) {
//                    Camion_ABM.jTextField_modelo.setText(RS_Productos.getString("modelo").trim());
//                }
//                if (RS_Productos.getString("anho") != null) {
//                    Camion_ABM.jTextField_anho.setText(RS_Productos.getString("anho").trim());
//                }
//                if (RS_Productos.getString("chapa") != null) {
//                    Camion_ABM.jTextField_chapa.setText(RS_Productos.getString("chapa").trim());
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Parcela_editar() {
//        try {
//            String sql = "select  * "
//                    + "from parcela "
//                    + "where id_parcela ='" + id_parcela + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//                Parcela_ABM.jTextField_parcela.setText(RS_Productos.getString("parcela").trim());
//                if (RS_Productos.getString("precio_del_flete") != null) {
//                    Parcela_ABM.jTextField_precio.setText(RS_Productos.getString("porcentaje").trim());
//                }
//                if (RS_Productos.getString("porcentaje") != null) {
//                    Parcela_ABM.jTextField_porcentaje.setText(RS_Productos.getString("porcentaje").trim());
//                }
//                if (RS_Productos.getString("has") != null) {
//                    Parcela_ABM.jTextField_has.setText(RS_Productos.getString("has").trim());
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Cliente_editar() {
//        try {
//            String sql = "select * "
//                    + "from cliente "
//                    + "where id_cliente ='" + id_cliente + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//                Cliente.jTextField_nombre.setText(RS_Productos.getString("nombre").trim());
//                id_cliente = RS_Productos.getInt("id_cliente");
//                if (RS_Productos.getString("telefono") != null) {
//                    Cliente.jTextField_telefono.setText(RS_Productos.getString("telefono").trim());
//                }
//                if (RS_Productos.getString("direccion") != null) {
//                    Cliente.jTextField_direccion.setText(RS_Productos.getString("direccion").trim());
//                }
//                if (RS_Productos.getString("ruc") != null) {
//                    Cliente.jTextField_ruc.setText(RS_Productos.getString("ruc").trim());
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Personales_editar() {
//        try {
//            String sql = "select * "
//                    + "from empleado "
//                    + "where id_empleado ='" + id_empleado + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//
//                if (RS_Productos.getString("nombre") != null) {
//                    Personales_ABM.jTextField_nombre.setText(RS_Productos.getString("nombre").trim());
//                }
//                if (RS_Productos.getString("ci") != null) {
//                    Personales_ABM.jTextField_ci.setText(RS_Productos.getString("ci").trim());
//                }
//                if (RS_Productos.getString("telefono") != null) {
//                    Personales_ABM.jTextField_telefono.setText(RS_Productos.getString("telefono").trim());
//                }
//                if (RS_Productos.getString("descripcion_del_trabajo") != null) {
//                    Personales_ABM.jTextField_trabajo.setText(RS_Productos.getString("descripcion_del_trabajo").trim());
//                }
//                if (RS_Productos.getString("salario") != null) {
//                    Personales_ABM.jTextField_salario.setText(getSepararMiles(RS_Productos.getString("salario").trim()));
//                }
//                id_empleado_cargo = RS_Productos.getInt("id_empleado_cargo");
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Chofer_editar() {
//        try {
//            String sql = "select * "
//                    + "from chofer "
//                    + "where id_chofer ='" + id_chofer_nuevo + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//                Conductor_ABM.jTextField_nombre.setText(RS_Productos.getString("nombre").trim());
//                id_chofer = RS_Productos.getInt("id_chofer");
//                if (RS_Productos.getString("telefono") != null) {
//                    Conductor_ABM.jTextField_telefono.setText(RS_Productos.getString("telefono").trim());
//                }
//                if (RS_Productos.getString("direccion") != null) {
//                    Conductor_ABM.jTextField_direccion.setText(RS_Productos.getString("direccion").trim());
//                }
//                if (RS_Productos.getString("ci") != null) {
//                    Conductor_ABM.jTextField_ci.setText(RS_Productos.getString("ci").trim());
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }
//
//    public static void Carreta_editar() {
//        try {
//            String sql = "select * "
//                    + "from carreta "
//                    + "where id_carreta ='" + id_carreta + "' ";
//            Statement ST_Productos = conexion.createStatement();
//            ResultSet RS_Productos = ST_Productos.executeQuery(sql);
//            while (RS_Productos.next()) {
//                Carreta_ABM.jTextField_marca.setText(RS_Productos.getString("marca").trim());
//                id_carreta = RS_Productos.getInt("id_carreta");
//                if (RS_Productos.getString("modelo") != null) {
//                    Carreta_ABM.jTextField_modelo.setText(RS_Productos.getString("modelo").trim());
//                }
//                if (RS_Productos.getString("anho") != null) {
//                    Carreta_ABM.jTextField_anho.setText(RS_Productos.getString("anho").trim());
//                }
//                if (RS_Productos.getString("chapa") != null) {
//                    Carreta_ABM.jTextField_chapa.setText(RS_Productos.getString("chapa").trim());
//                }
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    public synchronized static java.sql.Date util_Date_to_sql_date(Date fecha) {
        java.sql.Date fecha_sql_date = null;
        if (fecha != null) {
            java.util.Date utilDate = fecha;
            fecha_sql_date = new java.sql.Date(utilDate.getTime());
        }
        return fecha_sql_date;
    }

    public synchronized static boolean getIngresar() {

        boolean entro = false;
        try {
            Metodos.nombre = Logueo.jTextField1.getText();
            char[] arrayC = Logueo.jPasswordField1.getPassword();
            String pass = new String(arrayC);

            //Conexion.Verificar_conexion();
            PreparedStatement ps = conexion.prepareStatement(""
                    + "select * "
                    + "from usuario "
                    + "inner join sucursal on sucursal.id_sucursal = usuario.id_sucursal "
                    + "where nombre ='" + nombre + "' and contrasenha = '" + pass + "'"
                    + "");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombre = rs.getString("nombre_real").trim();
                id_usuario = rs.getInt("id_usuario");
                id_sucursal = rs.getInt("id_sucursal");
                sucursal = rs.getString("sucursal");
                privilegio = rs.getInt("privilegio");

                PreparedStatement ps2 = conexion.prepareStatement("select * from configuracion ");
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    titulo = rs2.getString("empresa") + " - " + nombre;
                    empresa = rs2.getString("empresa").trim();
                    empresa_datos = "RUC. " + rs2.getString("ruc").trim() + " - Telf." + rs2.getString("telefono").trim() + " - Dir." + rs2.getString("direccion").trim();
                }

                // Configuracion_inicial();
                ubicacion_proyecto = new File("").getAbsolutePath();
                ubicacion_reportes = new File("").getAbsolutePath();

                Metodos.imagen = ubicacion_reportes + "\\reportes\\logo.jpg";
                Metodos.path = ubicacion_reportes + "\\reportes\\";
                if (ismac == true) {
                    Metodos.imagen = ubicacion_reportes + "//reportes//logo.jpg";
                    Metodos.path = ubicacion_reportes + "//reportes//";
                }

                entro = true;
//                new Principal().setVisible(true);
            }
            if (entro == false) {
                JOptionPane.showMessageDialog(null, "Error de usuario y/o contraseña.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            MostrarError(ex, getNombreMetodo());
        }
        return entro;
    }

    public synchronized static boolean isNumericDouble(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public synchronized static boolean isNumeric(String cadena) {
        try {
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public synchronized static String getSepararMiles(String txtprec) {
        String valor = txtprec;

        int largo = valor.length();
        if (largo > 8) {
            valor = valor.substring(largo - 9, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 7) {
            valor = valor.substring(largo - 8, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 6) {
            valor = valor.substring(largo - 7, largo - 6) + "." + valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 5) {
            valor = valor.substring(largo - 6, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 4) {
            valor = valor.substring(largo - 5, largo - 3) + "." + valor.substring(largo - 3, largo);
        } else if (largo > 3) {
            valor = valor.substring(largo - 4, largo - 3) + "." + valor.substring(largo - 3, largo);
        }
        txtprec = valor;
        return valor;
    }

    public static void Aplicacion_productos_tipo_update(int valor, int app) {
        try {

            if (app == 0) {
                PreparedStatement st = conexion.prepareStatement(""
                        + "UPDATE producto_aplicacion "
                        + "SET tipo_aplicacion ='" + valor + "', "
                        + "aplicacion = '0' "
                        + "WHERE id_producto_aplicacion = '" + id_producto_aplicacion + "'");
                st.executeUpdate();
            } else {

                PreparedStatement st = conexion.prepareStatement(""
                        + "UPDATE producto_aplicacion "
                        + "SET tipo_aplicacion ='" + valor + "' "
                        + "WHERE id_producto_aplicacion = '" + id_producto_aplicacion + "'");
                st.executeUpdate();

            }
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    static void Personales_pagos_guardar(String dias_trabajados, Date fecha, String importe, String anho) {
        try {
            if (id_sueldo == 0) {

                Statement st1 = conexion.createStatement();
                ResultSet result = st1.executeQuery("SELECT MAX(id_sueldo) FROM sueldo");
                if (result.next()) {
                    id_sueldo = result.getInt(1) + 1;
                }

                PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO sueldo VALUES(?,?,?,?,?,?,?)");
                stUpdateProducto.setInt(1, id_sueldo);
                stUpdateProducto.setInt(2, personales_pagos_id_empleado);
                stUpdateProducto.setInt(3, personales_pago_id_mes);
                stUpdateProducto.setDate(4, util_Date_to_sql_date(hoy));
                stUpdateProducto.setDouble(5, Double.parseDouble(dias_trabajados));
                stUpdateProducto.setLong(6, 0);
                stUpdateProducto.setLong(7, Long.parseLong(anho));
                stUpdateProducto.executeUpdate();

            } else {

                PreparedStatement st = conexion.prepareStatement(""
                        + "UPDATE sueldo "
                        + "SET id_empleado ='" + personales_pagos_id_empleado + "', "
                        + "id_mes ='" + personales_pago_id_mes + "', "
                        + "fecha ='" + util_Date_to_sql_date(hoy) + "', "
                        + "anho ='" + Long.parseLong(anho) + "', "
                        + "dias ='" + Double.parseDouble(dias_trabajados) + "' "
                        + "WHERE id_sueldo = '" + id_sueldo + "'");
                st.executeUpdate();

                if (personales_pagos_id_concepto != 0) {
                    Statement st1 = conexion.createStatement();
                    ResultSet result = st1.executeQuery("SELECT MAX(id_sueldo_detalle) FROM sueldo_detalle");
                    if (result.next()) {
                        id_sueldo_detalle = result.getInt(1) + 1;
                    }

                    PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO sueldo_detalle VALUES(?,?,?,?)");
                    stUpdateProducto.setInt(1, id_sueldo_detalle);
                    stUpdateProducto.setLong(2, Long.parseLong(importe.replace(".", "")));
                    stUpdateProducto.setInt(3, id_sueldo);
                    stUpdateProducto.setInt(4, personales_pagos_id_concepto);
                    stUpdateProducto.executeUpdate();
                    personales_pagos_id_concepto = 0;
                }
            }

            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery(""
                    + "SELECT SUM(importe) "
                    + "FROM sueldo_detalle "
                    + "where id_sueldo = '" + id_sueldo + "'");
            if (result.next()) {
                PreparedStatement st = conexion.prepareStatement(""
                        + "UPDATE sueldo "
                        + "SET total ='" + result.getLong(1) + "' "
                        + "WHERE id_sueldo = '" + id_sueldo + "'");
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    static void Venta_imprimir() {
        try {
            long cinco = 0;
            long diez = 0;
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT SUM(cinco) FROM venta_detalle where id_venta = '" + id_venta + "'");
            if (result.next()) {
                cinco = result.getLong(1);
            }
            st1 = conexion.createStatement();
            result = st1.executeQuery("SELECT SUM(diez) FROM venta_detalle where id_venta = '" + id_venta + "'");
            if (result.next()) {
                diez = result.getLong(1);
            }
            int dolar = 1;
            st1 = conexion.createStatement();
            result = st1.executeQuery("SELECT * FROM venta where id_venta = '" + id_venta + "' and id_moneda = '2'");
            if (result.next()) {
                dolar = result.getInt("dolar");
            }

            JasperReport jr = null;
            Map parametros = new HashMap();
            String path = Metodos.ubicacion_proyecto + "\\reportes\\factura.jasper"; //
            ubicacion_proyecto = ubicacion_proyecto.replace("\\", "\\\\");

            parametros.put("direccion", ubicacion_proyecto + "\\\\reportes\\\\factura_detalle");
            parametros.put("cinco", (cinco / 21) * dolar);
            parametros.put("diez", (diez / 11) * dolar);
            parametros.put("total", ((diez / 11) + (cinco / 21)) * dolar);
            parametros.put("total_total", ((diez + cinco) * dolar));
            parametros.put("total_letras", Numero_a_String((diez + cinco) * dolar));
            parametros.put("id_venta", id_venta);

            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (SQLException | ClassNotFoundException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    static void Venta_imprimir_comprobante() {
        try {
            long cinco = 0;
            long diez = 0;
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT SUM(cinco) FROM venta_detalle where id_venta = '" + id_venta + "'");
            if (result.next()) {
                cinco = result.getLong(1);
            }
            st1 = conexion.createStatement();
            result = st1.executeQuery("SELECT SUM(diez) FROM venta_detalle where id_venta = '" + id_venta + "'");
            if (result.next()) {
                diez = result.getLong(1);
            }
            int dolar = 1;
//            st1 = conexion.createStatement();
//            result = st1.executeQuery("SELECT * FROM venta where id_venta = '" + id_venta + "' and id_moneda = '2'");
//            if (result.next()) {
//                dolar = result.getInt("dolar");
//            }

            JasperReport jr = null;
            Map parametros = new HashMap();
            String path = Metodos.ubicacion_proyecto + "\\reportes\\factura_con_logo.jasper"; //
            ubicacion_proyecto = ubicacion_proyecto.replace("\\", "\\\\");

            parametros.put("direccion", ubicacion_proyecto + "\\\\reportes\\\\factura_detalle");
            parametros.put("cinco", (cinco / 21) * dolar);
            parametros.put("diez", (diez / 11) * dolar);
            parametros.put("total", ((diez / 11) + (cinco / 21)) * dolar);
            parametros.put("total_total", ((diez + cinco) * dolar));
            parametros.put("total_letras", Numero_a_String((diez + cinco) * dolar));
            parametros.put("id_venta", id_venta);

            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            MostrarError(ex, getNombreMetodo());
        } catch (SQLException | ClassNotFoundException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    static void Ventas_update_total() {
        try {
            double total = 0;
            long total_long = 0;
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery(""
                    + "SELECT * "
                    + "FROM venta_detalle "
                    + "where id_venta = '" + id_venta + "'");
            while (result.next()) {
                total = result.getDouble("exentas") + result.getDouble("cinco") + result.getDouble("diez") + total;
            }
            total_long = (long) total;
            PreparedStatement st = conexion.prepareStatement(""
                    + "UPDATE venta "
                    + "SET total = '" + total_long + "' "
                    + "WHERE id_venta = '" + id_venta + "'");
            st.executeUpdate();

//            Ventas.jTextField_total.setText(String.valueOf(total_long));

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public synchronized static String Numero_a_String(long numeroINT) throws ClassNotFoundException, SQLException {

        Numero_a_Letra NumLetra = new Numero_a_Letra();
        String cantidad_string = Long.toString(numeroINT);
        String aRemplazar = NumLetra.Convertir(cantidad_string, true);
        String remplazado = aRemplazar.replace("0", "");
        return remplazado;

    }

    static void Generar_pagare() {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_pagare) FROM pagares");
            if (result.next()) {
                id_pagare = result.getInt(1) + 1;
            }

            st1 = conexion.createStatement();
            result = st1.executeQuery("SELECT * FROM venta where id_venta = '" + id_venta + "'");
            if (result.next()) {
                id_cliente = result.getInt("id_cliente");
            }

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO pagares VALUES(?,?,?,?,?)");
            stUpdateProducto.setInt(1, id_pagare);
            stUpdateProducto.setDate(2, util_Date_to_sql_date(hoy));
            stUpdateProducto.setDate(3, util_Date_to_sql_date(hoy));
            stUpdateProducto.setInt(4, id_cliente);
            stUpdateProducto.setInt(5, id_venta);
            stUpdateProducto.executeUpdate();

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

//    static void Recibo_de_dinero_clientes_jtable(String buscar) {
//        try {
//            dtm = (DefaultTableModel) Recibo_de_dinero.jTable_cliente.getModel();
//            for (int j = 0; j < Recibo_de_dinero.jTable_cliente.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from cliente "
//                    + "where nombre ilike '%" + buscar + "%'");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1);
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recibo_de_dinero.jTable_cliente.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

//    static void Recibo_de_dinero_bancos_jtable() {
//        try {
//            dtm = (DefaultTableModel) Recibo_de_dinero.jTable_banco.getModel();
//            for (int j = 0; j < Recibo_de_dinero.jTable_banco.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from banco "
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1);
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recibo_de_dinero.jTable_banco.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    static void Recibo_de_dinero_guardar(String cheque, String concepto, String dinero, Date fecha) {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_recibo) FROM recibo");
            if (result.next()) {
                id_recibo = result.getInt(1) + 1;
            }

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO recibo VALUES(?,?,?,?,?,?,?,?)");
            stUpdateProducto.setInt(1, id_recibo);
            stUpdateProducto.setInt(2, recibo_de_dinero_id_cliente);
            stUpdateProducto.setDate(3, util_Date_to_sql_date(fecha));
            stUpdateProducto.setInt(4, recibo_de_dinero_id_moneda);
            stUpdateProducto.setString(5, concepto);
            stUpdateProducto.setInt(6, recibo_de_dinero_id_banco);
            stUpdateProducto.setString(7, cheque);
            stUpdateProducto.setLong(8, Long.parseLong(dinero.replace(".", "")));
            stUpdateProducto.executeUpdate();

            JOptionPane.showMessageDialog(null, "Guardado correctamente.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verifique los datos." + ex);
        }
    }

//    static void Recibo_de_dinero_moneda_jtable() {
//        try {
//            dtm = (DefaultTableModel) Recibo_de_dinero.jTable_moneda.getModel();
//            for (int j = 0; j < Recibo_de_dinero.jTable_moneda.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select * "
//                    + "from moneda "
//                    + "order by moneda");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Recibo_de_dinero.jTable_moneda.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    static void Compras_detalle_guardar(String precio, String unidades, int id_moneda) {
        try {
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT MAX(id_facturas_compra_detalle) FROM facturas_compra_detalle");
            if (result.next()) {
                id_facturas_compras_detalle = result.getInt(1) + 1;
            }

            PreparedStatement stUpdateProducto = conexion.prepareStatement("INSERT INTO facturas_compra_detalle VALUES(?,?,?,?,?,?,?)");
            stUpdateProducto.setInt(1, id_facturas_compras_detalle);
            stUpdateProducto.setInt(2, id_facturas_compras);
            stUpdateProducto.setLong(3, Long.parseLong(unidades));
            stUpdateProducto.setLong(4, Long.parseLong(precio));
            stUpdateProducto.setLong(5, 0);
            stUpdateProducto.setInt(6, 1);
            stUpdateProducto.setInt(7, compras_id_producto);
            stUpdateProducto.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Verifique los datos." + ex);
        }
    }

    static void Recepcion_update_descuento() {
        try {

            long total_descuento = 0;
            long peso_neto = 0;
            Statement st1 = conexion.createStatement();
            ResultSet result = st1.executeQuery("SELECT SUM(descuento) FROM recepcion_detalle where id_recepcion = '" + id_recepcion + "'");
            if (result.next()) {
                total_descuento = result.getLong(1);
            }
            st1 = conexion.createStatement();
            result = st1.executeQuery("SELECT * FROM recepcion where id_recepcion = '" + id_recepcion + "'");
            if (result.next()) {
                peso_neto = result.getLong("peso_neto");
            }

            double total_neto_carga = peso_neto - total_descuento;
            long tnc = (long) total_neto_carga;
            long total_desc = (long) total_descuento;

            PreparedStatement st2 = conexion.prepareStatement(""
                    + "UPDATE recepcion "
                    + "SET total_descuento ='" + total_desc + "', "
                    + "total_neto_carga ='" + tnc + "' "
                    + "WHERE id_recepcion = '" + id_recepcion + "'");
            st2.executeUpdate();

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }
    }

    public static void Backup_online() {
        try {

            Conexion.conexion_online_activar();

            Statement st2 = null;
            Statement st = Conexion.conexion.createStatement();

            st2 = Conexion.conexion_online.createStatement();
            st2.executeUpdate("delete from venta_detalle");

            st2 = Conexion.conexion_online.createStatement();
            st2.executeUpdate("delete from venta");

            st2 = Conexion.conexion_online.createStatement();
            st2.executeUpdate("delete from recepcion_detalle");

            st2 = Conexion.conexion_online.createStatement();
            st2.executeUpdate("delete from recepcion");

            st2 = Conexion.conexion_online.createStatement();
            st2.executeUpdate("delete from recibo");

            st2 = Conexion.conexion_online.createStatement();
            st2.executeUpdate("delete from contrato");

            st2 = Conexion.conexion_online.createStatement();
            st2.executeUpdate("delete from cliente");

            ResultSet rs = st.executeQuery("SELECT * FROM cliente order by id_cliente ");
            while (rs.next()) {

                PreparedStatement st3 = Conexion.conexion_online.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?,?, ?,?,?,?)");
                st3.setInt(1, rs.getInt(1));
                st3.setString(2, rs.getString(2));
                st3.setString(3, rs.getString(3));
                st3.setString(4, rs.getString(4));
                st3.setString(5, rs.getString(5));
                st3.setString(6, rs.getString(6));
                st3.setString(7, rs.getString(7));
                st3.setInt(8, rs.getInt(8));
                st3.setInt(9, rs.getInt(9));
                st3.executeUpdate();

            }

            JOptionPane.showMessageDialog(null, "Copia de seguridad realizada exitosamente.");

        } catch (SQLException ex) {
            MostrarError(ex, getNombreMetodo());
        }

    }

//    static void Obtener_has_de_parcela(int productos_aplicacion_id_parcela) {
//        Statement st;
//        try {
//            st = Conexion.conexion.createStatement();
//            ResultSet rs = st.executeQuery(""
//                    + "SELECT * FROM parcela "
//                    + "where id_parcela = '" + productos_aplicacion_id_parcela + "' ");
//            while (rs.next()) {
//                Productos_aplicacion_ABM.jTextField_has.setText(rs.getString("has"));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//        }
//    }

//    public static void Uso_de_productos_listado_parcela_jtable(String buscar) {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Uso_de_productos_listado.jTable_parcela.getModel();
//            for (int j = 0; j < Uso_de_productos_listado.jTable_parcela.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_parcela, parcela  "
//                    + "from parcela "
//                    + "where parcela ilike '%" + buscar + "%'"
//                    + "order by parcela"
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Uso_de_productos_listado.jTable_parcela.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

//    public static void Uso_de_productos_listado_zafra_jtable() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Uso_de_productos_listado.jTable_zafra.getModel();
//            for (int j = 0; j < Uso_de_productos_listado.jTable_zafra.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_zafra, zafra  "
//                    + "from zafra "
//                    + "order by zafra"
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Uso_de_productos_listado.jTable_zafra.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

//    public static void Uso_de_productos_listado_cultivo_jtable() {
//        try {
//
//            Conexion.Verificar_conexion();
//
//            dtm = (DefaultTableModel) Uso_de_productos_listado.jTable_cultivo.getModel();
//            for (int j = 0; j < Uso_de_productos_listado.jTable_cultivo.getRowCount(); j++) {
//                dtm.removeRow(j);
//                j -= 1;
//            }
//            PreparedStatement ps2 = conexion.prepareStatement(""
//                    + "select id_granos_tipo, tipo  "
//                    + "from granos_tipo "
//                    + "order by granos_tipo"
//                    + "");
//            ResultSet rs2 = ps2.executeQuery();
//            rsm = rs2.getMetaData();
//            ArrayList<Object[]> data2 = new ArrayList<>();
//            while (rs2.next()) {
//                Object[] rows = new Object[rsm.getColumnCount()];
//                for (int i = 0; i < rows.length; i++) {
//                    rows[i] = rs2.getObject(i + 1).toString().trim();
//                }
//                data2.add(rows);
//            }
//            dtm = (DefaultTableModel) Uso_de_productos_listado.jTable_cultivo.getModel();
//            for (int i = 0; i < data2.size(); i++) {
//                dtm.addRow(data2.get(i));
//            }
//        } catch (SQLException ex) {
//            MostrarError(ex, getNombreMetodo());
//
//        }
//    }

    public static class Numero_a_Letra {

        private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
        private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
            "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
            "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
        private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
            "setecientos ", "ochocientos ", "novecientos "};

        public Numero_a_Letra() {
        }

        public String Convertir(String numero, boolean mayusculas) {
            String literal = "";
            String parte_decimal;
            //si el numero utiliza (.) en lugar de (,) -> se reemplaza
            numero = numero.replace(".", ",");
            //si el numero no tiene parte decimal, se le agrega ,00
            if (numero.indexOf(",") == -1) {
                numero = numero + ",0";
            }
            //se valida formato de entrada -> 0,00 y 999 999 999,00
            if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
                //se divide el numero 0000000,00 -> entero y decimal
                String Num[] = numero.split(",");
                //de da formato al numero decimal
                parte_decimal = Num[1] + "";
                //se convierte el numero a literal
                if (Integer.parseInt(Num[0]) == 0) {//si el valor es cero
                    literal = "cero ";
                } else if (Integer.parseInt(Num[0]) > 999999) {//si es millon
                    literal = getMillones(Num[0]);
                } else if (Integer.parseInt(Num[0]) > 999) {//si es miles
                    literal = getMiles(Num[0]);
                } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                    literal = getCentenas(Num[0]);
                } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                    literal = getDecenas(Num[0]);
                } else {//sino unidades -> 9
                    literal = getUnidades(Num[0]);
                }
                //devuelve el resultado en mayusculas o minusculas
                if (mayusculas) {
                    return (literal + parte_decimal).toUpperCase();
                } else {
                    return (literal + parte_decimal);
                }
            } else {//error, no se puede convertir
                return literal = null;
            }
        }

        /* funciones para convertir los numeros a literales */
        private String getUnidades(String numero) {// 1 - 9
            //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
            String num = numero.substring(numero.length() - 1);
            return UNIDADES[Integer.parseInt(num)];
        }

        private String getDecenas(String num) {// 99                        
            int n = Integer.parseInt(num);
            if (n < 10) {//para casos como -> 01 - 09
                return getUnidades(num);
            } else if (n > 19) {//para 20...99
                String u = getUnidades(num);
                if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                    return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
                } else {
                    return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
                }
            } else {//numeros entre 11 y 19
                return DECENAS[n - 10];
            }
        }

        private String getCentenas(String num) {// 999 o 099
            if (Integer.parseInt(num) > 99) {//es centena
                if (Integer.parseInt(num) == 100) {//caso especial
                    return " cien ";
                } else {
                    return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
                }
            } else {//por Ej. 099 
                //se quita el 0 antes de convertir a decenas
                return getDecenas(Integer.parseInt(num) + "");
            }
        }

        private String getMiles(String numero) {// 999 999
            //obtiene las centenas
            String c = numero.substring(numero.length() - 3);
            //obtiene los miles
            String m = numero.substring(0, numero.length() - 3);
            String n = "";
            //se comprueba que miles tenga valor entero
            if (Integer.parseInt(m) > 0) {
                n = getCentenas(m);
                return n + "mil " + getCentenas(c);
            } else {
                return "" + getCentenas(c);
            }

        }

        private String getMillones(String numero) { //000 000 000        
            //se obtiene los miles
            String miles = numero.substring(numero.length() - 6);
            //se obtiene los millones
            String millon = numero.substring(0, numero.length() - 6);
            String n = "";

            int mill = Integer.parseInt(millon);

            if (millon.length() > 1) {
                n = getCentenas(millon) + "millones ";
            } else {
                if (mill == 1) {
                    n = getCentenas(millon) + "millon ";
                }
                if (mill > 1) {
                    n = getCentenas(millon) + "millones ";
                }
            }

            return n + getMiles(miles);
        }
    }

}
