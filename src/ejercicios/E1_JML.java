package ejercicios;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import suplementarias.LineaInspeccion;
import suplementarias.Vehiculo;
import suplementarias.VehiculoTipo;

public class E1_JML {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		Vehiculo aux;
		ArrayList<Vehiculo> colaITV = new ArrayList<Vehiculo>();
		int vehiculosEnCola = 24;
		int tipoVehiculo;
		for (int i = 0; i<vehiculosEnCola; i++) {
			tipoVehiculo = (int)(Math.random()*3 + 1);
			switch (tipoVehiculo) {
			case 1:
				aux = new Vehiculo("CO-"+i,VehiculoTipo.COCHE);
				break;
			case 2:
				aux = new Vehiculo("MO-"+i, VehiculoTipo.MOTOCICLETA);
				break;
			case 3:
				aux = new Vehiculo("CA-"+i,VehiculoTipo.CAMION);
				break;
			default:
				aux = new Vehiculo("ERROR EN EL RANDOM",VehiculoTipo.AGRICOLA);
				break;
			}
			colaITV.add(aux);
		}
		LineaInspeccion li1 = new LineaInspeccion("LIN-1", sem, colaITV);
		li1.start();
		
		try {
			li1.join();
			System.out.println("La inspección de todos los vehiculos ha terminado.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
