package com.lafi.sljn;

import com.lafi.sljn.internal.database.LottoRepository;
import com.lafi.sljn.internal.loader.UniversalLoader;
import javafx.application.Application;
import javafx.stage.Stage;

import java.nio.file.Path;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Inițializăm Loader-ul și Repository-ul
        UniversalLoader loader = new UniversalLoader();
        LottoRepository repository = LottoRepository.getInstance();

        // 2. Încărcăm datele (Presupunem că fișierele sunt în folderul rădăcină al proiectului)
        // Notă: În JavaFX, căile pot fi relative la rădăcina proiectului
        repository.setLotoData(loader.loadFromFile(Path.of("resources/loto.txt"), false));
        repository.setSuperData(loader.loadFromFile(Path.of("resources/super.txt"), false));
        repository.setJokerData(loader.loadFromFile(Path.of("resources/joker.txt"), true));

        // 3. Confirmare în consolă
        System.out.println("Sălăjan a încărcat:");
        System.out.println("Loto 6/49: " + repository.getLotoData().size() + " extrageri.");
        System.out.println("Super 5/40: " + repository.getSuperData().size() + " extrageri.");
        System.out.println("Joker: " + repository.getJokerData().size() + " extrageri.");

        // 4. Interfața grafică (un buton simplu de test)
        javafx.scene.control.Button btn = new javafx.scene.control.Button("Date încărcate cu succes!");
        stage.setScene(new javafx.scene.Scene(new javafx.scene.layout.StackPane(btn), 400, 300));
        stage.setTitle("Sălăjan Lotto Analyzer");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}