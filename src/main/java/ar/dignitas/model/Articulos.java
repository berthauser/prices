package ar.dignitas.model;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Articulos {
	private final StringProperty codigo_interno;
	private final StringProperty descripcion;
	private final StringProperty tipo;
	private final IntegerProperty stock;
	private final IntegerProperty puntoReposicion;
	private final IntegerProperty idLinea;
	private final IntegerProperty idMedida;
	private final IntegerProperty idPresentacion;
	private final IntegerProperty idProveedor;
	private final SimpleObjectProperty<LocalDate> fechaCompra;
	private final SimpleObjectProperty<LocalDate> fechaBaja;
	private final SimpleObjectProperty<LocalDate> fechaActPrecios;
	private final IntegerProperty idUbicacion;
	private final IntegerProperty fila;
	private final IntegerProperty columna;
	private final DoubleProperty costoUnitario;
	private final DoubleProperty utilidad;
	private final IntegerProperty idEstado;
	private final DoubleProperty gravamen;
	private final DoubleProperty precioPublico;
	
	public Articulos() {
		
		codigo_interno = new SimpleStringProperty();
		descripcion = new SimpleStringProperty();
		tipo = new SimpleStringProperty();
		stock = new SimpleIntegerProperty();
		puntoReposicion = new SimpleIntegerProperty();
		idLinea = new SimpleIntegerProperty();
		idMedida = new SimpleIntegerProperty();
		idPresentacion = new SimpleIntegerProperty();
		idProveedor = new SimpleIntegerProperty();
		fechaCompra = new SimpleObjectProperty<>();
		fechaBaja = new SimpleObjectProperty<>();
		fechaActPrecios = new SimpleObjectProperty<>();
		idUbicacion = new SimpleIntegerProperty();
		fila = new SimpleIntegerProperty();
		columna = new SimpleIntegerProperty();
		costoUnitario = new SimpleDoubleProperty();
		utilidad = new SimpleDoubleProperty();
		idEstado = new SimpleIntegerProperty();
		gravamen = new SimpleDoubleProperty();
		precioPublico = new SimpleDoubleProperty();
		
	}

	public Articulos(String codigo_interno, String descripcion, String tipo, Integer stock, Integer puntoReposicion,
			Integer idLinea, Integer idMedida, Integer idPresentacion, Integer idProveedor, LocalDate fechaCompra,
			LocalDate fechaBaja, LocalDate fechaActPrecios, Integer idUbicacion, Integer fila, Integer columna,
			Double costoUnitario, Double utilidad, Integer idEstado, Double gravamen, Double precioPublico) {
		this();
		this.codigo_interno.set(codigo_interno);
		this.descripcion.set(descripcion);
		this.tipo.set(tipo);
		this.stock.set(stock);
		this.puntoReposicion.set(puntoReposicion);
		this.idLinea.set(idLinea);
		this.idMedida.set(idMedida);
		this.idPresentacion.set(idPresentacion);
		this.idProveedor.set(idProveedor);
		this.fechaCompra.set(fechaCompra);
		this.fechaBaja.set(fechaBaja);
		this.fechaActPrecios.set(fechaActPrecios);
		this.idUbicacion.set(idUbicacion);
		this.fila.set(fila);
		this.columna.set(columna);
		this.costoUnitario.set(costoUnitario);
		this.utilidad.set(utilidad);
		this.idEstado.set(idEstado);
		this.gravamen.set(gravamen);
		this.precioPublico.set(precioPublico);
	}

	public StringProperty codigo_internoProperty() {
		return this.codigo_interno;
	}
	

	public String getCodigo_interno() {
		return this.codigo_internoProperty().get();
	}
	

	public void setCodigo_interno(final String codigo_interno) {
		this.codigo_internoProperty().set(codigo_interno);
	}
	

	public StringProperty descripcionProperty() {
		return this.descripcion;
	}
	

	public String getDescripcion() {
		return this.descripcionProperty().get();
	}
	

	public void setDescripcion(final String descripcion) {
		this.descripcionProperty().set(descripcion);
	}
	

	public StringProperty tipoProperty() {
		return this.tipo;
	}
	

	public String getTipo() {
		return this.tipoProperty().get();
	}
	

	public void setTipo(final String tipo) {
		this.tipoProperty().set(tipo);
	}
	

	public IntegerProperty stockProperty() {
		return this.stock;
	}
	

	public int getStock() {
		return this.stockProperty().get();
	}
	

	public void setStock(final int stock) {
		this.stockProperty().set(stock);
	}
	

	public IntegerProperty puntoReposicionProperty() {
		return this.puntoReposicion;
	}
	

	public int getPuntoReposicion() {
		return this.puntoReposicionProperty().get();
	}
	

	public void setPuntoReposicion(final int puntoReposicion) {
		this.puntoReposicionProperty().set(puntoReposicion);
	}
	

	public IntegerProperty idLineaProperty() {
		return this.idLinea;
	}
	

	public int getIdLinea() {
		return this.idLineaProperty().get();
	}
	

	public void setIdLinea(final int idLinea) {
		this.idLineaProperty().set(idLinea);
	}
	

	public IntegerProperty idMedidaProperty() {
		return this.idMedida;
	}
	

	public int getIdMedida() {
		return this.idMedidaProperty().get();
	}
	

	public void setIdMedida(final int idMedida) {
		this.idMedidaProperty().set(idMedida);
	}
	

	public IntegerProperty idPresentacionProperty() {
		return this.idPresentacion;
	}
	

	public int getIdPresentacion() {
		return this.idPresentacionProperty().get();
	}
	

	public void setIdPresentacion(final int idPresentacion) {
		this.idPresentacionProperty().set(idPresentacion);
	}
	

	public IntegerProperty idProveedorProperty() {
		return this.idProveedor;
	}
	

	public int getIdProveedor() {
		return this.idProveedorProperty().get();
	}
	

	public void setIdProveedor(final int idProveedor) {
		this.idProveedorProperty().set(idProveedor);
	}
	

	public SimpleObjectProperty<LocalDate> fechaCompraProperty() {
		return this.fechaCompra;
	}
	

	public LocalDate getFechaCompra() {
		return this.fechaCompraProperty().get();
	}
	

	public void setFechaCompra(final LocalDate fechaCompra) {
		this.fechaCompraProperty().set(fechaCompra);
	}
	

	public SimpleObjectProperty<LocalDate> fechaBajaProperty() {
		return this.fechaBaja;
	}
	

	public LocalDate getFechaBaja() {
		return this.fechaBajaProperty().get();
	}
	

	public void setFechaBaja(final LocalDate fechaBaja) {
		this.fechaBajaProperty().set(fechaBaja);
	}
	

	public SimpleObjectProperty<LocalDate> fechaActPreciosProperty() {
		return this.fechaActPrecios;
	}
	

	public LocalDate getFechaActPrecios() {
		return this.fechaActPreciosProperty().get();
	}
	

	public void setFechaActPrecios(final LocalDate fechaActPrecios) {
		this.fechaActPreciosProperty().set(fechaActPrecios);
	}
	

	public IntegerProperty idUbicacionProperty() {
		return this.idUbicacion;
	}
	

	public int getIdUbicacion() {
		return this.idUbicacionProperty().get();
	}
	

	public void setIdUbicacion(final int idUbicacion) {
		this.idUbicacionProperty().set(idUbicacion);
	}
	

	public IntegerProperty filaProperty() {
		return this.fila;
	}
	

	public int getFila() {
		return this.filaProperty().get();
	}
	

	public void setFila(final int fila) {
		this.filaProperty().set(fila);
	}
	

	public IntegerProperty columnaProperty() {
		return this.columna;
	}
	

	public int getColumna() {
		return this.columnaProperty().get();
	}
	

	public void setColumna(final int columna) {
		this.columnaProperty().set(columna);
	}
	

	public DoubleProperty costoUnitarioProperty() {
		return this.costoUnitario;
	}
	

	public double getCostoUnitario() {
		return this.costoUnitarioProperty().get();
	}
	

	public void setCostoUnitario(final double costoUnitario) {
		this.costoUnitarioProperty().set(costoUnitario);
	}
	

	public DoubleProperty utilidadProperty() {
		return this.utilidad;
	}
	

	public double getUtilidad() {
		return this.utilidadProperty().get();
	}
	

	public void setUtilidad(final double utilidad) {
		this.utilidadProperty().set(utilidad);
	}
	

	public IntegerProperty idEstadoProperty() {
		return this.idEstado;
	}
	

	public int getIdEstado() {
		return this.idEstadoProperty().get();
	}
	

	public void setIdEstado(final int idEstado) {
		this.idEstadoProperty().set(idEstado);
	}
	

	public DoubleProperty gravamenProperty() {
		return this.gravamen;
	}
	

	public double getGravamen() {
		return this.gravamenProperty().get();
	}
	

	public void setGravamen(final double gravamen) {
		this.gravamenProperty().set(gravamen);
	}
	

	public DoubleProperty precioPublicoProperty() {
		return this.precioPublico;
	}
	

	public double getPrecioPublico() {
		return this.precioPublicoProperty().get();
	}
	

	public void setPrecioPublico(final double precioPublico) {
		this.precioPublicoProperty().set(precioPublico);
	}
	
	@Override
	public String toString() {
		return "Articulos [codigo_interno=" + codigo_interno + ", descripcion=" + descripcion + ", tipo=" + tipo
				+ ", stock=" + stock + ", puntoReposicion=" + puntoReposicion + ", idLinea=" + idLinea + ", idMedida="
				+ idMedida + ", idPresentacion=" + idPresentacion + ", idProveedor=" + idProveedor + ", fechaCompra="
				+ fechaCompra + ", fechaBaja=" + fechaBaja + ", fechaActPrecios=" + fechaActPrecios + ", idUbicacion="
				+ idUbicacion + ", fila=" + fila + ", columna=" + columna + ", costoUnitario=" + costoUnitario
				+ ", utilidad=" + utilidad + ", idEstado=" + idEstado + ", gravamen=" + gravamen + ", precioPublico="
				+ precioPublico + "]";
	}
	

}
