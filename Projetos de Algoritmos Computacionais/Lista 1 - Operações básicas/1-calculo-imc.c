#include <stdio.h>
#include <math.h>

float CalcIMC (float peso, float alt);
void ClassificIMC (float peso, float alt);

int main() {
  float peso, alt, IMC;

  printf ("Digite seu peso: ");
  scanf("%f", &peso);
  printf ("Digite sua altura: ");
  scanf("%f", &alt);

  IMC = CalcIMC (peso, alt);
  ClassificIMC (peso, alt);

  printf ("\n%.2f", IMC);
  return 0;
}
float CalcIMC (float peso, float alt){
  float IMC;
  IMC = peso/(alt * alt);
  return IMC;
}
void ClassificIMC (float peso, float alt){
  float IMC;
  IMC = peso/(alt * alt);
  if (IMC < 20){
    printf ("Abaixo do peso !!!");
  } if (IMC >= 20 && IMC < 25){
    printf ("Média");
  }if (IMC >= 25 && IMC < 30){
    printf ("Acima do peso");
  }
}