package observers;

import entities.NeuralNetwork;

public class Dashboard implements Observer{
    private NeuralNetwork neuralNetwork;

    @Override
    public void update(Subject s) {
        this.neuralNetwork = (NeuralNetwork) s;
        System.out.println("State change: " + this.neuralNetwork.getState().getClass().getName());
    }
}
