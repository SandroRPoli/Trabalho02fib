package Composite;

import java.util.ArrayList;
import java.util.List;
import Composite.Interface.iEsquema;

public class Presidente implements iEsquema {

    private String nome;
    private String cargo;
    private Double salario;
    private List<iEsquema> subordinados;

    public Presidente(String nome, String cargo, Double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.subordinados = new ArrayList<>();
    }

    public void incluirSubordinado(iEsquema func) {
        this.subordinados.add(func);
    }
    
    public void removerSubordinado(Funcionario func)
    {
        if (subordinados.contains(func)) {
            subordinados.remove(func);
        }
    }

    public List<iEsquema> getSubordinados() {
        return subordinados;
    }

    //Método de cada funcionário para calculo de folha
    private double receberPgto() {
        
        double salario_final;  
        
        // gera os descontos
        salario_final = this.salario * (1 - 0.02);      

        // return salario_final;
        return salario_final;
    }

    @Override
    public String mostrarFunc() {
        return "Nome: " + this.nome + " Cargo: " + this.cargo + " Salario: " + receberPgto();
    }
}
