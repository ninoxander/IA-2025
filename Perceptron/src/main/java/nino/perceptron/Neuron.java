package nino.perceptron;

import nino.data.Data;

public class Neuron {
    // Pesos
    private float weight[];
    // Sesgo: será definido aleatoreamente
    private float bias;
    // Tasa de aprendizaje
    private float rate;
    // Resultado
    private int output;
    // Constants
    private int upperLimit = 2;
    private int bottomLimit = 1;

    public Neuron(int size) {
        this.weight = weightGeneration(size);
        this.bias = ((float) Math.random() * this.upperLimit) - this.bottomLimit;
        this.rate = 0.1f;
    }

    // Generando los pesos
    public float[] weightGeneration(int size) {
        float auxWeight[] = new float[size];
        for (int i = 0; i < size; i++) {
            auxWeight[i] = ((float) Math.random() * this.upperLimit) - this.bottomLimit;
        }
        return auxWeight;
    }

    // Algoritmo de Sigmoid
    // Funcióom heuristica
    public int sigmoid(int[] entries) {
        // Suma pomderada
        float wSum = this.bias;
        int result;
        // For para suma ponderada
        for(int i = 0; i < entries.length; i++) {
            wSum += entries[i] * this.weight[i];
        }

        // Sigmoid decision
        if(wSum >= 0) {
            result = 1;
        } else {
            result = 0;
        }

        return result;
    }

    // Algoritmo de entrenamiento: calcula el error de cada entrada/salida
    // exOutput = salida esperada (expected output)
    public void train(int[] entries, int exOutput) {
        // Calcula la salida para cada entrada
        this.output = sigmoid(entries);
        // Y que tan erroneo fue el resultado
        int error = exOutput - this.output;

        for(int i = 0; i < this.weight.length; i++) {
            this.weight[i] += this.rate * error * entries[i];
        }
        this.bias += this.rate * error;
    }

    // Printing functions
    // Imprimir los pesos de cada generación
    public void printWeights() {
        for(float itemWeight : this.weight) {
            System.out.println("Weight: " + itemWeight);
        }
    }

    // Imprimir los resultados de cada generación
    public void printOutcomes(Data data) {
        System.out.println("Entry: " + data.entry[0] + " | " + data.entry[1]);
        System.out.println("Expected: " + data.output + " | Outcome: " + this.output);
    }
}