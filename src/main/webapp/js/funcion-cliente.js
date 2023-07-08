
const nombres = document.getElementById('nombres');
const apellidos = document.getElementById('apellidos');
const dni = document.getElementById('dni');
const telefono = document.getElementById('telefono');
const lNombres = document.getElementById('l_nombres');
const lApellidos = document.getElementById('l_apellidos');
const lDni = document.getElementById('l_dni');
const lTelefono = document.getElementById('l_telefono');


const guardar = document.querySelector('#btnGuardar');

guardar.addEventListener("click", () => {
    let estado = 1;
    if (nombres.value === null || nombres.value === '') {
        lNombres.style.color = "rgb(177 116 116 / 87%)";
        estado = 0;
    } else {
        lNombres.style.color = "#849c3e";
    }
    if (apellidos.value === null || apellidos.value === '') {
        lApellidos.style.color = "rgb(177 116 116 / 87%)";
        estado = 0;
    } else {
        lApellidos.style.color = "#849c3e";
    }
    if (dni.value === null || dni.value === '') {
        lDni.style.color = "rgb(177 116 116 / 87%)";
        estado = 0;
    } else {
        lDni.style.color = "#849c3e";
    }
    if (telefono.value === null || telefono.value === '') {
        lTelefono.style.color = "rgb(177 116 116 / 87%)";
        estado = 0;
    } else {
        lTelefono.style.color = "#849c3e";
    }

    if (estado === 1) {

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
  title: 'Proveedor Agregado :)'
})
        
        
        
        document.form.submit();
   




    } else {
        Swal.fire(
                'Error!',
                'Por favor complete todo el formulario ',
                'warning'
                )
    }

})






function Eliminar(id, idR) {
    Swal.fire({
        position: 'center',
        title: 'Estas seguro?',
        text: "¡Recuerde que si cliente posee productos dentro del establecimiento " +
                "el sistema no lo eliminará ,por politicas de la empresa!",
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
            location.href = "ClienteControl?accion=Eliminar&id=" + id + '&idR=' + idR;
        }

    })

}