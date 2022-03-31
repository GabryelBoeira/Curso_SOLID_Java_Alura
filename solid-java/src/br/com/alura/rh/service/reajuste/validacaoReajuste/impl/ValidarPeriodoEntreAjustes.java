package br.com.alura.rh.service.reajuste.validacaoReajuste.impl;

import br.com.alura.rh.exception.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.reajuste.validacaoReajuste.ValidacaoReajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidarPeriodoEntreAjustes implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {

        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (mesesUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser maior que 6 meses!");
        }
    }
}
