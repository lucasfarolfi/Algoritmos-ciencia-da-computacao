#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define PI 3.14

float volume_cubo (int a, int b, int c);
float volume_cilindro (int r, int h);

int main() {
  float a, b, c, r, h; //"a","b" e "c" =lados do cubo. "r" e "h" =raio e a altura do cilindro.
  float volumecubo, volumecil, volcubcil;//volcubcil = volume do cubo com um furo do cilindro;

  printf ("Digite os tres lados do cubo: ");
  scanf ("%f%f%f", &a, &b, &c);

  printf ("Digite o raio e a altura de um cilindro: ");
  scanf ("%f%f", &r, &h);

  volumecubo = volume_cubo (a, b, c);
  volumecil = volume_cilindro (r, h);

  volcubcil = volumecubo - volumecil;

  printf ("\nO volume do cubo eh %.2f cm³", volumecubo);
  printf ("\nO volume do cilindro eh %.2f cm³", volumecil);
  printf ("\nE o volume do cubo furado pelo cilindro eh %.2f cm³", volcubcil);

  return 0;
}
float volume_cubo (int a, int b, int c){
  float volumecubo;
  volumecubo = a * b * c;
  return volumecubo;
}
float volume_cilindro (int r, int h){
  float volumecil;
  volumecil = PI * h * pow(r,2);
  return volumecil;
}