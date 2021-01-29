#include <stdio.h>
#include <math.h>

int main() {
  float a, b, c, delta, x1, x2;
  scanf ("%f%f%f", &a, &b, &c);

  delta = pow(b,2) - (4 * a * c);

  if (delta > 0){
    x1 = (-b + sqrt (delta) )/(2 * a);
    x2 = (-b - sqrt (delta) )/(2 * a);
    printf ("As raizes sao %.1f e %.1f !!!", x1, x2);
  }
  if (delta == 0){
    x1 = -b / (2 * a);
    printf ("A raiz da equacao e %.1f !!!", x1);
  }
  if (delta < 0){
    printf ("Nao tem raiz !!!");
  }

  return 0;
}