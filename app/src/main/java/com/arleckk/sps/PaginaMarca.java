package com.arleckk.sps;

/**
 * Created by arleckk on 28/06/2015.
 */
public class PaginaMarca {

    private int pagina;
    private int Marca;

    public PaginaMarca(int pagina, int marca) {
        this.pagina = pagina;
        Marca = marca;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getMarca() {
        return Marca;
    }

    public void setMarca(int marca) {
        Marca = marca;
    }
}
