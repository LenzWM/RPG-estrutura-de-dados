import java.util.Random;
import java.util.Scanner;

import model.entities.Enemie;
import model.entities.PlayerCharacter;
import model.entities.User;
import presitence.Persistencia;
import java.util.LinkedList;
import model.entities.User;

public class userInterface {

    private Scanner scanner;
    private LinkedList<User> Players;
    private User PlayerLogado;
    private LinkedList<User> players;
    private User playerLogado;

    public userInterface() {
        this.scanner = new Scanner(System.in);
        this.players = new LinkedList<>();
        this.players = Persistencia.carregarJogadores();
    }

    private void Menu(){
        while (true) {
            System.out.println("\n=== RPG BATTLE SYSTEM ===");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar");
            System.out.println("3. Sair");
            System.out.println("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LogIn();
                    break;
                case 2:
                cadastraNovoJogor();
                    break;
                case 3:
                    System.out.println("Jogo encerrado!!");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void LogIn() {
        System.out.println("\nNome de usuário: ");
        String name = scanner.nextLine();
        System.out.println("Senha: ");
        String password = scanner.nextLine();

        for (int i = 0; i < players.size(); i++) {
            User newUser = players.get(i);
            if (newUser.getUserName().equals(name) && newUser.getPassword().equals(password)) {
                playerLogado = newUser;
                System.out.println("Login realizado com sucesso!");
                MenuPrincipal();
                return;
            }
        }
        System.out.println("Usuário ou senha incorretos!");
    }

    private void cadastraNovoJogor() {
        System.out.println("\nNovo nome de usuário: ");
        String name = scanner.nextLine();
        System.out.println("Nova senha:");
        String password = scanner.nextLine();

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getUserName().equals(name)) {
                System.out.println("Usuário já existe!");
                return;
            }
        }

        User newUser = new User(name, password); // Agora funciona com o novo construtor
        players.add(newUser);
        System.out.println("Cadastro realizado com sucesso!");
    }

    private void MenuPrincipal(){
        while (playerLogado != null) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Personagens");
            System.out.println("2. Batalha PvE");
            System.out.println("3. Batalha PvP");
            System.out.println("4. Desconectar");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    gerenciarPersonagens();
                    break;
                case 2:
                    iniciarBatalhaPvE();
                    break;
                case 3:
                    iniciarBatalhaPvP();
                    break;
                case 4:
                    playerLogado = null;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void gerenciarPersonagens(){
        while (true) {
            System.out.println("\n=== GERENCIAR PERSONAGENS ===");
            System.out.println("1. Criar Novo Personagem");
            System.out.println("2. Listar Personagens");
            System.out.println("3. Selecionar Personagem Ativo");
            System.out.println("4. Voltar");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    criarNovoPersonagem();
                    break;
                case 2:
                    listarPersonagens();
                    break;
                case 3:
                    selecionarPersonagemAtivo();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void criarNovoPersonagem(){
        System.out.print("Nome do novo personagem: ");
        String nome = scanner.nextLine();
        playerLogado.criarPersonagem(nome);
        System.out.println("Personagem criado com sucesso!");
    }

    private void listarPersonagens(){
        System.out.println("\n=== SEUS PERSONAGENS ===");
        if (playerLogado.getPlayerCharacters().size() == 0) {
            System.out.println("Você não tem personagens ainda!!");
            return;
        }

        for (int i = 0; i < playerLogado.getPlayerCharacters().size(); i++) {
            PlayerCharacter p = playerLogado.getPlayerCharacters().get(i);
            System.out.println(p.getId() + ": " + p.getName() + " (Nível " + p.getLevel() + ") - HP: " + p.getMaxHp());
        }
    }

    private void selecionarPersonagemAtivo() {
        listarPersonagens();
        if (playerLogado.getPlayerCharacter() == null) {
            System.out.println("Nenhum personagem disponível para selecionar!");
            return;
        }

        System.out.println("Personagem ativo: " + playerLogado.getPlayerCharacter().getName());
    }

    private void iniciarBatalhaPvE (){

    }

    private void iniciarBatalhaPvP (){

    }

}