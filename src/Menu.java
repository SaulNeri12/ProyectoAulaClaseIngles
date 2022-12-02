
/**
 * @author Saul Neri
 */
 
import java.util.Scanner;
 
public class Menu {
    public Aula aula;
    // debug mode  
    public boolean debug;
    
    public Menu(boolean debug) {
        this.aula = new Aula();
        // debug mode
        this.debug = debug;
    }
   
    public void desplegarMenu() {
        Scanner in = new Scanner(System.in);
        
        int opcion;
   
		if (debug) {
		  Butaca butaca = new Butaca("Saul Neri", "Prin", "M", 18);
		  this.aula.setButaca(butaca);
		  butaca = new Butaca("Arely Cruz", "Expr", "F", 18);
		  this.aula.setButaca(butaca);
		  butaca = new Butaca("Juan Perez", "Intr", "M", 20);
		  this.aula.setButaca(butaca);
		}

        boolean loop = true;
        
        while (loop) {
			// debug
			if (debug) System.out.println("[DEBUG]\n");

			System.out.println("\n-----[CLASE DE INGLES]-----\n");

			this.imprimirOpciones();
            
            System.out.println("Teclee la opcion...");
            System.out.print("> ");
            
            try {
                opcion = in.nextInt();
                
                switch (opcion) {
                    case 1:
                        this.registrarAlumno();
                        break;
                    case 2: 
                        this.eliminarAlumno();
                        break;
					case 3:
						this.mostrarInformacionAlumno();
						break;
                    case 4:
                        this.editarAlumno();
                        break;
                    case 5:
                        this.aula.mostrarOcupados();
                        break;
					case 6:
						this.generarListaAlumnos();
                    case 7:
                        loop = false;
                        break;
                    default: 
                        System.out.println("[!] Selecciona una opcion valida...");
                        break;
                }
            } catch (Exception e) {
                if (this.debug) {
                    System.err.println(e);
                } else {
                    System.out.println("[!] Error de entrada, intentalo de nuevo...");
                }
            }
        }
    }

	public void mostrarInformacionAlumno() {
	  Scanner in = new Scanner(System.in);
	  Butaca btca = null;
	  int num = 0;

	  boolean done = false, salir = false;

	  // no se deja de preguntar por numero de butaca hasta dar un valor existente
	  while (!done) {
		this.aula.mostrarOcupados();

		System.out.printf("\nIngresa el numero de butaca [numero > 24 -> salir]: ");
		num = in.nextInt();
		num = num - 1; // para trabajar con arreglos...

		if (num >= 0 && num < 24) {
		  if (this.aula.getButaca(num) != null) {
			done = true;
		  } else {
			System.out.println("[!] Alumno no encontrado...");
		  }
		} 
		else if (num > 24) { 
		  salir = true;
		  done = true;
		} 
		else {
			System.out.println("[!] La butaca no existe");
		}
	  }

	  if (!salir) {
		  btca = this.aula.getButaca(num);

		  System.out.println("\n-----------[INFORMACION DEL ALUMNO]----------");
		  // Muestra el nombre
		  System.out.printf("\nNOMBRE: %s\n", btca.getNombre());
		  
		  // Muestra el nivel
		  System.out.printf("NIVEL: ");
		  switch (btca.getNivel().toLowerCase()) {
			case "prin":
			  System.out.printf("Principiante (%s)\n", btca.getNivel());
			  break;
			case "intr": 
			  System.out.printf("Intermedio (%s)\n", btca.getNivel());
			  break;
			case "Avnz":
			  System.out.printf("Avanzado (%s)\n", btca.getNivel());
			  break;
			case "Expr":
			  System.out.printf("Experto (%s)\n", btca.getNivel());
			  break;
			default:
			  System.out.printf("DESCONOCIDO\n");
			  break;
		  }

		  // Muestra sexo
		  if (btca.getSexo().toLowerCase().equals("m")) {
			System.out.printf("SEXO: Hombre (M)\n");
		  }
		  else if (btca.getSexo().toLowerCase().equals("f")) {
			System.out.printf("SEXO: Mujer (F)\n");
		  }

		  // Muestra edad
		  System.out.printf("EDAD: %d\n", btca.getEdad());
		  System.out.println("--------------------------------------------\n");
	  } else {
		System.out.println("[!] Operacion cancelada...\n");
	  }
	}


