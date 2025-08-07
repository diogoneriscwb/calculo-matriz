package com.matrizes;

public class Calculadora {

    // Função de soma de dois números
    public int somar(int a, int b) {
        return a + b;
    }

    // Função de multiplicação de dois números
    public int multiplicar(int a, int b) {
        return a * b;
    }

    // Função para multiplicar duas matrizes
    public Matriz multiplicarMatrizes(Matriz m1, Matriz m2) {
        // Validação: o número de colunas da primeira matriz deve ser igual ao número de linhas da segunda
        if (m1.getColunas() != m2.getLinhas()) {
            System.out.println("Erro: O número de colunas da primeira matriz não é igual ao número de linhas da segunda. A multiplicação não é possível.");
            return null;
        }

        int linhasResultado = m1.getLinhas();
        int colunasResultado = m2.getColunas();
        Matriz resultado = new Matriz(linhasResultado, colunasResultado);
        
        System.out.println("\n--- Passo a passo da multiplicação ---");
        // Loop para percorrer cada célula da matriz resultante
        for (int i = 0; i < linhasResultado; i++) {
            for (int j = 0; j < colunasResultado; j++) {
                int soma = 0;
                System.out.print("Cálculo do elemento [" + i + "][" + j + "]: ");
                // Loop para calcular a soma do produto (produto interno)
                for (int k = 0; k < m1.getColunas(); k++) {
                    int produto = multiplicar(m1.getElemento(i, k), m2.getElemento(k, j));
                    soma = somar(soma, produto);
                    System.out.print("(" + m1.getElemento(i, k) + " * " + m2.getElemento(k, j) + ")");
                    if (k < m1.getColunas() - 1) {
                        System.out.print(" + ");
                    }
                }
                resultado.setElemento(i, j, soma);
                System.out.println(" = " + soma);
            }
        }
        System.out.println("-------------------------------------\n");
        return resultado;
    }
}