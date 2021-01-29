#include <stdio.h>
#include <math.h>

float valor_garcom (float custocliente);

int main() {
  float custocliente, valorgarcom, gastototal;

  printf ("Digite o valor do custo do cliente: ");
  scanf ("%f", &custocliente);

  valorgarcom = valor_garcom (custocliente);
  gastototal = custocliente + valorgarcom;

  printf ("O valor total eh de R$ %.2f", gastototal);
  return 0;
}
float valor_garcom (float custocliente){
  float valorgarcom;

  valorgarcom = (10 * custocliente)/(100);
  return valorgarcom;
}