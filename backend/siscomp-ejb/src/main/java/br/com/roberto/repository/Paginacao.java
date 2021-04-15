package br.com.roberto.repository;

public class Paginacao<T> {

    private Integer totaRegistros;
    private Integer paginaAtual;
    private Integer totalRegistrosPorPagina;

    public Paginacao() {}

    public Paginacao(Integer totaRegistros, Integer paginaAtual, Integer registrosPorPagina) {
        this.totaRegistros = totaRegistros;
        this.paginaAtual = paginaAtual;
        this.totalRegistrosPorPagina = registrosPorPagina;
    }

    public Integer getTotaRegistros() {
        return totaRegistros;
    }

    public void setTotaRegistros(Integer totaRegistros) {
        this.totaRegistros = totaRegistros;
    }

    public Integer getTotalPaginas() {
        double valor = (this.totaRegistros%this.totalRegistrosPorPagina);
        if (valor >0) {
            return ((this.totaRegistros / this.totalRegistrosPorPagina) +1);
        }
        return ((this.totaRegistros / this.totalRegistrosPorPagina));
    }

    public Integer getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(Integer paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public Integer getTotalRegistrosPorPagina() {
        return totalRegistrosPorPagina;
    }

    public void setTotalRegistrosPorPagina(Integer totalRegistrosPorPagina) {
        this.totalRegistrosPorPagina = totalRegistrosPorPagina;
    }

    @Override
    public String toString() {
        return "Paginacao{" +
                "totaRegistros=" + totaRegistros +
                ", totalPaginas=" + this.getTotalPaginas() +
                ", paginaAtual=" + paginaAtual +
                ", totalRegistrosPorPagina =" + this.totalRegistrosPorPagina +
                '}';
    }
}
