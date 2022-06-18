// Onde é definido as configurações iniciais
void setup(){
  size(800,800); //Tamanho da tela (width px, height px)
  
  frameRate(30); //Frames por segundo
}

//Onde é feito o desenho
void draw(){
  background(200);//Seta cores no background
  
  //Ao mover o mouse no eixo x, os pontos oscilam de 3 até 20
  //(eixo do mouse, posição minima, pos. maxima, de 3, ate 20)
  //int pontos = ceil(map(mouseX, 0, width, 3, 20));  
  
  // Aumenta os pontos de 3 ate 17 e depois volta pro 3
  int pontos = 3 + (frameCount % 17);
  float theta = TWO_PI/pontos; //Calcula o tamanho de cada lado
  float diametro = 0.6 * width/2; //Metade da tela
  
  translate(width/2, height/2); //Muda o circulo pro meio da tela
  circle(0, 0, diametro); // Desenha um circulo (width, height, size)
  
  // --- Montando um poligono --- //
  
  beginShape();
  for(int i=0; i<pontos; i++){
    //Gera os vértices nos pontos do seno e do cosseno, seguindo um circulo
    vertex(diametro*cos(i*theta), diametro*sin(i*theta));
  }
  endShape(CLOSE); //Liga o primeiro e o ultimo ponto do poligono
}
