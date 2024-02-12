/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.File;


/**
 *
 * @author steven
 */
public class Principal {
    public static void main(String[] args){
        // ruta del archivo lexer en donde se almacena las reglas.
        String ruta = "/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/src/main/java/codigo/lexer.flex";
        generarLexer(ruta);
    }
    
    public static void generarLexer(String ruta){
        // aqui se genera el archivo lexer.flex en base al archivo proporcionado
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
