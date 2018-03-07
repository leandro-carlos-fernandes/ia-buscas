package espacoDeEstados;

import java.util.List;

/**
 * Esta classe implementa o nível mais abstrato de representação do problema sob
 * a forma de um espaço de estados. Pontualmente, modela uma possível situação ou
 * configuração deste problema (estado), além de ser possível vinculá-lo com outros
 * estados, que é o quesito fundamental para construir espaço de estados.
 * 
 * @author Leandro Fernandes
 * 
 * @param <T> tipo utilizado para representar e armazenar uma descrição do estado,
 *            segundo o problema que estiver sendo modelado. Trata-se de um tipo
 *            abstrato de dados (TAD), que permite a esta classe operar com qualquer
 *            forma de descrição que for adotada e considerada mais adequada a
 *            representação do problema em questão.
 */
public abstract class Estado<T> {
	
	private int id = 0;					// identificador do estado
	private int nivel;					// nível em que o estado se encontra na árvore de busca
	private Estado<?> ancestral = null;	// referencia o nó pai na árvore de busca
	
	/**
	 * Define o número identificador do estado.
	 * @param identificador do estado
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Recupera o identificador do estado.
	 * @return identificador do estado
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Define o nível que o estado (nodo) ocupa na árvore de busca.
	 * @param nível do estado na árvore de busca
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	/**
	 * Método de acesso que permite recuperar qual o nível (profundidade em
	 * relação a raiz) que este estado ocupa na árvore de busca.
	 * @return nível do nodo na árvore de busca
	 */
	public int getNivel() {
		return nivel;
	}
	
	/**
	 * Define qual o estado que originou o estado corrente dentro do espaço
	 * de busca, ou seja, qual é o seu estado predecessor.
	 * @param referência ao estado ancestral
	 */
	public void setAncestral(Estado<?> estado) {
		ancestral = estado;
	}
	
	/**
	 * Recupera o estado predecessor deste estado no espaço de busca.
	 * @return referência ao estado anterior, sob o qual a ação resultou no estado atual
	 */
	public Estado<?> getAncestral() {
		return ancestral;
	}
	
	/**
	 * Status, descrição ou configuração representativa para o estado.
	 * @param informações que caracterizam este estado 
	 */
	public abstract void setEstado(T cfg);
	
	/**
	 * Retorna a configuração do estado 
	 * @return todas as informações que caracterizam este estado
	 */
	public abstract T getEstado();
		
	/**
	 * Função que gera os estados sucessores de acordo com o problema
	 * @return lista de estados sucessores (adjacentes) a partir deste estado
	 */
	public abstract List<?> getSucessores();
	
	/**
	 * Permite verificar se este estado é igual a outro.
	 * @param o estado qual se deseja comparar com este
	 * @return true ou false
	 */
	public abstract boolean equals(Object estado);
	
	/**
	 * Retorna uma representação do estado numa forma textual e que possa ser
	 * apresentada na console, por exemplo.
	 * @return uma String representativa contendo as informações descritivas do estado
	 */
	public abstract String toString();
}