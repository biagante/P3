package aula4;

import java.util.*;

public class ColecaoFiguras {

	private List<Figura> shapes = new ArrayList<>();
	private double maxArea;
	private double areaTotal;
	
	
	// O construtor define a área máxima da	coleção de figuras
	public ColecaoFiguras(double maxArea) {
		this.maxArea = maxArea;
		this.areaTotal = 0;
	}
	
	// Adiciona uma figura à coleção
	public boolean addFigura(Figura f) {
		if (areaTotal + f.area() > maxArea || exists(f)) {
			return false;
		}
		areaTotal += f.area();
		return shapes.add(f);
	}
	
	// Remove uma figura da coleção
	public boolean delFigura(Figura f) {
		areaTotal -= f.area(); //atualiza a area total
		return shapes.remove(f);
	}
	
	// Retorna a área total das figuras
	public double areaTotal() {
		return areaTotal;
	}
	
	// Verifica se uma figura existe na coleção
	public boolean exists(Figura f) {
		return shapes.contains(f);
	}
	
	// Retorna as características da coleção
	@Override
	public String toString() {
		return "Área Total da Lista de Figuras: " + areaTotal();
	}
	
	// Retorna uma lista com todas as figuras da coleção
	public Figura[] getFiguras() {
		return shapes.toArray(new Figura[0]);
	}
	
	// Retorna uma lista com todos os centros das figuras da coleção
	public Ponto[] getCentros() {
		List<Ponto> points = new ArrayList<>();
		for(Figura f : getFiguras()) {
			points.add(f.centro);
		}
		return points.toArray(new Ponto[0]);
	}
	
}
