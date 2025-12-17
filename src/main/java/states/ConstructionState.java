package states;

import entities.NeuralNetwork;

public class ConstructionState implements INetworkState {
    @Override
    public void train(NeuralNetwork nn) {
        nn.setState(new TrainingState());
        nn.notifyObservers();
        nn.train();
    }

    @Override
    public double[] predict(NeuralNetwork nn, double[] x) {
        throw new UnsupportedOperationException(
                "Can't predict without training"
        );
    }

    @Override
    public void fit(NeuralNetwork nn) {
        nn.notifyObservers();
        nn.setState(new TrainedState());
    }
}


