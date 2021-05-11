package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label userNameLabel;

    @FXML
    private Label OSLabel;

    @FXML
    private Label javaLabel;

    @FXML
    private Label userDirectoryLabel;

    @FXML
    private Label userDirectorySizeLabel;

    @FXML
    private Label JVMTotalSizeLabel;

    @FXML
    private Label JVMAvailableSizeLabel;

    @FXML
    private Label JVMFreeSizeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String osArch = System.getProperty("os.arch");
        String userDir = System.getProperty("user.home");
        String userName = System.getProperty("user.name");
        String javaVersion = System.getProperty("java.version");


        long userDirSize = 0;
        userDirSize = FileUtils.sizeOfDirectory(new File(System.getProperty("user.home")));

        long totalSizeForJVM = Runtime.getRuntime().totalMemory();
        long availableSizeForJVM = Runtime.getRuntime().maxMemory();
        long freeSizeForJVM = Runtime.getRuntime().freeMemory();

        userNameLabel.setText("Meno používateľa: " + userName);
        OSLabel.setText("Operačný systém: " + osName  + " verzia: " + osVersion + " architektúra: " + osArch);
        javaLabel.setText("Verzia javy: " + javaVersion);
        userDirectoryLabel.setText("Používateľský adresár: " + userDir);
        userDirectorySizeLabel.setText("Veľkosť používateľského adresára: " + userDirSize + " B");
        JVMTotalSizeLabel.setText("Celková dostupná pamäť pre JVM: " + totalSizeForJVM + " B");
        JVMAvailableSizeLabel.setText("Dostupná pamäť pre JVM: " + availableSizeForJVM + " B");
        JVMFreeSizeLabel.setText("Voľná pamäť v JVM: " + freeSizeForJVM + " B");

    }




}
