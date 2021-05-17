public class Dado {
   //Atributos
   private int dado=(int)(Math.random()*(6-1+1)+1);
   //Constructor
   public Dado(){
       
   }
   //get
   public int getDado(){
       return dado;
   }
   //Métodos necesarios para la ejecución
   public void lanzarDado(){
       System.out.println("El valor del dado es " + dado);
   }
}