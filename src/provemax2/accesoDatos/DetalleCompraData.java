package provemax2.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import provemax2.entidades.Compra;
import provemax2.entidades.DetalleCompra;
import provemax2.entidades.Producto;

/**
 *
 * @author Usuario
 */
public class DetalleCompraData {
    
    private CompraData comData = new CompraData();
    private ProveedorData provData = new ProveedorData();
    private ProductoData prodData = new ProductoData();
    
     private Connection con = null;
  
    public DetalleCompraData() {
        con = Conexion.getConexion();
              
    }
    
   public ArrayList<DetalleCompra> listarDetallePorCompra(){ // no corre
       ArrayList<DetalleCompra> listaDetalles =new ArrayList<>();
        String sql= " SELECT * FROM detalleCompra ";
    try {
         PreparedStatement ps= con.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
         while(rs.next()){
             DetalleCompra deta= new DetalleCompra();

// deta.setIdDetalle(rs.getInt("idDetalleCompra"));
             deta.setCantidad(rs.getInt("cantidad"));
             deta.setPrecioCosto(rs.getDouble("precioCosto"));
             Compra compra = comData.buscarCompra(rs.getInt("idCompra"));
             deta.setCompra(compra);
            Producto producto = prodData.buscarProductoPorId(rs.getInt("idProducto"));
             deta.setProducto(producto);
             listaDetalles.add(deta);
         }
         ps.close();
     } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al conectar con tabla de detalle compra "+ ex.getMessage());
  }
     return listaDetalles ;
    }
     

       
    public void guardarDetalleCompra(DetalleCompra detCom) { // no funciona
        String sql = " INSERT INTO detalleCompra (cantidad,precioCosto, idCompra,idProducto)"
                + " VALUES (?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detCom.getIdDetalle());
            ps.setInt(2, detCom.getCantidad());
            ps.setDouble(3, detCom.getPrecioCosto());
            ps.setInt(4, detCom.getCompra().getIdCompra());
            ps.setInt(5, detCom.getProducto().getIdProducto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detCom.setIdDetalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle de compra Guardado CORRECTAMENTE");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con tabla de detalleCompra" + ex.getMessage());
           
        }
    }
   
    
      public void modificarPrecioCosto(int idCompra, int idProducto, double precioCosto){ // funciona
        String sql= " UPDATE detalleCompra SET precioCosto =? "
               + " WHERE idCompra=? AND idProducto=? ";
         try {
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setDouble(1,precioCosto);
             ps.setInt(2, idCompra);
             ps.setInt(3, idProducto);
              int modificado=ps.executeUpdate();
            if (modificado>0) {
                JOptionPane.showMessageDialog(null,"Precio Costo modificado");
            }
            ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla detalleCompra " + ex.getMessage());
         }
      }
    
   }
