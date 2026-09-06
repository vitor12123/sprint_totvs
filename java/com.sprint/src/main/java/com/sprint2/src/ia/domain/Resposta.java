package com.sprint2.src.ia.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Resposta {

    private String resposta ="""
            {
              "resposta": "{\\n\\"dores\\": \\"Portal interno falho, gestão complexa de ponto e HE, atestados (homologação), relatórios inadequados. Falha na comunicação comercial TOTVS.\\",\\n\\"produto_totvs_envolvido\\": \\"TOTVS RM (já em uso), Meu RH (portal), ClockIn (coletor de ponto) e Assinatura Eletrônica TOTVS.\\",\\n\\"riscos\\": \\"Incompatibilidade do Meu RH com processos internos, falha no controle de ponto/HE, insatisfação de usuários, fraude no ponto e perda de credibilidade TOTVS.\\",\\n\\"solucao_recomendacao\\": \\"Agendar nova reunião com engenharia de valor e arquiteto TOTVS para detalhar customizações do Meu RH (fluxo de atestados, HE, relatórios de gestor). Utilizar TOTVS RM para parametrizar regras complexas, espelhando-as no Meu RH. Fornecer respostas claras e prazos sobre o roadmap. Apresentar demos práticas de workflows completos. Considerar ClockIn para coleta de ponto e simplificar integrações.\\"\\n}"
            }""";

     //public Resposta(String resposta){
     //   this.resposta = resposta;
     //}

    @GetMapping("/resposta")
    public String getResposta() {
        return resposta;
    }

}
