   public class PrintTriangle{


   public static void main(String[] args) {    
      PrintTriangle(10);
      
   }

   public static void PrintTriangle(int N){
   	for(int i = 1;i < N; i++){
         for(int j = 0; j < i; j++){
            System.out.print("*");
         }
         System.out.print("\n");
      }
   }
}
