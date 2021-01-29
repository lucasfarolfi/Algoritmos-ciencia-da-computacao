#include <stdio.h>

int main() {
  int x = 10;
  printf ("%d\n", &x);// mostra em qual endereço o 'x' está

  int y = 10;
  int *ponteiro;
  ponteiro = &y; // A variável do ponteiro está apontando para o endereço que está y;

  printf ("%d\n", ponteiro); // apenas o nome pega o endereço
  printf ("%d\n", *ponteiro); // com o caractere antes pega o valor do endereço

  printf ("___________________________\n");

  int a = 10; 
  int *pont;
  pont = &a; //estou apontando para o endereço de a;

  int b = 20;
  *pont = b; // estou jogando o valor de 'b' para dentro do endereço 'a' usando ponteiro;

  printf ("%d %d", a, b);

  return 0;
}