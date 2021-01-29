#include <stdio.h>

void inicializa (int notas[], int qtd){
  printf ("Notas: ");
  for (int i=0; i<qtd; i++){
    printf ("%d ", notas[i]);
  }
}
void exibe (int notas[], int qtd){

  for (int i=0; i<qtd; i++){
    int contador = 0;
    for (int j=0; j<qtd; j++){
      if (notas[i] == notas[j]){
        contador++;
      }
    }
    printf ("\nNota %d: ", i);
    for (int k=0; k<contador; i++){
      printf ("*");
    }
  }
}

int main() {
  int qtd, notas[qtd];

  scanf ("%d", &qtd);

  for (int i=0; i<qtd; i++){
    scanf ("%d", &notas[i]);
  }
  inicializa (notas, qtd);
  exibe (notas, qtd);

  return 0;
}