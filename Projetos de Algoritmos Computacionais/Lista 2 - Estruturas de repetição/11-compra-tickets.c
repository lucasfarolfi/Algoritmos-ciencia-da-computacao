#include <stdio.h>

float processa_tickets (int qtdtickets);

int main() {
  int numclientes;
  
  printf ("Digite o numero de clientes: ");
  scanf ("%d", &numclientes);

  for (int i=1; i <= numclientes; i++){
    float valorcobrado = 0;
    int tipopagamento = 0;

    printf ("Digite o valor cobrado: ");
    scanf ("%f", &valorcobrado);
    printf ("1 - Debito\n2 - Cartao de credito\n3 - Dinheiro\n4 - Ticket\nEscolha: ");
    scanf ("%d", &tipopagamento);

    if (tipopagamento == 1 || tipopagamento == 2){
      printf ("Nao ha troco !!!\n");
    }
    if (tipopagamento == 3){
      float valorpago = 0, troco = 0;

      printf ("Digite o valor pago: ");
      scanf ("%f", &valorpago);

      troco = valorpago - valorcobrado;
      printf ("Troco = R$ %.2f\n", troco);
    }
    if (tipopagamento == 4){
      int qtdtickets = 0;
      float totaltickets = 0, troco = 0;

      printf ("Digite a quantidade de tickets: ");
      scanf ("%d", &qtdtickets);

      totaltickets = processa_tickets (qtdtickets);
      troco = totaltickets - valorcobrado;

      if (troco > 0){
        printf ("Troco = R$ %.2f\n", troco);
      } 
      else if (troco == 0) {
        printf ("Nao ha troco !!!\n");
      }
    }
  }
  return 0;
}
float processa_tickets (int qtdtickets){
  float valorticket=0, totaltickets = 0;
  for (int i=1; i <= qtdtickets; i++){
    printf ("Digite o valor do ticket %d: ", i);
    scanf ("%f", &valorticket);
    totaltickets += valorticket;
  }
  return totaltickets;
}