package exercicios;

public class SaidaConsole {

	public static void main(String[] args) {
		System.out.print("a");
	    System.out.println('b');
	    //System.out.print();      O método print não possui versão sem argumentos.
	    System.out.println("c"); 
	    
	    System.out.println("\n***********************************");
	    
	    System.out.print("a");
        System.out.println("b");
        System.out.printf("c");
        System.out.print("d");
        System.out.println("\n");
        System.out.print("e");
        
        System.out.println("\n***********************************");
        
        System.out.printf("%s\n",12); 
        System.out.printf("%d\n",new Integer(321));
        System.out.printf("%d",(short)(byte)(double) 127);
        
        System.out.println("\n***********************************");
        
        System.out.printf(">%-(8.2f<\n",12.45);
        System.out.printf(">%0,8.2f<\n",12.45);
        System.out.format(">%1$08.2f<\n",12.45);
        System.out.printf(">%0,(8.2f<\n",12.45);
        System.out.format(">%0(8.2f<",12.45);
        
        System.out.println("\n***********************************");
        
        System.out.println(new char[]{'a','b','c'}); // A
        System.out.println(new byte[]{'a','b','c'}); // B
        System.out.println("abc"); // C
        System.out.println(new String[]{"abc"}); // D
	}
}
