package grafo;

public class Vertice {
	//el indice tiene que ser autoincremental en 1
	private static int indice = 0;
	private String nombre;
	private int indiceReal;
	
	
	public Vertice(String nombre) {
		indice++;
		this.nombre = nombre;
		indiceReal=indice;
	} 


	public int getIndice() {
		return indiceReal;
	}


	public String getNombre() {
		return nombre;
	}
	
	public void reiniciarIndice() {
		indice = 0;
	}


	
	
	

}
