package med.voll.api.domain.usuario;

public record DadosListagemUsuario(Long id, String login, String senha) {

    public DadosListagemUsuario (Usuario dados){
        this(dados.getId(), dados.getLogin(), dados.getSenha());
    }
}
