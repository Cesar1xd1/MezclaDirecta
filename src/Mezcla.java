import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

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
	//===== IMPORTANTE =====
	//ES NECESARIO CREAR UN ARCHIVO EN LA RAIZ DEL PROYECTO CON EL NOMBRE "archivo.txt" y archivo2.txt
	public int[] archivos() {
		File archivo=new File("archivo.txt");
		FileReader fr=null;
		BufferedReader br=null;
		String fila="";
		String lista="";
		try {
		fr= new FileReader(archivo);
		br = new BufferedReader(fr);
		while((fila=br.readLine())!=null) {
			lista=lista+fila+",";
		}
		}catch(FileNotFoundException e) {
			System.out.println("Error el archivo no fue enconrado");
		}catch(IOException e) {

		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		String numerosS[]=lista.split(",");
		int numerosEnteros[]=new int[numerosS.length];
		for(int i=0;i<numerosS.length;i++) {
			numerosEnteros[i]=Integer.parseInt(numerosS[i]);
		}
		return numerosEnteros;
	}
	public void meterDatosOrdenadosArchivo(int vector[]) {
		FileWriter fw=null;
		PrintWriter pw=null;
		try {
			fw=new FileWriter("archivo2.txt",false);

			pw=new PrintWriter(fw);
			for(int i=0;i<vector.length;i++) {
				pw.println(vector[i]);
			}
			System.out.println("Datos Ordenados y Actualizados en el Archivo");
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}finally {
			pw.close();
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void mezclaNatural(int[] vector) {
		int izquierda =0;
		int izq =0;
		int derecha = vector.length-1;
		int der = derecha;
		boolean ordenado = false;
		do {
			ordenado = true;
			izquierda = 0;
			while(izquierda<derecha) {
				izq =izquierda;
				while(izq < derecha && vector[izq]<=vector[izq+1]) {
					izq++;
				}
				der = izq +1;
				while(der==derecha-1 || der<derecha && vector[der]<=vector[der+1]) {
					der++;
				}
				if(der<=derecha) {
					mezclaDirecta2(vector);
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
		int [] v = o.archivos();
		System.out.println("Numeros desordenados: " + Arrays.toString(v));
		o.mezclaNatural(v);
		System.out.println("Numeros Ordenados: " +Arrays.toString(v));
		o.meterDatosOrdenadosArchivo(v);
	}

}
