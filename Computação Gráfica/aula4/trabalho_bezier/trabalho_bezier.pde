float calcula_pontos(float p_inicial, float cont, float p_final){
 return p_inicial + cont * (p_final - p_inicial); 
}

void setup(){
  size(800,800);
}

void draw(){
  background(0);
  
  float p1x = 50;
  float p1y = 500;
  float p2x = mouseX;// Põe mais efeito na curva ao mover mouse
  float p2y = mouseY;
  float p3x = 800;
  float p3y = 200;
  float p4x = 750;
  float p4y = 500;

  beginShape();
  vertex(p1x, p1y);
  for(float t = 0; t <= 1; t += 0.01)
  {
    // Criação de pontos que farão chegar até a curva
    float ax = calcula_pontos(p1x, t, p2x);
    float bx = calcula_pontos(p2x, t, p3x);
    float cx = calcula_pontos(p3x, t, p4x);
    float dx = calcula_pontos(ax, t, bx);
    float ex = calcula_pontos(bx, t, cx);
    float fx = calcula_pontos(dx, t, ex);
    
    float ay = calcula_pontos(p1y, t, p2y); 
    float by = calcula_pontos(p2y, t, p3y);
    float cy = calcula_pontos(p3y, t, p4y);
    float dy = calcula_pontos(ay, t, by);
    float ey = calcula_pontos(by, t, cy);
    float fy = calcula_pontos(dy, t, ey);

    vertex(fx,fy);
  }
  vertex(p4x, p4y);
  endShape(CLOSE);
}
