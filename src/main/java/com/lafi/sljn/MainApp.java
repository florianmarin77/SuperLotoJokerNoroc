package com.lafi.sljn;

import com.lafi.sljn.internal.analysis.StatisticsEngine;
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
import java.util.Map;

public class MainApp extends Application {

    private TableView<Sample> table = new TableView<>();
    private TableColumn<Sample, Integer> colSpecial = new TableColumn<>("Joker");
    private TextArea statsArea = new TextArea();
    private StatisticsEngine engine = new StatisticsEngine();

    @Override
    public void start(Stage stage) {
        initData();
        setupTable();

        statsArea.setEditable(false);
        statsArea.setPrefHeight(150);
        statsArea.setPromptText("Statisticile vor apărea aici...");

        Button btnLoto = new Button("Loto 6/49");
        Button btnJoker = new Button("Joker");
        Button btnSuper = new Button("Super 5/40");

        btnLoto.setOnAction(e -> updateUI(LottoRepository.getInstance().getLotoData(), false, "Statistici Loto 6/49"));
        btnJoker.setOnAction(e -> updateUI(LottoRepository.getInstance().getJokerData(), true, "Statistici Joker"));
        btnSuper.setOnAction(e -> updateUI(LottoRepository.getInstance().getSuperData(), false, "Statistici Super 5/40"));

        HBox menuBar = new HBox(10, btnLoto, btnJoker, btnSuper);
        menuBar.setPadding(new Insets(10));

        // Adăugăm și statsArea în layout
        VBox mainLayout = new VBox(10, menuBar, table, new Label("Raport Analiză Istoric:"), statsArea);
        VBox.setVgrow(table, javafx.scene.layout.Priority.ALWAYS);
        mainLayout.setPadding(new Insets(10));

        Scene scene = new Scene(mainLayout, 900, 700);
        stage.setTitle("Sălăjan - Analiză Statistică Completă");
        stage.setScene(scene);
        stage.show();

        // Pornire implicită
        updateUI(LottoRepository.getInstance().getLotoData(), false, "Statistici Loto 6/49");
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

    // O nouă metodă care face ambele acțiuni: schimbă datele și recalculează statistica
    private void updateUI(List<Sample> data, boolean showSpecial, String title) {
        // 1. Actualizăm datele din tabel
        table.getItems().clear();
        table.getItems().addAll(data);
        colSpecial.setVisible(showSpecial);

        // 2. Calculăm frecvențele folosind motorul statistic
        Map<Integer, Integer> freqs = engine.calculateFrequency(data);
        List<Map.Entry<Integer, Integer>> sortedFreqs = engine.getSortedFrequencies(freqs);

        // 3. Construim raportul textual
        StringBuilder sb = new StringBuilder();
        sb.append("==========================================\n");
        sb.append("   RAPORT STATISTIC: ").append(title.toUpperCase()).append("\n");
        sb.append("==========================================\n");
        sb.append("Total extrageri analizate: ").append(data.size()).append("\n\n");

        // Secțiunea TOP 10 Cele mai frecvente
        sb.append("🔥 TOP 10 CELE MAI FRECVENTE NUMERE (HOT):\n");
        for (int i = 0; i < Math.min(10, sortedFreqs.size()); i++) {
            Map.Entry<Integer, Integer> entry = sortedFreqs.get(i);
            sb.append(String.format("Loc %2d:  Bila %02d  --->  %d apariții\n",
                    (i + 1), entry.getKey(), entry.getValue()));
        }

        sb.append("\n❄️ TOP 10 CELE MAI RARE NUMERE (COLD):\n");
        // Parcurgem lista de la coadă la cap pentru cele mai rare
        int rank = 1;
        for (int i = sortedFreqs.size() - 1; i >= Math.max(0, sortedFreqs.size() - 10); i--) {
            Map.Entry<Integer, Integer> entry = sortedFreqs.get(i);
            sb.append(String.format("Loc %2d:  Bila %02d  --->  %d apariții\n",
                    rank++, entry.getKey(), entry.getValue()));
        }

        if (showSpecial) {
            Map<Integer, Integer> specialFreqs = engine.calculateSpecialFrequency(data);
            List<Map.Entry<Integer, Integer>> sortedSpecials = engine.getSortedFrequencies(specialFreqs);

            sb.append("\n👑 STATISTICI URNA SPECIALĂ (JOKER 1-20):\n");
            sb.append("------------------------------------------\n");

            // Top 3 Jokeri
            sb.append("Top 3 cei mai frecvenți JOKERI:\n");
            for (int i = 0; i < Math.min(3, sortedSpecials.size()); i++) {
                Map.Entry<Integer, Integer> entry = sortedSpecials.get(i);
                sb.append(String.format("   Loc %d: Bila %02d (%d apariții)\n", (i+1), entry.getKey(), entry.getValue()));
            }

            sb.append("\nDistribuție JOKER (Bila:Apariții):\n");
            int jCount = 0;
            for (Map.Entry<Integer, Integer> entry : specialFreqs.entrySet()) {
                sb.append(String.format("[%02d:%3d] ", entry.getKey(), entry.getValue()));
                jCount++;
                if (jCount % 5 == 0) sb.append("\n");
            }
            sb.append("\n");
        }

        sb.append("\n------------------------------------------\n");
        sb.append("DISTRIBUȚIA COMPLETĂ (Număr:Apariții):\n");
        sb.append("------------------------------------------\n");

        // Afișăm grila completă (TreeMap-ul din engine ne asigură că sunt ordonate 1, 2, 3...)
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            sb.append(String.format("[%02d:%3d]  ", entry.getKey(), entry.getValue()));
            count++;
            if (count % 8 == 0) sb.append("\n"); // Nouă linie la fiecare 8 numere pentru lizibilitate
        }

        // 4. Trimitem tot textul către interfață
        statsArea.setText(sb.toString());

        // Bonus: Ducem scroll-ul la începutul textului
        statsArea.setScrollTop(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}