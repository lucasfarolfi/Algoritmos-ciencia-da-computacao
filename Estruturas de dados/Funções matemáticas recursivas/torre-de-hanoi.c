#include <stdio.h>

void move_disco (int d, char origem, char destino, char aux){
  if (d==1){
    printf ("Movendo disco %d de origem %c para destino %c\n",d,origem,destino);
  }
  else{
    move_disco (d-1, origem, aux, destino);
    printf ("Movendo disco %d de origem %c para destino %c\n",d,origem,destino);
    move_disco (d-1,aux, destino, origem);
  }
}

int main() {
  int qtd;

  printf ("Digite a quantidade de disco: ");
  scanf ("%d", &qtd);

  move_disco (qtd, 'A', 'B', 'C');
  return 0;
}