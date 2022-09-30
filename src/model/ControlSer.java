package model;

public class ControlSer {

	public static Ser crearSer() {
		return new Menor();
	}

	public static Ser crearSer(int esperanza) {
		return new Menor(esperanza);
	}

	public static Ser controlarEtapas(Ser ser) {
		if (ser.getEdad() == 18)
			return new Adulto(ser);
		if (ser.getEdad() == 65)
			return new Ser(ser);
		return ser;
	}
}
