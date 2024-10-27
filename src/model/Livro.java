package model;

import java.time.LocalDate;

public class Livro {
    private String titulo;
    private String desc;
    private String autor;
    private LocalDate dataPublicacao;
    private Boolean disponivel = true;

    public Livro(String titulo, String desc, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.desc = desc;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDesc() {
        return desc;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }
}
