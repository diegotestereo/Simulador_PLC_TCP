import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
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
		        	     //System.out.println(InetAddress.getLocalHost().getHostAddress());
		        	 //    System.out.println(InetAddress.getLocalHost().getp());
		        	     System.out.println("********************************************************");
		                 System.out.println("************  Servidor esperando Cliente   *************");
		                 System.out.println("************                               *************");
		                 System.out.println("************    IP: "+InetAddress.getLocalHost().getHostAddress()+":5001     *************");
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
							Thread.sleep(250);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                  if (datos.equals("q")){
		                	  salida.println("exit");
		                	  exit=false;
		                  }
		                  if (exit){
		                  switch (datos.substring(0,2)) {
						case "a1":
							salida.println("t1v"+rnd.nextInt(1024));
							break;
						case "a2":
							salida.println("t2v"+rnd.nextInt(1024));
							break;
						case "a3":
							salida.println("h1v"+rnd.nextInt(1024));
							break;
						case "a4":
							salida.println("h2v"+rnd.nextInt(1024));
							break;
						case "r1":
							salida.println(datos);
							break;
						case "r2":
							salida.println(datos);
							break;
						case "r3":
							salida.println(datos);
							break;
						case "r4":
							salida.println(datos);
							break;
						case "r5":
							salida.println(datos);
							break;
						case "r6":
							salida.println(datos);
							break;
						case "r7":
							salida.println(datos);
							break;
						case "r8":
							salida.println(datos);
							break;
						default:
							salida.println("error: "+datos);
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
