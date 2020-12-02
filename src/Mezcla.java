
import java.util.Arrays;


class Ordenador{
	public int[] mezclaDirecta (int[] vector) {
		int i,j,k;
		if(vector.length>1) {
			int nElementosIzquierda = vector.length/2;
			int nElementosDerecha = vector.length - nElementosIzquierda;
			int vectorI[] = new int [nElementosIzquierda];
			int vectorD[] = new int [nElementosDerecha];
			
			for (i = 0; i < nElementosIzquierda; i++) {
				vectorI[i]=vector[i];
			}
			
			for (i = nElementosIzquierda; i < nElementosIzquierda+nElementosDerecha; i++){
				vectorD[i-nElementosIzquierda] = vector[i];
			}
			vectorI = mezclaDirecta(vectorI);
			vectorD = mezclaDirecta(vectorD);
			i=0;
			j=0;
			k=0;
			while(vectorI.length!=j && vectorD.length!=k) {
				if(vectorI[j]<vectorD[k]) {
					vector[i]=vectorI[j];
					i++;
					j++;
				}else {
					vector[i]=vectorD[k];
					i++;
					k++;
				}//Else
			}//While	
			while(vectorI.length!=j) {
				vector[i] = vectorI[j];
				i++;
				j++;
			}
			while(vectorD.length!=k) {
				vector[i] = vectorD[k];
				i++;
				k++;
			}	
		}
		return vector;
	}
	//MezclaDirecta2
	public void mezclaDirecta2 (int[] vector) {
		int i,j,k;
		if(vector.length>1) {
			int nElementosIzquierda = vector.length/2;
			int nElementosDerecha = vector.length - nElementosIzquierda;
			int vectorI[] = new int [nElementosIzquierda];
			int vectorD[] = new int [nElementosDerecha];
			
			for (i = 0; i < nElementosIzquierda; i++) {
				vectorI[i]=vector[i];
			}
			
			for (i = nElementosIzquierda; i < nElementosIzquierda+nElementosDerecha; i++){
				vectorD[i-nElementosIzquierda] = vector[i];
			}
			vectorI = mezclaDirecta(vectorI);
			vectorD = mezclaDirecta(vectorD);
			i=0;
			j=0;
			k=0;
			while(vectorI.length!=j && vectorD.length!=k) {
				if(vectorI[j]<vectorD[k]) {
					vector[i]=vectorI[j];
					i++;
					j++;
				}else {
					vector[i]=vectorD[k];
					i++;
					k++;
				}//Else
			}//While
				
			while(vectorI.length!=j) {
				vector[i] = vectorI[j];
				i++;
				j++;
			}
			while(vectorD.length!=k) {
				vector[i] = vectorD[k];
				i++;
				k++;
			}	
		}
	}
	
	public void mezclaNatural(int[] numeros) {
		int izquierda =0;
		int izq =0;
		int derecha = numeros.length-1;//Sin el error de nullPointerExepcion
		int der = derecha;
		boolean ordenado = false;
		do {
			ordenado = true;
			izquierda = 0;
			while(izquierda<derecha) {
				izq =izquierda;
				while(izq < derecha && numeros[izq]<=numeros[izq+1]) {
					izq++;
				}
				der = izq +1;
				while(der==derecha-1 || der<derecha && numeros[der]<=numeros[der+1]) {
					der++;
				}
				if(der<=derecha) {
					mezclaDirecta2(numeros);
					
					ordenado = false;
				}
				izquierda=izq;
				
			}
		}while(!ordenado);	
	}	
}
public class Mezcla {

	public static void main(String[] args) {
		Ordenador o = new Ordenador();
		int []numeros = {20,35,2,12,56,19,1,34,5,18,23,96,7,5,6}; 
		System.out.println("Numeros desordenados: " + Arrays.toString(numeros));
		o.mezclaNatural(numeros);
		System.out.println("Numeros Ordenados: " +Arrays.toString(numeros));
		
	}

}
