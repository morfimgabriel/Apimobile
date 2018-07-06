package com.mobile.api.model.entities;

public class Shopping {
	
	private Integer id;
	private String nome;
	private String endereco;
	private Double rating;
	
	public Shopping(Integer id, String nome, String endereco, Double rating) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.rating = rating;
	}

	public Shopping() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
}
