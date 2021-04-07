package com.company;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {

        int eleccion = -1;
        Scanner teclado = new Scanner(System.in);
        do {

            System.out.println("Bienvenido");
            System.out.println("----------------------");
            System.out.println("Elija la operacion a realizar");
            System.out.println("----------------------");
            System.out.println("1.-Convertir entero a binario8bits");
            System.out.println("----------------------");
            System.out.println("2.-Convertir binario8bits en entero");


            try {

                String entrada = teclado.nextLine();
                eleccion = Integer.parseInt(entrada);


                if (eleccion == 1) {

                    int numero = leerNumero();
                    imprimirNumBinario8bits(numero);

                } else if (eleccion == 2) {

                    ArrayList<String> binario = leerBinario();
                    imprimirNumEntero(binario);
                } else
                    System.out.println("Opcion invalida");

                System.out.println("¿Desea continuar?");
                System.out.println("------------------");
                System.out.println("Para salir, ingrese 0");
                eleccion = teclado.nextInt();

            }catch(Exception exception){

                System.out.println("¡Error!");
                System.out.println("------------------");
            }

            } while (eleccion != 0) ;
            System.out.println("Adios");
            System.out.println("------------------");

        }


        //Metodo para obtener un binario

        public static String obtenerBinario8bits ( int numero){

            StringBuilder binarioString = new StringBuilder();

            ArrayList<String> binario = intToBinary8bits(numero); //recuperamos el Arraylist del metodo IntToBinary

            for (int i = binario.size() - 1; i >= -0; i--) {

                binarioString.append(binario.get(i)); //guardamos los datos almacenados en el Arraylist, pero al reves
            }
            return binarioString.toString();
        }


        //Metodo para convertir un numero en binario

        public static ArrayList<String> intToBinary8bits ( int numero){

            ArrayList<String> binario = new ArrayList<>();

            int resto;
            do {

                resto = numero % 2;
                numero = (numero) / 2;

                binario.add(String.valueOf(resto)); //le agregamos el valor del resto al Arraylist

            } while (numero != 0);

            for (int i = binario.size(); i < 8; i++) {
                binario.add(String.valueOf(0));
            }
            return binario;
        }

        //Metodo para convertir un binario en entero

        public static int binary8bitsToInt (ArrayList < String > binario) {

            int entero = 0;

            for (int exponente = binario.size()-1; exponente >= 0; exponente--) {

                entero += Integer.parseInt(binario.get(binario.size()-1 - exponente)) * pow(2, exponente);
            }
            return entero;
        }

        //Metodo para validar que el numero este entre 0 y 255

        static boolean validarNumero ( int numero){

            return numero <= 255 && numero >= 0;
        }

        //Metodo para validar que el binario esté entre 00000000 y 11111111

        static boolean validarBinario8bits (ArrayList < String > binario) {

            for (String s : binario) {

                if (Integer.parseInt(s) != 0 && Integer.parseInt(s) != 1) {
                    return false;
                }
            }
            return binario.size() <= 8;
        }
    //Metodo para ingresar entero

    public static int leerNumero(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el numero entero");

        return teclado.nextInt();
    }

    //Metodo para ingresar binario8bits

    public static ArrayList<String> leerBinario() {

        ArrayList<String> binario = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el numero binario8bits");

        String binario8bits = teclado.nextLine();

       for (int i = 0; i < binario8bits.length(); i++) {
            binario.add(String.valueOf(binario8bits.charAt(i)));
        }
        return binario;
    }

    //Metodo que muestra en pantalla el numero binario8bits

    public static void imprimirNumBinario8bits(int numero){

        if (validarNumero(numero)) {
            System.out.println("------------------");
            System.out.println("El numero en binario es: " + obtenerBinario8bits(numero));
            return;
        }
            System.out.println("¡Error!");
    }

    //Metodo que muestra en pantalla el numero entero

    public static void imprimirNumEntero(ArrayList<String> binario){

        if (validarBinario8bits(binario)) {
            System.out.println("------------------");
            System.out.println("El numero en entero es: " + binary8bitsToInt(binario));
            return;
        }
            System.out.println("¡Error!");
    }
}

