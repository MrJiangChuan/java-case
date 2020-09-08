package com.jc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        PrintStream pt = new PrintStream("d.txt");
        System.setOut(pt);
        System.out.println( "Hello World!" );


    }
}
