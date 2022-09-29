package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import model.Ser;

class SerTest {

	@Test
	void testMenorFallido() {
		Ser ser=new Ser(50);
		int cantidadInsuficienteLimite=55;
		int periodos=18;
		do {
			ser.vivir(cantidadInsuficienteLimite);
		}while(periodos-->0);
		assertTrue(!ser.isAlive());
	}
	
	@Test
	void testMenorExitoso() {
		Ser ser=new Ser(50);
		int cantidadSuficienteLimite=56;
		int periodos=18;
		do {
			ser.vivir(cantidadSuficienteLimite);
		}while(periodos-->0);
		assertTrue(ser.isAlive());
	}
	
	@Test
	void testAdultoTrabajador() {
		Ser ser=new Ser(65);
		int cantidadSuficienteLimite=56;
		int periodos=18;
		do {
			ser.vivir(cantidadSuficienteLimite);
		}while(periodos-->0);
		//ahora es adulto
		//tres casos, lo alimentamos bien y mal
		
	}

}
