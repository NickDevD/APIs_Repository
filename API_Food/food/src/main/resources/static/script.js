const formulario = document.getElementById("adicionar");

formulario.addEventListener('submit', (evento) => {
    evento.preventDefault();

    const nomeAlimento = document.getElementById("name").value;
    const dataValidade = document.getElementById("data").value;

    const novaComida = {
        nome: nomeAlimento,
        dataValidade: dataValidade,
    }

    // Dentro do seu 'addEventListener', depois de criar o 'novoAlimento'

    fetch('http://localhost:8080/api/criar', { // Substitua o 8080 e o /foods se o seu endpoint for diferente
        method: 'POST', // Tipo de requisição que estamos enviando
        headers: {
            'Content-Type': 'application/json' // Informa ao backend que o conteúdo é JSON
        },
        body: JSON.stringify(novaComida) // Transforma o objeto JavaScript em uma string JSON
    })
        .then(resposta => {
            // Aqui nós vamos lidar com a resposta do backend
            if (!resposta.ok) {
                throw new Error('Erro ao cadastrar o alimento!');
            }
            return resposta.json(); // Pega a resposta do backend e a transforma em um objeto JavaScript
        })
        .then(dados => {
            // Aqui você pode fazer algo com os dados de resposta, como exibir uma mensagem de sucesso
            console.log('Alimento cadastrado com sucesso:', dados);
            alert('Alimento cadastrado com sucesso!');
        })
        .catch(erro => {
            // Se algo der errado, a gente lida com o erro aqui
            console.error('Erro:', erro);
            alert('Ops! Ocorreu um erro.');
        });
});




