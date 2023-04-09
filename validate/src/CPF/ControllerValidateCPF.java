package CPF;

import java.util.Arrays;

class ControllerValidateCPF {
	
	static boolean isValideCPF(String stringCPF) {
		
		stringCPF = stringCPF.replaceAll("[\\D]", "");
		
		int tam = stringCPF.length();
		
		if(tam!= 11 && tam != 14) return false;
		
		byte numsCPF[] = stringCPF.getBytes();
		
		for(int c =0; c < numsCPF.length; numsCPF[c++] -= 48);
		
		return calcDvCPF(numsCPF,1) == numsCPF[tam-2] && calcDvCPF(numsCPF,2) == numsCPF[tam-1];
	}
	
	static int calcDvCPF(byte array[],int position) {
		
		int soma = 0;
		
		int fimConta = array.length - (2/position);
		
		for(byte c = 0; c < fimConta; c++) soma += array[c]*(fimConta+1-c);
		
		int dv = (soma*10) %11%10;
		
		System.out.printf("Array: %s soma DV: %d DV %d \n",Arrays.toString(array),soma,dv);
		
		return dv;
	}

}
