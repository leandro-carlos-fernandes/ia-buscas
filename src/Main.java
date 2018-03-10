import espacoDeEstados.Estado;
import espacoDeEstados.Puzzle8;
import estrategiasDeBusca.cega.BuscaCega;
import estrategiasDeBusca.cega.BuscaEmLargura;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		//char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
		char[] cfgIni = {'2','4','3','7','1','6','5',' ','8'};
		//char[] cfgIni = {'2','3',' ','7','4','1','5','8','6'};
		//char[] cfgIni = {'7','2','3','4',' ','1','5','8','6'}; // OutOfMemory

		Estado puzzleInicial = new Puzzle8(cfgIni);
		Estado puzzleFinal = new Puzzle8(Puzzle8.TABULEIRO_ORGANIZADO);
		
		BuscaCega busca = new BuscaEmLargura();
		busca.setInicio(puzzleInicial);
		busca.setObjetivo(puzzleFinal);
		busca.buscar();
		for(Estado e : busca.getCaminhoSolucao()) {
			System.out.println(e);
		}

		System.exit(0);
	}

}
