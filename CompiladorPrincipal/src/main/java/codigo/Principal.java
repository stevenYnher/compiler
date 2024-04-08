/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author steven
 */
public class Principal {
    public static void main(String[] args) throws Exception{
        // ruta del archivo lexer en donde se almacena las reglas.
        String ruta1 = "/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/src/main/java/codigo/lexer.flex";
        String ruta2 = "/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/src/main/java/codigo/lexerCup.flex";
        String[] rutaS = {"-parser","Sintax","/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/src/main/java/codigo/Sintax.cup"};
        generar(ruta1,ruta2,rutaS);
    }
    
    public static void generar(String ruta1,String ruta2, String[] rutaS) throws IOException, Exception{
        // aqui se genera el archivo lexer.flex en base al archivo proporcionado
        File archivo;
        
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/src/main/java/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        
        Files.move(
                Paths.get("/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/sym.java"),
                Paths.get("/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/src/main/java/codigo/sym.java")
        );
        
        Path rutaSin = Paths.get("/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/src/main/java/codigo/sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/sintax.java"),
                Paths.get("/Users/steven/Desktop/Cursos/Utesa/Compiladores/AnalizadorLexico/src/main/java/codigo/sintax.java")
        );
    }
}