	/**
	 * @description: Muestra la informacion de los usuarios en forma de lista...
	 */
	public void generarListaAlumnos() {
	  Butaca btca;

	  System.out.println("---------[LISTA DE ALUMNOS]----------\n");
	  for (int i=0; i < this.aula.butacas.length; i++) {
		if (this.aula.getButaca(i) != null) {
		  btca = this.aula.getButaca(i);
		  
		  // Muestra el nombre
		  System.out.printf("%d. NOMBRE: %s\t|", i+1, btca.getNombre());
		  
		  // Muestra el nivel
		  System.out.printf("\tNIVEL: ");
		  switch (btca.getNivel().toLowerCase()) {
			case "prin":
			  System.out.printf("Principiante (%s)\t|", btca.getNivel());
			  break;
			case "intr": 
			  System.out.printf("Intermedio (%s)\t|", btca.getNivel());
			  break;
			case "Avnz":
			  System.out.printf("Avanzado (%s)\t|", btca.getNivel());
			  break;
			case "Expr":
			  System.out.printf("Experto (%s)\t|", btca.getNivel());
			  break;
			default:
			  System.out.printf("DESCONOCIDO\t\t|");
			  break;
		  }

		  // Muestra sexo
		  if (btca.getSexo().toLowerCase().equals("m")) {
			System.out.printf("\tSEXO: Hombre (M)\t|");
		  }
		  else if (btca.getSexo().toLowerCase().equals("f")) {
			System.out.printf("\tSEXO: Mujer (F)\t|");
		  }

		  // Muestra edad
		  System.out.printf("\t\tEDAD: %d\n", btca.getEdad());
		}
	  }

	  System.out.println();
	}


