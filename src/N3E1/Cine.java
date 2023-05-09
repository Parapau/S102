package N3E1;

import java.util.Scanner;

public class Cine {
	static Scanner entrada = new Scanner (System.in);
	private  int nFiles, nColumnes;
	private GestioButaques gestiona;
	public Cine() {
		super();
		demanarDadesInicials();
		this.gestiona = new GestioButaques();
	}

	public static Scanner getEntrada() {
		return entrada;
	}

	public int getnFiles() {
		return nFiles;
	}

	public int getnColumnes() {
		return nColumnes;
	}

	public GestioButaques getGestiona() {
		return gestiona;
	}




	public void iniciar() {
		int opcio;
		boolean seguir = true;

		opcio = menu();

		do {
			switch (opcio) {
			case 1:
				System.out.println("Molt be");
				mostrarButaques();
				break;
			case 2:
				System.out.println("Molt be");
				mostrarButaquesPersona();
				break;
			case 3:
				System.out.println("Molt be");
				reservaButaca();
				break;
			case 4:
				anularButaca();
				break;
			case 5:
				System.out.println("Molt be");
				anularButaquesPersona();
				break;
			case 0:
				System.out.println("Molt be \nFins un altre!");
				seguir = false;
				break;
			}

		}while (seguir);


	}



	public int menu() {
		int opcio;
		boolean seguir = false;
		String missatge = "Quina de les següents opcions vols pendre?\n"
				+ "1.Mostrar totes les butaques reservades\n"
				+ "2.Mostrar les butaques reservades per una persona\n"
				+ "3.Reservar una butaca\n"
				+ "4.Anul·lar la reserva d'una butaca\n"
				+ "5.Anul·lar totes les reserves d'una persona\n"
				+ "0.Sortir de l'aplicacio";
		do {
			System.out.println(missatge);
			opcio = numeros();
			missatge = "Siusplau introdueix un nombre del 0 al 5.";
		} while (opcio > 5 && opcio < 0);

		return opcio;
	}


	public void mostrarButaques() {
		try {
			for (Butaca butaca : gestiona.getButaques()) {
				System.out.println(butaca.toString());
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Encara no s'ha reservat cap butaca");
		}
	}


	public void mostrarButaquesPersona() {
		String nom = "", missatge;

		missatge = "\nEn/Na " + nom + " te les següents butaques reservades";
		System.out.println("Com es diu la persona que ha fet la reserva?");
		nom = entrada.nextLine();
		try {
			for (Butaca butaca : gestiona.getButaques()) {
				if (butaca.getSentador().equalsIgnoreCase(nom)) {
					System.out.print(missatge);
					System.out.println("	" + butaca.toString());
					missatge = "";
				}
			}	
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ningu no ha reservat cap butaca encara");
		}

		if (!missatge.equals("")) {
			System.out.println("Aquesta persona no ha reservat cap butaca de moment");
		}

	}


	public void anularButaquesPersona() {
		String nom = "";
		boolean fora = false;

		System.out.println("Com es diu la persona que ha fet la reserva?");
		nom = entrada.nextLine();
		try {
			for (Butaca butaca : gestiona.getButaques()) {
				if (butaca.getSentador().equalsIgnoreCase(nom)) {
					gestiona.eliminarButaca(butaca);
					fora = true;
				}
			}	
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ningu no ha reservat cap butaca encara");
		}

		if (!fora) {
			System.out.println("Aquesta persona no ha reservat cap butaca de moment");
		}

	}


	public void reservaButaca() {
		String nom;
		int fila, columna;

		fila = introduirFila();

		columna = introduirColumna();

		nom = introduirNom();


		Butaca butaca = new Butaca(fila, columna, nom);

		gestiona.afegirButaca(butaca);
	}


	public void anularButaca() {
		String nom;
		int fila, columna;

		fila = introduirFila();

		columna = introduirColumna();

		nom = introduirNom();

		Butaca butaca = new Butaca(fila, columna, nom);

		gestiona.eliminarButaca(butaca);
	}


	public String introduirNom() {
		String nom;

		System.out.println("Diguem el nom de la persona reservant");
		nom = entrada.nextLine();
		for (int i = 0 ; i < nom.length() ; i++) {
			if (Character.isDigit(nom.charAt(i))) {
				//throw new ExcepcioNomPersonaIncorrecte();
			}
		}
		return nom;
	}


	public int introduirFila() {
		int fila;


		System.out.println("A quina fila es troba la butaca?");
		//try {
		fila = numeros();
		//if (fila > getnFiles() || fila < 0) {
		//			throw new Exception();//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQUI no va pau, el handler ha d'anar a sobre
		//}
		//} catch (Exception e) {
		//	System.out.println("Aquesta fila puta");
		//}
		return fila;

	}


	public int introduirColumna() { //aixo tmabe es lo de que va a dalt
		int columna;
		System.out.println("A quina columna es troba la butaca?");
		columna = numeros();
		//if (columna > getnFiles() || columna < 0) {
		return columna;
	}


	public void demanarDadesInicials() {
		int files, columnes;

		System.out.println("Quantes files de butaques hi ha?");
		files = numeros();
		this.nFiles = files; 
		System.out.println("I quantes columnes?");
		columnes = numeros();
		this.nColumnes = columnes;
	}





















	public static int numeros (){
		int opcio = 0;
		boolean numeritus;
		do {
			try {
				opcio = Integer.parseInt(entrada.nextLine());
				numeritus = true;
			}
			catch (java.lang.NumberFormatException e) {
				System.err.println("Aixo no es un numero subnormal de merda dels collons, posa un numeor o et rajo les rodes del cotxe.");
				numeritus = false;
			}
		} while (!numeritus);
		return opcio;
	}
}
