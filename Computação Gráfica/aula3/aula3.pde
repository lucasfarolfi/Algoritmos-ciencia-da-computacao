
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
/*
Ponto p1 = null;
Ponto p2 = null;
Ponto p3 = null;
Triangulo t = null;
Segmento s = null;
*/

void setup(){
  size(800,800);
}

void draw(){
  if(figuras.isEmpty()){
    Ponto p1 = new Ponto(width/2, height/2);
    Ponto p2 = new Ponto(width/2+50, height/2);
    Ponto p3 = p1.roda(p2, PI/3);
    Triangulo t = new Triangulo(p1,p2,p3);
    Segmento s = new Segmento(new Ponto(0,0), new Ponto(width,height));
    
    figuras.add(p1);
    figuras.add(p2);
    figuras.add(p3);
    figuras.add(t);
    figuras.add(s);
  }
  
  for(Figura f: figuras){
    f.desenha();
  }
}
