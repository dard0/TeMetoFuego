package tuberias.estructura;

import java.util.Random;

public enum Direccion {
	ARRIBA, ABAJO, DERECHA, IZQUIERDA;
	
	public Direccion opuesta(Direccion direccion){
		
		switch (direccion) {
			case ARRIBA: return ABAJO;
			case ABAJO: return ARRIBA;
			case DERECHA: return IZQUIERDA;
			case IZQUIERDA: return DERECHA;
			default: return null;
		}
		
	}
	
	public Direccion aleatoria(){
		
			Direccion[] direcciones = Direccion.values();
			Random generador = new Random();
			return direcciones[generador.nextInt(direcciones.length)];
		
		}
		
	}

