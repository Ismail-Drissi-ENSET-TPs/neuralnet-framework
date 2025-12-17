package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data @Builder
public class Edge {
    double weight;
    Neuron prev;
    Neuron next;
}
