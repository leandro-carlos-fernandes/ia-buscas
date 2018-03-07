package estrategiasDeBusca.cega;

import java.util.ArrayList;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Esta classe modela os aspectos fundamentais de uma estratégia de busca cega,
 * sendo responsável por explorar o espaço de estados a partir de um estado
 * inicial e construir uma árvore busca através da expansão de seus nodos. A
 * forma como a exploração do espaço acontece é peculiar a cada tipo de busca,
 * assim busca é uma especialização desta classe e deve implementar sua estratégia.
 * 
 * @author Leandro Fernandes
 *
 */
public abstract class BuscaCega {
	
	protected String nomeDaEstrategia;	// nome da estratégia de busca utilizada
	protected Estado<?> eInicial;		// representa o estado inicial da busca
	protected Estado<?> eObjetivo;		// representa um estado do problema que contenha os objetivos ou seja, em si mesmo, a meta para a busca.
	protected List<Estado<?>> caminho; // contém o caminho da solução desde a raiz (inicio) 
	
	/**
	 * Construtor padrão.
	 */
	public BuscaCega() {
		this(null,null);
	}
	
	public BuscaCega(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		this.nomeDaEstrategia = "Busca cega";
		eInicial = estadoInicial;
		eObjetivo = estadoMeta;
		caminho = new ArrayList<Estado<?>>();
	}

	/**
	 * Recupera o nome da estratégia de busca.
	 * @return nome da estratégia de busca
	 */
	public String getNomeDaEstrategia() {
		return nomeDaEstrategia;
	}
	
	/**
	 * Define o estado inicial da busca, isto é, o ponto de partida do processo
	 * @param estadoInicial um dos estados possíveis do problema
	 */
	public void setInicio(Estado<?> estadoInicial) {
		this.eInicial = estadoInicial;
	}
	
	/**
	 * Define o estado objetivo para o processo de busca, sendo por dado por um
	 * estado que apresente os objetivos desejados ou que seja, em si mesmo, um
	 * estado meta. 
	 * @param estadoMeta um estado possível do problema que atende os objetivos
	 */
	public void setObjetivo(Estado<?> estadoMeta) {
		this.eObjetivo = estadoMeta;
	}
	
	/**
	 * Recupera o estado considerado como meta para a busca, aquele que contém
	 * ou atende os objetivos estabelecidos para o processo de busca.
	 * @return um estado solução para o problema apresentado.
	 */
	public Estado<?> getObjetivo() {
		return eObjetivo;
	}
	
	/**
	 * Método que realiza a exploração do espaço de busca, tomando como partida
	 * o estado inicial e seguindo, estado após estado, na construção do caminho
	 * que leva a um estado solução (objetivo).
	 */
	public abstract void buscar();
	
	/**
	 * Recupera o caminho correspondente a solução encontrada pela busca.
	 * @return
	 */
	public List<Estado<?>> getCaminhoSolucao() {
		return caminho;
	}
	
}