package grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo
{
	// Representamos el grafo por su matriz de adyacencia
	private boolean[][] A;
	private int[][] pesos;
	private int V;
	private Vertice[] vertices;
	private int n;
	
	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices)
	{
		A = new boolean[vertices][vertices];
		pesos = new int[vertices][vertices];
		V=vertices;
		this.vertices = new Vertice[vertices];
		n = 1;
		
	}
	
	// Agregado de aristas
	public void agregarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = true;
		A[j][i] = true;
	}

	// Eliminacion de aristas
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		A[i][j] = false;
		A[j][i] = false;
	}

	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return A[i][j];
	}

	// Cantidad de vertices
	public int tamano()
	{
		return A.length;
	}
	
	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				ret.add(j);
		}
		
		return ret;		
	}
	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= A.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	//registra el peso en la matriz de peso
	public void agregarPeso(int i, int j, int p) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		pesos[i][j] = p;
		pesos[j][i] = p;
	}
	
	public void eliminarPeso(int i, int j) {
		pesos[i][j] = 0;
		pesos[j][i] = 0;
	}
	//agrega a las matrices pesos y adyacencia una nueva relacion
	public void agregarRelacion(int i, int j, int p) {
		agregarArista(i,j);
		agregarPeso(i,j,p);
	}
	public void eliminarRelacion(int i, int j) {
		eliminarArista(i,j);
		eliminarPeso(i,j);
	}
	
	// registrar provincia
	public void registrarProvincia(String p) {
		vertices[n] = new Vertice(p);
		System.out.println(n);
		n++;
		
	}

	public List<Arista> primAGM(List<Vertice> vertices) {
		int numVertices = vertices.size();
		List<Arista> agmAristas = new ArrayList<>();
		boolean[] visitados = new boolean[numVertices];

		// Inicializa el primer vértice como visitado
		visitados[0] = true;

		while (agmAristas.size() < numVertices - 1) {
			int minPeso = Integer.MAX_VALUE;
			Arista minArista = null;
			System.out.println("hasta aca llega");

			for (int i = 1; i < numVertices; i++) {
				if (visitados[i]) {
					for (int j = 1; j < numVertices; j++) {
						if (!visitados[j] && A[i][j]) {
							System.out.println("hasta aca llega2");
							int peso = pesos[i][j];
							if (peso < minPeso) {
								minPeso = peso;
								minArista = new Arista(vertices.get(i), vertices.get(j), peso);
							}
						}
					}
				}
			}
			System.out.println("hasta aca llega3");

			if (minArista != null) {
				agmAristas.add(minArista);
				visitados[vertices.indexOf(minArista.getV2())] = true;
			}
		}
		System.out.println("hasta aca llega4");

		return agmAristas;
	}


	public Vertice[] getVertices() {
	    return vertices;
	}

	public boolean[][] getA() {
		return A;
	}

	public int[][] getPesos() {
		return pesos;
	}

	public ArrayList<Arista> eliminarAristasKMenos1(ArrayList<Arista> a, int k) {
		if (a.size() >= k) {
			Collections.sort(a); // Ordena las aristas por peso
			for (int i = 0; i < k - 1; i++) {
				Arista aristaEliminada = a.remove(a.size() - 1); // Elimina las k - 1 aristas de mayor peso
				int vertice1 = aristaEliminada.getV1().getIndice();
	            int vertice2 = aristaEliminada.getV2().getIndice();
	            System.out.println(vertice1 + "  " + vertice2);
	            //el vertice viene con indice de 10 y ni idea de por que
	            //eliminarRelacion(vertice1,vertice2);
	            //eliminarPeso(vertice1,vertice2);
	            
				
			}
		}
		return a;
	}
	public Arista[] eliminarAristasKMenos12(Arista[] aristas, int k) {
	    if (aristas.length >= k) {
	        Arrays.sort(aristas); // Ordena las aristas por peso (asegúrate de que Arista implemente Comparable)
	        Arista[] resultado = new Arista[aristas.length - (k - 1)];
	        System.arraycopy(aristas, 1, resultado, 1, resultado.length);
	        return resultado;
	    } else {
	        return aristas; // No hay suficientes aristas para eliminar
	    }
	}

	public Map<Integer, List<Arista>> encontrarComponentesConexas() {
		boolean[] visitado = new boolean[V];
		Map<Integer, List<Arista>> componentes = new HashMap<>();
		int indiceComponente = 0;

		for (int i = 0; i < V; i++) {
			if (!visitado[i]) {
				List<Arista> componente = new ArrayList<>();
				bfs(i, visitado, componente);
				componentes.put(indiceComponente, componente);
				indiceComponente++;
			}
		}

		return componentes;
	}

	private void bfs(int inicio, boolean[] visitado, List<Arista> componente) {
	    visitado[inicio] = true;

	    for (int j = 1; j < V; j++) {
	        if (A[inicio][j] && !visitado[j]) {
	            Vertice u = vertices[inicio]; 
	            Vertice v = vertices[j]; 
	            Arista arista = new Arista(u, v, pesos[inicio][j]);
	            componente.add(arista);
	            bfs(j, visitado, componente);
	        }
	    }
	}
	
	public List<List<Arista>> encontrarComponentesConexas2() {
	    boolean[] visitado = new boolean[V];
	    List<List<Arista>> componentes = new ArrayList<>();

	    for (int i = 1; i < V; i++) {
	        if (!visitado[i]) {
	            List<Arista> componente = new ArrayList<>();
	            bfs2(i, visitado, componente);
	            componentes.add(componente);
	        }
	    }

	    return componentes;
	}

	private void bfs2(int inicio, boolean[] visitado, List<Arista> componente) {
	    visitado[inicio] = true;

	    for (int j = 1; j < V; j++) {
	        if (A[inicio][j] && !visitado[j]) {
	            Vertice u = vertices[inicio];
	            Vertice v = vertices[j];
	            Arista arista = new Arista(u, v, pesos[inicio][j]);
	            componente.add(arista);
	            bfs2(j, visitado, componente); 
	        }
	    }
	}
	
	public List<List<Vertice>> encontrarComponentesConexas3(List<Arista> aristas) {
	    int V = vertices.length;

	    // Inicializa las estructuras para el DFS
	    boolean[] visitado = new boolean[V];
	    List<List<Vertice>> componentes = new ArrayList<>();

	    // Recorre todos los vértices
	    for (int i = 0; i < V; i++) {
	        if (!visitado[i]) {
	            List<Vertice> componente = new ArrayList<>();
	            dfs3(i, A, visitado, componente);
	            componentes.add(componente);
	        }
	    }

	    return componentes;
	}

	private void dfs3(int v, boolean[][] A, boolean[] visitado, List<Vertice> componente) {
	    visitado[v] = true;
	    componente.add(vertices[v]);
	    for (int j = 0; j < A.length; j++) {
	        if (A[v][j] && !visitado[j]) {
	            dfs3(j, A, visitado, componente);
	        }
	    }
	}
	
    public List<List<Vertice>> encontrarComponentesConexas4(List<Arista> aristasParam) {
        boolean[] visitado = new boolean[n + 1];
        List<List<Vertice>> componentes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visitado[i]) {
                List<Vertice> componenteActual = new ArrayList<>();
                dfs4(i, visitado, componenteActual, aristasParam);
                componentes.add(componenteActual);
            }
        }

        return componentes;
    }

    private void dfs4(int u, boolean[] visitado, List<Vertice> componenteActual, List<Arista> aristasParam) {
        visitado[u] = true;
        componenteActual.add(vertices[u]);

        for (Arista arista : aristasParam) {
            int v = (arista.getV1().getIndice() == u) ? arista.getV2().getIndice() : arista.getV1().getIndice();
            if (!visitado[v]) {
                dfs4(v, visitado, componenteActual, aristasParam);
            }
        }
    }

	

	public void agregarRelacionEntreProvincias(String s, String c, int p) {
	    String nombre1 = s;
	    String nombre2 = c;
	    int indice1 = -1;
	    int indice2 = -1;

	    // Buscar los índices de los vértices
	    for (int i = 1; i < V; i++) {
	        if (vertices[i].getNombre().equals(nombre1)) {
	            indice1 = i;
	        }
	        if (vertices[i].getNombre().equals(nombre2)) {
	            indice2 = i;
	        }
	    }

	    if (indice1 != -1 && indice2 != -1) {
	        agregarRelacion(indice1, indice2, p);
	    } else {
	        System.out.println("No se encontraron las provincias especificadas.");
	    }
	}
}


