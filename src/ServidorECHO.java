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
	 static final String ID ="000";
	 
	 
	 public static void main(String args[]) {
		 Boolean Serv=true;
		
		 Random rnd = new Random();
		   try {
		          ServerSocket sk = new ServerSocket(5000);
		          while (Serv) { 
		        	     System.out.println();
		        	     //System.out.println(InetAddress.getLocalHost().getHostAddress());
		        	 //    System.out.println(InetAddress.getLocalHost().getp());
		        	     System.out.println("********************************************************");
		                 System.out.println("************  Servidor esperando Cliente   *************");
		                 System.out.println("************      ID:"+ID+"                   *************");
		                 System.out.println("************    IP: "+InetAddress.getLocalHost().getHostAddress()+":5000     *************");
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
		                 /*try {
							Thread.sleep(250);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
		                  if (datos.equals("q")){
		                	  salida.print("ID"+ID);
		                	  salida.println("ex");
		                	  exit=false;
		                  }
		                  if (exit){
		                	 // System.out.println("entro"+datos.substring(4,6));
		                  switch (datos.substring(4,6)) {
						
						case "r1":
							salida.print("ID"+ID);
							salida.println("r1v"+rnd.nextInt(2));
							break;
						case "r2":
							salida.print("ID"+ID);
							salida.println("r2v"+rnd.nextInt(2));
							break;
						case "r3":
							salida.print("ID"+ID);
							salida.println("r3v"+rnd.nextInt(2));
							break;
						case "r4":
							salida.print("ID"+ID);
							salida.println("r4v"+rnd.nextInt(2));
							break;
						case "r5":
							salida.print("ID"+ID);
							salida.println("r5v"+rnd.nextInt(2));
							break;
						case "r6":
							salida.print("ID"+ID);
							salida.println("r6v"+rnd.nextInt(2));
							break;
						case "r7":
							salida.print("ID"+ID);
							salida.println("r7v"+rnd.nextInt(2));
							break;
						case "r8":
							salida.print("ID"+ID);
							salida.println("r8v"+rnd.nextInt(2));
							break;
						case "te":
							int Tinf = 19 ;
							int Tsup = 25; 

							int TempFinal = (int)(Math.random()*(Tsup - Tinf) + Tinf); 
							salida.print("ID"+ID);
							salida.println("te"+String.valueOf(TempFinal));
							
						break;
						case "st":
						  
						   
							salida.print("ID"+ID);
							
							for (int i=1;i<5;i++){
								 String Svalor =String.valueOf(rnd.nextInt(1024));
									String padded = "0000".substring(Svalor.length()) + Svalor;
									salida.print("a"+i+"v"+padded);
								
							}
						
							salida.println("r1v"+rnd.nextInt(2)+"r2v"+rnd.nextInt(2)+
									"r3v"+rnd.nextInt(2)+"r4v"+rnd.nextInt(2)+"r5v"+rnd.nextInt(2)+
									"r6v"+rnd.nextInt(2)+"r7v"+rnd.nextInt(2)+"r8v"+rnd.nextInt(2));
							break;
						default:
							salida.println("ID000er"+datos.substring(4, 6));
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
