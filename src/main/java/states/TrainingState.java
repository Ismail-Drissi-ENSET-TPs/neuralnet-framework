package states;

import entities.NeuralNetwork;

public class TrainingState implements INetworkState {
    @Override
    public void train(NeuralNetwork nn) {
        System.out.println("Training...");
        nn.setState(new TrainedState());
    }

    @Override
    public double[] predict(NeuralNetwork nn, double[] x) {
        throw new UnsupportedOperationException(
                "Can't predict without training"
        );
    }

    @Override
    public void fit(NeuralNetwork nn) {
        throw new UnsupportedOperationException("Cannot fit from a training state");
    }
}
