package br.com.virtualbooks.tabernabooks.shared;

/**
 * Representa a estrutura de resposta de erro para a aplicação.
 * Este DTO é utilizado para padronizar as mensagens de erro que serão enviadas para o cliente.
 */
public class ErrorResponse {
    private String codigoRetorno;
    private String textoMensagemUsuario;
    private String textoMensagemTecnica;


    public ErrorResponse(String codigoRetorno, String textoMensagemTecnica, String textoMensagemUsuario) {
        this.codigoRetorno = codigoRetorno;
        this.textoMensagemUsuario = textoMensagemUsuario;
        this.textoMensagemTecnica = textoMensagemTecnica;
    }

    public String getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public String getTextoMensagemTecnica() {
        return textoMensagemTecnica;
    }

    public void setTextoMensagemTecnica(String textoMensagemTecnica) {
        this.textoMensagemTecnica = textoMensagemTecnica;
    }

    public String getTextoMensagemUsuario() {
        return textoMensagemUsuario;
    }

    public void setTextoMensagemUsuario(String textoMensagemUsuario) {
        this.textoMensagemUsuario = textoMensagemUsuario;
    }
}
