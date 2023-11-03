package br.edu.ifpe.apoo.apresentacao;

import java.util.Scanner;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.entidades.AlunoBuilder;
import br.edu.ifpe.apoo.excecoes.AlunoNaoEncontradoException;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.excecoes.TamanhoCPFInvalidoException;
import br.edu.ifpe.apoo.excecoes.TamanhoNomeInvalidoException;
import br.edu.ifpe.apoo.negocio.FachadaDeNegocioFactory;
import br.edu.ifpe.apoo.negocio.IFachadaDeNegocio;
import br.edu.ifpe.apoo.negocio.ValidadorCPFAdapter;

public class AlunoApresentacao {

    public void exibirMenu() throws ExcecaoAlunoInvalido, TamanhoNomeInvalidoException, TamanhoCPFInvalidoException {
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);
        IFachadaDeNegocio fachadaNegocio = FachadaDeNegocioFactory.getInstancia();
        
        while (continuar) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1 para inserir um aluno;");
            System.out.println("2 para consultar um aluno;");
            System.out.println("3 para remover um aluno;");
            System.out.println("4 para alterar um aluno;");
            System.out.println("5 para sair;");

            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    inserir(fachadaNegocio);
                    break;
                case 2:
                    consultar(fachadaNegocio);
                    break;
                case 3:
                    remover(fachadaNegocio);
                    break;
                case 4:
                    atualizar(fachadaNegocio);
                    break;
                case 5:
                    continuar = false; // Sair do loop
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void inserir(IFachadaDeNegocio negocio) {
        ValidadorCPFAdapter validadorCPFAdapter = new ValidadorCPFAdapter();
        AlunoBuilder alunoBuilder = new AlunoBuilder();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite o nome do aluno:");
            String nome = scanner.nextLine();
            alunoBuilder.setNome(nome);

            System.out.println("Digite o CPF do aluno:");
            String cpf = scanner.nextLine();
            boolean teste = validadorCPFAdapter.validarCPF(cpf);

            if (teste) {
                alunoBuilder.setCpf(cpf);

                System.out.println("Digite o e-mail do aluno:");
                String email = scanner.nextLine();
                alunoBuilder.setEmail(email);

                Aluno aluno = alunoBuilder.build();

                try {
                    negocio.inserirAluno(aluno);
                    System.out.println("Aluno inserido com sucesso. ID: " + aluno.getId());
                } catch (ExcecaoAlunoInvalido ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("CPF Inválido");
                inserir(negocio);
            }
        } catch (TamanhoNomeInvalidoException e) {
            System.out.println(e.getMessage());
            inserir(negocio);
        } catch (TamanhoCPFInvalidoException e) {
            System.out.println(e.getMessage());
            inserir(negocio);
        }
    }


    private void consultar(IFachadaDeNegocio negocio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do aluno que deseja consultar:");

        long id = Long.parseLong(scanner.nextLine());

        try {
            Aluno aluno = negocio.getAluno(id);

            if (aluno != null) {
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println("E-mail: " + aluno.getEmail());
            } else {
                System.out.println("Aluno com ID " + id + " não encontrado.");
            }
        } catch (AlunoNaoEncontradoException ex) {
            System.out.println(ex.getMessage());
            
        }
    }

    private void remover(IFachadaDeNegocio negocio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do aluno que deseja remover:");

        long id = Long.parseLong(scanner.nextLine());

        try {
        	negocio.removerAluno(id);
            System.out.println("Aluno removido com sucesso.");
        } catch (AlunoNaoEncontradoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void atualizar(IFachadaDeNegocio negocio) throws TamanhoNomeInvalidoException, TamanhoCPFInvalidoException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do aluno que deseja atualizar:");

        long id = Long.parseLong(scanner.nextLine());

        try {
            Aluno aluno = negocio.getAluno(id);

            if (aluno != null) {
                System.out.println("Digite o novo nome do aluno:");
                String novoNome = scanner.nextLine();

                System.out.println("Digite o novo CPF do aluno:");
                String novoCpf = scanner.nextLine();

                System.out.println("Digite o novo e-mail do aluno:");
                String novoEmail = scanner.nextLine();

                aluno.setNome(novoNome);
                aluno.setCpf(novoCpf);
                aluno.setEmail(novoEmail);

                negocio.atualizarALUNO(aluno);

                System.out.println("Aluno atualizado com sucesso!");
            }
        } catch (AlunoNaoEncontradoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
