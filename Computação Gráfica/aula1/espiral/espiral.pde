void setup(){
 size(800,800);
 background(0);
}

//"5" é a distância das curvaturas em cada volta.

void draw(){
  int pontos_volta = 100;
  int voltas = 10;
  int tam_volta = 10;
  float theta;  
  float raio = 0.25 * width; //25% da largura da tela
  float angulo = TWO_PI/pontos_volta; // Angulo de cada vertice que soma 360
  
  translate(width/2, height/2); //Deixa a figura no centro da tela
  
  beginShape(); 
    for(int i = 0; i < voltas; i++){ //A cada volta
      for(int j = 0; j < pontos_volta; j++){ //A cada ponto
        theta = (TWO_PI * i) + (j * angulo); //Calcula angulo do ponto da volta atual
        raio = i + (tam_volta * theta); //Raio atual da volta
        vertex(raio * cos(theta), raio * sin(theta)); //Desenha os vértices circulando
      }
    }
  endShape();
}
