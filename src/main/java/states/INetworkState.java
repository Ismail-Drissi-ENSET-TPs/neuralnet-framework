package states;

import entities.NeuralNetwork;

public interface INetworkState {
    void train(NeuralNetwork nn);
    double[] predict(NeuralNetwork nn, double[] x);
    void fit(NeuralNetwork nn);
}
