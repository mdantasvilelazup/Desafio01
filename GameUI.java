import java.util.Scanner;

public class GameUI {
    private Scanner scanner = new Scanner(System.in);
    private GameData data = new GameData();

    public void coreLoop() {
        int playing = 1;
        while (playing == 1) {
            printSeparator();
            print("JOGO DE ADIVINHA");
            printSeparator();

            print("Escolha a dificuldade: ");
            print("1 - Fácil, 1 a 10");
            print("2 - Médio, 1 a 50");
            print("3 - Difícil, 1 a 100");

            data.difficulty = readDifficulty();
            data.resetTarget();

            print("Dificuldade " + data.difficulty + " escolhida");
            printSeparator();
            int guess = readInt("Digite seu palpite: ");
            int addedScore = data.guess(guess);

            printResult(addedScore);
            printSeparator();

            print("Quer continuar?");
            playing = readInt("Digite 1 para continuar ou outro número para encerrar");
        }

        printSeparator();
        print("Jogo finalizado com a pontuação total de " + data.getScore() + " pontos!");
        scanner.close();
    }

    void printResult(int addedScore) {
        print("Número alvo: " +  data.getTarget());
        switch (addedScore) {
            case 0:
                print("Passou longe...");
                break;
            case 5:
                print("Por pouco!");
                break;
            case 10:
                print("Incrível, acertou o alvo!");
                break;
            default:
                break;
        }

        print("Ganhou " + addedScore + " pontos!");
        print("Pontos totais: " + data.getScore());
    }

    int readDifficulty() {
        int difficulty;

        do {
           difficulty = readInt("Digite o número da dificuldade (1, 2, 3): ");
        } while(difficulty < 1 || difficulty > 3);

        return difficulty;
    }

    int readInt(String text) {
        String string = readString(text);
        int input = Integer.parseInt(string);

        return input;
    }

    String readString(String text) {
        print(text);
        return scanner.nextLine();
    }

    void print(String string) {
        System.out.println(string);
    }

    void printSeparator() {
        print("-------------------------------------------");
    }
}
