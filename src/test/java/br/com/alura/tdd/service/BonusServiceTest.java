package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {
    // fazendo testes automatizados, unidades com JUnite

    @Test // --> importando e utilizando o JUnit

    // vamos testar o metodo calcularBonus
    void bonusDeveriaSerZeroParaFuncionariosComSalarioMaiorqueDezMil(){
        // criando um service e precisamos intanciar a classe BonusService que vamos testar
        BonusService service = new BonusService();
        // o metodo que vamos testar vai ser o cacularBonus e vamos passar um funcionario direto como parametro
        //                                       // instanciando um funcionario ou criando um funcionario
        BigDecimal bonus = service.calcularBonus(new Funcionario("Andersom", LocalDate.now(), new BigDecimal("55000")));

        // usando assertEquals das assertivas do Junit
        // o BigDecimal vai ser 0 e a variavel bonus tem que ser 0 pois o salario esta muito alto
        Assertions.assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalarioMenorQueDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Andersom", LocalDate.now(), new BigDecimal("7000")));

        //                                valor esperado      bonus tem que ter 10%
        Assertions.assertEquals(new BigDecimal("700.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Andersom", LocalDate.now(), new BigDecimal("10000")));
        //                                valor esperado      bonus tem que ter 10%
        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);

    }






}
