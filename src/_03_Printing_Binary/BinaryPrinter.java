package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	public static void main(String[] args) {
		for (int i = 0; i < 256; i++) {
			printByteBinary((byte) i);
			System.out.println("");
		}
	}
	
	static public void printByteBinary(byte b) {
		byte one = (byte) (b&0b1);
		byte two  = (byte) ((byte) (b&0b10)>>1);
		byte three = (byte) ((byte) (b&0b100)>>2);
		byte four = (byte) ((byte) (b&0b1000)>>3);
		byte five = (byte) ((byte) (b&0b10000)>>4);
		byte six = (byte) ((byte) (b&0b100000)>>5);
		byte seven = (byte) ((byte) (b&0b1000000)>>6);
		byte eight = (byte) ((byte) (b&0b10000000)>>7);
		if(eight == -1) {eight = 1;}
		System.out.print(eight+""+seven+""+six+""+five+""+four+""+three+""+two+""+one);
	}
	
	static public void printShortBinary(short s) {
		byte top = (byte) (s>>8);
		byte bottom = (byte) (s&0b11111111);
		printByteBinary((byte) top);
		printByteBinary((byte) bottom);
	}
	
	static public void printIntBinary(int i) {
		short top = (short) (i>>16);
		short bottom = (short) (i&0b1111111111111111);
		printShortBinary((short) top);
		printShortBinary((short) bottom);
	}
	
	static public void printLongBinary(long l) {
		int top = (int) (l>>32);
		int bottom = (int) (l&0b111111111111111111111111);
		printIntBinary((int) top);
		printIntBinary((int) bottom);
	}
}
