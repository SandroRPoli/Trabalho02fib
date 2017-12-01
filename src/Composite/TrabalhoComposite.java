package Composite;

import Composite.Interface.iEsquema;

public class TrabalhoComposite {

    public static void main(String[] args) {

        Presidente presedente = new Presidente("Sandro", "Presidente", 15000.0);
        Gerente diretorComercial = new Gerente("Rubens", "Diretor Comercial", 5500.0, 20, 12300.0);
        Funcionario func1 = new Funcionario("Marcos", "Vendedor", 3000.0, 8, 16400.0);
        Funcionario func2 = new Funcionario("Murilo", "Vendedor", 2500.0, 10, 8900.0);
        
        Gerente diretorProducao = new Gerente("Jaimes", "Diretor Produção", 4000.0);
        Funcionario func3 = new Funcionario("Matheus", "Desenvolvedor", 2500.0);
        Funcionario func4 = new Funcionario("Marcelo", "Desenvolvedor", 1500.0);
        Funcionario func5 = new Funcionario("Ana", "Desenvolvedora", 2000.0);

        // subordinado do presidente
        presedente.incluirSubordinado(diretorComercial);
        presedente.incluirSubordinado(diretorProducao);

        // subordinado do diretor comercial
        diretorComercial.incluirSubordinado(func1);
        diretorComercial.incluirSubordinado(func2);

        // subodrinado do diretor produção
        diretorProducao.incluirSubordinado(func3);
        diretorProducao.incluirSubordinado(func4);
        diretorProducao.incluirSubordinado(func5);

        // Testes
        System.out.println(presedente.mostrarFunc());

        for (iEsquema diretor : presedente.getSubordinados()) {

            System.out.println("\t" + diretor.mostrarFunc());

            if (diretor instanceof Gerente) {
                for (iEsquema func : ((Gerente) diretor).getSubordinados()) {
                    System.out.println("\t\t" + func.mostrarFunc());
                }
            }

        }



    }
}
