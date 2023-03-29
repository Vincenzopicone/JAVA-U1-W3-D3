package model;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;


@Entity 
@Table(name="eventi")
@NamedQuery(name = "Eventi.findAll", query = "SELECT e FROM Eventi e")
public class Eventi implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(nullable = false)
	private String titolo;
	@Column(nullable = false)
	private LocalDate dataevento;
	@Column(nullable = false)
	private String descrizione;
	@Enumerated (EnumType.STRING)
	@Column(nullable = false)
	private TipoEvento tipoevento;
	@Column(nullable = false)
	private Integer numeromassimopartecipanti;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getDataEvento() {
		return dataevento;
	}
	public void setDataEvento(LocalDate dataEvento) {
		this.dataevento = dataEvento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public TipoEvento getTipoEvento() {
		return tipoevento;
	}
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoevento = tipoEvento;
	}
	public Integer getNumeroMassimoPartecipanti() {
		return numeromassimopartecipanti;
	}
	public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
		this.numeromassimopartecipanti = numeroMassimoPartecipanti;
	}
	@Override
	public String toString() {
		return "Eventi [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataevento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoevento + ", numeroMassimoPartecipanti=" + numeromassimopartecipanti + "]";
	}
	
	

}
