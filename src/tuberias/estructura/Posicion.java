package tuberias.estructura;

public class Posicion {
	private int x; //get
	private int y; //get

	//CONSTRUCTORES
	public Posicion(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Posicion(){
		this(0,0);
	}
	public Posicion(Posicion otro){
		this(otro.x,otro.y);
	}
	
	//GETTERS
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	//FUNCIONALIDAD
	/**
	 * Método que devuelve la posición adyacente a la posición receptora
	 * de la llamada dada una dirección pasada como parámetro.
	 * @param direccion Dirección de la que queremos saber la posición adyacente.
	 * @return Devuelve la posición adyacente
	 */
	public Posicion adyacente(Direccion direccion){
		int newX=this.x;
		int newY=this.y;
		switch(direccion){
			case ARRIBA: newY++; break;
			case ABAJO: newY--; break;
			case DERECHA: newX++; break;
			case IZQUIERDA: newX--; break;
		}
		return new Posicion(newX, newY);
	}
	
	/**
	 * Método que indica si una posición es adyacente a otra dada una 
	 * dirección.
	 * @param otro Posición que queremos saber si es adyacente.
	 * @param dir Dirección en la que queremos saber si es adyacente.
	 * @return Devuelve true si es adyacente, false en caso contrario.
	 */
	public boolean isAdyacente(Posicion otra, Direccion dir){
		Posicion posAdyacente = this.adyacente(dir);
		return (otra.x == posAdyacente.x)&&(otra.y == posAdyacente.y);
	}
	
	/**
	 * Método que calcula la distancia entre dos posiciones, la receptora
	 * de la llamada y otra posición pasada como parámetro.
	 * @param posicion Posición pasada como parámetro.
	 * @return Devuelve la distancia entre las dos posiciones.
	 */
	public double distancia(Posicion posicion){
		int difX = this.x - posicion.x;
		int difY = this.y - posicion.y;
		return Math.sqrt(Math.pow(difX, 2)+Math.pow(difY,2));
	}
	
	
}
