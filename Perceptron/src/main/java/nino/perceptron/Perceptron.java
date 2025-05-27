package nino.perceptron;

import nino.data.Data;

public class Perceptron {
    private Data[] data;
    private int epochs;
    private Neuron vivaldi;
    public Perceptron(Data[] data, int epochs) {
            this.data = data;
            this.epochs = epochs;
            this.vivaldi = new Neuron(2);
    }
    public void run() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for(int i = 0; i < this.epochs; i++) {
            for(Data item: this.data) {
                vivaldi.train(item.entry, item.output);
                vivaldi.printOutcomes(item);
                this.vivaldi.printWeights();
                System.out.println("============================================================\n");
            }
        }
    }
}
