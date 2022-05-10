import java.util.*;
public class Mochila {
    int peso[];
    int valor[];
    int vresultado[][];
    int resultado[][];
    public Mochila(int n,int p){
      Scanner scan=new Scanner(System.in);
      peso=new int[n+1];
        valor=new int[n+1];
        vresultado=new int [n+2][p+1];
        resultado=new int [n+2][p+1];
        peso[0]=0;
        valor[0]=0;
    for(int i=1;i<peso.length;++i){
        System.out.println("Ingrese el peso de la mochila "+i+": ");
        peso[i]=scan.nextInt();
         System.out.println("Ingrese el valor de la mochila "+i+": ");
        valor[i]=scan.nextInt();
        }
     for(int j=0;j<resultado[0].length;++j){
         vresultado[n+1][j]=0;
         resultado[n+1][j]=0;
     }
     for(int y=0;y<resultado.length;++y){
         for(int z=0;z<resultado[0].length;++z){
        	 vresultado[y][z]=0;
             resultado[y][z]=0;
         }
         }
        	 
    }
     public int valoriterativo(int n,int p){
         int maximo=0,maximo1=0;
         for(int i=n;i>=1;--i){
         for(int j=1;j<=p;++j){
        	 vresultado[i][j]=vresultado[i+1][j];
        	 resultado[i][j]=0;
             if(j>= peso[i]){
                 maximo1=valor[i]+vresultado[i+1][j-peso[i]];
                 if(maximo1>vresultado[i][j]){
                     vresultado[i][j]=maximo1;
                     resultado[i][j]=1;
             }
                 
             }
                     }
         }
     return vresultado[1][p];
     }
     public void visuaizadatos(int n,int p){
    	 for(int i=n;i>=1;--i){
             for(int j=1;j<=p;++j){
            System.out.print(vresultado[i][j]+ " ");
             }
             System.out.println();
    	 }
             }
    	 
     
     
     public int maxvalorrecursivo(int n,int p){
    	
    	 if(n<1||p<=0){
    		 
    		 return 0;
    	 }
    		
    	if( vresultado[n][p]>0)
    		 return vresultado[n][p];
    	 vresultado[n][p]=maxvalorrecursivo(n-1,p);
    	 if(p>= peso[n]){
             int maximo1=valor[n]+maxvalorrecursivo(n-1,p-peso[n]);
             if(maximo1>vresultado[n][p]){
                 vresultado[n][p]=maximo1;
                 resultado[n][p]=1;
         }
    	 }
    	 
    	 return  vresultado[n][p];
     }
     public void resultadorecursivo(int n,int p){
     	System.out.println("los objetos elegidos son: ");
     	 for(int i=n;i>=1;--i){
     		 if(p>=0&&resultado[i][p]==1){
     		 p-=peso[i];
     		 System.out.println("el objeto numero: "+i +" con peso: "+peso[i]+ " y con valor"+valor[i]);
     		 }
     	 }
     	
     }
     
    public void resultado(int n,int p){
    	System.out.println("los objetos elegidos son: ");
    	 for(int i=1;i<=n;++i){
    		 if(p>=0&&resultado[i][p]==1){
    		 p-=peso[i];
    		 System.out.println("el objeto numero: "+i +" con peso: "+peso[i]+ " y con valor"+valor[i]);
    		 }
    	 }
    	
    }
        // TODO code application logic here
  public static void main(String[] args) {
        // TODO code application logic here
    int n,p;
    Scanner scan=new Scanner(System.in);
     System.out.println("Ingrese el numero de elementos:");
     n=scan.nextInt();
     System.out.println("Ingrese el peso maximo:");
     p=scan.nextInt();
     Mochila test=new Mochila(n,p);
     /*int resultado=test.valoriterativo(n, p);
    System.out.println("el maximo valor es: "+resultado);
    test.resultado(n, p);*/
     System.out.println("el maximo valor es: "+test.valoriterativo(n, p));
     test.visuaizadatos(n, p);
     test.resultado(n, p);
    }
}
