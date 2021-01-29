#include <stdio.h>

float calcula_perifericos (int perifericos);

int main() {
  int vendas = 0, vendasemperifericos = 0;
  float vtotal = 0, valormedio = 0;

  printf ("Digite o numero de vendas: ");
  scanf ("%d", &vendas);

  for (int i=1; i <= vendas; i++){
    int escolha = 0, perifericos;
    float precopc, precoperifericos = 0, totalperiferico = 0;

    printf ("1 - Modelo 1 (R$ 1000)\n2 - Modelo 2 (R$ 1500)\n3 - Modelo 3 (R$ 2000)\nEscolha: ");
    scanf ("%d", &escolha);
    if (escolha == 1){
      precopc += 1000;
    }
    if (escolha == 2){
      precopc += 1500;
    }
    if (escolha == 3){
      precopc += 2000;
    }

    printf ("\nQuantos perifericos voce deseja ?: ");
    scanf ("%d", &perifericos);

    if (perifericos == 0){
      vendasemperifericos++;
      total += precopc;
    }
    else if (perifericos > 0){
      precoperifericos = calcula_perifericos (perifericos);
      total = precopc + precoperifericos;
    }
  }
  valormedio = (total)/vendas;
  
  printf ("Total de vendas sem perifericos: %d\nValor medio de todas as vendas: R$ %.2f", vendasemperifericos, valormedio);
  return 0;
}
float calcula_perifericos (int perifericos){
  float vtotalperifericos = 0;

  for (int i=1; i <= perifericos; i++){
    int escolha = 0;
    printf ("1 - Mouse Razer (R$ 100)\n2 - Mouse HyperX (R$ 200)\n Escolha %d: ", i);
    scanf ("%d", &escolha);

    if (escolha == 1){
      vtotalperifericos += 100;
    }
    if (escolha == 2){
      vtotalperifericos += 200;
    }
  }
  
  return vtotalperifericos;
}