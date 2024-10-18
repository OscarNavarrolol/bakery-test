async function chargeBreads() {
    const response = await fetch('http://localhost:8083/bread');
    const breads = await response.json();
    const showcaseContainer = document.getElementById('breads');
    
    breads.forEach(pan => {
        const showcase = document.createElement('div');
        showcase.classList.add('showcases');
        
        const name = document.createElement('h3');
        name.textContent = pan.breadName;
        
        const price = document.createElement('p');
        price.textContent = `Price: $${pan.price}`;
        
        const weight = document.createElement('p');
        weight.textContent = `Weight: ${pan.weight} kg`;
        
        const productionTime = document.createElement('p');
        productionTime.textContent = `Production Time: ${pan.productionTime} mins`;
        
        const flourId = document.createElement('p');
        flourId.textContent = `Flour ID: ${pan.flourId}`;
        
        showcase.appendChild(name);
        showcase.appendChild(price);
        showcase.appendChild(weight);
        showcase.appendChild(productionTime);
        showcase.appendChild(flourId);
        showcaseContainer.appendChild(showcase);
    });
}

chargeBreads();
