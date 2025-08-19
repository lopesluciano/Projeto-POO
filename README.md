# Trabalho Prático de POO
Projeto da disciplina SCC0604 - Programação Orientada a Objetos, ministrada pelo professor José Fernando Rodrigues Júnior.

- Luciano Gonçalves Lopes Filho 13676520
- Marco Antonio Gaspar Garcia 11833581

## Detalhes sobre o Projeto
O projeto consiste na recriação das 4 primeiras fases do jogo `Eggerland Mystery`, primeiro jogo da série [Eggerland](https://en.wikipedia.org/wiki/Eggerland), lançado em 1985 para MSX. O jogo é um puzzle de 105 fases, em que o personagem principal `Lolo` percorre  um labirinto para resgatar a princesa Lala, derrotando os monstros que a sequestraram.

<p align="center">
  <img src="Sprites(ALL)/capa_do_jogo.webp" alt="Eggerland Mystery" width="300">
</p>
<p align="center">
  <span style="font-size: 12px;">Capa original do jogo Eggerland Mystery</span>
</p>

Utilizamos a `Eclipse IDE` ao invés de NetBeans, pois tem uma melhor compatibilidade com o desenvolvimento de games. O projeto contém duas source folders, **src** e **res**. A pasta src contém todas as classes que utilizamos, organizadas em pacotes, enquanto que a pasta res contém tudo aquilo que não é código, isto é, as imagens e os mapas que utilizamos. 

As sprites foram todas redesenhadas através da aplicação `Piskel`, que é um editor de PixelArts para navegador. Todos os ladrilhos do jogo são de 16x16 pixels. Para descobrir as características do jogo e as funcionalidades que iríamos implementar, jogamos algumas fases do jogo através de um [emulador online](https://www.retrogames.cc/msx1-games/eggerland-mystery.html).


## Inspirações
Nos inspiramos nos vídeos de [RyiSnow](https://www.youtube.com/@RyiSnow), um desenvolvedor de games em Java. Ele traz diversos tutoriais em seu canal, e a base do jogo foi construída da forma que ele ensina. Entretanto, após certo ponto, todo o desenvolvimento passou a ser por nossa conta, pois os caminhos dos games divergiam.

Playlist: https://www.youtube.com/playlist?list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq


## Como jogar
Para iniciar o jogo, insira o comando java -jar RunGame.jar (O JDK do Java deve estar instalado no seu computador).

Pressione `W`, `A`, `S`, `D` para se mover para cima, esquerda, baixo e direita, respectivamente. Se você possuir munição, aperte `Space` para atirar. Para pausar o jogo, pressione a tecla `P`, e para reiniciar uma fase, pressione a tecla `R`. Para reiniciar o jogo desde a primeira fase, pressione `I` e feche a janela. Ao reabrir, você iniciará na primeira fase.

Pode ser que aconteça algum erro de importação de classes. Caso aconteça, dê "clean" no projeto e depois "run", que o jogo deve funcionar normalmente.

> Quaisquer problemas para rodar o jogo, entre em contato conosco!

## Screenshots 

<p align="left">
  <img src="Sprites(ALL)/Screenshot1.png" alt="Eggerland Mystery" width="300">
  <img src="Sprites(ALL)/Screenshot2.png" alt="Eggerland Mystery" width="300">
  <img src="Sprites(ALL)/Screenshot3.png" alt="Eggerland Mystery" width="300">
</p>
