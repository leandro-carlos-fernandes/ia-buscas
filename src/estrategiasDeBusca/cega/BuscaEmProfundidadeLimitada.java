package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Esta classe implementa uma estratégia de busca cega conhecida como "Busca em
 * Profundidade", que é característica por explorar o espaço se aprofundando no
 * ramo atual antes de fazê-lo noutra ramificação.
 * 
 * @author Leandro C. Fernandes
 *
 */
public class BuscaEmProfundidadeLimitada extends BuscaEmProfundidade {
	
	private int limite;

	/**
	 * Construtor padrão.
	 */
	public BuscaEmProfundidadeLimitada() {
		this(null,null,10);
	}
	
	/**
	 * Cria uma nova instância de Busca em Profundidade, definindo os estados
	 * inicial e objetivo para o processo, além do limite de aprofundamento.
	 * @param estadoInicial estado inicial de busca.
	 * @param estadoMeta estado que contém os objetivos da busca.
	 * @param nivelLimite nível máximo de aprofundamento da árvore.
	 */
	public BuscaEmProfundidadeLimitada(Estado<?> estadoInicial, Estado<?> estadoMeta, int nivelLimite) {
		super(estadoInicial,estadoMeta);
		super.nomeDaEstrategia = "Busca em Profundidade Limitada (até " + limite + " níveis)";
		this.limite = nivelLimite;
	}
	
	/**
	 * Retorna o nível máximo de aprofundamento definido para o processo de busca.
	 * @param limite nível máximo de aprofundamento da árvore.
	 */
	public int getLimite() {
		return limite;
	}

	/**
	 * Define o nível máximo de aprofundamento que um ramo será explorado.
	 * @param limite nível máximo de aprofundamento da árvore.
	 */
	public void setLimite(int limite) {
		this.limite = limite;
	}

	/**
	 * Implementa efetivamente a estratégia de busca, iniciando a exploração do
	 * espaço a partir do estado inicial e seguindo nível a nível no ramo atual
	 * até alcançar um estado que atenda os objetivos ou não tenha sucessor.
	 * Ao término, o caminho correspondente a solução terá sido armazenado no
	 * atributo caminho.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			if (eCorrente.getNivel() < limite)
				for (Estado<?> estado : (List<Estado<?>>) eCorrente.getSucessores())
					eAbertos.push(estado);
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
