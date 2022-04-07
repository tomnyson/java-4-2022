/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    document.getElementById('btnCreate').addEventListener('click', (event) => {
        $('#productModal').modal('show')
//        catModal.show()
    })

    const formCat = document.getElementById("productForm")
    if (formCat) {
        catModal = new bootstrap.Modal(document.getElementById('productModal'), {
            keyboard: false
        })
        document.getElementById("productForm").addEventListener('submit', (event) => {
            event.preventDefault();
            const txtName = document.querySelector('#txtName').value
            const txtDescription = document.querySelector('#txtDescription').value
            const txtImage = document.querySelector("#image").value || ''
            const txtPrice = document.querySelector("#price").value || ''
            const categoryId = document.querySelector("#category").value || ''
            const txtId = document.querySelector("#txtId").value || null
            const errorName = document.querySelector('#error-name')
            const errorDes = document.querySelector('#error-des')

            if (txtId) {
                //case update
                const jsonObj = {
                    id: Number(txtId),
                    name: txtName,
                    description: txtDescription,
                    image: txtImage,
                    price: Number(txtPrice),
                    categoryId: Number(categoryId)
                }
                console.log('jsonObj', jsonObj)
                fetch('/lessonJSP/admin/AdminProductController', {
                    method: 'put',
                    headers: {
                        'Accept': 'application/json, text/plain, */*',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(jsonObj)
                })
                        .then(function (response) {
                            return response.json();
                        })
                        .then(function (result) {
                            const item = result.data
                            console.log('call here')
                            $('#productModal').modal('hide')
                            $.toast({
                                heading: 'Success',
                                text: result.message,
                                position: 'top-right',
                                showHideTransition: 'slide',
                                icon: 'success'
                            })
                            resetForm();
                            console.log('theRowId', txtId)
                            var theRowId = $(`#catTable tbody tr[data-id='${Number(txtId)}']`);
                            console.log('remove', theRowId)
                            theRowId.remove();
                            $('#catTable tbody tr:first').after(`
                            <tr data-id='${item.id}'>
                        <td><strong>${item.name}</strong></td>
                        <td>${item.image}</td>
                        <td>${item.description}</td>
                        <td>
                            <div class="dropdown">
                                <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown"><i class="bx bx-dots-vertical-rounded"></i></button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="javascript:void(0);" onClick="EditCategory(${item.id},{
                                    'name': '${item.name}',
                                    'description': '${item.description}',
                                    'image': '${item.image}'
}
                                            )" ><i class="bx bx-edit-alt me-1"></i>Edit</a>
                                    <a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-trash me-1"></i>Delete</a>
                                </div>
                            </div>
                        </td>
                    </tr>
`);
                            resetForm()
//                            location.reload();
                        })
                        .catch(function (error) {
                            //failed
                            console.log('Request failed', error);
                        })
            } else {
                //case post
                if (txtName === '') {
                    errorName.innerHTML = "name required"
                }
                if (txtDescription === '') {
                    errorDes.innerHTML = "name required"
                } else {
                    const jsonObj = {
                        name: txtName,
                        description: txtDescription,
                        image: txtImage,
                        price: Number(txtPrice),
                        categoryId: Number(categoryId)
                    }

                    fetch('/lessonJSP/admin/AdminProductController', {
                        method: 'post',
                        headers: {
                            'Accept': 'application/json, text/plain, */*',
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(jsonObj)
                    })
                            .then(function (response) {
                                return response.json();
                            })
                            .then(function (result) {
                                //success
//                                catModal.hide();
                                const item = result.data
                                $.toast({
                                    heading: 'Success',
                                    text: result.message,
                                    position: 'top-right',
                                    showHideTransition: 'slide',
                                    icon: 'success'
                                })
                                $('#productModal').modal('hide')

                                $('#catTable tbody tr:first').after(`
                            <tr data-id='${item.id}'>
                        <td><strong>${item.name}</strong></td>
                        <td>${item.image}</td>
                        <td>${item.description}</td>
                        <td>
                            <div class="dropdown">
                                <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown"><i class="bx bx-dots-vertical-rounded"></i></button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="javascript:void(0);" onClick="EditCategory(${item.id},{
'name': '${item.name}',
'description': '${item.description}',
'image': '${item.image}'
}
                                            )" ><i class="bx bx-edit-alt me-1"></i>Edit</a>
                                    <a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-trash me-1"></i>Delete</a>
                                </div>
                            </div>
                        </td>
                    </tr>
`);
//                                location.reload();
                            })
                            .catch(function (error) {
                                //failed
                                console.log('Request failed', error);
                            })
                }


            }

        })
    }



})
function resetForm() {
    document.getElementById('categoryForm1').reset();
}
function EditProduct(id, item) {
    var catModal
    catModal = new bootstrap.Modal(document.getElementById('productModal'), {
        keyboard: false
    })
    catModal.show()
    document.querySelector('#txtName').value = item.name || ''
    document.querySelector('#txtDescription').value = item.description || ''
    document.querySelector("#image").value = item.description || ''
    document.querySelector("#txtId").value = id || 0
    catModal.show()
}

function DeleteCategory(id) {
    alert(id)
    if (id) {
        const obj = {
            "id": id
        }
        fetch('/lessonJSP/admin/AdminCategoryController', {
            method: 'delete',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        })
                .then(function (response) {
                    console.log('response', response)
                    return response.json();
                })
                .then(function (result) {
                    $.toast({
                        heading: 'Success',
                        text: result.message,
                        position: 'top-right',
                        showHideTransition: 'slide',
                        icon: 'success'
                    })

                    setTimeout(() => {
                        location.reload();
                    }, 2000)

                })
                .catch(function (error) {
                    //failed
                    console.log('Request failed', error);
                })
    }

}