package com.matrizes;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Usando Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho completo para o arquivo da primeira matriz (.txt ou .xlsx):");
        String caminhoArquivo1 = scanner.nextLine();
        
        System.out.println("Digite o caminho completo para o arquivo da segunda matriz (.txt ou .xlsx):");
        String caminhoArquivo2 = scanner.nextLine();

        try {
            // Carrega as matrizes dos arquivos usando o método auxiliar
            Matriz m1 = carregarMatrizDoArquivo(caminhoArquivo1);
            Matriz m2 = carregarMatrizDoArquivo(caminhoArquivo2);
            
            if (m1 == null || m2 == null) {
                // Se o carregamento falhar, a execução é interrompida.
                System.out.println("Não foi possível carregar uma ou ambas as matrizes. Verifique os caminhos e o formato dos arquivos.");
                return;
            }

            // Verificação de matrizes quadradas
            System.out.println("\n--- Verificação de Matrizes Quadradas ---");
            System.out.println("Matriz 1 (" + m1.getLinhas() + "x" + m1.getColunas() + ") é quadrada? " + m1.ehQuadrada());
            System.out.println("Matriz 2 (" + m2.getLinhas() + "x" + m2.getColunas() + ") é quadrada? " + m2.ehQuadrada());
            
            // Exibe as matrizes de entrada
            System.out.println("\n--- Matriz de Entrada 1 ---");
            m1.exibir();
            
            System.out.println("\n--- Matriz de Entrada 2 ---");
            m2.exibir();

            // Cria uma instância da classe Calculadora para realizar as operações
            Calculadora calc = new Calculadora();
            Matriz resultado = calc.multiplicarMatrizes(m1, m2);

            // Exibe a matriz resultante se a multiplicação for bem-sucedida
            if (resultado != null) {
                System.out.println("--- Matriz de Saída (Resultado da Multiplicação) ---");
                resultado.exibir();
            }

        } catch (IOException e) {
            // Captura e exibe erros de leitura de arquivo
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            // Garante que o Scanner seja fechado no final
            scanner.close();
        }
    }
    
    // Método auxiliar para carregar a matriz de acordo com a extensão do arquivo
    private static Matriz carregarMatrizDoArquivo(String caminho) throws IOException {
        // Verifica a extensão do arquivo para chamar o método de leitura correto
        if (caminho.toLowerCase().endsWith(".txt")) {
            return Matriz.lerDeArquivoTxt(caminho);
        } else if (caminho.toLowerCase().endsWith(".xlsx")) {
            return Matriz.lerDeArquivoXlsx(caminho);
        } else {
            throw new IOException("Formato de arquivo não suportado. Por favor, use .txt ou .xlsx.");
        }
    }
}