	/**
	 * @description: Despliega un menu que permite seleccionar un alumno y modificar sus datos...
	 */
    public void editarAlumno() {       
        Scanner in = new Scanner(System.in);
        
        String nombre, nivel, sexo, confirmacion;
        int edad, num_btca = -1;
        
		// inicializa el objeto
		Butaca butaca = new Butaca("", "", "", 0);

		boolean done = false, salir = false;

        System.out.println("--------[ MODIFICAR ALUMNO ]---------\n");
		
		this.aula.mostrarOcupados();

		// se selecciona el alumno a partir de su numero de butaca
		while (!done) {
		  num_btca = -1;

		  while (num_btca < 0) {
			System.out.printf("Numero de butaca [ numero > 24 -> salir]: ");
			num_btca = in.nextInt();
			num_btca -= 1; // le restamos uno para trabajar con los arreglos
			// muestra mensaje si el numero de butaca es erroneo
			if (num_btca > 23) {
			  salir = true; // sale del proceso "Modificar Alumno"
			  done = true;
			}
		  }

		  // si la butaca esta desocupada...
		  if (num_btca >= 0 && num_btca < 24) {
			if (this.aula.getButaca(num_btca) != null) {
			  System.out.printf("MOMBRE DEL ALUMNO: %s\n", this.aula.getButaca(num_btca).getNombre());
			  // mensaje de confirmacion...
			  System.out.printf("\nDesea continuar con este alumno? [S/N]: ");
			  in.nextLine(); // limpia stdin
			  confirmacion = in.nextLine();
			  if (confirmacion.toUpperCase().equals("S") || confirmacion.toUpperCase().equals("SI")) {
				done = true;
			  }
			} else {
			  System.out.println("[!] La butaca no existe o no esta ocupada...");
			}
		  }
		}

		if (!salir) {
		  // si la butaca no esta vacia
		  if (butaca != null) {
            boolean loop = true;
			String opcion;

            while (loop) {
                System.out.println("\n1. Modificar Nombre");
                System.out.println("2. Modificar Nivel");
                System.out.println("3. Modificar Sexo");
                System.out.println("4. Modificar Edad");
                System.out.println("5. Salir\n");
				      
                try {
                    opcion = in.nextLine();

                    switch (opcion) {
                        case "1":
                            System.out.print("Nombre nuevo: ");
                            nombre = in.nextLine();
                            // muetsra nombre anterior y el nuevo 
                            System.out.printf("[*] [NOMBRE MODIFICADO] Nombre anterior: %s", butaca.getNombre());
                            this.aula.butacas[num_btca].setNombre(nombre);
                            System.out.printf(" -> Nombre nuevo: %s\n\n", this.aula.getButaca(num_btca).getNombre());
                            break;
                        case "2":
							// muestra los niveles disponibles
							System.out.println("-----[niveles disponibles]-----\n");
							System.out.println("prin -> principal\t$200");
							System.out.println("intr -> intermedios\t$400");
							System.out.println("avnz -> avanzados\t$600");
							System.out.println("expr -> expertos\t$800\n");
                            System.out.print("Nivel: ");
                            nivel = in.nextLine();
                            this.aula.butacas[num_btca].setNivel(nivel);
                            System.out.println("[*] NIVEL DEL ALUMNO MODIFICADO\n");
                            break;
                        case "3":
                            System.out.printf("Sexo [(M) Masculino, (F) Femenino]: ");
                            sexo = in.nextLine();
                            this.aula.butacas[num_btca].setSexo(sexo);
                            System.out.println("[*] SEXO DEL ALUMNO MODIFICADO\n");
                            break;
                        case "4":
                            System.out.printf("Edad: ");
                            edad = in.nextInt();
                            this.aula.butacas[num_btca].setEdad(edad);
                            System.out.println("[*] EDAD DEL ALUMNO MODIFICADA\n");
                            in.nextLine();
							break;
                        case "5":
                            System.out.println("[!] Operacion cancelada...");
                            loop = false;
                            break;
						default:
							System.out.println("opcion incorreta, intenta de nuevo....");
							break;
                    }
                } catch (Exception e) {
                    if (this.debug) {
                        System.out.println(e);
                    } else {
                        System.out.println("[!] Error de entrada, intentalo otra vez...");
                    }
                }
            }
		  }
		  else if (butaca == null) {
			System.out.println("[!] Alumno no encontrado...");
		  }
		} else {
		  System.out.println("[!] Operacion cancelada...");
		}
    }
    

	/**
	 * @description: Despliega un mini menu que permite eliminar un alumno a partir de su numero de butaca
	 */
    public void eliminarAlumno() {  
        Scanner in = new Scanner(System.in);

		this.aula.mostrarOcupados();
        
        Butaca butaca_ocupada;
        String opcion;
        int pos;
        
        try {
            System.out.print("Ingresa el numero de butaca a eliminar: ");
            pos = in.nextInt();
            
            butaca_ocupada = this.aula.getButaca(pos - 1);
            
            if (butaca_ocupada != null) {
                System.out.println("------------------[CONFIRMACION]-------------------");
                System.out.printf("Nombre: %s\n", butaca_ocupada.getNombre());
                System.out.printf("Nivel: %s\n", butaca_ocupada.getNivel());
                System.out.printf("Mensualidad: $%d\n", this.getMensualidadPorNivel(butaca_ocupada.getNivel()));
                System.out.printf("Edad: %d\n", butaca_ocupada.getEdad());
                System.out.printf("Sexo: %s\n", butaca_ocupada.getSexo());
                System.out.printf("Butaca asignada: %d\n", pos);
                // muestra mensaje de confirmacion...
                in.nextLine();
                System.out.println("\nConfirma que desea liberar la butaca? (S/N): ");
                opcion = in.nextLine();
                
                if (opcion.toUpperCase().equals("S") || opcion.toUpperCase().equals("SI")) {
                    this.aula.eliminarButaca(pos - 1);
                    System.out.println("[*] Butaca eliminada con exito!\n");
                } else {
                    System.out.println("[!] Operacion cancelada...\n");
                }
            }            
        } catch (Exception e) {
            if (this.debug) {
                System.err.println(e);
            } else {
                System.out.println("[x] Ha ocurrido un error, intentalo de nuevo...");
            }
        }
    }
    
