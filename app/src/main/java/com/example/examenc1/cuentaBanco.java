package com.example.examenc1;

import kotlin.contracts.Returns;

public class cuentaBanco {
    private String numCuenta;
    private String Nombre;
    private String Banco;
    private  float Saldo;

    public cuentaBanco (String cuenta, String nombre, String banco, float saldo){
        numCuenta.this = cuenta;
        Nombre.this = nombre;
        Banco.this = banco;
        Saldo.this = saldo;

    }

    public int retirarDinero(float retiro){
        if(retiro<=Saldo){
            Saldo=Saldo-retiro;
            return 1;
        } else {

            return 0;
        }
    }

    public int DepositarDinero(float deposito){
        Saldo=Saldo+deposito;

        return 1;
    }

    public float obtenerSaldo(){
        return Saldo;
    }



}
