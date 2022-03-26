/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



 let formCategory = document.getElementById("categoryForm")
      formCategory.addEventListener('submit', (event)=> {
        event.preventDefault();
       const txtName = document.querySelector('#txtName').value
       const errorName = document.querySelector('#error-name')
       if(txtName === '') {
           errorName.innerHTML ="name required"
       } else {
           event.currentTarget.submit()
       }
          
})