package estrategiasDeBusca.heuristica;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import espacoDeEstados.Estado;

public class AStar extends BuscaInformada {

	private Stack<Estado<?>> eAbertos;

	/**
	 * Construtor padrão.
	 */
	public AStar() {
		this(null,null);
	}
	
	/**
	 * Cria uma nova instância da Busca Ótima (A*) e define os estados inicial
	 * e objetivo para o processo.
	 * @param estadoInicial estado inicial de busca
	 * @param estadoMeta estado que contém os objetivos da busca
	 */
	public AStar(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		super(estadoInicial,estadoMeta);
		nomeDaEstrategia = "Busca Ótima - A* (A-Star)";
		eAbertos = new Stack<Estado<?>>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			List<?> eSucessores = eCorrente.getSucessores();			
			for (Estado<?> estado : (List<Estado<?>>) eSucessores)
				eAbertos.push(estado);
			Collections.sort((List<Estado<?>>) eAbertos, new OrdenarPorCustoMaisAvaliacao());
			Collections.reverse((List<Estado<?>>) eAbertos);
			eCorrente = eAbertos.pop();
		}
		// Se o laço foi encerrado por um estado válido ...
		if (eCorrente != null) {
			// então construímos o caminho da solução (da folha até a raiz)
			caminho.add(eCorrente);
			while (eCorrente.getAncestral() != null) {
				eCorrente = eCorrente.getAncestral();
				caminho.add(eCorrente);
			}
			Collections.reverse(caminho);
		}		
	}
}
