package com.example.musicproductionv2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.sql.*;

public class HelloApplication extends Application {

    double x,y = 0;
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root, 1200, 500);
        primaryStage.setTitle("Muzicka produkcija");
        //move around
        root.setOnMousePressed( e -> {
           x = e.getSceneX();
           y = e.getSceneY();
        });
        root.setOnMouseDragged( e -> {
            primaryStage.setX(e.getScreenX()-x);
            primaryStage.setY(e.getScreenY()-y);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    Connection conn = null;
    public static Connection ConnectDb() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/muzickaProdukcija", "indir", "Iceking99.");
            Statement statement = connection.createStatement();

            //ResultSet resultSet = statement.executeQuery("SELECT * FROM izvodjac");
            //while (resultSet.next()) {
            //    System.out.println(resultSet.getString("imeIzvodjac"));
           // }
            return connection;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ObservableList<izvodjac> getDataIzvodjac() throws SQLException {
        System.out.println("Hahahaha");
        Connection conn = ConnectDb();
        //Statement statement = conn.createStatement();
        //ResultSet resultSet = statement.executeQuery("SELECT * FROM izvodjac");

        ObservableList<izvodjac> listIzvodjac = FXCollections.observableArrayList();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM izvodjac");
            while (rs.next()){
                System.out.println(listIzvodjac.size());
                //System.out.println(rs.getString("imeIzvodjac"));
                listIzvodjac.add(new izvodjac(Integer.parseInt(rs.getString("sifraIzvodjac")),rs.getString("imeIzvodjac"),
                        rs.getString("prezimeIzvodjac"),rs.getString("umjImeIzvodjac"), rs.getString("adresaIzvodjac"),
                        rs.getString("kontaktIzvodjac"),rs.getDate("datRodjIzvodjac")));
            }
        } catch (Exception e)
        {
            System.out.println(e.fillInStackTrace());
        }
        return listIzvodjac;
    }
}