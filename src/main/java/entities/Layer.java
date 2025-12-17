package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data @Builder
public class Layer {
    List<Neuron> neurons;
}
