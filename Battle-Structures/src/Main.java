import java.sql.SQLException;
import model.Battle;
import model.entities.*;
import structures.*;

public class Main {
    static final String EMAIL_REGEX = "^[a-zA-Z0-9._]+@gmail.com$";
    
    public static void main(String[] args) throws SQLException {
    //     UserDAO dao = new UserDAO();
    //     Scanner sc = new Scanner(System.in);
    //     User newUser = new User(null, null, null);
        
        int selectedOption = 0;
        String userName;
        String password;
        String email;
        
    //         ClearConsole.clear();
    //         System.out.println("----- Battle Structures -----\n");
    //         System.out.print("  > Press any key to continue <");
    //         sc.nextLine();
            
//        while(true) {
//            
//            ClearConsole.clear();
//            System.out.println("> Login    (1)");
//            System.out.println("> Sign up  (2)");
//            System.out.println("> Exit     (3)");
//            selectedOption = sc.nextInt();
//            sc.nextLine();
            
    //         switch(selectedOption) {
    //             case 1 -> {
    //                 System.out.println("Enter your email: ");
    //                 email = sc.nextLine();
    //                 System.out.println("Enter your password: ");
    //                 password = sc.nextLine();
                    
    //                 if(!isValidEmail(email)) {
    //                     System.out.println("Enter a valid email.");
    //                     sc.nextLine();
    //                     continue;
    //                 }
                    
    //                 boolean isValidLogin = dao.checkLogin(email, password);
                    
    //                 if(isValidLogin) {
    //                     break;
    //                 } else {
    //                     System.out.println("Invalid email and/or password.");
    //                     sc.nextLine();
    //                     continue;
    //                 }
    //             }
    //             case 2 -> {
    //                 System.out.println("Enter a user name: ");
    //                 userName = sc.nextLine();
    //                 System.out.println("Enter an email: ");
    //                 email = sc.nextLine();
    //                 System.out.println("Enter a password: ");
    //                 password = sc.nextLine();
                    
    //                 newUser.setUserName(userName);
    //                 newUser.setEmail(email);
    //                 newUser.setPassword(password);
    //                 dao.create(newUser);
    //                 num++;
    //                 break;
    //             }
    //             case 3 -> {
    //                 System.out.println("Leaving...");
    //                 return;
    //             }
    //             default -> {
    //                 System.out.println("Enter a valid option.");
    //                 sc.nextLine();
    //                 continue;
    //             }
    //         }
    //     }   

    //     while(true) {
    //         ClearConsole.clear();
    //         System.out.println("User: " + newUser.getUserName() + "\n\n");
    //         System.out.println("> Play    (1)");
    //         System.out.println("> Credits (2)");
    //         System.out.println("> Exit    (3)\n");

    //         System.out.print("Enter an option: ");
    //         try {
    //             selectedOption = sc.nextInt();
    //             sc.nextLine();
                
    //         } catch(Exception e) {
    //             ClearConsole.clear();
    //             System.out.println("Enter a valid option.");
    //             sc.nextLine();
    //             sc.nextLine();
    //             continue;
    //         }
            
    //         switch(selectedOption) {
    //             case 1 -> {
    //                 ClearConsole.clear();

    //                 runGame();

    //                 continue;
    //             }
    //             case 2 -> {
    //                 ClearConsole.clear();
    //                 System.out.println("Devs:");
    //                 System.out.println("- André Buna");
    //                 System.out.println("- Heitor Rodrigues");
    //                 System.out.println("- Josiah THE best (José Colino)");
    //                 System.out.println("- Leonardo Gomes");
    //                 sc.nextLine();
    //                 continue;
    //             }
    //             case 3 -> {
    //                 System.out.println("Leaving...");
    //                 break;
    //             }
    //         }
    //         return;
    //     }
    // }
    
    // public static boolean isValidEmail(String email) {
    //     if(email == null || email.isEmpty()) {
    //         return false;
    //     }
    //     Pattern pattern = Pattern.compile(EMAIL_REGEX);
    //     Matcher matcher = pattern.matcher(email);
    //     return matcher.matches();
        runGame();
    }

    public static void runGame(){
        Entity player = new PlayerCharacter(1, 100, 50, 50, 1, "Player", 30);
        Entity enemy = new Enemie("Enemy", 1, 40, 50, 50, 10);
        Entity boss = new Enemie("Boss", 1, 200,  50, 50, 20);
        LinkedList participants = new LinkedList();
        participants.addTail(player);
        participants.addTail(enemy);

        Battle battle = new Battle(participants);
        battle.startBattle();

    }
    
    public static boolean isValidPassword(String password) {
        return !(password == null || password.isEmpty());
    }
}

//import model.dao.UserDAO;
//import model.entities.User;
//
//public class Main {
//    public static void main(String[] args) {
//        UserDAO dao = new UserDAO();
//
//        try {
//            // Teste de inserção
//            User novo = new User("Fulano", "fulano@email.com", "1234");
//            dao.create(novo);
//
//            // Teste de login
//            boolean loginValido = dao.checkLogin("fulano@email.com", "1234");
//            System.out.println("Login válido? " + loginValido);
//
//            // Teste de busca por ID (id 1 como exemplo)
//            User u = dao.findById(1);
//            if (u != null) {
//                System.out.println("Usuário encontrado: " + u.getUserName());
//            } else {
//                System.out.println("Usuário não encontrado.");
//            }
//
//            // Teste de remoção
//            dao.delete(u); // cuidado: isso apaga o usuário mesmo
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
