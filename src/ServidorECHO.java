import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorECHO {

	 public static void main(String args[]) {
		 Boolean Serv=true;
		 Random rnd = new Random();
		   try {
		          ServerSocket sk = new ServerSocket(5001);
		          while (Serv) { 
		        	     System.out.println();
		        	     System.out.println("********************************************************");
		                 System.out.println("***********   Servidor esperando Cliente   *************");
		                 System.out.println("********************************************************");
		                 System.out.println();
		                 Socket cliente = sk.accept();
		                 System.out.println();
		                 System.out.println("----------------   Ingreso Cliente   -------------------");
		                 System.out.println();
		               Boolean exit=true;
					do{
		                 BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		                 PrintWriter salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()),true);
		                
		                 String datos = entrada.readLine();
		                 try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                  if (datos.equals("q")){
		                	  salida.println("exit");
		                	  exit=false;
		                  }
		                  if (exit){
		                  switch (datos) {
						case "a1":
							salida.println("t1v"+rnd.nextInt(1024));
							break;
						case "a2":
							salida.println("t1v"+rnd.nextInt(1024));
							break;
						case "a3":
							salida.println("p1v"+rnd.nextInt(1024));
							break;
						case "a4":
							salida.println("p1v"+rnd.nextInt(1024));
							break;
						case "r1":
							salida.println("r1v"+rnd.nextInt(2));
							break;
						case "r2":
							salida.println("r2v"+rnd.nextInt(2));
							break;
						case "r3":
							salida.println("r3v"+rnd.nextInt(2));
							break;
						case "r4":
							salida.println("r4v"+rnd.nextInt(2));
							break;
						case "r5":
							salida.println("r5v"+rnd.nextInt(2));
							break;
						case "r6":
							salida.println("r6v"+rnd.nextInt(2));
							break;
						case "r7":
							salida.println("r7v"+rnd.nextInt(2));
							break;
						case "r8":
							salida.println("r8v"+rnd.nextInt(2));
							break;
						default:
							salida.println("Comando Desconocido");
							break;
						}
		                  }
		                      System.out.println("Movil: "+datos);
		                 }while(exit);
		                 cliente.close();
		                 System.out.println("------------  Cerro sesion Cliente !!!  --------------------");
		          }
		   } catch (IOException e) {
		          System.out.println(e);
		   }
		  }
	
	
}
