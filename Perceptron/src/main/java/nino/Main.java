package nino;

import nino.data.Data;
import nino.perceptron.*;

import java.io.DataOutput;

public class Main {
    public static void main(String[] args) {
        Data[] dataOR = {
                new Data(0, 0, 1),
                new Data(0, 1, 0),
                new Data(1, 0, 1),
                new Data(1, 1, 0),
                new Data(1, 0, 0),
                new Data(0, 1, 1),
                new Data(1, 1, 1),
                new Data(0, 0, 0)
        };
        Data[] dataAND = {
                new Data(0, 0, 0),
                new Data(0, 1, 0),
                new Data(1, 0, 0),
                new Data(1, 1, 1),
                new Data(1, 1, 1),
                new Data(1, 0, 0),
                new Data(0, 1, 0),
                new Data(0, 0, 0)
        };
        System.out.println("Resultados OR");
        Perceptron mozart = new Perceptron(dataOR, 20);
        mozart.run();

        System.out.println("Resultados AND");
        Perceptron or = new Perceptron(dataAND, 20);
        or.run();

    }
}