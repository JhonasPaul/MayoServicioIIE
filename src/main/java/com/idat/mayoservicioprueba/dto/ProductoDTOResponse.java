package com.idat.mayoservicioprueba.dto;

public class ProductoDTOResponse {
    private int idProducto;
    private String nombreProducto;
    private String descripcionProdcuto;
    private double precioProdcuto;
    private int stockProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProdcuto() {
        return descripcionProdcuto;
    }

    public void setDescripcionProdcuto(String descripcionProdcuto) {
        this.descripcionProdcuto = descripcionProdcuto;
    }

    public double getPrecioProdcuto() {
        return precioProdcuto;
    }

    public void setPrecioProdcuto(double precioProdcuto) {
        this.precioProdcuto = precioProdcuto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }
}
