package ListaPrecios.exceptions;

public class ListaPreciosException extends Exception {
    public ListaPreciosException(String message) {
        super(message);
    }

    public ListaPreciosException(String message, Throwable cause) {
        super(message, cause);
    }
}
