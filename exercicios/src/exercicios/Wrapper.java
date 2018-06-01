package exercicios;

public class Wrapper {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//Criando wrappers
		Double d1 = new Double(22.5);  
		Double d2 = new Double("22.5");
		// Double d2 = new Double("abc"); throws NumberFormatException
		
		Character c = new Character('d');
		
		Boolean b1 = new Boolean(true);   // true
		Boolean b2 = new Boolean("true"); // true
		Boolean b3 = new Boolean("TrUe"); // true
		Boolean b4 = new Boolean("T");    // false
		
		
		//Convertendo de ::wrappers:: para primitivos
		Long l = new Long("123");

		byte b = l.byteValue();
		double d = l.doubleValue();
		int i = l.intValue();
		short s = l.shortValue();
		
		boolean b5 = new Boolean("true").booleanValue();
		char c1 = new Character('z').charValue();
		
		//Convertendo de String para ::wrappers:: ou primitivos
		Double d4 = Double.parseDouble("23.4"); //Autobox
		double d3 = Double.parseDouble("23.4");
		long l1 = Long.parseLong("23");
		int i1 = Integer.parseInt("444");
		short i7 = Short.parseShort("11",10); // 11  Decimal
		int i2 = Integer.parseInt("11",16);   // 17  HexaDecimal
		byte i3 = Byte.parseByte("11",8);     // 9   Octal
		int i4 = Integer.parseInt("11",2);    // 3   Binary
		int i5 = Integer.parseInt("A",16);    // 10  HexaDecimal
		int i6 = Integer.parseInt("FF",16);   // 255 HexaDecimal
		
		Double d5 = Double.valueOf("23.4");
		Long l2 = Long.valueOf("23");
		Integer i8 = Integer.valueOf("444");        
		Integer i9 = Integer.valueOf("5AF", 16);
		int i10 = Integer.valueOf("5AF", 16); //Autobox
		
		//JAVA 1.4
		Integer intWrapper = Integer.valueOf(1);
		int intPrimitive = intWrapper.intValue();
		intPrimitive++;
		intWrapper = Integer.valueOf(intPrimitive);
		
		// JAVA 5 Autobox
		Integer intWrapper2 = Integer.valueOf(1);
		intWrapper2++;
		
		// Comparando ::wrappers::
		Integer i11 = 1234;
		Integer i12 = 1234;
		System.out.println(i11 == i12);      //false
		System.out.println(i11.equals(i12)); //true
		
		//cache
		Integer i13 = 123;
		Integer i14 = 123;
		System.out.println(i13 == i14);      //true
		System.out.println(i13.equals(i14)); //true
		
		// short s2 = Integer.parseInt("23").shortValue(); ERRO DE COMPILAÇÃO
		Integer i15 = Integer.parseInt("23");
		short s2 = i15.shortValue();
		
		short s3 = Integer.valueOf("23").shortValue();
		
		int a = Integer.parseInt("10", 2);
        int b6 = a == 10 ? null : 3;
        System.out.println(a + b6);
		
	}
}
