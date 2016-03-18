package Structures.Exeptions;

/**
 * Исключительная ситуация при регистрации нового игрока, если такой никнейм уже занят
 */
public class PlayerAlreadyExist extends Exception {
    public PlayerAlreadyExist() {
        super("Игрок уже зарегестрирован");
    }
}