    /**
      * @description: Asigna una butaca a un alumno
      */
    public void registrarAlumno() {
        String nombre, nivel, sexo, opcion;
        int mensualidad, edad, btca_disponible;
        
        Scanner in = new Scanner(System.in);
        
        try {
            System.out.println("-------[Registrar Alumno]-------\n");
            System.out.print("Nombre del Alumno: ");
            nombre = in.nextLine();
            // muestra los niveles disponibles
            System.out.println("-----[niveles disponibles]-----\n");
            System.out.println("prin -> principal\t$200");
            System.out.println("intr -> intermedios\t$400");
            System.out.println("avnz -> avanzados\t$600");
            System.out.println("expr -> expertos\t$800\n");
            System.out.print("Nivel: ");
            nivel = in.nextLine();
            
            System.out.print("Edad: ");
            edad = in.nextInt();
            
            in.nextLine(); // limpia el buffer (stdin)
            
            System.out.print("Sexo [(M) Masculino, (F) Femenino]: ");
            sexo = in.nextLine();
             
            btca_disponible = this.aula.getSiguienteDisponible();
            
            if (btca_disponible >= 0) {
                System.out.println("-------------------[CONFIRMACION]------------------");
                System.out.printf("Nombre: %s\n", nombre);
                System.out.printf("Nivel: %s\n", nivel);
                System.out.printf("Edad: %d\n", edad);
                System.out.printf("Sexo: %s\n", sexo);
                System.out.printf("Butaca asignada: %d\n", btca_disponible + 1);
                
				// muestra mensaje de confirmacion...
                System.out.println("\n\tConfirmar el registro? (S/N): ");
                opcion = in.nextLine();
                
                if (opcion.toUpperCase().equals("S") || opcion.toUpperCase().equals("SI")) {
                    Butaca butaca = new Butaca(nombre, nivel, sexo, edad);
                    this.aula.setButaca(butaca);
                    System.out.println("[*] Alumno registrado con exito!\n");
                } else {
                    System.out.println("[!] Operacion cancelada...\n");
                }
            } else {
                System.out.println("[x] No se pudo encontrar una butaca para el alumno...");
            }
        } catch (Exception e) {
            if (this.debug) {
                System.err.println(e);
            } else {
                System.out.println("[x] Ha ocurrido un error, intentalo de nuevo...");
            }
        }
    }
    
    public void imprimirOpciones() {
        System.out.println("1. Registrar alumno");
        System.out.println("2. Eliminar alumno");
        System.out.println("3. Mostrar informacion del alumno");
        System.out.println("4. Editar alumno");
        System.out.println("5. Mostrar mapa de aula");
        System.out.println("6. Lista de alumnos");
        System.out.println("7. Salir\n");
    }
    
    /**
      * @description: Devuelve el valor de la mensualidad del curso dependiendo el nivel dado.
      * @param String nivel Nivel del curso
      * @return int mensualidad
      */
    public int getMensualidadPorNivel(String nivel) {
        if (nivel.equals("Prin"))
            return 200;
        else if (nivel.equals("Intr"))
            return 400;
        else if (nivel.equals("Avnz"))
            return 600;
        else if (nivel.equals("Expr"))
            return 800;
            
        return -1;
    }
}
