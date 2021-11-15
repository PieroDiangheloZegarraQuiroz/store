// get if of the form 
//const formCard = document.getElementById('form-card');

// get id of inputs of the form in html 
const cardName = document.getElementById('cardName');
const numberCard = document.getElementById('numberCard');
const cvv = document.getElementById('cvv');
const districts = document.getElementById('districts');
const direction = document.getElementById('direction');
const correctInfo = {
  cardName: false,
  numberCard: false,
  cvv: false,
  districts: false,
}

// valid all fields
cardName.addEventListener('change', event => {
  if(cardName.value.trim().length > 0) {
    correctInfo.cardName = true
    validForm();
  };
})

numberCard.addEventListener('change', event => {
  if (numberCard.value.trim().length === 16){
    let number = parseInt(numberCard.value.trim());
    if (!isNaN(number)) correctInfo.numberCard = true;
    validForm();
  }
})

cvv.addEventListener('change', event => {
  if (cvv.value.trim().length === 3){
    let number = parseInt(cvv.value.trim());
    if (!isNaN(number)) correctInfo.cvv = true;
    validForm();
  }
})

districts.addEventListener('change', event => {
  if(districts.value != '0') {
    correctInfo.districts = true
    validForm();
  };
})

direction.addEventListener('change', () => {
  if(direction.value.trim().length > 0) {
    correctInfo.direction = true
    validForm();
  }
})

//validate fields
const validForm = () => {
  const formValues = Object.values(correctInfo);
  const btnPay = document.querySelector('.btn-pay');
  const valid = formValues.findIndex(value => value == false);
  if (valid == -1) {
    btnPay.classList.add('active-pay')
  } else {
    btnPay.classList.remove('active-pay');
  }
}
// Reponsive animation CARD
const addCard = document.getElementById('add-card');
const openCard = document.getElementById('open-card');
const closedForm = document.getElementById('closed-form');

addCard.addEventListener('click', () =>{
  openCard.classList.add('view-form');
  addCard.classList.add('hidden');
  closedForm.classList.remove('hidden');
})

closedForm.addEventListener('click', () => {
  openCard.classList.remove('view-form');
  addCard.classList.remove('hidden');
  closedForm.classList.add('hidden');
})

