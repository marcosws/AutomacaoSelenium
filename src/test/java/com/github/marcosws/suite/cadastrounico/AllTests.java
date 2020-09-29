package com.github.marcosws.suite.cadastrounico;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.github.marcosws.testcase.cadastrounico.*;


@RunWith(Suite.class)
@SuiteClasses({ 
	CTA001.class, 
	CTA002.class, 
	CTA003.class,
	CTA004.class,
	CTA005.class,
	CTA006.class,
	CTA007.class,
	CTA008.class,
	CTA009.class,
	CTA010.class,   
	CTA011.class,
	CTA012.class,
	CTA013.class,
	CTA014.class, 
	CTA015.class,
	CTA016.class,
	CTA017.class,
	CTA018.class,
	CTA019.class,
	CTA020.class,
	CTA021.class,
	CTA022.class,
	CTA023.class 
	})
public class AllTests {

}

/*
CTA001 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) preenchendo todos os campos com dados válidos.
CTA002 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo Nome e preenchendo demais campos com dados válidos.
CTA003 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo CPF e preenchendo demais campos com dados válidos.
CTA004 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) preenchendo com um CPF inválido e preenchendo demais campos com dados válidos.
CTA005 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo Telefone e preenchendo demais campos com dados válidos.
CTA006 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo Celular e preenchendo demais campos com dados válidos.
CTA007 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo E-mail e preenchendo demais campos com dados válidos.
CTA008 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo Telefone, Celular e E-Mail e preenchendo demais campos com dados válidos.
CTA009 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) preenchendo com um Formato de Telefone inválido e preenchendo demais campos com dados válidos.
CTA010 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) preenchendo com um Formato de Celular inválido e preenchendo demais campos com dados válidos.
CTA011 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) preenchendo com um Formato de E-mail inválido e preenchendo demais campos com dados válidos.
CTA012 - Realizar o cadastro de cliente para pessoa física sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento de todos os campos.
CTA013 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e preenchendo todos os campos com dados válidos.
CTA014 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo Nome e preenchendo demais campos com dados válidos.
CTA015 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo CPF e preenchendo demais campos com dados válidos.
CTA016 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e preenchendo com um CPF inválido e preenchendo demais campos com dados válidos.
CTA017 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo Telefone e preenchendo demais campos com dados válidos.
CTA018 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo Celular e preenchendo demais campos com dados válidos.
CTA019 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo E-mail e preenchendo demais campos com dados válidos.
CTA020 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo Telefone, Celular e E-Mail e preenchendo demais campos com dados válidos.
CTA021 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e preenchendo com um Formato de Telefone inválido e preenchendo demais campos com dados válidos.
CTA022 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e preenchendo com um Formato de Celular inválido e preenchendo demais campos com dados válidos.
CTA023 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e preenchendo com um Formato de E-mail inválido e preenchendo demais campos com dados válidos.
CTA024 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar label informativa e omitindo o preenchimento de todos os campos.
CTA025 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar mensagem de confirmação de Cadastro, aceitando a mensagem e preenchendo todos os campos com dados válidos.
CTA026 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar mensagem de confirmação de Cadastro, declinando o mensagem e preenchendo todos os campos com dados válidos.
CTA027 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar mensagem de confirmação antes de limpar os campos preenchendo todos os campos e acionando o botão Limpar aceitando a mensagem.
CTA028 - Realizar o cadastro de cliente para pessoa física com parametrização selecionando Apresentar mensagem de confirmação antes de limpar os campos preenchendo todos os campos e acionando o botão Limpar declinando a mensagem.
CTA029 - Realizar o cadastro de cliente para pessoa física sem parametrização preenchendo todos os campos e acionando o botão Limpar.
CTA030 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) preenchendo todos os campos com dados válidos.
CTA031 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo Nome Fantasia e preenchendo demais campos com dados válidos.
CTA032 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo Razão Social e preenchendo demais campos com dados válidos.
CTA033 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo CNPJ e preenchendo demais campos com dados válidos.
CTA034 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) preenchendo com um CNPJ inválido e preenchendo demais campos com dados válidos.
CTA035 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo Celular, E-Mail e preenchendo demais campos com dados válidos.
CTA036 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo Celular, Telefone e preenchendo demais campos com dados válidos.
CTA037 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento do campo E-mail, Telefone e preenchendo demais campos com dados válidos.
CTA038 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização (Apresentar caixa de dialogo) omitindo o preenchimento de todos os campos.
CTA039 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e preenchendo todos os campos com dados válidos.
CTA040 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo Nome Fantasia e preenchendo demais campos com dados válidos.
CTA041 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo Razão Social e preenchendo demais campos com dados válidos.
CTA042 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo CNPJ e preenchendo demais campos com dados válidos.
CTA043 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e preenchendo com um CNPJ inválido e preenchendo demais campos com dados válidos.
CTA044 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo Celular, E-Mail e preenchendo demais campos com dados válidos.
CTA045 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo Celular, Telefone e preenchendo demais campos com dados válidos.
CTA046 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e omitindo o preenchimento do campo E-mail, Telefone e preenchendo demais campos com dados válidos.
CTA047 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar label informativa e omitindo o preenchimento de todos os campos.
CTA048 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar mensagem de confirmação de Cadastro, aceitando a mensagem e preenchendo todos os campos com dados válidos.
CTA049 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar mensagem de confirmação de Cadastro, declinando o mensagem e preenchendo todos os campos com dados válidos.
CTA050 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar mensagem de confirmação antes de limpar os campos preenchendo todos os campos e acionando o botão Limpar aceitando a mensagem.
CTA051 - Realizar o cadastro de cliente para pessoa jurídica com parametrização selecionando Apresentar mensagem de confirmação antes de limpar os campos preenchendo todos os campos e acionando o botão Limpar declinando a mensagem.
CTA052 - Realizar o cadastro de cliente para pessoa jurídica sem parametrização preenchendo todos os campos e acionando o botão Limpar.
*/