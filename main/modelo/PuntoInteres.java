package modelo;

public class PuntoInteres {
	private int _id;
	private String _nombre;
	private int _cantCarbon;

	public PuntoInteres(int id, String nombre, int cantCarbon) {
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

	public int getCantCarbon() {
		return _cantCarbon;
	}

	public void setCantCarbon(int _cantCarbon) {
		this._cantCarbon = _cantCarbon;
	}
}
