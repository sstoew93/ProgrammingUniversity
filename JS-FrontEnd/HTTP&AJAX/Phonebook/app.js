function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/phonebook';

    const loadButton = document.getElementById('btnLoad');
    loadButton.addEventListener('click', loadPhonesEvent);

    const ulPhonebookElement = document.getElementById('phonebook');

    const createButton = document.getElementById('btnCreate');
    createButton.addEventListener('click', createNewPhoneEvent);

    async function loadPhonesEvent(event) {
        ulPhonebookElement.innerHTML = '';

        try {
            const phonesResponse = await fetch(baseURL);
            if (!phonesResponse.ok) {
                throw new Error(`Failed to load phonebook: ${phonesResponse.status} ${phonesResponse.statusText}`);
            }

            const phones = await phonesResponse.json();

            for (let [key, phoneObj] of Object.entries(phones)) {
                const li = document.createElement('li');
                li.textContent = `${phoneObj.person}: ${phoneObj.phone}`;

                const deleteButton = document.createElement('button');
                deleteButton.textContent = 'Delete';
                deleteButton.addEventListener('click', () => deletePhoneEvent(key, li));

                li.appendChild(deleteButton);
                ulPhonebookElement.appendChild(li);
            }
        } catch (error) {
            console.error('Error loading phonebook:', error);
        }
    }

    async function deletePhoneEvent(key, liElement) {
        try {
            const response = await fetch(`${baseURL}/${key}`, {
                method: 'DELETE'
            });

            if (!response.ok) {
                throw new Error(`Failed to delete phonebook entry: ${response.status} ${response.statusText}`);
            }

            liElement.remove();
        } catch (error) {
            console.error('Error deleting phonebook entry:', error);
        }
    }

    async function createNewPhoneEvent(event) {
        const personInput = document.getElementById('person');
        const phoneInput = document.getElementById('phone');

        const newPhone = {
            person: personInput.value,
            phone: phoneInput.value
        };

        try {
            const response = await fetch(baseURL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newPhone)
            });

            if (!response.ok) {
                throw new Error(`Failed to create phonebook entry: ${response.status} ${response.statusText}`);
            }

            personInput.value = '';
            phoneInput.value = '';

            loadPhonesEvent();
        } catch (error) {
            console.error('Error creating phonebook entry:', error);
        }
    }
}

attachEvents();