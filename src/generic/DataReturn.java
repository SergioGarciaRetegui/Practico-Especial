package generic;

/**
 * Clase generica para contener resultados de distintas consultas a devolver
 * contiene dos atributos:
 * 
 * int value: Contendra un resultado numerico de la consulta.
 * String string: Contendra el identificador que identifica lo que representa el valor entero.
 * 
 */
public class DataReturn {
	private int value;
    private String string;
    public DataReturn() {
    	
    }
    public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	@Override
	public String toString() {
		return "data [value=" + value + ", string=" + string + "]";
	}
}
