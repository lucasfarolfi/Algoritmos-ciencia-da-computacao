#include <stdio.h>
#define tam 5

int main() {

  int vet[tam], aux = 0;

  for (int i=0; i < tam; i++){
    scanf ("%d", &vet[i]);
  }

  for (int i=0; i < tam; i++){
    for (int x=i+1; x < tam; x++){
      if (vet[i] < vet[x]){
        aux = vet[i];
        vet[i] = vet[x];
        vet[x] = aux;
      }
      
    }
  }
  for (int i=0; i < tam; i++) printf ("%d ", vet[i]);

  return 0;
}