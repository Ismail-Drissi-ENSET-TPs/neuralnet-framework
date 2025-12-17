package entities;

import functions.IActivationFunction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class Neuron {
    IActivationFunction activationFunction;
    double bias;
    List<Edge> edges;

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
