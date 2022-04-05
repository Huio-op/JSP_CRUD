const validate = (form) => {
    console.log(`na validacacac`, form)
}

const validateEmail = (value) => {
    let errors = null;
    if (!value || value === '') {
        errors = 'email.required'
    } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value)) {
        errors = 'email.invalid'
    }

    return errors;

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