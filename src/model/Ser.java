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
		this.esperanzaVida=vida;
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
				edad = (int) (esperanzaVida + 1);
			}
			this.estado = Estado.adulto;
		} else if (edad == 65) {
			this.estado = Estado.anciano;
		}
	};

	private void cobrar(int cantidad) {
		if (this.estado == Estado.menor||this.estado==Estado.anciano) {
			this.alimentar(cantidad);
		} else if (this.estado == Estado.adulto) {
			int sobrante=cantidad-necesidadVital;
			if(sobrante>=0) {
				this.alimentar(cantidad);
				this.ahorros+=sobrante;
			}else {
				this.ahorros+=sobrante;
				//tengo ahorros suficientes
				if(ahorros>=0) {
					this.alimentar(cantidad);
				}else {
					this.alimentar(cantidad-(int)ahorros);
					this.ahorros=0;
				}
			}
			
		} else if (this.estado == Estado.anciano) {

		}
	}

	private void alimentar(int cantidad) {
		if (this.estado == Estado.menor) {
			float porcentaje = (float) cantidad * 100 / this.necesidadVital;
			this.factorDeDesarrollo += 5.5f * porcentaje / 100;
		} else if (this.estado == Estado.adulto) {
			float porcentaje = cantidad * 100 / this.necesidadVital;
			if (porcentaje <= 99 && porcentaje >= 50) {
				this.esperanzaVida -= 0.5f;
			} else if (porcentaje <= 49) {
				this.esperanzaVida -= 1;
			}
		} else if (this.estado == Estado.anciano) {
			float porcentaje = cantidad * 100 / this.necesidadVital;
			if (porcentaje <= 99 && porcentaje >= 30) {
				this.esperanzaVida -= 1f;
			} else if (porcentaje <= 29) {
				this.esperanzaVida -= 2;
			}
		}
	};

	private int calculaEsperanzaVida(int minimo, int maximo) {
		return Utiles.dameNumero(maximo);
	}

}
