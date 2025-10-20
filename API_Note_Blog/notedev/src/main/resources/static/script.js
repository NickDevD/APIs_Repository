const CREATE_NOTE = '/api/create';
const GET_NOTES = '/api/get';

const createNote = document.getElementById('create-note');
const refreshButton = document.getElementById('refresh-button');
const noteDisplay = document.getElementById('note-container');

createNote.addEventListener('submit', async (event) => {
    event.preventDefault();

    const title = document.getElementById('title').value.trim();
    const content = document.getElementById('content').value.trim();

    const noteData = {
        title: title,
        content: content
    };

    console.log("Enviando dados",noteData);

    try{
        const reponse = await fetch(CREATE_NOTE, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(noteData)
        });

        if (reponse.status !== 201) {
            const responseError = await reponse.text();
            throw new Error(responseError);
        }

        const newNote = await reponse.json();
        createNote.reset();


    }catch(error){
        console.error(error.message);
    }
});

refreshButton.addEventListener('click', loadNotes);

async function loadNotes() {
    noteDisplay.textContent = 'Carregando notas...'; // Feedback visual

    try {
        const response = await fetch(GET_NOTES);


        if (!response.ok) {
            throw new Error(`Falha ao buscar notas. Status: ${response.status}`);
        }

        const notes = await response.json();

        noteDisplay.innerHTML = '';

        if (notes.length === 0) {
            noteDisplay.textContent = 'Nenhuma nota encontrada.';
        } else {
            let htmlList = '<ul>';
            notes.forEach(note => {
                htmlList += `<li><strong>${note.title}</strong>: ${note.content.substring(0, 100)}...</li>`;
            });
            htmlList += '</ul>';
            noteDisplay.innerHTML = htmlList;
            console.log(`Lista de notas atualizada. Total: ${notes.length}`);
        }

    } catch (error) {
        noteDisplay.textContent = `Erro de conexão com a API. Verifique se o backend está rodando. Detalhe: ${error.message}`;
        console.error(`ERRO na listagem: ${error.message}`);
    }
}