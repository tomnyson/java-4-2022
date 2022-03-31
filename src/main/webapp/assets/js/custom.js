/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var catModal 
    document.getElementById('btnCreate').addEventListener('click', (event) => {
       catModal = new bootstrap.Modal(document.getElementById('catModal'), {
            keyboard: false
        })
        catModal.show()
    })

    const formCat = document.getElementById("categoryForm1")
    console.log('formCat', formCat)
    if (formCat) {
        document.getElementById("categoryForm1").addEventListener('click', (event) => {
            event.preventDefault();
            const txtName = document.querySelector('#txtName').value
            const txtDescription = document.querySelector('#txtDescription').value
            const errorName = document.querySelector('#error-name')
            const errorDes = document.querySelector('#error-des')
            if (txtName === '') {
                errorName.innerHTML = "name required"
            }
            if (txtDescription === '') {
                errorDes.innerHTML = "name required"
            } else {
                const jsonObj = {
                    name: txtName,
                    description: txtDescription,
                    image: ''
                }

                fetch('/lessonJSP/admin/AdminCategoryController', {
                    method: 'post',
                    headers: {
                        'Accept': 'application/json, text/plain, */*',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(jsonObj)
                })
                        .then(function (response) {
                            console.log('response',response)
                            return response.json();
                        })
                        .then(function (result) {
                            //success
                    console.log('response',result)
                            catModal.hide();
//                          location.reload();
                        })
                        .catch(function (error) {
                            //failed
                            console.log('Request failed', error);
                        })

//            event.currentTarget.submit()
            }

        })
    } 

})