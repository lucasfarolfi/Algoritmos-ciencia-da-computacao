#include <stdio.h>

float nota [30][4];

float CalculaMedia (nota[30][4], int x, int y){
  for (int i=0; i < 30; i++){
    float media = 0;
    for (int j=0; j < 4; j++){
      media += nota[i][j];
    }
    nota[i][3]=media/4;
    
  }

}  

int main() {
  float media = 0;
 
  for (int i=0; i < 2; i++){
    for (int j=0; j < 4; j++){
      scanf ("%f", &nota[i][j]);
    }
  }
  media = CalculaMedia (nota, 30, 4);

  for (int i=0; i<30; i++) printf ("Media do aluno %d: %.1f\n", i, nota[i][3]);
  return 0;
}