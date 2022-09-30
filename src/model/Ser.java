package model;

import utiles.Utiles;

public class Ser {
	// schema de Ser
	private static final int vidaMax = 120;
	private static final int vidaMin = 0;
	protected final int necesidadVital = 100;
	protected float esperanzaVida;
	protected int edad = 0;

	public Ser() {
		super();
		this.esperanzaVida = this.calculaEsperanzaVida(vidaMin, vidaMax);
	}

	public Ser(Ser ser) {
		this.esperanzaVida = ser.esperanzaVida;
		this.edad=ser.edad;
	}
	

	public Ser(float esperanzaVida) {
		super();
		this.esperanzaVida = esperanzaVida;
	}

	// comportamiento igual para todos
	public boolean vivir(int cantidad) {
		if (isAlive()) {
			cobrar(cantidad);
			envejecer();
		}
		return isAlive();
	}

	public boolean isAlive() {
		return this.edad < this.esperanzaVida;
	}

	protected void envejecer() {
		this.edad++;
	}

	protected void cobrar(int cantidad) {
		this.alimentar(cantidad);
	}

	protected void alimentar(int cantidad) {
		alimentarBase(cantidad);
	}

	protected void alimentarPersona(int cantidad, int porcenMax, int porcenMin, float periodoMin, float periodoMax) {
		float porcentaje = cantidad * 100 / this.necesidadVital;
		if (porcentaje <= porcenMax && porcentaje >= porcenMin) {
			this.esperanzaVida -= periodoMin;
		} else if (porcentaje <= periodoMin - 1) {
			this.esperanzaVida -= periodoMax;
		}
	}

	private void alimentarBase(int cantidad) {
		alimentarPersona(cantidad, 99, 33, 1f, 2f);
	}

	private int calculaEsperanzaVida(int minimo, int maximo) {
		return Utiles.dameNumero(maximo);
	}

	public int getEdad() {
		return edad;
	}

}
