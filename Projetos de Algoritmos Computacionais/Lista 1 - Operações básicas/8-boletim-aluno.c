#include <stdio.h>

float calcula_media (float mp, float mt);

int main() {
  int matricula;
  float p1=0, p2=0, trab1=0, trab2=0, mediaprova=0, mediatrab=0, mediafinal;
  scanf ("%d", &matricula);
  scanf ("%f%f%f%f", &p1, &p2, &trab1, &trab2);

  mediaprova = (p1 + p2) /(2);
  mediatrab = (trab1 + trab2) /(2);

  mediafinal = calcula_media (mediaprova, mediatrab);

  printf ("O numero da matricula eh %d\nA media das provas eh %.1f\nA media dos trabalhos eh %.1f\nE a media final eh %.1f", matricula, mediaprova, mediatrab, mediafinal);

  return 0;
}
float calcula_media (float mp, float mt){
  float mediafinal;
  mediafinal = (mp + mt) /(2);
  return mediafinal;
}