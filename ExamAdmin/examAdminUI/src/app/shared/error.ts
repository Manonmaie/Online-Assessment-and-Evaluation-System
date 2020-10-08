export function setError(input: string,message: string){
    const formItem = document.getElementById(input).parentElement;
    const small = formItem.querySelector('small');
    small.innerText = message;
    formItem.className = 'form-item error'
}