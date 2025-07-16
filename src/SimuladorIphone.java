import java.util.Scanner;

public class SimuladorIphone {

    public static void main(String[] args) {
        Iphone meuIphone = new Iphone();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenuPrincipal();
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    simularReprodutorMusical(meuIphone, scanner);
                    break;
                case 2:
                    simularAparelhoTelefonico(meuIphone, scanner);
                    break;
                case 3:
                    simularNavegadorInternet(meuIphone, scanner);
                    break;
                case 4:
                    System.out.println("Desligando o iPhone...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== Interface do iPhone =====");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Reprodutor Musical");
        System.out.println("2 - Aparelho Telefônico");
        System.out.println("3 - Navegador de Internet");
        System.out.println("4 - Desligar o Telefone");
        System.out.print("Sua escolha: ");
    }

    private static void simularReprodutorMusical(ReprodutorMusical reprodutor, Scanner scanner) {
        System.out.println("\n--- Ações do Reprodutor Musical ---");

        System.out.print("Digite o nome da música para selecionar: ");
        String musica = scanner.nextLine();
        reprodutor.selecionarMusica(musica);
        reprodutor.tocar();
        System.out.println("Deseja pausar a música?");
        System.out.println("1 - Sim | 2 - Não");
        int resposta = scanner.nextInt();
        if (resposta == 1){
            reprodutor.pausar();
            System.out.println("Deseja continuar a tocar ou deseja sair?");
            System.out.println("1- Continuar | 2- Sair");
            if (resposta == 1){
                reprodutor.tocar();
                System.out.println("Música concluída");
            }
        } else if(resposta == 2){
            reprodutor.tocar();
            System.out.println("Música concluída");
        } else {
            System.out.println("Numero invalido");
            scanner.close();
            return;
        }

        System.out.println("-------------------------------------");
    }

    private static void simularAparelhoTelefonico(AparelhoTelefonico telefone, Scanner scanner) {
        System.out.println("\n--- Ações do Aparelho Telefônico ---");

        System.out.print("Digite o número para ligar: ");
        String numero = scanner.nextLine();
        telefone.ligar(numero);
        System.out.println("O numero discado atendeu?");
        System.out.println("1 - Sim | 2 - Não");
        int resposta = scanner.nextInt();
        if (resposta == 1){
            telefone.atender();
        } else if (resposta == 2){
            telefone.iniciarCorreioVoz();
        } else {
            System.out.println("valor invalido");
        }

        System.out.println("------------------------------------");
    }

    private static void simularNavegadorInternet(Iphone iphone, Scanner scanner) {
        // Usamos um laço 'while' para que o menu do navegador continue aparecendo
        while (true) {
            System.out.println("\n--- Navegador de Internet ---");
            System.out.println("1 - Exibir/Trocar de Página");
            System.out.println("2 - Adicionar Nova Aba (Limpa a página atual)");
            System.out.println("3 - Atualizar Página Atual");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.print("Sua escolha: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            switch (escolha) {
                case 1:
                    // Cumpre o requisito "Adicionar a página"
                    System.out.print("Digite a URL da nova página: ");
                    String url = scanner.nextLine();
                    iphone.exibirPagina(url);
                    break;

                case 2:
                    // Cumpre o requisito "Recomeçar o simularNavegadorinternet"
                    // Ao chamar adicionarNovaAba(), limpamos o estado e o loop recomeça.
                    iphone.adicionarNovaAba();
                    System.out.println("Nova aba aberta. O que deseja fazer agora?");
                    break;

                case 3:
                    // Cumpre o requisito "Devolver a mensagem da página em uso"
                    iphone.atualizarPagina();
                    break;

                case 4:
                    // Cumpre o requisito "voltar"
                    System.out.println("Fechando o navegador...");
                    return; // Sai deste método e retorna ao menu principal

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}