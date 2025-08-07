# Calculadora de Matrizes

Este é um projeto acadêmico desenvolvido em Java para a disciplina de Programação Orientada a Objetos, que tem como objetivo a leitura, validação e multiplicação de duas matrizes.

## Sobre o Projeto

O software foi construído seguindo o paradigma de **Programação Orientada a Objetos** e utiliza o **Maven** como ferramenta de gerenciamento e automação de projeto. Ele permite ao usuário inserir o caminho para dois arquivos (`.txt` ou `.xlsx`) contendo matrizes e, em seguida, realiza a multiplicação, exibindo os resultados e o passo a passo do cálculo no terminal.

### Tecnologias Utilizadas

* **Linguagem de Programação:** Java
* **Gerenciador de Dependências:** Apache Maven
* **Biblioteca para leitura de `.xlsx`:** Apache POI
* **IDE:** Visual Studio Code

---

## 2. Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Maven, facilitando a navegação e a compreensão da sua organização.

```
calculo-matriz/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── matrizes/
                    ├── Main.java              # Ponto de entrada da aplicação
                    ├── Matriz.java            # Classe que representa o objeto Matriz e suas operações de leitura
                    └── Calculadora.java       # Classe com as funções de cálculo

```
---

## Como Utilizar (Para Outros Desenvolvedores)

Para compilar e executar o software em outro computador, siga os passos abaixo.

### Pré-requisitos

Certifique-se de que as seguintes ferramentas estão instaladas e configuradas em sua máquina:

* **Java Development Kit (JDK):** Versão 17 ou superior.
* **Apache Maven:** Versão 3.6.0 ou superior.

### 1. Clonar o Repositório

```bash
git clone <https://github.com/diogoneriscwb/calculo-matriz>
cd calculo-matriz
```    
### 2. Preparar os Arquivos de Entrada
Crie ou utilize arquivos ``.txt`` ou ``.xlsx`` com as matrizes que deseja multiplicar. A estrutura esperada para o arquivo .txt é uma matriz por linha, separada por espaços.

**Exemplo de** ``matriz1.txt:``
```
2 3
4 5
```

**Observação:** O software lê apenas a primeira aba de um arquivo .xlsx.

### 3. Compilar e Executar
Utilize os comandos do Maven no terminal, a partir da pasta raiz do projeto (calculo-matriz).

**Compilar e Empacotar o Projeto**
Este comando irá baixar todas as dependências (incluindo o Apache POI), compilar o código-fonte e empacotá-lo em um arquivo .jar.

```Bash

mvn clean install 
``` 
**Executar o Programa**
Após a compilação, execute o programa com o comando simplificado.


```Bash

mvn exec:java
```
O programa então exibirá as matrizes de entrada, a verificação se são quadradas, o passo a passo da multiplicação e a matriz resultante.                
