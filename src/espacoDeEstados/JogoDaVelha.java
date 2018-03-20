package espacoDeEstados;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe modela o jogo de tabuleiro conhecido como "Jogo da Velha" ou
 * Tic-Tac-Toe na forma de um estado, de modo que seja possível representar as
 * partidas como um conjunto de possibilidades (espaço de estados).
 * Nele temos um tabuleiro de três linhas e três colunas, onde dois jogadores
 * se enfrentam marcando um após o outro as posições livres com um símbolo que
 * os representa.
 * O jogo termina quando um dos jogadores consegue formar uma trinca alinhada ou
 * quando não há mais uma posição vaga que possa ser preenchida.
 *  
 * Ex:
 *     |   |          |   |          |   |          |   |          |   |          |   |          |   |
 *   X | O |        X | O |        X | O |        X | O |        X | O |        X | O |        X | O |    
 * ----+---+----  ----+---+----  ----+---+----  ----+---+----  ----+---+----  ----+---+----  ----+---+----
 *     |   |          |   |          |   |        O |   |        O |   |        O | O |        O | O |
 * ----+---+----  ----+---+----  ----+---+----  ----+---+----  ----+---+----  ----+---+----  ----+---+----
 *     |   |          |   |        X |   |        X |   |        X |   | X      X |   | X    --X-+-X-+-X--
 *     |   |          |   |          |   |          |   |          |   |          |   |          |   |
 *     
 * @author Leandro C. Fernandes
 *
 */
public class JogoDaVelha extends Estado<char[]> {
	
	private char jogador;
	private static int contGlobal = 0;	// contador global representando a qde de instâncias
	private char[] tabuleiro;			// vetor que descreve a posição das peças do quebra-cabeças
	
	/**
	 * Cria uma instância para representar uma configuração para o tabuleiro do quebra-cabeças
	 */
	public JogoDaVelha() {
		this(new char[9], null, 0);
	}
	
	/**
	 * Permite criar um novo estado, já definindo a configuração para o tabuleiro 
	 * @param cfgTabuleiro vetor de caracteres que representa a disposição das peças
	 */
	public JogoDaVelha(char[] cfgTabuleiro) {
		this(cfgTabuleiro, null, 0);
	}
	
	/**
	 * Permite criar um novo estado, já definindo a configuração para o tabuleiro 
	 * @param cfgTabuleiro vetor de caracteres que representa a disposição das peças
	 * @param ancestral referencia ao nodo pai do estado corrente
	 * @param nivel altura do nodo em relação a raiz da árvore
	 */
	public JogoDaVelha(char[] cfgTabuleiro, JogoDaVelha ancestral, int nivel) {
		setId(contGlobal++);
		setNivel(nivel);
		setAncestral(ancestral);
		tabuleiro = cfgTabuleiro.clone();
	}
	
	/**
	 * Define o símbolo do próximo jogador (jogador 'X' ou jogador 'O').
	 */
	public void setJogador(char simbolo) {
		jogador = simbolo;
	}
	
	/**
	 * Recupera o símbolo do próximo jogador.
	 * @return símbolo 'X' ou 'O'
	 */
	public char getJogador() {
		return jogador;
	}
	
	/**
	 * Define o posicionamento das peças do quebra-cabeças, determinando a configuração
	 * que será assumida pelo tabuleiro. 
	 * @param cfgTabuleiro vetor representando a posição dos elementos no tabuleiro 
	 */
	@Override
	public void setEstado(char[] cfgTabuleiro) {
		for (int i = 0; i < cfgTabuleiro.length; i++) {
			this.tabuleiro[i] = cfgTabuleiro[i];	
		}
	}
	
	/**
	 * Retorna a configuração das peças no tabuleiro do quebra-cabeças 
	 * @return vetor representando a configuração do tabuleiro
	 */
	@Override
	public char[] getEstado() {
		char[] cfgTabuleiro = new char[9];
		for (int i = 0; i < tabuleiro.length; i++) {
			cfgTabuleiro[i] = tabuleiro[i];
		}
		return cfgTabuleiro;
	}

	/**
	 * Função que gera os estados sucessores de acordo com os diferentes movimentos possíveis
	 * a partir da configuração do tabuleiro.
	 * @return lista de estados sucessores
	 */
	@Override
	public List<JogoDaVelha> getSucessores() {
		List<JogoDaVelha> estadosSucessores = new ArrayList<JogoDaVelha>();
		
		char proximoJogador = (getJogador() == 'O') ? 'X' : 'O';
		
		char[] cfg = tabuleiro.clone();
		for (int k = 0; k < 9; k++)
			if (tabuleiro[k] == ' ') {
				for (int i = 0; i < cfg.length; i++)
					cfg[i] = (i != k) ? tabuleiro[i] : jogador;
				JogoDaVelha sucessor = new JogoDaVelha(cfg,this,this.getNivel()+1);
				sucessor.setJogador(proximoJogador);
				estadosSucessores.add(sucessor);
			}
		
		return estadosSucessores;
	}
	
	public int heuristica(char[] cfgEstadoMeta) {
		return 0;
	}

	/**
	 * Retorna uma String correspondente a posição das peças no tabuleiro do quebra-cabeças 
	 */
	public String toString() {
		String msg = "";
		msg += " " + tabuleiro[0] + " | " + tabuleiro[1] + " | " + tabuleiro[2] + "\n";
		msg += "---+---+---\n";
		msg += " " + tabuleiro[3] + " | " + tabuleiro[4] + " | " + tabuleiro[5] + "   Nodo #" + getId() + "  Nível: " + getNivel() + "\n";
		msg += "---+---+---\n";
		msg += " " + tabuleiro[6] + " | " + tabuleiro[7] + " | " + tabuleiro[8] + "\n";
		return msg;
	}

	/**
	 * Implementa a comparação entre dois estados, sendo baseada na disposição das peças no
	 * tabuleiro do quebra-cabeças
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoDaVelha other = (JogoDaVelha) obj;
		for (int i = 0; i < tabuleiro.length; i++)
			if ((tabuleiro[i] != other.tabuleiro[i]) && (other.tabuleiro[i] != '?'))
				return false;
		
		return true;
	}
	
}