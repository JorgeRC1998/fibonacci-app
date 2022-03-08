package com.proteccion.seriefibonacci.dto;

public class GeneralResponseDto {
    private String mensaje;
    private String fibonacciResultado;

    public GeneralResponseDto(){

    }

    public GeneralResponseDto(String mensaje, String fibonacciResultado){
        this.mensaje = mensaje;
        this.fibonacciResultado = fibonacciResultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFibonacciResultado() {
        return fibonacciResultado;
    }

    public void setFibonacciResultado(String fibonacciResultado) {
        this.fibonacciResultado = fibonacciResultado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fibonacciResultado == null) ? 0 : fibonacciResultado.hashCode());
        result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GeneralResponseDto other = (GeneralResponseDto) obj;
        if (fibonacciResultado == null) {
            if (other.fibonacciResultado != null)
                return false;
        } else if (!fibonacciResultado.equals(other.fibonacciResultado))
            return false;
        if (mensaje == null) {
            if (other.mensaje != null)
                return false;
        } else if (!mensaje.equals(other.mensaje))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GeneralResponseDto [fibonacciResultado=" + fibonacciResultado + ", mensaje=" + mensaje + "]";
    }
    
}
