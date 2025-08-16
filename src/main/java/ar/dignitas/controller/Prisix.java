package ar.dignitas.controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import ar.dignitas.dao.ConsultaPreciosDAO;
import ar.dignitas.dao.DBUtil;
import ar.dignitas.model.Articulos;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Prisix {
	
	@FXML
	private TextField txtCodigo;
	@FXML
	private TextField txtDescripcion;
	@FXML
	private Label lblFecha;
	@FXML
	private Label lblHora;
	@FXML
	private TextField txtPrecioContado;
	@FXML
	private TextField txtPrecioFinanciado;
	@FXML
	private ImageView imgLogo;
	
	private static final DateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
	
	ObservableList<Articulos> listaPrecios = FXCollections.observableArrayList();
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	public void initialize() throws FileNotFoundException, SQLException {
		
		Date date = new Date();
	    lblFecha.setText((sdf.format(date)));
	    
	    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
	    	LocalTime currentTime = LocalTime.now();
	    	lblHora.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
	    }),
	         new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
	    
	    imgLogo.setImage(new Image("/images/vitris.png"));
		imgLogo.setSmooth(true);
		
		Platform.runLater(() -> {
			try {
				DBUtil.dbConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		txtCodigo.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				String[] parts = txtCodigo.getText().split("\\(");
				try {
					mostrarPrecios(parts[0].strip());
					txtCodigo.requestFocus();
					txtCodigo.selectAll();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				txtCodigo.requestFocus();
			}
		});
		
	}

	private Boolean mostrarPrecios(String articulo) throws Exception, IndexOutOfBoundsException {
		
		DecimalFormat df = new DecimalFormat("$###,###.##");
		
		double porcentualFinanciado = Double.valueOf("1.18");
		
		try {
			
			listaPrecios = ConsultaPreciosDAO.buscarPrecios(articulo);

			txtPrecioContado.setText(df.format(listaPrecios.get(0).getPrecioPublico()));

			double precioFinanciado = porcentualFinanciado * listaPrecios.get(0).getPrecioPublico();

			txtPrecioFinanciado.setText(df.format(precioFinanciado));
			
			txtDescripcion.setText(listaPrecios.get(0).getDescripcion());
			
		} catch (SQLException | IndexOutOfBoundsException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error de SQL");
			alert.setHeaderText("Imposible Mostrar los Precios");
			alert.setContentText("Verifique Existencia en Stock\r\n");
			e.printStackTrace();
			alert.showAndWait()
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response -> txtCodigo.requestFocus());     	
		}
		
		return listaPrecios.isEmpty();
	}

}
