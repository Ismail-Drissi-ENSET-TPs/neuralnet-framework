package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class Layer {
    List<Neuron> neurons;

    public Layer(List<Neuron> neurons) {
        this.neurons = neurons;
    }

    public Layer() {
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(List<Neuron> neurons) {
        this.neurons = neurons;
    }
}
