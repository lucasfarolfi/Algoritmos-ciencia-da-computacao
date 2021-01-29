#include <stdio.h>

struct dados{
  int numero;
  float saldo;
};

void FuncaoExibe (struct dados *cliente , int qtd, float media){

  for (int i=0; i<qtd; i++){
    printf ("\nO numero do cliente %d eh: %d", i, cliente[i].numero);
    printf ("\nO seu saldo eh: R$ %.2f", cliente[i].saldo);
    
    if (cliente[i].saldo > media){
      printf ("\nAcima da media do saldo !!!\n");
    }
    else if (cliente[i].saldo < media){
      printf ("\nAbaixo da media do saldo !!!\n");
    }
    else if (cliente[i].saldo == media){
      printf ("\nSaldo na media !!!\n");
    }
  }
}

int main() {
  int qtd;
  float saldomedio = 0;
  
  struct dados cliente[qtd];
  printf ("Digite o numero de clientes: ");
  scanf ("%d", &qtd);

  for (int i=0; i < qtd; i++){
    printf ("Digite o numero do cliente %d: ", i);
    scanf ("%d", &cliente[i].numero);
    printf ("Digite o saldo do cliente %d: ", i);
    scanf ("%f", &cliente[i].saldo);

    saldomedio += cliente[i].saldo;
  }
  saldomedio = saldomedio/qtd;
  
  FuncaoExibe (cliente, qtd, saldomedio);
  return 0;
}