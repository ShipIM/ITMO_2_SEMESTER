package Controllers;

import Interaction.Parser;
import Main.Client;
import Models.*;
import Realisation.*;
import Utilities.Serializer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class LoginScreenController extends Controller {

    @FXML
    private ComboBox<String> languages;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label loginField;

    @FXML
    private Label passwordField;

    @FXML
    public void registration() {
        this.action("register");
    }

    @FXML
    public void log() {
        this.action("login");
    }

    @FXML
    private void initialize() {
        Client.resourceFactory.setLanguage(Languages.RUSSIAN);
        Arrays.stream(Languages.values()).forEach((x) -> this.languages.getItems().add(x.getName()));
        this.languages.setValue(Languages.RUSSIAN.getName());

        languages.valueProperty().addListener((observable, oldValue, newValue) -> Client.resourceFactory
                .setLanguage(Languages.getEnum(newValue)));

        loginField.textProperty().bind(Client.resourceFactory.getStringBinding("loginField"));
        passwordField.textProperty().bind(Client.resourceFactory.getStringBinding("passwordField"));
        loginButton.textProperty().bind(Client.resourceFactory.getStringBinding("loginButton"));
        registerButton.textProperty().bind(Client.resourceFactory.getStringBinding("registerButton"));
    }

    public void action(String command) {
        if (!this.isWaiting()) {
            new Thread(() -> {
                this.setWaiting(true);
                User user = new User(name.getText(), new HashPassword().hash(password.getText()));
                byte[] data = Parser.parseTo(new ClientDTO(new Command.CommandData(command,
                        Arrays.asList(Serializer.serialize(user))), Client.resourceFactory.getLanguage(),
                        true, null));

                this.getSender().sendResponse(data);

                ServerDTO<City> answer = this.blockGetAnswer();

                if (answer != null) {
                    if (answer.isSuccess()) {
                        Platform.runLater(() -> this.changeScreen(user, this.getListener(), answer));
                    } else {
                        alert(new String(answer.getMessage(), StandardCharsets.UTF_8), Alert.AlertType.ERROR);
                    }
                }
                this.setWaiting(false);
            }).start();
        }
    }

    private void changeScreen(User user, StorageListener listener, ServerDTO<City> answer) {
        try {
            loginButton.getScene().getWindow().hide();

            FXMLLoader preset = new FXMLLoader();
            URL xml = getClass().getResource("/MainScreen.fxml");
            preset.setLocation(xml);

            Parent root = preset.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root));

            MainScreenController controller = preset.getController();
            controller.setUser(user);
            controller.setSender(this.getSender());
            controller.setListener(listener);
            controller.setCommandManager(new CommandManager(answer.getCommandData()));
            controller.setWaiting(this.isWaiting());

            controller.updateContents(answer.getCollection());

            listener.setController(controller);

            secondStage.show();
            secondStage.setMinWidth(989);
            secondStage.setMinHeight(853);
            secondStage.setOnCloseRequest(windowEvent -> System.exit(0));
            secondStage.titleProperty().bind(Client.resourceFactory.getStringBinding("app"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
