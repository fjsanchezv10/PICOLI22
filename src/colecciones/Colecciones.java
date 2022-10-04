package colecciones;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Colecciones {
	public static void main(String[] args) {
		ArrayList lista=new ArrayList<>();
		LinkedList linkaf=new LinkedList<>();
		// una cola. First In First Out
		ArrayDeque ll=new ArrayDeque<>();
		//uso alternativo seria con linked
		//operaciones de cola son encolar, desencolar
		//encolar
		linkaf.offer("hola");
		linkaf.offer("adios");
		//desencolar
		Object pop = linkaf.poll();
		System.err.println(pop);
		pop = linkaf.poll();
		System.err.println(pop);
		linkaf.offer("buenas");
		//desencola sin borrar
		Object peek = linkaf.peek();
		System.err.println(peek);
		peek = linkaf.peek();
		peek = linkaf.poll();
		// de tipo pila
		// los elementos que entran despues salen antes
		// First In Last Out
		//apilando
		linkaf.push("hola");
		linkaf.push("hol3");
		linkaf.push("hol4");
		//desapilar
		System.out.println(linkaf.pop());
		System.out.println(linkaf.pop());
		System.out.println(linkaf.pop());
	}
}
