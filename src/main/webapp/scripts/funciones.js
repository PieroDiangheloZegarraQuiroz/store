/*const btnDelete = document.getElementById("btnDelete");
 const idproducto = document.getElementById("idp");
 
 btnDelete.addEventListener("click", ()=>{
 swal({
 title: "Estas seguro de eliminar?",
 text: "El registro seleccionado se eliminara!",
 icon: "warning",
 buttons: true,
 dangerMode: true,
 })
 .then((willDelete) => {
 if (willDelete) {
 eliminar(idproducto.value);
 
 swal("Registro eliminado!", {
 icon: "success",
 }).then((willDelete) => {
 if (willDelete) {
 parent.location.href = "Controlador?accion=Carrito";
 }
 });
 } 
 });
 });*/
function eliminar(idproduct) {
    const idProduct = document.getElementById(`id-product-${idproduct}`);
    axios({
        method: 'POST',
        url: "SCard?action=Delete",
        data: "id=" + idProduct.value,
    }).then(
            swal({
                title: "Estas seguro de eliminar?",
                text: "El registro seleccionado se eliminara!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
            .then((willDelete) => {
                if (willDelete) {

                    swal("Registro eliminado!", {
                        icon: "success",
                    }).then((willDelete) => {
                        if (willDelete) {
                           location.reload();
                        }
                    });
                }
            }))
}
/*function btnAdd(id) {
    const idProduct = document.getElementById(`id-product-${id}`);
    axios({
        method: 'POST',
        url: 'ServletCard',
        data: 'idProduct=' + idProduct.value
    }).then(response => console.log(response))
            .catch(err => console.log(err))
}*/


