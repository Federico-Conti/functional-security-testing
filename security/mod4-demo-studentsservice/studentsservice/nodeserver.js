const express = require('express');
const app = express();
const port = 8080;

app.listen(port, () => {
	console.log(`Server listening on port ${port}`);
});

const bodyParser = require('body-parser');
app.use(bodyParser.json());

var students = [];

app.get('/students', (request, response) => {
	response.send(students);
});

app.post('/students', (request, response) => {
	const { name, email } = request.body;
	if(students.filter(e => e.email === email).length > 0) {
		response.status(500).send('Student already present');
	} else {
		students.push({'name':name, 'email':email});
		response.send('Student created successfully');
	}
});

app.put('/students/:email', (request, response) => {
	const { email } = request.params;
	const { name } = request.body;
	if(students.filter(e => e.email === email).length == 0) {
		response.status(500).send('Student not present');
	} else {
		var index = students.findIndex(e => e.email === email);
		students[index].name = name;
		response.send('Student updated successfully');
	}
});

app.delete('/students/:email', (request, response) => {
	const { email } = request.params;
	if(students.filter(e => e.email === email).length == 0) {
		response.status(500).send('Student not present');
	} else {
		var index = students.findIndex(e => e.email === email);
		students.splice(index, 1);
		// students = students.filter(e => e.email !== email); // alternative, less performant
		response.send('Student removed successfully');
	}
});
