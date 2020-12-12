export function setError(input: string,message: string){
    const formItem = document.getElementById(input).parentElement;
    const small = formItem.querySelector('small');
    small.innerText = message;
    formItem.className = 'form-item error'
}
export function resetError(input: string){
    const formItem = document.getElementById(input).parentElement;
    formItem.className = 'form-item'
}