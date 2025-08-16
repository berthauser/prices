package ar.dignitas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import ar.dignitas.model.Articulos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ConsultaPreciosDAO {
	
	
	public static ObservableList<Articulos> buscarPrecios(String codigoInterno) throws Exception {
		
		String selectStmt = "SELECT DESCRIPCION, ((COSTO_UNITARIO * (UTILIDAD/100)) + COSTO_UNITARIO) * (GRAVAMEN/100 + 1) AS PUBLICO  FROM articulos\r\n"
				+ "WHERE CODIGO_INTERNO = '" + codigoInterno + "'";

		try (ResultSet rsPrecios = DBUtil.dbExecuteQuery(selectStmt)) {
			
			ObservableList<Articulos> precio = getPrecio(rsPrecios);
			
			return precio;
			
		} catch (SQLException e) {
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Error de SQL");
			alert2.setContentText("Imposible mostrar el Precio" + e);
			e.printStackTrace();
			alert2.showAndWait();
			throw e;
		}
	}

	private static ObservableList<Articulos> getPrecio(ResultSet rs) throws SQLException, ClassNotFoundException {
		
		ObservableList<Articulos> listaArticulos = FXCollections.observableArrayList();
		
		while (rs.next()) {
			Articulos articulos = new Articulos();
			articulos.setPrecioPublico(rs.getDouble("PUBLICO"));
			articulos.setDescripcion(rs.getString("DESCRIPCION"));
			listaArticulos.add(articulos);
		}
		return listaArticulos;
	}

}