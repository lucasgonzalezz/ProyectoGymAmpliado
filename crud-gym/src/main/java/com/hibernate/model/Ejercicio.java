package com.hibernate.model;

/**
 * Ejercicio: Datos del ejercicio.
 * 
 * @author Lucas & Laura
 * @version 25/05/2023
 *
 */

import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {

	@Id
	@Column(name = "idEjercicio", updatable = false)
	private int idEjercicio;
	@Column(name = "tipoMuscular")
	private String tipoMuscular;
	@Column(name = "nombreEjercicio")
	private String nombreEjercicio;
	@Column(name = "numeroSeries")
	private int numeroSeries;
	@Column(name = "numeroRepeticiones")
	private int numeroRepeticiones;
	@Column(name = "cargaKg")
	private double cargaKg;

	@Fetch(FetchMode.JOIN)
	@ManyToMany // (cascade = CascadeType.ALL)
	@JoinTable(name = "cliente_ejercicio", joinColumns = @JoinColumn(name = "idEjercicio"), inverseJoinColumns = @JoinColumn(name = "idCliente"))
	private List<Cliente> clientes = new ArrayList<Cliente>();

	/**
	 * Constructor.
	 */

	public Ejercicio() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param tipoMuscular
	 * @param nombreEjercicio
	 * @param numeroSeries
	 * @param numeroRepeticiones
	 * @param cargaKg
	 */

	public Ejercicio(String tipoMuscular, String nombreEjercicio, int numeroSeries, int numeroRepeticiones,
			double cargaKg) {
		super();
		this.tipoMuscular = tipoMuscular;
		this.nombreEjercicio = nombreEjercicio;
		this.numeroSeries = numeroSeries;
		this.numeroRepeticiones = numeroRepeticiones;
		this.cargaKg = cargaKg;
	}

	/**
	 * Getter.
	 * 
	 * @return idEjercicio: Devuelve el ID del ejercicio.
	 */

	public int getIdEjercicio() {
		return idEjercicio;
	}

	/**
	 * Setter.
	 * 
	 * @param idEjercicio: Establece el valor de ID del ejercicio.
	 */

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	/**
	 * Getter.
	 * 
	 * @return tipoMuscular: Devuelve el tipo muscular.
	 */

	public String getTipoMuscular() {
		return tipoMuscular;
	}

	/**
	 * Setter.
	 * 
	 * @param tipoMuscular: Establece el valor del tipo muscular
	 */
	public void setTipoMuscular(String tipoMuscular) {
		this.tipoMuscular = tipoMuscular;
	}

	/**
	 * Getter.
	 * 
	 * @return nombreEjercicio: Devuelve el Nombre del ejercicio.
	 */

	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	/**
	 * Setter.
	 * 
	 * @param nombreEjercicio: Establece el Nombre del ejercicio.
	 */

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	/**
	 * Getter.
	 * 
	 * @return numeroSeries: Devuelve el Numero de series del ejercicio.
	 */

	public int getNumeroSeries() {
		return numeroSeries;
	}

	/**
	 * Setter.
	 * 
	 * @param numeroSeries: Establece el Numero de series del ejercicio.
	 */

	public void setNumeroSeries(int numeroSeries) {
		this.numeroSeries = numeroSeries;
	}

	/**
	 * Getter.
	 * 
	 * @return numeroRepeticiones: Devuelve el valor del Numero de repeticiones del
	 *         ejercicio.
	 */

	public int getNumeroRepeticiones() {
		return numeroRepeticiones;
	}

	/**
	 * Setter.
	 * 
	 * @param numeroRepeticiones: Establece el valor del Numero de repeticiones del
	 *                            ejercicio.
	 */

	public void setNumeroRepeticiones(int numeroRepeticiones) {
		this.numeroRepeticiones = numeroRepeticiones;
	}

	/**
	 * Getter.
	 * 
	 * @return cargaKg: Devuelve el valor de la Carga en Kg del ejercicio.
	 */

	public double getCargaKg() {
		return cargaKg;
	}

	/**
	 * Setter.
	 * 
	 * @param cargaKg: Establece el valor de la Carga en Kg del ejercicio.
	 */

	public void setCargaKg(double cargaKg) {
		this.cargaKg = cargaKg;
	}

	/*
	 * Getter
	 * 
	 * @return clientes: Devuelve una lsita de todos los cientes de ejercicios
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/*
	 * Setter
	 * 
	 * @param clientes: Establece una lista de todos los clientes de ejercicio
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	/*
	 * Añade clientes a ejercicios
	 */
	public void anyadirCliente(Cliente c) {
		this.clientes.add(c);
		c.getEjercicios().add(this);
	}

	/*
	 * Quita clientes a ejercicios
	 */
	public void quitarCliente(Cliente c) {
		this.clientes.remove(c);
		c.getEjercicios().remove(this);
	}

}