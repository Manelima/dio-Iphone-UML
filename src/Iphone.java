public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {
    private String paginaAtual;

    public Iphone() {
        this.paginaAtual = null;
    }

    // Métodos de ReprodutorMusical
    @Override
    public void tocar() {
        System.out.println("TOCANDO MÚSICA...");
    }

    @Override
    public void pausar() {
        System.out.println("PAUSANDO MÚSICA...");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("SELECIONANDO A MÚSICA: " + musica);
    }

    // Métodos de AparelhoTelefonico
    @Override
    public void ligar(String numero) {
        System.out.println("LIGANDO PARA O NÚMERO: " + numero);
    }

    @Override
    public void atender() {
        System.out.println("ATENDENDO CHAMADA...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("INICIANDO CORREIO DE VOZ...");
    }

    //Métodos de Navegador Internet
    @Override
    public void exibirPagina(String url) {
        System.out.println("EXIBINDO A PÁGINA: " + url);
        this.paginaAtual = url;
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("ADICIONANDO NOVA ABA NO NAVEGADOR...");
        this.paginaAtual = null;
    }

    @Override
    public void atualizarPagina() {
        if (paginaAtual != null && !paginaAtual.isEmpty()) {
            System.out.println("ATUALIZANDO A PÁGINA: " + this.paginaAtual);
        } else {
            System.out.println("NENHUMA PÁGINA PARA ATUALIZAR. ABRA UMA PÁGINA PRIMEIRO.");
        }
    }
}