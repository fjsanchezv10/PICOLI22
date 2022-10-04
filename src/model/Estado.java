package model;

import java.util.LinkedList;

public class Estado {
	// propiedades
	private LinkedList<Ser> poblacion;
	private LinkedList<Ser> trabajadores;
	private LinkedList<Ser> parados;
	private LinkedList<Ser> menores;
	private LinkedList<Ser> ancianos;
	private final int produccionPorTrabajador=400;
	private long capital=0;

	// funciones a realizar
	public void gestionarPeriodo(float incremento) {
		cerrarPeriodoAnterior();
		abrirPeriodoActual(incremento);
	}

	private void abrirPeriodoActual(float incremento) {
		long demandaProxima=calculaDemanda(incremento);
		long diferencia=demandaProxima-calcularProduccionTotal();
		gestionEmpleados(diferencia);
		gestionNacimientos();
	}

	private void gestionNacimientos() {
		// TODO Auto-generated method stub
		
	}

	private void gestionEmpleados(long diferencia) {
		// TODO Auto-generated method stub
		
	}

	private long calculaDemanda(float incremento) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void cerrarPeriodoAnterior() {
		pagarPoblacion();
		envejecerPoblacion();
		enterrarMuertos();
	}

	private void enterrarMuertos() {
		// TODO Auto-generated method stub
		
	}

	private void envejecerPoblacion() {
		poblacion.forEach((ser)->{ser.envejecer();});		
	}

	private void pagarPoblacion() {
		capital+=calcularProduccionTotal();
		long pagoParados=pagarAParados();
		capital-=pagoParados;
		pagarATrabajadores();
		pagoAMenores();
		pagoAAncianos();
	}

	private int calcularProduccionTotal() {
		return trabajadores.size()*produccionPorTrabajador;
	}

	private void pagarATrabajadores() {
		// TODO Auto-generated method stub
		
	}

	private void pagoAAncianos() {
		// TODO Auto-generated method stub
		
	}

	private void pagoAMenores() {
		// TODO Auto-generated method stub
		
	}

	private long pagarAParados() {
		// TODO Auto-generated method stub
		return 0;
	}
}
