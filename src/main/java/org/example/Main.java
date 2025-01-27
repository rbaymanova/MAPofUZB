package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private Map<Color, String> colorToRegionMap = new HashMap<>();
    private Map<String, String > RegionArea = new HashMap<>();
    private Map<String, String > RegionPopulation = new HashMap<>();


    @Override
    public void start(Stage stage) throws Exception {
        initializeColorToRegionMap();
        regionsArea();
        regionPopulation();

        Image mapImage = new Image(getClass().getResource("/u1.png").toExternalForm());
        ImageView mapView = new ImageView(mapImage);

        mapView.fitWidthProperty().bind(stage.widthProperty());
        mapView.fitHeightProperty().bind(stage.heightProperty());
        mapView.setPreserveRatio(true);

        StackPane stackPane = new StackPane(mapView);
        Scene scene = new Scene(stackPane, mapImage.getWidth(), mapImage.getHeight());

        mapView.setOnMouseClicked(event -> onMapClick(event, mapImage));

        stage.setScene(scene);
        stage.setTitle("Map");
        stage.sizeToScene();
        stage.show();
    }

    private void initializeColorToRegionMap() {
        colorToRegionMap.put(Color.web("#ED1C24"), "Karakalpakistan");
        colorToRegionMap.put(Color.web("#FFF200"), "Navoi");
        colorToRegionMap.put(Color.web("#3F48CC"), "Khorezm");
        colorToRegionMap.put(Color.web("#B97A57"), "Bukhara");
        colorToRegionMap.put(Color.web("#40E0D0"), "Samarkand");
        colorToRegionMap.put(Color.web("#A349A4"), "Kashkadarya");
        colorToRegionMap.put(Color.web("#FF7F27"), "Surkhandarya");
        colorToRegionMap.put(Color.web("#FFBCBD"), "Jizzakh");
        colorToRegionMap.put(Color.web("#B4B221"), "Sirdarya");
        colorToRegionMap.put(Color.web("#7FFF00"), "Tashkent");
        colorToRegionMap.put(Color.web("#FF335A"), "Namangan");
        colorToRegionMap.put(Color.web("#7F7F7F"), "Andijan");
        colorToRegionMap.put(Color.web("#E5FF2E"), "Ferghana");
    }

    private void regionsArea(){
        RegionArea.put("15,585", "Tashkent");
        RegionArea.put("6,464", "Khorezm");
        RegionArea.put("7,181", "Namangan");
        RegionArea.put("41,937", "Bukhara");
        RegionArea.put("20,099", "Surkhandarya");
        RegionArea.put("28,568", "Kashkadarya");
        RegionArea.put("4,276", "Sirdarya");
        RegionArea.put("7,005", "Ferghana");
        RegionArea.put("4,303", "Andijan");
        RegionArea.put("109,375", "Navoi");
        RegionArea.put("21,179", "Jizzakh");
        RegionArea.put("16,773", "Samarkand");
        RegionArea.put("161,358", "Karakalpakistan");
    }

    private void regionPopulation(){
        RegionPopulation.put("5,253,400", "Tashkent");
        RegionPopulation.put("1,776,700", "Khorezm");
        RegionPopulation.put("2,652,400", "Namangan");
        RegionPopulation.put("1,843,500", "Bukhara");
        RegionPopulation.put("2,462,300", "Surkhandarya");
        RegionPopulation.put("2,088,800", "Kashkadarya");
        RegionPopulation.put("803,100", "Sirdarya");
        RegionPopulation.put("3,564,800", "Ferghana");
        RegionPopulation.put("2,965,500", "Andijan");
        RegionPopulation.put("942,800", "Navoi");
        RegionPopulation.put("1,301,000", "Jizzakh");
        RegionPopulation.put("3,651,700", "Samarkand");
        RegionPopulation.put("1,817,500", "Karakalpakistan");
    }

    private boolean colorsAreClose(Color c1, Color c2) {
        double tolerance = 0.15;
        return Math.abs(c1.getRed() - c2.getRed()) < tolerance &&
                Math.abs(c1.getGreen() - c2.getGreen()) < tolerance &&
                Math.abs(c1.getBlue() - c2.getBlue()) < tolerance;
    }


    private void onMapClick(MouseEvent event, Image mapImage) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        Color clickedColor = mapImage.getPixelReader().getColor(x, y);

        String region = "Unknown Region";
        String area = "Unknown Area";
        String population = "Unknown Population";


        for (Map.Entry<Color, String> entry : colorToRegionMap.entrySet()) {
            Color regionColor = entry.getKey();
            if (colorsAreClose(clickedColor, regionColor)) {
                region = entry.getValue();
                break;
            }
        }


        for (Map.Entry<String, String> entry : RegionArea.entrySet()) {
            if (entry.getValue().equals(region)) {
                area = String.valueOf(entry.getKey());
                break;
            }
        }

        for (Map.Entry<String, String> entry : RegionPopulation.entrySet()) {
            if (entry.getValue().equals(region)) {
                population = String.valueOf(entry.getKey());
                break;
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Region Info");
        alert.setHeaderText("Region Clicked");
        alert.setContentText("Region: " + region + "\nArea: " + area + "\nPopulation: " + population);
        alert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
