# Algoritmo que busca endereço pelo CEP utilizando Busca Binária
from io import SEEK_SET
import os
with open("cep_ordenado.dat", 'r') as file: # Arquivo aberto apenas dentro da função
    tamArquivo = os.stat("cep_ordenado.dat").st_size
    cep_busca = int(input("Digite o CEP para encontrar o endereço: "))

    def busca_binaria(inicio, fim, cep_busca):
        meio = (inicio + fim)//2
        file.seek(meio*300, SEEK_SET) #Move o cursor para o meio da linha

        linha = file.readline()
        cep = int(linha[290:298]) #Pega o CEP e faz cast para inteiro

        if cep == cep_busca:
            # Logradouro - Bairro - Municipio - Estado - CEP
            print(f'Endereço encontrado:\n\n'
                  f'{linha[0:71]}\n{linha[72:144]}\n{linha[144:216]}\n{linha[216:288]}\n{linha[288:298]}')

        elif inicio > fim:
            print("Este CEP não foi encontrado.")

        elif cep_busca < cep:
            busca_binaria(inicio, meio - 1, cep_busca)

        elif cep_busca > cep:
            busca_binaria(meio + 1, fim, cep_busca)

    busca_binaria(1, tamArquivo//300, cep_busca)

#Fim algoritmo