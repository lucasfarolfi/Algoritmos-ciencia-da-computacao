// Interface figura
interface Figura{
  void desenha();
}

// Classe Ponto
class Ponto implements Figura{
  float x,y;
  
  Ponto(float x, float y){
    this.x = x;
    this.y = y;
  }
  
  void desenha(){
    fill(0);
    circle(this.x, this.y, 10);
  }
  
  // Faz a translação do ponto primitivamente
  Ponto roda(Ponto B, float alpha){
    return new Ponto(
      ((B.x-this.x) * cos(alpha) + (B.y-this.y) * sin(alpha)) + this.x,
      (-(B.x-this.x)*sin(alpha) + (B.y-this.y) * cos(alpha)) + this.y
    );
  }
}

// Triangulo
class Triangulo implements Figura{
  Ponto A,B,C;
  
  Triangulo(Ponto A, Ponto B, Ponto C){
    this.A = A;
    this.B = B;
    this.C = C;
  }
  
  void desenha(){
    beginShape();
    vertex(this.A.x, this.A.y);
    vertex(this.B.x, this.B.y);
    vertex(this.C.x, this.C.y);
    endShape(CLOSE);
  }
}

//Segmento
class Segmento implements Figura{
  Ponto A,B;
  
  Segmento(Ponto A, Ponto B){
   this.A = A;
   this.B = B;
  }
  
  void desenha(){
    line(this.A.x, this.A.y, this.B.x, this.B.y);
  }
}

// Variaveis globais
ArrayList<Figura> figuras = new ArrayList<Figura>();

void setup(){
  size(800,800);
}

void koch(Ponto A, Ponto B, int nivel){
  if(nivel == 0){
    new Segmento(A,B).desenha();
  }
  else{
    Ponto C = new Ponto((1.0 * (B.x-A.x)/3.0)+A.x, (1.0*(B.y-A.y)/3.0)+A.y);
    Ponto D = new Ponto((2.0 * (B.x-A.x)/3.0)+A.x, (2.0*(B.y-A.y)/3.0)+A.y);
    Ponto E = C.roda(D, PI/3);
    koch(A,C, nivel-1);
    koch(C,E, nivel-1);
    koch(E,D, nivel-1);
    koch(D,B, nivel-1);
  }
}

void draw(){
  background(200);
  
  if(figuras.size() == 2){
    Ponto A = (Ponto)figuras.get(0);
    Ponto B = (Ponto)figuras.get(1);
    koch(A,B,4);
  }
  
  for(Figura f: figuras){
    f.desenha();
  }
}



void mouseReleased(){
  if(figuras.size() <= 2){
    figuras.add(new Ponto(mouseX, mouseY));
  }
}
