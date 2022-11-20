package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {

    private List<Queue> results;

    public Player() {
        this.results = new ArrayList<>(10);
    }
}
