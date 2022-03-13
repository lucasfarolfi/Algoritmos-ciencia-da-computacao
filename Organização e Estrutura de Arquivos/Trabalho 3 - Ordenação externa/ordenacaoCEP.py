from io import SEEK_SET
import os
import struct

# ----- Intercalação ----- #
def intercalacao(caminhof1, caminhof2,numeroArquivo ,v):
    f1 = open(caminhof1, "rb")
    f2 = open(caminhof2, "rb")

    # Cria o arquivo da intercalação
    novoArq = open(f"cep{numeroArquivo}-pt{v}.dat", "wb")
    print(f"Arquivo cep{numeroArquivo}-pt{v}.dat criado.")
    l1 = f1.read(tamLinha)
    l2 = f2.read(tamLinha)

    # Compara o cep dos 2 arquivos e armazena o menor no novo arquivo
    while ((len(l1) > 0 and len(l2) > 0)):
        e1 = registroCEP.unpack(l1)
        e2 = registroCEP.unpack(l2)
        cepf1 = e1[5]
        cepf2 = e2[5]

        if (cepf1 < cepf2):
            novoArq.write(registroCEP.pack(*e1))
            l1 = f1.read(tamLinha)
        else:
            novoArq.write(registroCEP.pack(*e2))
            l2 = f2.read(tamLinha)

    while (len(l1) > 0):
        e1 = registroCEP.unpack(l1)
        novoArq.write(registroCEP.pack(*e1))
        l1 = f1.read(tamLinha)
    while (len(l2) > 0):
        e2 = registroCEP.unpack(l2)
        novoArq.write(registroCEP.pack(*e2))
        l2 = f2.read(tamLinha)    
    
    novoArq.close()
    f1.close()
    f2.close()

# ----- Programa principal ----- #
registroCEP = struct.Struct("72s72s72s72s2s8s2s")
divisoes = int(input("Deseja dividir em quantos arquivos ?: "))
numeroArquivo = 1
tamLinha = registroCEP.size

# Total de linhas para cada arquivo
linhasPorArquivo = (os.stat("cep.dat").st_size // tamLinha) //divisoes 

f = open("cep.dat", "rb")

# Laço que cria e ordena os arquivos por numero de divisão
for x in range(1, divisoes + 1):
    f.seek((x - 1) *linhasPorArquivo * tamLinha, SEEK_SET)
    linha = f.readline(tamLinha)
    cont = 1
    ceps = []

    # Armazena as linhas do arquivo dividido no array
    while(cont <= linhasPorArquivo) and len(linha) > 0:
        endereco_linha = registroCEP.unpack(linha)
        ceps.append(endereco_linha)
        linha = f.read(tamLinha)
        cont += 1

    # Ordena os dados por ceps
    ceps.sort(key = lambda x: x[5])

    #Cria o arquivo dividido
    f2 = open(f"cep{x}-pt{numeroArquivo}.dat", "wb")

    #Escreve os ceps no arquivo
    for e in ceps: f2.write(registroCEP.pack(*e))
    f2.close()
    print(f"Arquivo cep{x}-pt{numeroArquivo}.dat criado.")

f.close()

# Faz 1 arquivo para juntar e ordenar dados de 2 arquivos divididos
while (divisoes != 1):
    novaDiv = 1
    cont = 1
    numeroArquivo2 = numeroArquivo+1
    while ( divisoes >= novaDiv):
        intercalacao(f"cep{novaDiv}-pt{numeroArquivo}.dat", 
        f"cep{novaDiv+1}-pt{numeroArquivo}.dat", 
        cont, 
        numeroArquivo2)

        novaDiv += 2
        cont+=1
    numeroArquivo += 1
    divisoes /= 2

print("\nStatus: Ceps ordenados com sucesso!")