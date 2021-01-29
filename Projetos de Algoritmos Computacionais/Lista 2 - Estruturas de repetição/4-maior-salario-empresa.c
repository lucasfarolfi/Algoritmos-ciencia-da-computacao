#include <stdio.h>

int qtd_func (int qtdfuncionarios);

int main() {
  int qtdfuncionarios;
  float maiorsalario;

  printf ("Digite a quantidade de funcionarios: ");
  scanf ("%d", &qtdfuncionarios);

  maiorsalario = qtd_func (qtdfuncionarios);

  printf ("\nO maior salario eh de R$ %.2f !!!", maiorsalario);

  return 0;
}
int qtd_func (int qtdfuncionarios){
  int qtdfuncionarias = 0, salariototal = 0;
  float maiorsalario;

  for (int i = 1; i <= qtdfuncionarios;i++){
    int sexo = 0, salario = 0;
    float salariomaior = 0;

    printf ("\nDigite o sexo do funcionario %d(1-Masc/2-Fem): ", i);
    scanf ("%d", &sexo);
    if (sexo == 1){
      qtdfuncionarias += 1;
    }
    printf ("\nDigite o salario do funcionario %d: ", i);
    scanf ("%d", &salario);
    salariototal += salario;

    if (salario > maiorsalario){
      maiorsalario = salario;
    }
  }
  return maiorsalario; 
}
