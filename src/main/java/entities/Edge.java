package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class Edge {
    double weight;
    Neuron prev;
    Neuron next;

    public Edge(double weight, Neuron prev, Neuron next) {
        this.weight = weight;
        this.prev = prev;
        this.next = next;
    }

    public Edge() {
    }

    public void setNext(Neuron next) {
        this.next = next;
    }

    public void setPrev(Neuron prev) {
        this.prev = prev;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public Neuron getNext() {
        return next;
    }

    public Neuron getPrev() {
        return prev;
    }


}

