const form = document.getElementById('form');
const button = document.getElementById('submit-Button')

const userName = document.getElementById('userName')
const lastName = document.getElementById('lastName')
const dni = document.getElementById('Dni')
const email = document.getElementById('email')
const password = document.getElementById('password')
const telefono = document.getElementById('phoneNumber')
const politics = document.getElementById('politics')
const btnSign = document.getElementById('btn-sign');

/*Esto va debajo de la linea 9 o 10  script_form*/
const modal = document.getElementById('modal');
const modalIcon = document.getElementById('modal-icon');
const valuesCorrects = {
    userName: false,
    lastName: false,
    dni: false,
    email: false,
    password: false,
    telefono: false,
    politics: false,
}


/* ============validate data============  */
//aquiiva email

/* ============Listerner all events============ */
form.addEventListener('submit', event => {
    event.preventDefault();
    //setTimeout(validateForm, 3000);
})

userName.addEventListener('change', event => {
    if (userName.value.trim().length > 0) {
        valuesCorrects.userName = true
        validateForm();
    }
    ;
})
lastName.addEventListener('change', event => {
    if (lastName.value.trim().length > 0) {
        valuesCorrects.lastName = true
        validateForm();
    }
    ;
})
dni.addEventListener('change', event => {
    if (dni.value.trim().length > 0) {
        valuesCorrects.dni = true
        validateForm();
    }
    ;
})
email.addEventListener('change', event => {
    if (email.value.trim().length > 0) {
        valuesCorrects.email = true
        validateForm();
    }
    ;
})
password.addEventListener('change', event => {
    if (password.value.trim().length > 0) {
        valuesCorrects.password = true
        validateForm();
    }
    ;
})
telefono.addEventListener('change', event => {
    if (telefono.value.trim().length > 0) {
        valuesCorrects.telefono = true
        validateForm();
    }
    ;
})

politics.addEventListener('click', event => {
    valuesCorrects.politics = event.target.checked;
    if (event.target.checked) {
        valuesCorrects.politics = true
        validateForm()
    } else {
        valuesCorrects.politics = false
    }
})

const validateForm = () => {
    const formValues = Object.values(valuesCorrects);
    const validate = formValues.findIndex(value => value == false);
    if (validate == -1) {
        button.classList.add('active')
        button.removeAttribute('disabled')
        
    } 
}

/*Esto va al final de script_form*/
button.addEventListener('click', () =>{
    setTimeout(()=>{form.submit()},2000)
    
    modal.classList.add('modal-active');
})

modalIcon.addEventListener('click', () => {
    modal.classList.remove('modal-active');
})



