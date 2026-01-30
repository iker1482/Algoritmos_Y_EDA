/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author ikerab
 */
public class ST_Pruebas {
    
    public static Paciente[] creaPacientesAleatorios(){
        Paciente[]pacientes= new Paciente[1000];
        Random aleatorio= new Random();
        for(int i=0;i<1000;i++){
            pacientes[i]= new Paciente("Paciente"+i,aleatorio.nextInt(10)+1);
        }
        return pacientes;
    }
    
    public static void main(String[]args) throws InterruptedException, IOException{
        
        double t_agregar=0; 
        double t_atender=0;
        double t_cambiarPrioridad=0;
        int i=0;
        int contAgregar=0;
        int contAtender=0;
        int contCambiarPrioridad=0;
        PrintWriter agregarWriter = new PrintWriter(new FileWriter("agregar_arbol.csv"));
        PrintWriter atenderWriter = new PrintWriter(new FileWriter("atender_arbol.csv"));
        PrintWriter cambioWriter = new PrintWriter(new FileWriter("cambio_arbol.csv"));
        double aleatorio;
        Paciente[]pacientes= creaPacientesAleatorios();
        ST_Arbol arbol = new ST_Arbol();
        System.out.println("ARBOL");
        
        while(i<pacientes.length){
            aleatorio=Math.random();
           // Thread.sleep(1000); Es el delay 
            if(aleatorio<=1.0/60){
                long inicio=System.nanoTime();
                arbol.alta(pacientes[i]);
                long fin= System.nanoTime();
                t_agregar+=(fin-inicio)/1000.0;
                i++;
                contAgregar++;
                agregarWriter.println(contAgregar+","+t_agregar+","+i);
                System.out.println("Agregar; t: "+t_agregar+"; n: "+contAgregar+"; p: "+i);
            }
            if(aleatorio<=1.0/120){
                long inicio=System.nanoTime();
                arbol.baja();
                long fin= System.nanoTime();
                t_atender+=(fin-inicio)/1000.0;
                contAtender++;
                atenderWriter.println(contAtender+","+t_atender+","+(i-1));
                System.out.println("Atender; t: "+t_atender+"; n: "+contAtender+"; p: "+i);
            }
            if(aleatorio<=1.0/180){
                long inicio=System.nanoTime();
                arbol.cambiarPrioridad(pacientes[i-1].getNombre(), new Random().nextInt(10)+1);
                long fin= System.nanoTime();
                t_cambiarPrioridad+=(fin-inicio)/1000.0;
                contCambiarPrioridad++;
                cambioWriter.println(contCambiarPrioridad+","+t_cambiarPrioridad+","+i);
                System.out.println("Cambio; t: "+t_cambiarPrioridad+"; n: "+contCambiarPrioridad+"; p: "+i);
            }
        }
        agregarWriter.close();
        atenderWriter.close();
        cambioWriter.close();

        double t_agregarL=0; 
        double t_atenderL=0;
        double t_cambiarPrioridadL=0;
        int j=0;
        int contAgregarL=0;
        int contAtenderL=0;
        int contCambiarPrioridadL=0;
        PrintWriter agregarWriterL = new PrintWriter(new FileWriter("agregar_lista.csv"));
        PrintWriter atenderWriterL = new PrintWriter(new FileWriter("atender_lista.csv"));
        PrintWriter cambioWriterL = new PrintWriter(new FileWriter("cambio_lista.csv"));
        double aleatorioL;
        ST_Lista lista = new ST_Lista();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("LISTA");
        
        while(j<pacientes.length){
            aleatorioL=Math.random();
            if(aleatorioL<=1.0/60){
                long inicio=System.nanoTime();
                lista.alta(pacientes[j]);
                long fin= System.nanoTime();
                t_agregarL+=(fin-inicio)/1000.0;
                j++;
                contAgregarL++;
                agregarWriterL.println(contAgregarL+","+t_agregarL+","+j);
                System.out.println("Agregar; t: "+t_agregarL+"; n: "+contAgregarL+"; p: "+j);
            }
            if(aleatorioL<=1.0/120){
                long inicio=System.nanoTime();
                lista.baja();
                long fin= System.nanoTime();
                t_atenderL+=(fin-inicio)/1000.0;
                contAtenderL++;
                atenderWriterL.println(contAtenderL+","+t_atenderL+","+j);
                System.out.println("Atender; t: "+t_atenderL+"; n: "+contAtenderL+"; p: "+j);
            }
            if(aleatorioL<=1.0/180){
                long inicio=System.nanoTime();
                lista.cambiarPrioridad(pacientes[j-1], new Random().nextInt(10)+1);
                long fin= System.nanoTime();
                t_cambiarPrioridadL+=(fin-inicio)/1000.0;
                contCambiarPrioridadL++;
                cambioWriterL.println(contCambiarPrioridadL+","+t_cambiarPrioridadL+","+j);
                System.out.println("Cambio; t: "+t_cambiarPrioridadL+"; n: "+contCambiarPrioridadL+"; p: "+j);
            }   
        }
        agregarWriterL.close();
        atenderWriterL.close();
        cambioWriterL.close();
    
    }
}