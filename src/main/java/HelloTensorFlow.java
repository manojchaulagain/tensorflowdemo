import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;
import org.tensorflow.Tensors;

public class HelloTensorFlow {
    public static void main(String[] args) {
        try (Graph g = new Graph()) {
            final String value = "Hello from " + TensorFlow.version();

            // Construct the computation graph with a single operation, a constant
            // named "MyConst" with a value "value".
            double[] data = { 2, 3, 4, 5, 6, 7, 8, 9 };
            double[] data2 = { 2, 3, 4, 5, 6, 7, 8, 9 };
            try (Tensor<Double> t = Tensors.create(data)) {
//            try (Tensor t = Tensor.create(value.getBytes(StandardCharsets.UTF_8))) {
                // The Java API doesn't yet include convenience functions for adding operations.
//                g.opBuilder("Const", "MyConst").setAttr("dtype", t.dataType()).setAttr("value", t).build();
                g.opBuilder("DOUBLE", "data").setAttr("dtype", t.dataType()).setAttr("value", t).build();
            }

            // Execute the "MyConst" operation in a Session.
            try (Session s = new Session(g);
                 // Generally, there may be multiple output tensors,
                 // all of them must be closed to prevent resource leaks.
                 Tensor output = s.runner().fetch("data").run().get(0)) {
                System.out.println(output.doubleValue());
            }
        }
    }
}
