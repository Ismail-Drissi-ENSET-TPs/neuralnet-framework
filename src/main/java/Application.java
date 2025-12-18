import annotations.SecuredBy;
import context.SecurityContext;
import entities.Edge;
import entities.Layer;
import entities.NeuralNetwork;
import entities.Neuron;
import functions.SigmoidFunction;
import observers.Dashboard;

import java.util.ArrayList;
import java.util.List;

public class Application {

    @SecuredBy(roles = {"ADMIN"})
    public static void main(String[] args) {
        SecurityContext.authenticate("ismail", "1234", new String[]{"ADMIN"});
        NeuralNetwork neuralNetwork = new NeuralNetwork();

        Dashboard dashboard = new Dashboard(neuralNetwork);

        // -------- Layer 1 neurons --------
        Neuron neuron1 = new Neuron();
        neuron1.setBias(0);
        neuron1.setActivationFunction(new SigmoidFunction());

        Neuron neuron2 = new Neuron();
        neuron2.setBias(1);
        neuron2.setActivationFunction(new SigmoidFunction());

        Layer layer1 = new Layer();
        layer1.setNeurons(List.of(neuron1, neuron2));

        // -------- Layer 2 neurons --------
        Neuron neuron1_layer2 = new Neuron();
        neuron1_layer2.setBias(1);
        neuron1_layer2.setActivationFunction(new SigmoidFunction());
        neuron1_layer2.setEdges(new ArrayList<>());

        Neuron neuron2_layer2 = new Neuron();
        neuron2_layer2.setBias(0);
        neuron2_layer2.setActivationFunction(new SigmoidFunction());
        neuron2_layer2.setEdges(new ArrayList<>());

        Neuron neuron3_layer2 = new Neuron();
        neuron3_layer2.setBias(1);
        neuron3_layer2.setActivationFunction(new SigmoidFunction());
        neuron3_layer2.setEdges(new ArrayList<>());

        Layer layer2 = new Layer();
        layer2.setNeurons(List.of(
                neuron1_layer2,
                neuron2_layer2,
                neuron3_layer2
        ));

        // -------- Edges --------
        Edge edge1 = new Edge();
        edge1.setPrev(neuron1);
        edge1.setNext(neuron1_layer2);

        Edge edge2 = new Edge();
        edge2.setPrev(neuron1);
        edge2.setNext(neuron2_layer2);

        Edge edge3 = new Edge();
        edge3.setPrev(neuron1);
        edge3.setNext(neuron3_layer2);

        Edge edge4 = new Edge();
        edge4.setPrev(neuron2);
        edge4.setNext(neuron1_layer2);

        Edge edge5 = new Edge();
        edge5.setPrev(neuron2);
        edge5.setNext(neuron2_layer2);

        Edge edge6 = new Edge();
        edge6.setPrev(neuron2);
        edge6.setNext(neuron3_layer2);

        // -------- Attach edges (IMPORTANT: add, don't overwrite) --------
        neuron1_layer2.getEdges().add(edge1);
        neuron1_layer2.getEdges().add(edge4);

        neuron2_layer2.getEdges().add(edge2);
        neuron2_layer2.getEdges().add(edge5);

        neuron3_layer2.getEdges().add(edge3);
        neuron3_layer2.getEdges().add(edge6);

        // -------- Neural network --------
        neuralNetwork.setLayers(List.of(layer1, layer2));

        neuralNetwork.train();

        double[] output = neuralNetwork.predict(new double[]{1, 2});

        for (double v : output) {
            System.out.print(v + ", ");
        }
    }
}
