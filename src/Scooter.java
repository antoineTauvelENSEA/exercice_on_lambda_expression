import com.interactivemesh.jfx.importer.obj.ObjModelImporter;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Scooter extends Group {
        public Scooter(Scene s) {
            ObjModelImporter importer = new ObjModelImporter();
            try {
                importer.read("model/scooter-smgrps.obj");
            } catch (Exception e) {
                System.out.println("Broken link");
            }

            for (MeshView parts : importer.getImport()) {
                this.getChildren().add(parts);
            }   // Bonus : change this for loop to a ForEach with a method reference.

            this.getTransforms().add(new Rotate(90, Rotate.Y_AXIS));
        }
    }