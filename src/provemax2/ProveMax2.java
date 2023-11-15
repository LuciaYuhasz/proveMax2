/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax2;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import provemax2.accesoDatos.CompraData;
import provemax2.accesoDatos.DetalleCompraData;
import provemax2.accesoDatos.ProductoData;
import provemax2.accesoDatos.ProveedorData;
import provemax2.entidades.Compra;
import provemax2.entidades.DetalleCompra;
import provemax2.entidades.Producto;
import provemax2.entidades.Proveedor;
public class ProveMax2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
 
 
 
 //****************************COMPRAA**********************************************
 
 
 
 //       CompraData com = new CompraData();  // cargo compra
//            ProveedorData proData = new ProveedorData();
//            Proveedor provEnco = proData.buscarProveedorPorId(16);
//            Compra nueva = new Compra(provEnco,LocalDate.now(),true);
////            nueva.setProveedor (prov);
////            nueva.setFecha(LocalDate.now());
////            nueva.isEstado();
//            com.agregarCompra(nueva);



              CompraData comp = new CompraData(); // lista compras activas
              Proveedor prov = new Proveedor();
        for (Compra com : comp.listarComprasActivas()) {
            System.out.println(" Id de compra : " + com.getIdCompra());
            System.out.println(" Proveedor : " + com.getProveedor());
            System.out.println(" Fecha de compra  : " + com.getFecha());
            System.out.println("-------------------------------------------------------------------");
        }
        
        
//              CompraData comp = new CompraData(); // lista compra inactivas
//              Proveedor prov = new Proveedor();
//        for (Compra com : comp.listarComprasInactivas()) {
//            System.out.println(" Id de compra : " + com.getIdCompra());
//            System.out.println(" Proveedor : " + com.getProveedor());
//            System.out.println(" Fecha de compra  : " + com.getFecha());
//            System.out.println("-------------------------------------------------------------------");
//        }

//             CompraData comp = new CompraData(); // borro compra
//             comp.borrarCompra(1);
//       


//
//        CompraData comData = new CompraData();  //busco compra por id
//        int idCompraABuscar = 3; 
//        Compra compraEncontrada = comData.buscarCompra(idCompraABuscar);
//        if (compraEncontrada != null) {
//            System.out.println("ID de compra: " + compraEncontrada.getIdCompra());
//            System.out.println("ID de Proveedor: " + compraEncontrada.getProveedor().getIdProveedor());
//            System.out.println("Fecha de Compra : " + compraEncontrada.getFecha());
//            
//        } else {
//            
//            JOptionPane.showMessageDialog(null,"Compra no encontrada");
//        }
    
    
    
    }
    
}
