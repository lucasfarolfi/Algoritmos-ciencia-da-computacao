#include <iostream>
using namespace std;

//Melhor: o(1) |Pior: o(log n)
int BuscaBinaria(int vet[], int num, int inicio, int fim){
  int meio;

  if(inicio <= fim){

    meio = (fim+inicio)/2;

    if (num == vet[meio]){
      return meio;
    }
    else{

      if(num < vet[meio]){
        return BuscaBinaria(vet, num, inicio, meio-1);
      }
      else{
        return BuscaBinaria(vet,num, meio+1, fim);
      }
    }//fim else
    
  }//fim if
  
  return -1; //Quando o valor não for encontrado
}

int main() {
  int vet[] = {5, 10, 15, 20, 25};
  int Tam = 5, num, resultado;

  cout <<"Digite o numero a ser buscado:";
  cin >> num;

  resultado = BuscaBinaria(vet, num, 0, Tam);

  if (resultado != -1){
    cout << "O valor foi encontrado na posição " << resultado;
  }
  else{
    cout << "Valor não encontrado";
  }

  return 0;
}