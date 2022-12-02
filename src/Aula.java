
/**
 *
 * @author Saul Neri
 */
public class Aula {
    public Butaca butacas[];
    
    public Aula() {
        this.butacas = new Butaca[24];
    }
      
    public Butaca getButaca(int pos) {
        return this.butacas[pos];
    }
    
    public int getNumeroButaca(String nombre) {
	  for (int i=0; i < this.butacas.length; i++) {
		if (this.getButaca(i) != null) {
		  if (this.getButaca(i).getNombre().equals(nombre)) {
			return i;
		  }
		}
	  }
      
	  return -1;
    }
    
    public Butaca getButaca(String nombre) {
	  for (int i=0; i < this.butacas.length; i++) {
		if (this.getButaca(i) != null) {
		  System.out.println("## Aula.getButaca ");
		  if (this.getButaca(i).getNombre().equals(nombre)) {
			return this.getButaca(i);
		  }
		}
	  }
      
	  return null;
    }
    
    public void eliminarButaca(int pos) {
        this.butacas[pos] = null;
    }
    
    public void setButaca(Butaca btca) {
        int pos = 0;
        
        for (int i=0; i < this.butacas.length; i++) {
            if (this.getButaca(i) == null) {
                //System.out.printf("## Butaca dada: %s\n", i);
                pos = i;
                break;
            }
        }
        
        this.butacas[pos] = btca;
    }
    
    public int getSiguienteDisponible() {
        for (int pos=0; pos < this.butacas.length; pos++) {
            if (this.butacas[pos] == null) {
                return pos;
            }
        }
        
        return -1;
    }
	
    public void mostrarOcupados() {
        
        for (int i=0; i < 8; i++) {
            // iteradores usados para mostrar las butacas en 3 hileras...
            int hil1 = 7 - i, hil2 = 15 - i, hil3 = 23 - i;
            
            // evalua si los lugares estan ocupados, en caso de que lo esten, se muestra el numero de butaca junto a una X
            if (this.butacas[hil1] == null) {
                System.out.printf("%d\t\t|\t", hil1 + 1);
            } else {
                System.out.printf("%dX\t\t|\t", hil1 + 1);
            }
            
            if (this.butacas[hil2] == null) {
                System.out.printf("%d\t\t|\t", hil2 + 1);
            } else {
                System.out.printf("%dX\t\t|\t", hil2 + 1);
            }
            
            if (this.butacas[hil3] == null) { 
                System.out.printf("%d\t\t|\t", hil3 + 1);
            } else {
                System.out.printf("%dX\t\t|\t", hil3 + 1);
            }
            
            System.out.println();
        }
        
        
        System.out.println();
    }
}
