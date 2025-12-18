package observers;

import entities.NeuralNetwork;

public class Dashboard implements Observer{
    private NeuralNetwork neuralNetwork;

    public Dashboard(NeuralNetwork neuralNetwork){
        this.neuralNetwork = neuralNetwork;
        neuralNetwork.add(this);
    }

    @Override
    public void update(Subject s) {
        this.neuralNetwork = (NeuralNetwork) s;
        System.out.println("State change: " + this.neuralNetwork.getState().getClass().getName());
    }
}
