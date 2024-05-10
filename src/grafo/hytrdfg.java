package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hytrdfg {

	
	public static void main(String[] args) {
		/*
		
		Vertice v1 = new Vertice("Buenos Aires");
		Vertice v2 = new Vertice("Tierra del fuego");
		Arista arista = new Arista(v1,v2,5000);
		
		Vertice v3 = new Vertice("Cordoba");
		Vertice v4 = new Vertice("Chubut");
		Arista arista1 = new Arista(v2,v3,4000);
		//con esto se agrega la relacion en la matriz de adyacencia del grafo
		grafo.agregarArista(v1.getIndice(), v2.getIndice());
		grafo.agregarArista(v2.getIndice(), v3.getIndice());
		// de bs as a tierra del fuego y de tierra del fuego a cordoba
		
		
		
		
		//en el caso de que kruskal devuelva una lista de aristas
		List<Arista> aristas = new ArrayList<>();
		aristas.add(arista1);
		aristas.add(arista);
		Grafo grafoAgm = new Grafo(aristas.size());
		for(Arista a: aristas) {
			grafoAgm.agregarArista(a.getV1().getIndice(), a.getV2().getIndice());
		}*/
		Grafo grafo = new Grafo(6);
		grafo.registrarProvincia("A");
		grafo.registrarProvincia("B");
		grafo.registrarProvincia("C");
		grafo.registrarProvincia("D");
		grafo.registrarProvincia("E");
		for (int i = 1; i < grafo.getVertices().length; i++) {
		    Vertice v = grafo.getVertices()[i];
		    if (v != null) {
		        System.out.println(v.getNombre());
		    }
		}
		grafo.agregarRelacionEntreProvincias("A","B" ,2);
		grafo.agregarRelacionEntreProvincias("A","C" ,3);
		grafo.agregarRelacionEntreProvincias("B","C" ,5);
		grafo.agregarRelacionEntreProvincias("B","D" ,4);
		grafo.agregarRelacionEntreProvincias("C","E" ,1);
		
		//System.out.println(grafo.getVertices().size());
		//List<Arista> aristas = grafo.primAGM(grafo.getVertices());
		//System.out.println(aristas.size());
		//for(Arista a: aristas) {
			//7System.out.println(a.toString());
		//}
		//System.out.println("sfd");
	
		
		//System.out.println(indice2);
		imprimirMatriz(grafo.getPesos());
		//imprimirMatrizBoolean(grafo.getA());
		
		//pasarlo al agm luego directo a eliminar las k-1 y vuelvo a convertirlo en grafo con matrices
		ArrayList<Arista> a = new ArrayList<>();
		Arista[] aristasArray = new Arista[a.size()];
		for (int i = 1; i < a.size(); i++) {
		    aristasArray[i] = a.get(i);
		    System.out.println(aristasArray[i].toString()+"dsds");
		}


		a.add(new Arista(new Vertice("A"),new Vertice("B"),2));
		a.add(new Arista(new Vertice("A"),new Vertice("C"),3));
		a.add(new Arista(new Vertice("B"),new Vertice("C"),5));
		a.add(new Arista(new Vertice("B"),new Vertice("D"),4));
		a.add(new Arista(new Vertice("C"),new Vertice("E"),1));
		for(Arista arista: a) {
			System.out.println(arista.toString());
			}
		System.out.println("-----d");
		System.out.println(grafo.getPesos().length);
		System.out.println(grafo.getA().length);
		System.out.println(grafo.getVertices().length);
		System.out.println("eliminando");
		grafo.eliminarAristasKMenos1(a, 3);
		//grafo.eliminarAristasKMenos12(aristasArray, 1);
		//for (int i = 1; i < aristasArray.length; i++) {
		    //System.out.println(aristasArray[i].toString());
		//}
		System.out.println("-----");
		for(Arista arista: a) {
			System.out.println(arista.toString());
			}
		List<List<Vertice>> componentes = grafo.encontrarComponentesConexas3(a);
		System.out.println(componentes.size());

	    // Iterar sobre las componentes
	    for (int i = 1; i < componentes.size(); i++) {
	        System.out.println("Componente " + i + ":");
	        List<Vertice> componente = componentes.get(i);

	        // Recorrer las aristas dentro de la componente
	        for (Vertice v : componente) {
	        	if(v!=null) {
	        		System.out.println("Vertice: " + v.getNombre() + i);
	        	}
	            
	        }
	    }
		
	
	
	
	
	
	}

	// Imprimir la matriz
	public static void imprimirMatriz(int[][] matriz) {
			
	        System.out.println("Matriz de pesos:");
	        for (int i = 1; i < matriz.length; i++) {
	            for (int j = 1; j < matriz[i].length; j++) {
	                System.out.print(matriz[i][j] + " ");
	            }
	            System.out.println();
	        }
	}
	 


	public static void imprimirMatrizBoolean(boolean[][] matriz) {

		System.out.println("Matriz de adyacencia:");
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
			    
	
		
	
		
		
				
		
	}

}
