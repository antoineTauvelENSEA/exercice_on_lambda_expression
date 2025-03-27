import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {
    private double mouseX;
    private double mouseY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("A complex lambda Expression");

        Group root = new Group();
        Scene playScene = new Scene(root, 600, 400,true);
        Scooter moto = new Scooter(playScene);

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-5);
        playScene.setCamera(camera);

        root.getChildren().add(moto);

        playScene.addEventHandler(MouseEvent.MOUSE_CLICKED,
                mouseEvent ->{
                    mouseX=mouseEvent.getSceneX();
                    mouseY=mouseEvent.getSceneY();
                    System.out.println("Click on "+mouseX+" "+ mouseY);}
        );

        playScene.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                mouseEvent -> camera.setTranslateZ(-5+(mouseEvent.getY()-mouseY)/3));
        primaryStage.setScene(playScene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}