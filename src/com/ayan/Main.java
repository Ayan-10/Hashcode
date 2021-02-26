package com.ayan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static int D;
    static int I;
    static int S;
    static int V;
    static int F;
    static ArrayList<Integer> Input ;
    static ArrayList<obj> Output;
    static int score = 0;
    public static void main(String[] args) {
        String[] filename = {"a"};
        for(int i =0; i<filename.length; i++){
            getInputFromFile(filename[i]);
            Output = new ArrayList<>();
            ArrayList<String> srt1 = new ArrayList<>();
            srt1.add("rue-d-athenes 2");
            srt1.add("rue-d-amsterdam 1");
            obj bj1 = new obj(1,2,srt1);
            Output.add(bj1);
            ArrayList<String> srt2 = new ArrayList<>();
            srt2.add("rue-de-londres 2");
            obj bj2 = new obj(0,1,srt2);
            Output.add(bj2);
            ArrayList<String> srt3 = new ArrayList<>();
            srt3.add("rue-de-moscou 1");
            obj bj3 = new obj(2,1,srt3);
            Output.add(bj3);

            writeIntoFile(filename[i]);
        }
    }
    static void getInputFromFile(String fileName) {
        try {
            Input = new ArrayList<Integer>();

            BufferedReader fr = new BufferedReader(new FileReader("in\\" + fileName + ".txt"));
            String line, firstLine,sndline;
            firstLine = fr.readLine();
            String[] vars;
            vars = firstLine.split(" ");

            D = Integer.parseInt(vars[0]); // Maximum Pizza slices requires
            I = Integer.parseInt(vars[1]); // Number of Pizzas available
            S = Integer.parseInt(vars[2]); // Number of Pizzas available
            V = Integer.parseInt(vars[3]); // Number of Pizzas available
            F = Integer.parseInt(vars[4]); // Number of Pizzas available
            // Create the pizza list by reading the file
            System.out.println("-------input of " + fileName);
            System.out.println(D + " " + I+ " " + S+ " " + V+ " " + F);
            for(int i = 0;i<S; i++){
                line = fr.readLine();
                String letters[] = line.split(" ");
                int B = Integer.parseInt(letters[0]);
                int E = Integer.parseInt(letters[1]);
                String name = letters[2];
                int L = Integer.parseInt(letters[1]);
                System.out.print(B + " "+E+ " "+name+ " "+L);
                System.out.println();
            }
            for(int i = 0;i<V; i++){
                sndline = fr.readLine();
                String snd[] = sndline.split(" ");
                int P = Integer.parseInt(snd[0]);
                System.out.print(P+" ");
                String[] s = new String[P];
                for(int j=1; j<s.length+1; j++ ){
                    s[j-1]=snd[j];
                }
               for(int j=0; j<s.length; j++ ){
                   System.out.print(s[j]+" ");
               }
                System.out.println();
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void writeIntoFile(String fileName) {
        try {
            System.out.println("\n------- output " + fileName);
            PrintWriter outputFile = new PrintWriter("output\\" + fileName + ".out", "UTF-8");
            outputFile.println(Output.size());
            System.out.println(Output.size());
            for (int i = 0; i < Output.size(); i++) {
                outputFile.println(Output.get(i).in);
                outputFile.println(Output.get(i).srt);
                int n = Output.get(i).srt;
                for(int j=0; j<n; j++){
                    outputFile.println(Output.get(i).arr.get(j));
                }
                System.out.println(Output.get(i).in);
                System.out.println(Output.get(i).srt);
                for(int j=0; j<n; j++){
                    System.out.println(Output.get(i).arr.get(j));
                }
            }
            outputFile.close();
        } catch (Exception e) {
            System.err.println("" + e);
        }
    }
}
class obj{
    int in;
    int srt;
    ArrayList<String> arr;

    public obj(int in, int srt,ArrayList<String> arr) {
        this.in=in;
        this.srt=srt;
        this.arr = arr;
    }
}
