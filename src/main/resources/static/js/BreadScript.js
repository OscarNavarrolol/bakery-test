// BreadScript.js
const apiUrl = 'http://localhost:8083/bread';

document.getElementById('productForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const productId = document.getElementById('productId').value;
    const productName = document.getElementById('productName').value;
    const productPrice = document.getElementById('productPrice').value;
    const productWeight = document.getElementById('productWeight').value;
    const productTime = document.getElementById('productTime').value;
    const flourId = document.getElementById('flourId').value;
    
    if (productId) {
        updateProduct(productId, productName, productPrice, productWeight, productTime, flourId);
    } else {
        addProduct(productName, productPrice, productWeight, productTime, flourId);
    }
    document.getElementById('productForm').reset();
    document.getElementById('cancelEdit').style.display = 'none';
});

document.getElementById('cancelEdit').addEventListener('click', function() {
    document.getElementById('productForm').reset();
    document.getElementById('productId').value = '';
    this.style.display = 'none';
});

async function addProduct(name, price, weight, time, flourId) {
    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            breadName: name,
            price: price,
            weight: weight,
            productionTime: time,
            flourId: flourId
        })
    });

    const newProduct = await response.json();
    displayProduct(newProduct);
}

async function updateProduct(id, name, price, weight, time, flourId) {
    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            breadName: name,
            price: price,
            weight: weight,
            productionTime: time,
            flourId: flourId
        })
    });

    const updatedProduct = await response.json();
    const li = document.querySelector(`li[data-id='${id}']`);
    li.innerHTML = `${updatedProduct.breadName} - $${updatedProduct.price}`;
    addButtonsToListItem(li, updatedProduct);
}

function displayProduct(product) {
    const productList = document.getElementById('productList');

    const li = document.createElement('li');
    li.dataset.id = product.breadId;
    li.innerHTML = `${product.breadName} - $${product.price}`;

    addButtonsToListItem(li, product);
    productList.appendChild(li);
}

function addButtonsToListItem(li, product) {
    const editButton = document.createElement('button');
    editButton.textContent = 'Editar';
    editButton.classList.add('edit-button');
    editButton.onclick = function() {
        editProduct(product);
    };

    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Eliminar';
    deleteButton.classList.add('delete-button');
    deleteButton.onclick = function() {
        deleteProduct(product.breadId, li);
    };

    li.appendChild(editButton);
    li.appendChild(deleteButton);
}

function editProduct(product) {
    document.getElementById('productId').value = product.breadId;
    document.getElementById('productName').value = product.breadName;
    document.getElementById('productPrice').value = product.price;
    document.getElementById('productWeight').value = product.weight;
    document.getElementById('productTime').value = product.productionTime;
    document.getElementById('flourId').value = product.flourId;
    document.getElementById('cancelEdit').style.display = 'block';
}

async function deleteProduct(id, li) {
    await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
    li.remove();
}

// Initial load
async function loadProducts() {
    const response = await fetch(apiUrl);
    const products = await response.json();
    products.forEach(displayProduct);
}

loadProducts();
