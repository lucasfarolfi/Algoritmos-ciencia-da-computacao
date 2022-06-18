void setup(){
  size(800,800);
}

void draw(){
  background(0);

  //Desenha sol no centro
  translate(width/2, height/2);
  fill(255,200,0,255);
  circle(0,0,200);
  
  //Desenha a terra e rotaciona em volta do sol
  rotate(frameCount/(TWO_PI * 5));
  translate(width/4, -width/4);
  fill(0,0,255,255);
  circle(0,0,60);
  
  //Desenha a lua no eixo da terra e rotaciona
  rotate(frameCount/(TWO_PI * 2)); 
  fill(200,200,200,250);
  circle(100,0,25);
}
