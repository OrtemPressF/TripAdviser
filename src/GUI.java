//package sk.stuba.fiit.gui;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.TextArea;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
//import sk.stuba.fiit.City;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintStream;
//
//public class GUI extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    private TextArea consoleTextArea;
//
//    @Override
//    public void start(Stage primaryStage) {
//
//        // Create the UI components
//        consoleTextArea = new TextArea();
//
//        // Redirect the console output to the text area
//        System.setOut(new PrintStream(new ConsoleOutputStream(consoleTextArea)));
//        System.setErr(new PrintStream(new ConsoleOutputStream(consoleTextArea)));
//
//        // Create the layout
//        BorderPane root = new BorderPane();
//        root.setCenter(consoleTextArea);
//
//        // Create the scene and show the stage
//        Scene scene = new Scene(root, 400, 400);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        //app logic
//        City arkham=new City();
//
//
//    }
//
//    private static class ConsoleOutputStream extends OutputStream {
//        private TextArea console;
//
//        public ConsoleOutputStream(TextArea console) {
//            this.console = console;
//        }
//
//        @Override
//        public void write(int b) throws IOException {
//            console.appendText(String.valueOf((char) b));
//        }
//    }
//}