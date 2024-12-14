document.addEventListener('DOMContentLoaded', function () {
    /*
    * 상품 삭제 관련
    * */
    document.addEventListener('click', (event) => {
        if (event.target.classList.contains('btn-delete')) {
            console.log('ddd')
            const productId = event.target.getAttribute('data');
            if (confirm('해당 상품을 정말 삭제하시겠습니까?')) {
                deleteProduct(productId);
            }
        }
    });
});


/**
 * 상품 삭제 처리
 * @param {bigint} productId - 삭제할 상품 ID
 */
function deleteProduct(productId) {
    fetch(`/api/products/${productId}`, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(error => {
                    alert('상품 삭제 중 오류가 발생했습니다. \n' + error.message);
                });
            }
            location.reload();
        })
        .catch(error => {
            console.error(error);
        });
}