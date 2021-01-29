#include <stdio.h>

int qtd_func (int qtdfuncionarios);

int main() {
  int qtdfuncionarios, qtdfuncionarias, salariototal;
  printf ("Digite a quantidade de funcionarios: ");
  scanf ("%d", &qtdfuncionarios);

  qtdfuncionarias = qtd_func (qtdfuncionarios);

  printf ("A empresa possui no total %d funcionaria(s) !!!", qtdfuncionarias);

  return 0;
}
int qtd_func (int qtdfuncionarios){
  int qtdfuncionarias = 0;

  for (int i = 1; i <= qtdfuncionarios;i++){
    int sexo = 0, salario = 0;

    printf ("\nDigite o sexo do funcionario %d(1-Masc/2-Fem): ", i);
    scanf ("%d", &sexo);
    if (sexo == 1){
      qtdfuncionarias += 1;
    }
    printf ("\nDigite o salario do funcionario %d: \n", i);
    scanf ("%d", &salario);
    
  }
  return qtdfuncionarias; 
}
