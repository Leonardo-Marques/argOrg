package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner ler = new Scanner("orgArq");
        String nome = ler.nextLine();
        Cache1 cache1 = new Cache1();
        Cache2 cache2 = new Cache2();
        CacheA1 cacheA1 = new CacheA1();
        CacheA2 cacheA2 = new CacheA2();
        ArrayList<String> teste = new ArrayList<>();
        HashSet<String> teste2 = new HashSet<>();
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {
                //linha.substring(0,10)tag
                //System.out.println(linha.substring(10,14));//linha
                //linha.substring(14,16)palavra
                cache1.add(linha.substring(10,14), linha.substring(0,10), linha.substring(14,16));
                cache2.add(linha.substring(10,15), linha.substring(0,10), linha.substring(15,16));
//                cacheA1.add(linha.substring(0,14),linha.substring(14,16));
//                cacheA2.add(linha.substring(0,15),linha.substring(15,16));
//                teste.add(linha.substring(0,15));
//                teste2.add(linha.substring(0,15));

                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println("hit c1: "+ cache1.getHit());
        System.out.println("miss c1: "+ cache1.getMiss());
        System.out.println(cache1.toString());

        System.out.println("hit c2: "+ cache2.getHit());
        System.out.println("miss c2: "+ cache2.getMiss());
        System.out.println(cache2.toString());

//        System.out.println("hit ca1: "+ cacheA1.getHit());
//        System.out.println("miss ca1: "+ cacheA1.getMiss());
//        //System.out.println(cacheA1.getCache().size());
//
//        System.out.println("hit ca2: "+ cacheA2.getHit());
//        System.out.println("miss ca2: "+ cacheA2.getMiss());
        //System.out.println(cacheA2.getCache());

//        for (int i = 0; i < 200; i++){
//            System.out.println(System.nanoTime());
//        }
        //System.out.println(teste.size() +" "+teste2.size());
    }
}
