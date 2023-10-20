package genericsAdvanced.model;

public class BirkbeckStudent extends Student {

    private double percentComplete;

    // This code will call the super constructor implicitly.
    public BirkbeckStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    // % needs to be escaped, therefore using double %%.
    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
