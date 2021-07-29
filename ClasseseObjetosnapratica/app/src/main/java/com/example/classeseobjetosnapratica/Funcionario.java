package com.example.classeseobjetosnapratica;

class Funcionario {

    //propriedades

    String nome;
    double salario;

    //métodos

    double recuperarSalario(){

        this.salario = this.salario - (this.salario * 0.01);

        return this.salario;

       // System.out.println(this.salario);
    }

}
