#include <iostream>
using namespace std;

/*void BuscaSequencial(int vet[], int num){ //Melhor: o(1)|Pior: o(n)
  bool numeroEncontrado = false;
  int i = 0;
  
  while(numeroEncontrado == false && i < Tam){

    if(vet[i] == num){
      numeroEncontrado = true;
      cout << "O número " << vet[i] << " foi encontrado.";
    }
    else i++;
  }

  if (numeroEncontrado == false){
    cout << "Valor não encontrado !!!";
  }

}
*/

int BuscaBinaria(int vet[], int num, int inicio, int fim){ //Melhor: o(1) |Pior: o(log n)
  int meio = (fim+inicio)/2;

  while(inicio <= fim){

    if (num == vet[meio]){
      return meio;
    }
    else{

      if(num < vet[meio]){
        fim = meio -1;
      }
      else{
        inicio = meio + 1;
      }
    }//fim else
    
    meio = (inicio + fim) / 2;
  }//fim while
  
  return -1; //Quando o valor não for encontrado
}

int main() {
  int vet[] = {5, 10, 15, 20, 25};
  int Tam = 5, num, resultado;

  cout <<"Digite o numero a ser buscado:";
  cin >> num;

  //BuscaSequencial(vet, num);
  resultado = BuscaBinaria(vet, num, 0, Tam);

  if (resultado != -1){
    cout << "O valor foi encontrado na posição " << resultado;
  }
  else{
    cout << "Valor não encontrado";
  }

  return 0;
}