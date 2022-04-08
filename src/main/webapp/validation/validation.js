const validate = (form) => {

    const formFields = form.serializeArray();
    let error = { field: '', msg: '', isValid: true };
    $.each(formFields, (i, field) => {
        const validators = form[0][i].validity;

        if (validators.typeMismatch) {
            error.isValid = false;
            error.field = form[0][i].dataset.name;
            error.msg = 'valor digitado não é valido para este campo';
            return false;
        } else if (field.value.length === 0) {
            error.isValid = false;
            error.field = form[0][i].dataset.name;
            error.msg = 'o campo não foi preenchido';
            return false;
        } else if (field.name === 'publishDate') {
            const today = new Date();
            const birthdate = new Date(field.value);
            const age = today.getFullYear() - birthdate.getFullYear();
            if (age > 100) {
                error.isValid = false;
                error.field = form[0][i].dataset.name;
                error.msg = 'você não pode cadastar um livro publicado a mais de 100 anos';
                return false;
            }
        } else if (field.name === 'email') {
            error = validateEmail(field.value);
            return false;
        } else if (field.name === 'cpf') {
            const validCPF = validateCPF(field.value);
            if (!validCPF) {
                error.isValid = false;
                error.field = form[0][i].dataset.name;
                error.msg = 'CPF inválido';
                return false;
            }
        }
    });

    if (error.isValid) {
        alert(`Seu cadasro foi concluído!`);
        return true;
    } else {
        alert(`Erro na validação do campo de ${error.field}: ${error.msg}`);
        return false;
    }

}

const validateEmail = (value) => {
    let error = { field: '', msg: '', isValid: true };
    if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value)) {
        error.isValid = false;
        error.field = 'email';
        error.msg = 'email digitado não é válido';
    }

    return error;
}

const validateCPF = (cpf) => {
    let cpfOnlyNum = cpf.replaceAll('-', '')
    cpfOnlyNum = cpfOnlyNum.replaceAll('.', '');
    let Soma;
    let Resto;
    Soma = 0;
    if (cpfOnlyNum == "00000000000") return false;

    for (i=1; i<=9; i++) Soma = Soma + parseInt(cpfOnlyNum.substring(i-1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(cpfOnlyNum.substring(9, 10)) ) return false;

    Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(cpfOnlyNum.substring(i-1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(cpfOnlyNum.substring(10, 11) ) ) return false;
    return true;
}

const cpfMask = (input) => {

    let value = input.value;

    if(isNaN(value[value.length-1])){
        input.value = value.substring(0, value.length-1);
        return;
    }

    input.setAttribute("maxlength", "14");
    if (value.length == 3 || value.length == 7) input.value += ".";
    if (value.length == 11) input.value += "-";

}