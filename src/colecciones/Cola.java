package colecciones;

import java.util.LinkedList;

public class Cola<T> {
	private LinkedList<T> linkaf=new LinkedList<T>();
	
	public T desapilar() {
		return linkaf.pop();
	}
	
	public boolean apilar(T t) {
		return linkaf.offer(t);
	}
}
