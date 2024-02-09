package circulorojo.cajeroautomatico;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class keeptoController {
    @FXML
    private Label barStatus;
    @FXML
    private Label barStatusMin;
    @FXML
    private Button btn_credito;
    @FXML
    private Button btn_estados;
    @FXML
    private Button btn_home;
    @FXML
    private Button btn_inicio1;
    @FXML
    private Button btn_inicio2;
    @FXML
    private Button btn_inicio3;
    @FXML
    private Button btn_servicios;
    @FXML
    private FontAwesomeIconView iconStatus;
    @FXML
    private Button log_out;
    @FXML
    private GridPane screenIndex;
    @FXML
    private GridPane screenEstados;
    @FXML
    private GridPane screenServicios;
    @FXML
    private GridPane screenCredito;
    @FXML
    private Label num_cuenta;
    @FXML
    private Label num_cuenta1;
    @FXML
    private Label num_cuenta2;
    @FXML
    private Label saldoTxt;
    @FXML
    private Label creditoTxt;
    @FXML
    private Label saldoTxt1;
    @FXML
    private Label deudaTxt;
    @FXML
    private Label num_cuenta3;
    @FXML
    private RadioButton boton1;
    @FXML
    private RadioButton boton2;
    @FXML
    private RadioButton boton3;
    private ToggleGroup group;
    @FXML
    private Button btnPagar;

    @FXML
    public void initialize() {
        group = new ToggleGroup();
        boton1.setToggleGroup(group);
        boton2.setToggleGroup(group);
        boton3.setToggleGroup(group);
    }

    @FXML
    public void evtAlert(ActionEvent evtalert){
        Object evt = evtalert.getSource();

        if (evt.equals(btnPagar)){

            if (group.getSelectedToggle()==null){
                controller.AlertUtility.showInformationAlert("¡No selección!", "Al parecer no has seleccionado ninguna opcion, seleciona alguna e intenta de nuevo.");
            }else {
                controller.AlertUtility.showInformationAlert("¡Pago realizado!", "¡Todo salio bien!");
            }

        }
    }


    @FXML
    private void signOut(ActionEvent event){
        ((Node) (event.getSource())).getScene().getWindow().hide();
        try {
            Stage stage = (Stage) log_out.getScene().getWindow();
            stage.close();
            new loginMain().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void cambioEvent(ActionEvent mouseEvent){
        float saldo = 0;
        float credito = 0;
        float deuda = 0;

        if (controller.username.equals("1234567890")){
            saldo = 50002.50f;
            credito= 1030.042f;
            deuda = 4701.09f;
            saldoTxt.setText(String.format("%.2f",saldo));
            saldoTxt1.setText(String.format("%.2f",saldo));
            creditoTxt.setText(String.format("%.2f",credito));
            deudaTxt.setText(String.format("%.2f",deuda));

        }else if (controller.username.equals("2414205416")){
            saldo = 10032.12f;
            credito= 1020.04f;
            deuda = 5223.1f;
            saldoTxt.setText(String.format("%.2f",saldo));
            saldoTxt1.setText(String.format("%.2f",saldo));
            creditoTxt.setText(String.format("%.2f",credito));
            deudaTxt.setText(String.format("%.2f",deuda));
        }


        Button clicked = (Button) mouseEvent.getSource();

        String defaultStyle = "-fx-background-color: #12485e;";
        String activeStyle = "-fx-background-color: #15556e;";

        btn_estados.setStyle(defaultStyle);
        btn_servicios.setStyle(defaultStyle);
        btn_credito.setStyle(defaultStyle+ "-fx-background-radius: 0 0 30 30;");

        if(clicked == btn_home){

            screenIndex.setDisable(false);
            screenIndex.setVisible(true);
            iconStatus.setGlyphName("HOME");
            barStatusMin.setText("/inicio");
            barStatus.setText("Inicio");

        }else {
            screenIndex.setDisable(true);
            screenIndex.setVisible(false);
        }

        if(clicked == btn_estados || clicked == btn_inicio1){

            screenEstados.setDisable(false);
            screenEstados.setVisible(true);

            btn_estados.setStyle(activeStyle);

            iconStatus.setGlyphName("FILE");
            barStatusMin.setText("/inicio/estados de cuenta");
            barStatus.setText("Estados de Cuenta");


            num_cuenta1.setText(controller.username);
            num_cuenta2.setText(controller.username);

        }else{
            screenEstados.setDisable(true);
            screenEstados.setVisible(false);
        }

        if(clicked == btn_servicios || clicked == btn_inicio2){

            screenServicios.setDisable(false);
            screenServicios.setVisible(true);

            btn_servicios.setStyle(activeStyle);

            iconStatus.setGlyphName("TAG");
            barStatusMin.setText("/inicio/pago de servicios");
            barStatus.setText("Pago De Servicios");

            num_cuenta.setText(controller.username);

        }else{
            screenServicios.setDisable(true);
            screenServicios.setVisible(false);
        }
        if(clicked == btn_credito || clicked == btn_inicio3){

            screenCredito.setDisable(false);
            screenCredito.setVisible(true);

            btn_credito.setStyle(activeStyle + "-fx-background-radius: 0 0 30 30;");

            iconStatus.setGlyphName("CREDIT_CARD");
            barStatusMin.setText("/inicio/pago de credito");
            barStatus.setText("Pago De Credito");

            num_cuenta3.setText(controller.username);

        }else{
            screenCredito.setDisable(true);
            screenCredito.setVisible(false);
        }

    }
}