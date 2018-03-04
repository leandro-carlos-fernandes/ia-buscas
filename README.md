# Espaço de Estados e formas de Buscas

Este projeto é um exemplo de implementação em Java dos métodos de busca cega mais comuns da área de Inteligência Artificial, que permitem resolver problemas diversos desde que modelados na forma de um Espaços de Estados.

A solução do problema é dada através exploração do espaço, transitando entre diferentes estados possíveis até que seja alcançado um estado que atenda os objetivos estabelecidos para a busca (estado meta).


## Problemas modelados:

Dado o caráter generalista que as buscas oferecem, escolhemos dois problemas diferentes e os modelamos como um espaço de estados de maneira que seja possível demonstrar essas técnicas em funcionamento.

- **Puzzle-8**

Um quebra-cabeças combinatório e de deslizamento (do tipo _sliding tile puzzle_), composto por oito peças numeradas que são distribuídas no tabuleiro e organizadas em três linhas e três colunas.

Dentre as nove posições do arranjo há sempre uma que encontra-se vazia. É possível deslizar qualquer peça adjacente (tanto horizontalmente quanto verticalmente) para a posição livre, conferindo ao tabuleiro uma nova distribuição.

As peças não podem ser retiradas do tabuleiro, tampouco podem ser movimentadas diagonalmente ou sobre uma outra peça. Vale ressaltar que nem sempre qualquer seqüência que o usuário possa imaginar seria possível efetivamente, uma vez que  na realidade o processo de embaralhamento é feito usando as mesmas regras. Um referencial teórico sobre como é possível determinar se uma configuração do tabuleiro é válidas ou não, pode ser encontradas [aqui] (http://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html) 

- **Jogo da Velha (Tic-Tac-Toe)**

Consiste num jogo em que um quadriculado com nove posições, organizadas em três linhas e três colunas, é preenchido e no qual dois jogadores se confrontam fazendo suas jogadas alternadamente. Cada um deles faz a sua jogada marcando uma posição vazia com o seu símbolo.

Jogada após jogada o tabuleiro vai sendo preenchido com os símbolos `X` e `O`. O ganhador da disputa será aquele que conseguir formar primeiro uma trinca de suas marcas numa disposição linear.
