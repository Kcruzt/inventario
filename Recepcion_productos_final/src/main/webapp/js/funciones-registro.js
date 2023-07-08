
    const guardar=document.querySelector('#btnGuardar');
          guardar.addEventListener("click",()=>{
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
                  title: 'Signed in :vvv'
              })
              document.form.submit();


        })
        
    const salir=document.querySelector('#BtnOf');
          guardar.addEventListener("click",()=>{
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
                  title: 'Signed in successfully'
              })
              location.href="SignInAdministrador?conf=0";


        })





        function Enviar(id,validacion){
            if(validacion=='RETIRADORETIRADO'){
                Swal.fire({
                    icon: 'error',
                    title: 'EL PRODUCTO YA HA SIDO RETIRADO ¡',
                    text: 'Recuerde que esta bajo supervision',
                })

            }else{
                Swal.fire({
                    position:'center',
                    title: 'Estas seguro de retirar el producto?',
                    text: "¡No podrás revertir esto!",
                    icon: 'question',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si,retirar',

                }).then((result) => {
                    if (result.isConfirmed) {
                        Swal.fire(
                            'Retirado!',
                            'El producto ha sido retirado',
                            'success'
                        )
                        location.href="SalidaCarga?id="+id;
                    }

                })

            }


       }









