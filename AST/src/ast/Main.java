package ast;

import java.io.Console;
import java.io.File;
import java.util.Scanner;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class Main {
	public static String path = "E:\\\\ASTdata\\\\test";
	public static String path2;
	
	private static String readDataFromConsole(String prompt) {
		    Console console = System.console();
		    if (console == null) {
		      throw new IllegalStateException("Console is not available!");
		    }
		    return console.readLine(prompt);
		  }

	public Main(String path1) {
		CompilationUnit comp = GenAST.getCompilationUnit(path1);
		ASTNodeVisitor visitor = new ASTNodeVisitor();
		comp.accept(visitor);
	}
	public static void main(String[] args) throws Exception { 
		path = readDataFromConsole("Please input Java file path:");
	    //System.out.println("The information from console:" + path);

		path2 = readDataFromConsole("Please input Result out path:");
	    //System.out.println("The information from console:" + path2);
		File file1=new File(path);
	   	 if(file1.exists()) {
	   		 File[] sf=file1.listFiles();
	   		 for(int i =0;i<sf.length;i++) {
	   			if(file1.isDirectory()) {
	   				new Main(sf[i].getPath());
	   				System.out.println(sf[i].getPath());
	   			}
	   			 }
	      } 
	}
	
	
	
}
