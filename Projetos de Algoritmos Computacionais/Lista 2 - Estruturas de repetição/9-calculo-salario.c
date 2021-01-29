#include <stdio.h>

int menu (int n);
float calcula_salario (int opcao);

int main() {
  int n; //numero de funcionarios
  
 
  printf ("Digite o numero de funcionarios: ");
  scanf ("%d", &n);
  
  for (int i=0; i < n; i++){
    int opcao = 0;
    float salario = 0;
    opcao = menu (n);
    salario = calcula_salario (opcao);
    printf ("\nSeu salario sera de R$ %.2f\n", salario);
  }
  return 0;
}
int menu (int n){
  int opcao;

  printf ("1 - Horista\n2 - Contratado\n3 - Prestador de servico\nEscolha: ");
  scanf ("%d", &opcao);
  
  return opcao;
}
float calcula_salario (int opcao){
  float salario;
  if (opcao == 1){
    float  valorhora;
    int qtdhoras;
    printf ("Digite o valor ganho por hora e a quantidade de horas trabalhadas: ");
    scanf ("%f%d", &valorhora, &qtdhoras);
    salario = valorhora * qtdhoras;
  }
  if (opcao == 2){
    printf ("Digite seu salario: ");
    scanf ("%f", &salario);
  }
  if (opcao == 3){
    int servicos = 0;
    printf ("Digite a quantidade de servicos feitos: ");
    scanf ("%d", &servicos);

    for (int i = 1; i <= servicos; i++){
      float valorservico = 0;
      printf ("Digite o valor do servico %d: ", i);
      scanf ("%f", &valorservico);
      salario += valorservico;
    }
  }
  return salario;
}