package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import espacoDeEstados.Estado;

/**
 * Esta classe implementa uma estratégia de busca cega conhecida como "Busca em
 * Largura", característica por explorar o espaço de estados nível-a-nível sempre
 * visitando primeiro os nodos não-expandidos da árvore de busca que se encontram
 * mais próximos da raiz.
 * 
 * @author Leandro C. Fernandes
 *
 */
public class BuscaEmLargura extends BuscaCega {
	
	private Queue<Estado<?>> eAbertos;

	/**
	 * Construtor padrão.
	 */
	public BuscaEmLargura() {
		this(null,null);
	}
	
	/**
	 * Cria uma nova instância de Busca em Largura e define os estados inicial
	 * e objetivo para o processo.
	 * @param estadoInicial estado inicial de busca
	 * @param estadoMeta estado que contém os objetivos da busca
	 */
	public BuscaEmLargura(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		super(estadoInicial,estadoMeta);
		nomeDaEstrategia = "Busca em Largura";
		eAbertos = new LinkedList<Estado<?>>();
	}
	
	/**
	 * Implementa efetivamente a estratégia de busca, iniciando a exploração do
	 * espaço a partir do estado inicial e seguindo nível a nível a procura de
	 * um estado que atenda aos objetivos. Ao término, o caminho correspondente
	 * a solução encontra-se armazenado no atributo caminho.  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			for (Estado<?> estado : (List<Estado<?>>) eCorrente.getSucessores())
				eAbertos.add(estado);
			eCorrente = eAbertos.poll();
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
