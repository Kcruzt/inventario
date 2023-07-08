const servicio = document.getElementById('id_servicio4');
const categoria = document.getElementById('id_categoria');
const tipoComprobante = document.getElementById('tipo_comprobante');
const tipoEstado = document.getElementById('estado');
const descripcion = document.getElementById('descripcion');
const estado = document.getElementById("estadocarga");
const total = document.getElementById('total');
const lTipoComprobante = document.getElementById('l_tipo_comprobante');
const lTipoEstado = document.getElementById('l_estado');
const lDescripcion = document.getElementById('l_descripcion');
const lEstado = document.getElementById('l_estado_carga');
const lTotal = document.getElementById('l_total');



const guardar = document.querySelector('#btnGuardar');
guardar.addEventListener("click", () => {
    let condicion=1;
    if (tipoComprobante.value === null || tipoComprobante.value === '') {
        lTipoComprobante.style.color = "rgb(177 116 116 / 87%)";
        condicion= 0;
    } else {
        lTipoComprobante.style.color = "#849c3e";
    }
  
    if (tipoEstado.value === null || tipoEstado.value === '') {
        lTipoEstado.style.color = "rgb(177 116 116 / 87%)";
        condicion= 0;
    } else {
        lTipoEstado.style.color = "#849c3e";
    }
       
    if (descripcion.value === null || descripcion.value === '') {
        lDescripcion.style.color = "rgb(177 116 116 / 87%)"
        condicion= 0
    } else {
        lDescripcion.style.color = "#849c3e";
    }

    if (estado.value === null || estado.value === ''||estado.value==='undefined') {  
        lEstado.style.color = "rgb(177 116 116 / 87%)";
        condicion= 0;
    } else {
        lEstado.style.color = "#849c3e";
    }
    
    if (total.value === null || total.value === '') {
        lTotal.style.color = "rgb(177 116 116 / 87%)";
        condicion= 0
    } else {
        lTotal.style.color = "#849c3e";
    }

    if (condicion===1) {
        
        
        const Toast = Swal.mixin({
  toast: true,
  position: 'top-end',
  showConfirmButton: false,
  timer: 3000,
  timerProgressBar: true,
  didOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer)
    toast.addEventListener('mouseleave', Swal.resumeTimer)
  }
})

Toast.fire({
  icon: 'success',
  title: 'Producto Agregado :)'
})
        
        document.form.submit();
    
        }else{
        Swal.fire(
                'Error!',
                'Por favor complete todo el formulario ',
                'warning'
                )
    }

}
)


function Eliminar(id, idR, idL) {
    Swal.fire({
        position: 'center',
        title: 'Estas seguro?',
        text: "¡No podrás revertir esto!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si,eliminar',

    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                    'Eliminado!',
                    'El administrador ha sido eliminado',
                    'success'
                    )
            location.href = "AdministradorControl?accion=Eliminar&id=" + id + '&idR=' + idR + '&idL=' + idL;
        }

    })

}









