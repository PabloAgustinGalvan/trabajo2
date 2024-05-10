package grafo;

public class Arista implements Comparable<Arista> {
	
	private Vertice v1;
	private Vertice v2;
	
	private int peso;

	public Arista(Vertice v1, Vertice v2, int peso) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.peso = peso;
	}

	public Vertice getV1() {
		return v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public int compareTo(Arista o) {
		return Integer.compare(this.peso, o.peso);
	}

	@Override
	public String toString() {
		return "Arista " + v1.getNombre() +v2.getNombre() +" (peso " + peso + ")";
	}
	
	
	
	
	
	
	
	

}
