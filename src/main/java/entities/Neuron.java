package entities;

import functions.IActivationFunction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class Neuron {
    IActivationFunction activationFunction;
    double bias;
    List<Edge> edges;

    public Neuron(IActivationFunction activationFunction, double bias, List<Edge> edges) {
        this.activationFunction = activationFunction;
        this.bias = bias;
        this.edges = edges;
    }

    public Neuron() {
    }

    public void setActivationFunction(IActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public IActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public double getBias() {
        return bias;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public double activate(double[] inputs){
        double z = bias;
        if (edges == null)
            return activationFunction.activate(z);
        for (int i = 0; i < edges.size(); i++) {
            z += edges.get(i).weight * inputs[i];
        }
        return activationFunction.activate(z);
    }
}
