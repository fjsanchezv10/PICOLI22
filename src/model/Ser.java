package model;

import utiles.Utiles;

public class Ser {
	private static final int vidaMax = 120;
	private static final int vidaMin = 0;
	private final int necesidadVital = 100;
	private float esperanzaVida;
	private float factorDeDesarrollo = 0;
	private int edad = 0;
	private Estado estado = Estado.menor;
	private long ahorros = 0;

	public Ser() {
		super();
		this.esperanzaVida = this.calculaEsperanzaVida(vidaMin, vidaMax);
	}

	public Ser(int vida) {
		this.esperanzaVida = vida;
	}

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

	private void envejecer() {
		this.edad++;
		if (edad == 18) {
			if (factorDeDesarrollo < 55) {
				// aqui lo mato
				matar();
			}
			this.estado = Estado.adulto;
		} else if (edad == 65) {
			this.estado = Estado.anciano;
		}
	}

	private void matar() {
		edad = (int) (esperanzaVida + 1);
	};

	private void cobrar(int cantidad) {
		if (this.estado == Estado.menor || this.estado == Estado.anciano) {
			this.alimentar(cantidad);
		} else if (this.estado == Estado.adulto) {
			calcularCobroAdulto(cantidad);
		}
	}

	private void calcularCobroAdulto(int cantidad) {
		int sobrante = cantidad - necesidadVital;
		if (sobrante >= 0) {
			this.alimentar(cantidad);
			this.ahorros += sobrante;
		} else {
			calcularAportacionAhorro(cantidad, sobrante);
		}
	}

	private void calcularAportacionAhorro(int cantidad, int sobrante) {
		this.ahorros += sobrante;
		// tengo ahorros suficientes
		if (ahorros >= 0) {
			this.alimentar(cantidad);
		} else {
			this.alimentar(cantidad - (int) ahorros);
			this.ahorros = 0;
		}
	}

	private void alimentar(int cantidad) {
		switch (this.estado) {
		case menor:
			alimentarMenor(cantidad);
			break;
		case adulto:
			alimentarAdultos(cantidad);
			break;
		case anciano:
			alimentarAnciano(cantidad);
			break;
		}
	}

	private void alimentarPersona(int cantidad, int porcenMax, int porcenMin, float periodoMin, float periodoMax) {
		float porcentaje = cantidad * 100 / this.necesidadVital;
		if (porcentaje <= porcenMax && porcentaje >= porcenMin) {
			this.esperanzaVida -= periodoMin;
		} else if (porcentaje <= periodoMin - 1) {
			this.esperanzaVida -= periodoMax;
		}
	}

	private void alimentarAnciano(int cantidad) {
		alimentarPersona(cantidad, 99, 33, 1f, 2f);
	}

	private void alimentarAdultos(int cantidad) {
		alimentarPersona(cantidad, 99, 50,0.5f, 1f);
	}

	private void alimentarMenor(int cantidad) {
		float porcentaje = (float) cantidad * 100 / this.necesidadVital;
		this.factorDeDesarrollo += 5.5f * porcentaje / 100;
	};

	private int calculaEsperanzaVida(int minimo, int maximo) {
		return Utiles.dameNumero(maximo);
	}

}
