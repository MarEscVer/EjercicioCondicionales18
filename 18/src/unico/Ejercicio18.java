package unico;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

/* Escribe un programa que genere la nómina (bien desglosada) de un empleado según las siguientes condiciones:
 * Se pregunta el cargo del empleado (1 - Prog. junior, 2 - Prog. senior, 3 - Jefe de proyecto),
 * los días que ha estado de viaje visitando clientes durante el mes y su estado civil (1 - Soltero, 2 - Casado).
 * El sueldo base según el cargo es de 950, 1200 y 1600 euros según si se trata de un prog. junior, un prog.
 * senior o un jefe de proyecto respectivamente Por cada día de viaje visitando clientes se pagan 30 euros
 * extra en concepto de dietas. Al sueldo neto hay que restarle el IRPF, que será de un 25% en caso de estar
 * soltero y un 20% en caso de estar casado.
 * */
		
		final int JUNIOR = 950;
		final int SENIOR = 1200;
		final int JEFE = 1600;
		final int PRECIODIETA = 30;
		final int CASADO = 20;
		final int SOLTERO = 25;
		
		int cargo;
		int sueldoBase =0;
		int diasVisita;
		int dietas;
		int estadoCivil;
	    int irpf = 0;
	    int sueldoBruto;
	    double retencion;
	    double sueldoNeto;
		boolean valido = true;
	    
	    System.out.println("1. Programador junior ");
	    System.out.println("2. Programador senior ");
	    System.out.println("3. Jefe de proyecto \n ");
	    System.out.print("Introduza cargo del empleado (1-3): ");
	    cargo = Integer.parseInt(teclado.nextLine());

// Calcular sueldo base
	    switch (cargo){
	      case 1:
	        sueldoBase = JUNIOR;
	        break;
	      case 2:
	        sueldoBase = SENIOR;
	        break;
	      case 3:
	        sueldoBase = JEFE;
	        break;
	      default:
	    	  valido = false;
	        break;
	    }
	    
// Calcular extras al sueldo
	    System.out.print("¿Cuántos días ha estado visitando clientes?: ");
	    diasVisita = Integer.parseInt(teclado.nextLine());
	    dietas = diasVisita*PRECIODIETA;
	    System.out.print("Introduza su estado civil (1 (soltero) o 2 (casado)): ");
	    estadoCivil = Integer.parseInt(teclado.nextLine());

	    switch (estadoCivil){
	      case 1:
	        irpf = SOLTERO;
	        break;
	      case 2:
	        irpf = CASADO;
	        break;
	      default:
	    	  valido = false;
	        break;
	    }
	    
// Resultados en pantalla
	    if (valido == false){
	      System.out.println("Alguno de los datos introducidos no es válido");
	    } else {
	      sueldoBruto = sueldoBase + dietas;
	      retencion = (double)sueldoBruto*((double)irpf/100);
	      sueldoNeto = (double)sueldoBruto - retencion;
	      System.out.println("Sueldo base: " + sueldoBase);
	      System.out.println("Dietas (" + diasVisita + " viajes) viajes: " + dietas);
	      System.out.println("Sueldo bruto: " + sueldoBruto);
	      System.out.println("Retención IRPF(" + irpf + "%): " + retencion);
	      System.out.println("Sueldo neto: " + sueldoNeto);
	    }
	  }
	}