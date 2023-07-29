// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.canvas.Canvas;
// import javafx.scene.canvas.GraphicsContext;
// import javafx.scene.layout.StackPane;
// import javafx.scene.paint.Color;
// import javafx.stage.Stage;

// public class FractalCanvas extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         int canvasWidth = 800;
//         int canvasHeight = 800;
//         int numIterations = 15; // Increase this value for a more detailed Dragon Curve

//         Canvas canvas = new Canvas(canvasWidth, canvasHeight);
//         GraphicsContext gc = canvas.getGraphicsContext2D();

//         // Scaling and translation parameters to fit the Dragon Curve within the canvas
//         double scale = 200; // Adjust this value to control the scale of the Dragon Curve
//         double translateX = canvasWidth / 2.0;
//         double translateY = canvasHeight / 2.0;

//         // Starting point for the Dragon Curve
//         double x = 1;
//         double y = 0;

//         // Set the line width for the Dragon Curve
//         gc.setLineWidth(40.0); // Adjust this value to control the thickness of the lines

//         // Iteratively generate the Dragon Curve
//         for (int i = 0; i < numIterations; i++) {
//             // Calculate the next position using Dragon Curve rules
//             double newX = (x + y) / Math.sqrt(2);
//             double newY = (y - x) / Math.sqrt(2);

//             // Draw the line segment on the canvas
//             gc.setStroke(Color.BLACK);
//             gc.strokeLine(x * scale + translateX, y * scale + translateY, newX * scale + translateX, newY * scale + translateY);

//             x = newX;
//             y = newY ;
//         }

//         StackPane root = new StackPane(canvas);
//         Scene scene = new Scene(root, canvasWidth, canvasHeight);
//         primaryStage.setScene(scene);
//         primaryStage.setTitle("Dragon Curve");
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }



//     @Override
//     public void start(Stage primaryStage) {
//         int canvasWidth = 800;
//         int canvasHeight = 800;
//         double escapeValue = 2.0;
//         int maxIterations = 100;

//         Canvas canvas = new Canvas(canvasWidth, canvasHeight);
//         GraphicsContext gc = canvas.getGraphicsContext2D();
//         //this is the point where we make the recursion limits our equation
//         //we are running the formula to account for the -2 , 2 range of the complex plan
//         // and making our 0,4  range of the canvas convert to the complex plane
//         for (int x = 0; x < canvasWidth; x++) {
//             for (int y = 0; y < canvasHeight; y++) {
//                 double zx = x * 4.0 / canvasWidth - 2.0;
//                 double zy = y * 4.0 / canvasHeight - 2.0;
//                 //here we are saving the coordinate of the previous points to change with the iteratoions
//                 double cX = zx;
//                 double cY = zy;
//                 int iteration = 0;
//                 // This is the mandelbrot iteration for his equation z = z^2 + c while iterating
//                 // until we hit our maximum
//                 while (zx * zx + zy * zy < escapeValue && iteration < maxIterations) {
//                     //here we set the new value for each zx and zy by solving for each respectivly
//                     // after computing

//                     double tmp = zx * zx - zy * zy + cX;
//                     zy = 2.0 * zx * zy + cY;
//                     zx = tmp;
//                     iteration++;
//                 }

//                 // Color the point based on the number of iterations
//                 if (iteration == maxIterations) {
//                     gc.setFill(Color.BLACK);
//                 } else {
//                     double hue = (double) iteration / maxIterations;
//                     gc.setFill(Color.hsb(360 * hue, 1.0, 1.0));
//                 }

//                 gc.fillRect(x, y, 1, 1);
//             }
//         }

//         StackPane root = new StackPane(canvas);
//         Scene scene = new Scene(root, canvasWidth, canvasHeight);
//         primaryStage.setScene(scene);
//         primaryStage.setTitle("Mandelbrot Set");
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.canvas.Canvas;
// import javafx.scene.canvas.GraphicsContext;
// import javafx.scene.layout.StackPane;
// import javafx.scene.paint.Color;
// import javafx.stage.Stage;

// public class FractalCanvas extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         int canvasWidth = 800;
//         int canvasHeight = 600;
//         int rectHeight = 30;
//         int rectWidth = 50;
//         Canvas canvas = new Canvas(canvasWidth, canvasHeight);
//         GraphicsContext gc = canvas.getGraphicsContext2D();
        
//         gc.setFill(Color.BLUE);
//         int numRectsX = canvasWidth / rectWidth;
//         int numRectsY = canvasHeight / rectHeight;
//         for (int row = 0; row < numRectsY; row++) {
//             for (int col = 0; col < numRectsX; col++) {
//                 double x = col * rectWidth;
//                 double y = row * rectHeight;
//                 gc.fillRect(x, y, rectWidth, rectHeight);
//             }
//         }
        
//         // Draw the fractals or other visualizations on the canvas here using GraphicsContext methods

//         StackPane root = new StackPane(canvas);
//         Scene scene = new Scene(root, 400, 400, Color.WHITE);
        
//         primaryStage.setScene(scene);
//         primaryStage.setTitle("JavaFX Fractal Visualization");
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }






        //THIS IS FOR ANIMATIONS
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

        // Start the animation timer
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

        // Draw the fractals or other visualizations on the canvas here using GraphicsContext methods

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

            // Add a delay of 50 milliseconds (adjust as needed)
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

