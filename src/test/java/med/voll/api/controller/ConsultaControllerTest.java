package med.voll.api.controller;

import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import med.voll.api.domain.medico.Especialidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoConsulta> dadosAgendamentoConsultaJacksonTester; // dto de entrada
    @Autowired
    private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoConsultaJacksonTester; // dto de saída

    @MockBean
    private AgendaDeConsultas agenda;

    @Test
    @DisplayName("Deveria devolver código http 400 quando informacoes estao invalidas")
    @WithMockUser // Para simular um usuario logado
    void agendar_cenario1() throws Exception {
        // given or arrange

        // When or act
        MockHttpServletResponse response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();

        // Then or assert
        assertThat(response.getStatus(), equalTo(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Deveria devolver código http 200 quando informacoes estao válidas")
    @WithMockUser // Para simular um usuario logado
    void agendar_cenario2() throws Exception {
        // given or arrange
        LocalDateTime data = LocalDateTime.now().plusHours(1);
        Especialidade especialidade = Especialidade.CARDIOLOGIA;

        DadosAgendamentoConsulta dtoRequest = new DadosAgendamentoConsulta(2l, 1l, data, especialidade);
        DadosDetalhamentoConsulta dtoResponse = new DadosDetalhamentoConsulta(null, 2l, 1l, data);

        String jsonRequest = dadosAgendamentoConsultaJacksonTester.write(dtoRequest).getJson();
        String jsonResponse = dadosDetalhamentoConsultaJacksonTester.write(dtoResponse).getJson();

        // When or act
        when(agenda.agendar(any())).thenReturn(dtoResponse);

        MockHttpServletResponse response = mvc
                .perform(
                        post("/consultas")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonRequest)
                )
                .andReturn().getResponse();

        // Then or assert
        assertThat(response.getStatus(), equalTo(HttpStatus.OK.value()));
        assertThat(response.getContentAsString(), equalTo(jsonResponse));


    }
}