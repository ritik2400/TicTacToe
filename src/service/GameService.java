package service;

import enums.GameStatus;
import models.Game;
import models.Game.GameBuilder;
import models.Player;
import models.Player.PlayerBuilder;

import java.util.Scanner;

public class GameService {
    private Game game;
    private Scanner sc;
    private GameStatus gameStatus;
    GameService() {
        sc = new Scanner(System.in);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void initGame() {
        int totalPlayers = sc.nextInt();
        sc.nextLine();
        Player[] players = new Player[totalPlayers];
        PlayerBuilder playerBuilder = new PlayerBuilder();
        for(int i=0;i<totalPlayers;i++) {
            System.out.println("Enter Player " + (i+1) + " name: ");
            playerBuilder.name(sc.nextLine());
            System.out.println("Enter Player " + (i+1) + " symbol: ");
            playerBuilder.symbol(sc.nextLine().charAt(0));
            players[i] = playerBuilder.build();
        }
        this.game = new GameBuilder()
                .totalPlayers(totalPlayers)
                .players(players)
                .build();
    }

    public void startGame() {
        gameStatus = GameStatus.START;
        initGame();
        gameStatus = GameStatus.RUNNING;
        int turn = 0;
        while(gameStatus == GameStatus.RUNNING) {
            game.printBoard();
            Player player = game.getPlayer(turn%game.getTotalPlayers());
            System.out.print(player.getName()+"'s turn.\n Enter your position: ");
            int pos = sc.nextInt()-1;
            if(pos>8 || pos<0) {
                System.out.println("Invalid position. Try again.");
                continue;
            }
            if(game.markAndCheck(pos/3, pos%3, player.getSymbol())) {
                gameStatus = GameStatus.WIN;
                game.setWinner(player);
            }
            else {
                turn++;
            }
            if(turn==9) {
                gameStatus = GameStatus.DRAW;
            }
        }

        if(gameStatus == GameStatus.DRAW) {
            System.out.println("Game has ended in a DRAW. ");
        }
        if(gameStatus == GameStatus.WIN) {
            System.out.println(game.getWinner().getSymbol() + " won the game.");
        }
        game.printBoard();
        gameStatus = GameStatus.END;
    }
}
