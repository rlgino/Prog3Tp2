package modelo;

public class PuntoInteres {
	private int _id;
	private String _nombre;
	private double _cantCarbon;

	public PuntoInteres(int id, String nombre, double cantCarbon) {
		_id = id;
		_nombre = nombre;
		_cantCarbon = cantCarbon;
	}

	public int getId() {
		return _id;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String _nombre) {
		this._nombre = _nombre;
	}

	public double getCantCarbon() {
		return _cantCarbon;
	}

	public void setCantCarbon(double _cantCarbon) {
		this._cantCarbon = _cantCarbon;
	}
}
