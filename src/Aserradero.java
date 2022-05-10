import java.util.*;
public class Aserradero {
	int coste[];
    int ganancia[];
    int resultado[];
    public Aserradero(int coste[]){
    	this.coste=coste;
    	ganancia=new int[coste.length];
    	resultado=new int[coste.length];
    	for(int i=0;i<coste.length;++i){
    		ganancia[i]=0;
    	    resultado[i]=0;
    	}
    }
    public int analisisrecursivo(int longitud){
    	if(longitud<1)
    		return 0;
    	if(ganancia[longitud]>0)
    		return ganancia[longitud];
    	for(int i=longitud;i>=1;--i){
    		int maximo=Integer.MIN_VALUE;
    		for(int k=1;k<=i;++k){
    			if(coste[k]+analisisrecursivo(i-k)>maximo){
        			maximo=coste[k]+analisisrecursivo(i-k);
        			ganancia[i]=maximo;	
        			resultado[i]=k;	
        		}
    		}
    	}
    	return ganancia[longitud];
    }
    
    public int analisisiterativo(){
    	ganancia[0]=0;
    	resultado[0]=0;
    	for(int i=1;i<this.ganancia.length;++i){
    		int maximo=Integer.MIN_VALUE;
    		for(int k=1;k<=i;++k){
        		if(coste[k]+ganancia[i-k]>maximo){
        			maximo=coste[k]+ganancia[i-k];
        			ganancia[i]=maximo;	
        			resultado[i]=k;	
        		}
        	}	
    	}
    	
    	return ganancia[ganancia.length-1];
    }
    public void resultadoiterativo(){
    	int longitud=ganancia.length-1;
    	for(int i=longitud;i>=1;){
    		System.out.println("Se corto un pedazo de longitude: "+resultado[i]+"." );
    		i-=resultado[i];
    	}
    }
    public static void main(String[] args) {
    	/*int longitud=0;
    	Scanner scaner=new Scanner(System.in);
     	System.out.println("Ingresa la longitud del tronco a cortar: ");
     	longitud=scaner.nextInt();
     	int coste[]=new int[longitud+1];
     	coste[0]=0;
     	for(int i=1;i<coste.length;++i){
     		System.out.println("Ingresa el coste de cortar un pedazo de longitud: "+i+ " ");
     		 coste[i]=scaner.nextInt();
     	}
     	Aserradero test=new Aserradero(coste);
     	int ganancia=test.analisisrecursivo(longitud);
     	test.resultadoiterativo();
     	System.out.println("la ganancia maxima es: "+ganancia);*/
    	int a=0,b=0;
    	boolean seguir=true;
    		for(int i=3;i<=99;){
    		a+=i;
    		i+=4;
    		}
    		for(int i=1;i<=97;){
        		b+=i;
        		i+=4;
        		}
    		System.out.println(a-b);
    		
    			
    }
}
