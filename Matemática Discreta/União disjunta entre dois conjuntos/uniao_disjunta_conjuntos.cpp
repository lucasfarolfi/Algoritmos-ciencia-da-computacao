#include <iostream>

using namespace std;

int main() {

  //Tamanho de cada array (conjunto)
  int tam_A = 6, tam_B = 7, indice_U = 0, indice_intersec = 0; 

  //Conjunto A, B, união disjunta e intersecção
  int A[] = {5, 2, 4, 9, 10, 6} , B[] = {9, 4, 3, 7, 10, 11, 13}, uniao_disj[tam_A + tam_B], intersec[tam_A + tam_B];

  //Serve como ponto de parada do programa nos laços de repetição
  bool elementoIgual = true;

  //Compara o conjunto A com o conjunto B para achar a intersecção
  for(int i = 0; i < tam_A; i++){   
    for(int j = 0; j < tam_B; j++){
      
      //Se algum elemento de A é igual ao de B, este elemento será passado de A para a intersecção
      if(A[i] == B[j]){ 
        intersec[indice_intersec] = A[i];
        indice_intersec++; 
      }
    }
  }

  //Compara o conjunto A com a intersecção
  for(int i = 0; i < tam_A; i++){ 
    for(int j = 0; j < indice_intersec; j++){ 

      //Se for igual, o elementoIgual irá para falso
      if(A[i] == intersec[j]){
        elementoIgual = false;   
      }
    }

    //Se o elemento do conjunto A não estiver na intersecção, então o vetor da união disjunta receberá o valor do conjunto A
    if(elementoIgual == true){
      uniao_disj[indice_U] = A[i];
      indice_U++;   
    }

    //Reseta o elementoIgual
    elementoIgual = true;
  }  

  //Compara o conjunto B com a intersecção
  for(int i = 0; i < tam_B; i++){ 
    for(int j = 0; j < indice_intersec; j++){ 
          
      //Se for igual, o elementoIgual irá para falso
      if(B[i] == intersec[j]) {
        elementoIgual = false;
      }
    }

    //Se o elemento do conjunto B não estiver na intersecção, então o vetor união disjunta receberá o valor do conjunto B
    if(elementoIgual == true){
      uniao_disj[indice_U] = B[i];
      indice_U++; 
    }

    //Reseta o elementoIgual
    elementoIgual = true;    
  }
  
  //Saída: Conjunto A ⊕ B
  for(int i = 0; i < indice_U; i++){
    
    if(i == 0){
      cout << "\nA ⊕  B = { " << uniao_disj[i] << ", ";
    }
    else if(i == indice_U - 1){
      cout << uniao_disj[i] << " }";
    }
    else{
      cout << uniao_disj[i] << ", ";
    }
  }

} //fim