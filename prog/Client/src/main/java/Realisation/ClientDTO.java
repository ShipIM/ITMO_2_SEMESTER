package Realisation;

import Models.Command;
import Models.User;

import java.io.Serializable;

public class ClientDTO implements Serializable {
    private Command.CommandData commandData;
    private Languages language;
    private boolean isRequest;
    private User user;

    public ClientDTO(Command.CommandData commandData, Languages language, boolean isRequest, User user) {
        this.commandData = commandData;
        this.language = language;
        this.isRequest = isRequest;
        this.user = user;
    }

    public ClientDTO(Command.CommandData commandData, User user) {
        this.commandData = commandData;
        this.user = user;
    }

    public ClientDTO(boolean isRequest) {
        this.isRequest = isRequest;
    }

    public Command.CommandData getCommandData() {
        return commandData;
    }

    public boolean isRequest() {
        return isRequest;
    }

    public User getUser() {
        return user;
    }

    public Languages getLanguage() {
        return language;
    }
}
