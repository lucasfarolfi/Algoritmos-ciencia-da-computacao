#include <stdio.h>

void calcula_troco (int valorsaque);

int main() {
  float valorsaque;
  printf ("Digite o valor do saque: ");
  scanf ("%f", &valorsaque);

  calcula_troco (valorsaque);
  return 0;
}
void calcula_troco (int valorsaque){
  int nota01, nota02, nota05, nota10, nota20, nota50, nota100;

  printf ("\nDeverá ser dado: ");
  nota100 = valorsaque / 100;
  if (nota100 != 0){
    printf ("\n%d nota(s) de R$100", nota100);  
  }
  nota100 = valorsaque % 100;

  nota50 = nota100 / 50;
  if (nota50 != 0){
    printf ("\n%d nota(s) de R$50", nota50);
  }
  nota50 = nota100 % 50;

  nota20 = nota50 / 20;
  if (nota20 != 0){
    printf ("\n%d nota(s) de R$20", nota20);
  }
  nota20 = nota50 % 20;

  nota10 = nota20 / 10;
  if (nota10 != 0){
    printf ("\n%d nota(s) de R$10", nota10);
  }
  nota10 = nota20 % 10;
  
  nota05 = nota10 / 5;
  if (nota05 != 0){
    printf ("\n%d nota(s) de R$5", nota05);  
  }
  nota05 = nota10 % 5;

  nota02 = nota05 / 2;
  if (nota02 != 0){
    printf ("\n%d nota(s) de R$2", nota02);
  }
  nota02 = nota05 % 2;

  nota01 = nota02 / 1;
  if (nota01 != 0){
    printf ("\n%d nota(s) de R$1", nota01);
  }
}