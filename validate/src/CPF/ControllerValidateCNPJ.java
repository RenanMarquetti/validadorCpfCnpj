package CPF;

import java.util.Arrays;

class ControllerValidateCNPJ {
	
	static boolean isValideCNPJ(String stringCNPJ) {
		
		stringCNPJ = stringCNPJ.replaceAll("[\\D]", "");
		
		int tam = stringCNPJ.length();
		
		if(tam != 14) return false;
		
		byte numsCNPJ[] = stringCNPJ.getBytes();
		
		for(int c =0; c < numsCNPJ.length; numsCNPJ[c++] -= 48);
		
		return calcDvCNPJ(numsCNPJ,1) == numsCNPJ[tam-2] && calcDvCNPJ(numsCNPJ,2) == numsCNPJ[tam-1];
	}
	
	static int calcDvCNPJ(byte array[],int position) {
		
		int soma = 0;
		
		int fimConta = array.length - (2/position);
		
		int inicio = 14 + (2/position);
		
		for(byte c = 0; c < fimConta; c++) soma += array[c]*(inicio--%10);
		
		int dv = (soma*10) %11%10;
		
		System.out.printf("Array: %s soma DV: %d DV %d \n",Arrays.toString(array),soma,dv);
		
		return dv;
	}

}
