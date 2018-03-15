# Espaço de Estados e Estratégias de Busca

Este projeto é um exemplo de implementação em Java dos métodos de busca mais comuns da área de Inteligência Artificial, que permitem resolver problemas dos mais diversos tipos desde que modelados na forma de um Espaços de Estados.

A solução de um problema é encontrada através da exploração do espaço que o representa, transitando entre os diferentes estados possíveis até que seja alcançado um estado que atenda os objetivos estabelecidos para a busca (estado meta).


## Problemas modelados:

Dado o caráter generalista que as buscas oferecem, escolhemos dois problemas diferentes e os modelamos como um espaço de estados de maneira que seja possível demonstrar essas técnicas em funcionamento.

- **Puzzle-8**

Um quebra-cabeças combinatório e de deslizamento (do tipo _sliding tile puzzle_), composto por oito peças numeradas que são distribuídas no tabuleiro e organizadas em três linhas e três colunas.

Dentre as nove posições do arranjo há sempre uma que encontra-se vazia. É possível deslizar qualquer peça adjacente (tanto horizontalmente quanto verticalmente) para a posição livre, conferindo ao tabuleiro uma nova distribuição.

As peças não podem ser retiradas do tabuleiro, tampouco podem ser movimentadas diagonalmente ou sobre uma outra peça. Vale ressaltar que nem sempre qualquer seqüência que o usuário possa imaginar seria possível efetivamente, uma vez que  na realidade o processo de embaralhamento é feito usando as mesmas regras. Um referencial teórico sobre como é possível determinar se uma configuração do tabuleiro é válidas ou não, pode ser encontradas [aqui](http://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html).

- **Jogo da Velha (Tic-Tac-Toe)**

Consiste num jogo em que um quadriculado com nove posições, organizadas em três linhas e três colunas, é preenchido e no qual dois jogadores se confrontam fazendo suas jogadas alternadamente. Cada um deles faz a sua jogada marcando uma posição vazia com o seu símbolo.

Jogada após jogada o tabuleiro vai sendo preenchido com os símbolos `X` e `O`. O ganhador da disputa será aquele que conseguir formar primeiro uma trinca de suas marcas numa disposição linear.


## Estratégias de Busca

### Busca Cega ###

Guiam-se por uma exploração sistemática do espaço de estados, segundo uma determinada estratégia e utilizam apenas a descrição do problema para conduzir o processo.

Métodos deste grupo:
 
1. *Busca em Largura*:

Constroem a árvore de busca expandindo nível-a-nível, de modo que o aprofundamento aconteça após todas as possibilidades do nível anterior tenham sido analisadas.
 
2. *Busca em Profundidade*:
 
Cria a árvore de busca se aprofundando na seqüência de estados sucessivos, incrementando o nível da árvore a cada passo e enquanto houver sucessores para o estado corrente. Os demais estados de um mesmo nível somente serão explorados após o ramo do anterior ter sido completamente finalizado.
 
Note que esta abordagem é suscetível a problemas frente processos cíclicos no espaço de estados e quando não há detecção de estados repetidos, podendo incorrer num aprofundamento infinito de um ramo e, por conseqüência, não sendo capaz de explorar outras áreas do espaço de estado.
 
3. *Busca em Profundidade Limitada*:

Opera de forma análoga ao anterior, porém limitando o nível máximo de aprofundamento de um ramo e evitando assim o comportamento exploratório infinito de um ramo que não contém uma solução válida para o problema.


### Busca Informada ou Busca Heurística ###

Os algoritmos desta categoria empregam estratégias que procuram prover maior eficiência funcional e de memória em relação as abordagens clássicas. Além da descrição do problema, fazem uso de funções de custo e de avaliação  para orientar a escolha do próximo estado a ser explorado durante o processo de busca.

1. *Hill-Climbing (Subida da Encosta ou Otimização Discreta)*:
    
A estratégia deste algoritmo consiste em realizar uma busca em profundidade em conjunto com a função de avaliação (heurística), de modo a selecionar dentre os nodos descendentes do ramo atual aquele que for mais promissor. 
 
2. *Best-First Search - BFS (Melhor primeiro)*:
    
O algoritmo BFS explora o espaço de estados realizando uma busca em largura, porém diferenciando-se por utilizar a função de avaliação para determinar a ordem de visitação dos nodos localizados no mesmo nível.
 
3. *Branch-and-Bound*:
    
Também utiliza uma estratégia exploratória em largura, entretanto considera a função de custo como o elemento de seleção para determinar qual o nodo, dentre aqueles do mesmo nível, será o próximo a ser visitado.
    
4. *A\* (A-Star ou Busca Ótima)*:
    
5. *Iterative Deepening A-Star - IDA\**:
    
6. *Recursive Best-First Search - RBFS*: