package functions;

public class SigmoidFunction implements IActivationFunction {
    @Override
    public double activate(double value) {
        return 1.0 / (1.0 + Math.exp(-value));
    }
}
