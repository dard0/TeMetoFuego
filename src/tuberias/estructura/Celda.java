package tuberias.estructura;

import java.util.HashMap;
import java.util.Map;

public class Celda {
	private Map<Direccion, Celda> vecinas;
	private int capacidad;
	private final static int CAPACIDAD_MAXIMA = 5;
	private int caudal;
	private boolean saturada;
	private boolean vacia;
	
	//CONSTRUCTORES
	public Celda(){
		this.caudal = 0;
		this.capacidad = CAPACIDAD_MAXIMA;
		this.saturada = false;
		this.vacia = true;
		this.vecinas = new HashMap<Direccion, Celda>();
	}

	public Celda(int capacidad){
		this.caudal = 0;
		this.capacidad = capacidad;
		this.saturada = false;
		this.vacia = true;
		this.vecinas = new HashMap<Direccion, Celda>();
		
		//T_D_S P_T_S
		// vecinas.put(Direccion.DERECHA, new Celda(23));
	}
	
	//GETTERS
	public Map<Direccion,Celda> getVecinas() {
		return new HashMap<Direccion,Celda>(vecinas);
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getCaudal() {
		return caudal;
	}

	public boolean isSaturada() {
		return saturada;
	}

	public boolean isVacia() {
		return vacia;
	}
	
	//FUNCIONALIDAD
	public void incrementarCaudal(){
		if (this.caudal+1 <= CAPACIDAD_MAXIMA) this.caudal++;
	}
	public void decrementarCaudal(){
		if (this.caudal-1 >= 0) this.caudal--;
	}
	
	public void establecerVecina(Celda celda, Direccion direccion){
		
	}
	






}
