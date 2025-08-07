package com.matrizes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Matriz {
    private int[][] dados;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = new int[linhas][colunas];
    }

    // Getters para acessar as propriedades da matriz
    public int getLinhas() { return linhas; }
    public int getColunas() { return colunas; }
    public int getElemento(int i, int j) { return dados[i][j]; }

    public void setElemento(int i, int j, int valor) {
        this.dados[i][j] = valor;
    }

    // Método para ler uma única matriz de um arquivo .txt
    public static Matriz lerDeArquivoTxt(String caminhoArquivo) throws IOException {
        List<String> linhasArquivo = Files.readAllLines(Paths.get(caminhoArquivo));
        List<List<Integer>> dadosTemporarios = new ArrayList<>();

        for (String linha : linhasArquivo) {
            String[] elementos = linha.trim().split("\\s+"); // Separa os números por espaço
            List<Integer> linhaNumeros = new ArrayList<>();
            for (String elemento : elementos) {
                linhaNumeros.add(Integer.parseInt(elemento));
            }
            dadosTemporarios.add(linhaNumeros);
        }
        // Cria a matriz a partir dos dados lidos
        return criarMatriz(dadosTemporarios);
    }
    
    // Método para ler uma única matriz de uma aba de arquivo .xlsx
    public static Matriz lerDeArquivoXlsx(String caminhoArquivo) throws IOException {
        FileInputStream arquivo = new FileInputStream(new File(caminhoArquivo));
        Workbook workbook = new XSSFWorkbook(arquivo);
        Sheet sheet = workbook.getSheetAt(0); // Assume que a matriz está na primeira aba
        
        List<List<Integer>> dadosTemporarios = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            List<Integer> linhaNumeros = new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                // Assumimos que as células contêm números inteiros
                linhaNumeros.add((int) cell.getNumericCellValue());
            }
            dadosTemporarios.add(linhaNumeros);
        }
        
        workbook.close();
        arquivo.close();
        
        return criarMatriz(dadosTemporarios);
    }
    
    // Método privado auxiliar para criar a matriz a partir de uma lista de listas
    private static Matriz criarMatriz(List<List<Integer>> dados) {
        if (dados.isEmpty()) {
            return new Matriz(0, 0);
        }
        int linhas = dados.size();
        int colunas = dados.get(0).size();
        Matriz novaMatriz = new Matriz(linhas, colunas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                novaMatriz.setElemento(i, j, dados.get(i).get(j));
            }
        }
        return novaMatriz;
    }
    
    // Método para verificar se a matriz é quadrada (linhas == colunas)
    public boolean ehQuadrada() {
        return linhas == colunas;
    }

    // Método para exibir a matriz no console
    public void exibir() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(dados[i][j] + "\t");
            }
            System.out.println();
        }
    }
}