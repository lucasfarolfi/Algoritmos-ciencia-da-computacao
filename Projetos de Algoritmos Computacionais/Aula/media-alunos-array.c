#include <stdio.h>
#include <math.h>

#define nota 100

int main (){
  float alunos [nota];
  float media = 0, maiornota = 0;


  for (int i = 0; i < nota; i++){
    scanf ("%f", &alunos[i]);
    
    if (alunos[i]>maiornota){
      maiornota=alunos[i];
    }
    media += alunos [i];
  }
  media = media/nota;
  printf ("Media: %.1f |Maior nota: %.1f", media, maiornota);

  return 0;
}