async function getFlourNameById(flourId) {
    const response = await fetch(`http://localhost:8083/flour/${flourId}`);
    const flour = await response.json();
    return flour.flourName;
}

async function chargeBreads() {
    const response = await fetch('http://localhost:8083/bread');
    const breads = await response.json();
    const showcaseContainer = document.getElementById('breads');

    for (const bread of breads) {
        const showcase = document.createElement('div');
        showcase.classList.add('showcases');

        const name = document.createElement('h3');
        name.textContent = bread.breadName;

        const price = document.createElement('p');
        price.textContent = `Price: $${bread.price}`;

        const weight = document.createElement('p');
        weight.textContent = `Weight: ${bread.weight} kg`;

        const productionTime = document.createElement('p');
        productionTime.textContent = `Production Time: ${bread.productionTime} mins`;

        const flourName = await getFlourNameById(bread.flourId);
        const flour = document.createElement('p');
        flour.textContent = `Flour: ${flourName}`;

        showcase.appendChild(name);
        showcase.appendChild(price);
        showcase.appendChild(weight);
        showcase.appendChild(productionTime);
        showcase.appendChild(flour);
        showcaseContainer.appendChild(showcase);
    }
}
chargeBreads();

