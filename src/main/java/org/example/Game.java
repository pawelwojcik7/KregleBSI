package org.example;

import org.example.generators.PointsGenerator;
import org.example.generators.SplitGenerator;
import org.example.models.Player;
import org.example.models.Queue;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private final List<Player> playerList;
  private final TypeChecker typeChecker;

  public Game(int numberOfPlayers) {
    this.playerList = new ArrayList<>(numberOfPlayers);
    for (int i = 0; i < numberOfPlayers; i++) this.playerList.add(new Player("Player" + i));
    this.typeChecker = new TypeChecker();
  }

  public void start() {
    System.out.println("Start game");
    gameProgress();
    printResults();
    List<Player> winners = checkWhoWin(playerList);
    System.out.println("\n" + "Winners \n");
    winners.forEach(e -> System.out.println(e.getName()));
  }

  private void gameProgress() {
    for (int i = 0; i < 10; i++) {
      for (Player player : playerList) {
        player.getResults().get(i).setThrow1(PointsGenerator.generatePoints(0, 10));

        if (player.getResults().get(i).getThrow1() != 10) {
          player
              .getResults()
              .get(i)
              .setThrow2(
                  PointsGenerator.generatePoints(0, 10 - player.getResults().get(i).getThrow1()));
        } else player.getResults().get(i).setThrow2(0);
        typeChecker.checkAndSet(player.getResults().get(i), SplitGenerator.generateSplit());
        Queue queue = player.getResults().get(i);
        queue.setSumOfPoints(queue.getThrow1() + queue.getThrow2());
      }
    }
  }

  private void printResults() {

    for (int i = 0; i < playerList.size(); i++) {
      System.out.println("Player : " + (i + 1));
      for (int j = 0; j < playerList.get(i).getResults().size(); j++) {
        System.out.println("  Queue : " + (j + 1));
        System.out.println("      Throw 1 : " + playerList.get(i).getResults().get(j).getThrow1());
        System.out.println("      Throw 2 : " + playerList.get(i).getResults().get(j).getThrow2());
        System.out.println(
            "    Sum of points : " + playerList.get(i).getResults().get(j).getSumOfPoints());
        System.out.println(
            "    Queue type : " + playerList.get(i).getResults().get(j).getType().toString());
      }
    }
  }

  public List<Player> checkWhoWin(List<Player> playerList) {
    for (Player player : playerList) {
      int sum = 0;
      for (Queue queue : player.getResults()) {
        sum = sum + queue.getSumOfPoints();
      }
      player.setTotalPoints(sum);
    }
    int max = 0;
    for (Player player : playerList) {
      if (player.getTotalPoints() > max) max = player.getTotalPoints();
    }

   return checkWinners(playerList, max);
  }

  public List<Player> checkWinners(List<Player> players, int winningPoints)
  {
    List<Player> winnerList = new ArrayList<>();
    for (Player player : players) {
      if (player.getTotalPoints() == winningPoints) winnerList.add(player);
    }

    return winnerList;
  }

}
