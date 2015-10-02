function limparFormulario() {
	$('form').each(function(){
		this.reset(); //Cada volta no laço o form atual será resetado
	});
	$('form').find('*').removeClass('invalid').removeClass('valid');
}