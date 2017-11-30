package Composite;

import java.util.ArrayList;
import java.util.List;
import Composite.Interface.iEsquema;

public class Gerente implements iEsquema {

    private String nome;
    private String cargo;
    private Double salario;
    private int comissao;
    private Double totVenda;
    private List<iEsquema> subordinados;

    // Com comissão
    public Gerente(String nome, String cargo, Double salario, int comissao, Double totVenda) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.comissao = comissao;
        this.totVenda = totVenda;
        this.subordinados = new ArrayList<>();

    }

    // Sem comissão
    public Gerente(String nome, String setor, Double salario) {
        this.nome = nome;
        this.cargo = setor;
        this.salario = salario;
        this.subordinados = new ArrayList<>();
    }

    public void incluirSubordinado(iEsquema func) {
        this.subordinados.add(func);
    }

    public void removerSubordinado(Funcionario func) {
        if (subordinados.contains(func)) {
            subordinados.remove(func);
        }
    }

    public List<iEsquema> getSubordinados() {
        return subordinados;
    }

    // Método de cada funcionário para calculo de folha
    private double receberPgto() {

        double salario_final;
        
        // gera os descontos
        salario_final = this.salario * (1 - 0.06);
        salario_final = salario_final * (1 - 0.11);
        
        // soma a comissão caso for de vendas
        if (this.comissao > 0) {
            salario_final = this.salario + ((this.totVenda * this.comissao) / 100);
        }

        // return salario_final;
        return salario_final;
    }

    @Override
    public String mostrarFunc() {

        return "Nome: " + this.nome + " Cargo: " + this.cargo + " Salario: " + receberPgto();
    }
}
