import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FractalCanvas extends Application {
    private int canvasWidth = 800;
    private int canvasHeight = 600;
    private int rectHeight = 30;
    private int rectWidth = 50;
    private Canvas canvas;
    private GraphicsContext gc;
    private int numRectsX;
    private int numRectsY;
    private int currentRow = 0;
    private int currentCol = 0;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(canvasWidth, canvasHeight);
        gc = canvas.getGraphicsContext2D();
        numRectsX = canvasWidth / rectWidth;
        numRectsY = canvasHeight / rectHeight;

        
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                drawRectangles();
                // Stop the animation when all rectangles are drawn
                if (currentRow >= numRectsY && currentCol >= numRectsX) {
                    stop();
                }
            }
        };
        animationTimer.start();


        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 400, 400, Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Fractal Visualization");
        primaryStage.show();
    }

    private void drawRectangles() {
        if (currentRow < numRectsY) {
            double x = currentCol * rectWidth;
            double y = currentRow * rectHeight;
            gc.setFill(Color.BLUE);
            gc.fillRect(x, y, rectWidth, rectHeight);

            currentCol++;
            if (currentCol >= numRectsX) {
                currentCol = 0;
                currentRow++;
            }

            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

