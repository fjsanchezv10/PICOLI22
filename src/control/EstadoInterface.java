package control;

public interface EstadoInterface {
	// Fabricar lo que después se venderá al exterior, respecto a una demanda concreta
	public void fabricar(int demanda);
	
	// Controlar los seres que nacen
	void crearSeres();
	
	// Controlar si trabajan, van al paro y su salario
	void controlarAdultos();
	
	// Pagar en este orden: costes de fabricación <- ahorros del Estado <- población
	void pagar(float costesProduccion);
	
	// Realizamos el presupuesto. De lo que sobre del gasto de pagar a los demás
	void calcularGastosSeguridadSocial();
	
}
