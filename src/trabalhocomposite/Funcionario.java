package trabalhocomposite;

import trabalhocomposite.Interface.iEsquema;

public class Funcionario implements iEsquema {

    private String nome;
    private String cargo;
    private Double salario;
    private int comissao;
    private Double totVenda;    

    //sem comissão
    public Funcionario(String nome, String cargo, Double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    //Com comissão
    public Funcionario(String nome, String cargo, Double salario, int comissao, Double totVenda) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.comissao = comissao;
        this.totVenda = totVenda;
    }

    //Método de cada funcionário para calculo de folha
    private double receberPgto() {

        double salario_final;

        // gera os descontos
        salario_final = this.salario * (1 - 0.06);
        salario_final = salario_final * (1 - 0.11);
        
        // soma a comissão caso for de vendas
        if (this.comissao > 0) {
            salario_final = this.salario + ((this.totVenda * this.comissao) / 100);
        }

        //return salario_final;
        return salario_final;
    }

    @Override
    public String mostrarFunc() {
        return "Nome: " + this.nome + " Cargo: " + this.cargo + " Salario: " + receberPgto();
    }
}
