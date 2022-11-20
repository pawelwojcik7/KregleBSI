package org.example;

import junit.framework.TestCase;
import org.example.models.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

  Game game = new Game(2);
  List<Player> playerList = new ArrayList<>();
  List<Player> expectedWinnerList = new ArrayList<>();

  public void prepare() {
    playerList.add(new Player("Player1"));
    playerList.add(new Player("Player2"));
    playerList.add(new Player("Player3"));

    playerList.get(0).setTotalPoints(20);
    playerList.get(1).setTotalPoints(20);
    playerList.get(2).setTotalPoints(10);

    expectedWinnerList.add(playerList.get(0));
    expectedWinnerList.add(playerList.get(1));
  }

  @Test
  public void testCheckWhoWin() {
    prepare();
    List<Player> results = game.checkWinners(playerList, 20);
    Assert.assertEquals(expectedWinnerList, results);
  }
}
