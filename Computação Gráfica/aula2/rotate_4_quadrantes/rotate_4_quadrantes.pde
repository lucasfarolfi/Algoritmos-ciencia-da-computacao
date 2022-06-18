void setup(){
  size(800,800);
}

void desenhaSatelite(){
  circle(0,0,10);
  rotate(frameCount/(TWO_PI)); 
  circle(40,0,10);
}

void draw(){
  background(200);

  translate(width/2, height/2);
  line(-width/2, 0, width/2, 0);
  line(0, height/2, 0, -height/2);
  
  pushMatrix(); // Armazena a matriz de translate atual em uma pilha
  translate(width/4, -width/4);
  desenhaSatelite();
  popMatrix(); // Deleta essa matriz e volta para a origem
  
  pushMatrix();
  translate(-width/4, width/4);
  desenhaSatelite();
  popMatrix();
  
  pushMatrix();
  translate(width/4, width/4);
  desenhaSatelite();
  popMatrix();
  
  pushMatrix();
  translate(-width/4, -width/4);
  desenhaSatelite();
  popMatrix();
}
