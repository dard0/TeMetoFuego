package tuberias.estructura;

public class Celda {
	private Celda[] vecinas;
	private static final int CAPACIDAD = 5;
	private int caudal;
	private boolean saturada;
	private boolean vacia;
	
	//CONSTRUCTORES
	public Celda(){
		this.caudal = 0;
		this.saturada = false;
		this.vacia = true;
	}

	//GETTERS
	public Celda[] getVecinas() {
		return vecinas.clone();
	}

	public static int getCapacidad() {
		return CAPACIDAD;
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
		if (this.caudal+1 <= CAPACIDAD) this.caudal++;
	}
	public void decrementarCaudal(){
		if (this.caudal-1 >= 0) this.caudal--;
	}
	
	






}
