package model.repo;

import java.util.List;
import java.util.stream.Collectors;

import model.Adulto;
import model.Menor;
import model.Ser;

public class SerRepository {
	List<Ser> listaSeres;
	
	public List<Ser> findAll(){
		return this.listaSeres;
	}
	
	private List<Ser> findAdultos(){
		return this.listaSeres.stream()
			.filter( ser -> ser instanceof Adulto)
			.collect(Collectors.toList());
	}
	
	private List<Ser> findMenores(){
		return this.listaSeres.stream()
			.filter( ser -> ser instanceof Menor)
			.collect(Collectors.toList());
	}
	
}
