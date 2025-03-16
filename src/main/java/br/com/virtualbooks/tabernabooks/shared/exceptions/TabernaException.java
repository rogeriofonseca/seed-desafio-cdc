package br.com.virtualbooks.tabernabooks.shared.exceptions;

public class TabernaException extends RuntimeException {

    private final String codigoRetorno;
    private final String textoMensagemTecnica;
    private final String textoMensagemUsuario;

    public TabernaException(String codigoRetorno, String textoMensagemUsuario, String textoMensagemTecnica) {
        super(textoMensagemTecnica);
        this.codigoRetorno = codigoRetorno;
        this.textoMensagemUsuario = textoMensagemUsuario;
        this.textoMensagemTecnica = textoMensagemTecnica;
    }

    public String getCodigoRetorno() {
        return codigoRetorno;
    }

    public String getTextoMensagemTecnica() {
        return textoMensagemTecnica;
    }

    public String getTextoMensagemUsuario() {
        return textoMensagemUsuario;
    }
}
