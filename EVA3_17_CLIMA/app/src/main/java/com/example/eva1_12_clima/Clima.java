package com.example.eva1_12_clima;

public class Clima {
    private int imagen;
    private double temp;
    private String ciudad, desc;

    public Clima() {
        this.imagen = R.drawable.sunny;
        this.ciudad = "Chihuahua";
        this.temp = 27.3;
        this.desc = "Soleado";
    }

    public Clima(int imagen, String ciudad, double temp,  String desc) {
        this.imagen = imagen;
        this.temp = temp;
        this.ciudad = ciudad;
        this.desc = desc;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
