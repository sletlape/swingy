package za.co.wethinkcode.sletlape.swingy.model.util;

import lombok.Getter;

import java.util.ArrayList;

public class GameMessages {
    @Getter
    ArrayList<String> messages  = new ArrayList<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    public void clearMessages() {
        messages.clear();
    }


}
