package com.example.examenc1;

public class cuentaBanco {
    private String numCuenta;
    private String nombre;
    private String banco;
    private float saldo;

    public cuentaBanco(String numCuenta, String nombre, String banco, float saldo){
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.banco = banco;
        this.saldo = saldo;
    }

    public int retirarDinero(float retiro){
        if(retiro <= saldo){
            saldo = saldo - retiro;
            return 1;
        } else {
            return 0;
        }
    }

    public int depositarDinero(float deposito){
        saldo = saldo + deposito;
        return 1;
    }

    public float obtenerSaldo(){
        return saldo;
    }
}
