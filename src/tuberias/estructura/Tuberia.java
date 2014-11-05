package tuberias.estructura;

public class Tuberia {

	private int anchura;
	private int altura;
	private Celda[][] matriz;
	private Celda celdaInicial;
	
	public Tuberia(int anchura, int altura, Posicion inicial){
		
		this.anchura = anchura;
		this.altura = altura;
		this.matriz = new Celda[anchura][altura];
		this.celdaInicial = new Celda();
		celdaInicial.setPosicion(inicial);
		matriz[inicial.getX()][inicial.getY()] = celdaInicial;
		
	}
	
	public boolean establecerCelda(Celda celda, Posicion posicion){
		
		// Caso A
		if ((posicion.getX()<0)||(posicion.getY()<0)||(posicion.getX()>=anchura)||(posicion.getY()>=altura)) return false;
		if (matriz[posicion.getX()][posicion.getY()] == null){
			
			////// Comprobar cuantas vecinas tiene
			Direccion[] direcciones = Direccion.values();
			int contador = 0;
			for (int i = 0; i < direcciones.length; i++){
				if (obtenerVecina(posicion, direcciones[i]) != null){
					contador++;
				}
			}
			///// Si tiene solo una se le asigna la posicion
			///// Se resetea su vecindad
			///// Se le asigna su nueva vecindad
			///// Se inserta en la matriz y se devuelve el true
			if (contador == 1){
				celda.setPosicion(posicion);
				celda.resetearVecindad();
				for (int i = 0; i < direcciones.length; i++){
					if (obtenerVecina(posicion, direcciones[i]) != null){
						celda.establecerVecina(celda, direcciones[i]);
						}
					}
				matriz[posicion.getX()][posicion.getY()] = celda;
				return true;
			}else {
				return false;
			}
			// CASO B
		}else {
			Direccion[] direcciones = Direccion.values();
			celda.setPosicion(posicion);
			celda.resetearVecindad();
			for (int i = 0; i < direcciones.length; i++){
				if (obtenerVecina(posicion, direcciones[i]) != null){
					celda.establecerVecina(celda, direcciones[i]);
					}
				}
			matriz[posicion.getX()][posicion.getY()] = celda;
			return true;
			
		}
	}
	
	//TODO Revisar aliasing - Porsiaca
	public Celda obtenerVecina(Posicion posicion, Direccion direccion){
		if ((posicion.adyacente(direccion).getX()<0)||(posicion.adyacente(direccion).getY()<0)||(posicion.adyacente(direccion).getX()>=anchura)||(posicion.adyacente(direccion).getY()>=altura)) return null;
		return matriz[posicion.adyacente(direccion).getX()][posicion.adyacente(direccion).getY()];
		
	}
	
	public boolean consultarVecina(Posicion posicion, Direccion direccion){
		if (obtenerVecina(posicion, direccion) == null) return false;
		else return true;
	}
	
	public Celda obtenerCelda(Posicion posicion){
		if ((posicion.getX()<0)||(posicion.getY()<0)||(posicion.getX()>=anchura)||(posicion.getY()>=altura)) return null;
		return matriz[posicion.getX()][posicion.getY()];
	}
	
	public void contruirTubo(Posicion posicion, Direccion direccion, int longitud){
		
		boolean fallo = true;
		int ejeXCalculado = posicion.getX();
		int ejeYCalculado = posicion.getY();
		switch(direccion){
			case ARRIBA: ejeYCalculado = ejeYCalculado + longitud ; break;
			case ABAJO: ejeYCalculado = ejeYCalculado - longitud ; break;
			case DERECHA: ejeXCalculado = ejeXCalculado + longitud ; break;
			case IZQUIERDA: ejeXCalculado = ejeXCalculado - longitud ; break;
		}
		
		if ((ejeXCalculado<=anchura)&&(ejeYCalculado<=altura)&&(ejeXCalculado>=0)&&(ejeYCalculado>=0)&&(longitud>0)){
			Celda nuevaCelda = new Celda();
			nuevaCelda.setPosicion(posicion);
			establecerCelda(nuevaCelda, nuevaCelda.getPosicion());
			
			for (int i = 1; i < longitud; i++) {
				
				Celda celdaAdyacente = new Celda();
				int ejeX = posicion.getX();
				int ejeY = posicion.getY();
				switch(direccion){
					case ARRIBA: ejeY = ejeY + i ; break;
					case ABAJO: ejeY = ejeY - i ; break;
					case DERECHA: ejeX = ejeX + i ; break;
					case IZQUIERDA: ejeX = ejeX - i ; break;
				}
				
				Posicion nuevaPosicion = new Posicion(ejeX, ejeY);
				celdaAdyacente.setPosicion(nuevaPosicion);
				establecerCelda(celdaAdyacente, celdaAdyacente.getPosicion());
				fallo = false;
			}System.out.println("Tubo creado correctamente");
		}if (fallo)System.out.println("Error en la creacion del tubo, revise los parametros insertados");
	}
}
