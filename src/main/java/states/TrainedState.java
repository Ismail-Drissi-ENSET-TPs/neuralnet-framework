package states;

import entities.Layer;
import entities.NeuralNetwork;
import entities.Node;
import enums.NNState;

public class TrainedState implements INetworkState {
    @Override
    public void train(NeuralNetwork nn) {
        nn.setState(new TrainingState());
        nn.notifyObservers();
        nn.train();
    }

    @Override
    public double[] predict(NeuralNetwork nn, double[] x) {
        double[] currentOutput = x;

        for (Layer layer : nn.getLayers()) {
            double[] nextOutput = new double[layer.getNodes().size()];
            int i = 0;

            for (Node node : layer.getNodes()) {
                nextOutput[i++] = node.activate(currentOutput);
            }

            currentOutput = nextOutput;
        }

        return currentOutput;
    }

    @Override
    public void fit(NeuralNetwork nn) {
        throw new UnsupportedOperationException("Cannot fit from a trained state");
    }
}
