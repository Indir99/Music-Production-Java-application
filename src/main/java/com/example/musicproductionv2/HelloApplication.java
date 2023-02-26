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
            return connection;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ObservableList<izvodjac> getDataIzvodjac() throws SQLException {
        Connection conn = ConnectDb();

        ObservableList<izvodjac> listIzvodjac = FXCollections.observableArrayList();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM izvodjac");
            while (rs.next()){
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

    public static ObservableList<tekstopisac> getDataTekstopisac() throws SQLException {
        Connection conn = ConnectDb();

        ObservableList<tekstopisac> listTekstopisac = FXCollections.observableArrayList();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM tekstopisac");
            while (rs.next()){
                listTekstopisac.add(new tekstopisac(Integer.parseInt(rs.getString("sifraTekstopisac")),rs.getString("imeTekstopisac"),
                        rs.getString("prezimeTekstopisac"),rs.getString("umjImeTekstopisac"), rs.getString("adresaTekstopisac"),
                        rs.getString("kontaktTekstopisac"),rs.getDate("datRodjTekstopisac")));
            }
        } catch (Exception e)
        {
            System.out.println(e.fillInStackTrace());
        }
        return listTekstopisac;
    }


    public static ObservableList<aranzer> getDataAranzer() throws SQLException {
        Connection conn = ConnectDb();

        ObservableList<aranzer> listAranzer = FXCollections.observableArrayList();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM aranzer");
            while (rs.next()){
                listAranzer.add(new aranzer(Integer.parseInt(rs.getString("sifraAranzer")),rs.getString("imeAranzer"),
                        rs.getString("prezimeAranzer"),rs.getString("umjImeAranzer"), rs.getString("adresaAranzer"),
                        rs.getString("kontaktAranzer"),rs.getDate("datRodjAranzer")));
            }
        } catch (Exception e)
        {
            System.out.println(e.fillInStackTrace());
        }
        return listAranzer;
    }


    public static ObservableList<kompozitor> getDataKompozitor() throws SQLException {
        Connection conn = ConnectDb();

        ObservableList<kompozitor> listKompozitor = FXCollections.observableArrayList();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM kompozitor");
            while (rs.next()){
                listKompozitor.add(new kompozitor(Integer.parseInt(rs.getString("sifraKompozitor")),rs.getString("imeKompozitor"),
                        rs.getString("prezimeKompozitor"),rs.getString("umjImeKompozitor"), rs.getString("adresaKompozitor"),
                        rs.getString("kontaktKompozitor"),rs.getDate("datRodjKompozitor")));
            }
        } catch (Exception e)
        {
            System.out.println(e.fillInStackTrace());
        }
        return listKompozitor;
    }
}