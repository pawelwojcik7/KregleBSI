package org.example;

import org.example.generators.FaulGenerator;
import org.example.generators.PointsGenerator;
import org.example.models.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> playerList;
    private final TypeChecker typeChecker;

    public Game(int numberOfPlayers) {
        this.playerList = new ArrayList<Player>(numberOfPlayers);
        this.typeChecker=new TypeChecker();
    }

    public void start() {
        System.out.println("Start game");
        gameProgress();
    }

    private void gameProgress() {
        for (int i = 1; i < 11; i++) {
            for (Player player : playerList) {
                player.getResults()
                        .get(i).
                        getThrow1()
                        .setPoints(PointsGenerator.generatePoints(0, 10));
                if (FaulGenerator.generateIfFaul()) {
                    player.getResults().get(i).getThrow1().setIfFoul(true);
                }
                if(player.getResults()
                        .get(i).
                        getThrow1().getPoints()!=10) {
                    player.getResults()
                            .get(i)
                            .getThrow2()
                            .setPoints(PointsGenerator.generatePoints(0,10 - player.getResults().get(i).getThrow1().getPoints()
                            ));
                    if (FaulGenerator.generateIfFaul()) {
                        player.getResults().get(i).getThrow2().setIfFoul(true);
                    }
                }
                typeChecker.checkAndSet(player.getResults().get(i));
            }
        }
    }


}
