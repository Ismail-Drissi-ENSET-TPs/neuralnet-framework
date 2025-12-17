import entities.Edge;
import entities.Layer;
import entities.NeuralNetwork;
import entities.Node;
import functions.SigmoidFunction;
import observers.Dashboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        neuralNetwork.add(dashboard);

        Node node1 = Node.builder().bias(0).activationFunction(new SigmoidFunction()).build();
        Node node2 = Node.builder().bias(1).activationFunction(new SigmoidFunction()).build();
        Layer layer1 = Layer.builder().nodes(List.of(node1, node2)).build();
        Node node1_layer2 = Node.builder().bias(1).activationFunction(new SigmoidFunction()).build();
        Node node2_layer2 = Node.builder().bias(0).activationFunction(new SigmoidFunction()).build();
        Node node3_layer2 = Node.builder().bias(1).activationFunction(new SigmoidFunction()).build();
        Layer layer2 = Layer.builder().nodes(List.of(node1_layer2, node2_layer2, node3_layer2)).build();
        Edge edge1_layer1 = Edge.builder().prev(node1).next(node1_layer2).build();
        Edge edge2_layer1 = Edge.builder().prev(node1).next(node2_layer2).build();
        Edge edge3_layer1 = Edge.builder().prev(node1).next(node3_layer2).build();


        Edge edge4_layer1 = Edge.builder().prev(node2).next(node1_layer2).build();
        Edge edge5_layer1 = Edge.builder().prev(node2).next(node2_layer2).build();
        Edge edge6_layer1 = Edge.builder().prev(node2).next(node3_layer2).build();


        node1_layer2.setEdges(List.of(edge1_layer1));
        node1_layer2.setEdges(List.of(edge4_layer1));

        node2_layer2.setEdges(List.of(edge2_layer1));
        node2_layer2.setEdges(List.of(edge5_layer1));

        node3_layer2.setEdges(List.of(edge3_layer1));
        node3_layer2.setEdges(List.of(edge6_layer1));
        neuralNetwork.setLayers(List.of(layer1, layer2));


        neuralNetwork.train();

        double[] output = neuralNetwork.predict(new double[]{1, 2});


        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + ", ");
        }

    }
}
