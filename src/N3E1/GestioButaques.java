package N3E1;

import java.util.ArrayList;

public class GestioButaques {
	private ArrayList<Butaca> butaques;

	public GestioButaques() {
		this.butaques = new ArrayList<Butaca>();
	}

	public ArrayList<Butaca> getButaques() {
		return butaques;
	}
	
	
	public void afegirButaca(Butaca butaca) {
		
		try {
			if (cercarButaca(butaca) == -1) {
				this.butaques.add(butaca);
				System.out.println("Butaca afegida"); //potser eliminar
			} else {
				throw new ExcepcioButacaOcupada("Aquesta butaca ja esta ocupada.");
			}
		} catch (ExcepcioButacaOcupada e) {//PAU MIRA'T AIXO AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
			System.out.println();// COMPAREU AMB LO DE LA VENDA PORFA			GRACIES :)						PS:puto github que es cau
			//getMessage();
		}
	}
	
	
	public void eliminarButaca(Butaca butaca){
		int i = cercarButaca(butaca);
		
		try {
			if (cercarButaca(butaca) != -1) {
				this.butaques.remove(i);
				System.out.println("Butaca eliminada"); //potser eliminar
			} else {
				throw new ExcepcioButacaOcupada("Aquesta butaca ja esta lliure.");
			}
		} catch (ExcepcioButacaOcupada e) {//PAU MIRA'T AIXO AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
			System.out.println();// COMPARE-ho AMB LO DE LA VENDA PORFA			GRACIES :)						PS:puto github que es cau
			//getMessage();
		}
	}
	
	
	
	private int cercarButaca(Butaca butaca) {
		ArrayList<Butaca> array = getButaques();
		int i = 0;
		boolean seguir = true;
		while (i < array.size() && seguir) {
			if (array.get(i).getFila() == butaca.getFila() && array.get(i).getColumna() == butaca.getColumna()) {
				seguir = false;
			} else {
				i++;
			}
		}
		i = (seguir)?i:-1;
		return i;
	}
	
}
