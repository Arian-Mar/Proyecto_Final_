package org.example.persistencia;



import org.example.modelo.RedesSociales;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RedesSocialesDAO implements InterfazDAO {
    public RedesSocialesDAO() {
    }

    //Metodo invocado en el modelo en el metodo AgregarRedesSociales
    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO fortnite(nombre,añoDeInicio,ColorAplicacion,usuarios,imagenurl) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("RedesSocialesDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((RedesSociales) obj).getNombre());
        pstm.setString(2, ((RedesSociales) obj).getAnioDeInicio());
        pstm.setString(3, ((RedesSociales) obj).getColorAplicacion());
        pstm.setString(4, ((RedesSociales) obj).getUsuarios());
        pstm.setString(5, ((RedesSociales) obj).getImagenUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE redesSociales SET nombre = ?,añoDeInicio = ?,colorAplicacion = ?,usuario = ?,imagenurl = ? WHERE id = ? ";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("redesSocialesDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setInt(1, ((RedesSociales) obj).getId());
        pstm.setString(2, ((RedesSociales) obj).getNombre());
        pstm.setString(3, ((RedesSociales) obj).getAnioDeInicio());
        pstm.setString(4, ((RedesSociales) obj).getColorAplicacion());
        pstm.setString(5, ((RedesSociales) obj).getUsuarios());
        pstm.setString(6, ((RedesSociales) obj).getImagenUrl());

        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    //Metodo invocado en el modelo en el metodo actualizarUnElemento
    public boolean updateUnElemento(Object obj, int id, int columna) throws SQLException {
        int rowCount = 0;
        String sqlDelete;
        PreparedStatement pstm= null;
        switch (columna){
            case 0:
                System.out.println("No se puede actualizar un id");
                break;
            case 1:
                sqlDelete = "UPDATE redesSociales SET nombre = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("redesSocialesDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 2:
                sqlDelete = "UPDATE redesSociales SET añoDeInicio = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("redesSocialesDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 3:
                sqlDelete = "UPDATE redesSociales SET colorAplicacion = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("redesSocialesDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 4:
                sqlDelete = "UPDATE redesSociales SET usuarios= ? WHERE id = ? ;";
                pstm = Conexion.getInstance("redesSocialesDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
            case 5:
                sqlDelete = "UPDATE redesSociales SET imagenurl = ? WHERE id = ? ;";
                pstm = Conexion.getInstance("redesSocialesDB.db").getConnection().prepareStatement(sqlDelete);
                pstm.setString(1, (String)obj);
                pstm.setInt(2, id);
                rowCount = pstm.executeUpdate();
                break;
        }
        return rowCount > 0;
    }

    //Metodo invocado en el modelo en el metodo borrar RedesSociales
    @Override
    public boolean delete(int id) throws SQLException {
        String sqlDelete = "DELETE FROM redesSociales WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("redesSocialesDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, id);
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM redesSociales";
        ArrayList<RedesSociales> resultado = new ArrayList<>();
        Statement stm = Conexion.getInstance("redesSocialesDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new RedesSociales(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6)));
        }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM redesSociales WHERE id = ?";
        RedesSociales redesSociales = null;

        PreparedStatement pstm = Conexion.getInstance("redesSocialesDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            redesSociales = new RedesSociales(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6));

            return redesSociales;
        }
        return null;
    }

}