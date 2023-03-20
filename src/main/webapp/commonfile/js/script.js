const sidePop = document.querySelector('.side-pop');
window.addEventListener('load', event => {
	if(!sidePop.classList.contains('d-none')) {
		showAndHideModal();
	}
})

function showAndHideModal() {
	sidePop.classList.add('slide-right-show');
	setTimeout(() => {
		sidePop.classList.add('slide-right-hide');
		sidePop.classList.remove('slide-right-show');
	},3000); 
}