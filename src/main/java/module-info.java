module circulorojo.cajeroautomatico {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;


    opens circulorojo.cajeroautomatico to javafx.fxml;
    exports circulorojo.cajeroautomatico;
}