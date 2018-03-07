import espacoDeEstados.Estado;
import espacoDeEstados.Puzzle8;
import estrategiasDeBusca.BuscaCega;
import estrategiasDeBusca.BuscaEmLargura;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		char[] cfgIni = {' ','2','3','1','4','6','7','5','8'};
		Estado puzzleInicial = new Puzzle8(cfgIni);

		char[] cfgMeta = {'1','2','3','4','5','6','7','8',' '};
		Estado puzzleFinal = new Puzzle8(cfgMeta);
		
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