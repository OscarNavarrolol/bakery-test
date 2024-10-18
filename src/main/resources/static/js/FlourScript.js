// FlourScript.js
const apiUrl = 'http://localhost:8083/flour';

document.getElementById('flourForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const flourId = document.getElementById('flourId').value;
    const flourName = document.getElementById('flourName').value;
    const flourQuantity = document.getElementById('flourQuantity').value;
    const flourUnit = document.getElementById('flourUnit').value;
    
    if (flourId) {
        updateFlour(flourId, flourName, flourQuantity, flourUnit);
    } else {
        addFlour(flourName, flourQuantity, flourUnit);
    }
    document.getElementById('flourForm').reset();
    document.getElementById('cancelEdit').style.display = 'none';
});

document.getElementById('cancelEdit').addEventListener('click', function() {
    document.getElementById('flourForm').reset();
    document.getElementById('flourId').value = '';
    this.style.display = 'none';
});

async function addFlour(name, quantity, unit) {
    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            flourName: name,
            quantity: quantity,
            unit: unit
        })
    });

    const newFlour = await response.json();
    displayFlour(newFlour);
}

async function updateFlour(id, name, quantity, unit) {
    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            flourName: name,
            quantity: quantity,
            unit: unit
        })
    });

    const updatedFlour = await response.json();
    const li = document.querySelector(`li[data-id='${id}']`);
    li.innerHTML = `${updatedFlour.flourName} - ${updatedFlour.quantity} ${updatedFlour.unit}`;
    addButtonsToListItem(li, updatedFlour);
}

function displayFlour(flour) {
    const flourList = document.getElementById('flourList');

    const li = document.createElement('li');
    li.dataset.id = flour.flourId;
    li.innerHTML = `${flour.flourName} - ${flour.quantity} ${flour.unit}`;

    addButtonsToListItem(li, flour);
    flourList.appendChild(li);
}

function addButtonsToListItem(li, flour) {
    const editButton = document.createElement('button');
    editButton.textContent = 'Editar';
    editButton.classList.add('edit-button');
    editButton.onclick = function() {
        editFlour(flour);
    };

    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Eliminar';
    deleteButton.classList.add('delete-button');
    deleteButton.onclick = function() {
        deleteFlour(flour.flourId, li);
    };

    li.appendChild(editButton);
    li.appendChild(deleteButton);
}

function editFlour(flour) {
    document.getElementById('flourId').value = flour.flourId;
    document.getElementById('flourName').value = flour.flourName;
    document.getElementById('flourQuantity').value = flour.quantity;
    document.getElementById('flourUnit').value = flour.unit;
    document.getElementById('cancelEdit').style.display = 'block';
}

async function deleteFlour(id, li) {
    await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
    li.remove();
}

// Initial load
async function loadFlours() {
    const response = await fetch(apiUrl);
    const flours = await response.json();
    flours.forEach(displayFlour);
}

loadFlours();
