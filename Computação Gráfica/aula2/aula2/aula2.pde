void setup(){
  size(800,800);
}

void draw(){
  background(200);
  //Move o desenho para um ponto usando multiplicação por matriz
  //applyMatrix(1,0,width/2,0,1,height/2); //Faz o mesmo que o translate
  //É a mesma coisa que isto
  translate(width/2, height/2);
  
  //param1 - Eixo x do ponto do translate até a esquerda quando negativo
  //param2 - Eixo y do ponto do translate até em baixo
  //param3 - Eixo x do ponto do translate até a direita
  //param1 - Eixo y do ponto do translate até em cima quando negativo
  line(-width/2, 0, width/2, 0);
  line(0, height/2, 0, -height/2);
  
  rotate(frameCount/(TWO_PI * 20)); //Rotaciona o primeiro cirulo no eixo de origem
  translate(width/4, 0);
  //Eixo x = 0, eixo y = 0, diametro = 10
  circle(0,0,10);
  
  //Rotacione um frame dinamicamente com o contador do frame atual
  rotate(frameCount/(TWO_PI)); //Rotacionao o segundo circulo no eixo do 1 circulo
  circle(40,0,10);
}
