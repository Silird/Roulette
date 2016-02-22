package Structures.Exeptions;

public class PlayerAlreadyExist extends Exception {
    public PlayerAlreadyExist() {
        super("Игрок уже зарегестрирован");
    }
}
