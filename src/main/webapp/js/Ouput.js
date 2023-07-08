function Salir(){
    Swal.fire({
        icon: 'warning',
        position:'center',
        title: 'Estas seguro de cerrar sesion? ',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si,cerrar sesion',

    }).then((result) => {
        if (result.isConfirmed) {
         
            location.href="SignInAdministrador?conf=0";
        }

    })

}

