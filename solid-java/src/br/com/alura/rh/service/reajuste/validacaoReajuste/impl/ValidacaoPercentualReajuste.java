package br.com.alura.rh.service.reajuste.validacaoReajuste.impl;

import br.com.alura.rh.exception.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.reajuste.validacaoReajuste.ValidacaoReajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {

        BigDecimal salarioAtual = funcionario.getDadosPessoais().getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);

        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
    }
}
