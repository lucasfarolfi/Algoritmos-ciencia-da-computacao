#include <stdio.h>

void calcula_maiorsalario (int qtd_funcionario);

int main() {
  int qtd_funcionarios;
  printf ("Digite a quantidade de funcionarios de uma empresa: ");
  scanf ("%d", &qtd_funcionarios);

  calcula_maiorsalario (qtd_funcionarios);
  return 0;
}
void calcula_maiorsalario (int qtd_funcionario){
  int mesmosalario = 0;
  float maiorsalario = 0;

  for (int i=1; i <= qtd_funcionario; i++){ //utilizando o i como contador
    int matricula = 0;
    float salario = 0;

    printf ("Digite o salario do funcionario %d: ", i);
    scanf ("%f", &salario);

    if (salario > maiorsalario){
      maiorsalario = salario;
      mesmosalario = 0;
    }
    if (salario == maiorsalario){
      mesmosalario +=1;
    }
  }
  printf ("\nMaior salario = R$ %.2f| Possuem %d funcionario(s) recebendo este salario", maiorsalario, mesmosalario);
}