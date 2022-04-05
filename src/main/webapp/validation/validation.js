const validate = (form) => {
    console.log(`na validacacac`, form)


    const formFields = form.serializeArray();
    let error = { field: '', msg: '', isValid: true };
    $.each(formFields, (i, field) => {
        const validators = form[0][i].validity;

        console.log(field, form[0][i].validity, form[0][i]);

        if (validators.typeMismatch) {
            error.isValid = false;
            error.field = field.name;
            error.msg = 'valor digitado não é valido para este campo';
            return false;
        } else if (field.value.length === 0) {
            error.isValid = false;
            error.field = field.name;
            error.msg = 'o campo não foi preenchido';
            return false;
        } else if (field.name === 'publishDate') {
            const today = new Date();
            const birthdate = new Date(field.value);
            const age = today.getFullYear() - birthdate.getFullYear();
            if (age > 100) {
                error.isValid = false;
                error.field = field.name;
                error.msg = 'você não pode cadastar um livro publicado a mais de 100 anos';
                return false;
            }
        } else if (field.name === 'email') {
            error = validateEmail(field.value);
            return false;
        }
    });

    if (error.isValid) {
        return true;
        alert(`Seu cadasro foi concluído!`);
    } else {
        alert(`Erro na validação do campo de ${error.field}: ${error.msg}`);
        return false;
    }

}

const validateEmail = (value) => {
    let error = {};
    if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value)) {
        error.isValid = false;
        error.field = 'email';
        error.msg = 'email digitado não é válido';
    }

    return error;
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