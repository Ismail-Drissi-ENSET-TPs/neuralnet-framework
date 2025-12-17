package functions.adapter;

import functions.IActivationFunction;
import functions.old.OldFunction;

public class OldFunctionAdapter implements IActivationFunction {

    private OldFunction oldFunction;

    @Override
    public double activate(double value) {
        return oldFunction.compute(value);
    }

}
