package br.com.roberto.repository;

public class Page<T> {

    private Double pageSize;
    private Double atualPage;
    private Double qtdeRegistros;
    private Double pageNumber;

    public Page() {
    }

    public Page(Double qtdeRegistros, Double pageSize, Double atualPage) {
        this.pageSize = pageSize;
        this.atualPage = atualPage;
        this.qtdeRegistros = qtdeRegistros;
    }

    public Double getQtdeRegistros() {
        return qtdeRegistros;
    }

    public void setQtdeRegistros(Double qtdeRegistros) {
        this.qtdeRegistros = qtdeRegistros;
    }


    public Double getPageSize() {
        return pageSize;
    }

    public void setPageSize(Double pageSize) {
        this.pageSize = pageSize;
    }

    public Double getAtualPage() {
        return atualPage;
    }

    public void setAtualPage(Double atualPage) {
        this.atualPage = atualPage;
    }

    public Double getPageNumber() {
        double valor = (this.qtdeRegistros%this.pageSize);
        if (valor >0) {
            return ((this.qtdeRegistros / this.pageSize) +1);
        }
        return ((this.qtdeRegistros / this.pageSize));
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", atualPage=" + atualPage +
                ", qtdeRegistros=" + qtdeRegistros +
                ", numeroDePaginas=" +this.getPageNumber() +
                '}';
    }
}
