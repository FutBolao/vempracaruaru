function limparFormulario() {
	$('form').each(function(){
		this.reset(); //Cada volta no laço o form atual será resetado
	});
	$('form').find('*').removeClass('invalid').removeClass('valid');
}
function contatoEnviadoComSucesso() {
	document.getElementById("form").innerHTML = "<br/><br/><br/>Seu formul&aacute;rio de contato foi enviado com sucesso!!!<br/>Aguarde que nossa equipe ir&aacute; entrar em contato em breve.";
}
function usuarioCadastradoComSucesso() {
	document.getElementById("form").innerHTML = "<br/><br/><br/>Seu cadastro foi efetuado com sucesso!!!<br/>";
}
function usuarioSenhaAlteradaComSucesso() {
	document.getElementById("form").innerHTML = "<br/><br/><br/>Sua senha foi alterada com sucesso!!!<br/>";
}
var doConfirm = function(id){
     var link = document.getElementById(id);
     if(confirm("Deseja realmente excluir?"))
         return true;
     else
        return false;
}