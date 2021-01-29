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
  int maiormatricula = 0;
  float maiorsalario = 0;

  for (int i=1; i <= qtd_funcionario; i++){
    int matricula = 0;
    float salario = 0;
    printf ("Digite a matricula do funcionario %d: ", i);
    scanf ("%d", &matricula);

    printf ("Digite o salario do funcionario %d: ", i);
    scanf ("%f", &salario);

    if (salario > maiorsalario){
      maiorsalario = salario;
      maiormatricula = matricula;
    }
  }
  printf ("\nMaior salario = R$ %.2f| Matricula = %d", maiorsalario, maiormatricula);
}