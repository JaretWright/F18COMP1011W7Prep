package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GraphViewController implements Initializable {

    @FXML
    private BarChart<?,?> barChart;

    @FXML
    private CategoryAxis movies;

    @FXML
    private NumberAxis students;

    private XYChart.Series movieSeriesMale;
    private XYChart.Series moviesSeriesFemale;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        movieSeriesMale = new XYChart.Series();
        barChart.setTitle("Favourite type of movie");
        movies.setLabel("movie type");
        students.setLabel("# of students");

        //add data to the the data series
        movieSeriesMale.getData().add(new XYChart.Data("Comedy", 10));
        movieSeriesMale.getData().add(new XYChart.Data("Action",15));
        movieSeriesMale.getData().add(new XYChart.Data("Romance", 5));
        movieSeriesMale.getData().add(new XYChart.Data("Thriller", 9));
        movieSeriesMale.setName("Male");

        moviesSeriesFemale = new XYChart.Series();
        moviesSeriesFemale.getData().add(new XYChart.Data("Comedy",7));
        moviesSeriesFemale.getData().add(new XYChart.Data("Action",2));
        moviesSeriesFemale.getData().add(new XYChart.Data("Romance", 8));
        moviesSeriesFemale.getData().add(new XYChart.Data("Thriller", 6));
        moviesSeriesFemale.setName("Female");

        //add the data series to the bar chart
        barChart.getData().addAll(movieSeriesMale);
        barChart.getData().addAll(moviesSeriesFemale);
    }

    @FXML
    public void returnToTableViewButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../Views/TableOfPhones.fxml",
                            "Table of Phones");
    }
}
