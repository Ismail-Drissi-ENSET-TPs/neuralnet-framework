import entities.Edge;
import entities.Layer;
import entities.NeuralNetwork;
import entities.Neuron;
import functions.SigmoidFunction;
import observers.Dashboard;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        neuralNetwork.add(dashboard);

        Neuron neuron1 = Neuron.builder().bias(0).activationFunction(new SigmoidFunction()).build();
        Neuron neuron2 = Neuron.builder().bias(1).activationFunction(new SigmoidFunction()).build();
        Layer layer1 = Layer.builder().neurons(List.of(neuron1, neuron2)).build();
        Neuron neuron1_layer2 = Neuron.builder().bias(1).activationFunction(new SigmoidFunction()).build();
        Neuron neuron2_layer2 = Neuron.builder().bias(0).activationFunction(new SigmoidFunction()).build();
        Neuron neuron3_layer2 = Neuron.builder().bias(1).activationFunction(new SigmoidFunction()).build();
        Layer layer2 = Layer.builder().neurons(List.of(neuron1_layer2, neuron2_layer2, neuron3_layer2)).build();
        Edge edge1_layer1 = Edge.builder().prev(neuron1).next(neuron1_layer2).build();
        Edge edge2_layer1 = Edge.builder().prev(neuron1).next(neuron2_layer2).build();
        Edge edge3_layer1 = Edge.builder().prev(neuron1).next(neuron3_layer2).build();


        Edge edge4_layer1 = Edge.builder().prev(neuron2).next(neuron1_layer2).build();
        Edge edge5_layer1 = Edge.builder().prev(neuron2).next(neuron2_layer2).build();
        Edge edge6_layer1 = Edge.builder().prev(neuron2).next(neuron3_layer2).build();


        neuron1_layer2.setEdges(List.of(edge1_layer1));
        neuron1_layer2.setEdges(List.of(edge4_layer1));

        neuron2_layer2.setEdges(List.of(edge2_layer1));
        neuron2_layer2.setEdges(List.of(edge5_layer1));

        neuron3_layer2.setEdges(List.of(edge3_layer1));
        neuron3_layer2.setEdges(List.of(edge6_layer1));
        neuralNetwork.setLayers(List.of(layer1, layer2));


        neuralNetwork.train();

        double[] output = neuralNetwork.predict(new double[]{1, 2});


        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }

    }
}
