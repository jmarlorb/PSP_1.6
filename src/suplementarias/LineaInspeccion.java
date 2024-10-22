package suplementarias;

import java.util.List;
import java.util.concurrent.Semaphore;

public class LineaInspeccion extends Thread {

	private String id;
	private Semaphore sem;
	private List<Vehiculo> cola;
	public LineaInspeccion(String id, Semaphore sem, List<Vehiculo> cola) {
		super();
		this.id = id;
		this.sem = sem;
		this.cola = cola;
	}
	
	public void run() {
		Vehiculo aux = null;
		try {
			while (true) {
			sem.acquire();
			if (!cola.isEmpty()) {
				aux = cola.remove(0);
				sem.release();
			} else {
				sem.release();
				break;
			}
			if (aux.getTipo()==VehiculoTipo.COCHE) {
				Thread.sleep(1000);
			} else if (aux.getTipo()==VehiculoTipo.MOTOCICLETA) {
				Thread.sleep(500);
			} else if (aux.getTipo()==VehiculoTipo.CAMION) {
				Thread.sleep(1500);
			} else if (aux.getTipo()==VehiculoTipo.AGRICOLA) {
				Thread.sleep(2000);
			}
			System.out.println("La línea de inspeción " + id + " ha inspeccionado el vehículo " + aux.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
