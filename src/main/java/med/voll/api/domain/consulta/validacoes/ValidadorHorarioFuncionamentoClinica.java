package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){
        LocalDateTime dataConsulta = dados.data();

        boolean ehDomingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean ehAntesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        boolean ehDepoisDoFechemantoDaClinica = dataConsulta.getHour() > 18;

        if (ehDomingo || ehAntesDaAberturaDaClinica || ehDepoisDoFechemantoDaClinica ) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }

    }

}
