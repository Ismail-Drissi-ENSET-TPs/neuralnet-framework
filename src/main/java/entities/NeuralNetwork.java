package entities;

import annotations.Log;
import enums.NNState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import observers.Observer;
import observers.Subject;
import states.ConstructionState;
import states.INetworkState;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork implements Subject {
    List<Layer> layers;
    List<Observer> observers = new ArrayList<>();
    INetworkState state = new ConstructionState();

    public NeuralNetwork(List<Layer> layers, List<Observer> observers, INetworkState state) {
        this.layers = layers;
        this.observers = observers;
        this.state = state;
    }

    public NeuralNetwork() {
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    public void setState(INetworkState state) {
        this.state = state;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public INetworkState getState() {
        return state;
    }

    @Override
    public void add(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public void train(){
        state.train(this);
    }

    public void fit(){
        state.fit(this);
    }

    @Log
    public double[] predict(double[] input) {
        return state.predict(this, input);
    }
}
