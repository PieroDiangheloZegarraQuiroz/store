const modalAdd = document.getElementById('modal-add-product');
const modalName = document.getElementById('name-product-modal');

modalAdd.addEventListener('click', () => {
   modalAdd.classList.remove('modal-add-product-active');
})

function btnAdd(id, name, url, stock) {
   if (stock <= 0) {
        
    } else {
   axios({
      method: 'POST',
      url: 'SCard',
      data: 'idProduct=' + id
   }).then(response => console.log(response))
       .catch(err => console.log(err));
   modalAdd.classList.add('modal-add-product-active');
   modalName.textContent = `Se agrego : ${name}`;
   document.getElementById('image-product-modal').src = `assets/image/${url}`;
}
}




