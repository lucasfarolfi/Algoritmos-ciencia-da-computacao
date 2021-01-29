#include <stdio.h>

float matriz[6][12];

int main() {
  float valorcarro =0;
  scanf ("%f", &valorcarro);

  for (int i=0; i < 6; i++){
    float faturado=0;

    for (int j=0; j < 12; j++){
      scanf ("%f", &matriz[i][j]);
      faturado += matriz[i][j];
    }
    faturado *= valorcarro;
    printf ("O valor total de %d eh: R$ %.2f", 2010+i, faturado);
  }
  
  return 0;
}