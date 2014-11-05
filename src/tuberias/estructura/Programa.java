package tuberias.estructura;

public class Programa {

	public static void main(String[] args) {

		// Rango del campo
		int anchura = 5;
		int altura = 5;
		//PENEOooooootdfghjkgfhjk
		//Creamos la posicion inicial (0,0)aa
		Posicion posicionInicial = new Posicion();
		
		//Creamos el campo de juego y la posicion inicial
		
		Tuberia campo = new Tuberia(anchura, altura, posicionInicial);
		System.out.println(campo.obtenerCelda(posicionInicial).getPosicion().getX()+","+campo.obtenerCelda(posicionInicial).getPosicion().getY());
		
		//Insertamos una celda contigua a la inicial
		
		Celda celda1 = new Celda();
		Posicion posicionCelda1 = new Posicion(0,1);
		celda1.setPosicion(posicionCelda1);
		campo.establecerCelda(celda1, celda1.getPosicion());
		System.out.println(campo.obtenerCelda(celda1.getPosicion()).getPosicion().getX()+","+campo.obtenerCelda(celda1.getPosicion()).getPosicion().getY());

		
		//Comprobamos si la celda se inserta bien
		System.out.println(campo.establecerCelda(celda1, celda1.getPosicion()));
		
		
		
		
		
		
	}

}
