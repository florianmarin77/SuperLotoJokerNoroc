package com.lafi.sljn;

import com.lafi.sljn.internal.database.LottoRepository;
import com.lafi.sljn.internal.loader.UniversalLoader;
import com.lafi.sljn.internal.model.Sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.util.List;

public class MainApp extends Application {

    private TableView<Sample> table = new TableView<>();
    private TableColumn<Sample, Integer> colSpecial = new TableColumn<>("Joker");

    @Override
    public void start(Stage stage) {
        // 1. Încărcăm datele în Repository (Logica rămâne "stâncă")
        initData();

        // 2. Configurăm Tabelul
        setupTable();

        // 3. Creăm Butoanele de Navigare
        Button btnLoto = new Button("Loto 6/49");
        Button btnJoker = new Button("Joker");
        Button btnSuper = new Button("Super 5/40");

        // Stilăm puțin butoanele
        btnLoto.setPrefWidth(100);
        btnJoker.setPrefWidth(100);
        btnSuper.setPrefWidth(100);

        // 4. Definim acțiunile butoanelor (Evenimentele)
        btnLoto.setOnAction(e -> switchData(LottoRepository.getInstance().getLotoData(), false));
        btnJoker.setOnAction(e -> switchData(LottoRepository.getInstance().getJokerData(), true));
        btnSuper.setOnAction(e -> switchData(LottoRepository.getInstance().getSuperData(), false));

        // 5. Layout-ul
        HBox menuBar = new HBox(10, btnLoto, btnJoker, btnSuper);
        menuBar.setPadding(new Insets(10));

        VBox mainLayout = new VBox(10, menuBar, table);
        VBox.setVgrow(table, javafx.scene.layout.Priority.ALWAYS);

        Scene scene = new Scene(mainLayout, 800, 600);
        stage.setTitle("Sălăjan - Tablou de Bord");
        stage.setScene(scene);
        stage.show();

        // Pornim implicit cu Joker (că tot ne-a purtat noroc)
        switchData(LottoRepository.getInstance().getJokerData(), true);
    }

    private void initData() {
        UniversalLoader loader = new UniversalLoader();
        LottoRepository repository = LottoRepository.getInstance();
        repository.setLotoData(loader.loadFromFile(Path.of("resources/loto.txt"), false));
        repository.setSuperData(loader.loadFromFile(Path.of("resources/super.txt"), false));
        repository.setJokerData(loader.loadFromFile(Path.of("resources/joker.txt"), true));
    }

    private void setupTable() {
        TableColumn<Sample, Integer> colIndex = new TableColumn<>("Nr.");
        colIndex.setCellValueFactory(new PropertyValueFactory<>("index"));

        TableColumn<Sample, String> colDate = new TableColumn<>("Data");
        colDate.setCellValueFactory(new PropertyValueFactory<>("datex"));

        TableColumn<Sample, String> colNums = new TableColumn<>("Numere");
        colNums.setCellValueFactory(new PropertyValueFactory<>("intexString"));

        colSpecial.setCellValueFactory(new PropertyValueFactory<>("special"));

        TableColumn<Sample, String> colCodex = new TableColumn<>("Codex");
        colCodex.setCellValueFactory(new PropertyValueFactory<>("codex"));

        table.getColumns().addAll(colIndex, colDate, colNums, colSpecial, colCodex);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void switchData(List<Sample> data, boolean showSpecial) {
        table.getItems().clear();
        table.getItems().addAll(data);
        colSpecial.setVisible(showSpecial); // Ascundem coloana Joker dacă nu e Joker
    }

    public static void main(String[] args) {
        launch(args);
    }
}