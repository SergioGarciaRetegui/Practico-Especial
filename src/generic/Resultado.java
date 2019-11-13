package generic;

public class Resultado{
	String Campo;
	String ValorCampo;
	String CampoValor;
	Long Valor;
	public Resultado(String c,String vc,String cv,Long v) {
		this.Campo=c;
		this.ValorCampo=vc;
		this.CampoValor=cv;
		this.Valor=v;
	}
	public void setCampo(String c) {
		this.Campo=c;
	}
	public void setValor(Long v) {
		this.Valor=v;
	}
	public void setValorCampo(String c) {
		this.ValorCampo=c;
	}
	public void setCampoValor(String v) {
		this.CampoValor=v;
	}
	public String getValorCampo() {
		return this.ValorCampo;
	}
	public String getCampoValor() {
		return this.CampoValor;
	}
	public String getCampo() {
		return this.Campo;
	}
	public Long getValor() {
		return this.Valor;
	}

	@Override
	public String toString() {
		return "{"+this.Campo+ ": "+this.ValorCampo+" - "+this.CampoValor+": "+this.Valor+"}";
	}
}
