import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FractalCanvas extends Application {
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        // Draw the fractals or other visualizations on the canvas here using GraphicsContext methods

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 400, 400, Color.WHITE);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Fractal Visualization");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
