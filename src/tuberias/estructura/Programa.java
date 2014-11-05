package tuberias.estructura;

public class Programa {

	public static void main(String[] args) {

		// Rango del campo
		int anchura = 3;
		int altura = 3;
		
		//Creamos la posicion inicial (0,0)
		Posicion posicionInicial = new Posicion(1,1);
		
		//Creamos el campo de juego y la posicion inicial
		
		Tuberia campo = new Tuberia(anchura, altura, posicionInicial);
		System.out.println(campo.obtenerCelda(posicionInicial).getPosicion().getX()+","+campo.obtenerCelda(posicionInicial).getPosicion().getY());
		
		//Insertamos una celda contigua a la inicial
		
		Celda celda1 = new Celda();
		Posicion posicionCelda1 = new Posicion(0,1);
		
		//Comprobamos si la celda se inserta bien
		System.out.println(campo.establecerCelda(celda1, posicionCelda1));
		
		//Vamos a insertar una celda enmedio del campo sin que tenga vecinas
		Celda celda2 = new Celda();
		Posicion posicionCelda2 = new Posicion(2,2);
		System.out.println(campo.establecerCelda(celda2, posicionCelda2));
		
		//Comprobamos insertar una 2º celda adyacente a celda1
		Celda celda3 = new Celda();
		Posicion posicionCelda3 = new Posicion(0,2);
		System.out.println(campo.establecerCelda(celda3, posicionCelda3));
		
		//Forzamos el fallo
		Celda celda4 = new Celda();
		Posicion posicionCelda4 = new Posicion(0,3);
		System.out.println(campo.establecerCelda(celda4, posicionCelda4));
		
		//Insertamos en una celda ya ocupada
		Celda celda5 = new Celda();
		Posicion posicionCelda5 = new Posicion(0,0);
		System.out.println(campo.establecerCelda(celda5, posicionCelda5));
		
		//Construimos un tubo dentro de los margenes aceptados
		Posicion posicionInicialTubo = new Posicion(1,0);
		Direccion direccion = Direccion.ARRIBA;
		int cantidadCeldas = 3;
		campo.contruirTubo(posicionInicialTubo, direccion, cantidadCeldas);
		
	}

}
