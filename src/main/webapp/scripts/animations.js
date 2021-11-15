/* Responsive animation NAV */
const navbar = document.getElementById('navbar');
const openMenu = document.getElementById('open-menu');
const closedMenu = document.getElementById('closed-menu');

openMenu.addEventListener('click', () => {
  navbar.classList.add('view-menu');
  closedMenu.classList.remove('hidden');
  openMenu.classList.add('hidden');
})

closedMenu.addEventListener('click', () => {
  navbar.classList.remove('view-menu');
  closedMenu.classList.add('hidden');
  openMenu.classList.remove('hidden');
})

/* Description.html change colors */
const unitsText = document.getElementById('units-text');
const quantityAdd = document.getElementById('units-add');
const quantityMinus = document.getElementById('units-minus');
const price = document.getElementById('price');
const rangeColor = document.getElementById('range-color');

let units = parseInt(unitsText.textContent);
let priceCalculated = parseFloat(price.textContent);

rangeColor.addEventListener('input',() =>{
   document.documentElement.style.setProperty('--deg-color',`${rangeColor.value}deg`);
})

quantityAdd.addEventListener('click', ()=> {
    unitsText.textContent = ++units;
    price.textContent = (priceCalculated * units).toFixed(2);
})
quantityMinus.addEventListener('click', ()=> {
    if(units > 1) {
       unitsText.textContent = --units;
       price.textContent = units === 1 ? priceCalculated.toFixed(2) :(priceCalculated * units).toFixed(2);
    }
})