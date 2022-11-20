package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {

    private List<Queue> results;
    private int totalPoints;

    public Player() {
        this.results = new ArrayList<>();
        for (int i=0;i<10;i++) this.results.add(new Queue());
    }
}
