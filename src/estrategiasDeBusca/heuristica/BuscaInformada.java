package estrategiasDeBusca.heuristica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Esta classe modela os aspectos comuns as estratégias de busca informada,
 * que explorar o espaço de estados a partir de um estado inicial e constrói a
 * árvore busca expandindo seus nodos até que se alcance um estado objetivo.
 * 
 * @author Leandro Fernandes
 *
 */
public abstract class BuscaInformada {
	
	protected String nomeDaEstrategia;	// nome da estratégia de busca utilizada
	protected Estado<?> eInicial;		// representa o estado inicial da busca
	protected Estado<?> eObjetivo;		// representa um estado do problema que contenha os objetivos ou seja, em si mesmo, a meta para a busca.
	protected List<Estado<?>> caminho;	// contém o caminho da solução desde a raiz (inicio) 
	
	/**
	 * Construtor padrão.
	 */
	public BuscaInformada() {
		this(null,null);
	}
	
	public BuscaInformada(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		this.nomeDaEstrategia = "Busca informada";
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

class OrdenarPorCusto implements Comparator<Estado<?>> {

	@Override
	public int compare(Estado<?> estado1, Estado<?> estado2) {
		return estado1.getCusto() - estado2.getCusto();
	}

}

class OrdenarPorAvaliacao implements Comparator<Estado<?>> {

	@Override
	public int compare(Estado<?> estado1, Estado<?> estado2) {
		return estado1.getAvaliacao() - estado2.getAvaliacao();
	}

}

class OrdenarPorCustoMaisAvaliacao implements Comparator<Estado<?>> {

	@Override
	public int compare(Estado<?> estado1, Estado<?> estado2) {
		int f = (estado1.getCusto() + estado1.getAvaliacao()) - (estado2.getCusto() + estado2.getAvaliacao());		
		return (f != 0) ? f : estado2.getNivel() - estado1.getNivel();
	}

}