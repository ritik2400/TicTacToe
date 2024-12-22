import service.GameService;

public class Driver {

    private static GameService gameService;

    public static void main(String[] args) {
        gameService = new GameService();
        gameService.startGame();

    }
}