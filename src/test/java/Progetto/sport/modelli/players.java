package Progetto.sport.modelli;

import java.sql.Date;

public class players {
	
	private String nome;
	private String cognome;
	private Date dataNascita;
	private int numeroMaglia;
	private int idTeam;
	private String ruolo;
	
	@Override
	public String toString() {
		return "Player [" + super.toString() + ", nome=" + nome + ", cognome=" + cognome + ", ruolo="
				+ ruolo + "]";
	}
		
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public int getNumeroMaglia() {
		return numeroMaglia;
	}
	public void setNumeroMaglia(int numeroMaglia) {
		this.numeroMaglia = numeroMaglia;
	}
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	

}
