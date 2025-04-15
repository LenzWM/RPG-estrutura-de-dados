import java.io.IOException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Main {
    static String[] menuItems = {" Play", " Options", " Credits"," Exit"};
    static int selectedIndex = 0;
    
    public static void main(String[] args) throws IOException {
        Terminal terminal = TerminalBuilder.terminal();
        LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();
        
        terminal.enterRawMode(); //Para a captura das teclas, tipo o getch() em C
        
        while(true) {
            printMenu(terminal);
            
            int ch =  terminal.reader().read();
            char input = Character.toLowerCase((char) ch);
            
            switch(input) {
                case 'w' ->{
                    selectedIndex = (selectedIndex - 1 + menuItems.length) % menuItems.length;
                    break;
                }
                case 's' -> {
                    selectedIndex = (selectedIndex + 1) % menuItems.length;
                    break;
                }
                case '\n' -> {
                    terminal.writer().println("You selected: " + menuItems[selectedIndex]);
                    terminal.flush();
                    if (menuItems[selectedIndex].equalsIgnoreCase("Exit")) {
                        return;
                    }
                    pause(terminal);
                    break;
                }
            }
        }
    }
    
    static void printMenu(Terminal terminal) {
        terminal.puts(org.jline.utils.InfoCmp.Capability.clear_screen);
        terminal.flush();
        for (int i = 0; i < menuItems.length; i++) {
            if (i == selectedIndex) {
                terminal.writer().println("> " + menuItems[i]);
            } else {
                terminal.writer().println("  " + menuItems[i]);
            }
        }
        terminal.flush();
    }
    
    static void pause(Terminal terminal) {
        terminal.writer().println("Press any key to go back to menu...");
        terminal.flush();
        try {
            terminal.reader().read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
