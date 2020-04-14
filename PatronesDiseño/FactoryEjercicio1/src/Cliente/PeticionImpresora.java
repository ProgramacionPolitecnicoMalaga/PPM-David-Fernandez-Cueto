package Cliente;

import io.github.cdimascio.dotenv.Dotenv;

public class PeticionImpresora {

    Dotenv dotenv = Dotenv.configure().load();
    public String tipo = "";

    public PeticionImpresora() {
        tipo = dotenv.get("viewer");
    }

    public String getTipo() {
        return tipo;
    }
}
