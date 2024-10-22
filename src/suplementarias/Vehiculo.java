package suplementarias;

public class Vehiculo {

	private String id;
	private VehiculoTipo tipo;
	public Vehiculo(String id, VehiculoTipo tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public VehiculoTipo getTipo() {
		return tipo;
	}
	public void setTipo(VehiculoTipo tipo) {
		this.tipo = tipo;
	}
	
	
}
