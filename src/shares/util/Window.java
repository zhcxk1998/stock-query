package shares.util;

import javafx.scene.control.Alert;

import java.util.*;

/**
 * @author BB小天使
 * @author Yumen
 * @version 1.0
 */
public class Window {

    // show the alert
    public void alert(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("我是祖传弹窗~");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
