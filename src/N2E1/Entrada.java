package N2E1;

import java.util.Scanner;

public class Entrada {
	private static Scanner entrada = new Scanner(System.in);


	//InputMismatchException

	public static byte llegirByte (String missatge) {
		boolean seguir = false;
		byte num = 0;

		System.out.println(missatge);

		do {
			try {
				num = entrada.nextByte();
			} catch (java.util.InputMismatchException e) {
				System.err.println("Error de format");
				seguir = true;
			}
		} while (seguir);
		return num;
	}

	public static int llegirInt (String missatge) {
		boolean seguir = false;
		int num = 0;

		System.out.println(missatge);

		do {
			try {
				num = entrada.nextByte();
			} catch (java.util.InputMismatchException e) {
				System.err.println("Error de format");
				seguir = true;
			}
		} while (seguir);
		return num;
	}

	public static float llegirFloat (String missatge) {
		boolean seguir = false;
		float num = 0;

		System.out.println(missatge);

		do {
			try {
				num = entrada.nextFloat();
			} catch (java.util.InputMismatchException e) {
				System.err.println("Error de format");
				seguir = true;
			}
		} while (seguir);
		return num;
	}

	public static double llegirDouble (String missatge) {
		boolean seguir = false;
		double num = 0;

		System.out.println(missatge);

		do {
			try {
				num = entrada.nextDouble();
			} catch (java.util.InputMismatchException e) {
				System.err.println("Error de format");
				seguir = true;
			}
		} while (seguir);
		return num;
	}




	//Exception



	public static char llegirChar(String missatge) {
		boolean seguir = false;
		String car;
		char caracter = ' ';

		System.out.println(missatge);

		do {
			try {
				car = entrada.next();
				if (car.length()==1) {
					caracter = car.charAt(0);
				} else {
					throw new Exception();
				}

			} catch (Exception e) {
				System.err.println("Error de format");
				seguir = true;
			} 
		} while (seguir);

		return caracter;
	}




	public static String llegirString(String missatge) {
		String control = "A", str = "";
		boolean seguir = false;

		System.out.println("missatge");

		do {
			try {
				str = entrada.nextLine();
				if (str.getClass() != "A".getClass()) {
					throw new Exception();
				}
			} catch (Exception e) {
				System.err.println("Error de format");
				seguir = true;
			}
		} while (seguir);


		return "puta";

	}


	public static boolean llegirSiNo(String missatge) {
		boolean si = true, seguir = false;
		String no;

		System.out.println(missatge);
		try {
			do {
				no = entrada.next();
				if (no.equalsIgnoreCase("n")) {
					si = false;
				} else if (!no.equalsIgnoreCase("s")) {
					throw new Exception();
				}
			} while (seguir);
		} catch (Exception e) {
			System.err.println("Error de format");
			seguir = true;
		}


		return si;
	}











}





































